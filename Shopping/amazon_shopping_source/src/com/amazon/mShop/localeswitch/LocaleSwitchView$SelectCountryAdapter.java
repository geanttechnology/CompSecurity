// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.localeswitch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.LocaleUtils;

// Referenced classes of package com.amazon.mShop.localeswitch:
//            LocaleSwitchView, LocaleSwitcher

private class mLayoutInflater extends BaseAdapter
    implements android.widget.CountryAdapter
{

    private final LayoutInflater mLayoutInflater;
    final LocaleSwitchView this$0;

    public int getCount()
    {
        return mLayoutInflater().length;
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = (RelativeLayout)view;
        if (view == null)
        {
            viewgroup = (RelativeLayout)mLayoutInflater.inflate(com.amazon.mShop.android.lib..mLayoutInflater, null);
        }
        ((ImageView)viewgroup.findViewById(com.amazon.mShop.android.lib..mLayoutInflater)).setImageResource(mLayoutInflater()[i].wableId());
        ((ImageView)viewgroup.findViewById(com.amazon.mShop.android.lib.awableId)).setImageResource(com.amazon.mShop.android.lib.awableId);
        view = (ImageView)viewgroup.findViewById(com.amazon.mShop.android.lib.awableId);
        int j;
        if (LocaleUtils.isCurrentLocale(wableId()[i].tring()))
        {
            j = 0;
        } else
        {
            j = 4;
        }
        view.setVisibility(j);
        view = ConfigUtils.getStringForSpecificLocale(getContext(), com.amazon.mShop.android.lib.String, tring()[i].tring());
        ((TextView)(TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.String)).setText(view);
        view = new StringBuilder(ConfigUtils.getStringForSpecificLocale(getContext(), com.amazon.mShop.android.lib.String, tring()[i].tring()));
        ((TextView)(TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.String)).setText((new StringBuilder()).append(" - ").append(view).toString());
        return viewgroup;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        int k = i - getHeaderViewsCount();
        if (k < 0 || k >= getCount())
        {
            return;
        }
        i = 0;
        while (i < adapterview.getChildCount()) 
        {
            View view1 = adapterview.getChildAt(i);
            if (view1 instanceof RelativeLayout)
            {
                ImageView imageview = (ImageView)((RelativeLayout)view1).findViewById(com.amazon.mShop.android.lib..getCount);
                int j;
                if (view1 == view)
                {
                    j = 0;
                } else
                {
                    j = 4;
                }
                imageview.setVisibility(j);
            }
            i++;
        }
        LocaleSwitchView.access$000(LocaleSwitchView.this).changeLocale(com.amazon.mShop.localeswitch.this._mth0()[k].tring());
    }

    public I()
    {
        this$0 = LocaleSwitchView.this;
        super();
        mLayoutInflater = LayoutInflater.from(getContext());
    }
}
