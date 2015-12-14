// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import acm;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import atz;
import awc;
import awg;
import awm;
import axs;
import axt;
import axu;
import bgx;
import com.fotoable.comlib.ui.RecyclingImageView;
import com.fotoable.sketch.info.TTieZhiInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import yp;

public class TTieZhiViewCell extends LinearLayout
{

    private static final String TAG = "TTieZhiViewCell";
    private static Semaphore semp = new Semaphore(1);
    boolean bGroupInfoExist;
    public int downloadCount;
    public int downloadFinishCount;
    public List groupInfos;
    private RecyclingImageView img1;
    private ImageView imgdownload;
    private ImageView imgshare;
    private axt lisener;
    private Context mContext;
    private TTieZhiInfo mInfo;
    atz weChatShare;

    public TTieZhiViewCell(Context context)
    {
        super(context);
        groupInfos = new ArrayList();
        mContext = context;
        initView();
    }

    public TTieZhiViewCell(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        groupInfos = new ArrayList();
        mContext = context;
        initView();
    }

    private void downloadInfo(TTieZhiInfo ttiezhiinfo)
    {
        if (ttiezhiinfo == null)
        {
            return;
        } else
        {
            awc.a().a(ttiezhiinfo, new axs(this));
            return;
        }
    }

    private void goComposeByInfo(TTieZhiInfo ttiezhiinfo)
    {
        if (lisener != null)
        {
            awg.a().a(mInfo.resId);
            lisener.a(awg.a().c(mInfo.resId), true);
        }
    }

    private void groupInfoClicked()
    {
        boolean flag;
        flag = false;
        mInfo.version = "0.0";
        bGroupInfoExist = true;
        if (lisener == null) goto _L2; else goto _L1
_L1:
        int i;
        downloadCount = 0;
        i = 0;
_L13:
        if (i >= mInfo.groupIds.size()) goto _L4; else goto _L3
_L3:
        int l = ((Integer)mInfo.groupIds.get(i)).intValue();
        if (awg.a().b(l)) goto _L6; else goto _L5
_L5:
        TTieZhiInfo ttiezhiinfo = lisener.a(l);
        if (ttiezhiinfo != null) goto _L7; else goto _L2
_L2:
        return;
_L7:
        if (ttiezhiinfo.version != null)
        {
            mInfo.version = bgx.b(mInfo.version, ttiezhiinfo.version);
        }
        downloadCount = downloadCount + 1;
        bGroupInfoExist = false;
_L9:
        groupInfos.add(ttiezhiinfo);
        i++;
        continue; /* Loop/switch isn't completed */
_L6:
        TTieZhiInfo ttiezhiinfo1;
        ttiezhiinfo1 = awg.a().c(l);
        ttiezhiinfo = ttiezhiinfo1;
        if (ttiezhiinfo1 != null) goto _L9; else goto _L8
_L8:
        return;
_L4:
        if (!bGroupInfoExist)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (groupInfos.size() <= 0) goto _L2; else goto _L10
_L10:
        int j = ((flag) ? 1 : 0);
        if (!awg.a().b(mInfo.resId))
        {
            awg.a().b(mInfo);
            j = ((flag) ? 1 : 0);
        }
        for (; j < mInfo.groupIds.size(); j++)
        {
            int k = ((Integer)mInfo.groupIds.get(j)).intValue();
            awg.a().a(k);
        }

        awg.a().a(mInfo.resId);
        lisener.a(groupInfos);
        return;
        if (mContext != null && (new awm(mContext, mInfo)).a()) goto _L2; else goto _L11
_L11:
        startDownloadGroupInfo();
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    private void initView()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300d8, this, true);
        img1 = (RecyclingImageView)findViewById(0x7f0d029f);
        imgdownload = (ImageView)findViewById(0x7f0d02a0);
        imgdownload.setImageResource(0x7f0202a1);
        imgshare = (ImageView)findViewById(0x7f0d02a1);
        imgshare.setImageResource(0x7f0203fa);
        img1.setOnClickListener(new axu(this, null));
        weChatShare = new atz(getContext());
    }

    private boolean isGroupInfoExist()
    {
        if (lisener == null || !mInfo.isGroupEnable || mInfo.groupIds == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L5:
        int j;
        if (i >= mInfo.groupIds.size())
        {
            break; /* Loop/switch isn't completed */
        }
        j = ((Integer)mInfo.groupIds.get(i)).intValue();
        if (awg.a().b(j)) goto _L3; else goto _L2
_L2:
        return false;
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        return true;
    }

    private void startDownloadGroupInfo()
    {
        if (groupInfos.size() > 0)
        {
            for (int i = 0; i < groupInfos.size(); i++)
            {
                TTieZhiInfo ttiezhiinfo = (TTieZhiInfo)groupInfos.get(i);
                if (ttiezhiinfo != null && !awg.a().b(ttiezhiinfo.resId))
                {
                    downloadInfo(ttiezhiinfo);
                }
            }

        }
    }

    public void SetDataInfo(TTieZhiInfo ttiezhiinfo)
    {
        mInfo = ttiezhiinfo;
        groupInfos.clear();
        downloadFinishCount = 0;
        refreshUIByData(ttiezhiinfo);
    }

    public TTieZhiInfo getDataItem()
    {
        return mInfo;
    }

    public RecyclingImageView getImageView()
    {
        return img1;
    }

    public void refreshUIByData(TTieZhiInfo ttiezhiinfo)
    {
        if (ttiezhiinfo == null)
        {
            return;
        }
        if (awg.a().b(ttiezhiinfo.resId) || isGroupInfoExist())
        {
            if (ttiezhiinfo.isGroupEnable && !awg.a().b(ttiezhiinfo.resId))
            {
                awg.a().b(ttiezhiinfo);
            }
            imgdownload.setVisibility(4);
            imgshare.setVisibility(4);
            return;
        }
        imgdownload.setVisibility(4);
        boolean flag;
        if (ttiezhiinfo.otherAppStoreId != null && !ttiezhiinfo.otherAppStoreId.equalsIgnoreCase("null") && ttiezhiinfo.otherAppStoreId.length() > 4 && !yp.a(getContext(), ttiezhiinfo.otherAppStoreId))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            imgshare.setImageResource(0x7f0203a3);
            imgshare.setVisibility(0);
            return;
        }
        if (ttiezhiinfo.needReviewing && !acm.c())
        {
            imgshare.setVisibility(0);
            imgshare.setImageResource(0x7f0202a9);
            return;
        }
        if (mInfo.needSharing && !ttiezhiinfo.hasSharedInfo() && ttiezhiinfo.wxdlShareInfo != null && weChatShare.b())
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

    public void setItemClickLisener(axt axt1)
    {
        lisener = axt1;
    }









}
