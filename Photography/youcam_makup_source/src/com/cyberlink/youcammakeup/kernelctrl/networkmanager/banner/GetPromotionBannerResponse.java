// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.b;
import com.cyberlink.youcammakeup.utility.ad;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetPromotionBannerResponse extends b
{

    private int d;
    private List e;

    public GetPromotionBannerResponse()
    {
        e = new ArrayList();
    }

    public GetPromotionBannerResponse(HttpEntity httpentity)
    {
        super(httpentity);
        e = new ArrayList();
        d = a(b, c);
        e = b(b, c);
    }

    public static int a(JSONObject jsonobject, com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus)
    {
        if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a || jsonobject == null)
        {
            return 0;
        }
        int i;
        try
        {
            i = Integer.parseInt(jsonobject.getString("rotationPeriod"));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return 0;
        }
        return i;
    }

    public static List b(JSONObject jsonobject, com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus responsestatus)
    {
        ArrayList arraylist = new ArrayList();
        m.c("GetPromotionBannerResponse", String.valueOf(jsonobject));
        if (responsestatus != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a || jsonobject == null)
        {
            return arraylist;
        }
        jsonobject = jsonobject.getJSONArray("bannerList");
        if (jsonobject == null)
        {
            return arraylist;
        }
        int j = jsonobject.length();
        for (int i = 0; i < j; i++)
        {
            responsestatus = jsonobject.getJSONObject(i);
            arraylist.add(new PromotionBanner(ad.c(responsestatus, "bannerId"), responsestatus.getString("actionURL"), responsestatus.getString("bannerImgURL_169_1080"), responsestatus.getString("bannerImgURL_169_720"), responsestatus.getString("bannerImgURL_43_1080"), responsestatus.getString("bannerImgURL_43_720"), ad.c(responsestatus, "endDate"), ad.c(responsestatus, "lastModified")));
        }

        return arraylist;
    }

    public int a()
    {
        return d;
    }

    public List b()
    {
        return e;
    }

    public JSONObject c()
    {
        return b;
    }

    private class PromotionBanner
    {

        public final long a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final long g;
        public final long h;
        public final String i;
        public final boolean j = e();
        public final Scheme k;
        public final com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl l;
        private Bitmap m;

        public static com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl a(String s)
        {
            class Scheme extends Enum
            {

                public static final Scheme a;
                public static final Scheme b;
                public static final Scheme c;
                private static final Scheme d[];

                public static Scheme valueOf(String s1)
                {
                    return (Scheme)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/networkmanager/banner/GetPromotionBannerResponse$PromotionBanner$Scheme, s1);
                }

                public static Scheme[] values()
                {
                    return (Scheme[])d.clone();
                }

                static 
                {
                    a = new Scheme("UNKNOWN", 0) {

                        public String toString()
                        {
                            return "[unknown]";
                        }

                    };
                    b = new Scheme("YMK", 1) {

                        public String toString()
                        {
                            return "ymk://";
                        }

                    };
                    c = new Scheme("HTTP", 2) {

                        public String toString()
                        {
                            return "http://";
                        }

                    };
                    d = (new Scheme[] {
                        a, b, c
                    });
                }

                private Scheme(String s, int i1)
                {
                    super(s, i1);
                }

            }

            if (!s.toLowerCase(Locale.US).startsWith(com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.Scheme.b.toString()))
            {
                com.pf.common.utility.m.e("PromotionBanner#parsingURL", "!startsWith(\"ymk://\")");
            } else
            {
                s = s.split("//");
                if (s.length < 2)
                {
                    com.pf.common.utility.m.e("PromotionBanner#parsingURL", "parts.length < 2");
                } else
                {
                    s = s[1];
                    if (s == null)
                    {
                        com.pf.common.utility.m.e("PromotionBanner#parsingURL", "urlHost == null");
                    } else
                    {
                        s = s.split("/");
                        if (s.length < 3)
                        {
                            com.pf.common.utility.m.e("PromotionBanner#parsingURL", "parts.length < 3");
                        } else
                        {
                            return new com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl(s[0], s[1], s[2], null);
                        }
                    }
                }
            }
            return com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl.a;
        }

        public static Scheme b(String s)
        {
            if (s != null)
            {
                s = s.toLowerCase(Locale.US);
                if (s.startsWith(com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.Scheme.b.toString()))
                {
                    return com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.Scheme.b;
                }
                if (s.startsWith(Scheme.c.toString()))
                {
                    return Scheme.c;
                }
            }
            return Scheme.a;
        }

        private boolean e()
        {
            while (k == Scheme.a || k == com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.Scheme.b && l == com.cyberlink.youcammakeup.utility.SkuTemplateUtils.SkuTryItUrl.a) 
            {
                return false;
            }
            return true;
        }

        public Bitmap a()
        {
            return m;
        }

        public void a(Bitmap bitmap)
        {
            m = bitmap;
        }

        public void b()
        {
            aa.a(m);
            m = null;
        }

        public String c()
        {
            return (new Date(g)).toString();
        }

        public String d()
        {
            return (new Date(h)).toString();
        }

        public String toString()
        {
            return String.format(Locale.US, "bannerId=%d, actionURL=%s, bannerImgURL_169_1080=%s, bannerImgURL_169_720=%s, bannerImgURL_43_1080=%s, bannerImgURL_43_720=%s, endDate=%d, lastModified=%d, bannerImgURL=%s", new Object[] {
                Long.valueOf(a), b, c, d, e, f, Long.valueOf(g), Long.valueOf(h), i
            });
        }

        public PromotionBanner(long l1, String s, String s1, String s2, String s3, String s4, 
                long l2, long l3)
        {
            m = null;
            a = l1;
            b = s;
            c = s1;
            d = s2;
            e = s3;
            f = s4;
            g = l2;
            h = l3;
            s = Globals.d().getResources().getDisplayMetrics();
            double d1 = (double)((DisplayMetrics) (s)).heightPixels / (double)((DisplayMetrics) (s)).widthPixels;
            if (Math.abs(1080 - ((DisplayMetrics) (s)).widthPixels) < Math.abs(720 - ((DisplayMetrics) (s)).widthPixels))
            {
                if (Math.abs(d1 - 1.7777777777777777D) < Math.abs(d1 - 1.3333333333333333D))
                {
                    i = c;
                } else
                {
                    i = e;
                }
            } else
            if (Math.abs(d1 - 1.7777777777777777D) < Math.abs(d1 - 1.3333333333333333D))
            {
                i = d;
            } else
            {
                i = f;
            }
            k = b(b);
            l = a(b);
        }
    }

}
