// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk;

import com.aviary.android.feather.sdk.panels.AbstractPanel;
import com.aviary.android.feather.sdk.widget.AviaryBottomBarViewFlipper;

// Referenced classes of package com.aviary.android.feather.sdk:
//            AviaryMainController

class val.isConfirmed
    implements com.aviary.android.feather.sdk.widget.per.OnViewChangingStatusListener
{

    final AviaryMainController this$0;
    final boolean val$isConfirmed;

    public void onCloseEnd()
    {
        AviaryMainController aviarymaincontroller = AviaryMainController.this;
        byte byte0;
        if (val$isConfirmed)
        {
            byte0 = 4;
        } else
        {
            byte0 = 5;
        }
        AviaryMainController.access$100(aviarymaincontroller, byte0);
        AviaryMainController.access$200(AviaryMainController.this).getBottomBar().removeOnViewChangingStatusListener(this);
    }

    public void onCloseStart()
    {
        AviaryMainController.access$000(AviaryMainController.this).onClosing();
    }

    public void onOpenEnd()
    {
    }

    public void onOpenStart()
    {
    }

    iewFlipper()
    {
        this$0 = final_aviarymaincontroller;
        val$isConfirmed = Z.this;
        super();
    }
}
