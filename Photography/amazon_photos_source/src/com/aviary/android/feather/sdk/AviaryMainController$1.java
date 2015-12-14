// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk;

import com.aviary.android.feather.sdk.panels.AbstractPanel;
import com.aviary.android.feather.sdk.widget.AviaryBottomBarViewFlipper;

// Referenced classes of package com.aviary.android.feather.sdk:
//            AviaryMainController

class this._cls0
    implements com.aviary.android.feather.sdk.widget.per.OnViewChangingStatusListener
{

    final AviaryMainController this$0;

    public void onCloseEnd()
    {
    }

    public void onCloseStart()
    {
    }

    public void onOpenEnd()
    {
        AviaryMainController.access$100(AviaryMainController.this, 2);
        AviaryMainController.access$200(AviaryMainController.this).getBottomBar().removeOnViewChangingStatusListener(this);
    }

    public void onOpenStart()
    {
        AviaryMainController.access$000(AviaryMainController.this).onOpening();
    }

    iewFlipper()
    {
        this$0 = AviaryMainController.this;
        super();
    }
}
