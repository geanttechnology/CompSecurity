// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.google.android.a.a.a:
//            y

public final class o
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

    public o(Context context)
    {
        context = context.getResources();
        HashMap hashmap;
        String s;
        if (context != null && context.getConfiguration() != null && context.getConfiguration().locale != null)
        {
            context = context.getConfiguration().locale;
        } else
        {
            context = Locale.getDefault();
        }
        hashmap = new HashMap();
        hashmap.put("error_initializing_player", "An error occurred while initializing the YouTube player.");
        hashmap.put("get_youtube_app_title", "Get YouTube App");
        hashmap.put("get_youtube_app_text", "This app won't run without the YouTube App, which is missing from your device");
        hashmap.put("get_youtube_app_action", "Get YouTube App");
        hashmap.put("enable_youtube_app_title", "Enable YouTube App");
        hashmap.put("enable_youtube_app_text", "This app won't work unless you enable the YouTube App.");
        hashmap.put("enable_youtube_app_action", "Enable YouTube App");
        hashmap.put("update_youtube_app_title", "Update YouTube App");
        hashmap.put("update_youtube_app_text", "This app won't work unless you update the YouTube App.");
        hashmap.put("update_youtube_app_action", "Update YouTube App");
        y.a(hashmap, context.getLanguage());
        s = String.valueOf(context.getLanguage());
        context = String.valueOf(context.getCountry());
        y.a(hashmap, (new StringBuilder(String.valueOf(s).length() + 1 + String.valueOf(context).length())).append(s).append("_").append(context).toString());
        a = (String)hashmap.get("error_initializing_player");
        b = (String)hashmap.get("get_youtube_app_title");
        c = (String)hashmap.get("get_youtube_app_text");
        d = (String)hashmap.get("get_youtube_app_action");
        e = (String)hashmap.get("enable_youtube_app_title");
        f = (String)hashmap.get("enable_youtube_app_text");
        g = (String)hashmap.get("enable_youtube_app_action");
        h = (String)hashmap.get("update_youtube_app_title");
        i = (String)hashmap.get("update_youtube_app_text");
        j = (String)hashmap.get("update_youtube_app_action");
    }
}
