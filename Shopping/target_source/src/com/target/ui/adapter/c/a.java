// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.c;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.target.mothership.model.coupons.interfaces.CouponOffer;
import com.target.ui.adapter.b.e;
import com.target.ui.util.g;
import com.target.ui.util.q;
import java.util.Date;
import java.util.List;

public class com.target.ui.adapter.c.a extends e
{
    private class a
    {

        public TextView couponDesc;
        public TextView couponExpires;
        public View root;
        final com.target.ui.adapter.c.a this$0;

        public a(View view)
        {
            this$0 = com.target.ui.adapter.c.a.this;
            super();
            root = view;
            couponDesc = (TextView)view.findViewById(0x7f100394);
            couponExpires = (TextView)view.findViewById(0x7f100395);
        }
    }


    private static final String EXPIRY_FORWARD_SLASH = "/";
    public static final String TAG = com/target/ui/adapter/c/a.getSimpleName();

    public com.target.ui.adapter.c.a(Context context, List list)
    {
        super(context, list);
    }

    private void a(TextView textview, String s)
    {
        if (s == null || s.isEmpty())
        {
            return;
        } else
        {
            textview.setText(s);
            return;
        }
    }

    private void a(TextView textview, Date date)
    {
        if (date == null || g.a(date) == null || g.b(date) == null)
        {
            q.a(TAG, "Invalid expiry date");
            return;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder(textview.getResources().getString(0x7f090295));
            stringbuilder.append(" ");
            stringbuilder.append(g.a(date));
            stringbuilder.append("/").append(g.b(date));
            textview.setText(stringbuilder.toString());
            return;
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        CouponOffer couponoffer = (CouponOffer)getItem(i);
        if (view == null)
        {
            viewgroup = mInflater.inflate(0x7f03014d, null, false);
            view = new a(viewgroup);
            viewgroup.setTag(view);
        } else
        {
            a a1 = (a)view.getTag();
            viewgroup = view;
            view = a1;
        }
        if (couponoffer == null || view == null)
        {
            q.a(TAG, "Coupon offer adapter error!");
            return viewgroup;
        } else
        {
            a(((a) (view)).couponDesc, couponoffer.d());
            a(((a) (view)).couponExpires, (Date)couponoffer.e().d());
            return viewgroup;
        }
    }

}
