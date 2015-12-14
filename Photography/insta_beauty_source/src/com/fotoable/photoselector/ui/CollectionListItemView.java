// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.ui;

import aeh;
import aei;
import aej;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import asr;
import ata;
import java.util.ArrayList;
import zt;

public class CollectionListItemView extends RelativeLayout
    implements asr
{

    private static final String TAG = "EncryptItemView";
    private TextView mCollectionCount;
    private ImageView mCollectionCover;
    private TextView mCollectionName;
    private ata mData;
    private zt mImageWorker;

    public CollectionListItemView(Context context, zt zt1)
    {
        super(context);
        if (zt1 == null)
        {
            Log.e("EncryptItemView", "Set empty worker!");
        }
        mImageWorker = zt1;
        ContructView();
    }

    private void ContructView()
    {
        ViewGroup viewgroup = (ViewGroup)View.inflate(getContext(), aei.view_listcollectionitem, this);
        mCollectionCover = (ImageView)viewgroup.findViewById(aeh.imageCollectionCover);
        mCollectionName = (TextView)viewgroup.findViewById(aeh.textCollectionName);
        mCollectionCount = (TextView)viewgroup.findViewById(aeh.collectionPhotosCount);
        mCollectionCover.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
    }

    private void refreshView()
    {
        mImageWorker.a(mData, mCollectionCover);
        mCollectionName.setText(mData.a());
        int i = mData.i().size();
        String s = String.format(getContext().getString(aej.collection_photo_count), new Object[] {
            Integer.valueOf(i)
        });
        mCollectionCount.setText(s);
    }

    public void SetDataItem(ata ata1)
    {
        if (ata1 == null)
        {
            Log.e("EncryptItemView", "Set empty data!");
        } else
        if (ata1 != mData)
        {
            if (mData != null)
            {
                mData.b(this);
            }
            mData = ata1;
            ata1.a(this);
            refreshView();
            return;
        }
    }

    public void onStatusChange(int i, Object obj)
    {
    }
}
