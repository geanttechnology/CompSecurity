// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import android.view.View;

// Referenced classes of package com.xfinity.playerlib.view.downloads:
//            DownloadsArrayAdapter, DownloadsItemListener

class wnloadableItemHolder
    implements android.view.DownloadsArrayAdapter._cls2
{

    final DownloadsArrayAdapter this$0;
    final wnloadableItemHolder val$holder;

    public void onClick(View view)
    {
        listener.onHotwireDownloadPressed(view.getContext(), val$holder.playerDownloadFile);
    }

    wnloadableItemHolder()
    {
        this$0 = final_downloadsarrayadapter;
        val$holder = wnloadableItemHolder.this;
        super();
    }
}
