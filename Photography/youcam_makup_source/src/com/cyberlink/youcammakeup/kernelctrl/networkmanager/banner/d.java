// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner;

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
import com.cyberlink.youcammakeup.utility.bb;
import com.pf.common.utility.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner:
//            GetPromotionBannerResponse, f, e, b, 
//            c

public class d
{

    private int a;

    public d()
    {
    }

    static long a(d d1)
    {
        return d1.g();
    }

    private List a(GetPromotionBannerResponse getpromotionbannerresponse)
    {
        ArrayList arraylist;
        List list;
        boolean flag2;
        flag2 = false;
        arraylist = new ArrayList();
        list = e();
        if (list != null) goto _L2; else goto _L1
_L1:
        m.c("PromotionBannerCtrl", "No local cache.");
        if (getpromotionbannerresponse != null)
        {
            a = getpromotionbannerresponse.a();
            b(getpromotionbannerresponse);
            a(getpromotionbannerresponse.b(), ((List) (arraylist)));
        }
_L5:
        m.c("PromotionBannerCtrl", (new StringBuilder()).append("getAvailablePromotionBanners: ").append(Arrays.toString(arraylist.toArray())).toString());
        return arraylist;
_L2:
        m.c("PromotionBannerCtrl", (new StringBuilder()).append("Local cache: ").append(Arrays.toString(list.toArray())).toString());
        if (getpromotionbannerresponse != null) goto _L4; else goto _L3
_L3:
        boolean flag1;
        m.c("PromotionBannerCtrl", "No response result.");
        flag1 = flag2;
_L7:
        m.c("PromotionBannerCtrl", (new StringBuilder()).append("shouldUpdateCache: ").append(flag1).toString());
        Iterator iterator;
        GetPromotionBannerResponse.PromotionBanner promotionbanner;
        Iterator iterator1;
        GetPromotionBannerResponse.PromotionBanner promotionbanner1;
        boolean flag;
        if (flag1)
        {
            b(getpromotionbannerresponse);
            a(getpromotionbannerresponse.b(), ((List) (arraylist)));
            d();
        } else
        {
            a(list, ((List) (arraylist)));
        }
        if (true) goto _L5; else goto _L4
_L4:
        a = getpromotionbannerresponse.a();
        iterator = getpromotionbannerresponse.b().iterator();
_L10:
        flag1 = flag2;
        if (!iterator.hasNext()) goto _L7; else goto _L6
_L6:
        promotionbanner = (GetPromotionBannerResponse.PromotionBanner)iterator.next();
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
                promotionbanner1 = (GetPromotionBannerResponse.PromotionBanner)iterator1.next();
            } while (promotionbanner.a != promotionbanner1.a);
            if (promotionbanner.h == promotionbanner1.h && promotionbanner.i.equals(promotionbanner1.i))
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

    private void a(GetPromotionBannerResponse getpromotionbannerresponse, e e1)
    {
        getpromotionbannerresponse = a(getpromotionbannerresponse);
        if (getpromotionbannerresponse.size() > 0)
        {
            a(((List) (getpromotionbannerresponse)), e1);
        }
    }

    static void a(d d1, GetPromotionBannerResponse getpromotionbannerresponse, e e1)
    {
        d1.a(getpromotionbannerresponse, e1);
    }

    static void a(d d1, String s, List list, GetPromotionBannerResponse.PromotionBanner promotionbanner, e e1)
    {
        d1.a(s, list, promotionbanner, e1);
    }

    private void a(String s, List list, GetPromotionBannerResponse.PromotionBanner promotionbanner, e e1)
    {
        s = BitmapFactory.decodeFile(s);
        if (s == null)
        {
            try
            {
                m.e("PromotionBannerCtrl", "DownloadThumbnailCallback#complete: damaged cover image");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                m.b("PromotionBannerCtrl", "BitmapFactory.decodeFile", s);
            }
            break MISSING_BLOCK_LABEL_41;
        }
        promotionbanner.a(s);
        b(list, e1);
        return;
    }

    private void a(List list, GetPromotionBannerResponse.PromotionBanner promotionbanner, f f1, e e1)
    {
        Globals.d().w().a(f1, new l(list, promotionbanner, e1) {

            final List a;
            final GetPromotionBannerResponse.PromotionBanner b;
            final e c;
            final d d;

            public void a(a a1)
            {
            }

            public void a(bn bn1)
            {
                m.e("PromotionBannerCtrl", (new StringBuilder()).append("DownloadThumbnailCallback#error: ").append(String.valueOf(bn1)).toString());
            }

            public volatile void a(Object obj)
            {
                a((String)obj);
            }

            public void a(String s)
            {
                m.c("PromotionBannerCtrl", (new StringBuilder()).append("DownloadThumbnailCallback#complete: ").append(String.valueOf(s)).toString());
                if (s == null || s.equalsIgnoreCase(""))
                {
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.d.a(d, s, a, b, c);
                    return;
                }
            }

            public void a(Void void1)
            {
                m.e("PromotionBannerCtrl", "DownloadThumbnailCallback#cancel");
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
                d = d.this;
                a = list;
                b = promotionbanner;
                c = e1;
                super();
            }
        });
    }

