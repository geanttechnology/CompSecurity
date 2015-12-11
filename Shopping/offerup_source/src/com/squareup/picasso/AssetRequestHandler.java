// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.util.List;

// Referenced classes of package com.squareup.picasso:
//            RequestHandler, Request, Utils

class AssetRequestHandler extends RequestHandler
{

    protected static final String ANDROID_ASSET = "android_asset";
    private static final int ASSET_PREFIX_LENGTH = 22;
    private final AssetManager assetManager;

    public AssetRequestHandler(Context context)
    {
        assetManager = context.getAssets();
    }

    public boolean canHandleRequest(Request request)
    {
        boolean flag1 = false;
        request = request.uri;
        boolean flag = flag1;
        if ("file".equals(request.getScheme()))
        {
            flag = flag1;
            if (!request.getPathSegments().isEmpty())
            {
                flag = flag1;
                if ("android_asset".equals(request.getPathSegments().get(0)))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    Bitmap decodeAsset(Request request, String s)
    {
        java.io.InputStream inputstream;
        android.graphics.BitmapFactory.Options options;
        inputstream = null;
        options = createBitmapOptions(request);
        if (!requiresInSampleSize(options))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        java.io.InputStream inputstream1 = assetManager.open(s);
        inputstream = inputstream1;
        BitmapFactory.decodeStream(inputstream1, null, options);
        Utils.closeQuietly(inputstream1);
        calculateInSampleSize(request.targetWidth, request.targetHeight, options, request);
        request = assetManager.open(s);
        s = BitmapFactory.decodeStream(request, null, options);
        Utils.closeQuietly(request);
        return s;
        request;
        Utils.closeQuietly(inputstream);
        throw request;
        s;
        Utils.closeQuietly(request);
        throw s;
    }

    public RequestHandler.Result load(Request request)
    {
        return new RequestHandler.Result(decodeAsset(request, request.uri.toString().substring(ASSET_PREFIX_LENGTH)), Picasso.LoadedFrom.DISK);
    }

}
