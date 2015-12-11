// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.target.mothership.model.product.interfaces.ProductPromotion;
import com.target.ui.adapter.b.e;
import com.target.ui.util.al;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.view.product:
//            PdpCartwheelAndPromotionView

private class setNotifyOnChange extends e
{
    private class a
    {

        final TextView promotion;
        final ImageView promotionTag;
        final PdpCartwheelAndPromotionView.e this$1;

        public a(View view)
        {
            this$1 = PdpCartwheelAndPromotionView.e.this;
            super();
            promotion = (TextView)view.findViewById(0x7f1004d4);
            promotionTag = (ImageView)view.findViewById(0x7f1004d3);
        }
    }


    private boolean displayPromoIcon;
    private int displayTextColorResourceId;
    final PdpCartwheelAndPromotionView this$0;

    private List b(List list)
    {
        ArrayList arraylist = new ArrayList();
        PdpCartwheelAndPromotionView.b(PdpCartwheelAndPromotionView.this, list);
        for (list = list.iterator(); list.hasNext(); arraylist.add(((ProductPromotion)list.next()).b())) { }
        return arraylist;
    }

    public void a(int i)
    {
        displayTextColorResourceId = i;
    }

    public void a(List list)
    {
        clear();
        a(((java.util.Collection) (b(list))));
        notifyDataSetChanged();
    }

    public void a(boolean flag)
    {
        displayPromoIcon = flag;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        String s = (String)getItem(i);
        if (view == null)
        {
            view = mInflater.inflate(0x7f030192, null, false);
            viewgroup = new a(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (a)view.getTag();
        }
        ((a) (viewgroup)).promotion.setText(s);
        if (displayTextColorResourceId != -1)
        {
            ((a) (viewgroup)).promotion.setTextColor(getResources().getColor(displayTextColorResourceId));
        }
        al.a(((a) (viewgroup)).promotionTag, displayPromoIcon);
        return view;
    }

    public a.promotionTag(Context context)
    {
        this$0 = PdpCartwheelAndPromotionView.this;
        super(context, new ArrayList());
        displayTextColorResourceId = -1;
        setNotifyOnChange(false);
    }
}
