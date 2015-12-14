// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.gif.adapter;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import bns;
import com.wantu.model.GifNetMaterial;
import com.wantu.view.BorderImageView;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;

public class GifMaterialAdapter extends BaseAdapter
{

    private Activity mContext;
    private List mIds;
    private bns mManage;

    public GifMaterialAdapter(Activity activity)
    {
        mContext = activity;
        mManage = new bns(activity);
        mIds = mManage.a();
    }

    public int getCount()
    {
        return mIds.size();
    }

    public GifNetMaterial getGifMaterial(int i)
    {
        GifNetMaterial gifnetmaterial = mManage.a((String)mIds.get(i));
        return gifnetmaterial;
        Object obj;
        obj;
        ((IOException) (obj)).printStackTrace();
_L2:
        return null;
        obj;
        ((JSONException) (obj)).printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
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
        view = (BorderImageView)view;
_L3:
        viewgroup = getGifMaterial(i);
        viewgroup = mManage.a(viewgroup);
        view.setImageBitmap(BitmapFactory.decodeByteArray(viewgroup, 0, viewgroup.length));
        return view;
_L2:
        view = new BorderImageView(mContext);
        try
        {
            view.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            view.setLayoutParams(new android.widget.Gallery.LayoutParams(80, 80));
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
