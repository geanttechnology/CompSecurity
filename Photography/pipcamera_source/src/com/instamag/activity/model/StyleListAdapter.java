// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.model;

import android.content.Context;
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
import qw;
import qx;

public class StyleListAdapter extends BaseAdapter
{

    qx imageWorker;
    private final Context mContext;
    StatusImageView mCurSelectedItem;
    private LayoutInflater mInflater;
    ArrayList mItemList;
    HashMap posViewMap;
    private int selectedIndex;

    public StyleListAdapter(Context context, qx qx1, ArrayList arraylist)
    {
        imageWorker = null;
        posViewMap = new HashMap();
        selectedIndex = -1;
        mContext = context;
        imageWorker = qx1;
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
        view1 = view;
        InstaMagType instamagtype = TPhotoComposeInfo.getInstaMagType(tphotocomposeinfo);
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        view1 = view;
        posViewMap.remove(Integer.valueOf(i));
        if (view == null) goto _L2; else goto _L1
_L1:
        view1 = view;
        if ((InstaMagType)view.getTag(0x7f060246) == instamagtype) goto _L3; else goto _L2
_L2:
        view1 = view;
        if (instamagtype != InstaMagType.RECT_LIB_SIZE_TYPE) goto _L5; else goto _L4
_L4:
        view1 = view;
        Object obj = mInflater.inflate(0x7f03008b, viewgroup, false);
_L16:
        view1 = ((View) (obj));
        view = (StatusImageView)((View) (obj)).findViewById(0x7f0c010f);
        view1 = ((View) (obj));
        viewgroup = new qw();
        view1 = ((View) (obj));
        viewgroup.a = view;
        view1 = ((View) (obj));
        ((View) (obj)).setTag(viewgroup);
        view1 = ((View) (obj));
        ((View) (obj)).setTag(0x7f060246, instamagtype);
        view = ((View) (obj));
_L11:
        if (i != selectedIndex) goto _L7; else goto _L6
_L6:
        ((qw) (viewgroup)).a.setIsSelected(true);
        mCurSelectedItem = ((qw) (viewgroup)).a;
_L12:
        imageWorker.a(tphotocomposeinfo, ((qw) (viewgroup)).a);
        posViewMap.put(Integer.valueOf(i), view);
        return view;
_L5:
        view1 = view;
        if (instamagtype != InstaMagType.SQ_LIB_SIZE_TYPE) goto _L9; else goto _L8
_L8:
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
          goto _L10
_L9:
        view1 = view;
        if (instamagtype != InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
        {
            break MISSING_BLOCK_LABEL_265;
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
_L3:
        view1 = view;
        viewgroup = (qw)view.getTag();
          goto _L11
_L7:
        ((qw) (viewgroup)).a.setIsSelected(false);
          goto _L12
        obj;
        viewgroup = view;
_L14:
        ((Exception) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
        return viewgroup;
_L10:
        if (true) goto _L14; else goto _L13
_L13:
        if (true) goto _L16; else goto _L15
_L15:
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
            obj = (qw)((View) (obj)).getTag();
            if (obj != null)
            {
                obj = ((qw) (obj)).a;
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
