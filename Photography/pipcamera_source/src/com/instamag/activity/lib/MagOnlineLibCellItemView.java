// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fotoable.comlib.ui.RecyclingImageView;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.model.res.TResInfo;
import fr;
import java.util.ArrayList;
import kf;
import ql;
import qo;
import qp;
import qq;

public class MagOnlineLibCellItemView extends FrameLayout
{

    private static final String TAG = "MagLibCellItemView";
    FrameLayout cellLayout;
    ImageView done1;
    ImageView done2;
    ImageView done3;
    RecyclingImageView img1;
    RecyclingImageView img2;
    RecyclingImageView img3;
    FrameLayout ly1;
    FrameLayout ly2;
    FrameLayout ly3;
    private qq mCellItem;
    Context mContext;
    private fr mImageWorker;
    private ql magViewClickListener;
    ImageView share1;
    ImageView share2;
    ImageView share3;

    public MagOnlineLibCellItemView(Context context)
    {
        super(context);
        mContext = context;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030054, this, true);
        cellLayout = (FrameLayout)findViewById(0x7f0c0176);
        ly1 = (FrameLayout)findViewById(0x7f0c0177);
        ly2 = (FrameLayout)findViewById(0x7f0c017c);
        ly3 = (FrameLayout)findViewById(0x7f0c017f);
        img1 = (RecyclingImageView)findViewById(0x7f0c017a);
        img2 = (RecyclingImageView)findViewById(0x7f0c017d);
        img3 = (RecyclingImageView)findViewById(0x7f0c0180);
        img1.setOnClickListener(new qo(this, img1));
        img2.setOnClickListener(new qo(this, img2));
        img3.setOnClickListener(new qo(this, img3));
        done1 = (ImageView)findViewById(0x7f0c0186);
        done2 = (ImageView)findViewById(0x7f0c0188);
        done3 = (ImageView)findViewById(0x7f0c018a);
        share1 = (ImageView)findViewById(0x7f0c0187);
        share2 = (ImageView)findViewById(0x7f0c0189);
        share3 = (ImageView)findViewById(0x7f0c018b);
        share1.setBackgroundResource(0x7f020262);
        share2.setBackgroundResource(0x7f020262);
        share3.setBackgroundResource(0x7f020262);
    }

    private void resetLayout(FrameLayout framelayout, InstaMagType instamagtype)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)framelayout.getLayoutParams();
        android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)done1.getLayoutParams();
        android.widget.FrameLayout.LayoutParams layoutparams2 = (android.widget.FrameLayout.LayoutParams)done2.getLayoutParams();
        android.widget.FrameLayout.LayoutParams layoutparams3 = (android.widget.FrameLayout.LayoutParams)done3.getLayoutParams();
        android.widget.FrameLayout.LayoutParams layoutparams4 = (android.widget.FrameLayout.LayoutParams)share1.getLayoutParams();
        android.widget.FrameLayout.LayoutParams layoutparams5 = (android.widget.FrameLayout.LayoutParams)share2.getLayoutParams();
        android.widget.FrameLayout.LayoutParams layoutparams6 = (android.widget.FrameLayout.LayoutParams)share3.getLayoutParams();
        layoutparams.width = qp.a(mContext);
        layoutparams.height = qp.a(instamagtype);
        if (framelayout == ly1)
        {
            layoutparams.leftMargin = qp.a();
            layoutparams1.width = qp.a();
            layoutparams1.height = qp.a();
            layoutparams1.leftMargin = (layoutparams.leftMargin + layoutparams.width) - layoutparams1.width / 2;
            layoutparams1.topMargin = cellLayout.getLayoutParams().height - layoutparams.height - layoutparams1.height / 2;
            layoutparams4.leftMargin = layoutparams.leftMargin;
            layoutparams4.topMargin = cellLayout.getLayoutParams().height - layoutparams.height;
            framelayout = img1.getLayoutParams();
            framelayout.width = layoutparams.width;
            framelayout.height = layoutparams.height;
            img1.setLayoutParams(framelayout);
        } else
        {
            if (framelayout == ly2)
            {
                layoutparams.leftMargin = qp.a() * 2 + qp.a(mContext);
                layoutparams2.width = qp.a();
                layoutparams2.height = qp.a();
                layoutparams2.leftMargin = (layoutparams.leftMargin + layoutparams.width) - layoutparams2.width / 2;
                layoutparams2.topMargin = cellLayout.getLayoutParams().height - layoutparams.height - layoutparams2.height / 2;
                layoutparams5.leftMargin = layoutparams.leftMargin;
                layoutparams5.topMargin = cellLayout.getLayoutParams().height - layoutparams.height;
                framelayout.setLayoutParams(layoutparams);
                framelayout = img2.getLayoutParams();
                framelayout.width = layoutparams.width;
                framelayout.height = layoutparams.height;
                img2.setLayoutParams(framelayout);
                return;
            }
            if (framelayout == ly3)
            {
                layoutparams.leftMargin = qp.a() * 3 + qp.a(mContext) * 2;
                layoutparams3.width = qp.a();
                layoutparams3.height = qp.a();
                layoutparams3.leftMargin = (layoutparams.leftMargin + layoutparams.width) - layoutparams3.width / 2;
                layoutparams3.topMargin = cellLayout.getLayoutParams().height - layoutparams.height - layoutparams3.height / 2;
                layoutparams6.leftMargin = layoutparams.leftMargin;
                layoutparams6.topMargin = cellLayout.getLayoutParams().height - layoutparams.height;
                framelayout.setLayoutParams(layoutparams);
                framelayout = img3.getLayoutParams();
                framelayout.width = layoutparams.width;
                framelayout.height = layoutparams.height;
                img3.setLayoutParams(framelayout);
                return;
            }
        }
    }

    private void setDoneLogoByInfo(ImageView imageview, TResInfo tresinfo)
    {
        if (kf.c().e().isExistedByResId(tresinfo.resId))
        {
            imageview.setVisibility(0);
            return;
        } else
        {
            imageview.setVisibility(4);
            return;
        }
    }

    private void setShareLogoByInfo(ImageView imageview, TResInfo tresinfo)
    {
        if (tresinfo.needSharing && !kf.c().e().isExistedByResId(tresinfo.resId))
        {
            imageview.setVisibility(0);
            return;
        } else
        {
            imageview.setVisibility(4);
            return;
        }
    }

    public void SetDataItem(qq qq1, fr fr1)
    {
        mImageWorker = fr1;
        if (qq1 == null)
        {
            Log.e("MagLibCellItemView", "Set empty data!");
        } else
        if (qq1 != mCellItem)
        {
            mCellItem = qq1;
            if (mCellItem.d != null)
            {
                qq1 = (android.widget.FrameLayout.LayoutParams)cellLayout.getLayoutParams();
                qq1.height = qp.a(mCellItem.d) + qp.a();
                cellLayout.setLayoutParams(qq1);
                switch (mCellItem.d.size())
                {
                default:
                    return;

                case 1: // '\001'
                    resetLayout(ly2, InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
                    resetLayout(ly3, InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
                    img1.setVisibility(0);
                    qq1 = (TResInfo)mCellItem.d.get(0);
                    resetLayout(ly1, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)qq1));
                    mImageWorker.a(qq1, img1);
                    img1.setTag(qq1);
                    setDoneLogoByInfo(done1, qq1);
                    setShareLogoByInfo(share1, qq1);
                    img3.setVisibility(4);
                    img2.setVisibility(4);
                    done2.setVisibility(4);
                    done3.setVisibility(4);
                    share2.setVisibility(4);
                    share3.setVisibility(4);
                    return;

                case 2: // '\002'
                    resetLayout(ly3, InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
                    img1.setVisibility(0);
                    qq1 = (TResInfo)mCellItem.d.get(0);
                    resetLayout(ly1, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)qq1));
                    mImageWorker.a(qq1, img1);
                    img1.setTag(qq1);
                    setDoneLogoByInfo(done1, qq1);
                    setShareLogoByInfo(share1, qq1);
                    img2.setVisibility(0);
                    qq1 = (TResInfo)mCellItem.d.get(1);
                    resetLayout(ly2, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)qq1));
                    mImageWorker.a(qq1, img2);
                    img2.setTag(qq1);
                    setDoneLogoByInfo(done2, qq1);
                    setShareLogoByInfo(share2, qq1);
                    img3.setVisibility(4);
                    done3.setVisibility(4);
                    share3.setVisibility(4);
                    return;

                case 3: // '\003'
                    img1.setVisibility(0);
                    break;
                }
                qq1 = (TResInfo)mCellItem.d.get(0);
                resetLayout(ly1, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)qq1));
                mImageWorker.a(qq1, img1);
                img1.setTag(qq1);
                setDoneLogoByInfo(done1, qq1);
                setShareLogoByInfo(share1, qq1);
                img2.setVisibility(0);
                qq1 = (TResInfo)mCellItem.d.get(1);
                resetLayout(ly2, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)qq1));
                mImageWorker.a(qq1, img2);
                img2.setTag(qq1);
                setDoneLogoByInfo(done2, qq1);
                setShareLogoByInfo(share2, qq1);
                img3.setVisibility(0);
                qq1 = (TResInfo)mCellItem.d.get(2);
                resetLayout(ly3, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)qq1));
                mImageWorker.a(qq1, img3);
                img3.setTag(qq1);
                setDoneLogoByInfo(done3, qq1);
                setShareLogoByInfo(share3, qq1);
                return;
            }
        }
    }

    public void setImageWorker(fr fr1)
    {
        mImageWorker = fr1;
    }

    public void setMagItemViewClickListener(ql ql)
    {
        magViewClickListener = ql;
    }

}
