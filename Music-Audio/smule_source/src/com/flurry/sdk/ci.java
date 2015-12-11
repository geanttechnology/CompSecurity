// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import com.flurry.android.impl.ads.protocol.v13.AdFrame;
import com.flurry.android.impl.ads.protocol.v13.AdRequest;
import com.flurry.android.impl.ads.protocol.v13.AdResponse;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import com.flurry.android.impl.ads.protocol.v13.AdViewContainer;
import com.flurry.android.impl.ads.protocol.v13.AdViewType;
import com.flurry.android.impl.ads.protocol.v13.ConfigurationUnion;
import com.flurry.android.impl.ads.protocol.v13.FrequencyCapResponseInfo;
import com.flurry.android.impl.ads.protocol.v13.NativeAdConfiguration;
import com.flurry.android.impl.ads.protocol.v13.TargetingOverride;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.flurry.sdk:
//            gh, cl, gd, fz, 
//            r, q, hn, cr, 
//            e, ap, w, i, 
//            n, fp, fq, fd, 
//            fg, fm, fe, hm, 
//            gk, j, gt, fn, 
//            t, az, ba, da, 
//            cy, ac, x, cj, 
//            fj, fy, ff, fx, 
//            hq, cg, aa

public class ci
{

    private static final String a = com/flurry/sdk/ci.getSimpleName();
    private final gh b = new gh("ad request", new cl(com/flurry/android/impl/ads/protocol/v13/AdRequest));
    private final gh c = new gh("ad response", new cl(com/flurry/android/impl/ads/protocol/v13/AdResponse));
    private final String d;
    private final List e = Arrays.asList(new Integer[] {
        Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5)
    });
    private a f;
    private r g;
    private ap h;
    private x i;
    private List j;
    private final fy k = new fy() {

        final ci a;

        public void a(ff ff1)
        {
            ci.a(a);
        }

        public void notify(fx fx)
        {
            a((ff)fx);
        }

            
            {
                a = ci.this;
                super();
            }
    };

    public ci(String s)
    {
        d = s;
        f = a.a;
        d();
    }

    static List a(ci ci1, List list)
    {
        ci1.j = list;
        return list;
    }

    private void a(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        a a2;
        a2 = a1;
        if (a1 != null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        a2 = a.a;
        gd.a(3, a, (new StringBuilder()).append("Setting state from ").append(f).append(" to ").append(a2).toString());
        if (!a.a.equals(f) || a.a.equals(a2)) goto _L2; else goto _L1
_L1:
        gd.a(3, a, (new StringBuilder()).append("Adding request listeners for adspace: ").append(d).toString());
        fz.a().a("com.flurry.android.sdk.IdProviderFinishedEvent", k);
_L4:
        f = a2;
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!a.a.equals(a2) || a.a.equals(f)) goto _L4; else goto _L3
_L3:
        gd.a(3, a, (new StringBuilder()).append("Removing request listeners for adspace: ").append(d).toString());
        fz.a().a(k);
          goto _L4
        a1;
        throw a1;
    }

    static void a(ci ci1)
    {
        ci1.e();
    }

    static void a(ci ci1, a a1)
    {
        ci1.a(a1);
    }

    static void a(ci ci1, r r1, ap ap1)
    {
        ci1.a(r1, ap1);
    }

    private void a(r r1, ap ap1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.c.equals(f);
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        Object obj4;
        a(a.d);
        obj = r1.f();
        obj4 = r1.l();
        if (!(r1 instanceof q)) goto _L4; else goto _L3
_L3:
        AdViewType adviewtype = AdViewType.BANNER;
_L13:
        int l;
        int i1;
        int j1;
        int k1;
        Pair pair = hn.c(hn.j());
        j1 = ((Integer)pair.first).intValue();
        k1 = ((Integer)pair.second).intValue();
        pair = hn.k();
        i1 = ((Integer)pair.first).intValue();
        l = ((Integer)pair.second).intValue();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        if (((ViewGroup) (obj)).getHeight() > 0)
        {
            l = hn.a(((ViewGroup) (obj)).getHeight());
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        if (((ViewGroup) (obj)).getWidth() > 0)
        {
            i1 = hn.a(((ViewGroup) (obj)).getWidth());
        }
        Object obj1;
        AdViewContainer adviewcontainer;
        TargetingOverride targetingoverride;
        adviewcontainer = new AdViewContainer();
        adviewcontainer.screenHeight = k1;
        adviewcontainer.screenWidth = j1;
        adviewcontainer.viewHeight = l;
        adviewcontainer.viewWidth = i1;
        adviewcontainer.density = hn.e();
        adviewcontainer.screenOrientation = cr.b();
        obj = cr.c();
        obj1 = Collections.emptyMap();
        targetingoverride = new TargetingOverride();
        targetingoverride.personas = Collections.emptyList();
        targetingoverride.ageRange = -2;
        targetingoverride.gender = -2;
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_1095;
        }
        Object obj2 = ((e) (obj4)).getLocation();
        if (obj2 != null)
        {
            obj = obj2;
        }
        obj2 = ((e) (obj4)).getKeywords();
        if (obj2 != null)
        {
            obj1 = obj2;
        }
        obj2 = ((e) (obj4)).getGender();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        targetingoverride.ageRange = ((Integer) (obj2)).intValue();
        obj2 = ((e) (obj4)).getGender();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_342;
        }
        targetingoverride.gender = ((Integer) (obj2)).intValue();
        flag = ((e) (obj4)).getEnableTestAds();
        obj2 = obj1;
        obj1 = obj;
        obj = obj2;
