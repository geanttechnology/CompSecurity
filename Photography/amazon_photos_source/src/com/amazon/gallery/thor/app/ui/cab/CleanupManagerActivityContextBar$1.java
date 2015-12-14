// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui.cab;

import com.amazon.gallery.thor.app.activity.GalleryActionMode;
import java.util.List;
import org.apache.commons.io.FileUtils;

// Referenced classes of package com.amazon.gallery.thor.app.ui.cab:
//            CleanupManagerActivityContextBar, CleanupTitleUpdater

class this._cls0
    implements Runnable
{

    final CleanupManagerActivityContextBar this$0;

    public void run()
    {
        galleryActionMode.setTitle(CleanupManagerActivityContextBar.access$000(CleanupManagerActivityContextBar.this).getSubTitle(getSelectables().size()));
        galleryActionMode.setSubtitle(FileUtils.byteCountToDisplaySize(CleanupManagerActivityContextBar.access$100(CleanupManagerActivityContextBar.this)));
    }

    ()
    {
        this$0 = CleanupManagerActivityContextBar.this;
        super();
    }
}
