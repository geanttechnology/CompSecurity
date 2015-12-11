// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;


// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SymbanDataManager

static class num
{

    static final int $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$StatusEnum[];

    static 
    {
        $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$StatusEnum = new int[com.ebay.nautilus.domain.data.tatusEnum.values().length];
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$StatusEnum[com.ebay.nautilus.domain.data.tatusEnum.READ.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$StatusEnum[com.ebay.nautilus.domain.data.tatusEnum.DELETED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$StatusEnum[com.ebay.nautilus.domain.data.tatusEnum.NEW.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
