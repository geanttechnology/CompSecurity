// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.os.SystemClock;

class TimestampWrapper
{

    long mCreatedTimestamp;
    final Object mInstance;

    TimestampWrapper(Object obj)
    {
        mInstance = obj;
        mCreatedTimestamp = SystemClock.uptimeMillis();
    }
}
