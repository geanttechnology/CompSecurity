// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import com.amazon.mShop.sso.IdentityType;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHMShopAuthenticationPlugin

static class 
{

    static final int $SwitchMap$com$amazon$mShop$sso$IdentityType[];

    static 
    {
        $SwitchMap$com$amazon$mShop$sso$IdentityType = new int[IdentityType.values().length];
        try
        {
            $SwitchMap$com$amazon$mShop$sso$IdentityType[IdentityType.CENTRAL_SSO_TYPE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$mShop$sso$IdentityType[IdentityType.DISTRIBUTED_SSO_TYPE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$mShop$sso$IdentityType[IdentityType.NON_SSO_TYPE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
