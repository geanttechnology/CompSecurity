// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            BaseListActivity

private class <init>
    implements android.widget.istener, Runnable
{

    private final Handler handler;
    final BaseListActivity this$0;

    public final void cancelRequestFocus()
    {
        handler.removeCallbacks(this);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        onListItemClick((ListView)adapterview, view, i, l);
    }

    public final void requestFocus()
    {
        handler.post(this);
    }

    public void run()
    {
        BaseListActivity.access$100(BaseListActivity.this).focusableViewAvailable(BaseListActivity.access$100(BaseListActivity.this));
    }

    private _cls9()
    {
        this$0 = BaseListActivity.this;
        super();
        handler = new Handler();
    }

    handler(handler handler1)
    {
        this();
    }
}
