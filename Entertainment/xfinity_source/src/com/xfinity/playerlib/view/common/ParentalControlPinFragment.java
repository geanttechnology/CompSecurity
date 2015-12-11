// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.comcast.cim.android.view.common.PinKeypadFragment;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;

public class ParentalControlPinFragment extends PinKeypadFragment
{

    private PlayNowTrackingService trackingService;

    public ParentalControlPinFragment()
    {
        trackingService = PlayerContainer.getInstance().getTrackingService();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        trackingService.trackParentalControlsPinPadRendered();
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }
}
