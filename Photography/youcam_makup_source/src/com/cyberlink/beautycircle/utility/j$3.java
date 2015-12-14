// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.SharedPreferences;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            j, k, l

class b extends j
{

    final String a;
    final l b;
    final com.cyberlink.beautycircle.utility.j c;

    public volatile Object a(Object obj)
    {
        return a((d)obj);
    }

    public Void a(d d1)
    {
        e.b(new Object[] {
            "Query default cover success."
        });
        Object obj = (new StringBuilder()).append("BC_Default_Cover_").append(a).toString();
        Globals.D().edit().putString(((String) (obj)), d1.toString()).commit();
        obj = new k(c, null);
        ((k) (obj)).a(d1);
        j.a(c).replace(a, obj);
        d1 = ((k) (obj)).a();
        if (b != null)
        {
            b.a(d1);
        }
        return null;
    }

    public void a(int i)
    {
        super.a(i);
        e.b(new Object[] {
            (new StringBuilder()).append("Query default cover faile : ").append(i).toString()
        });
        b.a();
    }

    k.d(com.cyberlink.beautycircle.utility.j j1, String s, l l1)
    {
        c = j1;
        a = s;
        b = l1;
        super();
    }
}
