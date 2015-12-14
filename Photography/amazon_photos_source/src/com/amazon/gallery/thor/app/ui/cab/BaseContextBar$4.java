// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui.cab;

import com.amazon.gallery.thor.app.activity.GalleryActionMode;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.app.ui.cab:
//            BaseContextBar, TitleUpdater

class this._cls0
    implements Runnable
{

    final BaseContextBar this$0;

    public void run()
    {
        galleryActionMode.setSubtitle(titleUpdater.getSubTitle(selectables.size()));
    }

    de()
    {
        this$0 = BaseContextBar.this;
        super();
    }
}
