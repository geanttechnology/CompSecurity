// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.view;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import aph;
import api;
import apq;
import aqx;
import atz;
import bbs;
import bcn;
import bcv;
import bds;
import bdt;
import bdu;
import bdv;
import bdw;
import bdx;
import bdy;
import bdz;
import com.fotoable.comlib.ui.RecyclingImageView;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.activity.link.model.TPhotoLinkComposeInfo;
import java.util.List;
import yp;

// Referenced classes of package com.instamag.activity.library.view:
//            NumberProgressBar

public class MaglibItemView extends LinearLayout
{

    private static final String DELETEINFOTAG = "deleteInfoTagTip";
    private static final String TAG = "MaglibItemView";
    private FrameLayout cellLayout;
    private RecyclingImageView img1;
    private ImageView imgDelete;
    private ImageView imgNewTip;
    private ImageView imgdownload;
    private ImageView imgshare;
    public boolean isEditMode;
    private bdz lisener;
    private TPhotoComposeInfo mInfo;
    private NumberProgressBar progressBar;
    atz weChatShare;

    public MaglibItemView(Context context)
    {
        super(context);
        initView();
    }

    public MaglibItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        initView();
    }

    private void checkToShowTipDialog()
    {
        (new api(getContext())).b(getResources().getString(0x7f0602ae)).a(getResources().getString(0x7f0600db)).a(true).a("  no more tips", new bdx(this)).a(getResources().getString(0x7f0602fd), new bdw(this)).b(getResources().getString(0x7f0600a8), new bdv(this)).a().show();
    }

    private void deleteComposeInfo(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (isEditMode)
        {
            apq.c().d().removeInfoFromLibrary(tphotocomposeinfo);
            if (lisener != null)
            {
                lisener.e(tphotocomposeinfo);
                return;
            }
        }
    }

    private void downloadInfo(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (tphotocomposeinfo == null)
        {
            return;
        } else
        {
            bcv.a().a(tphotocomposeinfo, new bdu(this));
            return;
        }
    }

    private void goComposeByInfo(TPhotoComposeInfo tphotocomposeinfo)
    {
        int i = tphotocomposeinfo.rid;
        aqx.b(InstaBeautyApplication.a, "TRESINFOUSED", (new StringBuilder()).append("resInfoUesd_").append(i).toString(), true);
        imgNewTip.setVisibility(4);
        if (lisener != null)
        {
            lisener.a(tphotocomposeinfo);
        }
    }

    private void initView()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03009c, this, true);
        img1 = (RecyclingImageView)findViewById(0x7f0d029f);
        progressBar = (NumberProgressBar)findViewById(0x7f0d01a8);
        cellLayout = (FrameLayout)findViewById(0x7f0d0279);
        imgdownload = (ImageView)findViewById(0x7f0d02a0);
        imgdownload.setImageResource(0x7f0202a1);
        imgshare = (ImageView)findViewById(0x7f0d02a1);
        imgshare.setImageResource(0x7f0203fa);
        imgDelete = (ImageView)findViewById(0x7f0d02a3);
        imgDelete.setImageResource(0x7f0202b8);
        imgNewTip = (ImageView)findViewById(0x7f0d02a2);
        imgNewTip.setImageResource(0x7f0202d7);
        img1.setOnClickListener(new bdy(this, null));
        imgDelete.setOnClickListener(new bds(this));
        weChatShare = new atz(getContext());
    }

    private void onClickedDownloadInfo(TPhotoComposeInfo tphotocomposeinfo)
    {
        while (tphotocomposeinfo == null || (new bcn(getContext(), tphotocomposeinfo)).a()) 
        {
            return;
        }
        downloadInfo(tphotocomposeinfo);
    }

    private void resetLayout(InstaMagType instamagtype)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)cellLayout.getLayoutParams();
        layoutparams.width = bbs.a(getContext());
        layoutparams.height = bbs.a(instamagtype);
        cellLayout.setLayoutParams(layoutparams);
    }

    public void SetDataInfo(TPhotoComposeInfo tphotocomposeinfo)
    {
        mInfo = tphotocomposeinfo;
        resetLayout(TPhotoComposeInfo.getInstaMagType(mInfo));
        refreshUIByData(tphotocomposeinfo);
    }

    public boolean checkHasUsed(int i)
    {
        return aqx.a(InstaBeautyApplication.a, "TRESINFOUSED", (new StringBuilder()).append("resInfoUesd_").append(i).toString(), true);
    }

    public TPhotoComposeInfo getDataItem()
    {
        return mInfo;
    }

    public RecyclingImageView getImageView()
    {
        return img1;
    }

    public NumberProgressBar getProgressBar()
    {
        return progressBar;
    }

    public void refreshUIByData(TPhotoComposeInfo tphotocomposeinfo)
    {
        boolean flag = true;
        if (tphotocomposeinfo == null)
        {
            return;
        }
        if (tphotocomposeinfo instanceof TPhotoLinkComposeInfo)
        {
            imgNewTip.setVisibility(4);
            imgdownload.setVisibility(4);
            imgshare.setVisibility(4);
            imgDelete.setVisibility(4);
            return;
        }
        if (isEditMode)
        {
            imgdownload.setVisibility(4);
            imgshare.setVisibility(4);
            imgNewTip.setVisibility(4);
            tphotocomposeinfo = apq.c().d().getInfosByImageCountAndCollageType(mInfo.imageCount);
            if (tphotocomposeinfo != null && tphotocomposeinfo.size() > 1 || !apq.c().d().isExistedByResId(mInfo.resId))
            {
                imgDelete.setVisibility(0);
                return;
            } else
            {
                imgDelete.setVisibility(4);
                return;
            }
        }
        imgDelete.setVisibility(4);
        if (apq.c().d().isExistedByResId(tphotocomposeinfo.resId))
        {
            if (checkHasUsed(mInfo.resId))
            {
                imgNewTip.setVisibility(4);
            } else
            {
                imgNewTip.setVisibility(0);
            }
            imgdownload.setVisibility(4);
            imgshare.setVisibility(4);
            return;
        }
        imgdownload.setVisibility(4);
        imgNewTip.setVisibility(4);
        if (tphotocomposeinfo.otherAppStoreId == null || tphotocomposeinfo.otherAppStoreId.equalsIgnoreCase("null") || tphotocomposeinfo.otherAppStoreId.length() <= 4 || yp.a(getContext(), tphotocomposeinfo.otherAppStoreId))
        {
            flag = false;
        }
        if (flag)
        {
            imgshare.setImageResource(0x7f020045);
            imgshare.setVisibility(0);
            return;
        }
        if (mInfo.needSharing && !tphotocomposeinfo.hasSharedInfo() && tphotocomposeinfo.wxdlShareInfo != null && weChatShare.b())
        {
            imgshare.setImageResource(0x7f0203fa);
            imgshare.setVisibility(0);
            return;
        } else
        {
            imgdownload.setVisibility(0);
            imgshare.setVisibility(4);
            return;
        }
    }

    public void setEditState(boolean flag)
    {
        isEditMode = flag;
    }

    public void setItemClickLisener(bdz bdz1)
    {
        lisener = bdz1;
    }

    public void showFlipAnimation()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            AnimatorSet animatorset = (AnimatorSet)AnimatorInflater.loadAnimator(getContext(), 0x7f040026);
            animatorset.addListener(new bdt(this));
            animatorset.setTarget(this);
            animatorset.setDuration(300L);
            animatorset.start();
            return;
        } else
        {
            refreshUIByData(mInfo);
            return;
        }
    }







}
