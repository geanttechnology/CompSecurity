// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.Model;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.wantu.ResourceOnlineLibrary.activity.ResItemView;
import com.wantu.model.res.TResInfo;
import fq;
import java.util.ArrayList;
import um;

public class OnlineResImageAdapter extends BaseAdapter
{

    private static final String TAG = "GroupGridAdapter";
    private final Activity mContext;
    private um mDelegate;
    private android.widget.AbsListView.LayoutParams mImageViewLayoutParams;
    final fq mImageWorker;
    private int mItemHeight;
    ArrayList mItemList;
    private int mNumColumns;

    public OnlineResImageAdapter(Activity activity, ArrayList arraylist, fq fq1)
    {
        mItemHeight = 0;
        mNumColumns = 0;
        mContext = activity;
        mItemList = arraylist;
        mImageWorker = fq1;
        mImageViewLayoutParams = new android.widget.AbsListView.LayoutParams(-1, -1);
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

    public int getNumColumns()
    {
        return mNumColumns;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (mItemList.get(i) instanceof TResInfo)
        {
            if (view != null && (view instanceof ResItemView))
            {
                view = (ResItemView)view;
            } else
            {
                view = new ResItemView(mContext, mImageWorker);
                view.setmDelegate(mDelegate);
                view.setLayoutParams(mImageViewLayoutParams);
            }
            if (view.getLayoutParams().height != mItemHeight)
            {
                view.setLayoutParams(mImageViewLayoutParams);
            }
            view.SetDataItem((TResInfo)mItemList.get(i));
            return view;
        } else
        {
            Log.e("GroupGridAdapter", String.format("getView no view for the specified positon %d ", new Object[] {
                Integer.valueOf(i)
            }));
            return null;
        }
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public um getmDelegate()
    {
        return mDelegate;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public void removeItem(TResInfo tresinfo)
    {
        int i = 0;
_L3:
        if (i >= mItemList.size())
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (!((TResInfo)mItemList.get(i)).name.equalsIgnoreCase(tresinfo.name)) goto _L2; else goto _L1
_L1:
        tresinfo = (TResInfo)mItemList.get(i);
_L4:
        mItemList.remove(tresinfo);
        notifyDataSetChanged();
        return;
_L2:
        i++;
          goto _L3
        tresinfo = null;
          goto _L4
    }

    public void setItemHeight(int i)
    {
        if (i == mItemHeight)
        {
            return;
        } else
        {
            mItemHeight = i;
            mImageViewLayoutParams = new android.widget.AbsListView.LayoutParams(-1, mItemHeight);
            mImageWorker.a(i);
            notifyDataSetChanged();
            return;
        }
    }

    public void setItemList(ArrayList arraylist)
    {
        mItemList = arraylist;
        notifyDataSetChanged();
    }

    public void setNumColumns(int i)
    {
        mNumColumns = i;
    }

    public void setmDelegate(um um)
    {
        mDelegate = um;
    }
}
