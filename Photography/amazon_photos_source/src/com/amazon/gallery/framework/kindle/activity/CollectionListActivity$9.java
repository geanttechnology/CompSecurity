// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import com.amazon.gallery.framework.gallery.widget.TagListAdapter;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            CollectionListActivity

class this._cls0
    implements Runnable
{

    final CollectionListActivity this$0;

    public void run()
    {
        if (listAdapter != null && CollectionListActivity.access$200(CollectionListActivity.this) != null)
        {
            listAdapter.onDestroy();
            listAdapter.init(CollectionListActivity.access$200(CollectionListActivity.this), tagType, null);
        }
    }

    ()
    {
        this$0 = CollectionListActivity.this;
        super();
    }
}
