// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.model.res.TResInfo;
import java.util.List;
import on;
import oy;

// Referenced classes of package com.fotoable.sketch.view:
//            TTieZhiViewCell

public class TTieZhiViewListCell extends FrameLayout
{

    FrameLayout cellLayout;
    TTieZhiViewCell cellView1;
    TTieZhiViewCell cellView2;
    TTieZhiViewCell cellView3;
    TTieZhiViewCell cellView4;
    on imgWorker;
    private oy lisener;
    FrameLayout ly1;
    FrameLayout ly2;
    FrameLayout ly3;
    FrameLayout ly4;
    Context mContext;
    private List mInfos;

    public TTieZhiViewListCell(Context context, on on1)
    {
        super(context);
        mContext = context;
        imgWorker = on1;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030099, this, true);
        cellLayout = (FrameLayout)findViewById(0x7f0c0176);
        ly1 = (FrameLayout)findViewById(0x7f0c0177);
        ly2 = (FrameLayout)findViewById(0x7f0c017c);
        ly3 = (FrameLayout)findViewById(0x7f0c017f);
        ly4 = (FrameLayout)findViewById(0x7f0c0266);
        cellView1 = (TTieZhiViewCell)findViewById(0x7f0c0263);
        cellView2 = (TTieZhiViewCell)findViewById(0x7f0c0264);
        cellView3 = (TTieZhiViewCell)findViewById(0x7f0c0265);
        cellView4 = (TTieZhiViewCell)findViewById(0x7f0c0267);
    }

    public static int getItemDividerWidth()
    {
        return (int)(float)PIPCameraApplication.a.getResources().getDisplayMetrics().widthPixels / 40;
    }

    public static int getItemWidth(Context context)
    {
        return (int)((float)context.getResources().getDisplayMetrics().widthPixels - (float)(getItemDividerWidth() * 5)) / 4;
    }

    private void resetLayout(FrameLayout framelayout)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)framelayout.getLayoutParams();
        layoutparams.width = getItemWidth(getContext());
        layoutparams.height = getItemWidth(getContext());
        Log.i("debug test", (new StringBuilder()).append("width ").append(layoutparams.width).append(",height ").append(layoutparams.height).toString());
        if (framelayout == ly1)
        {
            layoutparams.leftMargin = getItemDividerWidth();
            framelayout.setLayoutParams(layoutparams);
        } else
        {
            if (framelayout == ly2)
            {
                layoutparams.leftMargin = getItemDividerWidth() * 2 + getItemWidth(mContext);
                framelayout.setLayoutParams(layoutparams);
                return;
            }
            if (framelayout == ly3)
            {
                layoutparams.leftMargin = getItemDividerWidth() * 3 + getItemWidth(mContext) * 2;
                framelayout.setLayoutParams(layoutparams);
                return;
            }
            if (framelayout == ly4)
            {
                layoutparams.leftMargin = getItemDividerWidth() * 4 + getItemWidth(mContext) * 3;
                framelayout.setLayoutParams(layoutparams);
                return;
            }
        }
    }

    public void setDataItem(List list)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mInfos = list;
        if (mInfos.size() == 0) goto _L1; else goto _L3
