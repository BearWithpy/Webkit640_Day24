package org.webkit.myweb.saram.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaramDTO {
    public int seq;
    public String id;

    public String name;
//    public String nickname;
    public int age;

    @Override
    public String toString() {
        return "SaramDTO [ id=" + id + ", name=" + name + ", seq=" + seq + "]"+", age=" + age + "]";
    }
}
