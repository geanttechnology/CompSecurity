// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import com.amazon.gallery.foundation.utils.TimeTracker;
import com.amazon.gallery.framework.gallery.widget.TagListAdapter;
import com.amazon.gallery.framework.model.tags.TagProperty;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            CollectionListActivity

class freshAlbumAsyncTask extends freshAlbumAsyncTask
{

    final CollectionListActivity this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((TagProperty[])aobj);
    }

    protected transient List doInBackground(TagProperty atagproperty[])
    {
        TimeTracker.log("loadTags.started");
        atagproperty = listAdapter.loadTags(atagproperty[0]);
        TimeTracker.log("loadTags.finished");
        return atagproperty;
    }

    freshAlbumAsyncTask()
    {
        this$0 = CollectionListActivity.this;
        super(CollectionListActivity.this, null);
    }
}
