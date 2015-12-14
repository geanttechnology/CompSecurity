// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.view.View;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryNavBarViewFlipper

class this._cls0
    implements android.view.viaryNavBarViewFlipper._cls2
{

    final AviaryNavBarViewFlipper this$0;

    public void onClick(View view)
    {
        if (mListener != null && isClickable() && !opened())
        {
            mListener.onDoneClick();
        }
    }

    ToolbarClickListener()
    {
        this$0 = AviaryNavBarViewFlipper.this;
        super();
    }
}
