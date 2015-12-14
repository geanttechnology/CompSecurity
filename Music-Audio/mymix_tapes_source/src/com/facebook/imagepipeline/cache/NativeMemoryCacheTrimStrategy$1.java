// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.facebook.common.memory.MemoryTrimType;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            NativeMemoryCacheTrimStrategy

static class 
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
