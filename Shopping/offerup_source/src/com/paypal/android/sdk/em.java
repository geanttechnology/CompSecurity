// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.paypal.android.sdk:
//            eo, cp, dd, ck, 
//            ac

public final class em extends eo
{

    private final String a;
    private final String b;

    public em(ck ck, ac ac, String s, String s1, String s2, String s3)
    {
        super(cp.d, ck, ac, b(s, s1));
        a = s2;
        b = s3;
    }

    public final String b()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("authn_schemes", "2fa_pre_login");
        hashmap.put("nonce", a);
        JSONObject jsonobject = new JSONObject();
        jsonobject.accumulate("authn_scheme", "security_key_sms_token");
        jsonobject.accumulate("token_identifier", b);
        hashmap.put("2fa_token_identifiers", a(jsonobject));
        return dd.a(hashmap);
    }

    public final void c()
    {
        JSONObject jsonobject = m();
        try
        {
            g = jsonobject.getString("nonce");
            return;
        }
        catch (JSONException jsonexception)
        {
            b(jsonobject);
        }
    }

    public final void d()
    {
        b(m());
    }

    public final String e()
    {
        return "{\"nonce\": \"mock-login-challenge-nonce\"}";
    }
}
