// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.net.Uri;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            JsonModel

public class PaymentSession extends JsonModel
    implements Serializable
{

    static Map payPalDomainMapping;
    public final String paymentSessionId;
    public final boolean redirectRequired;
    public final String returnUrl;

    public PaymentSession(JSONObject jsonobject)
        throws JSONException
    {
        super(jsonobject.getJSONObject("cartResponse"));
        String s = "";
        Object obj = getObject(jsonobject, new String[] {
            "returnURLs"
        });
        String s1 = s;
        if (obj != null)
        {
            obj = getArray(((JSONObject) (obj)), new String[] {
                "url"
            });
            s1 = s;
            if (obj != null)
            {
                int i = 0;
                do
                {
                    s1 = s;
                    if (i >= ((JSONArray) (obj)).length())
                    {
                        break;
                    }
                    JSONObject jsonobject1 = ((JSONArray) (obj)).getJSONObject(i);
                    s1 = s;
                    if (jsonobject1.has("@type"))
                    {
                        s1 = s;
                        if ("redirectUrl".equals(jsonobject1.get("@type")))
                        {
                            s1 = jsonobject1.getString("__value__");
                        }
                    }
                    i++;
                    s = s1;
                } while (true);
            }
        }
        s = "";
        Object obj1 = getObject(jsonobject, new String[] {
            "paymentAttributes"
        });
        obj = s;
        if (obj1 != null)
        {
            obj1 = getArray(((JSONObject) (obj1)), new String[] {
                "attribute"
            });
            obj = s;
            if (obj1 != null)
            {
                int j = 0;
                do
                {
                    obj = s;
                    if (j >= ((JSONArray) (obj1)).length())
                    {
                        break;
                    }
                    JSONObject jsonobject2 = ((JSONArray) (obj1)).getJSONObject(j);
                    obj = s;
                    if (jsonobject2.has("@name"))
                    {
                        obj = s;
                        if ("PaymentSessionId".equals(jsonobject2.get("@name")))
                        {
                            obj = jsonobject2.getString("__value__");
                        }
                    }
                    j++;
                    s = ((String) (obj));
                } while (true);
            }
        }
        returnUrl = shortCircuitRedirect(s1).replace("_express-checkout&", "_express-checkout-mobile&");
        paymentSessionId = ((String) (obj));
        redirectRequired = getBoolean(jsonobject, "redirectRequired").booleanValue();
    }

    public static final String shortCircuitRedirect(String s)
    {
        String s1 = s;
        String s3 = Uri.parse(s).getHost();
        String s2 = s1;
        if (!TextUtils.isEmpty(s3))
        {
            s2 = s1;
            if (payPalDomainMapping.containsKey(s3))
            {
                int i = s.indexOf(s3);
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append(s.substring(0, s.indexOf(s3)));
                stringbuilder.append((String)payPalDomainMapping.get(s3));
                stringbuilder.append(s.substring(s3.length() + i));
                s2 = stringbuilder.toString();
            }
        }
        return s2;
    }

    static 
    {
        payPalDomainMapping = new HashMap();
        payPalDomainMapping.put("www.paypal.at", "www.paypal.com/at");
        payPalDomainMapping.put("www.paypal.au", "www.paypal.com/au");
        payPalDomainMapping.put("www.paypal.be", "www.paypal.com/be");
        payPalDomainMapping.put("www.paypal.ch", "www.paypal.com/ch");
        payPalDomainMapping.put("www.paypal.cn", "www.paypal.com/cn");
        payPalDomainMapping.put("www.paypal.de", "www.paypal.com/de");
        payPalDomainMapping.put("www.paypal.es", "www.paypal.com/es");
        payPalDomainMapping.put("www.paypal.fr", "www.paypal.com/fr");
        payPalDomainMapping.put("www.paypal.hk", "www.paypal.com/hk");
        payPalDomainMapping.put("www.paypal.it", "www.paypal.com/it");
        payPalDomainMapping.put("www.paypal.nl", "www.paypal.com/nl");
        payPalDomainMapping.put("www.paypal.sg", "www.paypal.com/sg");
        payPalDomainMapping.put("www.paypal.pl", "www.paypal.com/pl");
        payPalDomainMapping.put("www.paypal.ph", "www.paypal.com/ph");
    }
}
