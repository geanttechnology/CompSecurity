// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.analytics.tracking.android:
//            ae, ak, ai, aj, 
//            aq, ba, aw

final class af
    implements Runnable
{

    final Map a;
    final ae b;

    af(ae ae1, Map map)
    {
        b = ae1;
        a = map;
        super();
    }

    public final void run()
    {
        if (TextUtils.isEmpty((CharSequence)a.get("&cid")))
        {
            a.put("&cid", ae.a(b));
        }
        Object obj = ak.a(ae.b(b));
        ai.a().a(aj.R);
        if (((ak) (obj)).a.booleanValue() || ae.b(a))
        {
            return;
        }
        if (!TextUtils.isEmpty(ae.c(b)))
        {
            ai.a().a(true);
            obj = a;
            Object obj1 = new aq();
            Object obj2 = ae.c(b);
            ai.a().a(aj.d);
            obj2 = ba.d(((String) (obj2)));
            String s;
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                obj2 = ba.a(((String) (obj2)));
                ((aq) (obj1)).a("&cc", (String)((Map) (obj2)).get("utm_content"));
                ((aq) (obj1)).a("&cm", (String)((Map) (obj2)).get("utm_medium"));
                ((aq) (obj1)).a("&cn", (String)((Map) (obj2)).get("utm_campaign"));
                ((aq) (obj1)).a("&cs", (String)((Map) (obj2)).get("utm_source"));
                ((aq) (obj1)).a("&ck", (String)((Map) (obj2)).get("utm_term"));
                ((aq) (obj1)).a("&ci", (String)((Map) (obj2)).get("utm_id"));
                ((aq) (obj1)).a("&gclid", (String)((Map) (obj2)).get("gclid"));
                ((aq) (obj1)).a("&dclid", (String)((Map) (obj2)).get("dclid"));
                ((aq) (obj1)).a("&gmob_t", (String)((Map) (obj2)).get("gmob_t"));
            }
            ((Map) (obj)).putAll(((aq) (obj1)).a());
            ai.a().a(false);
            ae.d(b);
        }
        ae.c(a);
        obj1 = a;
        obj = new HashMap();
        obj1 = ((Map) (obj1)).entrySet().iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            obj2 = (java.util.Map.Entry)((Iterator) (obj1)).next();
            if (((String)((java.util.Map.Entry) (obj2)).getKey()).startsWith("&") && ((java.util.Map.Entry) (obj2)).getValue() != null)
            {
                s = ((String)((java.util.Map.Entry) (obj2)).getKey()).substring(1);
                if (!TextUtils.isEmpty(s))
                {
                    ((Map) (obj)).put(s, ((java.util.Map.Entry) (obj2)).getValue());
                }
            }
        } while (true);
        ae.f(b).a(((Map) (obj)), Long.valueOf((String)a.get("&ht")).longValue(), ae.d(a), ae.e(b));
    }
}
