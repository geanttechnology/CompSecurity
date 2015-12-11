// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import com.google.android.gms.common.api.e;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package android.support.v7:
//            aah, adi, aeh, abo, 
//            ael, adc, aed, aee, 
//            adb

public class aai
{
    public static interface a
    {

        public abstract aee a(Context context, aai aai1, Looper looper, String s, int i, aeh aeh1);
    }


    private static aai g;
    private final a a;
    private final Context b;
    private final aah c;
    private final adb d;
    private final ConcurrentMap e;
    private final aeh f;

    aai(Context context, a a1, aah aah1, adb adb1)
    {
        if (context == null)
        {
            throw new NullPointerException("context cannot be null");
        } else
        {
            b = context.getApplicationContext();
            d = adb1;
            a = a1;
            e = new ConcurrentHashMap();
            c = aah1;
            c.a(new aah.b() {

                final aai a;

                public void a(Map map)
                {
                    map = ((Map) (map.get("event")));
                    if (map != null)
                    {
                        aai.a(a, map.toString());
                    }
                }

            
            {
                a = aai.this;
                super();
            }
            });
            c.a(new adi(b));
            f = new aeh();
            c();
            return;
        }
    }

    public static aai a(Context context)
    {
        android/support/v7/aai;
        JVM INSTR monitorenter ;
        if (g != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        abo.a("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
        context;
        android/support/v7/aai;
        JVM INSTR monitorexit ;
        throw context;
        g = new aai(context, new a() {

            public aee a(Context context1, aai aai1, Looper looper, String s, int i, aeh aeh1)
            {
                return new aee(context1, aai1, looper, s, i, aeh1);
            }

        }, new aah(new ael(context)), adc.c());
        context = g;
        android/support/v7/aai;
        JVM INSTR monitorexit ;
        return context;
    }

    static void a(aai aai1, String s)
    {
        aai1.a(s);
    }

    private void a(String s)
    {
        for (Iterator iterator = e.keySet().iterator(); iterator.hasNext(); ((aed)iterator.next()).a(s)) { }
    }

    private void c()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            b.registerComponentCallbacks(new ComponentCallbacks2() {

                final aai a;

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
                        a.b();
                    }
                }

            
            {
                a = aai.this;
                super();
            }
            });
        }
    }

    public aah a()
    {
        return c;
    }

    public e a(String s, int i, String s1)
    {
        s = a.a(b, this, null, s, i, f);
        s.a(s1);
        return s;
    }

    void a(aed aed1)
    {
        e.put(aed1, Boolean.valueOf(true));
    }

    public void b()
    {
        d.a();
    }

    boolean b(aed aed1)
    {
        return e.remove(aed1) != null;
    }
}
