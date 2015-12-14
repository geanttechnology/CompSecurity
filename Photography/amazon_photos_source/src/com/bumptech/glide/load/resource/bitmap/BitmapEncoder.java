// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.OutputStream;

public class BitmapEncoder
    implements ResourceEncoder
{

    private android.graphics.Bitmap.CompressFormat compressFormat;
    private int quality;

    public BitmapEncoder()
    {
        this(null, 90);
    }

    public BitmapEncoder(android.graphics.Bitmap.CompressFormat compressformat, int i)
    {
        compressFormat = compressformat;
        quality = i;
    }

    private android.graphics.Bitmap.CompressFormat getFormat(Bitmap bitmap)
    {
        if (compressFormat != null)
        {
            return compressFormat;
        }
        if (bitmap.hasAlpha())
        {
            return android.graphics.Bitmap.CompressFormat.PNG;
        } else
        {
            return android.graphics.Bitmap.CompressFormat.JPEG;
        }
    }

    public boolean encode(Resource resource, OutputStream outputstream)
    {
        resource = (Bitmap)resource.get();
        long l = LogTime.getLogTime();
        android.graphics.Bitmap.CompressFormat compressformat = getFormat(resource);
        resource.compress(compressformat, quality, outputstream);
        if (Log.isLoggable("BitmapEncoder", 2))
        {
            Log.v("BitmapEncoder", (new StringBuilder()).append("Compressed with type: ").append(compressformat).append(" of size ").append(Util.getBitmapByteSize(resource)).append(" in ").append(LogTime.getElapsedMillis(l)).toString());
        }
        return true;
    }

    public volatile boolean encode(Object obj, OutputStream outputstream)
    {
        return encode((Resource)obj, outputstream);
    }

    public String getId()
    {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }
}
