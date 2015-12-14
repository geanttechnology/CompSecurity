// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core.internal.models;


public class ThreadData
{

    public static final int IMPORTANCE_CRASHED_THREAD = 4;
    public final FrameData frames[];
    public final int importance;
    public final String name;

    public ThreadData(int i, FrameData aframedata[])
    {
        this(null, i, aframedata);
    }

    public ThreadData(String s, int i, FrameData aframedata[])
    {
        name = s;
        importance = i;
        frames = aframedata;
    }
}
