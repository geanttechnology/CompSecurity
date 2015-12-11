// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search;

import com.amazon.dee.result.bif.ConfidenceBin;

// Referenced classes of package com.amazon.shopapp.voice.search:
//            VoiceResult

static class 
{

    static final int $SwitchMap$com$amazon$dee$result$bif$ConfidenceBin[];

    static 
    {
        $SwitchMap$com$amazon$dee$result$bif$ConfidenceBin = new int[ConfidenceBin.values().length];
        try
        {
            $SwitchMap$com$amazon$dee$result$bif$ConfidenceBin[ConfidenceBin.HIGH.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$dee$result$bif$ConfidenceBin[ConfidenceBin.MEDIUM.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$dee$result$bif$ConfidenceBin[ConfidenceBin.LOW.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
