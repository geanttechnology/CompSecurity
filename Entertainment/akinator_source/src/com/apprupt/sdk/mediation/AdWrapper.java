// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk.mediation;


// Referenced classes of package com.apprupt.sdk.mediation:
//            Adapter, Mediator

public interface AdWrapper
{
    public static interface Listener
    {

        public abstract void onCloseAd();

        public abstract void onFirstTap();

        public abstract void onKillSpace();
    }


    public abstract void changeCloseButtonVisibility(boolean flag);

    public abstract Adapter getAdapter();

    public abstract String getErrorMessage();

    public abstract String getFallbackToIdentifier();

    public abstract boolean isError();

    public abstract boolean isValueExchangeAd();

    public abstract void setBackgroundColor(int i);

    public abstract void setMediator(Mediator mediator);

    public abstract boolean shouldRunFallback();
}
