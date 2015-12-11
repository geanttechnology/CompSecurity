// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby;

import gu;
import java.io.Serializable;

public class LoginRequest
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String authorization_code;
    private String grant_type;
    private String password;
    private String session_id;
    private String username;

    public LoginRequest()
    {
    }

    public String getAuthorization_code()
    {
        return authorization_code;
    }

    public String getGrant_type()
    {
        return grant_type;
    }

    public String getPassword()
    {
        return password;
    }

    public String getSession_id()
    {
        return session_id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setAuthorization_code(String s)
    {
        authorization_code = s;
    }

    public void setGrant_type(String s)
    {
        grant_type = s;
    }

    public void setPassword(String s)
    {
        password = s;
    }

    public void setSession_id(String s)
    {
        session_id = s;
    }

    public void setUsername(String s)
    {
        username = s;
    }
}
