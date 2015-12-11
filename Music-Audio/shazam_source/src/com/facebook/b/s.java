// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.os.Bundle;
import com.facebook.k;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.b:
//            t, e, o

public final class s
{

    public static final Collection a = t.a(new String[] {
        "service_disabled", "AndroidAuthKillSwitchException"
    });
    public static final Collection b = t.a(new String[] {
        "access_denied", "OAuthAccessDeniedException"
    });
    private static final String c = com/facebook/b/s.getName();

    public s()
    {
    }

    public static Bundle a(String s1, int i, Bundle bundle)
    {
        Bundle bundle1;
        Object obj;
        obj = k.c(k.g());
        if (t.a(((String) (obj))))
        {
            return null;
        }
        bundle1 = new Bundle();
        bundle1.putString("android_key_hash", ((String) (obj)));
        bundle1.putString("app_id", k.j());
        bundle1.putInt("version", i);
        bundle1.putString("display", "touch");
        obj = new Bundle();
        ((Bundle) (obj)).putString("action_id", s1);
        s1 = bundle;
        if (bundle == null)
        {
            s1 = new Bundle();
        }
        bundle = e.a(((Bundle) (obj)));
        s1 = e.a(s1);
        bundle1.putString("bridge_args", bundle.toString());
        bundle1.putString("method_args", s1.toString());
        s1 = bundle1;
_L2:
        return s1;
        s1;
        o.a(com.facebook.s.f, 6, c, (new StringBuilder("Error creating Url -- ")).append(s1).toString());
        s1 = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static final String a()
    {
        return String.format("m.%s", new Object[] {
            k.f()
        });
    }

    public static final String b()
    {
        return String.format("https://graph.%s", new Object[] {
            k.f()
        });
    }

    public static final String c()
    {
        return String.format("https://graph-video.%s", new Object[] {
            k.f()
        });
    }

    public static final String d()
    {
        return "v2.5";
    }

}
