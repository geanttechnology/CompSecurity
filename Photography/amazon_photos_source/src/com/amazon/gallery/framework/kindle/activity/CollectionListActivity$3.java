// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.view.View;
import com.amazon.gallery.framework.gallery.widget.AndroidGalleryBadgeableCoverView;
import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView;
import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverViewProvider;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            CollectionListActivity

class this._cls0
    implements GalleryBadgeableCoverViewProvider
{

    final CollectionListActivity this$0;

    public GalleryBadgeableCoverView buildBadgeableCoverView(View view)
    {
        return new AndroidGalleryBadgeableCoverView(view);
    }

    erView()
    {
        this$0 = CollectionListActivity.this;
        super();
    }
}
