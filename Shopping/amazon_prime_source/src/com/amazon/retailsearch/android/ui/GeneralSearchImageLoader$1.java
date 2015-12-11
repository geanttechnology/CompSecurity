// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.graphics.Bitmap;
import com.amazon.ansel.fetch.AbstractResourceListener;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            GeneralSearchImageLoader, SearchImageLoaderListener

class val.searchImageLoaderListener extends AbstractResourceListener
{

    final GeneralSearchImageLoader this$0;
    final SearchImageLoaderListener val$searchImageLoaderListener;

    public void result(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return;
        }
        Bitmap bitmap1 = bitmap;
        if (bitmap.getConfig() == null)
        {
            bitmap1 = bitmap.copy(android.graphics.archImageLoader._fld1, false);
        }
        val$searchImageLoaderListener.onLoad(bitmap1);
    }

    public volatile void result(Object obj)
    {
        result((Bitmap)obj);
    }

    ()
    {
        this$0 = final_generalsearchimageloader;
        val$searchImageLoaderListener = SearchImageLoaderListener.this;
        super();
    }
}
