// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.playbackmanager;

import com.espn.androidplayersdk.datamanager.EPStream;
import com.espn.androidplayersdk.objects.EPAuthError;

public interface EPPlaybackManagerListener
{

    public abstract boolean shouldWaitForUpdatedAdobePassParams();

    public abstract boolean shouldWaitForUpdatedAffiliateToken();

    public abstract void streamAuthorizationFailedWithError(EPAuthError epautherror);

    public abstract void streamAuthorizationSucceeded(EPStream epstream);

    public abstract void streamCookieUpdated(EPStream epstream);

    public abstract void streamDidEnterBlackout(EPAuthError epautherror);

    public abstract void streamDidFailAuthorizationWithMessage(String s);
}
