// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;


// Referenced classes of package com.amazon.device.ads.identity:
//            AdsIdentityContainer, AdsIdentity, AmazonRegistration, IAmazonRegistration

static final class ation extends AdsIdentityContainer
{

    public IAmazonRegistration getAmazonRegistration()
    {
        return AmazonRegistration.getInstance();
    }

    ation()
    {
    }
}
