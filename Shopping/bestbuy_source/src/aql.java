// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class aql
{

    private static aql g;
    private final aqm a;
    private final Context b;
    private final aqg c;
    private final aru d;
    private final ConcurrentMap e;
    private final asg f;

    aql(Context context, aqm aqm, aqg aqg1, aru aru1)
    {
        if (context == null)
        {
            throw new NullPointerException("context cannot be null");
        } else
        {
            b = context.getApplicationContext();
            d = aru1;
            a = aqm;
            e = new ConcurrentHashMap();
            c = aqg1;
            c.a(new aqi() {

                final aql a;

                public void a(Map map)
                {
                    map = ((Map) (map.get("event")));
                    if (map != null)
                    {
                        aql.a(a, map.toString());
                    }
                }

            
            {
                a = aql.this;
                super();
            }
            });
            c.a(new arx(b));
            f = new asg();
            b();
            return;
        }
    }

    public static aql a(Context context)
    {
        aql;
        JVM INSTR monitorenter ;
        if (g != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        aqv.a("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
        context;
        aql;
        JVM INSTR monitorexit ;
        throw context;
        g = new aql(context, new aqm() {

        }, new aqg(new asi(context)), arv.b());
        context = g;
        aql;
        JVM INSTR monitorexit ;
        return context;
    }

    static void a(aql aql1, String s)
    {
        aql1.a(s);
    }

    private void a(String s)
    {
        for (Iterator iterator = e.keySet().iterator(); iterator.hasNext(); ((asd)iterator.next()).a(s)) { }
    }

    private void b()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            b.registerComponentCallbacks(new ComponentCallbacks2() {

                final aql a;

                public void onConfigurationChanged(Configuration configuration)
                {
                }

                public void onLowMemory()
                {
                }

                public void onTrimMemory(int i)
                {
                    if (i == 20)
                    {
                        a.a();
                    }
                }

            
            {
                a = aql.this;
                super();
            }
            });
        }
    }

    public void a()
    {
        d.a();
    }

    public boolean a(Uri uri)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = arg.a();
        if (!((arg) (obj)).a(uri)) goto _L2; else goto _L1
_L1:
        int i;
        uri = ((arg) (obj)).d();
        class _cls4
        {

            static final int a[];

            static 
            {
                a = new int[arh.a().length];
                try
                {
                    a[arh.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[arh.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[arh.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        i = _cls4.a[((arg) (obj)).b().ordinal()];
        i;
        JVM INSTR tableswitch 1 3: default 60
    //                   1 68
    //                   2 130
    //                   3 130;
           goto _L3 _L4 _L5 _L5
_L3:
        boolean flag = true;
_L9:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        obj = e.keySet().iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            asd asd1 = (asd)((Iterator) (obj)).next();
            if (asd1.d().equals(uri))
            {
                asd1.b(null);
                asd1.c();
            }
        }
          goto _L3
        uri;
        throw uri;
_L5:
        Iterator iterator = e.keySet().iterator();
_L7:
        asd asd2;
        while (iterator.hasNext()) 
        {
            asd2 = (asd)iterator.next();
            if (!asd2.d().equals(uri))
            {
                continue; /* Loop/switch isn't completed */
            }
            asd2.b(((arg) (obj)).c());
            asd2.c();
        }
          goto _L3
        if (asd2.e() == null) goto _L7; else goto _L6
_L6:
        asd2.b(null);
        asd2.c();
        if (true) goto _L7; else goto _L8
_L8:
          goto _L3
_L2:
        flag = false;
          goto _L9
    }

    boolean a(asd asd1)
    {
        return e.remove(asd1) != null;
    }
}
