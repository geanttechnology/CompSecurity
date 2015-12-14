// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import apq;
import aqx;
import atz;
import beg;
import beh;
import com.crashlytics.android.Crashlytics;
import com.instabeauty.application.InstaBeautyApplication;
import com.instamag.activity.commonview.StatusImageView;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.activity.link.model.TPhotoLinkComposeInfo;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.HashMap;
import yp;

public class StyleListAdapter extends BaseAdapter
{

    beh imageWorker;
    private final Context mContext;
    StatusImageView mCurSelectedItem;
    private LayoutInflater mInflater;
    ArrayList mItemList;
    HashMap posViewMap;
    private int selectedIndex;

    public StyleListAdapter(Context context, beh beh1, ArrayList arraylist)
    {
        imageWorker = null;
        posViewMap = new HashMap();
        selectedIndex = -1;
        mContext = context;
        imageWorker = beh1;
        mItemList = arraylist;
        mInflater = (LayoutInflater)mContext.getSystemService("layout_inflater");
    }

    private View createViewByType(InstaMagType instamagtype, ViewGroup viewgroup)
    {
        View view = null;
        if (instamagtype == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            view = mInflater.inflate(0x7f0300ca, viewgroup, false);
        } else
        {
            if (instamagtype == InstaMagType.SQ_LIB_SIZE_TYPE)
            {
                return mInflater.inflate(0x7f0300cb, viewgroup, false);
            }
            if (instamagtype == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
            {
                return mInflater.inflate(0x7f0300c9, viewgroup, false);
            }
            if (instamagtype == InstaMagType.LINK_LIB_SIZE_TYPE)
            {
                return mInflater.inflate(0x7f0300ca, viewgroup, false);
            }
        }
        return view;
    }

    private void refreshItemUIByInfo(int i, TPhotoComposeInfo tphotocomposeinfo)
    {
        Object obj = (View)posViewMap.get(Integer.valueOf(i));
        if (obj != null && tphotocomposeinfo != null)
        {
            obj = (beg)((View) (obj)).getTag();
            if (obj != null)
            {
                setShareLogoByInfo(((beg) (obj)).b, tphotocomposeinfo);
            }
        }
    }

    private void setShareLogoByInfo(ImageView imageview, TResInfo tresinfo)
    {
        imageview.setVisibility(4);
        imageview.setImageResource(0x7f0203fa);
        imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        if (!apq.c().d().isExistedByResId(tresinfo.resId) && !(tresinfo instanceof TPhotoLinkComposeInfo))
        {
            boolean flag;
            if (tresinfo.otherAppStoreId != null && !tresinfo.otherAppStoreId.equalsIgnoreCase("null") && tresinfo.otherAppStoreId.length() > 4 && !isAppInstalled(tresinfo.otherAppStoreId))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_START);
            imageview.setImageResource(0x7f0202a1);
            imageview.setVisibility(0);
            if (tresinfo.needSharing && (new atz(mContext)).b() && !aqx.a(tresinfo))
            {
                imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                imageview.setImageResource(0x7f0203fa);
                imageview.setVisibility(0);
            }
            if (flag)
            {
                imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                imageview.setImageResource(0x7f020045);
                imageview.setVisibility(0);
            }
        }
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

    public int getIndexByInfo(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (tphotocomposeinfo != null && mItemList != null)
        {
            for (int i = 0; i < mItemList.size(); i++)
            {
                TPhotoComposeInfo tphotocomposeinfo1 = (TPhotoComposeInfo)mItemList.get(i);
                if (tphotocomposeinfo.resId == tphotocomposeinfo1.resId)
                {
                    return i;
                }
            }

        }
        return 0;
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

    public int getItemWdithByInfo(TPhotoComposeInfo tphotocomposeinfo)
    {
        int i = 0;
        tphotocomposeinfo = TPhotoComposeInfo.getInstaMagType(tphotocomposeinfo);
        Context context = InstaBeautyApplication.a().getApplicationContext();
        if (tphotocomposeinfo == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            i = yp.a(context, 62F);
        } else
        {
            if (tphotocomposeinfo == InstaMagType.SQ_LIB_SIZE_TYPE)
            {
                return yp.a(context, 62F);
            }
            if (tphotocomposeinfo == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
            {
                return yp.a(context, 90F);
            }
            if (tphotocomposeinfo == InstaMagType.LINK_LIB_SIZE_TYPE)
            {
                return yp.a(context, 62F);
            }
        }
        return i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = view;
        TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)getItem(i);
        obj = view;
        InstaMagType instamagtype = TPhotoComposeInfo.getInstaMagType(tphotocomposeinfo);
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        obj = view;
        posViewMap.remove(Integer.valueOf(i));
        if (view == null) goto _L2; else goto _L1
_L1:
        obj = view;
        if ((InstaMagType)view.getTag(0x7f06033c) == instamagtype) goto _L3; else goto _L2
_L2:
        obj = view;
        view = createViewByType(instamagtype, viewgroup);
        obj = view;
        StatusImageView statusimageview = (StatusImageView)view.findViewById(0x7f0d01cd);
        obj = view;
        ImageView imageview = (ImageView)view.findViewById(0x7f0d02a1);
        obj = view;
        ProgressBar progressbar = (ProgressBar)view.findViewById(0x7f0d0176);
        obj = view;
        viewgroup = new beg(null);
        obj = view;
        viewgroup.a = statusimageview;
        obj = view;
        viewgroup.b = imageview;
        obj = view;
        viewgroup.c = progressbar;
        obj = view;
        view.setTag(viewgroup);
        obj = view;
        view.setTag(0x7f06033c, instamagtype);
_L11:
        setShareLogoByInfo(((beg) (viewgroup)).b, tphotocomposeinfo);
        if (i != selectedIndex) goto _L5; else goto _L4
_L4:
        ((beg) (viewgroup)).a.setIsSelected(true);
        mCurSelectedItem = ((beg) (viewgroup)).a;
_L7:
        imageWorker.a(tphotocomposeinfo, ((beg) (viewgroup)).a);
        posViewMap.put(Integer.valueOf(i), view);
        return view;
_L3:
        obj = view;
        try
        {
            viewgroup = (beg)view.getTag();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            viewgroup = ((ViewGroup) (obj));
            obj = view;
        }
          goto _L6
_L5:
        ((beg) (viewgroup)).a.setIsSelected(false);
          goto _L7
        obj;
        viewgroup = view;
_L9:
        ((Exception) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
        return viewgroup;
_L6:
        if (true) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public boolean isAppInstalled(String s)
    {
        boolean flag = false;
        try
        {
            s = InstaBeautyApplication.a.getPackageManager().getPackageInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = null;
        }
        if (s != null)
        {
            flag = true;
        }
        return flag;
    }

    public void replaceAblsulateInfo(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (mItemList == null || tphotocomposeinfo == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        if (i >= mItemList.size()) goto _L2; else goto _L3
_L3:
        if (((TPhotoComposeInfo)mItemList.get(i)).resId != tphotocomposeinfo.resId) goto _L5; else goto _L4
_L4:
        mItemList.set(i, tphotocomposeinfo);
        refreshItemUIByInfo(i, tphotocomposeinfo);
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
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
            obj = (beg)((View) (obj)).getTag();
            if (obj != null)
            {
                obj = ((beg) (obj)).a;
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
