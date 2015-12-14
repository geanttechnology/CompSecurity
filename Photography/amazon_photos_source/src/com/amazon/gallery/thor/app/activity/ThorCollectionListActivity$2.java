// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import com.amazon.gallery.framework.gallery.widget.TagListAdapter;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorCollectionListActivity

class this._cls0
    implements Runnable
{

    final ThorCollectionListActivity this$0;

    public void run()
    {
        ThorCollectionListActivity.access$100(ThorCollectionListActivity.this).notifyDataSetChanged();
    }

    ()
    {
        this$0 = ThorCollectionListActivity.this;
        super();
    }
}
