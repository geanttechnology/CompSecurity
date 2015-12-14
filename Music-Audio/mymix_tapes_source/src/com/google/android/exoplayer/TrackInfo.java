// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;


public final class TrackInfo
{

    public final long durationUs;
    public final String mimeType;

    public TrackInfo(String s, long l)
    {
        mimeType = s;
        durationUs = l;
    }
}
