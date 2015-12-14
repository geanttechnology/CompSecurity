// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.crashlytics.android.Crashlytics;
import com.instamag.activity.commonview.StatusImageView;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.ArrayList;
import java.util.HashMap;
import qr;
import qs;

public class StyleListAdapter extends BaseAdapter
{

    qs imageWorker;
    private final Context mContext;
    StatusImageView mCurSelectedItem;
    private LayoutInflater mInflater;
    ArrayList mItemList;
    HashMap posViewMap;
    private int selectedIndex;

    public StyleListAdapter(Context context, qs qs1, ArrayList arraylist)
    {
        imageWorker = null;
        posViewMap = new HashMap();
        selectedIndex = -1;
        mContext = context;
        imageWorker = qs1;
        mItemList = arraylist;
        mInflater = (LayoutInflater)mContext.getSystemService("layout_inflater");
    }

    public void clear()
    {
        if (mItemList != null)
        {
            mItemList.clear();
        }
        posViewMap.clear();
        notifyDataSetChanged();
    }

    public int getCount()
    {
        if (mItemList == null)
        {
            return 0;
        } else
        {
            return mItemList.size();
        }
    }

    public Object getItem(int i)
    {
        return mItemList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)getItem(i);
        if (view != null) goto _L2; else goto _L1
_L1:
        view1 = view;
        InstaMagType instamagtype = TPhotoComposeInfo.getInstaMagType(tphotocomposeinfo);
        view1 = view;
        if (instamagtype != InstaMagType.RECT_LIB_SIZE_TYPE) goto _L4; else goto _L3
_L3:
        view1 = view;
        Object obj = mInflater.inflate(0x7f03008b, viewgroup, false);
_L17:
        view1 = ((View) (obj));
        view = (StatusImageView)((View) (obj)).findViewById(0x7f0c010f);
        view1 = ((View) (obj));
        view.setTag(tphotocomposeinfo);
        view1 = ((View) (obj));
        viewgroup = new qr();
        view1 = ((View) (obj));
        viewgroup.a = view;
        view1 = ((View) (obj));
        ((View) (obj)).setTag(viewgroup);
        view = ((View) (obj));
_L11:
        imageWorker.a(tphotocomposeinfo, ((qr) (viewgroup)).a);
        if (i != selectedIndex) goto _L6; else goto _L5
_L5:
        ((qr) (viewgroup)).a.setIsSelected(true);
        mCurSelectedItem = ((qr) (viewgroup)).a;
_L13:
        posViewMap.put(Integer.valueOf(i), view);
        return view;
_L4:
        view1 = view;
        if (instamagtype != InstaMagType.SQ_LIB_SIZE_TYPE) goto _L8; else goto _L7
_L7:
        view1 = view;
        try
        {
            obj = mInflater.inflate(0x7f03008c, viewgroup, false);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            viewgroup = view1;
            obj = view;
        }
          goto _L9
_L8:
        view1 = view;
        if (instamagtype != InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        view1 = view;
        obj = mInflater.inflate(0x7f03008a, viewgroup, false);
        continue; /* Loop/switch isn't completed */
        obj = view;
        view1 = view;
        if (instamagtype != InstaMagType.LINK_LIB_SIZE_TYPE)
        {
            continue; /* Loop/switch isn't completed */
        }
        view1 = view;
        obj = mInflater.inflate(0x7f03008b, viewgroup, false);
        continue; /* Loop/switch isn't completed */
_L2:
        view1 = view;
        viewgroup = (qr)view.getTag();
        view1 = view;
        ((qr) (viewgroup)).a.setImageBitmap(null);
        view1 = view;
        ((qr) (viewgroup)).a.setTag(tphotocomposeinfo);
        view1 = view;
        if (((qr) (viewgroup)).b == null) goto _L11; else goto _L10
_L10:
        view1 = view;
        if (((qr) (viewgroup)).b.isRecycled()) goto _L11; else goto _L12
_L12:
        view1 = view;
        ((qr) (viewgroup)).b.recycle();
        view1 = view;
        viewgroup.b = null;
          goto _L11
_L6:
        ((qr) (viewgroup)).a.setIsSelected(false);
          goto _L13
        obj;
        viewgroup = view;
_L15:
        ((Exception) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
        return viewgroup;
_L9:
        if (true) goto _L15; else goto _L14
_L14:
        if (true) goto _L17; else goto _L16
_L16:
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public void setDataList(ArrayList arraylist)
    {
        if (mItemList != null)
        {
            mItemList.clear();
        }
        mItemList = arraylist;
        posViewMap.clear();
        notifyDataSetChanged();
    }

    public void setSelectPosition(int i)
    {
        selectedIndex = i;
        Object obj = (View)posViewMap.get(Integer.valueOf(i));
        if (obj != null)
        {
            obj = (qr)((View) (obj)).getTag();
            if (obj != null)
            {
                obj = ((qr) (obj)).a;
                if (mCurSelectedItem != null)
                {
                    mCurSelectedItem.setIsSelected(false);
                }
                ((StatusImageView) (obj)).setIsSelected(true);
                mCurSelectedItem = ((StatusImageView) (obj));
            }
        }
    }
}
