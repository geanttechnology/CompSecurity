// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdTargetingOptions, AdListener

public interface Ad
{

    public abstract int getTimeout();

    public abstract boolean isLoading();

    public abstract boolean loadAd();

    public abstract boolean loadAd(AdTargetingOptions adtargetingoptions);

    public abstract void setListener(AdListener adlistener);

    public abstract void setTimeout(int i);
}
