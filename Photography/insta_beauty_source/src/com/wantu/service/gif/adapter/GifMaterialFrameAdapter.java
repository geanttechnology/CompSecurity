// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.gif.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import bnv;

public class GifMaterialFrameAdapter extends BaseAdapter
{

    private Context mContext;
    private bnv mDecoder;

    public GifMaterialFrameAdapter(Context context, bnv bnv1)
    {
        mDecoder = bnv1;
        mContext = context;
    }

    public int getCount()
    {
        return mDecoder.b();
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
        if (view == null) goto _L2; else goto _L1
_L1:
        view = (ImageView)view;
_L3:
        view.setImageBitmap(mDecoder.c(i));
        return view;
_L2:
        view = new ImageView(mContext);
        try
        {
            view.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            view.setLayoutParams(new android.widget.Gallery.LayoutParams(100, 100));
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            continue; /* Loop/switch isn't completed */
        }
          goto _L3
        viewgroup;
        view = null;
_L5:
        viewgroup.printStackTrace();
        return view;
        viewgroup;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
