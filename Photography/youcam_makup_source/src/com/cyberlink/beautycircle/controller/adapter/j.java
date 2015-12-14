// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.h;
import com.cyberlink.beautycircle.i;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class j extends ArrayAdapter
{

    Context a;

    public j(Context context)
    {
        super(context, k.bc_view_item_share_out, a());
        a = context;
    }

    public static List a()
    {
        ArrayList arraylist = new ArrayList();
        if (Locale.getDefault().equals(Locale.CHINA))
        {
            if (!Globals.s().equals("YCN"))
            {
                arraylist.add(new a(i.bc_ico_sns_wechat, m.bc_register_wechat));
            }
            arraylist.add(new a(i.bc_ico_sns_fb, m.bc_register_fb));
            arraylist.add(new a(i.bc_ico_sns_twitter, m.bc_register_twitter));
            return arraylist;
        }
        arraylist.add(new a(i.bc_ico_sns_twitter, m.bc_register_twitter));
        if (!Globals.s().equals("YCN"))
        {
            arraylist.add(new a(i.bc_ico_sns_weibo, m.bc_register_weibo));
        }
        arraylist.add(new a(i.bc_ico_sns_wechat, m.bc_register_wechat));
        return arraylist;
    }

    public View getView(int l, View view, ViewGroup viewgroup)
    {
        view = super.getView(l, view, viewgroup);
        viewgroup = (TextView)view;
        Object obj = (a)getItem(l);
        String s = a.getResources().getString(((a) (obj)).b);
        obj = a.getResources().getDrawable(((a) (obj)).a);
        ((Drawable) (obj)).setBounds(0, 0, Globals.b(h.t40dp), Globals.b(h.t40dp));
        viewgroup.setCompoundDrawables(((Drawable) (obj)), null, null, null);
        viewgroup.setText(s);
        return view;
    }
}
