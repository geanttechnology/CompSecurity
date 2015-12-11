// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.kahuna.sdk:
//            m, r, j, v, 
//            c, u

class it>
    implements Runnable
{

    final j a;
    final m b;

    public void run()
    {
        Object obj;
        Object obj1;
        obj1 = r.e(m.a(b));
        if (a != null)
        {
            obj = a.a();
        } else
        {
            obj = new HashMap();
        }
        if (!((Map) (obj1)).isEmpty()) goto _L2; else goto _L1
_L1:
        if (!v.a(a)) goto _L4; else goto _L3
_L3:
        return;
_L4:
        boolean flag;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("login() called and no previous credentials found. Storing new credentials: ").append(obj).toString());
        }
        r.b(((Map) (obj)), m.a(b));
        flag = true;
_L7:
        if (flag)
        {
            obj1 = new c("k_user_login");
            ((c) (obj1)).a(((Map) (obj)));
            m.a(b, ((c) (obj1)));
            return;
        }
          goto _L5
_L2:
        if (v.a(a))
        {
            if (m.a)
            {
                Log.d("Kahuna", "login() called with previous credentials but new credentials are empty. Triggering empty k_user_login.");
            }
            m.p(b);
            flag = true;
            obj = null;
        } else
        if (!a.a(new u(((Map) (obj1)))))
        {
            if (v.a(((Map) (obj1)), ((Map) (obj))))
            {
                for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext();)
                {
                    java.util.ntry ntry = (java.util.ntry)((Iterator) (obj)).next();
                    if (((Map) (obj1)).containsKey(ntry.getKey()))
                    {
                        ((Set)((Map) (obj1)).get(ntry.getKey())).addAll((Collection)ntry.getValue());
                    } else
                    {
                        ((Map) (obj1)).put(ntry.getKey(), ntry.getValue());
                    }
                }

                if (m.a)
                {
                    Log.d("Kahuna", (new StringBuilder()).append("login() called with overlapping credentials. Merging all credentials: ").append(obj1).toString());
                }
                r.b(((Map) (obj1)), m.a(b));
                flag = true;
                obj = obj1;
            } else
            {
                if (m.a)
                {
                    Log.d("Kahuna", "login() called with no overlapping credentials. Sending up only new credentials.");
                }
                m.p(b);
                r.b(((Map) (obj)), m.a(b));
                flag = true;
            }
        } else
        {
            if (m.a)
            {
                Log.d("Kahuna", "login() called with no change in credentials.");
            }
            flag = false;
            obj = null;
        }
        if (true) goto _L7; else goto _L6
_L6:
_L5:
        if (true) goto _L3; else goto _L8
_L8:
    }

    (m m1, j j1)
    {
        b = m1;
        a = j1;
        super();
    }
}
