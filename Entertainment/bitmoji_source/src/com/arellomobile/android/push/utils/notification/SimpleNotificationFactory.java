// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.utils.notification;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import com.arellomobile.android.push.preference.SoundType;
import com.arellomobile.android.push.preference.VibrateType;

// Referenced classes of package com.arellomobile.android.push.utils.notification:
//            BaseNotificationFactory, Helper

public class SimpleNotificationFactory extends BaseNotificationFactory
{

    private static final int sImageHeight = 128;

    public SimpleNotificationFactory(Context context, Bundle bundle, String s, String s1, SoundType soundtype, VibrateType vibratetype)
    {
        super(context, bundle, s, s1, soundtype, vibratetype);
    }

    private CharSequence getContent(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return s;
        } else
        {
            return Html.fromHtml(s);
        }
    }

    Notification generateNotificationInner(Context context, Bundle bundle, String s, String s1, String s2)
    {
        int i = Helper.tryToGetIconFormStringOrGetFromApplication(bundle.getString("i"), context);
        context.getResources();
        Object obj = null;
        String s3 = bundle.getString("ci");
        bundle = obj;
        if (s3 != null)
        {
            bundle = Helper.tryToGetBitmapFromInternet(s3, context, 128);
        }
        context = new com.pushwoosh.support.v4.app.NotificationCompat.Builder(context);
        context.setContentTitle(getContent(s));
        context.setContentText(getContent(s1));
        context.setTicker(getContent(s2));
        context.setWhen(System.currentTimeMillis());
        context.setStyle((new com.pushwoosh.support.v4.app.NotificationCompat.BigTextStyle()).bigText(getContent(s1)));
        context.setSmallIcon(i);
        if (bundle != null)
        {
            context.setLargeIcon(bundle);
        }
        return context.build();
    }
}
