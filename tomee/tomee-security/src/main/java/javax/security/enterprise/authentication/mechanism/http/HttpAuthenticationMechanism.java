/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jakarta.security.enterprise.authentication.mechanism.http;

import jakarta.security.enterprise.AuthenticationException;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static jakarta.security.enterprise.AuthenticationStatus.SUCCESS;

public interface HttpAuthenticationMechanism {

    AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response,
                                         HttpMessageContext httpMessageContext)
            throws AuthenticationException;

    default AuthenticationStatus secureResponse(HttpServletRequest request, HttpServletResponse response,
                                                HttpMessageContext httpMessageContext)
            throws AuthenticationException {
        return SUCCESS;
    }

    default void cleanSubject(HttpServletRequest request, HttpServletResponse response,
                              HttpMessageContext httpMessageContext) {
        httpMessageContext.cleanClientSubject();
    }
}
