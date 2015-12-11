// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.utils.meta_data.PinterestBoard;
import com.poshmark.utils.meta_data.PinterestBoardPickerInfo;

public class PinterestBoardListAdapter extends ArrayAdapter
{

    Context context;
    PinterestBoardPickerInfo data;
    int defaultColor;
    boolean defaultColorSet;
    int layoutResourceId;

    public PinterestBoardListAdapter(Context context1, int i, PinterestBoardPickerInfo pinterestboardpickerinfo)
    {
        super(context1, i, pinterestboardpickerinfo.getAllboards());
        defaultColorSet = false;
        data = pinterestboardpickerinfo;
        context = context1;
        layoutResourceId = i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        PinterestBoard pinterestboard = (PinterestBoard)getItem(i);
        Object obj = view;
        Object obj1 = ((Activity)context).getLayoutInflater();
        view = ((View) (obj));
        if (obj == null)
        {
            view = ((LayoutInflater) (obj1)).inflate(layoutResourceId, viewgroup, false);
        }
        obj = (TextView)view.findViewById(0x7f0c025d);
        obj1 = (ImageView)view.findViewById(0x7f0c0097);
        viewgroup = (ImageView)view.findViewById(0x7f0c025c);
        if (!defaultColorSet)
        {
            defaultColorSet = true;
            defaultColor = ((TextView) (obj)).getTextColors().getDefaultColor();
        }
        ((TextView) (obj)).setCompoundDrawables(null, null, null, null);
        ((TextView) (obj)).setText(pinterestboard.getDisplay());
        if (data.currentSelection.getId().equals(pinterestboard.getId()))
        {
            ((TextView) (obj)).setTypeface(null, 1);
            ((TextView) (obj)).setTextColor(context.getResources().getColor(0x7f09003c));
            ((ImageView) (obj1)).setVisibility(0);
        } else
        {
            ((ImageView) (obj1)).setVisibility(8);
            ((TextView) (obj)).setTypeface(null, 0);
            ((TextView) (obj)).setTextColor(defaultColor);
        }
        obj = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020138).build();
        ImageLoader.getInstance().displayImage(pinterestboard.getImage_url(), viewgroup, ((com.nostra13.universalimageloader.core.DisplayImageOptions) (obj)));
        view.setTag(pinterestboard);
        return view;
    }
}
