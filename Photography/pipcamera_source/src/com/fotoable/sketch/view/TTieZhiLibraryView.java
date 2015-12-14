// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fotoable.sketch.info.TTieZhiInfo;
import java.util.List;
import on;
import oo;
import or;
import ow;
import oy;

public class TTieZhiLibraryView extends FrameLayout
{

    public on imageWorker;
    boolean isFinishLoad;
    long lastClickTime;
    public oy lisener;
    ow mAdapter;
    ExpandableListView mListView;
    public or mTypeInfo;
    RelativeLayout tipView;
    TextView txt_networkTip;
    TextView txt_noresView;
    TextView txt_refresh;
    RelativeLayout view_loading;
    FrameLayout view_refresh;

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
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030096, this, true);
        tipView = (RelativeLayout)findViewById(0x7f0c025a);
        tipView.setOnClickListener(new android.view.View.OnClickListener() {

            final TTieZhiLibraryView a;

            public void onClick(View view)
            {
                Log.e("click text", "click down");
                long l = System.currentTimeMillis();
                if (l - a.lastClickTime > 5000L)
                {
                    Log.e("click text", "click down yes");
                    a.lastClickTime = l;
                    if (a.view_refresh.getVisibility() == 0 && a.lisener != null)
                    {
                        a.lisener.a(true);
                    }
                }
            }

            
            {
                a = TTieZhiLibraryView.this;
                super();
            }
        });
        txt_networkTip = (TextView)findViewById(0x7f0c025b);
        view_loading = (RelativeLayout)findViewById(0x7f0c025d);
        view_refresh = (FrameLayout)findViewById(0x7f0c025f);
        txt_noresView = (TextView)findViewById(0x7f0c025c);
        txt_refresh = (TextView)findViewById(0x7f0c0260);
        txt_refresh.getPaint().setFlags(8);
        txt_refresh.setOnTouchListener(new android.view.View.OnTouchListener() {

            final TTieZhiLibraryView a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 2 || motionevent.getAction() == 0)
                {
                    a.txt_refresh.setTextColor(0x7affffff);
                } else
                {
                    a.txt_refresh.setTextColor(-1);
                }
                return true;
            }

            
            {
                a = TTieZhiLibraryView.this;
                super();
            }
        });
        mListView = (ExpandableListView)findViewById(0x7f0c0259);
        mListView.setDivider(null);
        mListView.setGroupIndicator(null);
        mListView.setOnGroupClickListener(new android.widget.ExpandableListView.OnGroupClickListener() {

            final TTieZhiLibraryView a;

            public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
            {
                return true;
            }

            
            {
                a = TTieZhiLibraryView.this;
                super();
            }
        });
        mAdapter = new ow(this);
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

    public void initWithImageWorker(on on)
    {
        imageWorker = on;
    }

    public void reloadData()
    {
        expandAllGroup();
        mAdapter.notifyDataSetChanged();
    }

    public void setData(or or1)
    {
        mTypeInfo = or1;
        if (or1.a == TTieZhiInfo.kTZLocalTypeID)
        {
            mTypeInfo = oo.a().f();
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

    public void setTieZhiCellLisener(oy oy)
    {
        lisener = oy;
    }
}
