package com.book.bookonline.exception;

import com.book.bookonline.dto.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class GenericException extends RuntimeException{

    private HttpStatus httpStatus;

    private ErrorCode errorCode;

}
