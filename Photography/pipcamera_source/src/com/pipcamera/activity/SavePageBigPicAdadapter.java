// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.crashlytics.android.Crashlytics;
import java.util.ArrayList;
import rt;

// Referenced classes of package com.pipcamera.activity:
//            BigPicAdViewItem

public class SavePageBigPicAdadapter extends BaseAdapter
{

    private Context mContext;
    private ArrayList mList;

    public SavePageBigPicAdadapter(Context context, ArrayList arraylist)
    {
        mContext = context;
        mList = arraylist;
    }

    public int getCount()
    {
        if (mList == null)
        {
            return 0;
        } else
        {
            return mList.size();
        }
    }

    public Object getItem(int i)
    {
        return mList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        rt rt1 = (rt)mList.get(i);
        if (view != null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        viewgroup = new BigPicAdViewItem(mContext);
        ((BigPicAdViewItem)viewgroup).setData(rt1);
        return viewgroup;
        ((BigPicAdViewItem)view).setData(rt1);
        return view;
        Exception exception;
        exception;
        viewgroup = view;
        view = exception;
_L2:
        Crashlytics.logException(view);
        return viewgroup;
        view;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setItemList(ArrayList arraylist)
    {
        mList = arraylist;
    }
}
