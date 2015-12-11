// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.widget;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.amazon.retailsearch.android.ui.SearchImageLoaderListener;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.widget:
//            ImageSparkleWidget

class this._cls0
    implements SearchImageLoaderListener
{

    final ImageSparkleWidget this$0;

    public void onLoad(Bitmap bitmap)
    {
        ImageSparkleWidget.access$000(ImageSparkleWidget.this).setImageBitmap(bitmap);
    }

    ()
    {
        this$0 = ImageSparkleWidget.this;
        super();
    }
}