_L3:
        list = (android.widget.FrameLayout.LayoutParams)cellLayout.getLayoutParams();
        list.height = getItemWidth(getContext()) + getItemDividerWidth();
        cellLayout.setLayoutParams(list);
        switch (mInfos.size())
        {
        default:
            return;

        case 1: // '\001'
            resetLayout(ly2);
            resetLayout(ly3);
            resetLayout(ly4);
            cellView1.setVisibility(0);
            list = (TResInfo)mInfos.get(0);
            resetLayout(ly1);
            cellView1.setItemClickLisener(lisener);
            cellView1.SetDataInfo((TTieZhiInfo)list);
            cellView1.setTag(list);
            cellView4.setVisibility(4);
            cellView3.setVisibility(4);
            cellView2.setVisibility(4);
            if (imgWorker != null)
            {
                imgWorker.a(list, cellView1.getImageView());
                return;
            }
            break;

        case 2: // '\002'
            resetLayout(ly3);
            resetLayout(ly4);
            cellView1.setVisibility(0);
            list = (TResInfo)mInfos.get(0);
            resetLayout(ly1);
            cellView1.setItemClickLisener(lisener);
            cellView1.SetDataInfo((TTieZhiInfo)list);
            cellView1.setTag(list);
            if (imgWorker != null)
            {
                imgWorker.a(list, cellView1.getImageView());
            }
            cellView2.setVisibility(0);
            list = (TResInfo)mInfos.get(1);
            resetLayout(ly2);
            cellView2.setItemClickLisener(lisener);
            cellView2.SetDataInfo((TTieZhiInfo)list);
            cellView2.setTag(list);
            cellView4.setVisibility(4);
            cellView3.setVisibility(4);
            if (imgWorker != null)
            {
                imgWorker.a(list, cellView2.getImageView());
                return;
            }
            break;

        case 3: // '\003'
            resetLayout(ly4);
            cellView1.setVisibility(0);
            list = (TResInfo)mInfos.get(0);
            resetLayout(ly1);
            cellView1.setItemClickLisener(lisener);
            cellView1.SetDataInfo((TTieZhiInfo)list);
            cellView1.setTag(list);
            if (imgWorker != null)
            {
                imgWorker.a(list, cellView1.getImageView());
            }
            cellView2.setVisibility(0);
            list = (TResInfo)mInfos.get(1);
            resetLayout(ly2);
            cellView2.setItemClickLisener(lisener);
            cellView2.SetDataInfo((TTieZhiInfo)list);
            cellView2.setTag(list);
            if (imgWorker != null)
            {
                imgWorker.a(list, cellView2.getImageView());
            }
            cellView3.setVisibility(0);
            list = (TResInfo)mInfos.get(2);
            resetLayout(ly3);
            cellView3.setItemClickLisener(lisener);
            cellView3.SetDataInfo((TTieZhiInfo)list);
            cellView3.setTag(list);
            cellView4.setVisibility(4);
            if (imgWorker != null)
            {
                imgWorker.a(list, cellView3.getImageView());
                return;
            }
            break;

        case 4: // '\004'
            cellView1.setVisibility(0);
            list = (TResInfo)mInfos.get(0);
            resetLayout(ly1);
            cellView1.setItemClickLisener(lisener);
            cellView1.SetDataInfo((TTieZhiInfo)list);
            cellView1.setTag(list);
            if (imgWorker != null)
            {
                imgWorker.a(list, cellView1.getImageView());
            }
            cellView2.setVisibility(0);
            list = (TResInfo)mInfos.get(1);
            resetLayout(ly2);
            cellView2.setItemClickLisener(lisener);
            cellView2.SetDataInfo((TTieZhiInfo)list);
            cellView2.setTag(list);
            if (imgWorker != null)
            {
                imgWorker.a(list, cellView2.getImageView());
            }
            cellView3.setVisibility(0);
            list = (TResInfo)mInfos.get(2);
            resetLayout(ly3);
            cellView3.setItemClickLisener(lisener);
            cellView3.SetDataInfo((TTieZhiInfo)list);
            cellView3.setTag(list);
            if (imgWorker != null)
            {
                imgWorker.a(list, cellView3.getImageView());
            }
            cellView4.setVisibility(0);
            list = (TResInfo)mInfos.get(3);
            resetLayout(ly4);
            cellView4.setItemClickLisener(lisener);
            cellView4.SetDataInfo((TTieZhiInfo)list);
            cellView4.setTag(list);
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (imgWorker == null) goto _L1; else goto _L5
_L5:
        imgWorker.a(list, cellView4.getImageView());
        return;
    }

    public void setItemClickLisener(oy oy)
    {
        lisener = oy;
    }
}
