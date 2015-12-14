// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.os.AsyncTask;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.edmodo.cropper.CropImageView;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            CropImageActivity

class a extends AsyncTask
{

    final CropImageActivity a;

    protected transient Void a(Void avoid[])
    {
        CropImageActivity.a(a, CropImageActivity.c(a).getCroppedImage());
        if (CropImageActivity.d(a) == 48135 || CropImageActivity.d(a) == 48132)
        {
            avoid = NetworkFile.a(CropImageActivity.e(a), CropImageActivity.f(a).compressSetting);
            CropImageActivity.a(a, avoid);
        } else
        {
            CropImageActivity.a(a, -1, CropImageActivity.e(a));
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    (CropImageActivity cropimageactivity)
    {
        a = cropimageactivity;
        super();
    }
}
