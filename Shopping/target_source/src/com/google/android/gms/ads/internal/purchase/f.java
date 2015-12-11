// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.b;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{

    public f()
    {
    }

    public int a(Intent intent)
    {
        intent = ((Intent) (intent.getExtras().get("RESPONSE_CODE")));
        if (intent == null)
        {
            com.google.android.gms.ads.internal.util.client.b.e("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        if (intent instanceof Integer)
        {
            return ((Integer)intent).intValue();
        }
        if (intent instanceof Long)
        {
            return (int)((Long)intent).longValue();
        } else
        {
            com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Unexpected type for intent response code. ").append(intent.getClass().getName()).toString());
            return 5;
        }
    }

    public int a(Bundle bundle)
    {
        bundle = ((Bundle) (bundle.get("RESPONSE_CODE")));
        if (bundle == null)
        {
            com.google.android.gms.ads.internal.util.client.b.e("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        if (bundle instanceof Integer)
        {
            return ((Integer)bundle).intValue();
        }
        if (bundle instanceof Long)
        {
            return (int)((Long)bundle).longValue();
        } else
        {
            com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Unexpected type for intent response code. ").append(bundle.getClass().getName()).toString());
            return 5;
        }
    }

    public String a(String s)
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = JSONObjectInstrumentation.init(s).getString("developerPayload");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.google.android.gms.ads.internal.util.client.b.e("Fail to parse purchase data");
            return null;
        }
        return s;
    }

    public String b(Intent intent)
    {
        if (intent == null)
        {
            return null;
        } else
        {
            return intent.getStringExtra("INAPP_PURCHASE_DATA");
        }
    }

    public String c(Intent intent)
    {
        if (intent == null)
        {
            return null;
        } else
        {
            return intent.getStringExtra("INAPP_DATA_SIGNATURE");
        }
    }
}
