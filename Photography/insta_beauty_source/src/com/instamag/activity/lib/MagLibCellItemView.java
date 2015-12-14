// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import bbr;
import bbs;
import bbu;
import com.fotoable.comlib.ui.RecyclingImageView;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import zu;

public class MagLibCellItemView extends FrameLayout
{

    private static final String TAG = "MagLibCellItemView";
    FrameLayout cellLayout;
    RecyclingImageView img1;
    RecyclingImageView img2;
    RecyclingImageView img3;
    FrameLayout ly1;
    FrameLayout ly2;
    FrameLayout ly3;
    private bbu mCellItem;
    public Context mContext;
    private zu mImageWorker;

    public MagLibCellItemView(Context context)
    {
        super(context);
        mContext = context;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03009d, this, true);
        cellLayout = (FrameLayout)findViewById(0x7f0d0279);
        ly1 = (FrameLayout)findViewById(0x7f0d027a);
        ly2 = (FrameLayout)findViewById(0x7f0d027c);
        ly3 = (FrameLayout)findViewById(0x7f0d027e);
        img1 = (RecyclingImageView)findViewById(0x7f0d02a4);
        img2 = (RecyclingImageView)findViewById(0x7f0d02a5);
        img3 = (RecyclingImageView)findViewById(0x7f0d02a6);
        img1.setOnClickListener(new bbr(this, img1));
        img2.setOnClickListener(new bbr(this, img2));
        img3.setOnClickListener(new bbr(this, img3));
    }

    private void resetLayout(FrameLayout framelayout, InstaMagType instamagtype)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)framelayout.getLayoutParams();
        if (framelayout == ly1)
        {
            layoutparams.leftMargin = bbs.a();
            layoutparams.width = bbs.a(mContext);
            layoutparams.height = bbs.a(instamagtype);
            framelayout.setLayoutParams(layoutparams);
            framelayout = img1.getLayoutParams();
            framelayout.width = layoutparams.width;
            framelayout.height = layoutparams.height;
            img1.setLayoutParams(framelayout);
        } else
        {
            if (framelayout == ly2)
            {
                layoutparams.leftMargin = bbs.a() * 2 + bbs.a(mContext);
                layoutparams.width = bbs.a(mContext);
                layoutparams.height = bbs.a(instamagtype);
                framelayout.setLayoutParams(layoutparams);
                framelayout = img2.getLayoutParams();
                framelayout.width = layoutparams.width;
                framelayout.height = layoutparams.height;
                img2.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                img2.setLayoutParams(framelayout);
                return;
            }
            if (framelayout == ly3)
            {
                layoutparams.leftMargin = bbs.a() * 3 + bbs.a(mContext) * 2;
                layoutparams.width = bbs.a(mContext);
                layoutparams.height = bbs.a(instamagtype);
                framelayout.setLayoutParams(layoutparams);
                framelayout = img3.getLayoutParams();
                framelayout.width = layoutparams.width;
                framelayout.height = layoutparams.height;
                img3.setLayoutParams(framelayout);
                return;
            }
        }
    }

    public void SetDataItem(bbu bbu1, zu zu1)
    {
        mImageWorker = zu1;
        if (bbu1 == null)
        {
            Log.e("MagLibCellItemView", "Set empty data!");
        } else
        if (!bbu1.equals(mCellItem))
        {
            mCellItem = bbu1;
            if (mCellItem.a != null)
            {
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
                    ly3.setVisibility(4);
                    ly2.setVisibility(4);
                    zu.a(img2);
                    zu.a(img3);
                    ly1.setVisibility(0);
                    bbu1 = (TResInfo)mCellItem.a.get(0);
                    resetLayout(ly1, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)bbu1));
                    zu.a(img1);
                    mImageWorker.a(bbu1, img1);
                    img1.setTag(bbu1);
                    return;

                case 2: // '\002'
                    resetLayout(ly3, InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
                    ly3.setVisibility(4);
                    ly1.setVisibility(0);
                    bbu1 = (TResInfo)mCellItem.a.get(0);
                    resetLayout(ly1, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)bbu1));
                    zu.a(img1);
                    mImageWorker.a(bbu1, img1);
                    img1.setTag(bbu1);
                    ly2.setVisibility(0);
                    zu.a(img2);
                    bbu1 = (TResInfo)mCellItem.a.get(1);
                    mImageWorker.a(bbu1, img2);
                    resetLayout(ly2, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)bbu1));
                    img2.setTag(bbu1);
                    return;

                case 3: // '\003'
                    ly1.setVisibility(0);
                    break;
                }
                bbu1 = (TResInfo)mCellItem.a.get(0);
                resetLayout(ly1, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)bbu1));
                zu.a(img1);
                mImageWorker.a(bbu1, img1);
                img1.setTag(bbu1);
                bbu1 = (TResInfo)mCellItem.a.get(1);
                zu.a(img2);
                mImageWorker.a(bbu1, img2);
                resetLayout(ly2, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)bbu1));
                ly2.setVisibility(0);
                img2.setTag(bbu1);
                bbu1 = (TResInfo)mCellItem.a.get(2);
                zu.a(img3);
                mImageWorker.a(bbu1, img3);
                resetLayout(ly3, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)bbu1));
                ly3.setVisibility(0);
                img3.setTag(bbu1);
                return;
            }
        }
    }

    public void setImageWorker(zu zu1)
    {
        mImageWorker = zu1;
    }
}
