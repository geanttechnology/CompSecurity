// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.ndk;


class ProcMapEntry
{

    public final long address;
    public final String path;
    public final long size;

    public ProcMapEntry(long l, long l1, String s)
    {
        address = l;
        size = l1;
        path = s;
    }
}
