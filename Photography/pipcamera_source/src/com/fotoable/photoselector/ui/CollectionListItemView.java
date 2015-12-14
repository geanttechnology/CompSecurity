// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.ui;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import fq;
import java.util.ArrayList;
import no;
import nu;

public class CollectionListItemView extends RelativeLayout
    implements no
{

    private static final String TAG = "EncryptItemView";
    private TextView mCollectionCount;
    private ImageView mCollectionCover;
    private TextView mCollectionName;
    private nu mData;
    private fq mImageWorker;

    public CollectionListItemView(Context context, fq fq1)
    {
        super(context);
        if (fq1 == null)
        {
            Log.e("EncryptItemView", "Set empty worker!");
        }
        mImageWorker = fq1;
        ContructView();
    }

    private void ContructView()
    {
        ViewGroup viewgroup = (ViewGroup)View.inflate(getContext(), com.fotoable.fotophotoselector.R.layout.view_listcollectionitem, this);
        mCollectionCover = (ImageView)viewgroup.findViewById(com.fotoable.fotophotoselector.R.id.imageCollectionCover);
        mCollectionName = (TextView)viewgroup.findViewById(com.fotoable.fotophotoselector.R.id.textCollectionName);
        mCollectionCount = (TextView)viewgroup.findViewById(com.fotoable.fotophotoselector.R.id.collectionPhotosCount);
        mCollectionCover.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
    }

    private void refreshView()
    {
        mImageWorker.a(mData, mCollectionCover);
        mCollectionName.setText(mData.a());
        int i = mData.i().size();
        String s = String.format(getContext().getString(com.fotoable.fotophotoselector.R.string.collection_photo_count), new Object[] {
            Integer.valueOf(i)
        });
        mCollectionCount.setText(s);
    }

    public void SetDataItem(nu nu1)
    {
        if (nu1 == null)
        {
            Log.e("EncryptItemView", "Set empty data!");
        } else
        if (nu1 != mData)
        {
            if (mData != null)
            {
                mData.b(this);
            }
            mData = nu1;
            nu1.a(this);
            refreshView();
            return;
        }
    }

    public void onStatusChange(int i, Object obj)
    {
    }
}
