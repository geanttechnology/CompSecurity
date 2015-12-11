// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;

// Referenced classes of package com.amazon.mobile.mash:
//            MASHContentDownloadHandler

class val.receiver
    implements android.content.ner
{

    final MASHContentDownloadHandler this$0;
    final Activity val$activity;
    final DownloadManager val$downloadManager;
    final long val$queryId;
    final BroadcastReceiver val$receiver;

    public void onCancel(DialogInterface dialoginterface)
    {
        val$downloadManager.remove(new long[] {
            val$queryId
        });
        val$activity.unregisterReceiver(val$receiver);
        MASHContentDownloadHandler.access$000(MASHContentDownloadHandler.this, val$activity);
    }

    _cls9()
    {
        this$0 = final_mashcontentdownloadhandler;
        val$downloadManager = downloadmanager;
        val$queryId = l;
        val$activity = activity1;
        val$receiver = BroadcastReceiver.this;
        super();
    }
}
