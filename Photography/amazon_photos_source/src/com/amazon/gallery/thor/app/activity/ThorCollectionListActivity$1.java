// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.view.MenuItem;
import com.amazon.gallery.thor.app.ui.cab.TagContextBar;
import com.amazon.gallery.thor.view.NoOpSidePanelListener;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorCollectionListActivity

class this._cls0 extends NoOpSidePanelListener
{

    final ThorCollectionListActivity this$0;

    public void onNavigate(MenuItem menuitem)
    {
        ThorCollectionListActivity.access$000(ThorCollectionListActivity.this).hide();
    }

    ()
    {
        this$0 = ThorCollectionListActivity.this;
        super();
    }
}
