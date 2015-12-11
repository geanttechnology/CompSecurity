// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import java.util.ArrayList;

public class 
{

    public contest contest;
    public ArrayList leaderboard;
    public Long rank;
    public Integer score;

    public boolean isEnded()
    {
        return contest.contest.longValue() * 1000L < System.currentTimeMillis();
    }

    public ()
    {
    }
}
