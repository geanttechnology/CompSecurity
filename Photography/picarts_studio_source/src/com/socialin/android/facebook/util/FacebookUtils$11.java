// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.socialin.android.util.s;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.facebook.util:
//            FacebookUtils

final class c
    implements com.facebook.alizeCallback
{

    private Activity a;
    private String b;
    private String c;

    public final void onInitialized()
    {
        if (s.a(a) && FacebookUtils.canIPost() && FacebookUtils.isUserConnected()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s1;
        Bundle bundle;
        SharedPreferences sharedpreferences;
        bundle = new Bundle();
        s1 = "";
        sharedpreferences = a.getSharedPreferences((new StringBuilder("sinPref_")).append(a.getString(m.e(a, "app_name_short"))).toString(), 0);
        if (!"og.follows".equals(b))
        {
            break; /* Loop/switch isn't completed */
        }
        if (sharedpreferences != null && !sharedpreferences.getBoolean("enable_fb_action_follow", true))
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = (new StringBuilder("me/")).append(b).toString();
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        if (sharedpreferences != null && sharedpreferences.getBoolean("enable_fb_explicit", false))
        {
            bundle.putString("fb:explicitly_shared", "true");
        }
        bundle.putString("profile", c);
        FacebookUtils.access$100(bundle, s1);
        return;
    }

    _cls9(Activity activity, String s1, String s2)
    {
        a = activity;
        b = s1;
        c = s2;
        super();
    }
}
