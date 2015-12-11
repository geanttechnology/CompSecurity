// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

// Referenced classes of package com.xfinity.playerlib.view.downloads:
//            DownloadsFragment

class this._cls0
    implements android.widget.ickListener
{

    final DownloadsFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (!DownloadsFragment.access$200(DownloadsFragment.this))
        {
            downloadList.setItemChecked(i, false);
            return;
        } else
        {
            DownloadsFragment.access$500(DownloadsFragment.this);
            return;
        }
    }

    ()
    {
        this$0 = DownloadsFragment.this;
        super();
    }
}