_L18:
        List list;
        List list1;
        list = cr.e();
        list1 = cr.f();
        if (!AdViewType.STREAM.equals(AdViewType.STREAM)) goto _L6; else goto _L5
_L5:
        obj2 = cr.g();
_L14:
        ArrayList arraylist = new ArrayList();
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_438;
        }
        obj4 = ((e) (obj4)).getFixedAdId();
        if (!TextUtils.isEmpty(((CharSequence) (obj4))))
        {
            arraylist.add("FLURRY_VIEWER");
            arraylist.add(obj4);
        }
        obj4 = Collections.emptyMap();
        if (ap1 == null) goto _L8; else goto _L7
_L7:
        boolean flag1;
        ap1 = ap1.a();
        flag1 = ((AdUnit) (ap1)).renderTime;
        ap1 = ((AdUnit) (ap1)).clientSideRtbPayload;
_L17:
        NativeAdConfiguration nativeadconfiguration = new NativeAdConfiguration();
        Object obj5;
        obj5 = null;
        obj4 = null;
        if (r1 instanceof w)
        {
            obj4 = (w)r1;
            obj5 = ((w) (obj4)).s();
            obj4 = ((w) (obj4)).t();
        }
        if (obj5 != null) goto _L10; else goto _L9
_L9:
        nativeadconfiguration.requestedStyles = Collections.emptyList();
_L15:
        if (obj4 != null) goto _L12; else goto _L11
_L11:
        nativeadconfiguration.requestedAssets = Collections.emptyList();
