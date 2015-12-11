// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal;

import com.pointinside.internal.utils.LogUtils;

// Referenced classes of package com.pointinside.internal:
//            StrictModeCompat

private static class <init> extends StrictModeCompat
{
    private static class Holder
    {

        private static final StrictModeCompat.PreGingerbread sInstance = new StrictModeCompat.PreGingerbread(null);



        private Holder()
        {
        }
    }


    public void applyDebugPolicy()
    {
        LogUtils.logW(StrictModeCompat.access$700(), "Cannot apply debug StrictMode policies; StrictMode not supported on this platform");
    }

    private Holder()
    {
    }

    Holder(Holder holder)
    {
        this();
    }
}
