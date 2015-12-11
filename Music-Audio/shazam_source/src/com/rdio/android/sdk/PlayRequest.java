// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk;


public class PlayRequest
{

    public final int initialPositionMSec;
    public final int sourceIndex;
    public final String sourceKey;

    public PlayRequest(String s)
    {
        this(s, 0, 0);
    }

    public PlayRequest(String s, int i)
    {
        this(s, i, 0);
    }

    public PlayRequest(String s, int i, int j)
    {
        sourceKey = s;
        sourceIndex = i;
        initialPositionMSec = j;
    }
}
