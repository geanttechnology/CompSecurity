// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.paypal.android.sdk:
//            ci, co, cp, az, 
//            dd, ck, ac

public class el extends ci
{

    private Map a;
    private String b;
    private String c;
    private String d;

    public el(ck ck, ac ac, String s, String s1, String s2)
    {
        co co1 = new co(cp.h);
        StringBuilder stringbuilder = new StringBuilder("Bearer ");
        String s3 = s1;
        if (az.a(s))
        {
            s3 = s1;
            if (s1 == null)
            {
                s3 = "mock_euat";
            }
        }
        super(co1, ck, ac, stringbuilder.append(s3).toString(), (new StringBuilder("/")).append(s2).toString());
        a = new HashMap();
        a("Content-Type", "application/x-www-form-urlencoded");
    }

    private static void a(JSONArray jsonarray, Map map)
    {
        if (jsonarray != null)
        {
            for (int i = 0; i < jsonarray.length(); i++)
            {
                Object obj = jsonarray.getJSONObject(i);
                if (obj == null)
                {
                    continue;
                }
                String s = ((JSONObject) (obj)).optString("name");
                obj = ((JSONObject) (obj)).optString("value");
                if (dd.c(s) && dd.c(((CharSequence) (obj))))
                {
                    map.put(s, obj);
                }
            }

        }
    }

    public final String b()
    {
        return "";
    }

    public final void c()
    {
        JSONObject jsonobject;
        JSONArray jsonarray;
        jsonobject = m();
        jsonarray = jsonobject.optJSONArray("capabilities");
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L5:
        Object obj;
        if (i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_171;
        }
        obj = jsonarray.getJSONObject(i);
        if (obj == null || !"PAYPAL_ACCESS".equals(((JSONObject) (obj)).optString("name"))) goto _L4; else goto _L3
_L3:
        if (obj != null)
        {
            a(((JSONObject) (obj)).optJSONArray("attributes"), a);
            obj = a;
            (new StringBuilder("Attributes: ")).append(obj.toString());
        }
_L2:
        obj = jsonobject.optJSONArray("attributes");
        if (obj != null)
        {
            HashMap hashmap = new HashMap();
            a(((JSONArray) (obj)), hashmap);
            b = (String)hashmap.get("privacy_policy_url");
            c = (String)hashmap.get("user_agreement_url");
            d = (String)hashmap.get("display_name");
        }
        return;
_L4:
        i++;
          goto _L5
        obj = null;
          goto _L3
    }

    public final void d()
    {
    }

    public final String e()
    {
        return " {\n     \"attributes\": [\n         {\n             \"name\": \"display_name\",\n             \"value\": \"Example Merchant\"\n         },\n         {\n             \"name\": \"privacy_policy_url\",\n             \"value\": \"http://www.example.com/privacy-policy\"\n         },\n         {\n             \"name\": \"user_agreement_url\",\n             \"value\": \"http://www.example.com/user-agreement\"\n         }\n     ],\n     \"name\": \"LiveTestApp\",\n     \"capabilities\": [\n         {\n             \"scopes\": [],\n             \"name\": \"PAYPAL_ACCESS\",\n             \"attributes\": [\n                 {\n                     \"name\": \"openid_connect\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_date_of_birth\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_fullname\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_gender\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_zip\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_language\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_city\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_country\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_timezone\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_email\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_street_address1\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_street_address2\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_phone_number\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_locale\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_state\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_age_range\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_account_verified\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_account_creation_date\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_account_type\",\n                     \"value\": \"Y\"\n                 }\n             ]\n         },\n         {\n             \"scopes\": [\n                 \"https://api.paypal.com/v1/payments/.*\",\n                 \"https://api.paypal.com/v1/vault/credit-card\",\n                 \"https://api.paypal.com/v1/vault/credit-card/.*\"\n             ],\n             \"name\": \"PAYMENT\",\n             \"features\": [\n                 {\n                     \"status\": \"ACTIVE\",\n                     \"name\": \"ACCEPT_CARD\"\n                 },\n                 {\n                     \"status\": \"ACTIVE\",\n                     \"name\": \"ACCEPT_PAYPAL\"\n                 }\n             ]\n         }\n     ]\n }    ";
    }

    public final Map t()
    {
        return a;
    }

    public final String u()
    {
        return b;
    }

    public final String v()
    {
        return c;
    }

    public final String w()
    {
        return d;
    }

    static 
    {
        com/paypal/android/sdk/el.getSimpleName();
    }
}
