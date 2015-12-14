// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.d;
import com.cyberlink.you.database.o;
import com.cyberlink.you.e;
import com.cyberlink.you.utility.h;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you.friends:
//            g, h, f, UserInfo, 
//            Friend, l, i, j, 
//            e

public class c
{

    private static final String a = com/cyberlink/you/friends/c.getSimpleName();
    private Handler b;
    private i c;
    private j d;
    private com.cyberlink.you.friends.e e;
    private Executor f;
    private AsyncTask g;
    private String h;
    private String i;
    private l j;
    private List k;
    private Object l;
    private boolean m;
    private boolean n;
    private Class o;

    private c()
    {
        b = new Handler(Looper.getMainLooper());
        c = new g(this);
        d = new com.cyberlink.you.friends.h(this);
        e = new f(this);
        f = AsyncTask.SERIAL_EXECUTOR;
        m = false;
        n = false;
    }


    static com.cyberlink.you.friends.e a(c c1, com.cyberlink.you.friends.e e1)
    {
        c1.e = e1;
        return e1;
    }

    static i a(c c1, i i1)
    {
        c1.c = i1;
        return i1;
    }

    static j a(c c1)
    {
        return c1.d;
    }

    static l a(c c1, l l1)
    {
        c1.j = l1;
        return l1;
    }

    static Class a(c c1, Class class1)
    {
        c1.o = class1;
        return class1;
    }

    static Object a(c c1, Object obj)
    {
        c1.l = obj;
        return obj;
    }

    private Object a(String s)
    {
        if (n)
        {
            return b(s);
        }
        if (o.getName().equals(com/cyberlink/you/friends/UserInfo.getName()))
        {
            return com.cyberlink.you.utility.h.b(com.cyberlink.you.utility.h.a(s));
        }
        if (o.getName().equals(com/cyberlink/you/friends/Friend.getName()))
        {
            return com.cyberlink.you.utility.h.a(com.cyberlink.you.utility.h.a(s));
        }
        if (o.getName().equals(com/cyberlink/you/database/Group.getName()))
        {
            return com.cyberlink.you.utility.h.c(com.cyberlink.you.utility.h.a(s));
        } else
        {
            return "";
        }
    }

    static String a(c c1, String s)
    {
        c1.h = s;
        return s;
    }

    static List a(c c1, List list)
    {
        c1.k = list;
        return list;
    }

    static Executor a(c c1, Executor executor)
    {
        c1.f = executor;
        return executor;
    }

    private void a(Object obj)
    {
        if (!o.getName().equals(com/cyberlink/you/friends/Friend.getName())) goto _L2; else goto _L1
_L1:
        if (!n) goto _L4; else goto _L3
_L3:
        com.cyberlink.you.e.g().b((List)obj);
_L6:
        return;
_L4:
        com.cyberlink.you.e.g().a((Friend)obj);
        return;
_L2:
        if (o.getName().equals(com/cyberlink/you/database/Group.getName()) && !n)
        {
            com.cyberlink.you.e.f().a((Group)obj);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static boolean a(c c1, boolean flag)
    {
        c1.n = flag;
        return flag;
    }

    static com.cyberlink.you.friends.e b(c c1)
    {
        return c1.e;
    }

    private Object b(String s)
    {
        if (o.getName().equals(com/cyberlink/you/friends/Friend.getName()))
        {
            return com.cyberlink.you.utility.h.b(com.cyberlink.you.utility.h.b(s));
        } else
        {
            return "";
        }
    }

    static String b(c c1, String s)
    {
        c1.i = s;
        return s;
    }

    static boolean b(c c1, boolean flag)
    {
        c1.m = flag;
        return flag;
    }

    static i c(c c1)
    {
        return c1.c;
    }

    private String c(String s)
    {
        String s1 = null;
        if (s != null)
        {
            try
            {
                s1 = (new JSONObject(s)).getString("errorMessage");
            }
            catch (JSONException jsonexception)
            {
                Log.e(a, (new StringBuilder()).append("wrong json response:").append(s).toString(), jsonexception);
                return null;
            }
        }
        return s1;
    }

    private void d(String s)
    {
        b.post(new Runnable(s) {

            final String a;
            final c b;

            public void run()
            {
                c.c(b).a(a);
            }

            
            {
                b = c.this;
                a = s;
                super();
            }
        });
    }

    protected transient Object a(String as[])
    {
        String s = as[0];
        as = as[1];
        Object obj1 = j.b(s, as, k);
        String s1 = (String)((Pair) (obj1)).first;
        obj1 = (String)((Pair) (obj1)).second;
        Log.d(a, (new StringBuilder()).append("response:").append(((String) (obj1))).toString());
        if (s1 == null)
        {
            d((new StringBuilder()).append("Server connection fail or table=").append(s).append(" field=").append(as).append(" command does not exists").toString());
            as = null;
        } else
        {
            if (s1 == null || !s1.equals("200"))
            {
                d(c(((String) (obj1))));
                return null;
            }
            Object obj = a(((String) (obj1)));
            Log.d(a, (new StringBuilder()).append("parseResult:").append(obj).toString());
            as = ((String []) (obj));
            if (m)
            {
                a(obj);
                return obj;
            }
        }
        return as;
    }

    public void a()
    {
        g = new AsyncTask() {

            final c a;

            protected transient Object a(String as[])
            {
                return a.a(as);
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((String[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                super.onPostExecute(obj);
                c.a(a, obj);
                if (obj != null)
                {
                    c.b(a).a(obj);
                    return;
                } else
                {
                    c.c(a).a("result is null.");
                    return;
                }
            }

            protected void onPreExecute()
            {
                super.onPreExecute();
                c.a(a).a();
            }

            
            {
                a = c.this;
                super();
            }
        };
        g.executeOnExecutor(f, new String[] {
            h, i
        });
    }

}
