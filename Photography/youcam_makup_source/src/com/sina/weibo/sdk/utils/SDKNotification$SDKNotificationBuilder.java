// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;

// Referenced classes of package com.sina.weibo.sdk.utils:
//            ResourceManager, SDKNotification

public class 
{

    private String mNotificationContent;
    private PendingIntent mNotificationPendingIntent;
    private String mNotificationTitle;
    private Uri mSoundUri;
    private String mTickerText;
    private long mVibrate[];

    public static  buildUpon()
    {
        return new <init>();
    }

    private static int getNotificationIcon(Context context)
    {
        int i = getResourceId(context, "com_sina_weibo_sdk_weibo_logo", "drawable");
        if (i > 0)
        {
            return i;
        } else
        {
            return 0x108009b;
        }
    }

    private static int getResourceId(Context context, String s, String s1)
    {
        String s2 = context.getApplicationContext().getPackageName();
        context = context.getPackageManager();
        int i;
        try
        {
            i = context.getResourcesForApplication(s2).getIdentifier(s, s1, s2);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.intStackTrace();
            return 0;
        }
        return i;
    }

    public SDKNotification build(Context context)
    {
        android.support.v4.app.r r = new android.support.v4.app.r(context);
        r.l(true);
        r.tent(mNotificationPendingIntent);
        r.mNotificationPendingIntent(mTickerText);
        r.(getNotificationIcon(context));
        r.getNotificationIcon(System.currentTimeMillis());
        if (mSoundUri != null)
        {
            r.mSoundUri(mSoundUri);
        }
        if (mVibrate != null)
        {
            r.mVibrate(mVibrate);
        }
        r.(((BitmapDrawable)ResourceManager.getDrawable(context, "weibosdk_notification_icon.png")).getBitmap());
        r.tle(mNotificationTitle);
        r.xt(mNotificationContent);
        return new SDKNotification(context, r.mNotificationContent(), null);
    }

    public mNotificationContent setNotificationContent(String s)
    {
        mNotificationContent = s;
        return this;
    }

    public mNotificationContent setNotificationPendingIntent(PendingIntent pendingintent)
    {
        mNotificationPendingIntent = pendingintent;
        return this;
    }

    public mNotificationPendingIntent setNotificationTitle(String s)
    {
        mNotificationTitle = s;
        return this;
    }

    public mNotificationTitle setSoundUri(Uri uri)
    {
        mSoundUri = uri;
        return this;
    }

    public mSoundUri setTickerText(String s)
    {
        mTickerText = s;
        return this;
    }

    public mTickerText setVibrate(long al[])
    {
        mVibrate = al;
        return this;
    }

    public ()
    {
    }
}
