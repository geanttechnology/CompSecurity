// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.sdk;

import com.supersonic.mediationsdk.logger.SupersonicError;

public interface OfferwallListener
{

    public abstract void onGetOfferwallCreditsFail(SupersonicError supersonicerror);

    public abstract boolean onOfferwallAdCredited(int i, int j, boolean flag);

    public abstract void onOfferwallClosed();

    public abstract void onOfferwallInitFail(SupersonicError supersonicerror);

    public abstract void onOfferwallInitSuccess();

    public abstract void onOfferwallOpened();

    public abstract void onOfferwallShowFail(SupersonicError supersonicerror);
}
