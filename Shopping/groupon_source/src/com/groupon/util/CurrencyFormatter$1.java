// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            CurrencyFormatter

static class cimalStripBehavior
{

    static final int $SwitchMap$com$groupon$util$CurrencyFormatter$DecimalStripBehavior[];

    static 
    {
        $SwitchMap$com$groupon$util$CurrencyFormatter$DecimalStripBehavior = new int[cimalStripBehavior.values().length];
        try
        {
            $SwitchMap$com$groupon$util$CurrencyFormatter$DecimalStripBehavior[cimalStripBehavior.OnlyIfZero.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$groupon$util$CurrencyFormatter$DecimalStripBehavior[cimalStripBehavior.Always.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$groupon$util$CurrencyFormatter$DecimalStripBehavior[cimalStripBehavior.Never.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
