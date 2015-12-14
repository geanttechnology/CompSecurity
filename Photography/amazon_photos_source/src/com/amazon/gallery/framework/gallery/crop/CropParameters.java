// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.crop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import org.apache.commons.lang3.StringUtils;

public class CropParameters
{

    private final int aspectX;
    private final int aspectY;
    private final android.graphics.Bitmap.CompressFormat compressFormat;
    private final Uri imageUri;
    private final boolean isCircleCrop;
    private final boolean isReturningUri;
    private final Uri outputUri;
    private final int outputX;
    private final int outputY;

    public CropParameters(Intent intent)
    {
        boolean flag = true;
        super();
        imageUri = intent.getData();
        outputX = intent.getIntExtra("outputX", 0);
        outputY = intent.getIntExtra("outputY", 0);
        aspectX = intent.getIntExtra("aspectX", 1);
        aspectY = intent.getIntExtra("aspectY", 1);
        isCircleCrop = intent.getBooleanExtra("circleCrop", false);
        Object obj;
        if (intent.getBooleanExtra("return-data", false))
        {
            flag = false;
        }
        isReturningUri = flag;
        obj = intent.getExtras().get("output");
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = Uri.parse(obj.toString());
        }
        outputUri = ((Uri) (obj));
        compressFormat = compressFormatFromIntent(intent);
    }

    private android.graphics.Bitmap.CompressFormat compressFormatFromIntent(Intent intent)
    {
        if (StringUtils.equalsIgnoreCase(intent.getStringExtra("outputFormat"), "png"))
        {
            return android.graphics.Bitmap.CompressFormat.PNG;
        } else
        {
            return android.graphics.Bitmap.CompressFormat.JPEG;
        }
    }

    public int getAspectX()
    {
        return aspectX;
    }

    public int getAspectY()
    {
        return aspectY;
    }

    public android.graphics.Bitmap.CompressFormat getCompressFormat()
    {
        return compressFormat;
    }

    public Uri getImageUri()
    {
        return imageUri;
    }

    public Uri getOutputUri()
    {
        return outputUri;
    }

    public int getOutputX()
    {
        return outputX;
    }

    public int getOutputY()
    {
        return outputY;
    }

    public boolean isCircleCrop()
    {
        return isCircleCrop;
    }

    public boolean isReturningUri()
    {
        return isReturningUri;
    }
}
