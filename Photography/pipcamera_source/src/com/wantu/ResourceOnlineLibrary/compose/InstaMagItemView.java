// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.compose;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TResInfo;
import fr;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.compose:
//            InstaMagType, TPhotoComposeInfo

public class InstaMagItemView extends LinearLayout
{

    private static final String TAG = "InstaMagItemView";
    private boolean bShowNew;
    private InstaMagType instatype;
    private TResInfo mData;
    private ImageView mImage;
    private fr mImageWorker;
    private ImageView newStyle;
    private TextView txtNameView;

    public InstaMagItemView(Context context, fr fr1)
    {
        super(context);
        bShowNew = false;
        instatype = InstaMagType.RECT_LIB_SIZE_TYPE;
        if (fr1 == null)
        {
            Log.e("InstaMagItemView", "Set empty worker!");
        }
        mImageWorker = fr1;
        ContructView(InstaMagType.RECT_LIB_SIZE_TYPE);
    }

    public InstaMagItemView(Context context, fr fr1, InstaMagType instamagtype)
    {
        super(context);
        bShowNew = false;
        instatype = InstaMagType.RECT_LIB_SIZE_TYPE;
        if (fr1 == null)
        {
            Log.e("InstaMagItemView", "Set empty worker!");
        }
        mImageWorker = fr1;
        ContructView(instamagtype);
        instatype = instamagtype;
    }

    private void ContructView(InstaMagType instamagtype)
    {
        instamagtype = (ViewGroup)View.inflate(getContext(), 0x7f030049, this);
        mImage = (ImageView)instamagtype.findViewById(0x7f0c0127);
        newStyle = (ImageView)instamagtype.findViewById(0x7f0c0151);
        mImage.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
    }

    public void SetDataItem(TResInfo tresinfo)
    {
        if (tresinfo == null)
        {
            Log.e("InstaMagItemView", "Set empty data!");
        } else
        if (tresinfo != mData)
        {
            mData = tresinfo;
            if (tresinfo.icon != null)
            {
                mImageWorker.a(mData, mImage);
            }
            mImage.setTag(mData);
            if (mData != null)
            {
                if (mData.name == null);
            }
            if ((mData instanceof TPhotoComposeInfo) && bShowNew)
            {
                int i = ((TPhotoComposeInfo)mData).useCount;
                tresinfo = ((TPhotoComposeInfo)mData).getResType();
                if (tresinfo != null && tresinfo == EResType.NETWORK && i == 0)
                {
                    newStyle.setVisibility(0);
                } else
                {
                    newStyle.setVisibility(4);
                }
                if (PIPCameraApplication.a())
                {
                    newStyle.setVisibility(4);
                    return;
                }
            }
        }
    }

    public InstaMagType getCurrentInstaMag()
    {
        return instatype;
    }

    public int getImageViewHeightByType(InstaMagType instamagtype)
    {
        int j = getImgaeViewWidth();
        int i;
        if (instamagtype == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            i = (int)(((float)j / 2.0F) * 3F);
        } else
        {
            if (instamagtype == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
            {
                return (int)(((float)j / 320F) * 214F);
            }
            i = j;
            if (instamagtype != InstaMagType.SQ_LIB_SIZE_TYPE)
            {
                if (instamagtype == InstaMagType.LINK_LIB_SIZE_TYPE)
                {
                    return (int)(((float)j / 2.0F) * 3F);
                } else
                {
                    return 0;
                }
            }
        }
        return i;
    }

    public int getImgaeViewWidth()
    {
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        return (int)((float)displaymetrics.widthPixels - displaymetrics.density * 90F) / 2;
    }

    public InstaMagType getInstaMagType(TPhotoComposeInfo tphotocomposeinfo)
    {
        InstaMagType instamagtype1 = InstaMagType.RECT_LIB_SIZE_TYPE;
        InstaMagType instamagtype;
        if (tphotocomposeinfo.width == 320F && tphotocomposeinfo.height == 480F)
        {
            instamagtype = InstaMagType.RECT_LIB_SIZE_TYPE;
        } else
        {
            if (tphotocomposeinfo.width == 320F && tphotocomposeinfo.height == 320F)
            {
                return InstaMagType.SQ_LIB_SIZE_TYPE;
            }
            instamagtype = instamagtype1;
            if (tphotocomposeinfo.width == 320F)
            {
                instamagtype = instamagtype1;
                if (tphotocomposeinfo.height == 214F)
                {
                    return InstaMagType.LANDSCAPE_LIB_SIZE_TYPE;
                }
            }
        }
        return instamagtype;
    }

    public TResInfo getItemData()
    {
        return mData;
    }

    public int getItemViewHeightByType(InstaMagType instamagtype)
    {
        return getImageViewHeightByType(instamagtype) + getResources().getDimensionPixelSize(0x7f080044);
    }

    public void resetLayout()
    {
        if (mImage != null && mData != null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = mImage.getLayoutParams();
            if (layoutparams != null)
            {
                layoutparams.width = getImgaeViewWidth();
                layoutparams.height = getImageViewHeightByType(getInstaMagType((TPhotoComposeInfo)mData));
                mImage.setLayoutParams(layoutparams);
            }
        }
    }

    public void setShowNew(boolean flag)
    {
        bShowNew = flag;
    }
}
