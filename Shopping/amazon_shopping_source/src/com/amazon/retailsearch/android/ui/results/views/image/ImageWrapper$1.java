// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.image;

import android.graphics.Bitmap;
import com.amazon.ansel.fetch.AbstractResourceListener;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.retailsearch.util.Utils;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.image:
//            ImageWrapper

class val.imageRequest extends AbstractResourceListener
{

    final ImageWrapper this$0;
    final ImageRequest val$imageRequest;

    public void result(Bitmap bitmap)
    {
        if (ImageWrapper.access$000(ImageWrapper.this) != this || !Utils.isEqual(val$imageRequest, ImageWrapper.access$100(ImageWrapper.this)))
        {
            return;
        }
        if (bitmap == null)
        {
            hideImage();
            return;
        } else
        {
            showImage(ImageWrapper.access$100(ImageWrapper.this), bitmap);
            return;
        }
    }

    public volatile void result(Object obj)
    {
        result((Bitmap)obj);
    }

    ()
    {
        this$0 = final_imagewrapper;
        val$imageRequest = ImageRequest.this;
        super();
    }
}
