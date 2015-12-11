// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.content.Context;
import android.net.Uri;
import com.ebay.mobile.photomanager.android.CropImageView;
import com.ebay.nautilus.shell.content.FwLoader;

public class SaveImageLoader extends FwLoader
{

    private CropImageView cropImageView;
    private Uri savedImage;

    public SaveImageLoader(Context context, CropImageView cropimageview)
    {
        super(context);
        cropImageView = cropimageview;
    }

    protected void doInBackground()
    {
        savedImage = cropImageView.save();
    }

    public Uri getSavedImage()
    {
        return savedImage;
    }
}
