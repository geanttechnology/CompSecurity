// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.image;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.glide.IntegerVersionSignature;
import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.FutureTarget;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import org.apache.commons.io.IOUtils;

public class BitmapDecoder
{

    private static final String TAG = com/amazon/gallery/foundation/image/BitmapDecoder.getName();

    public BitmapDecoder()
    {
    }

    public static android.graphics.BitmapFactory.Options getBitmapDimensions(Context context, Uri uri)
        throws FileNotFoundException
    {
        Context context1 = null;
        context = getInputStream(context, uri);
        context1 = context;
        uri = getBitmapDimensions(((InputStream) (context)));
        IOUtils.closeQuietly(context);
        return uri;
        context;
        IOUtils.closeQuietly(context1);
        throw context;
    }

    private static android.graphics.BitmapFactory.Options getBitmapDimensions(InputStream inputstream)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        if (inputstream != null)
        {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputstream, null, options);
        }
        return options;
    }

    public static android.graphics.BitmapFactory.Options getBitmapDimensions(String s)
        throws FileNotFoundException
    {
        Object obj = null;
        s = new FileInputStream(s);
        android.graphics.BitmapFactory.Options options = getBitmapDimensions(((InputStream) (s)));
        IOUtils.closeQuietly(s);
        return options;
        Exception exception;
        exception;
        s = obj;
_L2:
        IOUtils.closeQuietly(s);
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static InputStream getInputStream(Context context, Uri uri)
        throws FileNotFoundException
    {
        if (uri.getScheme().equals("file"))
        {
            return new FileInputStream(uri.getPath());
        } else
        {
            return context.getContentResolver().openInputStream(uri);
        }
    }

    public static Bitmap loadBitmapFromFile(Context context, String s, int i, int j, int k)
        throws FileNotFoundException
    {
        s = Glide.with(context.getApplicationContext()).load(s).asBitmap().fitCenter();
        context = s;
        if (k < 0)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        context = s.signature(new IntegerVersionSignature(k));
        context = (Bitmap)context.into(i, j).get();
        return context;
        context;
_L2:
        if (context.getCause() instanceof FileNotFoundException)
        {
            throw (FileNotFoundException)context.getCause();
        } else
        {
            GLogger.ex(TAG, "Exception while loading bitmap from file using Glide", context);
            return null;
        }
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Bitmap loadBitmapFromUri(Context context, Uri uri, int i, int j, int k)
        throws FileNotFoundException
    {
        context = (Bitmap)Glide.with(context.getApplicationContext()).load(uri).asBitmap().fitCenter().into(i, j).get();
        return context;
        context;
_L2:
        GLogger.ex(TAG, "Exception while loading bitmap from uri using Glide", context);
        return null;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
