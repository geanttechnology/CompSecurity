// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import awf;
import awg;
import awk;
import axk;
import axl;
import axm;
import axn;
import axt;
import com.fotoable.sketch.info.TTieZhiInfo;
import java.util.List;

public class TTieZhiLibraryView extends FrameLayout
{

    public awf imageWorker;
    boolean isFinishLoad;
    public long lastClickTime;
    public axt lisener;
    axn mAdapter;
    ExpandableListView mListView;
    public awk mTypeInfo;
    RelativeLayout tipView;
    TextView txt_networkTip;
    TextView txt_noresView;
    public TextView txt_refresh;
    RelativeLayout view_loading;
    public FrameLayout view_refresh;

    public TTieZhiLibraryView(Context context)
    {
        super(context);
        lastClickTime = 0L;
        initView();
    }

    public TTieZhiLibraryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        lastClickTime = 0L;
        initView();
    }

    public TTieZhiLibraryView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        lastClickTime = 0L;
        initView();
    }

    private void initView()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300d5, this, true);
        tipView = (RelativeLayout)findViewById(0x7f0d0347);
        tipView.setOnClickListener(new axk(this));
        txt_networkTip = (TextView)findViewById(0x7f0d0348);
        view_loading = (RelativeLayout)findViewById(0x7f0d034a);
        view_refresh = (FrameLayout)findViewById(0x7f0d034c);
        txt_noresView = (TextView)findViewById(0x7f0d0349);
        txt_refresh = (TextView)findViewById(0x7f0d034d);
        txt_refresh.getPaint().setFlags(8);
        txt_refresh.setOnTouchListener(new axl(this));
        mListView = (ExpandableListView)findViewById(0x7f0d0346);
        mListView.setDivider(null);
        mListView.setGroupIndicator(null);
        mListView.setOnGroupClickListener(new axm(this));
        mAdapter = new axn(this);
        mListView.setAdapter(mAdapter);
    }

    public void expandAllGroup()
    {
        if (mTypeInfo != null && mTypeInfo.e.size() > 0)
        {
            for (int i = 0; i < mTypeInfo.e.size(); i++)
            {
                mListView.expandGroup(i);
            }

        }
    }

    public void initWithImageWorker(awf awf)
    {
        imageWorker = awf;
    }

    public void reloadData()
    {
        expandAllGroup();
        mAdapter.notifyDataSetChanged();
    }

    public void setData(awk awk1)
    {
        mTypeInfo = awk1;
        if (awk1.a == TTieZhiInfo.kTZLocalTypeID)
        {
            mTypeInfo = awg.a().f();
        }
        reloadData();
        if (mTypeInfo != null && mTypeInfo.e.size() > 0)
        {
            tipView.setVisibility(4);
            return;
        }
        tipView.setVisibility(0);
        if (mTypeInfo.a == TTieZhiInfo.kTZLocalTypeID)
        {
            view_refresh.setVisibility(4);
            view_loading.setVisibility(4);
            txt_networkTip.setVisibility(4);
            txt_noresView.setVisibility(0);
            return;
        }
        txt_noresView.setVisibility(4);
        if (isFinishLoad)
        {
            view_refresh.setVisibility(0);
            view_loading.setVisibility(4);
            txt_networkTip.setVisibility(0);
            return;
        } else
        {
            view_refresh.setVisibility(4);
            view_loading.setVisibility(0);
            txt_networkTip.setVisibility(4);
            return;
        }
    }

    public void setIsFinishLoad(boolean flag)
    {
        isFinishLoad = flag;
    }

    public void setTieZhiCellLisener(axt axt)
    {
        lisener = axt;
    }
}
