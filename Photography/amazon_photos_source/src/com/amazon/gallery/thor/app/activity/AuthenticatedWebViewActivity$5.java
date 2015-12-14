// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.view.MenuItem;
import com.amazon.gallery.thor.view.NoOpSidePanelListener;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AuthenticatedWebViewActivity

class this._cls0 extends NoOpSidePanelListener
{

    final AuthenticatedWebViewActivity this$0;

    public void onNavigate(MenuItem menuitem)
    {
        super.onNavigate(menuitem);
        finish();
    }

    I()
    {
        this$0 = AuthenticatedWebViewActivity.this;
        super();
    }
}
