// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.graphics.Bitmap;
import com.amazon.ansel.fetch.AbstractResourceListener;
import com.amazon.retailsearch.interaction.SearchDataSource;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout, StackLayoutState

class this._cls0 extends AbstractResourceListener
{

    final StackLayout this$0;

    public void result(Bitmap bitmap)
    {
        if (bitmap != null && StackLayout.access$500(StackLayout.this) != null && StackLayout.access$600(StackLayout.this).contains(this))
        {
            int i = StackLayout.access$500(StackLayout.this).getAtfImagesLoadedCount() + 1;
            StackLayout.access$500(StackLayout.this).setAtfImagesLoadedCount(i);
            if (i >= StackLayout.access$700(StackLayout.this))
            {
                searchDataSource.logATF();
                return;
            }
        }
    }

    public volatile void result(Object obj)
    {
        result((Bitmap)obj);
    }

    te()
    {
        this$0 = StackLayout.this;
        super();
    }
}
