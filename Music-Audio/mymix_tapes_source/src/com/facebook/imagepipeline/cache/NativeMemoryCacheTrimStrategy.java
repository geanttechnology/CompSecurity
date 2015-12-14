// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;

public class NativeMemoryCacheTrimStrategy
    implements CountingMemoryCache.CacheTrimStrategy
{

    private static final String TAG = "NativeMemoryCacheTrimStrategy";

    public NativeMemoryCacheTrimStrategy()
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

        switch (_cls1..SwitchMap.com.facebook.common.memory.MemoryTrimType[memorytrimtype.ordinal()])
        {
        default:
            FLog.wtf("NativeMemoryCacheTrimStrategy", "unknown trim type: %s", new Object[] {
                memorytrimtype
            });
            // fall through

        case 1: // '\001'
            return 0.0D;

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            return 1.0D;
        }
    }
}
