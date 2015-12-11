// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas;


// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas:
//            EcasErrorHandler

static class erBase.Action
{

    static final int $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[];

    static 
    {
        $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action = new int[com.ebay.nautilus.domain.content.dm.agerBase.Action.values().length];
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[com.ebay.nautilus.domain.content.dm.agerBase.Action.ADD_TO_CART.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[com.ebay.nautilus.domain.content.dm.agerBase.Action.GET_CART.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$Action[com.ebay.nautilus.domain.content.dm.agerBase.Action.GET_AND_VALIDATE_CART.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
