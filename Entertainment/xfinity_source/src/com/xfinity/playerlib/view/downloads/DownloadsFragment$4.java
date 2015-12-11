// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.xfinity.playerlib.view.downloads:
//            DownloadsFragment

class this._cls0
    implements android.widget.ngClickListener
{

    final DownloadsFragment this$0;

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        if (!DownloadsFragment.access$200(DownloadsFragment.this))
        {
            DownloadsFragment.access$600(DownloadsFragment.this);
            DownloadsFragment.access$700(DownloadsFragment.this, i);
        } else
        {
            DownloadsFragment.access$700(DownloadsFragment.this, i);
        }
        return true;
    }

    ()
    {
        this$0 = DownloadsFragment.this;
        super();
    }
}
