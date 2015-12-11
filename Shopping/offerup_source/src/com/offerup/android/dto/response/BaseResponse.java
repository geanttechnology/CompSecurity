// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;


public class BaseResponse
{

    boolean authenticationError;
    Status status;

    public BaseResponse()
    {
    }

    public Status getStatus()
    {
        if (status == null)
        {
            status = new Status();
        }
        return status;
    }

    public boolean isAuthenticationError()
    {
        return authenticationError;
    }

    public boolean isSuccess()
    {
        return status != null && "ok".equalsIgnoreCase(status.getStatus());
    }

    public void setAuthenticationError(boolean flag)
    {
        authenticationError = flag;
    }

    public void setStatus(Status status1)
    {
        status = status1;
    }

    private class Status
    {

        String code;
        Error error;
        String message;
        String status;

        public String getCode()
        {
            return code;
        }

        public Error getError()
        {
            return error;
        }

        public String getMessage()
        {
            return message;
        }

        public String getStatus()
        {
            return status;
        }

        public void setCode(String s)
        {
            code = s;
        }

        public void setMessage(String s)
        {
            message = s;
        }

        public void setStatus(String s)
        {
            status = s;
        }

        public Status()
        {
        }
    }

}
