// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.container;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.comcast.cim.android.view.common.OrientationStrategy;
import com.comcast.cim.model.system.PlayerAndroidDevice;

// Referenced classes of package com.comcast.cim.container:
//            PlayerContainer

class this._cls0
    implements OrientationStrategy
{

    final PlayerContainer this$0;

    public int getAppropriateOrientation()
    {
        boolean flag = true;
        byte byte0 = 4;
        int i;
        if (getResources().getConfiguration().keyboard == 1)
        {
            flag = false;
        }
        i = byte0;
        if (getAndroidDevice().getDevicePhysicalSize() < 3)
        {
            i = byte0;
            if (!flag)
            {
                i = getAndroidDevice().getPortraitOrientation();
            }
        }
        return i;
    }

    ice()
    {
        this$0 = PlayerContainer.this;
        super();
    }
}
