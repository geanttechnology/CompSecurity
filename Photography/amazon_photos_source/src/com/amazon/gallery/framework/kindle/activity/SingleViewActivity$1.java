// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.view.MenuItem;
import com.amazon.gallery.thor.view.NoOpSidePanelListener;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            SingleViewActivity

class this._cls0 extends NoOpSidePanelListener
{

    final SingleViewActivity this$0;

    public void onNavigate(MenuItem menuitem)
    {
        super.onNavigate(menuitem);
        if (menuitem.getItemId() != 0x7f0c0270)
        {
            finish();
        }
    }

    ()
    {
        this$0 = SingleViewActivity.this;
        super();
    }
}
