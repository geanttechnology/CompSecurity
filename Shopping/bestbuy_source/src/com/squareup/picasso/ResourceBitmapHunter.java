// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

// Referenced classes of package com.squareup.picasso:
//            BitmapHunter, Request, Utils, Picasso, 
//            Dispatcher, Cache, Stats, Action

class ResourceBitmapHunter extends BitmapHunter
{

    private final Context context;

    ResourceBitmapHunter(Context context1, Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action)
    {
        super(picasso, dispatcher, cache, stats, action);
        context = context1;
    }

    private Bitmap decodeResource(Resources resources, int i, Request request)
    {
        android.graphics.BitmapFactory.Options options = createBitmapOptions(request);
        if (requiresInSampleSize(options))
        {
            BitmapFactory.decodeResource(resources, i, options);
            calculateInSampleSize(request.targetWidth, request.targetHeight, options);
        }
        return BitmapFactory.decodeResource(resources, i, options);
    }

    Bitmap decode(Request request)
    {
        Resources resources = Utils.getResources(context, request);
        return decodeResource(resources, Utils.getResourceId(resources, request), request);
    }

    Picasso.LoadedFrom getLoadedFrom()
    {
        return Picasso.LoadedFrom.DISK;
    }
}
