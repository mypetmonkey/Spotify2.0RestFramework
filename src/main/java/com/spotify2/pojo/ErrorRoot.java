package com.spotify2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class ErrorRoot {

@JsonProperty("error")
private InnerError error;

@JsonProperty("error")
public InnerError getError() {
return error;
}

@JsonProperty("error")
public void setError(InnerError error) {
this.error = error;
}

}
