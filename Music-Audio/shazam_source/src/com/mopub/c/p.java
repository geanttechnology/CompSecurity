// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.m;
import com.mopub.d.d;
import com.mopub.d.i;
import com.mopub.d.l;
import com.mopub.d.n;
import com.mopub.d.s;
import com.mopub.mobileads.ab;
import com.mopub.mobileads.ac;
import com.mopub.mobileads.ae;
import com.mopub.mobileads.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.mopub.c:
//            i, g

public final class p extends l
{
    public static interface a
        extends com.mopub.d.n.a
    {

        public abstract void a(String s);
    }


    private final a l;

    private p(String s, a a1)
    {
        super(0, s, a1);
        l = a1;
        super.g = false;
        super.j = new d(2500, 1, 1.0F);
    }

    public static void a(Iterable iterable, Context context)
    {
        c(iterable, context);
    }

    public static void a(String s, Context context)
    {
        if (s != null)
        {
            c(Arrays.asList(new String[] {
                s
            }), context);
        }
    }

    public static void a(List list, y y1, Integer integer, String s, Context context)
    {
        m.a(list);
        ArrayList arraylist = new ArrayList(list.size());
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            ae ae1 = (ae)list.next();
            if (ae1 != null && (!ae1.b || ae1.c))
            {
                arraylist.add(ae1.a());
                ae1.b = true;
            }
        } while (true);
        list = new ac(arraylist);
        if (y1 != null)
        {
            ((ac) (list)).a.put(ab.a, y1.g);
        }
        a(((Iterable) (list.a(integer).a(s).a())), context);
    }

    public static void b(Iterable iterable, Context context)
    {
        c(iterable, context);
    }

    public static void c(Iterable iterable, Context context)
    {
        if (iterable != null && context != null)
        {
            context = i.a(context);
            iterable = iterable.iterator();
            while (iterable.hasNext()) 
            {
                String s = (String)iterable.next();
                if (!TextUtils.isEmpty(s))
                {
                    context.b(new p(s, new a(s) {

                        final a a = null;
                        final String b;

                        public final void a(s s1)
                        {
                            com.mopub.common.c.a.b((new StringBuilder("Failed to hit tracking endpoint: ")).append(b).toString());
                            if (a != null)
                            {
                                a.a(s1);
                            }
                        }

                        public final void a(String s1)
                        {
                            com.mopub.common.c.a.b((new StringBuilder("Successfully hit tracking endpoint: ")).append(s1).toString());
                            if (a != null)
                            {
                                a.a(s1);
                            }
                        }

            
            {
                b = s;
                super();
            }
                    }));
                }
            }
        }
    }

    protected final n a(i j)
    {
        if (j.a != 200)
        {
            return n.a(new g((new StringBuilder("Failed to log tracking request. Response code: ")).append(j.a).append(" for url: ").append(super.b).toString(), g.a.e));
        } else
        {
            return n.a(null, com.mopub.d.a.d.a(j));
        }
    }

    public final volatile void a(Object obj)
    {
        if (l != null)
        {
            l.a(super.b);
        }
    }
}
