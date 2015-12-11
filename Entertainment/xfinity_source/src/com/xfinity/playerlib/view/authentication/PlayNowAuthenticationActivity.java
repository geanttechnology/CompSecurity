// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.authentication;

import android.os.Bundle;
import com.comcast.cim.android.authentication.AuthenticationActivity;
import com.comcast.cim.android.view.common.OrientationStrategy;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.model.user.XipUserManager;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;

public class PlayNowAuthenticationActivity extends AuthenticationActivity
{

    private final OrientationStrategy sensorIfHasKeyboardOrientationStrategy = PlayerContainer.getInstance().getSensorIfHasKeyboardOrientationStrategy();
    private final PlayNowTrackingService trackingService = PlayerContainer.getInstance().getTrackingService();
    private final XipUserManager userManager = PlayerContainer.getInstance().getUserManager();

    public PlayNowAuthenticationActivity()
    {
    }

    public OrientationStrategy getOrientationStrategy()
    {
        return sensorIfHasKeyboardOrientationStrategy;
    }

    protected XipUserManager getUserManager()
    {
        return userManager;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        trackingService.trackSignInScreenRendered();
    }
}
