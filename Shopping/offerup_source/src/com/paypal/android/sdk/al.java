// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.paypal.android.sdk:
//            ao, z, aj, ai, 
//            ap

public final class al extends ao
{

    private String a;
    private HashMap b;
    private Map c;
    private Handler d;
    private boolean e;

    public al(String s, HashMap hashmap, Handler handler, boolean flag)
    {
        a = s;
        b = hashmap;
        c = new HashMap();
        d = handler;
        e = flag;
    }

    public final void run()
    {
        int i;
        i = 1;
        if (d == null)
        {
            return;
        }
        d.sendMessage(Message.obtain(d, 0, a));
        if (!e)
        {
            c.put("CLIENT-AUTH", "No cert");
        }
        c.put("X-PAYPAL-RESPONSE-DATA-FORMAT", "NV");
        c.put("X-PAYPAL-REQUEST-DATA-FORMAT", "NV");
        c.put("X-PAYPAL-SERVICE-VERSION", "1.0.0");
        if (!e) goto _L2; else goto _L1
_L1:
        Object obj;
        StringBuilder stringbuilder;
        Object obj1;
        obj = z.a.a();
        ((ai) (obj)).a(Uri.parse(a));
        ((ai) (obj)).a(c);
        obj1 = b;
        stringbuilder = new StringBuilder();
        obj1 = ((HashMap) (obj1)).entrySet().iterator();
_L5:
        if (!((Iterator) (obj1)).hasNext()) goto _L4; else goto _L3
_L3:
        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
        if (!i)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        i = 0;
_L6:
        stringbuilder.append(URLEncoder.encode((String)entry.getKey(), "UTF-8"));
        stringbuilder.append("=");
        stringbuilder.append(URLEncoder.encode((String)entry.getValue(), "UTF-8"));
          goto _L5
        stringbuilder.append("&");
          goto _L6
_L4:
        i = ((ai) (obj)).a(stringbuilder.toString().getBytes("UTF-8"));
        Exception exception;
        if (i == 200)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        try
        {
            throw new Exception((new StringBuilder("Network Connection Error with wrong http code: ")).append(i).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            ap.a().b(this);
        }
        d.sendMessage(Message.obtain(d, 1, obj));
        ap.a().b(this);
        return;
        obj = new String(((ai) (obj)).a(), "UTF-8");
        d.sendMessage(Message.obtain(d, 2, obj));
_L8:
        ap.a().b(this);
        return;
_L2:
        d.sendMessage(Message.obtain(d, 2, "not supported"));
        if (true) goto _L8; else goto _L7
_L7:
        throw exception;
    }

    static 
    {
        com/paypal/android/sdk/z.getSimpleName();
    }
}
