// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;


// Referenced classes of package com.ebay.nautilus.kernel.content:
//            ResultStatus

static class verity
{

    static final int $SwitchMap$com$ebay$nautilus$kernel$content$ResultStatus$Severity[];

    static 
    {
        $SwitchMap$com$ebay$nautilus$kernel$content$ResultStatus$Severity = new int[verity.values().length];
        try
        {
            $SwitchMap$com$ebay$nautilus$kernel$content$ResultStatus$Severity[verity.Error.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$kernel$content$ResultStatus$Severity[verity.PartialFailure.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
