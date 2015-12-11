// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.AdapterView;
import com.target.mothership.model.product.interfaces.ProductCartWheel;
import com.target.mothership.util.o;
import java.util.List;

// Referenced classes of package com.target.ui.view.product:
//            PdpCartwheelAndPromotionView, FixedHeightListView

private class <init>
    implements android.widget.
{

    final PdpCartwheelAndPromotionView this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this) != null && i >= PdpCartwheelAndPromotionView.b(PdpCartwheelAndPromotionView.this).cartwheelListView.getHeaderViewsCount() && i < PdpCartwheelAndPromotionView.c(PdpCartwheelAndPromotionView.this).size())
        {
            adapterview = (ProductCartWheel)PdpCartwheelAndPromotionView.c(PdpCartwheelAndPromotionView.this).get(i);
            if (adapterview != null && o.g(adapterview.b()))
            {
                PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this).a(adapterview);
                return;
            }
        }
    }

    private Wheel()
    {
        this$0 = PdpCartwheelAndPromotionView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
