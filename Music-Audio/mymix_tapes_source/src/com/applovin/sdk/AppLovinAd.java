// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.sdk;


// Referenced classes of package com.applovin.sdk:
//            AppLovinAdSize, AppLovinAdType

public interface AppLovinAd
{

    public abstract long getAdIdNumber();

    public abstract AppLovinAdSize getSize();

    public abstract AppLovinAdType getType();

    public abstract boolean isVideoAd();
}
