// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import com.facebook.AccessToken;
import com.facebook.a.a;
import com.facebook.b.t;
import com.facebook.c;
import com.facebook.h;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.login:
//            LoginClient

abstract class LoginMethodHandler
    implements Parcelable
{

    Map a;
    protected LoginClient b;

    LoginMethodHandler(Parcel parcel)
    {
        a = t.a(parcel);
    }

    LoginMethodHandler(LoginClient loginclient)
    {
        b = loginclient;
    }

    public static AccessToken a(Collection collection, Bundle bundle, c c1, String s)
    {
        Date date = t.a(bundle, "expires_in", new Date());
        String s1 = bundle.getString("access_token");
        Object obj = bundle.getString("granted_scopes");
        if (!t.a(((String) (obj))))
        {
            collection = new ArrayList(Arrays.asList(((String) (obj)).split(",")));
        }
        obj = bundle.getString("denied_scopes");
        if (!t.a(((String) (obj))))
        {
            obj = new ArrayList(Arrays.asList(((String) (obj)).split(",")));
        } else
        {
            obj = null;
        }
        if (t.a(s1))
        {
            return null;
        } else
        {
            return new AccessToken(s1, s, b(bundle.getString("signed_request")), collection, ((Collection) (obj)), c1, date, new Date());
        }
    }

    private static String b(String s)
    {
        if (s == null || s.isEmpty())
        {
            throw new h("Authorization response does not contain the signed_request");
        }
        s = s.split("\\.");
        if (s.length != 2)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        s = (new JSONObject(new String(Base64.decode(s[1], 0), "UTF-8"))).getString("user_id");
        return s;
        s;
_L2:
        throw new h("Failed to retrieve user_id from signed_request");
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    abstract String a();

    final void a(LoginClient loginclient)
    {
        if (b != null)
        {
            throw new h("Can't set LoginClient if it is already set.");
        } else
        {
            b = loginclient;
            return;
        }
    }

    protected final void a(String s)
    {
        String s1 = b.g.d;
        a a1 = com.facebook.a.a.a(b.c.getActivity(), s1);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", s);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString("app_id", s1);
        a1.b("fb_dialogs_web_login_dialog_complete", bundle);
    }

    protected final void a(String s, Object obj)
    {
        if (a == null)
        {
            a = new HashMap();
        }
        Map map = a;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = obj.toString();
        }
        map.put(s, obj);
    }

    boolean a(int i, Intent intent)
    {
        return false;
    }

    abstract boolean a(LoginClient.Request request);

    void b()
    {
    }

    boolean c()
    {
        return false;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        t.a(parcel, a);
    }
}
