// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
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
        if (s.a(a) || FacebookUtils.isSessionValid()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s1;
        Bundle bundle;
        SharedPreferences sharedpreferences;
        String s2;
        byte byte0;
        bundle = new Bundle();
        s1 = (new StringBuilder("me/picsartphotostudio:")).append(b).toString();
        sharedpreferences = a.getSharedPreferences((new StringBuilder("sinPref_")).append(a.getString(m.e(a, "app_name_short"))).toString(), 0);
        s2 = b;
        byte0 = -1;
        s2.hashCode();
        JVM INSTR lookupswitch 4: default 140
    //                   -1478067162: 267
    //                   3321751: 219
    //                   3625706: 235
    //                   950398559: 251;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        byte0;
        JVM INSTR tableswitch 0 3: default 172
    //                   0 283
    //                   1 312
    //                   2 341
    //                   3 370;
           goto _L8 _L9 _L10 _L11 _L12
_L8:
        break MISSING_BLOCK_LABEL_172;
_L12:
        continue; /* Loop/switch isn't completed */
_L14:
        if (sharedpreferences != null && sharedpreferences.getBoolean("enable_fb_explicit", false))
        {
            bundle.putString("fb:explicitly_shared", "true");
        }
        (new GraphRequest(AccessToken.getCurrentAccessToken(), s1, bundle, HttpMethod.POST, FacebookUtils.access$200())).executeAndWait();
        return;
_L5:
        if (s2.equals("like"))
        {
            byte0 = 0;
        }
          goto _L3
_L6:
        if (s2.equals("vote"))
        {
            byte0 = 1;
        }
          goto _L3
_L7:
        if (s2.equals("comment"))
        {
            byte0 = 2;
        }
          goto _L3
_L4:
        if (s2.equals("og.likes"))
        {
            byte0 = 3;
        }
          goto _L3
_L9:
        if (sharedpreferences != null && !sharedpreferences.getBoolean("enable_fb_action_like", true)) goto _L1; else goto _L13
_L13:
        bundle.putString("photo", c);
          goto _L14
_L10:
        if (sharedpreferences != null && !sharedpreferences.getBoolean("enable_fb_action_vote", true)) goto _L1; else goto _L15
_L15:
        bundle.putString("photo", c);
          goto _L14
_L11:
        if (sharedpreferences != null && !sharedpreferences.getBoolean("enable_fb_action_comment", true)) goto _L1; else goto _L16
_L16:
        bundle.putString("photo", c);
          goto _L14
        if (sharedpreferences != null && !sharedpreferences.getBoolean("enable_fb_action_like", true)) goto _L1; else goto _L17
_L17:
        s1 = (new StringBuilder("me/")).append(b).toString();
        bundle.putString("object", c);
          goto _L14
    }

    _cls9(Activity activity, String s1, String s2)
    {
        a = activity;
        b = s1;
        c = s2;
        super();
    }
}
