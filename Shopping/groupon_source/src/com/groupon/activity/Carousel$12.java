// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.SharedPreferences;
import android.view.View;
import com.groupon.goods.shoppingcart.view.ShoppingCartInAppMessageView;
import com.groupon.service.InAppMessageService;

// Referenced classes of package com.groupon.activity:
//            Carousel

class this._cls0
    implements android.view.Listener
{

    final Carousel this$0;

    public void onClick(View view)
    {
        if (shoppingCartInAppMessage.getVisibility() == 0)
        {
            Carousel.access$1900(Carousel.this);
        }
        Carousel.access$900(Carousel.this, false);
        int i = Carousel.access$400(Carousel.this).getInt("new_in_app_messages", 0);
        int j = Carousel.access$300(Carousel.this);
        Carousel.access$600(Carousel.this).logInAppBellIconClick(Carousel.access$1400(Carousel.this), i, j - i);
    }

    ervice()
    {
        this$0 = Carousel.this;
        super();
    }
}
