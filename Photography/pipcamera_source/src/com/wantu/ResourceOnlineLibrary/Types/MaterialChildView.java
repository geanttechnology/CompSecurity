// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.Types;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import fr;
import uf;
import uj;

public class MaterialChildView extends LinearLayout
{

    private static final String TAG = "MaterialChildView";
    private ImageView btnNewMaterial;
    private uj mData;
    private uf mDelegate;
    private ImageView mImage;
    private fr mImageWorker;
    private TextView mMaterialTypeName;

    public MaterialChildView(Context context, fr fr1)
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
        ViewGroup viewgroup = (ViewGroup)View.inflate(getContext(), 0x7f030057, this);
        mImage = (ImageView)viewgroup.findViewById(0x7f0c018c);
        mMaterialTypeName = (TextView)viewgroup.findViewById(0x7f0c018d);
        btnNewMaterial = (ImageView)viewgroup.findViewById(0x7f0c018e);
        mImage.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
    }

    public void SetDataItem(uj uj1)
    {
        if (uj1 == null)
        {
            Log.e("MaterialChildView", "Set empty data!");
        } else
        if (uj1 != mData)
        {
            mData = uj1;
            mImageWorker.a(mData, mImage);
            if (mData.e > 0)
            {
                mMaterialTypeName.setText((new StringBuilder()).append(mData.b).append(" (").append(mData.e).append(")").toString());
            } else
            {
                mMaterialTypeName.setText((new StringBuilder()).append(mData.b).append("(0)").toString());
            }
            btnNewMaterial.setVisibility(4);
            return;
        }
    }

    public uf getmDelegate()
    {
        return mDelegate;
    }

    public void refresh()
    {
        SetDataItem(mData);
    }

    public void setmDelegate(uf uf)
    {
        mDelegate = uf;
    }
}
