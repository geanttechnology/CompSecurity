// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.fotoable.photocollage.view.compose2.color.ColorSelectView;
import com.fotoable.photocollage.view.compose2.framebg.FrameCollageBgPagerAdapter;
import com.fotoable.photocollage.view.compose2.framebg.FrameCollageBgScrollPageView;
import com.fotoable.photocollage.view.compose2.indicate.CirclePageIndicator;
import com.wantu.model.res.TFrameItemInfo;
import ew;
import me;
import mm;
import mn;
import yc;

public class Compose2ModuleBgView extends FrameLayout
    implements mm, mn
{

    FrameCollageBgPagerAdapter adapter;
    TFrameItemInfo bg_color_info;
    CirclePageIndicator circlePageIndicator1;
    ColorSelectView colorSelectView1;
    int displayHeight;
    yc gridsbgManager;
    View img_close;
    View layout_bg_scroll;
    View layout_mask;
    me listener;
    FrameCollageBgScrollPageView pageViewer;

    public Compose2ModuleBgView(Context context)
    {
        super(context);
        gridsbgManager = new yc();
        bg_color_info = new TFrameItemInfo();
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300ae, this, true);
        initView();
    }

    public Compose2ModuleBgView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        gridsbgManager = new yc();
        bg_color_info = new TFrameItemInfo();
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300ae, this, true);
        initView();
    }

    private void initView()
    {
        pageViewer = (FrameCollageBgScrollPageView)findViewById(0x7f0c02b0);
        circlePageIndicator1 = (CirclePageIndicator)findViewById(0x7f0c02b1);
        int i = ew.a(getContext());
        colorSelectView1 = (ColorSelectView)findViewById(0x7f0c02b2);
        colorSelectView1.setMaxSizeWithDoubleLine(ew.a(getContext(), i - 45), ew.a(getContext(), 36F));
        colorSelectView1.setOnColorSelectorListener(this);
        changeAdapter();
    }

    public void TouchBegin()
    {
    }

    public void TouchEnd()
    {
    }

    public void changeAdapter()
    {
        java.util.List list = gridsbgManager.a();
        adapter = new FrameCollageBgPagerAdapter();
        adapter.a(list);
        pageViewer.setDataAdapter(adapter);
        adapter.a(this);
        circlePageIndicator1.setViewPager(pageViewer.getPager());
        circlePageIndicator1.setCentered(true);
        circlePageIndicator1.notifyDataSetChanged();
    }

    public int getDisplayHeight()
    {
        return ew.a(getContext(), 150F);
    }

    public void onColorSelector(int i)
    {
        bg_color_info.setBgColor(i);
        if (listener != null)
        {
            adapter.resItemSelected(null);
            listener.a(bg_color_info);
        }
    }

    public void onItemSelected(TFrameItemInfo tframeiteminfo)
    {
        if (listener != null)
        {
            listener.a(tframeiteminfo);
        }
    }

    public void setOnBgChangeListener(me me1)
    {
        listener = me1;
    }
}
