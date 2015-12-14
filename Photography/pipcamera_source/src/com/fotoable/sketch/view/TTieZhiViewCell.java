// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.fotoable.comlib.ui.RecyclingImageView;
import com.fotoable.sketch.info.TTieZhiInfo;
import ew;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import of;
import ol;
import om;
import oo;
import oy;
import oz;
import sb;
import ub;
import uc;

public class TTieZhiViewCell extends LinearLayout
{

    private static final String TAG = "TTieZhiViewCell";
    private static Semaphore semp = new Semaphore(1);
    boolean bGroupInfoExist;
    int downloadCount;
    int downloadFinishCount;
    List groupInfos;
    private RecyclingImageView img1;
    private ImageView imgdownload;
    private ImageView imgshare;
    private oy lisener;
    private Context mContext;
    private TTieZhiInfo mInfo;
    of weChatShare;

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
            ol.a().a(ttiezhiinfo, new om() {

                final TTieZhiViewCell a;

                public void a(TTieZhiInfo ttiezhiinfo1)
                {
                    if (a.lisener != null)
                    {
                        a.lisener.a();
                    }
                }

                public void a(TTieZhiInfo ttiezhiinfo1, float f)
                {
                }

                public void b(TTieZhiInfo ttiezhiinfo1)
                {
label0:
                    {
                        a.imgdownload.setVisibility(4);
                        if (ttiezhiinfo1 != null)
                        {
                            oo.a().b(ttiezhiinfo1);
                            if (!a.mInfo.isGroupEnable)
                            {
                                break label0;
                            }
                            try
                            {
                                TTieZhiViewCell.semp.acquire();
                                ttiezhiinfo1 = a;
                                ttiezhiinfo1.downloadFinishCount = ((TTieZhiViewCell) (ttiezhiinfo1)).downloadFinishCount + 1;
                                TTieZhiViewCell.semp.release();
                            }
                            // Misplaced declaration of an exception variable
                            catch (TTieZhiInfo ttiezhiinfo1)
                            {
                                ttiezhiinfo1.printStackTrace();
                            }
                            if (a.downloadFinishCount >= a.downloadCount)
                            {
                                oo.a().b(a.mInfo);
                                if (a.lisener != null)
                                {
                                    for (int i = 0; i < a.mInfo.groupIds.size(); i++)
                                    {
                                        int j = ((Integer)a.mInfo.groupIds.get(i)).intValue();
                                        oo.a().a(j);
                                    }

                                    oo.a().a(a.mInfo.resId);
                                    a.lisener.a(a.groupInfos);
                                    a.lisener.a(false);
                                }
                            }
                        }
                        return;
                    }
                    if (a.lisener != null)
                    {
                        a.lisener.a(false);
                    }
                    a.goComposeByInfo(ttiezhiinfo1);
                }

                public void c(TTieZhiInfo ttiezhiinfo1)
                {
                    if (a.lisener != null)
                    {
                        a.lisener.b(false);
                    }
                }

            
            {
                a = TTieZhiViewCell.this;
                super();
            }
            });
            return;
        }
    }

    private void goComposeByInfo(TTieZhiInfo ttiezhiinfo)
    {
        if (lisener != null)
        {
            oo.a().a(mInfo.resId);
            lisener.a(oo.a().c(mInfo.resId), true);
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
        if (oo.a().b(l)) goto _L6; else goto _L5
_L5:
        TTieZhiInfo ttiezhiinfo = lisener.a(l);
        if (ttiezhiinfo != null) goto _L7; else goto _L2
_L2:
        return;
_L7:
        if (ttiezhiinfo.version != null)
        {
            mInfo.version = uc.a(mInfo.version, ttiezhiinfo.version);
        }
        downloadCount = downloadCount + 1;
        bGroupInfoExist = false;
_L9:
        groupInfos.add(ttiezhiinfo);
        i++;
        continue; /* Loop/switch isn't completed */
_L6:
        TTieZhiInfo ttiezhiinfo1;
        ttiezhiinfo1 = oo.a().c(l);
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
        if (!oo.a().b(mInfo.resId))
        {
            oo.a().b(mInfo);
            j = ((flag) ? 1 : 0);
        }
        for (; j < mInfo.groupIds.size(); j++)
        {
            int k = ((Integer)mInfo.groupIds.get(j)).intValue();
            oo.a().a(k);
        }

        oo.a().a(mInfo.resId);
        lisener.a(groupInfos);
        return;
        if (mContext != null && (new ub(mContext, mInfo)).a()) goto _L2; else goto _L11
_L11:
        startDownloadGroupInfo();
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    private void initView()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030098, this, true);
        img1 = (RecyclingImageView)findViewById(0x7f0c0178);
        imgdownload = (ImageView)findViewById(0x7f0c0179);
        imgdownload.setImageResource(0x7f02018c);
        imgshare = (ImageView)findViewById(0x7f0c0049);
        imgshare.setImageResource(0x7f020262);
        img1.setOnClickListener(new oz(this));
        weChatShare = new of(getContext());
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
        if (oo.a().b(j)) goto _L3; else goto _L2
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
                if (ttiezhiinfo != null && !oo.a().b(ttiezhiinfo.resId))
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
        if (oo.a().b(ttiezhiinfo.resId) || isGroupInfoExist())
        {
            if (ttiezhiinfo.isGroupEnable && !oo.a().b(ttiezhiinfo.resId))
            {
                oo.a().b(ttiezhiinfo);
            }
            imgdownload.setVisibility(4);
            imgshare.setVisibility(4);
            return;
        }
        imgdownload.setVisibility(4);
        boolean flag;
        if (ttiezhiinfo.otherAppStoreId != null && !ttiezhiinfo.otherAppStoreId.equalsIgnoreCase("null") && ttiezhiinfo.otherAppStoreId.length() > 4 && !ew.a(getContext(), ttiezhiinfo.otherAppStoreId))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            imgshare.setImageResource(0x7f020234);
            imgshare.setVisibility(0);
            return;
        }
        if (ttiezhiinfo.needReviewing && !sb.c())
        {
            imgshare.setVisibility(0);
            imgshare.setImageResource(0x7f020190);
            return;
        }
        if (mInfo.needSharing && !ttiezhiinfo.hasSharedInfo() && ttiezhiinfo.wxdlShareInfo != null && weChatShare.b())
        {
            imgshare.setImageResource(0x7f020262);
            imgshare.setVisibility(0);
            return;
        } else
        {
            imgdownload.setVisibility(0);
            imgshare.setVisibility(4);
            return;
        }
    }

    public void setItemClickLisener(oy oy1)
    {
        lisener = oy1;
    }









}
