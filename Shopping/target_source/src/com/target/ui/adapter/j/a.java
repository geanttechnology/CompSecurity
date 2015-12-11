// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.j;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.weekly_ad.WeeklyAdListItemView;
import java.util.List;

public abstract class com.target.ui.adapter.j.a extends BaseAdapter
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a ADD_TO_LIST;
        public static final a DEFAULT;
        public static final a PICK_UP;
        public static final a SHIP;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/adapter/j/a$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            DEFAULT = new a("DEFAULT", 0);
            ADD_TO_LIST = new a("ADD_TO_LIST", 1);
            PICK_UP = new a("PICK_UP", 2);
            SHIP = new a("SHIP", 3);
            $VALUES = (new a[] {
                DEFAULT, ADD_TO_LIST, PICK_UP, SHIP
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface b
    {

        public abstract void a(Object obj, BitmapImageView bitmapimageview, a a1);
    }


    private List mData;
    private int mImageHeight;
    private boolean mIsGuestInsideStore;
    private b mListener;

    public com.target.ui.adapter.j.a(Context context, List list)
    {
        mIsGuestInsideStore = false;
        mData = list;
        mImageHeight = context.getResources().getDimensionPixelSize(0x7f0a026e);
    }

    static b a(com.target.ui.adapter.j.a a1)
    {
        return a1.mListener;
    }

    public int a()
    {
        return mImageHeight;
    }

    public void a(b b1)
    {
        mListener = b1;
    }

    protected abstract void a(WeeklyAdListItemView weeklyadlistitemview, Object obj, int i);

    public void a(boolean flag)
    {
        mIsGuestInsideStore = flag;
    }

    public boolean b()
    {
        return mIsGuestInsideStore;
    }

    public int getCount()
    {
        return mData.size();
    }

    public Object getItem(int i)
    {
        return mData.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(final int position, View view, final ViewGroup image)
    {
        if (view == null)
        {
            view = (WeeklyAdListItemView)LayoutInflater.from(image.getContext()).inflate(0x7f03020b, image, false);
        } else
        {
            view = (WeeklyAdListItemView)view;
        }
        image = (BitmapImageView)view.findViewById(0x7f1004fd);
        a(view, getItem(position), position);
        view.setFulfillmentClickListener(new com.target.ui.view.product.PlpFulfillmentView.a() {

            final com.target.ui.adapter.j.a this$0;
            final BitmapImageView val$image;
            final Object val$item;

            public void a()
            {
                if (com.target.ui.adapter.j.a.a(com.target.ui.adapter.j.a.this) != null)
                {
                    com.target.ui.adapter.j.a.a(com.target.ui.adapter.j.a.this).a(item, image, a.PICK_UP);
                }
            }

            public void b()
            {
                if (com.target.ui.adapter.j.a.a(com.target.ui.adapter.j.a.this) != null)
                {
                    com.target.ui.adapter.j.a.a(com.target.ui.adapter.j.a.this).a(item, image, a.SHIP);
                }
            }

            public void c()
            {
                if (com.target.ui.adapter.j.a.a(com.target.ui.adapter.j.a.this) != null)
                {
                    com.target.ui.adapter.j.a.a(com.target.ui.adapter.j.a.this).a(item, image, a.ADD_TO_LIST);
                }
            }

            public void d()
            {
            }

            
            {
                this$0 = com.target.ui.adapter.j.a.this;
                item = obj;
                image = bitmapimageview;
                super();
            }
        });
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final com.target.ui.adapter.j.a this$0;
            final BitmapImageView val$image;
            final int val$position;

            public void onClick(View view1)
            {
                if (com.target.ui.adapter.j.a.a(com.target.ui.adapter.j.a.this) != null)
                {
                    com.target.ui.adapter.j.a.a(com.target.ui.adapter.j.a.this).a(getItem(position), image, a.DEFAULT);
                }
            }

            
            {
                this$0 = com.target.ui.adapter.j.a.this;
                position = i;
                image = bitmapimageview;
                super();
            }
        });
        return view;
    }
}
