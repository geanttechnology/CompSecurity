// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.instamag.activity.commonview.TMaterialTypeView;
import java.util.ArrayList;
import qi;
import qk;
import qt;

// Referenced classes of package com.instamag.activity.lib:
//            MagLibHorizontalView

public class OnlineLibTypeAdapter extends BaseAdapter
{

    private static String TAG = "OnlineLibTypeAdapter";
    private int TYPE_FOLDER;
    private int TYPE_HORIZONTAL;
    private Context mContext;
    private qk mImageWorker;
    private ArrayList mItems;
    private qi mLisener;

    public OnlineLibTypeAdapter(Context context, ArrayList arraylist, qk qk)
    {
        TYPE_HORIZONTAL = 0;
        TYPE_FOLDER = 1;
        mContext = context;
        mImageWorker = qk;
        mItems = arraylist;
    }

    public int getCount()
    {
        if (mItems == null)
        {
            return 0;
        } else
        {
            return mItems.size();
        }
    }

    public Object getItem(int i)
    {
        return mItems.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        qt qt1 = (qt)mItems.get(i);
        if (qt1 != null && qt1.e.booleanValue())
        {
            return TYPE_HORIZONTAL;
        } else
        {
            return TYPE_FOLDER;
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        int j = getItemViewType(i);
        if (view == null)
        {
            if (j == TYPE_FOLDER)
            {
                view = new TMaterialTypeView(mContext, mImageWorker);
                ((TMaterialTypeView)view).SetDataItem((qt)mItems.get(i));
            }
            if (j == TYPE_HORIZONTAL)
            {
                view = new MagLibHorizontalView(mContext);
                ((MagLibHorizontalView)view).setItemClickLisener(mLisener);
                ((MagLibHorizontalView)view).setDataItems((qt)mItems.get(i), mImageWorker);
            }
        } else
        {
            viewgroup = view;
            if (view instanceof MagLibHorizontalView)
            {
                viewgroup = view;
                if (j == TYPE_FOLDER)
                {
                    viewgroup = new TMaterialTypeView(mContext, mImageWorker);
                    ((TMaterialTypeView)viewgroup).SetDataItem((qt)mItems.get(i));
                }
            }
            if ((viewgroup instanceof TMaterialTypeView) && j == TYPE_HORIZONTAL)
            {
                viewgroup = new MagLibHorizontalView(mContext);
                ((MagLibHorizontalView)viewgroup).setItemClickLisener(mLisener);
                ((MagLibHorizontalView)viewgroup).setDataItems((qt)mItems.get(i), mImageWorker);
            }
            if ((viewgroup instanceof MagLibHorizontalView) && j == TYPE_HORIZONTAL)
            {
                ((MagLibHorizontalView)viewgroup).setDataItems((qt)mItems.get(i), mImageWorker);
            }
            view = viewgroup;
            if (viewgroup instanceof TMaterialTypeView)
            {
                view = viewgroup;
                if (j == TYPE_FOLDER)
                {
                    ((TMaterialTypeView)viewgroup).SetDataItem((qt)mItems.get(i));
                    return viewgroup;
                }
            }
        }
        return view;
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public void setItemHorizonListViewClickLisener(qi qi)
    {
        mLisener = qi;
    }

    public void setItemList(ArrayList arraylist)
    {
        mItems = arraylist;
        notifyDataSetChanged();
    }

}
