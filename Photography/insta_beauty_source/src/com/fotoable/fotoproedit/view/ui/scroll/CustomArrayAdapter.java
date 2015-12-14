// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

import amv;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.imagelib.filter.TImageFilterInfo;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TResInfo;
import com.wantu.view.compose2.StatusImageView;
import java.util.HashMap;

public class CustomArrayAdapter extends ArrayAdapter
{

    private int mCurSelectedIndex;
    StatusImageView mCurSelectedItem;
    private LayoutInflater mInflater;
    HashMap posViewMap;

    public CustomArrayAdapter(Context context, TResInfo atresinfo[])
    {
        super(context, 0x7f030081, atresinfo);
        mCurSelectedIndex = -1;
        posViewMap = new HashMap();
        mInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = view;
        TResInfo tresinfo = (TResInfo)getItem(i);
        obj = view;
        if (!(tresinfo instanceof TImageFilterInfo)) goto _L2; else goto _L1
_L1:
        obj = view;
        Object obj1 = (TImageFilterInfo)getItem(i);
        obj = view;
        if (((TImageFilterInfo) (obj1)).getResType() != EResType.NETWORK) goto _L4; else goto _L3
_L3:
        obj = view;
        int j = ((TImageFilterInfo) (obj1)).filterIconName.lastIndexOf("/");
        obj = view;
        obj1 = ((TImageFilterInfo) (obj1)).filterIconName.substring(j + 1);
        obj = view;
        obj1 = FileManager.getInstance().getOnlineBitmapRes(EOnlineResType.LIGHT_FILTER, ((String) (obj1)));
        obj = obj1;
          goto _L5
_L11:
        if (view != null) goto _L7; else goto _L6
_L6:
        obj = view;
        view = mInflater.inflate(0x7f030081, viewgroup, false);
        obj = view;
        StatusImageView statusimageview = (StatusImageView)view.findViewById(0x7f0d01cd);
        obj = view;
        statusimageview.setTag(tresinfo);
        obj = view;
        viewgroup = new amv(null);
        obj = view;
        viewgroup.a = statusimageview;
        obj = view;
        viewgroup.b = ((Bitmap) (obj1));
        obj = view;
        view.setTag(viewgroup);
_L9:
        ((amv) (viewgroup)).a.setImageBitmap(((Bitmap) (obj1)));
        if (i == mCurSelectedIndex)
        {
            ((amv) (viewgroup)).a.setIsSelected(true);
            mCurSelectedItem = ((amv) (viewgroup)).a;
        }
        posViewMap.put(Integer.valueOf(i), view);
        return view;
_L4:
        obj = view;
        obj1 = ((TImageFilterInfo) (obj1)).getIconBitmap();
        obj = obj1;
          goto _L5
_L2:
        obj = view;
        try
        {
            obj1 = tresinfo.getIconBitmap();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            viewgroup = view;
            view = ((View) (obj));
        }
        break; /* Loop/switch isn't completed */
_L7:
        obj = view;
        viewgroup = (amv)view.getTag();
        obj = view;
        ((amv) (viewgroup)).a.setImageBitmap(null);
        obj = view;
        ((amv) (viewgroup)).a.setIsSelected(false);
        obj = view;
        ((amv) (viewgroup)).a.setTag(tresinfo);
        obj = view;
        if (((amv) (viewgroup)).b == null)
        {
            break MISSING_BLOCK_LABEL_351;
        }
        obj = view;
        if (((amv) (viewgroup)).b.isRecycled())
        {
            break MISSING_BLOCK_LABEL_351;
        }
        obj = view;
        ((amv) (viewgroup)).b.recycle();
        obj = view;
        viewgroup.b = null;
        obj = view;
        viewgroup.b = ((Bitmap) (obj1));
        if (true) goto _L9; else goto _L8
_L8:
        viewgroup.printStackTrace();
        return view;
        viewgroup;
        if (true) goto _L8; else goto _L5
_L5:
        obj1 = obj;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void setSelectPosition(int i)
    {
        StatusImageView statusimageview = ((amv)((View)posViewMap.get(Integer.valueOf(i))).getTag()).a;
        if (statusimageview != mCurSelectedItem)
        {
            if (mCurSelectedItem != null)
            {
                mCurSelectedItem.setIsSelected(false);
            }
            statusimageview.setIsSelected(true);
        }
        mCurSelectedItem = statusimageview;
        mCurSelectedIndex = i;
    }
}
