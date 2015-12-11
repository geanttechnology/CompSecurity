// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.utils.notification;

import android.app.Notification;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.arellomobile.android.push.preference.SoundType;
import com.arellomobile.android.push.preference.VibrateType;

// Referenced classes of package com.arellomobile.android.push.utils.notification:
//            BaseNotificationFactory, Helper

public class BannerNotificationFactory extends BaseNotificationFactory
{

    public static final String sNotificationLayout = "notification";

    public BannerNotificationFactory(Context context, Bundle bundle, String s, String s1, SoundType soundtype, VibrateType vibratetype)
    {
        super(context, bundle, s, s1, soundtype, vibratetype);
    }

    Notification generateNotificationInner(Context context, Bundle bundle, String s, String s1, String s2)
    {
        context = new Notification();
        int i = getContext().getResources().getIdentifier("notification", "layout", getContext().getPackageName());
        if (i == 0)
        {
            throw new IllegalArgumentException();
        }
        bundle = new RemoteViews(getContext().getPackageName(), i);
        s = Helper.tryToGetBitmapFromInternet(getData().getString("b"), getContext(), -1);
        if (s != null)
        {
            bundle.setBitmap(getContext().getResources().getIdentifier("image", "id", getContext().getPackageName()), "setImageBitmap", s);
        } else
        {
            bundle.setBitmap(getContext().getResources().getIdentifier("image", "id", getContext().getPackageName()), "setImageBitmap", ((BitmapDrawable)getContext().getResources().getDrawable(getContext().getApplicationInfo().icon)).getBitmap());
        }
        context.contentView = bundle;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            context.bigContentView = bundle;
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            context.tickerView = bundle;
        } else
        {
            context.tickerText = s2;
        }
        context.icon = Helper.tryToGetIconFormStringOrGetFromApplication(getData().getString("i"), getContext());
        return context;
    }
}
