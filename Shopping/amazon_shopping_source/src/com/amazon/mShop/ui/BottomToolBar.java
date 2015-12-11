// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import java.util.Iterator;
import java.util.List;

public class BottomToolBar extends LinearLayout
    implements com.amazon.mShop.AmazonActivity.OnConfigurationChangedListener
{
    public static class ToolBarItem
    {

        private int mIconId;
        private boolean mIsEnabled;
        private int mItemId;
        private String mItemName;
        private int mItemNameId;

        public int getIconId()
        {
            return mIconId;
        }

        public int getItemId()
        {
            return mItemId;
        }

        public String getItemName()
        {
            return mItemName;
        }

        public int getItemNameId()
        {
            return mItemNameId;
        }

        public boolean isEnabled()
        {
            return mIsEnabled;
        }

        public void setEnabled(boolean flag)
        {
            mIsEnabled = flag;
        }

        public void setItemName(String s)
        {
            mItemName = s;
        }

        public ToolBarItem(int i, int j, int k, boolean flag)
        {
            mItemNameId = j;
            mItemId = i;
            mIsEnabled = flag;
            mIconId = k;
        }

        public ToolBarItem(int i, int j, boolean flag)
        {
            this(i, j, -1, flag);
        }

        public ToolBarItem(int i, String s, boolean flag)
        {
            mItemName = s;
            mItemId = i;
            mIsEnabled = flag;
            mIconId = -1;
        }
    }

    private class ToolBarItemOnClickListener
        implements android.view.View.OnClickListener
    {

        ToolBarItem mItem;
        final BottomToolBar this$0;

        public void onClick(View view)
        {
            if (mToolBarParent != null)
            {
                mToolBarParent.onToolBarItemSelected(mItem);
            }
        }

        public ToolBarItemOnClickListener(ToolBarItem toolbaritem)
        {
            this$0 = BottomToolBar.this;
            super();
            mItem = toolbaritem;
        }
    }

    public static interface ToolBarParent
    {

        public abstract void onToolBarItemSelected(ToolBarItem toolbaritem);
    }


    List mToolBarItemsList;
    private ToolBarParent mToolBarParent;

    public BottomToolBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private void addViews(boolean flag, boolean flag1, TextView textview, int i)
    {
        int j = com.amazon.mShop.android.lib.R.layout.vertical_separator_with_padding;
        View view = inflate(getContext(), j, null);
        if (2 == i)
        {
            if (flag1)
            {
                addView(view);
            }
            addView(textview);
            addView(View.inflate(getContext(), j, null));
        } else
        {
            if (flag || !flag1)
            {
                addView(view);
            }
            addView(textview);
            if (flag)
            {
                addView(View.inflate(getContext(), j, null));
                return;
            }
        }
    }

    private void initForLandScape(List list)
    {
        boolean flag = true;
        boolean flag1;
        if (list.size() != 1)
        {
            flag = false;
        }
        flag1 = true;
        for (list = list.iterator(); list.hasNext();)
        {
            ToolBarItem toolbaritem = (ToolBarItem)list.next();
            TextView textview = new TextView(getContext());
            setTextViewSettings(textview, toolbaritem, flag);
            addViews(flag, flag1, textview, getResources().getConfiguration().orientation);
            flag1 = false;
        }

    }

    private void initForPortrait(List list)
    {
        boolean flag = true;
        boolean flag1;
        if (list.size() != 1)
        {
            flag = false;
        }
        flag1 = true;
        for (list = list.iterator(); list.hasNext();)
        {
            ToolBarItem toolbaritem = (ToolBarItem)list.next();
            TextView textview = new TextView(getContext());
            setTextViewSettings(textview, toolbaritem, flag);
            addViews(flag, flag1, textview, getResources().getConfiguration().orientation);
            flag1 = false;
        }

    }

    private void setTextViewSettings(TextView textview, ToolBarItem toolbaritem, boolean flag)
    {
        int i = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.padding_small);
        textview.setBackgroundResource(com.amazon.mShop.android.lib.R.drawable.action_bar_icon_selector);
        textview.setTextColor(getResources().getColorStateList(com.amazon.mShop.android.lib.R.color.bottom_toolbar_text_selector));
        textview.setFocusable(true);
        android.widget.LinearLayout.LayoutParams layoutparams;
        int j;
        int k;
        int l;
        if (!Util.isEmpty(toolbaritem.getItemName()))
        {
            textview.setText(toolbaritem.getItemName());
        } else
        {
            textview.setText(getResources().getString(toolbaritem.getItemNameId()));
        }
        textview.setId(toolbaritem.getItemId());
        textview.setOnClickListener(new ToolBarItemOnClickListener(toolbaritem));
        j = (int)getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.padding_extra_small);
        k = (int)getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.padding_double);
        if (!flag)
        {
            layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -1);
            layoutparams.weight = 1.0F;
        } else
        {
            layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -1);
            textview.setMinimumWidth((int)Math.round((double)UIUtils.getPortraitWidth(getContext()) * 0.34999999999999998D));
        }
        l = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.separator_height);
        layoutparams.setMargins(-l, 0, -l, 0);
        textview.setGravity(17);
        textview.setLayoutParams(layoutparams);
        if (toolbaritem.getIconId() != -1)
        {
            textview.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(toolbaritem.getIconId()), null);
            textview.setCompoundDrawablePadding(j);
            textview.setPadding(i + k, j, i + j, j);
        } else
        {
            textview.setPadding(i + j, j, i + j, j);
        }
        updateItemView(textview, toolbaritem.isEnabled());
    }

    private void updateItemView(TextView textview, boolean flag)
    {
        textview.setClickable(flag);
        textview.setEnabled(flag);
    }

    public ToolBarParent getToolBarParent()
    {
        return mToolBarParent;
    }

    public void handleConfigurationChanged(Configuration configuration)
    {
        if (getVisibility() == 0)
        {
            removeAllViews();
            init(mToolBarItemsList);
        }
    }

    public void init(List list)
    {
        mToolBarItemsList = list;
        if (getResources().getConfiguration().orientation == 1)
        {
            initForPortrait(list);
            return;
        } else
        {
            initForLandScape(list);
            return;
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (getContext() instanceof AmazonActivity)
        {
            ((AmazonActivity)getContext()).registerConfigChangedListener(this);
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (getContext() instanceof AmazonActivity)
        {
            ((AmazonActivity)getContext()).unregisterConfigChangedListener(this);
        }
    }

    public void setToolBarEnabled(boolean flag)
    {
        for (int i = 0; i < getChildCount(); i++)
        {
            View view = getChildAt(i);
            if (view instanceof TextView)
            {
                updateItemView((TextView)view, flag);
            }
        }

    }

    public void setToolBarItemEnabled(ToolBarItem toolbaritem, boolean flag)
    {
        for (int i = 0; i < getChildCount(); i++)
        {
            View view = getChildAt(i);
            if (view.getId() == toolbaritem.getItemId())
            {
                toolbaritem.setEnabled(flag);
                updateItemView((TextView)view, flag);
            }
        }

    }

    public void setToolBarParent(ToolBarParent toolbarparent)
    {
        mToolBarParent = toolbarparent;
    }

}
