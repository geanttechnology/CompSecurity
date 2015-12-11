// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

// Referenced classes of package com.aio.downloader.adapter:
//            VideoDownloadedAdapter

class val.position
    implements android.view.adedAdapter._cls2
{

    final VideoDownloadedAdapter this$0;
    private final int val$position;

    public void onClick(View view)
    {
        view = new Intent();
        view.setAction("videodelete");
        view.putExtra("position", val$position);
        ctx.sendBroadcast(view);
    }

    _cls9()
    {
        this$0 = final_videodownloadedadapter;
        val$position = I.this;
        super();
    }
}