_L16:
        obj4 = com.flurry.sdk.i.a().h().b();
        if (obj4 == null)
        {
            obj4 = "";
        }
        obj5 = new AdRequest();
        obj5.requestTime = System.currentTimeMillis();
        obj5.apiKey = fp.a().d();
        obj5.agentVersion = Integer.toString(fq.a());
        obj5.adViewType = adviewtype;
        obj5.adSpaceName = d;
        obj5.sessionId = fd.a().c();
        obj5.adReportedIds = list;
        obj5.location = ((com.flurry.android.impl.ads.protocol.v13.Location) (obj1));
        obj5.testDevice = flag;
        obj5.bindings = e;
        obj5.adViewContainer = adviewcontainer;
        obj5.locale = fg.a().c();
        obj5.timezone = fg.a().d();
        obj5.osVersion = fm.a().c();
        obj5.devicePlatform = fm.a().d();
        obj5.keywords = ((java.util.Map) (obj));
        obj5.canDoSKAppStore = false;
        obj5.networkStatus = fd.a().h().a();
        obj5.frequencyCapRequestInfoList = list1;
        obj5.streamInfoList = ((List) (obj2));
        obj5.adTrackingEnabled = fe.a().e();
        obj5.preferredLanguage = Locale.getDefault().getLanguage();
        obj5.bcat = arraylist;
        obj5.userAgent = com.flurry.sdk.i.a().s();
        obj5.targetingOverride = targetingoverride;
        if (com.flurry.sdk.i.a().m() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj5.sendConfiguration = flag;
        obj5.origins = cr.d();
        obj5.renderTime = flag1;
        obj5.clientSideRtbPayload = ap1;
        obj5.nativeAdConfiguration = nativeadconfiguration;
        obj5.bCookie = ((String) (obj4));
        obj5.appBundleId = hm.c(r1.e());
        r1 = b.a(obj5);
        ap1 = new gk();
        ap1.a(com.flurry.sdk.j.a().g());
        ap1.a(20000);
        ap1.a(gl.a.c);
        ap1.a("Content-Type", "application/x-flurry");
        ap1.a("Accept", "application/x-flurry");
        ap1.a("FM-Checksum", Integer.toString(gh.c(r1)));
        ap1.a(new gt());
        ap1.b(new gt());
        ap1.a(r1);
        ap1.a(new gk.a() {

            final ci a;

            public volatile void a(gk gk1, Object obj6)
            {
                a(gk1, (byte[])obj6);
            }

            public void a(gk gk1, byte abyte0[])
            {
                List list2;
                gd.a(3, ci.c(), (new StringBuilder()).append("AdRequest: HTTP status code is:").append(gk1.e()).toString());
                ci.a(a, new ArrayList());
                list2 = Collections.emptyList();
                if (!gk1.c() || abyte0 == null) goto _L2; else goto _L1
_L1:
                gk1 = null;
                abyte0 = (AdResponse)ci.d(a).d(abyte0);
                gk1 = abyte0;
_L3:
                if (gk1 != null)
                {
                    abyte0 = ((AdResponse) (gk1)).configuration;
                    if (abyte0 != null)
                    {
                        abyte0 = ((ConfigurationUnion) (abyte0)).configuration;
                        if (abyte0 != null)
                        {
                            gd.a(3, ci.c(), "Ad server responded with configuration.");
                            cg cg1 = new cg();
                            cg1.a = abyte0;
                            fz.a().a(cg1);
                        }
                    }
                    if (((AdResponse) (gk1)).frequencyCapResponseInfoList != null)
                    {
                        az az1;
                        for (abyte0 = ((AdResponse) (gk1)).frequencyCapResponseInfoList.iterator(); abyte0.hasNext(); com.flurry.sdk.i.a().k().a(az1))
                        {
                            az1 = new az((FrequencyCapResponseInfo)abyte0.next());
                        }

                    }
                    break MISSING_BLOCK_LABEL_220;
                }
                break; /* Loop/switch isn't completed */
                abyte0;
                gd.a(5, ci.c(), (new StringBuilder()).append("Failed to decode ad response: ").append(abyte0).toString());
                if (true) goto _L3; else goto _L2
                if (((AdResponse) (gk1)).errors.size() > 0)
                {
                    gd.b(ci.c(), "Ad server responded with the following error(s):");
                    String s;
                    for (abyte0 = ((AdResponse) (gk1)).errors.iterator(); abyte0.hasNext(); gd.b(ci.c(), s))
                    {
                        s = (String)abyte0.next();
                    }

                }
                if (((AdResponse) (gk1)).adUnits != null)
                {
                    gk1 = ((AdResponse) (gk1)).adUnits;
                } else
                {
                    gk1 = list2;
                }
                abyte0 = gk1;
                if (!TextUtils.isEmpty(ci.e(a)))
                {
                    abyte0 = gk1;
                    if (gk1.size() == 0)
                    {
                        gd.b(ci.c(), "Ad server responded but sent no ad units.");
                        abyte0 = gk1;
                    }
                }
_L5:
                gk1 = abyte0.iterator();
                do
                {
                    if (!gk1.hasNext())
                    {
                        break;
                    }
                    abyte0 = (AdUnit)gk1.next();
                    if (((AdUnit) (abyte0)).adFrames.size() != 0)
                    {
                        abyte0 = new ap(abyte0);
                        ci.f(a).add(abyte0);
                    }
                } while (true);
                ci.a(a, a.e);
                fp.a().b(new hq(this) {

                    final _cls4 a;

                    public void safeRun()
                    {
                        ci.g(a.a);
                    }

            
            {
                a = _pcls4;
                super();
            }
                });
                return;
_L2:
                abyte0 = list2;
                if (true) goto _L5; else goto _L4
_L4:
            }

            
            {
                a = ci.this;
                super();
            }
        });
        fn.a().a(this, ap1);
          goto _L1
        r1;
        throw r1;
_L4:
label0:
        {
            if (!(r1 instanceof t))
            {
                break label0;
            }
            adviewtype = AdViewType.INTERSTITIAL;
        }
          goto _L13
label1:
        {
            if (!(r1 instanceof w))
            {
                break label1;
            }
            adviewtype = AdViewType.NATIVE;
        }
          goto _L13
        adviewtype = AdViewType.LEGACY;
          goto _L13
_L6:
        obj2 = Collections.emptyList();
          goto _L14
_L10:
        nativeadconfiguration.requestedStyles = ((List) (obj5));
          goto _L15
_L12:
        nativeadconfiguration.requestedAssets = ((List) (obj4));
          goto _L16
        r1;
        gd.a(5, a, (new StringBuilder()).append("Ad request failed with exception: ").append(r1).toString());
        d();
          goto _L1
_L8:
        ap1 = ((ap) (obj4));
        flag1 = false;
          goto _L17
        flag = false;
        Object obj3 = obj;
        obj = obj1;
        obj1 = obj3;
          goto _L18
    }

    static r b(ci ci1)
    {
        return ci1.g;
    }

    static ap c(ci ci1)
    {
        return ci1.h;
    }

    static String c()
    {
        return a;
    }

    static gh d(ci ci1)
    {
        return ci1.c;
    }

    private void d()
    {
        this;
        JVM INSTR monitorenter ;
        fn.a().a(this);
        a(a.a);
        i = null;
        g = null;
        h = null;
        j = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static String e(ci ci1)
    {
        return ci1.d;
    }

    private void e()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.b.equals(f);
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        gd.a(3, a, "Reported ids retrieved; request may continue");
        a(a.c);
        fp.a().b(new hq() {

            final ci a;

            public void safeRun()
            {
                ci.a(a, ci.b(a), ci.c(a));
            }

            
            {
                a = ci.this;
                super();
            }
        });
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static List f(ci ci1)
    {
        return ci1.j;
    }

    private void f()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.e.equals(f);
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = j.iterator();
_L9:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        ap ap1;
        Object obj;
        ap1 = (ap)iterator.next();
        obj = ap1.a();
        if (((AdUnit) (obj)).frequencyCapResponseInfoList != null)
        {
            az az1;
            for (Iterator iterator1 = ((AdUnit) (obj)).frequencyCapResponseInfoList.iterator(); iterator1.hasNext(); com.flurry.sdk.i.a().k().a(az1))
            {
                az1 = new az((FrequencyCapResponseInfo)iterator1.next());
            }

        }
          goto _L5
        Exception exception;
        exception;
        throw exception;
_L5:
        obj = ((AdUnit) (obj)).adFrames;
        int l = 0;
_L11:
        if (l >= ((List) (obj)).size()) goto _L7; else goto _L6
_L6:
        cy cy1 = da.a(((AdFrame)((List) (obj)).get(l)).display);
        if (cy1 == null)
        {
            break MISSING_BLOCK_LABEL_325;
        }
        ap1.a(l, cy1);
        if (!cy1.d())
        {
            break MISSING_BLOCK_LABEL_325;
        }
          goto _L7
_L10:
        if (l >= ((List) (obj)).size()) goto _L9; else goto _L8
_L8:
        ap1.a(l, ac.a(ap1, l));
        l++;
          goto _L10
_L4:
        gd.a(3, a, (new StringBuilder()).append("Handling ad response for adSpace: ").append(d).append(", size: ").append(j.size()).toString());
        if (j.size() > 0)
        {
            if (i != null)
            {
                i.a(j);
            }
            fp.a().b(new hq() {

                final ci a;

                public void safeRun()
                {
                    com.flurry.sdk.i.a().l().a(ci.f(a));
                }

            
            {
                a = ci.this;
                super();
            }
            });
        }
        g();
        d();
          goto _L1
_L7:
        l = 0;
          goto _L10
        l++;
          goto _L11
    }

    private void g()
    {
        cj cj1 = new cj();
        cj1.a = this;
        cj1.b = d;
        cj1.c = j;
        fz.a().a(cj1);
    }

    static void g(ci ci1)
    {
        ci1.f();
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        d();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(r r1, x x1, ap ap1)
    {
        this;
        JVM INSTR monitorenter ;
        gd.a(3, a, (new StringBuilder()).append("requestAd: adSpace = ").append(d).toString());
        if (a.a.equals(f)) goto _L2; else goto _L1
_L1:
        gd.a(3, a, (new StringBuilder()).append("requestAds: request pending ").append(f).toString());
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (fj.a().c())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        gd.a(5, a, "There is no network connectivity (requestAds will fail)");
        g();
          goto _L3
        r1;
        throw r1;
label0:
        {
            g = r1;
            h = ap1;
            i = x1;
            com.flurry.sdk.i.a().k().b();
            if (!fe.a().c())
            {
                break label0;
            }
            a(a.c);
            fp.a().b(new hq() {

                final ci a;

                public void safeRun()
                {
                    ci.a(a, ci.b(a), ci.c(a));
                }

            
            {
                a = ci.this;
                super();
            }
            });
        }
          goto _L3
        gd.a(3, a, "No reported ids yet; waiting");
        a(a.b);
          goto _L3
    }

    public void b()
    {
        d();
    }


    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        private static final a f[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/flurry/sdk/ci$a, s);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        static 
        {
            a = new a("NONE", 0);
            b = new a("WAIT_FOR_REPORTED_IDS", 1);
            c = new a("BUILD_REQUEST", 2);
            d = new a("REQUEST", 3);
            e = new a("PREPROCESS", 4);
            f = (new a[] {
                a, b, c, d, e
            });
        }

        private a(String s, int l)
        {
            super(s, l);
        }
    }

}
