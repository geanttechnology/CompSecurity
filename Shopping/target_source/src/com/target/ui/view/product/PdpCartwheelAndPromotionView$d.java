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
import com.target.mothership.model.product.interfaces.ProductCartWheel;
import com.target.mothership.util.o;
import com.target.ui.adapter.b.e;
import com.target.ui.util.al;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.view.product:
//            PdpCartwheelAndPromotionView

private class setNotifyOnChange extends e
{
    private class a
    {

        final TextView cartwheel;
        final ImageView cartwheelIcon;
        final PdpCartwheelAndPromotionView.d this$1;

        public a(View view)
        {
            this$1 = PdpCartwheelAndPromotionView.d.this;
            super();
            cartwheel = (TextView)view.findViewById(0x7f100498);
            cartwheelIcon = (ImageView)view.findViewById(0x7f100497);
        }
    }


    private boolean displayCartWheelIcon;
    private int displayCartWheelTextColorResourceId;
    final PdpCartwheelAndPromotionView this$0;

    private List b(List list)
    {
        ArrayList arraylist = new ArrayList();
        PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this, list);
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            if (o.g(((ProductCartWheel)list.next()).b()))
            {
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append(getContext().getString(0x7f090425));
                stringbuilder.append(" ");
                stringbuilder.append(getContext().getString(0x7f090424));
                arraylist.add(stringbuilder.toString());
            }
        } while (true);
        return arraylist;
    }

    public void a(int i)
    {
        displayCartWheelTextColorResourceId = i;
    }

    public void a(List list)
    {
        clear();
        a(((java.util.Collection) (b(list))));
        notifyDataSetChanged();
    }

    public void a(boolean flag)
    {
        displayCartWheelIcon = flag;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        String s = (String)getItem(i);
        if (view == null)
        {
            view = mInflater.inflate(0x7f030185, null, false);
            viewgroup = new a(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (a)view.getTag();
        }
        ((a) (viewgroup)).cartwheel.setText(s);
        if (displayCartWheelTextColorResourceId != -1)
        {
            ((a) (viewgroup)).cartwheel.setTextColor(getResources().getColor(displayCartWheelTextColorResourceId));
        }
        al.a(((a) (viewgroup)).cartwheelIcon, displayCartWheelIcon);
        return view;
    }

    public a.cartwheelIcon(Context context)
    {
        this$0 = PdpCartwheelAndPromotionView.this;
        super(context, new ArrayList());
        displayCartWheelTextColorResourceId = -1;
        setNotifyOnChange(false);
        PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this, Collections.emptyList());
    }
}
