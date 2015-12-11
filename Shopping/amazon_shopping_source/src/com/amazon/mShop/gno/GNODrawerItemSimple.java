// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemBase, GNODrawerHelper, GNODrawer

public class GNODrawerItemSimple extends GNODrawerItemBase
{
    public static class Builder
    {

        private GNODrawerItemSimple item;
        private GNODrawerItem.Type type;

        public GNODrawerItemSimple build()
        {
            if (type != null)
            {
                item.mType = type;
            } else
            {
                item.mType = GNODrawerItem.Type.SIMPLE_ITEM;
            }
            return item;
        }

        protected Builder self()
        {
            return this;
        }

        public Builder withListener(GNOItemOnClickListener gnoitemonclicklistener)
        {
            item.mListener = gnoitemonclicklistener;
            return self();
        }

        public Builder withRefMarker(String s)
        {
            item.setRefMarker(s);
            return self();
        }

        public Builder withSubView(int i)
        {
            item.mSubViewId = i;
            return self();
        }

        public Builder withText(int i)
        {
            item.mTextId = i;
            return self();
        }

        public Builder withText(String s)
        {
            item.mText = s;
            return self();
        }

        public Builder withType(GNODrawerItem.Type type1)
        {
            type = type1;
            return self();
        }

        public Builder(Context context, String s)
        {
            item = new GNODrawerItemSimple(context, s);
        }

        protected Builder(GNODrawerItemSimple gnodraweritemsimple)
        {
            item = gnodraweritemsimple;
        }
    }

    public static interface GNOItemOnClickListener
    {

        public abstract void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer);
    }

    private class ViewHolder
    {

        int subViewId;
        FrameLayout subViewWrapper;
        TextView text;
        final GNODrawerItemSimple this$0;

        private ViewHolder()
        {
            this$0 = GNODrawerItemSimple.this;
            super();
        }

    }


    private static final String TAG = com/amazon/mShop/gno/GNODrawerItemSimple.getSimpleName();
    protected Context mContext;
    private String mId;
    private GNOItemOnClickListener mListener;
    private int mSubViewId;
    private String mText;
    private int mTextId;
    private GNODrawerItem.Type mType;

    protected GNODrawerItemSimple(Context context, String s)
    {
        mContext = context;
        mId = s;
    }

    public static Builder builder(Context context, String s)
    {
        return new Builder(context, s);
    }

    public String getId()
    {
        return mId;
    }

    public GNODrawerItem.Type getType()
    {
        return mType;
    }

    public View getView(View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            viewgroup = LayoutInflater.from(mContext).inflate(getType().getLayoutId(), viewgroup, false);
            view = new ViewHolder();
            view.text = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.drawer_item_title);
            view.subViewWrapper = (FrameLayout)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.drawer_item_sub_view_container);
            viewgroup.setTag(view);
        } else
        {
            viewgroup = view;
            view = (ViewHolder)view.getTag();
        }
        if (mTextId != 0)
        {
            ((ViewHolder) (view)).text.setText(mTextId);
        } else
        {
            ((ViewHolder) (view)).text.setText(mText);
        }
        if (((ViewHolder) (view)).subViewId != mSubViewId)
        {
            view.subViewId = mSubViewId;
            ((ViewHolder) (view)).subViewWrapper.removeAllViews();
            if (mSubViewId != 0)
            {
                LayoutInflater.from(mContext).inflate(mSubViewId, ((ViewHolder) (view)).subViewWrapper);
            }
        }
        return viewgroup;
    }

    public void onClick(final AmazonActivity callingActivity, final GNODrawer drawer)
    {
        super.onClick(callingActivity, drawer);
        if (mListener != null)
        {
            boolean flag = "mshop:exit".equals(mId);
            boolean flag1 = mId.equals("android:debug/weblab_overrides");
            if (!flag && !flag1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            GNODrawerHelper.closeDrawerAndExecute(callingActivity, flag, new Runnable() {

                final GNODrawerItemSimple this$0;
                final AmazonActivity val$callingActivity;
                final GNODrawer val$drawer;

                public void run()
                {
                    mListener.onClick(callingActivity, drawer);
                }

            
            {
                this$0 = GNODrawerItemSimple.this;
                callingActivity = amazonactivity;
                drawer = gnodrawer;
                super();
            }
            });
        }
    }




/*
    static GNOItemOnClickListener access$102(GNODrawerItemSimple gnodraweritemsimple, GNOItemOnClickListener gnoitemonclicklistener)
    {
        gnodraweritemsimple.mListener = gnoitemonclicklistener;
        return gnoitemonclicklistener;
    }

*/


/*
    static GNODrawerItem.Type access$202(GNODrawerItemSimple gnodraweritemsimple, GNODrawerItem.Type type)
    {
        gnodraweritemsimple.mType = type;
        return type;
    }

*/


/*
    static String access$302(GNODrawerItemSimple gnodraweritemsimple, String s)
    {
        gnodraweritemsimple.mText = s;
        return s;
    }

*/


/*
    static int access$402(GNODrawerItemSimple gnodraweritemsimple, int i)
    {
        gnodraweritemsimple.mTextId = i;
        return i;
    }

*/


/*
    static int access$502(GNODrawerItemSimple gnodraweritemsimple, int i)
    {
        gnodraweritemsimple.mSubViewId = i;
        return i;
    }

*/
}
