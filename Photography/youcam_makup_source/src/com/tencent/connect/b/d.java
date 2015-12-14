// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.CookieSyncManager;
import com.tencent.connect.a.a;
import com.tencent.open.a.k;
import com.tencent.tauth.b;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.b:
//            a, m

class d
    implements b
{

    final com.tencent.connect.b.a a;
    private final b b;
    private final boolean c;
    private final Context d;

    public d(com.tencent.connect.b.a a1, Context context, b b1, boolean flag, boolean flag1)
    {
        a = a1;
        super();
        d = context;
        b = b1;
        c = flag;
        k.b("openSDK_LOG", "OpenUi, TokenListener()");
    }

    public void a()
    {
        k.b("openSDK_LOG", "OpenUi, TokenListener() onCancel");
        b.a();
        k.b();
    }

    public void a(com.tencent.tauth.d d1)
    {
        k.b("openSDK_LOG", "OpenUi, TokenListener() onError");
        b.a(d1);
        k.b();
    }

    public void a(Object obj)
    {
        k.b("openSDK_LOG", "OpenUi, TokenListener() onComplete");
        obj = (JSONObject)obj;
        String s;
        String s1;
        String s2;
        s = ((JSONObject) (obj)).getString("access_token");
        s1 = ((JSONObject) (obj)).getString("expires_in");
        s2 = ((JSONObject) (obj)).getString("openid");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (com.tencent.connect.b.a.a(a) == null || s2 == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        com.tencent.connect.b.a.b(a).a(s, s1);
        com.tencent.connect.b.a.c(a).a(s2);
        com.tencent.connect.a.a.d(d, com.tencent.connect.b.a.d(a));
        s = ((JSONObject) (obj)).getString("pf");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        d.getSharedPreferences("pfStore", 0).edit().putString("pf", s).commit();
_L1:
        if (c)
        {
            CookieSyncManager.getInstance().sync();
        }
_L2:
        b.a(obj);
        a.a();
        k.b();
        return;
        Object obj1;
        obj1;
        ((Exception) (obj1)).printStackTrace();
        k.b("openSDK_LOG", "OpenUi, TokenListener() onComplete error", ((Throwable) (obj1)));
          goto _L1
        obj1;
        ((JSONException) (obj1)).printStackTrace();
        k.b("openSDK_LOG", "OpenUi, TokenListener() onComplete error", ((Throwable) (obj1)));
          goto _L2
    }
}
