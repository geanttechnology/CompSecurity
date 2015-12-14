// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.framework.gallery.cab.ContextBar;
import com.amazon.gallery.thor.albums.AlbumsMetricsHelper;
import com.amazon.gallery.thor.app.activity.ThorNativeGalleryActivity;
import com.amazon.gallery.thor.folders.FoldersAdapter;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            FoldersActivity

class this._cls0
    implements android.view.er
{

    final FoldersActivity this$0;

    public void onClick(View view)
    {
        if (FoldersActivity.access$000(FoldersActivity.this).isContextBarActive())
        {
            FoldersActivity.access$100(FoldersActivity.this, view);
            return;
        } else
        {
            int i = FoldersActivity.access$200(FoldersActivity.this).getChildAdapterPosition(view);
            view = new Intent(FoldersActivity.this, com/amazon/gallery/thor/app/activity/ThorNativeGalleryActivity);
            view.setAction("com.amazon.photos.INTERNAL");
            view.putExtra("mediaTag", FoldersActivity.access$300(FoldersActivity.this).getFolderForPosition(i));
            view.putExtra("navigationFromFolders", true);
            com.amazon.gallery.thor.albums.r.MetricsEvent metricsevent = com.amazon.gallery.thor.albums.r.MetricsEvent.FolderMigrationViewAll;
            FoldersActivity.access$400(FoldersActivity.this).trackEvent(metricsevent, AlbumsMetricsHelper.createMetricsExtra(metricsevent.name(), null, null));
            startActivity(view);
            return;
        }
    }

    ()
    {
        this$0 = FoldersActivity.this;
        super();
    }
}
