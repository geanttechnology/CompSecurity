// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.c;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.ad;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.bb;
import com.pf.common.utility.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.c:
//            a, b, g, f, 
//            c, d

public class e
{

    public e()
    {
    }

    static long a(e e1)
    {
        return e1.e();
    }

    private List a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.a a1)
    {
        ArrayList arraylist;
        List list;
        boolean flag2;
        flag2 = false;
        arraylist = new ArrayList();
        list = c();
        if (list != null) goto _L2; else goto _L1
_L1:
        m.c("PromotionInfoCtrl", "No local cache.");
        if (a1 != null)
        {
            b(a1);
            a(a1.a(), ((List) (arraylist)));
        }
_L5:
        m.c("PromotionInfoCtrl", (new StringBuilder()).append("getAvailablePromotionInfos: ").append(Arrays.toString(arraylist.toArray())).toString());
        return arraylist;
_L2:
        m.c("PromotionInfoCtrl", (new StringBuilder()).append("Local cache: ").append(Arrays.toString(list.toArray())).toString());
        if (a1 != null) goto _L4; else goto _L3
_L3:
        boolean flag1;
        m.c("PromotionInfoCtrl", "No response result.");
        flag1 = flag2;
_L7:
        m.c("PromotionInfoCtrl", (new StringBuilder()).append("shouldUpdateCache: ").append(flag1).toString());
        Iterator iterator;
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b b1;
        Iterator iterator1;
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b b2;
        boolean flag;
        if (flag1)
        {
            b(a1);
            a(a1.a(), ((List) (arraylist)));
            b();
        } else
        {
            a(list, ((List) (arraylist)));
        }
        if (true) goto _L5; else goto _L4
_L4:
        iterator = a1.a().iterator();
_L10:
        flag1 = flag2;
        if (!iterator.hasNext()) goto _L7; else goto _L6
_L6:
        b1 = (com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b)iterator.next();
        iterator1 = list.iterator();
        flag = true;
_L8:
label0:
        {
            do
            {
                if (!iterator1.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                b2 = (com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b)iterator1.next();
            } while (b1.a != b2.a);
            if (b1.g == b2.g && b1.e.equals(b2.e))
            {
                break label0;
            }
            flag1 = true;
        }
          goto _L7
        flag = false;
          goto _L8
        if (!flag) goto _L10; else goto _L9
_L9:
        flag1 = true;
          goto _L7
    }

    private void a()
    {
        File file = new File(d());
        File file1 = file.getParentFile();
        file.delete();
        file1.mkdirs();
    }

    private void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.a a1, f f1)
    {
        a1 = a(a1);
        if (a1.size() > 0)
        {
            a(((List) (a1)), f1);
        }
    }

    static void a(e e1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.a a1, f f1)
    {
        e1.a(a1, f1);
    }

    static void a(e e1, String s, List list, com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b b1, f f1)
    {
        e1.a(s, list, b1, f1);
    }

    private void a(String s, List list, com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b b1, f f1)
    {
        s = BitmapFactory.decodeFile(s);
        if (s == null)
        {
            try
            {
                m.e("PromotionInfoCtrl", "DownloadThumbnailCallback#complete: damaged cover image");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                m.b("PromotionInfoCtrl", "BitmapFactory.decodeFile", s);
            }
            break MISSING_BLOCK_LABEL_41;
        }
        b1.a(s);
        b(list, f1);
        return;
    }

    private void a(List list, com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b b1, g g1, f f1)
    {
        Globals.d().w().a(g1, new l(list, b1, f1) {

            final List a;
            final com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b b;
            final f c;
            final e d;

            public void a(a a1)
            {
            }

            public void a(bn bn1)
            {
                m.e("PromotionInfoCtrl", (new StringBuilder()).append("DownloadThumbnailCallback#error: ").append(String.valueOf(bn1)).toString());
            }

            public volatile void a(Object obj)
            {
                a((String)obj);
            }

            public void a(String s)
            {
                m.c("PromotionInfoCtrl", (new StringBuilder()).append("DownloadThumbnailCallback#complete: ").append(String.valueOf(s)).toString());
                if (s == null || s.equalsIgnoreCase(""))
                {
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.e.a(d, s, a, b, c);
                    return;
                }
            }

            public void a(Void void1)
            {
                m.e("PromotionInfoCtrl", "DownloadThumbnailCallback#cancel");
            }

            public void b(Object obj)
            {
                a((bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            public void d(Object obj)
            {
                a((a)obj);
            }

            
            {
                d = e.this;
                a = list;
                b = b1;
                c = f1;
                super();
            }
        });
    }

    private void a(List list, f f1)
    {
        Iterator iterator1;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); m.b("PromotionInfoCtrl", "========"))
        {
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b b1 = (com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b)iterator.next();
            m.b("PromotionInfoCtrl", (new StringBuilder()).append("Available: ").append(b1.toString()).toString());
            m.b("PromotionInfoCtrl", (new StringBuilder()).append("End: ").append(b1.c()).toString());
            m.b("PromotionInfoCtrl", (new StringBuilder()).append("Modified: ").append(b1.d()).toString());
        }

        m.b("PromotionInfoCtrl", (new StringBuilder()).append("Current: ").append(String.valueOf(System.currentTimeMillis())).toString());
        m.b("PromotionInfoCtrl", (new StringBuilder()).append("Current: ").append((new Date(System.currentTimeMillis())).toString()).toString());
        iterator1 = list.iterator();
_L2:
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b b2;
        if (!iterator1.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        b2 = (com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b)iterator1.next();
        g g1 = new g(b2);
        a(list, b2, g1, f1);
        continue; /* Loop/switch isn't completed */
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        m.b("PromotionInfoCtrl", "DownloadThumbInfo", illegalargumentexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void a(List list, List list1)
    {
        long l = System.currentTimeMillis();
        if (al.a("com.cyberlink.U") || !Globals.d().c().b())
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b b1 = (com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b)list.next();
                String s = b1.d;
                if (b1.f > l && !"$LinkToUStore".equalsIgnoreCase(s))
                {
                    list1.add(b1);
                }
            } while (true);
        } else
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b b2 = (com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b)list.next();
                if (b2.f > l)
                {
                    list1.add(b2);
                }
            } while (true);
        }
    }

    static String b(e e1)
    {
        return e1.g();
    }

    private void b()
    {
        File file = new File(com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.g.e());
        bb.b(file);
        file.mkdirs();
    }

    private void b(com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.a a1)
    {
        String s = d();
        a();
        ad.a(a1.b(), s);
    }

    private void b(List list, f f1)
    {
        Iterator iterator = list.iterator();
        boolean flag = true;
        while (iterator.hasNext()) 
        {
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b b1 = (com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.b)iterator.next();
            if (flag && aa.b(b1.a()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        if (flag)
        {
            f1.a(list);
        }
    }

    private List c()
    {
        Object obj = d();
        if (!(new File(((String) (obj)))).exists())
        {
            return null;
        }
        obj = ad.b(((String) (obj)));
        try
        {
            m.c("PromotionInfoCtrl", "Parse local cache.");
            obj = com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.a.a(((org.json.JSONObject) (obj)), com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a);
        }
        catch (JSONException jsonexception)
        {
            m.b("PromotionInfoCtrl", "getLocalPromotionInfos", jsonexception);
            return null;
        }
        return ((List) (obj));
    }

    static void c(e e1)
    {
        e1.a();
    }

    private static String d()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(NetworkManager.b());
        stringbuilder.append(File.separator);
        stringbuilder.append("PromotionInfo");
        stringbuilder.append(File.separator);
        stringbuilder.append("PromotionList.json");
        return stringbuilder.toString();
    }

    static void d(e e1)
    {
        e1.f();
    }

    private long e()
    {
        return z.b("PROMOTION_LAST_QUERY_TIME", Long.valueOf(0L), Globals.d()).longValue();
    }

    static void e(e e1)
    {
        e1.h();
    }

    private void f()
    {
        z.a("PROMOTION_LAST_QUERY_TIME", Long.valueOf(System.currentTimeMillis()), Globals.d());
    }

    private String g()
    {
        return z.b("PROMOTION_LAST_QUERY_LANGUAGE", "", Globals.d());
    }

    private void h()
    {
        z.a("PROMOTION_LAST_QUERY_LANGUAGE", com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b(), Globals.d());
    }

    public void a(f f1)
    {
        (new AsyncTask(f1) {

            final f a;
            final e b;

            protected transient Void a(Void avoid[])
            {
                long l = com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.e.a(b);
                avoid = com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.e.b(b);
                if (System.currentTimeMillis() - l <= 0x5265c00L && com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b().equalsIgnoreCase(avoid))
                {
                    m.e("PromotionInfoCtrl", "Within 24 hours and same language, try to use the local cache.");
                    com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.e.a(b, null, a);
                    return null;
                } else
                {
                    e.c(b);
                    avoid = Globals.d().w();
                    avoid.a(new c(avoid, new d(this) {

                        final _cls1 a;

                        public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.a a1)
                        {
                            com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.e.a(a.b, a1, a.a);
                            e.d(a.b);
                            e.e(a.b);
                        }

                        public void a(bn bn1)
                        {
                            m.e("PromotionInfoCtrl", (new StringBuilder()).append("GetPromotionTask: ").append(String.valueOf(bn1)).toString());
                            com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.e.a(a.b, null, a.a);
                        }

                        public volatile void a(Object obj)
                        {
                            a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.a)obj);
                        }

                        public void b(Object obj)
                        {
                            a((bn)obj);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    }));
                    return null;
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            
            {
                b = e.this;
                a = f1;
                super();
            }
        }).execute(new Void[0]);
    }
}
