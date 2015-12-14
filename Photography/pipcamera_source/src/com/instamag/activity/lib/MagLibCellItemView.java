// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.ui.RecyclingImageView;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.model.res.TResInfo;
import fr;
import java.util.ArrayList;
import java.util.Iterator;
import jc;
import qm;
import qn;
import qp;
import qq;

public class MagLibCellItemView extends FrameLayout
{

    private static final String TAG = "MagLibCellItemView";
    FrameLayout cellLayout;
    RecyclingImageView img1;
    RecyclingImageView img2;
    RecyclingImageView img3;
    RecyclingImageView img_native;
    public qn lisener;
    FrameLayout ly1;
    FrameLayout ly2;
    FrameLayout ly3;
    FrameLayout ly_native;
    private qq mCellItem;
    public Context mContext;
    private fr mImageWorker;
    ImageView tipView1;
    ImageView tipView2;
    ImageView tipView3;
    TextView title_native;

    public MagLibCellItemView(Context context)
    {
        super(context);
        mContext = context;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030053, this, true);
        cellLayout = (FrameLayout)findViewById(0x7f0c0176);
        ly1 = (FrameLayout)findViewById(0x7f0c0177);
        ly2 = (FrameLayout)findViewById(0x7f0c017c);
        ly3 = (FrameLayout)findViewById(0x7f0c017f);
        img1 = (RecyclingImageView)findViewById(0x7f0c017a);
        img2 = (RecyclingImageView)findViewById(0x7f0c017d);
        img3 = (RecyclingImageView)findViewById(0x7f0c0180);
        tipView1 = (ImageView)findViewById(0x7f0c017b);
        tipView1.setVisibility(4);
        tipView2 = (ImageView)findViewById(0x7f0c017e);
        tipView2.setVisibility(4);
        tipView3 = (ImageView)findViewById(0x7f0c0181);
        tipView3.setVisibility(4);
        img1.setOnClickListener(new qm(this, img1));
        img2.setOnClickListener(new qm(this, img2));
        img3.setOnClickListener(new qm(this, img3));
        ly_native = (FrameLayout)findViewById(0x7f0c0182);
        img_native = (RecyclingImageView)findViewById(0x7f0c0183);
        title_native = (TextView)findViewById(0x7f0c0185);
        img_native.setClickable(false);
    }

    private void handleFbNativeView(TResInfo tresinfo, int i)
    {
        if (mCellItem == null || mCellItem.e == null) goto _L2; else goto _L1
_L1:
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)ly_native.getLayoutParams();
        i;
        JVM INSTR tableswitch 0 2: default 436
    //                   0 133
    //                   1 222
    //                   2 307;
           goto _L3 _L4 _L5 _L6
