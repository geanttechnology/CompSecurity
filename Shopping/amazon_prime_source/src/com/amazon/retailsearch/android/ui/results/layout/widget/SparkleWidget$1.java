// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.widget;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.amazon.retailsearch.android.ui.SearchImageLoaderListener;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.widget:
//            SparkleWidget

class this._cls0
    implements SearchImageLoaderListener
{

    final SparkleWidget this$0;

    public void onLoad(Bitmap bitmap)
    {
        SparkleWidget.access$000(SparkleWidget.this).setImageBitmap(bitmap);
        SparkleWidget.access$000(SparkleWidget.this).setVisibility(0);
    }

    ()
    {
        this$0 = SparkleWidget.this;
        super();
    }
}
