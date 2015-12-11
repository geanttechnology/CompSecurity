// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.activity:
//            Carousel

class this._cls0
    implements android.view.Listener
{

    final Carousel this$0;

    public void onClick(View view)
    {
        Carousel.access$500(Carousel.this).logClick("", "hamburger_button_click", "lollipop_toolbar", Logger.NULL_NST_FIELD);
        openNavDrawer();
    }

    ogger()
    {
        this$0 = Carousel.this;
        super();
    }
}
