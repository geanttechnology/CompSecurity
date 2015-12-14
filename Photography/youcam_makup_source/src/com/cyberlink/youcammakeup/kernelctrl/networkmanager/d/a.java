// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.d;

import android.util.Log;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.l.c;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.database.more.types.CollageLayoutType;
import com.cyberlink.youcammakeup.database.more.types.CollageType;
import com.cyberlink.youcammakeup.database.more.types.OrderType;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.g;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bh;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bi;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bj;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bp;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bq;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.br;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.f;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class a
{

    private static boolean a = false;
    private g b;

    private a()
    {
    }

    static g a(a a1)
    {
        return a1.b;
    }

    static g a(a a1, g g)
    {
        a1.b = g;
        return g;
    }

    public static void a()
    {
        if (a)
        {
            Log.i("CollageTemplateRequest", "task already add to NetworkManager");
            return;
        } else
        {
            a = true;
            (new a()).b();
            return;
        }
    }

    private void a(NetworkManager networkmanager, int i, long l)
    {
        z.a("BEFORE_AFTER_COLLAGE_DOWNLOADED", Boolean.valueOf(false), Globals.d().getApplicationContext());
        networkmanager.a(new bi(networkmanager, new com.cyberlink.youcammakeup.database.more.types.a(OrderType.b, CategoryType.h, CollageType.b, CollageLayoutType.b), i, 30, new bj(l, networkmanager, i) {

            final long a;
            final NetworkManager b;
            final int c;
            final a d;

            public void a(bh bh1)
            {
                int j = bh1.c();
                f.a("ListTemplateTask");
                f.a("ListTemplateTask", bh1.a());
                if (a.a(d) == null)
                {
                    a.a(d, new g(this, bh1, j) {

                        final bh a;
                        final int b;
                        final _cls2 c;
                        private int d;

                        public void c(long l)
                        {
                            Iterator iterator = a.b().iterator();
                            do
                            {
                                if (!iterator.hasNext())
                                {
                                    break;
                                }
                                if (((c)iterator.next()).a() == l)
                                {
                                    d = d + 1;
                                }
                            } while (true);
                            Log.i("CollageTemplateRequest", (new StringBuilder()).append("requestCollageTemplatesList download (").append(d).append("/").append(b).append(")").toString());
                            if (d == b)
                            {
                                z.a("BEFORE_AFTER_COLLAGE_LAST_MODIFIED_DATE", Long.valueOf(c.a), Globals.d().getApplicationContext());
                                z.a("BEFORE_AFTER_COLLAGE_DOWNLOADED", Boolean.valueOf(true), Globals.d().getApplicationContext());
                                c.b.b(a.a(c.d));
                            }
                        }

            
            {
                c = _pcls2;
                a = bh1;
                b = i;
                super();
                d = 0;
            }
                    });
                    b.a(a.a(d));
                }
                for (Iterator iterator = bh1.b().iterator(); iterator.hasNext();)
                {
                    c c1 = (c)iterator.next();
                    try
                    {
                        b.a(c1.a(), c1, null);
                    }
                    catch (IOException ioexception)
                    {
                        ioexception.printStackTrace();
                    }
                }

                if (bh1.b().size() + c < j)
                {
                    a.a(d, b, bh1.b().size() + c, a);
                }
            }

            public void a(bn bn1)
            {
                if (bn1 == null);
            }

            public volatile void a(Object obj)
            {
                a((bh)obj);
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj)
            {
                a((bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                d = a.this;
                a = l;
                b = networkmanager;
                c = i;
                super();
            }
        }));
    }

    static void a(a a1, NetworkManager networkmanager, int i, long l)
    {
        a1.a(networkmanager, i, l);
    }

    private void b()
    {
        NetworkManager networkmanager = Globals.d().w();
        networkmanager.a(new bp(networkmanager, CategoryType.h.name(), String.valueOf(4F), new bq(networkmanager) {

            final NetworkManager a;
            final a b;

            public void a(bn bn1)
            {
                Log.i("CollageTemplateRequest", "requestTemplateStatus error");
            }

            public void a(br br1)
            {
                long l = br1.a();
                Log.i("CollageTemplateRequest", (new StringBuilder()).append("requestTemplateStatus complete. LastModified=").append(l).toString());
                if (l > z.d("BEFORE_AFTER_COLLAGE_LAST_MODIFIED_DATE", Globals.d().getApplicationContext()).longValue())
                {
                    a.a(b, a, 0, l);
                }
            }

            public volatile void a(Object obj)
            {
                a((br)obj);
            }

            public void a(Void void1)
            {
                Log.i("CollageTemplateRequest", "requestTemplateStatus cancel");
            }

            public void b(Object obj)
            {
                a((bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                b = a.this;
                a = networkmanager;
                super();
            }
        }));
    }

}
