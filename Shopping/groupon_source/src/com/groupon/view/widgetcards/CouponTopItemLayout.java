// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.groupon.v3.view.list_view.CouponTopItemType;
import java.util.ArrayList;

// Referenced classes of package com.groupon.view.widgetcards:
//            CouponTopItemCard, CouponTopItem

public class CouponTopItemLayout extends LinearLayout
{

    protected CouponTopItemCard chiclets[];
    protected CouponTopItemType container;

    public CouponTopItemLayout(Context context)
    {
        super(context);
        chiclets = new CouponTopItemCard[3];
    }

    public CouponTopItemLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        chiclets = new CouponTopItemCard[3];
    }

    public CouponTopItemLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        chiclets = new CouponTopItemCard[3];
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        chiclets[0] = (CouponTopItemCard)findViewById(0x7f1001eb);
        chiclets[1] = (CouponTopItemCard)findViewById(0x7f1001ec);
        chiclets[2] = (CouponTopItemCard)findViewById(0x7f1001ed);
        CouponTopItemCard acoupontopitemcard[] = chiclets;
        int j = acoupontopitemcard.length;
        for (int i = 0; i < j; i++)
        {
            acoupontopitemcard[i].setVisibility(8);
        }

    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        CouponTopItemCard acoupontopitemcard[] = chiclets;
        int j = acoupontopitemcard.length;
        for (int i = 0; i < j; i++)
        {
            acoupontopitemcard[i].setOnClickListener(onclicklistener);
        }

    }

    public void setTopItemContainer(CouponTopItemType coupontopitemtype)
    {
        container = coupontopitemtype;
        CouponTopItemCard acoupontopitemcard[] = chiclets;
        int k = acoupontopitemcard.length;
        for (int i = 0; i < k; i++)
        {
            acoupontopitemcard[i].setVisibility(4);
        }

        ArrayList arraylist = coupontopitemtype.getItems();
        if (arraylist != null)
        {
            for (int j = 0; j < Math.min(arraylist.size(), chiclets.length); j++)
            {
                CouponTopItem coupontopitem = (CouponTopItem)arraylist.get(j);
                coupontopitem.setHorizontalPosition(j);
                coupontopitem.setVerticalPosition(coupontopitemtype.getPosition());
                coupontopitem.setItemType((com.groupon.v3.view.list_view.CouponTopItemType.ItemType)coupontopitemtype.getType());
                chiclets[j].bind(coupontopitem);
                chiclets[j].setVisibility(0);
            }

        }
    }
}
