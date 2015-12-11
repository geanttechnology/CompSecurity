// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.apps.youtube.kids.activities.BrowseActivity;

public final class wc extends BroadcastReceiver
{

    private BrowseActivity a;

    public wc(BrowseActivity browseactivity)
    {
        a = browseactivity;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("refresh_browse_activity_intent"))
        {
            BrowseActivity.a(a, true);
        }
    }
}
