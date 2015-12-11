// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.container;

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
        int i = 4;
        if (!getAndroidDevice().isTabletDevice())
        {
            i = getAndroidDevice().getPortraitOrientation();
        }
        return i;
    }

    ice()
    {
        this$0 = PlayerContainer.this;
        super();
    }
}
