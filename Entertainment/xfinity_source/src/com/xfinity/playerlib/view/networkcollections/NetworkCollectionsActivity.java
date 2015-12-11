// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.container.PlayerContainer;

// Referenced classes of package com.xfinity.playerlib.view.networkcollections:
//            NetworkActivity

public class NetworkCollectionsActivity extends NetworkActivity
{

    private final AccessibilityUtil accessibilityUtil = CALContainer.getInstance().getAccessibilityUtil();
    private final AndroidDevice androidDevice = PlayerContainer.getInstance().getAndroidDevice();

    public NetworkCollectionsActivity()
    {
    }

    protected int getLayoutId()
    {
        if (androidDevice.isTabletDevice())
        {
            if (accessibilityUtil.isAccessibilityEnabled())
            {
                return com.xfinity.playerlib.R.layout.flyin_network_collections_phone;
            } else
            {
                return com.xfinity.playerlib.R.layout.layout_flyin_network_collections;
            }
        } else
        {
            return com.xfinity.playerlib.R.layout.layout_flyin_network_collections;
        }
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        checkTalkBackModeOnResume();
    }
}
