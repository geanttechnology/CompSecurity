// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


public class ReportResponse
{

    int discussion;
    int item;
    String reason;
    String token;
    int user;

    public ReportResponse()
    {
    }

    public int getDiscussion()
    {
        return discussion;
    }

    public int getItem()
    {
        return item;
    }

    public String getReason()
    {
        return reason;
    }

    public String getToken()
    {
        return token;
    }

    public int getUser()
    {
        return user;
    }
}
