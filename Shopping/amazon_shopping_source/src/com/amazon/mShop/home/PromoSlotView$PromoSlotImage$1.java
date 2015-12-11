// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.view.View;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.PromoSlot;

// Referenced classes of package com.amazon.mShop.home:
//            PromoSlotView

class this._cls1
    implements android.view.tImage._cls1
{

    final is._cls0 this$1;

    public void onClick(View view)
    {
        if (view.getTag() instanceof PromoSlot)
        {
            PromoSlotView.access$300(_fld0, PromoSlotView.access$200(_fld0));
        }
        if (!Util.isEmpty(PromoSlotView.access$400(_fld0)))
        {
            RefMarkerObserver.logRefMarker(PromoSlotView.access$400(_fld0));
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
