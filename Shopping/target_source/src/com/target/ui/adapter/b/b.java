// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.h.c.e;
import com.h.c.u;
import com.h.c.y;
import com.target.ui.util.a;
import com.target.ui.view.ScalableImageView;
import java.util.List;

public class com.target.ui.adapter.b.b extends android.support.v7.widget.RecyclerView.a
{
    public static interface a
    {

        public abstract void a(int i);
    }

    public static class b extends android.support.v7.widget.RecyclerView.t
    {

        public b(View view)
        {
            super(view);
        }
    }


    private static final String CONTENT_DESCRIPTION_FORMAT = "%s %s of %s";
    private String mBaseContentDescription;
    private android.graphics.Bitmap.Config mBitmapConfig;
    private List mData;
    private Drawable mHeroImagePlaceholderDrawable;
    private boolean mIsCollapsed;
    private Integer mItemPadding;
    private a mListener;
    private Integer mViewWidth;

    public com.target.ui.adapter.b.b(List list)
    {
        mIsCollapsed = false;
        mBitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
        mData = list;
    }

    static Drawable a(com.target.ui.adapter.b.b b1, Drawable drawable)
    {
        b1.mHeroImagePlaceholderDrawable = drawable;
        return drawable;
    }

    static a a(com.target.ui.adapter.b.b b1)
    {
        return b1.mListener;
    }

    private String g(int i)
    {
        return String.format("%s %s of %s", new Object[] {
            mBaseContentDescription, Integer.valueOf(i + 1), Integer.valueOf(mData.size())
        });
    }

    public int a()
    {
        return mData.size();
    }

    public android.support.v7.widget.RecyclerView.t a(ViewGroup viewgroup, int i)
    {
        if (mItemPadding == null)
        {
            mItemPadding = Integer.valueOf(viewgroup.getContext().getResources().getDimensionPixelSize(0x7f0a018a));
        }
        viewgroup = new ScalableImageView(viewgroup.getContext());
        viewgroup.setLayoutParams(new android.support.v7.widget.RecyclerView.i(-1, -1));
        viewgroup.setPadding(mItemPadding.intValue(), 0, mItemPadding.intValue(), 0);
        return new b(viewgroup);
    }

    public void a(android.graphics.Bitmap.Config config)
    {
        mBitmapConfig = config;
    }

    public void a(Drawable drawable)
    {
        mHeroImagePlaceholderDrawable = drawable;
    }

    public void a(android.support.v7.widget.RecyclerView.t t, final int position)
    {
        final ScalableImageView imageView = (ScalableImageView)t.itemView;
        if (mViewWidth != null && mViewWidth.intValue() > 0)
        {
            imageView.getLayoutParams().width = mViewWidth.intValue();
        }
        final String imageUrl;
        boolean flag;
        if (!mIsCollapsed && !com.target.ui.util.a.a(imageView.getContext()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        imageView.setScalable(flag);
        imageView.c();
        imageView.setOnClickListener(new android.view.View.OnClickListener() {

            final com.target.ui.adapter.b.b this$0;
            final ScalableImageView val$imageView;
            final int val$position;

            public void onClick(View view)
            {
                if (imageView.b())
                {
                    imageView.a(true);
                }
                if (com.target.ui.adapter.b.b.a(com.target.ui.adapter.b.b.this) != null)
                {
                    com.target.ui.adapter.b.b.a(com.target.ui.adapter.b.b.this).a(position);
                }
            }

            
            {
                this$0 = com.target.ui.adapter.b.b.this;
                imageView = scalableimageview;
                position = i;
                super();
            }
        });
        imageView.setContentDescription(g(position));
        imageUrl = (String)mData.get(position);
        if (imageUrl == null)
        {
            imageView.setTag(null);
            u.a(imageView.getContext()).a(imageView);
            u.a(imageView.getContext()).a((String)null).a(imageView);
        } else
        if (!imageUrl.equals(imageView.getTag()))
        {
            if (position == 0)
            {
                t = mHeroImagePlaceholderDrawable;
            } else
            {
                t = null;
            }
            imageView.setTag(null);
            u.a(imageView.getContext()).a((String)mData.get(position)).a(t).a(mBitmapConfig).a(imageView, new e() {

                final com.target.ui.adapter.b.b this$0;
                final String val$imageUrl;
                final ScalableImageView val$imageView;

                public void a()
                {
                    imageView.setTag(imageUrl);
                    com.target.ui.adapter.b.b.a(com.target.ui.adapter.b.b.this, null);
                }

                public void b()
                {
                    com.target.ui.adapter.b.b.a(com.target.ui.adapter.b.b.this, null);
                }

            
            {
                this$0 = com.target.ui.adapter.b.b.this;
                imageView = scalableimageview;
                imageUrl = s;
                super();
            }
            });
            return;
        }
    }

    public void a(a a1)
    {
        mListener = a1;
    }

    public void a(String s)
    {
        mBaseContentDescription = s;
    }

    public void b(boolean flag)
    {
        mIsCollapsed = flag;
    }

    public void f(int i)
    {
        mViewWidth = Integer.valueOf(i);
    }
}
