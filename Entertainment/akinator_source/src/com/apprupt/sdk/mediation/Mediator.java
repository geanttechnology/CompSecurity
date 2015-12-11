// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk.mediation;

import android.content.Context;

// Referenced classes of package com.apprupt.sdk.mediation:
//            AdWrapper, ValueExchangeCompletion

public interface Mediator
{

    public abstract void adDidFinishLoading(AdWrapper adwrapper);

    public abstract void adFailedToLoad(AdWrapper adwrapper);

    public abstract void cancel();

    public abstract String getAdSpaceId();

    public abstract Context getContext();

    public abstract AdWrapper.Listener getListener();

    public abstract ValueExchangeCompletion getValueExchangeCompletion();

    public abstract boolean isCanceled();

    public abstract boolean isSpaceHardwareAccelerated();

    public abstract boolean isValueExchangeRequest();
}
