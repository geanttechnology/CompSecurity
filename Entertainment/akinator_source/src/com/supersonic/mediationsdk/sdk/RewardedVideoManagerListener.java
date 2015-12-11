// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.sdk;

import com.supersonic.mediationsdk.AbstractAdapter;
import com.supersonic.mediationsdk.logger.SupersonicError;

public interface RewardedVideoManagerListener
{

    public abstract void onRewardedVideoAdClosed(AbstractAdapter abstractadapter);

    public abstract void onRewardedVideoAdOpened(AbstractAdapter abstractadapter);

    public abstract void onRewardedVideoAdRewarded(int i, AbstractAdapter abstractadapter);

    public abstract void onRewardedVideoInitFail(SupersonicError supersonicerror, AbstractAdapter abstractadapter);

    public abstract void onRewardedVideoInitSuccess(AbstractAdapter abstractadapter);

    public abstract void onVideoAvailabilityChanged(boolean flag, AbstractAdapter abstractadapter);

    public abstract void onVideoEnd(AbstractAdapter abstractadapter);

    public abstract void onVideoStart(AbstractAdapter abstractadapter);
}