    private void a(List list, e e1)
    {
        Iterator iterator1;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); m.b("PromotionBannerCtrl", "========"))
        {
            GetPromotionBannerResponse.PromotionBanner promotionbanner = (GetPromotionBannerResponse.PromotionBanner)iterator.next();
            m.b("PromotionBannerCtrl", (new StringBuilder()).append("Available: ").append(promotionbanner.toString()).toString());
            m.b("PromotionBannerCtrl", (new StringBuilder()).append("End: ").append(promotionbanner.c()).toString());
            m.b("PromotionBannerCtrl", (new StringBuilder()).append("Modified: ").append(promotionbanner.d()).toString());
        }

        m.b("PromotionBannerCtrl", (new StringBuilder()).append("Current: ").append(String.valueOf(System.currentTimeMillis())).toString());
        m.b("PromotionBannerCtrl", (new StringBuilder()).append("Current: ").append((new Date(System.currentTimeMillis())).toString()).toString());
        iterator1 = list.iterator();
_L2:
        GetPromotionBannerResponse.PromotionBanner promotionbanner1;
        if (!iterator1.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        promotionbanner1 = (GetPromotionBannerResponse.PromotionBanner)iterator1.next();
        f f1 = new f(promotionbanner1);
        a(list, promotionbanner1, f1, e1);
        continue; /* Loop/switch isn't completed */
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        m.b("PromotionBannerCtrl", "DownloadThumbInfo", illegalargumentexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void a(List list, List list1)
    {
        long l = System.currentTimeMillis();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            GetPromotionBannerResponse.PromotionBanner promotionbanner = (GetPromotionBannerResponse.PromotionBanner)list.next();
            if (promotionbanner.g > l)
            {
                list1.add(promotionbanner);
            }
        } while (true);
    }

    public static String b()
    {
        return z.b("PROMOTION_BANNER_LAST_QUERY_LANGUAGE", "", Globals.d());
    }

    private void b(GetPromotionBannerResponse getpromotionbannerresponse)
    {
        String s = f();
        c();
        ad.a(getpromotionbannerresponse.c(), s);
    }

    static void b(d d1)
    {
        d1.c();
    }

    private void b(List list, e e1)
    {
        Iterator iterator = list.iterator();
        boolean flag = true;
        while (iterator.hasNext()) 
        {
            GetPromotionBannerResponse.PromotionBanner promotionbanner = (GetPromotionBannerResponse.PromotionBanner)iterator.next();
            if (flag && aa.b(promotionbanner.a()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        if (flag)
        {
            e1.a(list);
        }
    }

    private void c()
    {
        File file = new File(f());
        File file1 = file.getParentFile();
        file.delete();
        file1.mkdirs();
    }

    static void c(d d1)
    {
        d1.h();
    }

    private void d()
    {
        File file = new File(com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.f.e());
        bb.b(file);
        file.mkdirs();
    }

    static void d(d d1)
    {
        d1.i();
    }

    private List e()
    {
        Object obj = f();
        if (!(new File(((String) (obj)))).exists())
        {
            return null;
        }
        obj = ad.b(((String) (obj)));
        a = com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.a(((org.json.JSONObject) (obj)), com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a);
        try
        {
            m.c("PromotionBannerCtrl", "Parse local cache.");
            obj = com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.b(((org.json.JSONObject) (obj)), com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a);
        }
        catch (JSONException jsonexception)
        {
            m.b("PromotionBannerCtrl", "getLocalPromotionBanners", jsonexception);
            return null;
        }
        return ((List) (obj));
    }

    private static String f()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(NetworkManager.b());
        stringbuilder.append(File.separator);
        stringbuilder.append("PromotionBanner");
        stringbuilder.append(File.separator);
        stringbuilder.append("PromotionBanner.json");
        return stringbuilder.toString();
    }

    private long g()
    {
        return z.b("PROMOTION_BANNER_LAST_QUERY_TIME", Long.valueOf(0L), Globals.d()).longValue();
    }

    private void h()
    {
        z.a("PROMOTION_BANNER_LAST_QUERY_TIME", Long.valueOf(System.currentTimeMillis()), Globals.d());
    }

    private void i()
    {
        z.a("PROMOTION_BANNER_LAST_QUERY_LANGUAGE", com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b(), Globals.d());
    }

    public int a()
    {
        return a;
    }

    public void a(e e1)
    {
        (new AsyncTask(e1) {

            final e a;
            final d b;

            protected transient Void a(Void avoid[])
            {
                long l = com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.d.a(b);
                avoid = com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.d.b();
                if (System.currentTimeMillis() - l <= 0x5265c00L && com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b().equalsIgnoreCase(avoid))
                {
                    m.e("PromotionBannerCtrl", "Within 24 hours and same language, try to use the local cache.");
                    com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.d.a(b, null, a);
                    return null;
                } else
                {
                    com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.d.b(b);
                    avoid = Globals.d().w();
                    avoid.a(new com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.b(avoid, new c(this) {

                        final _cls1 a;

                        public void a(GetPromotionBannerResponse getpromotionbannerresponse)
                        {
                            com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.d.a(a.b, getpromotionbannerresponse, a.a);
                            d.c(a.b);
                            d.d(a.b);
                        }

                        public void a(bn bn1)
                        {
                            m.e("PromotionBannerCtrl", (new StringBuilder()).append("GetPromotionTask: ").append(String.valueOf(bn1)).toString());
                            com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.d.a(a.b, null, a.a);
                        }

                        public volatile void a(Object obj)
                        {
                            a((GetPromotionBannerResponse)obj);
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
                b = d.this;
                a = e1;
                super();
            }
        }).execute(new Void[0]);
    }
}
