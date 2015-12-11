// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal;

import android.os.StrictMode;
import com.pointinside.internal.utils.LogUtils;

public abstract class StrictModeCompat
{
    private static class Gingerbread extends GingerbreadAndBeyond
    {

        public void applyDebugPolicy()
        {
            StrictMode.setVmPolicy(applyCommonDebugPolicy(new android.os.StrictMode.VmPolicy.Builder()).build());
        }

        private Gingerbread()
        {
        }

    }

    private static class Gingerbread.Holder
    {

        private static final Gingerbread sInstance = new Gingerbread();



        private Gingerbread.Holder()
        {
        }
    }

    private static abstract class GingerbreadAndBeyond extends StrictModeCompat
    {

        protected android.os.StrictMode.VmPolicy.Builder applyCommonDebugPolicy(android.os.StrictMode.VmPolicy.Builder builder)
        {
            return builder.detectLeakedSqlLiteObjects().penaltyLog();
        }

        private GingerbreadAndBeyond()
        {
        }

    }

    private static class HoneycombAndBeyond extends GingerbreadAndBeyond
    {

        public void applyDebugPolicy()
        {
            StrictMode.setVmPolicy(applyCommonDebugPolicy(new android.os.StrictMode.VmPolicy.Builder(StrictMode.getVmPolicy())).detectLeakedClosableObjects().build());
        }

        private HoneycombAndBeyond()
        {
        }

    }

    private static class HoneycombAndBeyond.Holder
    {

        private static final HoneycombAndBeyond sInstance = new HoneycombAndBeyond();



        private HoneycombAndBeyond.Holder()
        {
        }
    }

    private static class PreGingerbread extends StrictModeCompat
    {

        public void applyDebugPolicy()
        {
            LogUtils.logW(StrictModeCompat.TAG, "Cannot apply debug StrictMode policies; StrictMode not supported on this platform");
        }

        private PreGingerbread()
        {
        }

    }

    private static class PreGingerbread.Holder
    {

        private static final PreGingerbread sInstance = new PreGingerbread();



        private PreGingerbread.Holder()
        {
        }
    }


    private static final String TAG = com/pointinside/internal/StrictModeCompat.getSimpleName();

    public StrictModeCompat()
    {
    }

    public static StrictModeCompat getInstance()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return HoneycombAndBeyond.Holder.sInstance;
        }
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            return Gingerbread.Holder.sInstance;
        } else
        {
            return PreGingerbread.Holder.sInstance;
        }
    }

    public abstract void applyDebugPolicy();


}
