// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.aviary.android.feather.library.utils.BitmapUtils;
import java.util.concurrent.Callable;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            StickersPanel

static class mFinalSize
    implements Callable
{

    int mFinalSize;
    String mUrl;

    public Bitmap call()
        throws Exception
    {
        Object obj = new android.graphics.kerThumbnailCallable();
        obj. = android.graphics.;
        Bitmap bitmap = BitmapFactory.decodeFile(mUrl, ((android.graphics.kerThumbnailCallable.mUrl) (obj)));
        obj = bitmap;
        if (mFinalSize > 0)
        {
            obj = bitmap;
            if (bitmap != null)
            {
                Bitmap bitmap1 = BitmapUtils.resizeBitmap(bitmap, mFinalSize, mFinalSize);
                obj = bitmap;
                if (bitmap1 != bitmap)
                {
                    bitmap.recycle();
                    obj = bitmap1;
                }
            }
        }
        return ((Bitmap) (obj));
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public (String s, int i)
    {
        mUrl = s;
        mFinalSize = i;
    }
}
