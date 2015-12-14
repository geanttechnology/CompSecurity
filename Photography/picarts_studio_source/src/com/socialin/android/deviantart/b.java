// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.deviantart;

import android.content.Context;
import android.content.SharedPreferences;
import com.socialin.android.d;
import com.socialin.android.oauth2.a;
import com.socialin.android.util.aj;
import com.socialin.android.util.s;
import org.json.JSONObject;

public class b
{

    public static final String a = com/socialin/android/deviantart/b.getSimpleName();
    public SharedPreferences b;
    public aj c;
    public Context d;

    public b(Context context)
    {
        b = null;
        d = context;
        b = context.getSharedPreferences("DeviantArtPrefs", 0);
    }

    public final void a()
    {
        if (c != null)
        {
            c.b();
        }
    }

    public final boolean b()
    {
        if (b.getString("oauth2AccessToken", null) == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        JSONObject jsonobject;
        jsonobject = s.a((new StringBuilder("https://www.deviantart.com/api/draft15/placebo?access_token=")).append(b.getString("oauth2AccessToken", null)).toString());
        (new StringBuilder("checkDeviantArtSession : response")).append(jsonobject);
        if ("success".equals(jsonobject.getString("status")))
        {
            return true;
        }
        com.socialin.android.oauth2.a.a(b);
        return false;
        Exception exception;
        exception;
        com.socialin.android.d.b(a, "checkDeviantArtSession", exception);
        return false;
    }

}
