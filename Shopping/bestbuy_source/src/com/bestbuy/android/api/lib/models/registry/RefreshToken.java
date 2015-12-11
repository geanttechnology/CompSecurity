// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import gu;
import java.io.Serializable;
import java.util.List;

public class RefreshToken
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x1f52ad40a3484325L;
    private String access_token;
    private List entities;
    private String expires_in;
    private String status;

    public RefreshToken()
    {
    }

    public String getAccess_token()
    {
        return access_token;
    }

    public List getEntities()
    {
        return entities;
    }

    public String getExpires_in()
    {
        return expires_in;
    }

    public String getStatus()
    {
        return status;
    }

    public void setAccess_token(String s)
    {
        access_token = s;
    }

    public void setEntities(List list)
    {
        entities = list;
    }

    public void setExpires_in(String s)
    {
        expires_in = s;
    }

    public void setStatus(String s)
    {
        status = s;
    }
}
