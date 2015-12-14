// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.flurry.android.FlurryAgent;
import java.io.File;

public class DownloadBackgroundReciver extends BroadcastReceiver
{

    public DownloadBackgroundReciver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        long l;
        long l1;
        Log.e("DownloadBackgroundReciver", "onReceive");
        if (!intent.getAction().equalsIgnoreCase("android.intent.action.DOWNLOAD_COMPLETE"))
        {
            break MISSING_BLOCK_LABEL_202;
        }
        l = intent.getLongExtra("extra_download_id", -1L);
        l1 = context.getSharedPreferences("SystemDownloadTask", 0).getLong("downloadID", 0L);
        if (l1 != l)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        Object obj;
        try
        {
            FlurryAgent.logEvent("guide_finish_dowmload");
            intent = (DownloadManager)context.getSystemService("download");
            obj = new android.app.DownloadManager.Query();
            ((android.app.DownloadManager.Query) (obj)).setFilterById(new long[] {
                l1
            });
            obj = intent.query(((android.app.DownloadManager.Query) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        intent = "";
        if (((Cursor) (obj)).moveToFirst())
        {
            intent = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("local_filename"));
        }
        ((Cursor) (obj)).close();
        intent = new File(intent);
        if (intent.exists())
        {
            obj = new Intent("android.intent.action.VIEW");
            ((Intent) (obj)).setDataAndType(Uri.parse((new StringBuilder()).append("file://").append(intent.toString()).toString()), "application/vnd.android.package-archive");
            ((Intent) (obj)).addFlags(0x10000000);
            context.startActivity(((Intent) (obj)));
        }
    }
}
