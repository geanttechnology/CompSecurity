// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ListView;
import com.aio.downloader.adapter.VideoDownloadedAdapter;
import com.aio.downloader.utils.Myutils;
import java.util.List;

// Referenced classes of package com.aio.downloader.fragments:
//            VideoFragment

class this._cls0 extends BroadcastReceiver
{

    final VideoFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = VideoFragment.access$0(VideoFragment.this);
        Myutils.getInstance();
        context.add(Myutils.successItem);
        VideoFragment.access$3(VideoFragment.this).setAdapter(VideoFragment.access$2(VideoFragment.this));
        VideoFragment.access$2(VideoFragment.this).notifyDataSetChanged();
    }

    pter()
    {
        this$0 = VideoFragment.this;
        super();
    }
}
