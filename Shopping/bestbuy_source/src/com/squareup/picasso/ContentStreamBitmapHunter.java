// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

// Referenced classes of package com.squareup.picasso:
//            BitmapHunter, Request, Utils, Picasso, 
//            Dispatcher, Cache, Stats, Action

class ContentStreamBitmapHunter extends BitmapHunter
{

    final Context context;

    ContentStreamBitmapHunter(Context context1, Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action)
    {
        super(picasso, dispatcher, cache, stats, action);
        context = context1;
    }

    Bitmap decode(Request request)
    {
        return decodeContentStream(request);
    }

    protected Bitmap decodeContentStream(Request request)
    {
        Object obj;
        android.graphics.BitmapFactory.Options options;
        ContentResolver contentresolver;
        obj = null;
        contentresolver = context.getContentResolver();
        options = createBitmapOptions(request);
        if (!requiresInSampleSize(options))
        {
            break MISSING_BLOCK_LABEL_62;
        }
        java.io.InputStream inputstream = contentresolver.openInputStream(request.uri);
        obj = inputstream;
        BitmapFactory.decodeStream(inputstream, null, options);
        Utils.closeQuietly(inputstream);
        calculateInSampleSize(request.targetWidth, request.targetHeight, options);
        request = contentresolver.openInputStream(request.uri);
        obj = BitmapFactory.decodeStream(request, null, options);
        Utils.closeQuietly(request);
        return ((Bitmap) (obj));
        request;
        Utils.closeQuietly(((java.io.InputStream) (obj)));
        throw request;
        Exception exception;
        exception;
        Utils.closeQuietly(request);
        throw exception;
    }

    Picasso.LoadedFrom getLoadedFrom()
    {
        return Picasso.LoadedFrom.DISK;
    }
}
