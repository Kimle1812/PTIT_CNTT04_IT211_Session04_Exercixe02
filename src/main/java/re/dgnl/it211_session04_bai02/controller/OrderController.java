package re.dgnl.it211_session04_bai02.controller;

import re.dgnl.it211_session04_bai02.model.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

/*
 * PHẦN 1 – LÝ THUYẾT: POST HAY PUT?
 *
 * 1. Kết luận: Đồng nghiệp B ĐÚNG khi chọn POST /api/v1/orders.
 *
 * 2. Giải thích nguyên nhân:
 *    - Quy tắc sinh ID: Nghiệp vụ yêu cầu "Hệ thống tự sinh orderId". PUT yêu cầu client
 *      phải biết trước ID và chỉ định rõ trên URL (Ví dụ: PUT /orders/ORD123). Do client
 *      không biết trước ID khi đặt hàng, việc dùng POST gửi lên một tập hợp (Collection)
 *      /orders là hoàn toàn chính xác.
 *    - Tính Idempotent (Đồng nhất): POST không có tính idempotent, mỗi lần gọi sẽ tạo ra
 *      một đơn hàng mới. PUT có tính idempotent, gọi nhiều lần với cùng dữ liệu thì kết quả
 *      trên server vẫn giữ nguyên. Đặt hàng là hành động tạo mới tài nguyên liên tục,
 *      do đó dùng POST là chuẩn tắc.
 */

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    // Yêu cầu Phần 2: Triển khai API nhận POST request để tạo đơn hàng mới
    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order incomingOrder) {

        String generatedId = "ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        incomingOrder.setOrderId(generatedId);

        // Trả về đối tượng Order hoàn chỉnh (gồm cả orderId) dưới dạng JSON
        return incomingOrder;
    }
}