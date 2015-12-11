// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.AdapterView;
import com.target.mothership.model.product.interfaces.ProductPromotion;
import java.util.List;

// Referenced classes of package com.target.ui.view.product:
//            PdpCartwheelAndPromotionView, FixedHeightListView

private class <init>
    implements android.widget.
{

    final PdpCartwheelAndPromotionView this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        while (PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this) == null || i < PdpCartwheelAndPromotionView.b(PdpCartwheelAndPromotionView.this).cartwheelListView.getHeaderViewsCount() || i >= PdpCartwheelAndPromotionView.d(PdpCartwheelAndPromotionView.this).size()) 
        {
            return;
        }
        adapterview = (ProductPromotion)PdpCartwheelAndPromotionView.d(PdpCartwheelAndPromotionView.this).get(i);
        PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this).a(adapterview);
    }

    private otion()
    {
        this$0 = PdpCartwheelAndPromotionView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
