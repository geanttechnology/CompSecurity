// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import b.a.a;

public class Blocked
{

    a blockDate;
    long blockedUser;
    long reportId;
    String reportToken;

    public Blocked()
    {
    }

    public a getBlockDate()
    {
        return blockDate;
    }

    public long getBlockedUser()
    {
        return blockedUser;
    }

    public long getReportId()
    {
        return reportId;
    }

    public String getReportToken()
    {
        return reportToken;
    }
}
