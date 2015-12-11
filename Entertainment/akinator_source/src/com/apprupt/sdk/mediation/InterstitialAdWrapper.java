// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk.mediation;


// Referenced classes of package com.apprupt.sdk.mediation:
//            AdWrapper

public interface InterstitialAdWrapper
    extends AdWrapper
{
    public static interface Listener
        extends AdWrapper.Listener
    {
    }


    public abstract Listener getListener();

    public abstract void presentInterstitial();

    public abstract void setListener(Listener listener);
}
