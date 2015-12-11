// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;

// Referenced classes of package com.groupon.activity:
//            LogViewer

class this._cls0
    implements android.view.enuItemClickListener
{

    final LogViewer this$0;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        menuitem = new Intent();
        menuitem.setAction("android.intent.action.SEND");
        menuitem.putExtra("android.intent.extra.STREAM", Uri.fromFile(LogViewer.access$000(LogViewer.this)));
        menuitem.setType("text/html");
        startActivity(Intent.createChooser(menuitem, "Send to"));
        return false;
    }

    lickListener()
    {
        this$0 = LogViewer.this;
        super();
    }
}
