// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;


public abstract class SignUpUserInfo
{

    private final String userEmail;
    private final String userNamePublic;

    public SignUpUserInfo(String s, String s1)
    {
        userEmail = s;
        userNamePublic = s1;
    }

    public String getUserEmail()
    {
        return userEmail;
    }

    public String getUserNamePublic()
    {
        return userNamePublic;
    }
}
