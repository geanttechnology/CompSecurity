// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;

public class BitmapMemoryCacheTrimStrategy
    implements CountingMemoryCache.CacheTrimStrategy
{

    private static final String TAG = "BitmapMemoryCacheTrimStrategy";

    public BitmapMemoryCacheTrimStrategy()
    {
    }

    public double getTrimRatio(MemoryTrimType memorytrimtype)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$facebook$common$memory$MemoryTrimType[];

            static 
            {
                $SwitchMap$com$facebook$common$memory$MemoryTrimType = new int[MemoryTrimType.values().length];
                try
                {
                    $SwitchMap$com$facebook$common$memory$MemoryTrimType[MemoryTrimType.OnCloseToDalvikHeapLimit.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$facebook$common$memory$MemoryTrimType[MemoryTrimType.OnAppBackgrounded.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$facebook$common$memory$MemoryTrimType[MemoryTrimType.OnSystemLowMemoryWhileAppInForeground.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$facebook$common$memory$MemoryTrimType[MemoryTrimType.OnSystemLowMemoryWhileAppInBackground.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.facebook.common.memory.MemoryTrimType[memorytrimtype.ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 57
    //                   2 72
    //                   3 72
    //                   4 72;
           goto _L1 _L2 _L3 _L3 _L3
_L1:
        FLog.wtf("BitmapMemoryCacheTrimStrategy", "unknown trim type: %s", new Object[] {
            memorytrimtype
        });
_L5:
        return 0.0D;
_L2:
        if (android.os.Build.VERSION.SDK_INT < 21) goto _L5; else goto _L4
_L4:
        return MemoryTrimType.OnCloseToDalvikHeapLimit.getSuggestedTrimRatio();
_L3:
        return 1.0D;
    }
}