_L3:
        android.view.ViewGroup.LayoutParams layoutparams1;
        try
        {
            ly_native.setVisibility(0);
            if (mCellItem.e != null)
            {
                mCellItem.e.a(ly_native);
                title_native.setVisibility(0);
                title_native.setText(mCellItem.e.a());
                if (mImageWorker != null)
                {
                    mImageWorker.a(tresinfo, img_native);
                    return;
                }
            }
        }
        // Misplaced declaration of an exception variable
        catch (TResInfo tresinfo)
        {
            Crashlytics.logException(tresinfo);
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        ly1.setVisibility(4);
        layoutparams.leftMargin = qp.a();
        layoutparams.width = qp.a(mContext);
        layoutparams.height = qp.a(InstaMagType.RECT_LIB_SIZE_TYPE);
        ly_native.setLayoutParams(layoutparams);
        layoutparams1 = img_native.getLayoutParams();
        layoutparams1.width = layoutparams.width;
        layoutparams1.height = layoutparams.height;
        img_native.setLayoutParams(layoutparams1);
        continue; /* Loop/switch isn't completed */
_L5:
        layoutparams.leftMargin = qp.a() * 2 + qp.a(mContext);
        layoutparams.width = qp.a(mContext);
        layoutparams.height = qp.a(InstaMagType.RECT_LIB_SIZE_TYPE);
        ly_native.setLayoutParams(layoutparams);
        android.view.ViewGroup.LayoutParams layoutparams2 = img_native.getLayoutParams();
        layoutparams2.width = layoutparams.width;
        layoutparams2.height = layoutparams.height;
        img_native.setLayoutParams(layoutparams2);
        continue; /* Loop/switch isn't completed */
_L6:
        layoutparams.leftMargin = qp.a() * 3 + qp.a(mContext) * 2;
        layoutparams.width = qp.a(mContext);
        layoutparams.height = qp.a(InstaMagType.RECT_LIB_SIZE_TYPE);
        ly_native.setLayoutParams(layoutparams);
        android.view.ViewGroup.LayoutParams layoutparams3 = img_native.getLayoutParams();
        layoutparams3.width = layoutparams.width;
        layoutparams3.height = layoutparams.height;
        img_native.setLayoutParams(layoutparams3);
        if (true) goto _L3; else goto _L7
_L8:
        ly_native.setVisibility(4);
        return;
_L9:
        ly1.setVisibility(0);
          goto _L8
_L10:
        ly2.setVisibility(0);
          goto _L8
_L11:
        ly3.setVisibility(0);
          goto _L8
_L7:
        return;
_L2:
        i;
        JVM INSTR tableswitch 0 2: default 468
    //                   0 403
    //                   1 414
    //                   2 425;
           goto _L8 _L9 _L10 _L11
    }

    private void handleTipView(TResInfo tresinfo, ImageView imageview)
    {
        if (tresinfo == null || imageview == null)
        {
            return;
        }
        if (tresinfo.resId == TPhotoMagComposeManager.KFBNATIVEID && isNativeLoaded())
        {
            imageview.setVisibility(4);
            return;
        }
        if (tresinfo.resId < TPhotoMagComposeManager.KMAXADRESID)
        {
            imageview.setBackgroundResource(0x7f020045);
            imageview.setVisibility(0);
            return;
        } else
        {
            imageview.setVisibility(4);
            return;
        }
    }

    private boolean isNativeLoaded()
    {
        return mCellItem != null && mCellItem.e != null;
    }

    private void onADResClicked(int i)
    {
        if (lisener != null)
        {
            lisener.a(i);
        }
    }

    private void resetLayout(FrameLayout framelayout, InstaMagType instamagtype)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)framelayout.getLayoutParams();
        if (framelayout == ly1)
        {
            layoutparams.leftMargin = qp.a();
            layoutparams.width = qp.a(mContext);
            layoutparams.height = qp.a(instamagtype);
            framelayout.setLayoutParams(layoutparams);
            framelayout = img1.getLayoutParams();
            framelayout.width = layoutparams.width;
            framelayout.height = layoutparams.height;
            img1.setLayoutParams(framelayout);
        } else
        {
            if (framelayout == ly2)
            {
                layoutparams.leftMargin = qp.a() * 2 + qp.a(mContext);
                layoutparams.width = qp.a(mContext);
                layoutparams.height = qp.a(instamagtype);
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
                layoutparams.leftMargin = qp.a() * 3 + qp.a(mContext) * 2;
                layoutparams.width = qp.a(mContext);
                layoutparams.height = qp.a(instamagtype);
                framelayout.setLayoutParams(layoutparams);
                framelayout = img3.getLayoutParams();
                framelayout.width = layoutparams.width;
                framelayout.height = layoutparams.height;
                img3.setLayoutParams(framelayout);
                return;
            }
        }
    }

    public void SetDataItem(qq qq1, fr fr1)
    {
        mImageWorker = fr1;
        if (qq1 != null) goto _L2; else goto _L1
_L1:
        Log.e("MagLibCellItemView", "Set empty data!");
_L4:
        return;
_L2:
        if (qq1.equals(mCellItem)) goto _L4; else goto _L3
_L3:
        mCellItem = qq1;
        if (mCellItem.d == null) goto _L4; else goto _L5
_L5:
        ly_native.setVisibility(4);
        qq1 = (android.widget.FrameLayout.LayoutParams)cellLayout.getLayoutParams();
        qq1.height = qp.a(mCellItem.d) + qp.a();
        cellLayout.setLayoutParams(qq1);
        mCellItem.d.size();
        JVM INSTR tableswitch 1 3: default 128
    //                   1 185
    //                   2 314
    //                   3 484;
           goto _L6 _L7 _L8 _L9
_L6:
        int i;
        fr1 = mCellItem.d.iterator();
        i = 0;
_L12:
        if (!fr1.hasNext())
        {
            break MISSING_BLOCK_LABEL_716;
        }
        qq1 = (TResInfo)fr1.next();
        if (qq1 == null || ((TResInfo) (qq1)).resId != TPhotoMagComposeManager.KFBNATIVEID) goto _L11; else goto _L10
_L10:
        if (qq1 != null)
        {
            handleFbNativeView(qq1, i);
            return;
        }
          goto _L4
_L7:
        resetLayout(ly2, InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
        resetLayout(ly3, InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
        ly3.setVisibility(4);
        ly2.setVisibility(4);
        fr.a(img2);
        fr.a(img3);
        ly1.setVisibility(0);
        qq1 = (TResInfo)mCellItem.d.get(0);
        resetLayout(ly1, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)qq1));
        fr.a(img1);
        mImageWorker.a(qq1, img1);
        img1.setTag(qq1);
        handleTipView(qq1, tipView1);
          goto _L6
_L8:
        resetLayout(ly3, InstaMagType.LANDSCAPE_LIB_SIZE_TYPE);
        ly3.setVisibility(4);
        ly1.setVisibility(0);
        qq1 = (TResInfo)mCellItem.d.get(0);
        resetLayout(ly1, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)qq1));
        fr.a(img1);
        mImageWorker.a(qq1, img1);
        img1.setTag(qq1);
        handleTipView(qq1, tipView1);
        ly2.setVisibility(0);
        fr.a(img2);
        qq1 = (TResInfo)mCellItem.d.get(1);
        mImageWorker.a(qq1, img2);
        resetLayout(ly2, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)qq1));
        img2.setTag(qq1);
        handleTipView(qq1, tipView2);
          goto _L6
_L9:
        ly1.setVisibility(0);
        qq1 = (TResInfo)mCellItem.d.get(0);
        resetLayout(ly1, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)qq1));
        fr.a(img1);
        mImageWorker.a(qq1, img1);
        img1.setTag(qq1);
        handleTipView(qq1, tipView1);
        qq1 = (TResInfo)mCellItem.d.get(1);
        fr.a(img2);
        mImageWorker.a(qq1, img2);
        resetLayout(ly2, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)qq1));
        ly2.setVisibility(0);
        img2.setTag(qq1);
        handleTipView(qq1, tipView2);
        qq1 = (TResInfo)mCellItem.d.get(2);
        fr.a(img3);
        mImageWorker.a(qq1, img3);
        resetLayout(ly3, TPhotoComposeInfo.getInstaMagType((TPhotoComposeInfo)qq1));
        ly3.setVisibility(0);
        img3.setTag(qq1);
        handleTipView(qq1, tipView3);
          goto _L6
_L11:
        i++;
          goto _L12
        qq1 = null;
          goto _L10
    }

    public void setImageWorker(fr fr1)
    {
        mImageWorker = fr1;
    }

    public void setMagLibCellClickedLisener(qn qn1)
    {
        lisener = qn1;
    }

}
