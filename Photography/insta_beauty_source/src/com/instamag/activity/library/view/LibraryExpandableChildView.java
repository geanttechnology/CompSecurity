// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import bbs;
import bbu;
import bda;
import bdz;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;

// Referenced classes of package com.instamag.activity.library.view:
//            MaglibItemView

public class LibraryExpandableChildView extends FrameLayout
{

    FrameLayout cellLayout;
    MaglibItemView cellView1;
    MaglibItemView cellView2;
    MaglibItemView cellView3;
    bda imgWorker;
    private bdz lisener;
    FrameLayout ly1;
    FrameLayout ly2;
    FrameLayout ly3;
    private bbu mCellItem;
    Context mContext;
    boolean mIsEdit;

    public LibraryExpandableChildView(Context context, bda bda1)
    {
        super(context);
        mContext = context;
        imgWorker = bda1;
        mIsEdit = false;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030080, this, true);
        cellLayout = (FrameLayout)findViewById(0x7f0d0279);
        ly1 = (FrameLayout)findViewById(0x7f0d027a);
        ly2 = (FrameLayout)findViewById(0x7f0d027c);
        ly3 = (FrameLayout)findViewById(0x7f0d027e);
        cellView1 = (MaglibItemView)findViewById(0x7f0d027b);
        cellView2 = (MaglibItemView)findViewById(0x7f0d027d);
        cellView3 = (MaglibItemView)findViewById(0x7f0d027f);
    }

    private void resetLayout(FrameLayout framelayout, InstaMagType instamagtype)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)framelayout.getLayoutParams();
        layoutparams.width = bbs.a(mContext);
        layoutparams.height = bbs.a(instamagtype);
        Log.i("debug test", (new StringBuilder()).append("width ").append(layoutparams.width).append(",height ").append(layoutparams.height).toString());
        if (framelayout == ly1)
        {
            layoutparams.leftMargin = bbs.a();
            framelayout.setLayoutParams(layoutparams);
        } else
        {
            if (framelayout == ly2)
            {
                layoutparams.leftMargin = bbs.a() * 2 + bbs.a(mContext);
                framelayout.setLayoutParams(layoutparams);
                return;
            }
            if (framelayout == ly3)
            {
                layoutparams.leftMargin = bbs.a() * 3 + bbs.a(mContext) * 2;
                framelayout.setLayoutParams(layoutparams);
                return;
            }
        }
    }

    public void SetDataItem(bbu bbu1)
    {
_L2:
        return;
        if (bbu1 == null || bbu1 == mCellItem) goto _L2; else goto _L1
_L1:
        mCellItem = bbu1;
        if (mCellItem.a == null) goto _L2; else goto _L3
_L3:
        bbu1 = (android.widget.FrameLayout.LayoutParams)cellLayout.getLayoutParams();
        bbu1.height = bbs.a(mCellItem.a) + bbs.a();
        cellLayout.setLayoutParams(bbu1);
        switch (mCellItem.a.size())
        {
        default:
            return;

        case 1: // '\001'
            resetLayout(ly2, InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
            resetLayout(ly3, InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
            cellView1.setVisibility(0);
            bbu1 = (TResInfo)mCellItem.a.get(0);
            resetLayout(ly1, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)bbu1));
            cellView1.setItemClickLisener(lisener);
            cellView1.setEditState(mIsEdit);
            cellView1.SetDataInfo((TPhotoComposeInfo)bbu1);
            cellView1.setTag(bbu1);
            cellView3.setVisibility(4);
            cellView2.setVisibility(4);
            if (imgWorker != null)
            {
                imgWorker.a(bbu1, cellView1.getImageView());
                return;
            }
            break;

        case 2: // '\002'
            resetLayout(ly3, InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
            cellView1.setVisibility(0);
            bbu1 = (TResInfo)mCellItem.a.get(0);
            resetLayout(ly1, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)bbu1));
            cellView1.setItemClickLisener(lisener);
            cellView1.setEditState(mIsEdit);
            cellView1.SetDataInfo((TPhotoComposeInfo)bbu1);
            cellView1.setTag(bbu1);
            if (imgWorker != null)
            {
                imgWorker.a(bbu1, cellView1.getImageView());
            }
            cellView2.setVisibility(0);
            bbu1 = (TResInfo)mCellItem.a.get(1);
            resetLayout(ly2, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)bbu1));
            cellView2.setItemClickLisener(lisener);
            cellView2.setEditState(mIsEdit);
            cellView2.SetDataInfo((TPhotoComposeInfo)bbu1);
            cellView2.setTag(bbu1);
            cellView3.setVisibility(4);
            if (imgWorker != null)
            {
                imgWorker.a(bbu1, cellView2.getImageView());
                return;
            }
            break;

        case 3: // '\003'
            cellView1.setVisibility(0);
            bbu1 = (TResInfo)mCellItem.a.get(0);
            resetLayout(ly1, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)bbu1));
            cellView1.setItemClickLisener(lisener);
            cellView1.setEditState(mIsEdit);
            cellView1.SetDataInfo((TPhotoComposeInfo)bbu1);
            cellView1.setTag(bbu1);
            if (imgWorker != null)
            {
                imgWorker.a(bbu1, cellView1.getImageView());
            }
            cellView2.setVisibility(0);
            bbu1 = (TResInfo)mCellItem.a.get(1);
            resetLayout(ly2, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)bbu1));
            cellView2.setItemClickLisener(lisener);
            cellView2.setEditState(mIsEdit);
            cellView2.SetDataInfo((TPhotoComposeInfo)bbu1);
            cellView2.setTag(bbu1);
            if (imgWorker != null)
            {
                imgWorker.a(bbu1, cellView2.getImageView());
            }
            cellView3.setVisibility(0);
            bbu1 = (TResInfo)mCellItem.a.get(2);
            resetLayout(ly3, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)bbu1));
            cellView3.setItemClickLisener(lisener);
            cellView3.setEditState(mIsEdit);
            cellView3.SetDataInfo((TPhotoComposeInfo)bbu1);
            cellView3.setTag(bbu1);
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L2; else goto _L4
_L4:
        if (imgWorker == null) goto _L2; else goto _L5
_L5:
        imgWorker.a(bbu1, cellView3.getImageView());
        return;
    }

    public void setEditMode(boolean flag)
    {
        mIsEdit = flag;
    }

    public void setItemClickLisener(bdz bdz)
    {
        lisener = bdz;
    }
}
