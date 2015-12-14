// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.a.c;
import com.cyberlink.youcammakeup.database.a.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.g;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bf;
import com.cyberlink.youcammakeup.utility.f;
import com.pf.common.utility.m;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner:
//            a

public class BannerRequest
{

    public static String a()
    {
        if (bf.a())
        {
            return "try_16to9.jpg";
        } else
        {
            return "try_4to3.jpg";
        }
    }

    public static void a(c c1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.a a1)
    {
        if (c1.b() < System.currentTimeMillis())
        {
            return;
        }
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.e e1 = new com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.e(c1) {

            final c a;

            public long l()
            {
                return 0L;
            }

            public String m()
            {
                return a.a();
            }

            public String n()
            {
                return "weekStar";
            }

            public URI o()
            {
                return URI.create(a.f());
            }

            
            {
                a = c1;
                super();
            }
        };
        if (z.a("BannerRequestWEEK_START_DOWNLOADED", false, Globals.d().getApplicationContext()))
        {
            a1.a(c1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a.a(e1));
            return;
        }
        (new LinkedList()).addAll(c1.g().a());
        try
        {
            c1 = Globals.d().w();
            c1.a(new a(c1, e1, new b() {

                public void a(NetworkManager networkmanager, com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.e e2)
                {
                }

                public void a(File file, com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.e e2)
                {
                }

                public void b(File file, com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.e e2)
                {
                    z.a("BannerRequestWEEK_START_DOWNLOADED", Boolean.valueOf(true), Globals.d().getApplicationContext());
                }

            }));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            c1.printStackTrace();
        }
    }

    public static void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.a a1)
    {
        Object obj = f.b("PF_YMK_LAUNCHER_BANNER");
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = e.a(((org.json.JSONObject) (obj)));
_L7:
        if (obj != null && ((List) (obj)).size() > 0)
        {
            com.cyberlink.youcammakeup.database.a.a a2 = (com.cyberlink.youcammakeup.database.a.a)((List) (obj)).get(0);
            obj = a2;
            if (!f.a("PF_YMK_LAUNCHER_BANNER", TimeUnit.DAYS.toMillis(1L)))
            {
                obj = a2.b().iterator();
                int i;
                for (int j = 0; ((Iterator) (obj)).hasNext(); j = i)
                {
                    c c1 = (c)((Iterator) (obj)).next();
                    i = j;
                    if (c1.i().equalsIgnoreCase(com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.Type.a.toString()))
                    {
                        j++;
                        i = j;
                        if (j == 1)
                        {
                            a(c1, a1);
                            i = j;
                        }
                    }
                }

                break MISSING_BLOCK_LABEL_150;
            }
        } else
        {
            obj = null;
        }
          goto _L3
        a1;
        m.b("BannerRequest", "[requestBanner] parse jason error", a1);
_L5:
        return;
_L3:
        if (!NetworkManager.L()) goto _L5; else goto _L4
_L4:
        LinkedList linkedlist = new LinkedList();
        linkedlist.add("PF_YMK_LAUNCHER_BANNER");
        NetworkManager networkmanager = Globals.d().w();
        networkmanager.a(new com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.f(networkmanager, new g(((com.cyberlink.youcammakeup.database.a.a) (obj)), a1) {

            final com.cyberlink.youcammakeup.database.a.a a;
            final com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.a b;

            public void a(bn bn1)
            {
                if (bn1 == null);
            }

            public void a(e e1)
            {
                f.a("PF_YMK_LAUNCHER_BANNER", e1.b());
                f.a("PF_YMK_LAUNCHER_BANNER");
                if (e1.a().size() > 0 && ((com.cyberlink.youcammakeup.database.a.a)e1.a().get(0)).b().size() > 0)
                {
                    e1 = (c)((com.cyberlink.youcammakeup.database.a.a)e1.a().get(0)).b().get(0);
                    if (a == null || ((c)a.b().get(0)).h() != e1.h())
                    {
                        z.a("BannerRequestWEEK_START_DOWNLOADED", Boolean.valueOf(false), Globals.d().getApplicationContext());
                    }
                    com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.BannerRequest.a(e1, b);
                }
            }

            public volatile void a(Object obj1)
            {
                a((e)obj1);
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj1)
            {
                a((bn)obj1);
            }

            public void c(Object obj1)
            {
                a((Void)obj1);
            }

            
            {
                a = a1;
                b = a2;
                super();
            }
        }, linkedlist));
        return;
_L2:
        obj = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static String b()
    {
        if (bf.a())
        {
            return "banner_16to9.jpg";
        } else
        {
            return "banner_4to3.jpg";
        }
    }

    private class Type extends Enum
    {

        public static final Type a;
        private static final Type b[];

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/networkmanager/banner/BannerRequest$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])b.clone();
        }

        static 
        {
            a = new Type("WEEK_STAR_BANNER", 0) {

                public String toString()
                {
                    return "WEEK_STAR_BANNER";
                }

            };
            b = (new Type[] {
                a
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }

    }

}
