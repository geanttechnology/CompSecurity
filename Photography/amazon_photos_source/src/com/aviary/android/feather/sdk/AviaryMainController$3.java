// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk;

import android.view.ViewGroup;

// Referenced classes of package com.aviary.android.feather.sdk:
//            AviaryMainController

class this._cls0
    implements Runnable
{

    final AviaryMainController this$0;

    public void run()
    {
        AviaryMainController.access$200(AviaryMainController.this).getDrawingImageContainer().removeAllViews();
        AviaryMainController.access$200(AviaryMainController.this).deactivatePopupContainer();
    }

    atherContext()
    {
        this$0 = AviaryMainController.this;
        super();
    }
}
