// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.model.res.TResInfo;
import ew;
import fr;
import java.util.List;
import kf;
import qh;
import qt;

public class TMaterialTypeView extends LinearLayout
{

    private static final String TAG = "MaterialChildView";
    private qt mData;
    private qh mDelegate;
    private ImageView mImage;
    private fr mImageWorker;
    private TextView mMaterialTypeName;
    private TextView mtvNum;

    public TMaterialTypeView(Context context, fr fr1)
    {
        super(context);
        if (fr1 == null)
        {
            Log.e("MaterialChildView", "Set empty worker!");
        }
        mImageWorker = fr1;
        ContructView();
    }

    private void ContructView()
    {
        ViewGroup viewgroup = (ViewGroup)View.inflate(getContext(), 0x7f03005a, this);
        mImage = (ImageView)viewgroup.findViewById(0x7f0c018c);
        mMaterialTypeName = (TextView)viewgroup.findViewById(0x7f0c018d);
        mtvNum = (TextView)viewgroup.findViewById(0x7f0c0192);
        mImage.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
    }

    public void SetDataItem(qt qt1)
    {
        if (qt1 == null)
        {
            Log.e("MaterialChildView", "Set empty data!");
            return;
        }
        mData = qt1;
        mImageWorker.a(mData, mImage);
        if (ew.b())
        {
            qt1 = mData.a;
        } else
        if (ew.c())
        {
            qt1 = mData.b;
        } else
        {
            qt1 = mData.c;
        }
        mMaterialTypeName.setText(qt1);
        mtvNum.setText(String.valueOf(getUndownloadCount()));
    }

    public TPhotoMagComposeManager getComposeManager()
    {
        return kf.c().e();
    }

    public qt getListInfo()
    {
        return mData;
    }

    public int getUndownloadCount()
    {
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (mData.f != null)
        {
            i = ((flag) ? 1 : 0);
            if (mData.f.size() > 0)
            {
                int j = 0;
                int k;
                for (i = 0; j < mData.f.size(); i = k)
                {
                    TResInfo tresinfo = (TResInfo)mData.f.get(j);
                    k = i;
                    if (!getComposeManager().isExistedByResId(tresinfo.resId))
                    {
                        k = i + 1;
                    }
                    j++;
                }

            }
        }
        return i;
    }

    public qh getmDelegate()
    {
        return mDelegate;
    }

    public void refresh()
    {
        SetDataItem(mData);
    }

    public void setmDelegate(qh qh)
    {
        mDelegate = qh;
    }
}
