// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.webkit.WebSettings;

public final class aby
{

    public static String a(Context context)
    {
        return WebSettings.getDefaultUserAgent(context);
    }

    public static void a(Context context, WebSettings websettings)
    {
        abv.a(context, websettings);
        websettings.setMediaPlaybackRequiresUserGesture(false);
    }
}
