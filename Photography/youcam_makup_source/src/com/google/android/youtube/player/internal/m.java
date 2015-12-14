// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.google.android.youtube.player.internal:
//            x

public final class m
{

    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    public m(Context context)
    {
        context = context.getResources();
        if (context != null && context.getConfiguration() != null && context.getConfiguration().locale != null)
        {
            context = context.getConfiguration().locale;
        } else
        {
            context = Locale.getDefault();
        }
        context = x.a(context);
        a = (String)context.get("error_initializing_player");
        b = (String)context.get("get_youtube_app_title");
        c = (String)context.get("get_youtube_app_text");
        d = (String)context.get("get_youtube_app_action");
        e = (String)context.get("enable_youtube_app_title");
        f = (String)context.get("enable_youtube_app_text");
        g = (String)context.get("enable_youtube_app_action");
        h = (String)context.get("update_youtube_app_title");
        i = (String)context.get("update_youtube_app_text");
        j = (String)context.get("update_youtube_app_action");
    }
}
