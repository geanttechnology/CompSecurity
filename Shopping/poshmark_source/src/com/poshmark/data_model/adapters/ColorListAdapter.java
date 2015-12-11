// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.poshmark.data_model.models.PMColor;
import com.poshmark.utils.meta_data.ColorPickerInfo;
import java.util.ArrayList;
import java.util.List;

public class ColorListAdapter extends ArrayAdapter
{

    Context context;
    List currentSelection;
    ColorPickerInfo data;
    ArrayList filteredData;
    int layoutResourceId;

    public ColorListAdapter(Context context1, int i, ColorPickerInfo colorpickerinfo)
    {
        super(context1, i, colorpickerinfo.allItems);
        data = colorpickerinfo;
        context = context1;
        layoutResourceId = i;
        currentSelection = colorpickerinfo.selectedColors;
    }

    private ColorListAdapter(Context context1, int i, ArrayList arraylist)
    {
        super(context1, i, arraylist);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        PMColor pmcolor = (PMColor)getItem(i);
        Object obj = view;
        Object obj1 = ((Activity)context).getLayoutInflater();
        view = ((View) (obj));
        if (obj == null)
        {
            view = ((LayoutInflater) (obj1)).inflate(layoutResourceId, viewgroup, false);
        }
        viewgroup = (RelativeLayout)view.findViewById(0x7f0c00d1);
        viewgroup = (TextView)view.findViewById(0x7f0c00d5);
        obj = (ImageView)view.findViewById(0x7f0c00d3);
        obj1 = (ImageView)view.findViewById(0x7f0c00d4);
        GradientDrawable gradientdrawable = (GradientDrawable)context.getResources().getDrawable(0x7f020038);
        gradientdrawable.setColor(Color.parseColor(pmcolor.rgb));
        ((ImageView) (obj1)).setImageDrawable(gradientdrawable);
        viewgroup.setText(pmcolor.getName());
        if (data.isColorInSelectColorList(pmcolor))
        {
            ((ImageView) (obj)).setImageDrawable(context.getResources().getDrawable(0x7f02007e));
        } else
        {
            ((ImageView) (obj)).setImageDrawable(null);
        }
        view.setTag(pmcolor);
        return view;
    }
}
