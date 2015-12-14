// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.e;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            m, k, l

public class j
{

    public static ExecutorService a = Executors.newFixedThreadPool(10);
    private ConcurrentHashMap b;

    public j()
    {
        b = new ConcurrentHashMap();
    }

    public static j a()
    {
        return m.a();
    }

    static ConcurrentHashMap a(j j1)
    {
        return j1.b;
    }

    static void a(j j1, String s, l l1)
    {
        j1.c(s, l1);
    }

    private void c(String s, l l1)
    {
        if (s == null)
        {
            return;
        }
        e.b(new Object[] {
            (new StringBuilder()).append("UserType :").append(s).toString()
        });
        Object obj = (new StringBuilder()).append("BC_Default_Cover_").append(s).toString();
        obj = new d(com/cyberlink/beautycircle/model/network/NetworkUser$DefaultCover, Globals.D().getString(((String) (obj)), null));
        k k1 = new k(this);
        k1.a(((d) (obj)));
        b.putIfAbsent(s, k1);
        obj = k1.a();
        if (l1 != null)
        {
            l1.a(((android.net.Uri) (obj)));
        }
        d(s, l1);
    }

    private void d(String s, l l1)
    {
        if (s == null)
        {
            return;
        } else
        {
            e.b(new Object[] {
                (new StringBuilder()).append("UserType :").append(s).toString()
            });
            NetworkUser.d(s).a(new com.perfectcorp.utility.j(s, l1) {

                final String a;
                final l b;
                final j c;

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
                    obj = new k(c);
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

            
            {
                c = j.this;
                a = s;
                b = l1;
                super();
            }
            });
            return;
        }
    }

    public AsyncTask a(String s, l l1)
    {
        return (new AsyncTask(s, l1) {

            final String a;
            final l b;
            final j c;

            protected transient Void a(Void avoid[])
            {
                String s1 = a;
                avoid = s1;
                if (s1 == null)
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

            
            {
                c = j.this;
                a = s;
                b = l1;
                super();
            }
        }).executeOnExecutor(a, new Void[0]);
    }

    public AsyncTask b(String s, l l1)
    {
        return (new AsyncTask(s, l1) {

            final String a;
            final l b;
            final j c;

            protected transient Void a(Void avoid[])
            {
                String s1 = a;
                avoid = s1;
                if (s1 == null)
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
                    avoid = ((k)j.a(c).get(avoid)).b();
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

            
            {
                c = j.this;
                a = s;
                b = l1;
                super();
            }
        }).executeOnExecutor(a, new Void[0]);
    }

}
