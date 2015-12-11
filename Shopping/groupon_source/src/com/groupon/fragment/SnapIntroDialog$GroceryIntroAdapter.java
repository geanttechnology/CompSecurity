// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.groupon.fragment:
//            SnapIntroDialog

private class <init> extends PagerAdapter
{

    private LayoutInflater layoutInflater;
    final SnapIntroDialog this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        ((ViewPager)viewgroup).removeView((LinearLayout)obj);
    }

    public int getCount()
    {
        return 3;
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        View view;
        TextView textview;
        ImageView imageview;
        Resources resources;
        layoutInflater = (LayoutInflater)viewgroup.getContext().getSystemService("layout_inflater");
        view = layoutInflater.inflate(0x7f030205, viewgroup, false);
        textview = (TextView)view.findViewById(0x7f10052f);
        imageview = (ImageView)view.findViewById(0x7f10052e);
        resources = getActivity().getResources();
        SnapIntroDialog.access$200(SnapIntroDialog.this).setOnClickListener(new t(SnapIntroDialog.this, null));
        SnapIntroDialog.access$200(SnapIntroDialog.this).setText(0x7f080218);
        if (i != 0) goto _L2; else goto _L1
_L1:
        textview.setText(0x7f0803ac);
        imageview.setImageDrawable(resources.getDrawable(0x7f0201d5));
_L4:
        viewgroup.addView(view, 0);
        return view;
_L2:
        if (i == 1)
        {
            textview.setText(0x7f0803ad);
            imageview.setImageDrawable(resources.getDrawable(0x7f0201d6));
        } else
        if (i == 2)
        {
            textview.setText(0x7f0803ae);
            imageview.setImageDrawable(resources.getDrawable(0x7f0201d7));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }

    private t()
    {
        this$0 = SnapIntroDialog.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
