// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.b:
//            t

static final class nit>
    implements Runnable
{

    final Context a;
    final String b;
    final String c;

    public final void run()
    {
        SharedPreferences sharedpreferences = a.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
        Object obj = sharedpreferences.getString(b, null);
        if (!t.a(((String) (obj))))
        {
            try
            {
                obj = new JSONObject(((String) (obj)));
            }
            catch (JSONException jsonexception)
            {
                t.a(jsonexception);
                jsonexception = null;
            }
            if (obj != null)
            {
                t.a(c, ((JSONObject) (obj)));
            }
        }
        obj = t.f(c);
        if (obj != null)
        {
            t.a(c, ((JSONObject) (obj)));
            sharedpreferences.edit().putString(b, ((JSONObject) (obj)).toString()).apply();
        }
        t.b().set(false);
    }

    text(Context context, String s, String s1)
    {
        a = context;
        b = s;
        c = s1;
        super();
    }
}
