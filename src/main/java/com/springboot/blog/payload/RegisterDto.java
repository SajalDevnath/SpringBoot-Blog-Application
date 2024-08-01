package com.springboot.blog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Data transfer object for user registration. Contains necessary fields for creating a new user account."
)
public class RegisterDto {

    @Schema(
            description = "Full name of the user.",
            example = "John Doe"
    )
    private String name;

    @Schema(
            description = "Username chosen by the user. This should be unique across the application.",
            example = "johndoe"
    )
    private String username;

    @Schema(
            description = "Email address of the user. It must be a valid email format.",
            example = "johndoe@example.com"
    )
    private String email;

    @Schema(
            description = "Password for the user account. It should be kept secure and follow the application's password policies.",
            example = "P@ssw0rd!123"
    )
    private String password;
}
