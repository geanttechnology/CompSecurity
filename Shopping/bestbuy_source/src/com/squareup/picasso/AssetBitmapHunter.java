// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

// Referenced classes of package com.squareup.picasso:
//            BitmapHunter, Request, Utils, Picasso, 
//            Dispatcher, Cache, Stats, Action

class AssetBitmapHunter extends BitmapHunter
{

    protected static final String ANDROID_ASSET = "android_asset";
    private static final int ASSET_PREFIX_LENGTH = "file:///android_asset/".length();
    private final AssetManager assetManager;

    public AssetBitmapHunter(Context context, Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action)
    {
        super(picasso, dispatcher, cache, stats, action);
        assetManager = context.getAssets();
    }

    Bitmap decode(Request request)
    {
        return decodeAsset(request.uri.toString().substring(ASSET_PREFIX_LENGTH));
    }

    Bitmap decodeAsset(String s)
    {
        Object obj;
        android.graphics.BitmapFactory.Options options;
        obj = null;
        options = createBitmapOptions(data);
        if (!requiresInSampleSize(options))
        {
            break MISSING_BLOCK_LABEL_61;
        }
        java.io.InputStream inputstream = assetManager.open(s);
        obj = inputstream;
        BitmapFactory.decodeStream(inputstream, null, options);
        Utils.closeQuietly(inputstream);
        calculateInSampleSize(data.targetWidth, data.targetHeight, options);
        s = assetManager.open(s);
        obj = BitmapFactory.decodeStream(s, null, options);
        Utils.closeQuietly(s);
        return ((Bitmap) (obj));
        s;
        Utils.closeQuietly(((java.io.InputStream) (obj)));
        throw s;
        Exception exception;
        exception;
        Utils.closeQuietly(s);
        throw exception;
    }

    Picasso.LoadedFrom getLoadedFrom()
    {
        return Picasso.LoadedFrom.DISK;
    }

}
