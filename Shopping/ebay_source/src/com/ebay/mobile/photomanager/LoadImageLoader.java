// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.ebay.nautilus.shell.content.FwLoader;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.ebay.mobile.photomanager:
//            BitmapUtil

public class LoadImageLoader extends FwLoader
{

    public int errorResId;
    private CountDownLatch exitLatch;
    private Uri imageUri;
    private Bitmap loadedImage;
    private ContentResolver resolver;

    public LoadImageLoader(Context context, ContentResolver contentresolver, Uri uri, CountDownLatch countdownlatch)
    {
        super(context);
        errorResId = -1;
        exitLatch = countdownlatch;
        imageUri = uri;
        resolver = contentresolver;
    }

    protected void doInBackground()
    {
        loadedImage = BitmapUtil.loadLargeBitmap(resolver, imageUri);
        if (loadedImage == null)
        {
            errorResId = 0x7f070783;
        }
        try
        {
            exitLatch.await();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
    }

    public Bitmap getLoadedImage()
    {
        return loadedImage;
    }

    public boolean isError()
    {
        return errorResId != -1;
    }
}
