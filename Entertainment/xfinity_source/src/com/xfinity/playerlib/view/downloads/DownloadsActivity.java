// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import com.xfinity.playerlib.view.flyinmenu.PlayNowFlyinMenuActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DownloadsActivity extends PlayNowFlyinMenuActivity
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/downloads/DownloadsActivity);

    public DownloadsActivity()
    {
    }

    private void cancelNotificationIfRequested(Intent intent)
    {
        if (intent != null && intent.getAction() != null && intent.getAction().equals("com.xfinity.playerlib.DOWNLOADS_NOTIFICATION.MANAGE_BUTTON"))
        {
            int i = intent.getIntExtra("EXTRA_NOTIFICATION_ID_TO_CANCEL", 0x80000000);
            intent = intent.getStringExtra("EXTRA_NOTIFICATION_TAG_TO_CANCEL");
            if (i != 0x80000000 && intent != null)
            {
                ((NotificationManager)getSystemService("notification")).cancel(intent, i);
            }
        }
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.flyin_downloads;
    }

    public int getSearchBackIcon()
    {
        return com.xfinity.playerlib.R.drawable.ico_back_downloads;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        cancelNotificationIfRequested(getIntent());
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        cancelNotificationIfRequested(intent);
    }

}
