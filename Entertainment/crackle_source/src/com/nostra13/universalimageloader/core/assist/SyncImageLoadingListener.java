// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;

import android.graphics.Bitmap;
import android.view.View;

// Referenced classes of package com.nostra13.universalimageloader.core.assist:
//            SimpleImageLoadingListener

public class SyncImageLoadingListener extends SimpleImageLoadingListener
{

    private Bitmap loadedImage;

    public SyncImageLoadingListener()
    {
    }

    public Bitmap getLoadedBitmap()
    {
        return loadedImage;
    }

    public void onLoadingComplete(String s, View view, Bitmap bitmap)
    {
        loadedImage = bitmap;
    }
}
