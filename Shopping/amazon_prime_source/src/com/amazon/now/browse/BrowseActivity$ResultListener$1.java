// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.browse;

import android.widget.ListView;
import com.amazon.now.ChromeStyle;

// Referenced classes of package com.amazon.now.browse:
//            BrowseActivity, BrowseListAdapter

class val.adapter
    implements Runnable
{

    final is._cls0 this$1;
    final BrowseListAdapter val$adapter;

    public void run()
    {
        BrowseActivity.access$200(_fld0).setAdapter(val$adapter);
        setRootView(BrowseActivity.access$200(_fld0), new ChromeStyle(com.amazon.now.ener.this._fld0));
    }

    ()
    {
        this$1 = final_;
        val$adapter = BrowseListAdapter.this;
        super();
    }
}
