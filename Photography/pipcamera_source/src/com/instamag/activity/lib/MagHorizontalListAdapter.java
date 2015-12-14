// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.crashlytics.android.Crashlytics;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.List;
import qj;
import qk;

// Referenced classes of package com.instamag.activity.lib:
//            MagHorizonalItemView

public class MagHorizontalListAdapter extends BaseAdapter
{

    private String TAG;
    private qk imageWorker;
    private final Context mContext;
    private List mItemList;

    public MagHorizontalListAdapter(Context context, qk qk1, List list)
    {
        TAG = "MagHorizontalListAdapter";
        imageWorker = null;
        mContext = context;
        imageWorker = qk1;
        mItemList = list;
        if (mItemList != null)
        {
            Log.v(TAG, (new StringBuilder()).append(TAG).append(" datalist :").append(mItemList.size()).toString());
        }
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
        TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)getItem(i);
        if (view != null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        viewgroup = new MagHorizonalItemView(mContext);
        qj qj1;
        try
        {
            qj1 = new qj();
            qj1.a = (MagHorizonalItemView)viewgroup;
            viewgroup.setTag(qj1);
        }
        catch (Exception exception)
        {
            view = viewgroup;
            viewgroup = exception;
            continue; /* Loop/switch isn't completed */
        }
        view = viewgroup;
        viewgroup = qj1;
_L1:
        ((qj) (viewgroup)).a.SetDataItem(tphotocomposeinfo);
        viewgroup = ((qj) (viewgroup)).a.getImageView();
        imageWorker.a(tphotocomposeinfo, viewgroup);
        return view;
        viewgroup = (qj)view.getTag();
          goto _L1
        viewgroup;
_L3:
        viewgroup.printStackTrace();
        Crashlytics.logException(viewgroup);
        return view;
        viewgroup;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public void setDataList(List list)
    {
        mItemList = list;
        notifyDataSetChanged();
    }
}
