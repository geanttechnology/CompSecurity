// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.model;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.ui.RecyclingImageView;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.imagelib.filter.TImageFilterInfo;
import ev;
import java.util.HashMap;
import qv;

public class FilterListArrayAdapter extends ArrayAdapter
{

    private int mCurSelectedIndex;
    View mCurSelectedItem;
    private LayoutInflater mInflater;
    HashMap posViewMap;

    public FilterListArrayAdapter(Context context, TImageFilterInfo atimagefilterinfo[])
    {
        super(context, 0x7f03003c, atimagefilterinfo);
        mCurSelectedIndex = -1;
        posViewMap = new HashMap();
        mInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = view;
        TImageFilterInfo timagefilterinfo = (TImageFilterInfo)getItem(i);
        obj = view;
        android.graphics.Bitmap bitmap = ev.a(PIPCameraApplication.a.getResources().getDrawable(timagefilterinfo.iconUrl));
        if (view != null) goto _L2; else goto _L1
_L1:
        obj = view;
        view = mInflater.inflate(0x7f03003c, viewgroup, false);
        obj = view;
        RecyclingImageView recyclingimageview = (RecyclingImageView)view.findViewById(0x7f0c0127);
        obj = view;
        TextView textview = (TextView)view.findViewById(0x7f0c0128);
        obj = view;
        recyclingimageview.setTag(timagefilterinfo);
        obj = view;
        viewgroup = new qv();
        obj = view;
        viewgroup.a = recyclingimageview;
        obj = view;
        viewgroup.b = bitmap;
        obj = view;
        viewgroup.c = textview;
        obj = view;
        view.setTag(viewgroup);
_L10:
        ((qv) (viewgroup)).c.setText(timagefilterinfo.filterName);
        ((qv) (viewgroup)).a.setImageBitmap(bitmap);
        if (i != mCurSelectedIndex) goto _L4; else goto _L3
_L3:
        ((qv) (viewgroup)).a.setSelected(true);
        mCurSelectedItem = ((qv) (viewgroup)).a;
_L6:
        posViewMap.put(Integer.valueOf(i), view);
        return view;
_L2:
        obj = view;
        viewgroup = (qv)view.getTag();
        obj = view;
        ((qv) (viewgroup)).a.setImageBitmap(null);
        obj = view;
        ((qv) (viewgroup)).a.setTag(timagefilterinfo);
        obj = view;
        ((qv) (viewgroup)).c.setText(timagefilterinfo.name);
        obj = view;
        try
        {
            viewgroup.b = bitmap;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            viewgroup = ((ViewGroup) (obj));
            obj = view;
        }
          goto _L5
_L4:
        ((qv) (viewgroup)).a.setSelected(false);
          goto _L6
        obj;
        viewgroup = view;
_L8:
        ((Exception) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
        return viewgroup;
_L5:
        if (true) goto _L8; else goto _L7
_L7:
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void setSelectPosition(int i)
    {
        View view = (View)posViewMap.get(Integer.valueOf(i));
        qv qv1 = (qv)view.getTag();
        if (view != mCurSelectedItem)
        {
            if (mCurSelectedItem != null)
            {
                mCurSelectedItem.setSelected(false);
            }
            view.setSelected(true);
        }
        mCurSelectedItem = view;
        mCurSelectedIndex = i;
    }
}
