// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.os.Build;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.paypal.android.sdk:
//            eo, cp, dd, z, 
//            eq, ew, ck, ac

public final class en extends eo
{

    public eq a;
    public boolean b;
    public String c;
    public String d;
    public String e;
    public long f;
    private String j;
    private final boolean k;
    private final String l;
    private String m;
    private String n;

    public en(ck ck, ac ac, String s, String s1, eq eq1, String s2, String s3, 
            boolean flag, String s4, boolean flag1, String s5)
    {
        this(ck, ac, s, s1, eq1, flag, s4, flag1, s5);
        m = s2;
        n = s3;
    }

    public en(ck ck, ac ac, String s, String s1, eq eq1, boolean flag, String s2, 
            boolean flag1, String s3)
    {
        super(cp.c, ck, ac, b(s, s1));
        a = eq1;
        b = flag;
        j = s2;
        k = flag1;
        l = s3;
    }

    public final String b()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("response_type", j);
        if (j != null && j.equals("token"))
        {
            hashmap.put("scope_consent_context", "access_token");
            if (!dd.b(l))
            {
                hashmap.put("scope", l);
            }
        }
        hashmap.put("risk_data", dd.a(z.a().b().toString()));
        if (m != null)
        {
            hashmap.put("grant_type", "urn:paypal:params:oauth2:grant_type:otp");
            hashmap.put("nonce", n);
            JSONObject jsonobject = new JSONObject();
            jsonobject.accumulate("token_identifier", "otp");
            jsonobject.accumulate("token_value", m);
            hashmap.put("2fa_token_claims", a(jsonobject));
        } else
        if (a.a())
        {
            hashmap.put("grant_type", "password");
            hashmap.put("email", dd.a(a.b()));
            hashmap.put("password", dd.a(a.c()));
        } else
        {
            hashmap.put("grant_type", "password");
            a.d().c();
            hashmap.put("phone", dd.a((new StringBuilder("+")).append(a.d().c()).append(" ").append(a.d().a()).toString()));
            hashmap.put("pin", a.e());
        }
        hashmap.put("device_name", dd.a(Build.DEVICE));
        hashmap.put("redirect_uri", dd.a("urn:ietf:wg:oauth:2.0:oob"));
        return dd.a(hashmap);
    }

    public final void c()
    {
        JSONObject jsonobject = m();
        jsonobject.getString("scope");
        e = jsonobject.getString("scope");
        if (k)
        {
            c = jsonobject.getString("code");
            g = jsonobject.getString("nonce");
            return;
        }
        try
        {
            d = jsonobject.getString("access_token");
            f = jsonobject.getLong("expires_in");
            return;
        }
        catch (JSONException jsonexception)
        {
            b(jsonobject);
        }
        return;
    }

    public final void d()
    {
        b(m());
    }

    public final String e()
    {
        return "{ \"access_token\": \"mock_access_token\", \"code\": \"mock_code_EJhi9jOPswug9TDOv93qg4Y28xIlqPDpAoqd7biDLpeGCPvORHjP1Fh4CbFPgKMGCHejdDwe9w1uDWnjPCp1lkaFBjVmjvjpFtnr6z1YeBbmfZYqa9faQT_71dmgZhMIFVkbi4yO7hk0LBHXt_wtdsw\", \"scope\": \"https://api.paypal.com/v1/payments/.*\", \"nonce\": \"mock_nonce\", \"token_type\": \"Bearer\",\"expires_in\":28800,\"visitor_id\":\"zVxjDBTRRNfYXdOb19-lcTblxm-6bzXGvSlP76ZiHOudKaAvoxrW8Cg5pA6EjIPpiz4zlw\" }";
    }

    public final boolean t()
    {
        return m != null;
    }
}
