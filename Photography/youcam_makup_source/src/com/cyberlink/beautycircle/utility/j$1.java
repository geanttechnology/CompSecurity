// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.os.AsyncTask;
import com.perfectcorp.utility.e;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            j, k, l

class b extends AsyncTask
{

    final String a;
    final l b;
    final j c;

    protected transient Void a(Void avoid[])
    {
        String s = a;
        avoid = s;
        if (s == null)
        {
            e.b(new Object[] {
                "The user type is null. Set to Normal"
            });
            avoid = "Normal";
        }
        if (j.a(c).containsKey(avoid))
        {
            e.b(new Object[] {
                (new StringBuilder()).append("Already has default cover in cover map. UserType:").append(avoid).toString()
            });
            avoid = ((k)j.a(c).get(avoid)).a();
            if (b != null)
            {
                b.a(avoid);
            }
        } else
        {
            j.a(c, avoid, b);
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    (j j1, String s, l l1)
    {
        c = j1;
        a = s;
        b = l1;
        super();
    }
}
