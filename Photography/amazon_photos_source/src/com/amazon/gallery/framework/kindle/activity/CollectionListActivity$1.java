// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.database.DataSetObserver;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            CollectionListActivity

class this._cls0 extends DataSetObserver
{

    final CollectionListActivity this$0;

    public void onChanged()
    {
        updateNoContentOverlay();
    }

    ()
    {
        this$0 = CollectionListActivity.this;
        super();
    }
}
