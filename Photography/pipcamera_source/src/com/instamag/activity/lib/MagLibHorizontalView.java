// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fotoable.comlib.ui.HorizontalListView;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import ew;
import java.util.List;
import qi;
import qk;
import qp;
import qt;

// Referenced classes of package com.instamag.activity.lib:
//            MagHorizonalItemView, MagHorizontalListAdapter

public class MagLibHorizontalView extends LinearLayout
    implements android.widget.AdapterView.OnItemClickListener
{

    private static String TAG = "MagLibHorizontalViews";
    MagHorizontalListAdapter adapter;
    HorizontalListView horizontalReuseListView1;
    qi mClickLisener;
    Context mContext;
    qk mImageWorker;
    qt mlistInfo;
    TextView tvTitle;

    public MagLibHorizontalView(Context context)
    {
        super(context);
        mContext = context;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03004f, this, true);
        horizontalReuseListView1 = (HorizontalListView)findViewById(0x7f0c0162);
        horizontalReuseListView1.setOnItemClickListener(this);
        tvTitle = (TextView)findViewById(0x7f0c0163);
        resetLayout();
    }

    private void resetLayout()
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)horizontalReuseListView1.getLayoutParams();
        layoutparams.height = qp.a(InstaMagType.RECT_LIB_SIZE_TYPE) + qp.a() / 2 + 3;
        horizontalReuseListView1.setLayoutParams(layoutparams);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" info rid onItemClick").toString());
        if (view instanceof MagHorizonalItemView)
        {
            adapterview = ((MagHorizonalItemView)view).getDataItem();
            if (adapterview != null)
            {
                Log.v(TAG, (new StringBuilder()).append(TAG).append(" info rid:").append(((TPhotoComposeInfo) (adapterview)).resId).toString());
                if (mClickLisener != null)
                {
                    mClickLisener.a(adapterview);
                }
            }
        }
    }

    public void setDataItems(qt qt1, qk qk)
    {
        mlistInfo = qt1;
        mImageWorker = qk;
        Log.v(TAG, (new StringBuilder()).append(TAG).append("setDataItems:").append(qt1.a).toString());
        Log.v(TAG, (new StringBuilder()).append(TAG).append("setDataItems:").append(mlistInfo.f.size()).toString());
        String s;
        if (ew.b())
        {
            s = qt1.a;
        } else
        if (ew.c())
        {
            s = qt1.b;
        } else
        {
            s = qt1.c;
        }
        tvTitle.setText(s);
        if (adapter == null)
        {
            adapter = new MagHorizontalListAdapter(mContext, qk, qt1.f);
            horizontalReuseListView1.setAdapter(adapter);
            return;
        } else
        {
            adapter.setDataList(mlistInfo.f);
            return;
        }
    }

    public void setItemClickLisener(qi qi1)
    {
        mClickLisener = qi1;
    }

}
