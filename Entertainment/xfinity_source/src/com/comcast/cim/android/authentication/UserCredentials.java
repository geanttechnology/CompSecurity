// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.authentication;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UserCredentials
{

    private final String password;
    private final String userName;

    public UserCredentials(String s, String s1)
    {
        userName = s;
        password = s1;
    }

    public String getPassword()
    {
        return password;
    }

    public String getUsername()
    {
        return userName;
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append("userName", userName).append("password", password).toString();
    }
}
