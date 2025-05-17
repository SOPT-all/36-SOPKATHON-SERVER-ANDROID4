package org.sopt.domain.course.domain;

import jakarta.persistence.*;
import lombok.*;
import org.sopt.domain.user.domain.User;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String courseTitle;
    private String description;
    private LocalDate recordDate;
}
