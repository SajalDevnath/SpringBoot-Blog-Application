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
        description = "Data transfer object for user login credentials."
)
public class LoginDto {

    @Schema(
            description = "The username or email address of the user attempting to log in.",
            example = "john.doe@example.com"
    )
    private String usernameOrEmail;

    @Schema(
            description = "The password associated with the username or email address.",
            example = "password123"
    )
    private String password;
}
