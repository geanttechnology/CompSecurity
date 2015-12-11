// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core.internal.models;


public class ThreadData
{
    public static final class FrameData
    {

        public final long address;
        public final String file;
        public final int importance;
        public final long offset;
        public final String symbol;
    }


    public final FrameData frames[];
    public final int importance;
    public final String name;
}
