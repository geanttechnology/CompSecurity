// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.activity;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.wantu.model.res.TResInfo;
import fr;
import um;

public class ResItemView extends LinearLayout
{

    private static final String TAG = "ResItemView";
    private Button btnDownload;
    private TResInfo mData;
    private um mDelegate;
    private ImageView mImage;
    private fr mImageWorker;

    public ResItemView(Context context, fr fr1)
    {
        super(context);
        if (fr1 == null)
        {
            Log.e("ResItemView", "Set empty worker!");
        }
        mImageWorker = fr1;
        ContructView();
    }

    private void ContructView()
    {
        ViewGroup viewgroup = (ViewGroup)View.inflate(getContext(), 0x7f03007c, this);
        mImage = (ImageView)viewgroup.findViewById(0x7f0c0127);
        mImage.setOnClickListener(new android.view.View.OnClickListener() {

            final ResItemView a;

            public void onClick(View view)
            {
                if (a.mDelegate != null && a.mData != null)
                {
                    a.mDelegate.c(a.mData);
                }
            }

            
            {
                a = ResItemView.this;
                super();
            }
        });
        btnDownload = (Button)viewgroup.findViewById(0x7f0c022a);
        btnDownload.setOnClickListener(new android.view.View.OnClickListener() {

            final ResItemView a;

            public void onClick(View view)
            {
                if (a.mDelegate != null)
                {
                    a.mDelegate.c(view.getTag());
                }
            }

            
            {
                a = ResItemView.this;
                super();
            }
        });
        mImage.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
    }

    public void SetDataItem(TResInfo tresinfo)
    {
        if (tresinfo == null)
        {
            Log.e("ResItemView", "Set empty data!");
        } else
        if (tresinfo != mData)
        {
            mData = tresinfo;
            mImageWorker.a(mData, mImage);
            btnDownload.setTag(tresinfo);
            return;
        }
    }

    public um getmDelegate()
    {
        return mDelegate;
    }

    public void setmDelegate(um um)
    {
        mDelegate = um;
    }


}
