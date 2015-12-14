// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.fotoable.comlib.ui.RecyclingImageView;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import fr;
import kf;
import qp;

public class MagHorizonalItemView extends LinearLayout
{

    private static final String TAG = "MagHorizonalItemView";
    private FrameLayout cellLayout;
    private RecyclingImageView img1;
    private ImageView imgdone;
    private ImageView imgshare;
    private FrameLayout ly1;
    private Context mContext;
    private fr mImageWorker;
    private TPhotoComposeInfo mInfo;

    public MagHorizonalItemView(Context context)
    {
        super(context);
        mContext = context;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030052, this, true);
        cellLayout = (FrameLayout)findViewById(0x7f0c0176);
        ly1 = (FrameLayout)findViewById(0x7f0c0177);
        img1 = (RecyclingImageView)findViewById(0x7f0c0178);
        imgdone = (ImageView)findViewById(0x7f0c0179);
        imgshare = (ImageView)findViewById(0x7f0c0049);
        imgshare.setBackgroundResource(0x7f020262);
    }

    private void resetLayout(InstaMagType instamagtype)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)ly1.getLayoutParams();
        layoutparams.width = qp.a(mContext);
        layoutparams.height = qp.a(instamagtype);
        ly1.setLayoutParams(layoutparams);
        instamagtype = img1.getLayoutParams();
        instamagtype.width = layoutparams.width;
        instamagtype.height = layoutparams.height;
        img1.setLayoutParams(instamagtype);
        instamagtype = (android.widget.FrameLayout.LayoutParams)imgdone.getLayoutParams();
        instamagtype.width = qp.a();
        instamagtype.height = qp.a();
        instamagtype.topMargin = cellLayout.getLayoutParams().height - layoutparams.height - ((android.widget.FrameLayout.LayoutParams) (instamagtype)).height / 2;
        instamagtype.leftMargin = (layoutparams.leftMargin + layoutparams.width) - ((android.widget.FrameLayout.LayoutParams) (instamagtype)).width / 2;
        instamagtype = (android.widget.FrameLayout.LayoutParams)imgshare.getLayoutParams();
        instamagtype.topMargin = cellLayout.getLayoutParams().height - layoutparams.height;
        instamagtype.leftMargin = layoutparams.leftMargin + qp.a() / 4;
    }

    public void SetDataItem(TPhotoComposeInfo tphotocomposeinfo)
    {
        mInfo = tphotocomposeinfo;
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)cellLayout.getLayoutParams();
        int i = qp.a(InstaMagType.RECT_LIB_SIZE_TYPE);
        layoutparams.width = qp.a(mContext) + qp.a() / 2 + 3;
        layoutparams.height = i + qp.a() / 2 + 3;
        cellLayout.setLayoutParams(layoutparams);
        resetLayout(TPhotoComposeInfo.getInstaMagType(tphotocomposeinfo));
        if (kf.c().e().isExistedByResId(tphotocomposeinfo.resId))
        {
            imgdone.setVisibility(0);
            imgshare.setVisibility(4);
            return;
        }
        imgdone.setVisibility(4);
        if (tphotocomposeinfo.needSharing)
        {
            imgshare.setVisibility(0);
            return;
        } else
        {
            imgshare.setVisibility(4);
            return;
        }
    }

    public TPhotoComposeInfo getDataItem()
    {
        return mInfo;
    }

    public RecyclingImageView getImageView()
    {
        return img1;
    }
}
