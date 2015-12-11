// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.amazon.device.ads:
//            co, ds, cn, at

class dn
{
    public static interface a
    {

        public abstract void e();
    }

    final class b extends c
    {

        final dn a;

        public b(Class class1, Object obj)
        {
            a = dn.this;
            super(class1, obj);
            d = true;
        }
    }

    class c
    {

        public Class b;
        public Object c;
        public boolean d;
        final dn e;

        public c(Class class1, Object obj)
        {
            e = dn.this;
            super();
            b = class1;
            c = obj;
        }
    }


    private static final String g = com/amazon/device/ads/dn.getSimpleName();
    private static dn h = new dn();
    ArrayList a;
    final ReentrantLock b = new ReentrantLock();
    final ConcurrentHashMap c = new ConcurrentHashMap();
    SharedPreferences d;
    final CountDownLatch e = new CountDownLatch(1);
    final cn f;
    private final ReentrantLock i = new ReentrantLock();

    protected dn()
    {
        new co();
        f = co.a(g);
        a = new ArrayList();
    }

    public static dn a()
    {
        return h;
    }

    static ReentrantLock a(dn dn1)
    {
        return dn1.i;
    }

    static void a(dn dn1, android.content.SharedPreferences.Editor editor)
    {
        if (ds.b())
        {
            dn1.f.d("Committing settings must be executed on a background thread.", null);
        }
        if (at.a(9))
        {
            at.a(editor);
            return;
        } else
        {
            editor.commit();
            return;
        }
    }

    static ConcurrentHashMap b(dn dn1)
    {
        return dn1.c;
    }

    public final int a(String s)
    {
        s = (c)c.get(s);
        if (s == null)
        {
            return 0;
        } else
        {
            return ((Integer)((c) (s)).c).intValue();
        }
    }

    public final long a(String s, long l)
    {
        s = (c)c.get(s);
        if (s == null)
        {
            return l;
        } else
        {
            return ((Long)((c) (s)).c).longValue();
        }
    }

    public final String a(String s, String s1)
    {
        s = (c)c.get(s);
        if (s == null)
        {
            return s1;
        } else
        {
            return (String)((c) (s)).c;
        }
    }

    final void a(SharedPreferences sharedpreferences)
    {
        ds.a(new Runnable(sharedpreferences) {

            final SharedPreferences a;
            final dn b;

            public final void run()
            {
                dn.a(b).lock();
                android.content.SharedPreferences.Editor editor = a.edit();
                editor.clear();
                Iterator iterator = dn.b(b).entrySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    c c1 = (c)entry.getValue();
                    if (!c1.d)
                    {
                        if (c1.b == java/lang/String)
                        {
                            editor.putString((String)entry.getKey(), (String)c1.c);
                        } else
                        if (c1.b == java/lang/Long)
                        {
                            editor.putLong((String)entry.getKey(), ((Long)c1.c).longValue());
                        } else
                        if (c1.b == java/lang/Integer)
                        {
                            editor.putInt((String)entry.getKey(), ((Integer)c1.c).intValue());
                        } else
                        if (c1.b == java/lang/Boolean)
                        {
                            editor.putBoolean((String)entry.getKey(), ((Boolean)c1.c).booleanValue());
                        }
                    }
                } while (true);
                dn.a(b, editor);
                dn.a(b).unlock();
            }

            
            {
                b = dn.this;
                a = sharedpreferences;
                super();
            }
        });
    }

    final void a(String s, c c1)
    {
        if (c1.c == null)
        {
            f.c("Could not set null value for setting: %s", new Object[] {
                s
            });
        } else
        {
            b(s, c1);
            if (!c1.d && b())
            {
                c();
                return;
            }
        }
    }

    public final boolean a(String s, boolean flag)
    {
        s = b(s);
        if (s == null)
        {
            return flag;
        } else
        {
            return s.booleanValue();
        }
    }

    public final Boolean b(String s)
    {
        s = (c)c.get(s);
        if (s == null)
        {
            return null;
        } else
        {
            return (Boolean)((c) (s)).c;
        }
    }

    final void b(String s, long l)
    {
        b(s, new c(java/lang/Long, Long.valueOf(l)));
    }

    final void b(String s, c c1)
    {
        if (c1.c == null)
        {
            f.c("Could not set null value for setting: %s", new Object[] {
                s
            });
            return;
        } else
        {
            c.put(s, c1);
            return;
        }
    }

    final void b(String s, String s1)
    {
        a(s, new c(java/lang/String, s1));
    }

    final void b(String s, boolean flag)
    {
        b(s, new c(java/lang/Boolean, Boolean.valueOf(flag)));
    }

    public final boolean b()
    {
        return d != null;
    }

    final void c()
    {
        a(d);
    }

    final void c(String s)
    {
        s = (c)c.remove(s);
        if (s != null && !((c) (s)).d && b())
        {
            c();
        }
    }

    final void c(String s, String s1)
    {
        b(s, new c(java/lang/String, s1));
    }


    // Unreferenced inner class com/amazon/device/ads/dn$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        final Context a;
        final dn b;

        public final void run()
        {
            dn dn1 = b;
            Object obj = a;
            if (!dn1.b())
            {
                obj = ((Context) (obj)).getSharedPreferences("AmazonMobileAds", 0);
                Iterator iterator1 = ((SharedPreferences) (obj)).getAll().entrySet().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    Object obj1 = (java.util.Map.Entry)iterator1.next();
                    String s = (String)((java.util.Map.Entry) (obj1)).getKey();
                    if (s != null && !dn1.c.containsKey(s))
                    {
                        obj1 = ((java.util.Map.Entry) (obj1)).getValue();
                        if (obj1 != null)
                        {
                            dn1.c.put(s, dn1. new c(obj1.getClass(), obj1));
                        } else
                        {
                            dn1.f.c("Could not cache null value for SharedPreferences setting: %s", new Object[] {
                                s
                            });
                        }
                    }
                } while (true);
                dn1.d = ((SharedPreferences) (obj));
                dn1.a(((SharedPreferences) (obj)));
            }
            dn1.e.countDown();
            dn1.b.lock();
            for (Iterator iterator = dn1.a.iterator(); iterator.hasNext(); ((a)iterator.next()).e()) { }
            dn1.a.clear();
            dn1.a = null;
            dn1.b.unlock();
        }

            
            {
                b = dn.this;
                a = context;
                super();
            }
    }

}
