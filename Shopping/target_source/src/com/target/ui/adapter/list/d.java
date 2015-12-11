// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.list;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ac;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.a.a.e;
import com.h.c.u;
import com.h.c.y;
import com.target.mothership.model.promotion.interfaces.PromotionDetail;
import java.util.ArrayList;
import java.util.List;

public class d extends ac
{
    public static interface a
    {

        public abstract void a(PromotionDetail promotiondetail, int i);
    }

    protected static class b
    {

        View addToListButton;
        ImageView imageView;
        TextView promotionTitle;
        TextView promotionValue;

        public b(View view)
        {
            imageView = (ImageView)view.findViewById(0x7f100461);
            promotionTitle = (TextView)view.findViewById(0x7f100460);
            promotionValue = (TextView)view.findViewById(0x7f100462);
            addToListButton = view.findViewById(0x7f100464);
        }
    }


    private static final float PAGE_WIDTH = 1F;
    private int mApproximateImageHeight;
    private final LayoutInflater mLayoutInflater;
    private final a mListener;
    private int mPosition;
    private List mPromotionList;

    public d(Context context, a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("promotionsListener cannot be null");
        } else
        {
            mLayoutInflater = (LayoutInflater)context.getSystemService("layout_inflater");
            mPromotionList = new ArrayList();
            mApproximateImageHeight = Math.round(context.getResources().getDisplayMetrics().heightPixels / 2);
            mListener = a1;
            return;
        }
    }

    static a a(d d1)
    {
        return d1.mListener;
    }

    private void a(final PromotionDetail item, b b1)
    {
        b1.addToListButton.setOnClickListener(new android.view.View.OnClickListener() {

            final d this$0;
            final PromotionDetail val$item;

            public void onClick(View view)
            {
                if (d.a(d.this) == null)
                {
                    return;
                } else
                {
                    d.a(d.this).a(item, d.b(d.this) + 1);
                    return;
                }
            }

            
            {
                this$0 = d.this;
                item = promotiondetail;
                super();
            }
        });
    }

    static int b(d d1)
    {
        return d1.mPosition;
    }

    public int a(Object obj)
    {
        obj = (PromotionDetail)((View)obj).getTag();
        int i = mPromotionList.indexOf(obj);
        if (i >= 0)
        {
            return i;
        } else
        {
            return -2;
        }
    }

    public Object a(ViewGroup viewgroup, int i)
    {
        View view = mLayoutInflater.inflate(0x7f030167, viewgroup, false);
        PromotionDetail promotiondetail = (PromotionDetail)mPromotionList.get(i);
        b b1 = new b(view);
        b1.promotionTitle.setText(promotiondetail.a());
        if (promotiondetail.b().b())
        {
            String s = (String)promotiondetail.a(mApproximateImageHeight).c();
            u.a(viewgroup.getContext()).a(s).a(0x7f02016f).a(b1.imageView);
        }
        b1.promotionValue.setText(promotiondetail.c());
        view.setTag(promotiondetail);
        viewgroup.addView(view);
        a(promotiondetail, b1);
        return view;
    }

    public void a(int i)
    {
        mPosition = i;
    }

    public void a(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public void a(List list)
    {
        mPromotionList.clear();
        mPromotionList.addAll(list);
        c();
    }

    public boolean a(View view, Object obj)
    {
        return view == obj;
    }

    public int b()
    {
        return mPromotionList.size();
    }

    public float d(int i)
    {
        return 1.0F;
    }
}
