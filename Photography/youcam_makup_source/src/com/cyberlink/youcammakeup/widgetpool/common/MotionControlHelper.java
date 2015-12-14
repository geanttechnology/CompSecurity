// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.SeekBar;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.clflurry.YMKApplyEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.jniproxy.UIBeautifierCacheMode;
import com.cyberlink.youcammakeup.jniproxy.ae;
import com.cyberlink.youcammakeup.jniproxy.ah;
import com.cyberlink.youcammakeup.jniproxy.al;
import com.cyberlink.youcammakeup.jniproxy.av;
import com.cyberlink.youcammakeup.jniproxy.bc;
import com.cyberlink.youcammakeup.jniproxy.bi;
import com.cyberlink.youcammakeup.jniproxy.bk;
import com.cyberlink.youcammakeup.jniproxy.bm;
import com.cyberlink.youcammakeup.jniproxy.s;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.jniproxy.z;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.k;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.l;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.n;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.o;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.p;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.q;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.t;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.u;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.ad;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.ai;
import com.cyberlink.youcammakeup.utility.aq;
import com.cyberlink.youcammakeup.utility.ar;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.bb;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl;
import com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c;
import com.pf.common.restart.RestartService;
import com.pf.common.utility.m;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            ah, ab, ad, af, 
//            z, ag, ai, aa, 
//            ac, ae

public class MotionControlHelper
    implements ad
{

    public static final String a = (new StringBuilder()).append(Globals.d().q()).append("/wig_offset_data").toString();
    public static final String b = (new StringBuilder()).append(a).append("/").append("reserved").toString();
    public static final String c = (new StringBuilder()).append(a).append("/").append("temp").toString();
    public static final android.graphics.BitmapFactory.Options d;
    public static final String h = Exporter.f();
    private ae A;
    private ae B;
    private Pair C;
    private Pair D;
    private Pair E;
    private ConcurrentHashMap F;
    private HashMap G;
    private HashMap H;
    private HashMap I;
    private HashMap J;
    private HashMap K;
    private HashMap L;
    private HashMap M;
    private HashMap N;
    private HashMap O;
    private HashMap P;
    private HashMap Q;
    private ae R;
    private ae S;
    private ae T;
    private ae U;
    private Pair V;
    private Pair W;
    private Pair X;
    private List Y;
    private HashMap Z;
    private HashMap aA;
    private HashMap aB;
    private HashMap aC;
    private boolean aD;
    private com.cyberlink.youcammakeup.widgetpool.common.z aE;
    private HashMap aF;
    private HashMap aG;
    private HashMap aH;
    private final List aI;
    private final Map aJ;
    private final Map aK;
    private final List aL;
    private final Map aM;
    private final Map aN;
    private List aO;
    private LinkedHashMap aP;
    private LinkedHashMap aQ;
    private LinkedHashMap aR;
    private LinkedHashMap aS;
    private LinkedHashMap aT;
    private boolean aU;
    private boolean aV;
    private boolean aW;
    private boolean aX;
    private boolean aY;
    private boolean aZ;
    private HashMap aa;
    private HashMap ab;
    private HashMap ac;
    private HashMap ad;
    private boolean ae;
    private com.cyberlink.youcammakeup.widgetpool.common.ah af;
    private ae ag;
    private ae ah;
    private HashMap ai;
    private HashMap aj;
    private boolean ak;
    private ab al;
    private ae am;
    private ae an;
    private HashMap ao;
    private HashMap ap;
    private boolean aq;
    private com.cyberlink.youcammakeup.widgetpool.common.ad ar;
    private ae as;
    private ae at;
    private HashMap au;
    private final HashMap av;
    private boolean aw;
    private af ax;
    private ae ay;
    private ae az;
    private boolean ba;
    private boolean bb;
    private int bc;
    private int bd;
    private boolean be;
    private boolean bf;
    public HashMap e;
    public HashMap f;
    boolean g;
    private ConfigErrorCode i;
    private float j;
    private SeekBar k;
    private SeekBar l;
    private List m;
    private boolean n;
    private int o;
    private int p;
    private ae q;
    private Pair r;
    private Boolean s;
    private Integer t;
    private HashMap u;
    private boolean v;
    private String w;
    private ae x;
    private ae y;
    private ae z;

    private MotionControlHelper()
    {
        i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.a;
        j = 0.0F;
        n = false;
        o = 0;
        p = 50;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        v = true;
        w = "";
        x = null;
        y = null;
        z = null;
        A = null;
        B = null;
        C = null;
        D = null;
        E = null;
        F = null;
        G = null;
        H = null;
        I = new HashMap();
        J = new HashMap();
        K = new HashMap();
        L = new HashMap();
        M = new HashMap();
        N = new HashMap();
        O = new HashMap();
        P = new HashMap();
        Q = new HashMap();
        R = null;
        S = null;
        T = null;
        U = null;
        V = null;
        W = null;
        X = null;
        Y = null;
        Z = null;
        aa = null;
        ab = null;
        ac = null;
        ad = null;
        ae = true;
        af = null;
        ag = null;
        ah = null;
        ai = new HashMap();
        aj = null;
        ak = true;
        al = null;
        am = null;
        an = null;
        ao = new HashMap();
        ap = null;
        aq = true;
        ar = null;
        as = null;
        at = null;
        au = new HashMap();
        av = null;
        aw = true;
        ax = null;
        ay = null;
        az = null;
        aA = new HashMap();
        aB = null;
        aC = null;
        aD = true;
        aE = null;
        aF = null;
        aG = null;
        aH = null;
        aI = new ArrayList();
        aJ = new HashMap();
        aK = new HashMap();
        aL = new ArrayList();
        aM = new HashMap();
        aN = new HashMap();
        aO = null;
        aP = null;
        aQ = null;
        aR = null;
        aS = null;
        aT = null;
        e = null;
        f = null;
        aU = false;
        g = false;
        aV = true;
        aW = true;
        aX = true;
        aY = true;
        aZ = true;
        ba = true;
        bb = true;
        be = false;
        bf = false;
        j = 0.0F;
        k = null;
        l = null;
        ArrayList arraylist = new ArrayList();
        arraylist.add(new at(0));
        m = arraylist;
        n = false;
        b(0);
        com.cyberlink.youcammakeup.utility.bb.a(b);
        com.cyberlink.youcammakeup.utility.bb.a(c);
    }


    private static List A(String s1)
    {
        ArrayList arraylist = new ArrayList();
        if (s1 == null)
        {
            return arraylist;
        }
        List list = PanelDataCenter.a().a(s1);
        int i1 = 0;
        while (i1 < list.size()) 
        {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list.get(i1);
            if (mask == null)
            {
                arraylist.add(s1);
            } else
            {
                arraylist.add(a(mask));
            }
            i1++;
        }
        return arraylist;
    }

    private static com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask B(String s1)
    {
label0:
        {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask1 = e().y(s1);
            com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask = mask1;
            if (mask1 == null)
            {
                s1 = PanelDataCenter.a().a(s1);
                if (s1 != null && s1.size() >= 1)
                {
                    break label0;
                }
                mask = null;
            }
            return mask;
        }
        return (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)s1.get(0);
    }

    public static at a(List list, at at1)
    {
        av av1 = e().a();
        at at2 = at1;
        if (av1 != null)
        {
            at2 = at1;
            if (av1.b() > 2L)
            {
                int j1 = -1;
                float f1 = 442F;
                for (int i1 = 0; i1 < list.size();)
                {
                    int k1 = ((at)list.get(i1)).a().intValue();
                    int l1 = ((at)list.get(i1)).b().intValue();
                    int i2 = ((at)list.get(i1)).c().intValue();
                    int j2 = av1.b(2);
                    int k2 = av1.b(1);
                    int l2 = av1.b(0);
                    float f3 = (float)Math.sqrt((float)((double)((l1 - i2 - (k2 - l2)) * (l1 - i2 - (k2 - l2)) + (l1 - k1 - (k2 - j2)) * (l1 - k1 - (k2 - j2))) + (double)((l1 - k2) * (l1 - k2)) * 0.10000000000000001D));
                    float f2 = f1;
                    if (f1 > f3)
                    {
                        j1 = i1;
                        f2 = f3;
                    }
                    i1++;
                    f1 = f2;
                }

                at2 = at1;
                if (j1 >= 0)
                {
                    at2 = (at)list.get(j1);
                }
            }
        }
        return at2;
    }

    private static String a(com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask)
    {
        return String.format(Locale.US, "%s_%d", new Object[] {
            mask.a(), Integer.valueOf(mask.B())
        });
    }

    private void a(Pair pair)
    {
        if (pair != null)
        {
            if (pair.first != null)
            {
                com.cyberlink.youcammakeup.utility.bb.b(new File((String)pair.first));
            }
            if (pair.second != null)
            {
                com.cyberlink.youcammakeup.utility.bb.b(new File((String)pair.second));
            }
        }
    }

    private void a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName featurename)
    {
        if (featurename != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        class _cls1
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.values().length];
                try
                {
                    b[com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.l.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    b[com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    b[com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    b[com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.j.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    b[com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.k.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    b[com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.m.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    b[com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.n.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    b[com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.t.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    b[com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.v.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    b[com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.w.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    b[com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.x.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    b[com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.y.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    b[com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.z.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                a = new int[BeautyMode.values().length];
                try
                {
                    a[BeautyMode.n.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    a[BeautyMode.m.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    a[BeautyMode.l.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    a[BeautyMode.x.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    a[BeautyMode.z.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[BeautyMode.A.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[BeautyMode.B.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[BeautyMode.C.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[BeautyMode.a.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[BeautyMode.r.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[BeautyMode.j.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[BeautyMode.k.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[BeautyMode.s.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.cyberlink.youcammakeup.widgetpool.common._cls1.b[featurename.ordinal()])
        {
        default:
            com.pf.common.utility.m.d("MotionControlHelper", (new StringBuilder()).append("logYMKTryoutEvent, not supported yet (featureName=").append(featurename.a()).append(")").toString());
            return;

        case 1: // '\001'
            featurename = e().C();
            boolean flag;
            if (w != null && !w.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                com.cyberlink.youcammakeup.clflurry.at at1 = new com.cyberlink.youcammakeup.clflurry.at(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.l);
                com.cyberlink.youcammakeup.clflurry.at.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.l, featurename, at1);
                com.cyberlink.youcammakeup.clflurry.b.a(at1.e());
                return;
            }
            aw aw1 = PanelDataCenter.a().i(featurename.c());
            if (aw1 != null && aw1.g() != com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c && !e().a(((r) (featurename))))
            {
                com.cyberlink.youcammakeup.clflurry.at at2 = new com.cyberlink.youcammakeup.clflurry.at(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.l);
                com.cyberlink.youcammakeup.clflurry.at.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.l, featurename, at2);
                com.cyberlink.youcammakeup.clflurry.b.a(at2.e());
                return;
            }
            break;

        case 2: // '\002'
            featurename = J();
            if (w != null)
            {
                if (w.isEmpty());
            }
            com.cyberlink.youcammakeup.clflurry.at at3 = new com.cyberlink.youcammakeup.clflurry.at(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.c);
            YMKApplyEvent.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.c, featurename, at3);
            com.cyberlink.youcammakeup.clflurry.b.a(at3.e());
            return;

        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
            r r1 = J();
            com.cyberlink.youcammakeup.clflurry.at at4 = new com.cyberlink.youcammakeup.clflurry.at(featurename);
            YMKApplyEvent.a(featurename, r1, at4);
            com.cyberlink.youcammakeup.clflurry.b.a(at4.e());
            return;

        case 10: // '\n'
            com.cyberlink.youcammakeup.clflurry.b.a(F().d().e());
            return;

        case 11: // '\013'
            com.cyberlink.youcammakeup.clflurry.b.a(G().d().e());
            return;

        case 12: // '\f'
            com.cyberlink.youcammakeup.clflurry.b.a(H().d().e());
            return;

        case 13: // '\r'
            com.cyberlink.youcammakeup.clflurry.b.a(I().d().e());
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void a(ae ae1)
    {
        if (ae1 != null)
        {
            for (int i1 = 0; (long)i1 < ae1.b(); i1++)
            {
                if (ae1.a(i1) != null)
                {
                    com.cyberlink.youcammakeup.utility.bb.b(new File(ae1.a(i1)));
                }
            }

        }
    }

    private void a(List list, Map map, Map map1)
    {
        String s1;
        for (list = list.iterator(); list.hasNext(); map.remove(s1))
        {
            s1 = (String)list.next();
            map1.put(s1, map.get(s1));
        }

        for (list = map1.keySet().iterator(); list.hasNext(); map.remove((String)list.next())) { }
        for (list = map.values().iterator(); list.hasNext(); com.cyberlink.youcammakeup.utility.bb.b(new File((String)list.next()))) { }
    }

    private boolean a(o o1, BeautifierTaskInfo beautifiertaskinfo)
    {
        boolean flag = false;
        o1 = o1.a();
        if (o1.size() > 0)
        {
            flag = a(((List) (o1)), false, beautifiertaskinfo);
        }
        return flag;
    }

    private static boolean a(BeautyMode beautymode, String s1, String s2)
    {
        beautymode = c(beautymode);
        s1 = b(s1, s2);
        return ((Float)((Pair) (s1)).first).floatValue() <= ((Float)((Pair) (beautymode)).first).floatValue() && ((Float)((Pair) (s1)).second).floatValue() <= ((Float)((Pair) (beautymode)).second).floatValue();
    }

    private boolean a(List list, at at1, int i1, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        Map map = aM;
        List list1 = aL;
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        ArrayList arraylist3 = new ArrayList();
        list1.clear();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            list = (String)iterator.next();
            List list2 = PanelDataCenter.a().a(list);
            int j1 = 0;
            while (j1 < list2.size()) 
            {
                com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(j1);
                String s1 = a(mask);
                arraylist1.add(s1);
                list1.add(s1);
                if (map.get(s1) == null)
                {
                    Bitmap bitmap = i(mask.b());
                    list = bitmap;
                    if (bitmap == null)
                    {
                        for (list = arraylist.iterator(); list.hasNext(); com.cyberlink.youcammakeup.utility.aa.a((Bitmap)list.next())) { }
                        arraylist.clear();
                        list1.clear();
                        com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("[configFaceWidget] getMaskBitmap failed. GUID: ").append(s1).toString());
                        return false;
                    }
                } else
                {
                    list = Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ARGB_8888);
                }
                arraylist.add(list);
                arraylist2.add(mask.w());
                al al1 = new al();
                if (at1 == null)
                {
                    list = null;
                } else
                {
                    list = at1.l();
                }
                if (list != null && list.length == 8)
                {
                    al1.a(true);
                    al1.a(list[0]);
                    al1.b(list[1]);
                    al1.c(list[2]);
                    al1.d(list[3]);
                    al1.e(list[4]);
                    al1.f(list[5]);
                    al1.g(list[6]);
                    al1.h(list[7]);
                    al1.i(i1);
                }
                arraylist3.add(al1);
                j1++;
            }
        }

        BeautifierEditCenter.a().b(map, arraylist1, arraylist, arraylist2, arraylist3, flag, beautifiertaskinfo);
        return true;
    }

    private boolean a(List list, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        Map map = aJ;
        List list1 = aI;
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        ArrayList arraylist3 = new ArrayList();
        list1.clear();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            list = (String)iterator.next();
            List list2 = PanelDataCenter.a().a(list);
            int i1 = 0;
            while (i1 < list2.size()) 
            {
                com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(i1);
                String s1 = a(mask);
                arraylist1.add(s1);
                list1.add(s1);
                if (map.get(s1) == null)
                {
                    Bitmap bitmap = i(mask.b());
                    list = bitmap;
                    if (bitmap == null)
                    {
                        for (list = arraylist.iterator(); list.hasNext(); com.cyberlink.youcammakeup.utility.aa.a((Bitmap)list.next())) { }
                        arraylist.clear();
                        list1.clear();
                        com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("[configFaceArt] getMaskBitmap failed. GUID: ").append(s1).toString());
                        return false;
                    }
                } else
                {
                    list = Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ALPHA_8);
                }
                arraylist.add(list);
                arraylist2.add(mask.w());
                arraylist3.add(new al());
                i1++;
            }
        }

        BeautifierEditCenter.a().c(s.booleanValue(), false, beautifiertaskinfo);
        BeautifierEditCenter.a().a(map, arraylist1, arraylist, arraylist2, arraylist3, flag, beautifiertaskinfo);
        return true;
    }

    private static Pair b(String s1, String s2)
    {
        Pair pair = Pair.create(Float.valueOf(2.0F), Float.valueOf(2.0F));
        if (s1 != null && s2 != null)
        {
            if (s1.equalsIgnoreCase(s2))
            {
                return Pair.create(Float.valueOf(0.0F), Float.valueOf(0.0F));
            }
            s1 = B(s1);
            if (s1 != null && s1.b() != null)
            {
                s2 = B(s2);
                if (s2 != null && s2.b() != null)
                {
                    s1 = i(s1.b());
                    s2 = i(s2.b());
                    if (s1 != null && s2 != null)
                    {
                        int i1 = s1.getWidth();
                        int j1 = s2.getWidth();
                        int k1 = s1.getHeight();
                        int l1 = s2.getHeight();
                        if (i1 != 0 && j1 != 0 && k1 != 0 && l1 != 0)
                        {
                            return Pair.create(Float.valueOf((float)Math.abs(i1 - j1) / ((float)(i1 + j1) / 2.0F)), Float.valueOf((float)Math.abs(k1 - l1) / ((float)(k1 + l1) / 2.0F)));
                        }
                    }
                }
            }
        }
        return pair;
    }

    private ae b(ae ae1)
    {
        ae ae2 = null;
        if (ae1 != null)
        {
            ae2 = new ae();
            for (int i1 = 0; (long)i1 < ae1.b(); i1++)
            {
                if (ae1.a(i1) != null)
                {
                    ae2.a(ae1.a(i1));
                }
            }

        }
        return ae2;
    }

    private static List b(BeautyMode beautymode)
    {
        beautymode = SkuTemplateUtils.a(beautymode);
        Object obj = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().b(beautymode);
        ArrayList arraylist = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = (Long)((Iterator) (obj)).next();
            obj1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(beautymode, ((Long) (obj1)));
            if (obj1 != null)
            {
                obj1 = ((d) (obj1)).l().iterator();
                while (((Iterator) (obj1)).hasNext()) 
                {
                    arraylist.addAll(A(((e)((Iterator) (obj1)).next()).a()));
                }
            }
        } while (true);
        return arraylist;
    }

    private void b(Pair pair)
    {
        if (pair != null)
        {
            if (pair.first != null)
            {
                com.cyberlink.youcammakeup.utility.bb.b(new File((String)pair.first));
            }
            if (pair.second != null)
            {
                for (pair = ((List)pair.second).iterator(); pair.hasNext(); com.cyberlink.youcammakeup.utility.bb.b(new File((String)pair.next()))) { }
            }
        }
    }

    private boolean b(BeautifierTaskInfo beautifiertaskinfo, boolean flag)
    {
        Object obj1;
        Object obj4;
        Object obj5;
        Object obj6;
        obj6 = StatusManager.j().s();
        if (obj6 == BeautyMode.n)
        {
            String s1 = StatusManager.j().e();
            if (m.size() == 0)
            {
                return false;
            }
            av av1 = new av();
            s s3 = new s();
            obj6 = new av();
            Object obj7 = m.iterator();
            while (((Iterator) (obj7)).hasNext()) 
            {
                at at1 = (at)((Iterator) (obj7)).next();
                com.cyberlink.youcammakeup.jniproxy.r r2 = new com.cyberlink.youcammakeup.jniproxy.r();
                r2.a(at1.a().intValue());
                r2.b(at1.b().intValue());
                r2.c(at1.c().intValue());
                av1.a(at1.d());
                s3.a(r2);
                int i1;
                if (at1.k())
                {
                    i1 = at1.j();
                } else
                {
                    i1 = 0;
                }
                ((av) (obj6)).a(i1);
            }
            obj7 = PanelDataCenter.a().a(s1);
            if (obj7 == null || ((List) (obj7)).size() < 1)
            {
                return false;
            }
            av av2 = new av();
            Object obj9 = ((List) (obj7)).iterator();
            while (((Iterator) (obj9)).hasNext()) 
            {
                com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.EyeShadowSide eyeshadowside = ((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((Iterator) (obj9)).next()).k();
                int j1 = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.EyeShadowSide.a.ordinal();
                if (eyeshadowside == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.EyeShadowSide.b)
                {
                    j1 = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.EyeShadowSide.b.ordinal();
                } else
                if (eyeshadowside == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.EyeShadowSide.c)
                {
                    j1 = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.EyeShadowSide.c.ordinal();
                }
                av2.a(j1);
            }
            obj9 = new bc();
            Object obj11 = new ah();
            ((ah) (obj11)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj7)).get(0)).g().x);
            ((ah) (obj11)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj7)).get(0)).g().y);
            Object obj13 = new ah();
            ((ah) (obj13)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj7)).get(0)).i().x);
            ((ah) (obj13)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj7)).get(0)).i().y);
            ah ah15 = new ah();
            ah15.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj7)).get(0)).h().x);
            ah15.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj7)).get(0)).h().y);
            ah ah19 = new ah();
            ah19.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj7)).get(0)).j().x);
            ah19.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj7)).get(0)).j().y);
            ((bc) (obj9)).a(((ah) (obj11)));
            ((bc) (obj9)).c(((ah) (obj13)));
            ((bc) (obj9)).b(ah15);
            ((bc) (obj9)).d(ah19);
            obj11 = i("assets://makeup/eyeshadow/bright.png");
            obj13 = PanelDataCenter.a().c(s1);
            boolean flag1;
            if (((List) (obj13)).size() == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (obj13 != null && ((List) (obj13)).size() >= 1)
            {
                int k5 = 0;
                while (k5 < ((List) (obj13)).size()) 
                {
                    bc bc4 = new bc();
                    Object obj15 = new ah();
                    ((ah) (obj15)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj13)).get(k5)).c().x);
                    ((ah) (obj15)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj13)).get(k5)).c().y);
                    ah ah21 = new ah();
                    ah21.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj13)).get(k5)).e().x);
                    ah21.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj13)).get(k5)).e().y);
                    ah ah22 = new ah();
                    ah22.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj13)).get(k5)).d().x);
                    ah22.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj13)).get(k5)).d().y);
                    ah ah23 = new ah();
                    ah23.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj13)).get(k5)).f().x);
                    ah23.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj13)).get(k5)).f().y);
                    bc4.a(((ah) (obj15)));
                    bc4.c(ah21);
                    bc4.b(ah22);
                    bc4.d(ah23);
                    int j7 = ((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj13)).get(k5)).l();
                    int k8 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj13)).get(k5)).k());
                    obj15 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj13)).get(k5)).a());
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj13)).get(k5)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.b)
                    {
                        BeautifierEditCenter.a().a(j7, k8, ((Bitmap) (obj15)), bc4);
                        if (flag1)
                        {
                            BeautifierEditCenter.a().b(0, k8, ((Bitmap) (obj15)), bc4);
                        }
                    } else
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj13)).get(k5)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.c)
                    {
                        BeautifierEditCenter.a().b(j7, k8, ((Bitmap) (obj15)), bc4);
                        if (flag1)
                        {
                            BeautifierEditCenter.a().a(0, k8, ((Bitmap) (obj15)), bc4);
                        }
                    } else
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj13)).get(k5)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.a)
                    {
                        BeautifierEditCenter.a().c(j7, k8, ((Bitmap) (obj15)), bc4);
                    }
                    k5++;
                }
            }
            if (flag)
            {
                a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.l);
            }
            if (q == null)
            {
                if (F == null)
                {
                    F = new ConcurrentHashMap();
                }
                if (F.get(s1) != null)
                {
                    q = b((ae)F.get(s1));
                    BeautifierEditCenter.a().a(av1, ((av) (obj6)), s3, av2, q, ((bc) (obj9)), s1, true, ((List) (obj13)).size(), beautifiertaskinfo);
                } else
                {
                    ArrayList arraylist2 = new ArrayList();
                    for (int k1 = 0; k1 < ((List) (obj7)).size(); k1++)
                    {
                        Bitmap bitmap1 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj7)).get(k1)).b());
                        if (bitmap1 != null)
                        {
                            arraylist2.add(bitmap1);
                        }
                    }

                    q = BeautifierEditCenter.a().a(av1, ((av) (obj6)), s3, av2, arraylist2, ((Bitmap) (obj11)), ((bc) (obj9)), s1, true, ((List) (obj13)).size(), beautifiertaskinfo);
                    F.put(s1, q);
                }
            } else
            {
                BeautifierEditCenter.a().a(av1, ((av) (obj6)), s3, av2, q, ((bc) (obj9)), s1, true, ((List) (obj13)).size(), beautifiertaskinfo);
            }
        } else
        if (obj6 == BeautyMode.t)
        {
            String s2 = StatusManager.j().e();
            if (s2 == null)
            {
                return false;
            }
            int l1 = 0;
            if (!s2.equalsIgnoreCase("default_original_double_eyelid"))
            {
                l1 = ((at)m.get(0)).d();
            }
            if (PanelDataCenter.a().a(s2).size() < 1)
            {
                return false;
            }
            com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)PanelDataCenter.a().a(s2).get(0);
            bc bc1 = new bc();
            obj6 = new ah();
            ((ah) (obj6)).a(mask.g().x);
            ((ah) (obj6)).b(mask.g().y);
            ah ah2 = new ah();
            ah2.a(mask.i().x);
            ah2.b(mask.i().y);
            ah ah6 = new ah();
            ah6.a(mask.h().x);
            ah6.b(mask.h().y);
            ah ah11 = new ah();
            ah11.a(mask.j().x);
            ah11.b(mask.j().y);
            bc1.a(((ah) (obj6)));
            bc1.c(ah2);
            bc1.b(ah6);
            bc1.d(ah11);
            obj6 = new com.cyberlink.youcammakeup.jniproxy.r(((at)m.get(0)).a().intValue(), ((at)m.get(0)).b().intValue(), ((at)m.get(0)).c().intValue());
            if (q == null)
            {
                if (F == null)
                {
                    F = new ConcurrentHashMap();
                }
                if (F.get(s2) != null)
                {
                    q = b((ae)F.get(s2));
                    BeautifierEditCenter.a().a(l1, ((com.cyberlink.youcammakeup.jniproxy.r) (obj6)), q, bc1, s2, true, beautifiertaskinfo);
                } else
                {
                    q = BeautifierEditCenter.a().a(l1, ((com.cyberlink.youcammakeup.jniproxy.r) (obj6)), i(mask.b()), bc1, s2, true, beautifiertaskinfo);
                    F.put(s2, q);
                }
            } else
            {
                BeautifierEditCenter.a().a(l1, ((com.cyberlink.youcammakeup.jniproxy.r) (obj6)), q, bc1, s2, true, beautifiertaskinfo);
            }
        } else
        if (obj6 == BeautyMode.r)
        {
            String s4 = StatusManager.j().e();
            obj6 = PanelDataCenter.a().a(s4);
            if (obj6 == null || ((List) (obj6)).size() < 1)
            {
                return false;
            }
            if (m.size() == 0)
            {
                return false;
            }
            Object obj;
            com.cyberlink.youcammakeup.jniproxy.r r1;
            com.cyberlink.youcammakeup.jniproxy.bb bb1;
            Object obj10;
            Object obj12;
            Object obj14;
            long l9;
            boolean flag4;
            boolean flag10;
            if (s4 != null && s4.equals("Eyebrow_general"))
            {
                flag4 = false;
            } else
            {
                flag4 = b(s4);
            }
            l9 = StatusManager.j().l();
            obj = Globals.d().t();
            flag10 = false;
            if (obj != null)
            {
                flag10 = ((EditViewActivity) (obj)).A();
            }
            if (flag10)
            {
                obj = StatusManager.j().l(l9);
            } else
            {
                obj = StatusManager.j().i(l9);
            }
            if (obj != null)
            {
                flag10 = e().a(((a) (obj)).e);
                r1 = new com.cyberlink.youcammakeup.jniproxy.r();
                r1.a(((at)m.get(0)).a().intValue());
                r1.b(((at)m.get(0)).b().intValue());
                r1.c(((at)m.get(0)).c().intValue());
                bb1 = new com.cyberlink.youcammakeup.jniproxy.bb();
                obj = new ah();
                ((ah) (obj)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).l().x);
                ((ah) (obj)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).l().y);
                ah ah1 = new ah();
                ah1.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).m().x);
                ah1.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).m().y);
                obj10 = new ah();
                ((ah) (obj10)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).n().x);
                ((ah) (obj10)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).n().y);
                bb1.a(((ah) (obj)));
                bb1.b(ah1);
                bb1.c(((ah) (obj10)));
                obj10 = new com.cyberlink.youcammakeup.jniproxy.bb();
                obj = new ah();
                ((ah) (obj)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).o().x);
                ((ah) (obj)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).o().y);
                ah1 = new ah();
                ah1.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).p().x);
                ah1.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).p().y);
                obj12 = new ah();
                ((ah) (obj12)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).q().x);
                ((ah) (obj12)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).q().y);
                ((com.cyberlink.youcammakeup.jniproxy.bb) (obj10)).a(((ah) (obj)));
                ((com.cyberlink.youcammakeup.jniproxy.bb) (obj10)).b(ah1);
                ((com.cyberlink.youcammakeup.jniproxy.bb) (obj10)).c(((ah) (obj12)));
                obj12 = new com.cyberlink.youcammakeup.jniproxy.bb();
                obj = new ah();
                ((ah) (obj)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).r().x);
                ((ah) (obj)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).r().y);
                ah1 = new ah();
                ah1.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).s().x);
                ah1.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).s().y);
                obj14 = new ah();
                ((ah) (obj14)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).t().x);
                ((ah) (obj14)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(0)).t().y);
                ((com.cyberlink.youcammakeup.jniproxy.bb) (obj12)).a(((ah) (obj)));
                ((com.cyberlink.youcammakeup.jniproxy.bb) (obj12)).b(ah1);
                ((com.cyberlink.youcammakeup.jniproxy.bb) (obj12)).c(((ah) (obj14)));
                obj14 = PanelDataCenter.a().c(s4);
                if (obj14 != null && ((List) (obj14)).size() >= 1)
                {
                    int i2 = 0;
                    while (i2 < ((List) (obj14)).size()) 
                    {
                        obj = new bc();
                        Object obj2 = new ah();
                        ((ah) (obj2)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj14)).get(i2)).g().x);
                        ((ah) (obj2)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj14)).get(i2)).g().y);
                        ah ah16 = new ah();
                        ah16.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj14)).get(i2)).i().x);
                        ah16.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj14)).get(i2)).i().y);
                        ah ah20 = new ah();
                        ah20.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj14)).get(i2)).h().x);
                        ah20.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj14)).get(i2)).h().y);
                        ((bc) (obj)).a(((ah) (obj2)));
                        ((bc) (obj)).c(ah16);
                        ((bc) (obj)).b(ah20);
                        int l5 = ((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj14)).get(i2)).l();
                        int k7 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj14)).get(i2)).k());
                        obj2 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj14)).get(i2)).a());
                        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj14)).get(i2)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.b)
                        {
                            BeautifierEditCenter.a().m(l5, k7, ((Bitmap) (obj2)), ((bc) (obj)));
                        } else
                        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj14)).get(i2)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.c)
                        {
                            BeautifierEditCenter.a().n(l5, k7, ((Bitmap) (obj2)), ((bc) (obj)));
                        } else
                        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj14)).get(i2)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.a)
                        {
                            BeautifierEditCenter.a().o(l5, k7, ((Bitmap) (obj2)), ((bc) (obj)));
                        }
                        i2++;
                    }
                }
            } else
            {
                return false;
            }
            if (flag)
            {
                a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.m);
            }
            if (r == null)
            {
                if (G == null)
                {
                    G = new HashMap();
                }
                if (G.get(s4) != null)
                {
                    r = c((Pair)G.get(s4));
                    BeautifierEditCenter.a().a((int)((float)((at)m.get(0)).d() * 0.7F), (int)(j * 0.5F), r1, (String)r.first, (String)r.second, bb1, ((com.cyberlink.youcammakeup.jniproxy.bb) (obj10)), ((com.cyberlink.youcammakeup.jniproxy.bb) (obj12)), s4, flag10, flag4, true, ((List) (obj14)).size(), beautifiertaskinfo);
                } else
                {
                    Bitmap bitmap = null;
                    Object obj3 = null;
                    for (int j2 = 0; j2 < ((List) (obj6)).size(); j2++)
                    {
                        obj3 = ((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(j2)).b();
                        bitmap = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj6)).get(j2)).c());
                        obj3 = i(((String) (obj3)));
                    }

                    r = BeautifierEditCenter.a().a((int)((float)((at)m.get(0)).d() * 0.7F), (int)(j * 0.5F), r1, bitmap, ((Bitmap) (obj3)), bb1, ((com.cyberlink.youcammakeup.jniproxy.bb) (obj10)), ((com.cyberlink.youcammakeup.jniproxy.bb) (obj12)), s4, flag10, flag4, true, ((List) (obj14)).size(), beautifiertaskinfo);
                    if (r != null)
                    {
                        G.put(s4, r);
                    }
                }
            } else
            {
                BeautifierEditCenter.a().a((int)((float)((at)m.get(0)).d() * 0.7F), (int)(j * 0.5F), r1, (String)r.first, (String)r.second, bb1, ((com.cyberlink.youcammakeup.jniproxy.bb) (obj10)), ((com.cyberlink.youcammakeup.jniproxy.bb) (obj12)), s4, flag10, flag4, true, ((List) (obj14)).size(), beautifiertaskinfo);
            }
        } else
        if (obj6 == BeautyMode.l)
        {
            String s5 = StatusManager.j().e();
            List list1 = PanelDataCenter.a().a(s5);
            if (list1 == null || list1.size() < 1)
            {
                return false;
            }
            if (m.size() == 0)
            {
                return false;
            }
            com.cyberlink.youcammakeup.jniproxy.r r3 = new com.cyberlink.youcammakeup.jniproxy.r();
            r3.a(((at)m.get(0)).a().intValue());
            r3.b(((at)m.get(0)).b().intValue());
            r3.c(((at)m.get(0)).c().intValue());
            bc bc2 = new bc();
            obj1 = new ah();
            ((ah) (obj1)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).g().x);
            ((ah) (obj1)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).g().y);
            obj4 = new ah();
            ((ah) (obj4)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).i().x);
            ((ah) (obj4)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).i().y);
            obj5 = new ah();
            ((ah) (obj5)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).h().x);
            ((ah) (obj5)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).h().y);
            obj6 = new ah();
            ((ah) (obj6)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).j().x);
            ((ah) (obj6)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).j().y);
            bc2.a(((ah) (obj1)));
            bc2.c(((ah) (obj4)));
            bc2.b(((ah) (obj5)));
            bc2.d(((ah) (obj6)));
            List list4 = PanelDataCenter.a().c(s5);
            if (list4 != null && list4.size() >= 1)
            {
                int k2 = 0;
                while (k2 < list4.size()) 
                {
                    obj1 = new bc();
                    obj4 = new ah();
                    ((ah) (obj4)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list4.get(k2)).c().x);
                    ((ah) (obj4)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list4.get(k2)).c().y);
                    obj5 = new ah();
                    ((ah) (obj5)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list4.get(k2)).e().x);
                    ((ah) (obj5)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list4.get(k2)).e().y);
                    obj6 = new ah();
                    ((ah) (obj6)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list4.get(k2)).d().x);
                    ((ah) (obj6)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list4.get(k2)).d().y);
                    ah ah17 = new ah();
                    ah17.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list4.get(k2)).f().x);
                    ah17.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list4.get(k2)).f().y);
                    ((bc) (obj1)).a(((ah) (obj4)));
                    ((bc) (obj1)).c(((ah) (obj5)));
                    ((bc) (obj1)).b(((ah) (obj6)));
                    ((bc) (obj1)).d(ah17);
                    int i6 = ((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list4.get(k2)).l();
                    int l7 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list4.get(k2)).k());
                    obj4 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list4.get(k2)).a());
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list4.get(k2)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.b)
                    {
                        BeautifierEditCenter.a().d(i6, l7, ((Bitmap) (obj4)), ((bc) (obj1)));
                    } else
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list4.get(k2)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.c)
                    {
                        BeautifierEditCenter.a().e(i6, l7, ((Bitmap) (obj4)), ((bc) (obj1)));
                    } else
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list4.get(k2)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.a)
                    {
                        BeautifierEditCenter.a().f(i6, l7, ((Bitmap) (obj4)), ((bc) (obj1)));
                    }
                    k2++;
                }
            }
            if (flag)
            {
                a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.j);
            }
            ArrayList arraylist3;
            int l2;
            if (q == null)
            {
label0:
                {
                    if (F == null)
                    {
                        F = new ConcurrentHashMap();
                    }
                    if (F.get(s5) == null)
                    {
                        break label0;
                    }
                    q = b((ae)F.get(s5));
                    BeautifierEditCenter.a().a(((at)m.get(0)).d(), r3, q, bc2, s5, true, list4.size(), beautifiertaskinfo);
                }
            } else
            {
                BeautifierEditCenter.a().a(((at)m.get(0)).d(), r3, q, bc2, s5, true, list4.size(), beautifiertaskinfo);
            }
        } else
        if (obj6 == BeautyMode.m)
        {
            String s6 = StatusManager.j().e();
            List list2 = PanelDataCenter.a().a(s6);
            if (list2 == null || list2.size() < 1)
            {
                return false;
            }
            if (m.size() == 0)
            {
                return false;
            }
            com.cyberlink.youcammakeup.jniproxy.r r4 = new com.cyberlink.youcammakeup.jniproxy.r();
            r4.a(((at)m.get(0)).a().intValue());
            r4.b(((at)m.get(0)).b().intValue());
            r4.c(((at)m.get(0)).c().intValue());
            bc bc3 = new bc();
            obj1 = new ah();
            ((ah) (obj1)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(0)).g().x);
            ((ah) (obj1)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(0)).g().y);
            obj4 = new ah();
            ((ah) (obj4)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(0)).i().x);
            ((ah) (obj4)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(0)).i().y);
            obj5 = new ah();
            ((ah) (obj5)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(0)).h().x);
            ((ah) (obj5)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(0)).h().y);
            obj6 = new ah();
            ((ah) (obj6)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(0)).j().x);
            ((ah) (obj6)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(0)).j().y);
            bc3.a(((ah) (obj1)));
            bc3.c(((ah) (obj4)));
            bc3.b(((ah) (obj5)));
            bc3.d(((ah) (obj6)));
            List list5 = PanelDataCenter.a().c(s6);
            boolean flag2;
            if (list5.size() == 1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            BeautifierEditCenter.a().c();
            if (list5 != null && list5.size() >= 1)
            {
                int j6 = 0;
                while (j6 < list5.size()) 
                {
                    obj1 = new bc();
                    obj4 = new ah();
                    ((ah) (obj4)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).c().x);
                    ((ah) (obj4)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).c().y);
                    obj5 = new ah();
                    ((ah) (obj5)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).e().x);
                    ((ah) (obj5)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).e().y);
                    obj6 = new ah();
                    ((ah) (obj6)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).d().x);
                    ((ah) (obj6)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).d().y);
                    ah ah18 = new ah();
                    ah18.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).f().x);
                    ah18.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).f().y);
                    ((bc) (obj1)).a(((ah) (obj4)));
                    ((bc) (obj1)).c(((ah) (obj5)));
                    ((bc) (obj1)).b(((ah) (obj6)));
                    ((bc) (obj1)).d(ah18);
                    int i8 = ((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).l();
                    int l8 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).k());
                    obj4 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).a());
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.b)
                    {
                        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooPosition.c)
                        {
                            BeautifierEditCenter.a().g(i8, l8, ((Bitmap) (obj4)), ((bc) (obj1)));
                        } else
                        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooPosition.d)
                        {
                            BeautifierEditCenter.a().h(i8, l8, ((Bitmap) (obj4)), ((bc) (obj1)));
                        }
                        if (flag2)
                        {
                            BeautifierEditCenter.a().i(0, l8, ((Bitmap) (obj4)), ((bc) (obj1)));
                            BeautifierEditCenter.a().j(0, l8, ((Bitmap) (obj4)), ((bc) (obj1)));
                        }
                    } else
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.c)
                    {
                        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooPosition.c)
                        {
                            BeautifierEditCenter.a().i(i8, l8, ((Bitmap) (obj4)), ((bc) (obj1)));
                        } else
                        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooPosition.d)
                        {
                            BeautifierEditCenter.a().j(i8, l8, ((Bitmap) (obj4)), ((bc) (obj1)));
                        }
                        if (flag2)
                        {
                            BeautifierEditCenter.a().g(0, l8, ((Bitmap) (obj4)), ((bc) (obj1)));
                            BeautifierEditCenter.a().h(0, l8, ((Bitmap) (obj4)), ((bc) (obj1)));
                        }
                    } else
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooPosition.c)
                    {
                        BeautifierEditCenter.a().k(i8, l8, ((Bitmap) (obj4)), ((bc) (obj1)));
                    } else
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list5.get(j6)).b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooPosition.d)
                    {
                        BeautifierEditCenter.a().l(i8, l8, ((Bitmap) (obj4)), ((bc) (obj1)));
                    }
                    j6++;
                }
            }
            if (flag)
            {
                a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.k);
            }
            ArrayList arraylist4;
            int i3;
            if (q == null)
            {
label1:
                {
                    if (F == null)
                    {
                        F = new ConcurrentHashMap();
                    }
                    if (F.get(s6) == null)
                    {
                        break label1;
                    }
                    q = b((ae)F.get(s6));
                    BeautifierEditCenter.a().b(((at)m.get(0)).d(), r4, q, bc3, s6, true, list5.size(), beautifiertaskinfo);
                }
            } else
            {
                BeautifierEditCenter.a().b(((at)m.get(0)).d(), r4, q, bc3, s6, true, list5.size(), beautifiertaskinfo);
            }
        } else
        if (obj6 == BeautyMode.o)
        {
            BeautifierEditCenter.a().a(((at)m.get(0)).d(), true, beautifiertaskinfo);
        } else
        if (obj6 == BeautyMode.p)
        {
            BeautifierEditCenter.a().b(((at)m.get(0)).d(), true, beautifiertaskinfo);
        } else
        if (obj6 == BeautyMode.q)
        {
            BeautifierEditCenter.a().a(n, true, beautifiertaskinfo);
        } else
        if (obj6 == BeautyMode.v)
        {
            if (s == null)
            {
                return false;
            }
            if (m.size() == 0)
            {
                return false;
            }
            obj1 = StatusManager.j().e();
            obj1 = PanelDataCenter.a().p(((String) (obj1)));
            if (obj1 == null)
            {
                return false;
            }
            if (((ax) (obj1)).h() != null)
            {
                if (((ax) (obj1)).h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.a)
                {
                    obj1 = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.LipstickType.b;
                } else
                if (((ax) (obj1)).h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.b)
                {
                    obj1 = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.LipstickType.a;
                } else
                if (((ax) (obj1)).h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.c)
                {
                    obj1 = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.LipstickType.c;
                } else
                if (((ax) (obj1)).h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.d)
                {
                    obj1 = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.LipstickType.d;
                } else
                {
                    return false;
                }
                if (m.size() > 1)
                {
                    obj4 = StatusManager.j().g();
                    obj4 = PanelDataCenter.a().r(((String) (obj4)));
                    int j3 = ((ar) (obj4)).b();
                    int k6 = ((ar) (obj4)).c();
                    int j8 = Color.rgb(((at)m.get(0)).c().intValue(), ((at)m.get(0)).b().intValue(), ((at)m.get(0)).a().intValue());
                    int i9 = Color.rgb(((at)m.get(1)).c().intValue(), ((at)m.get(1)).b().intValue(), ((at)m.get(1)).a().intValue());
                    BeautifierEditCenter.a().a(((at)m.get(0)).d(), j3, k6, s.booleanValue(), ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.LipstickType) (obj1)), j8, i9, ((at)m.get(0)).f(), ((at)m.get(1)).f(), ((at)m.get(0)).g(), ((at)m.get(1)).g(), true, beautifiertaskinfo);
                } else
                {
                    int k3 = Color.rgb(((at)m.get(0)).c().intValue(), ((at)m.get(0)).b().intValue(), ((at)m.get(0)).a().intValue());
                    BeautifierEditCenter.a().a(((at)m.get(0)).d(), s.booleanValue(), ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.LipstickType) (obj1)), k3, ((at)m.get(0)).f(), ((at)m.get(0)).g(), true, beautifiertaskinfo);
                }
                if (flag)
                {
                    a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.t);
                }
            } else
            {
                return false;
            }
        } else
        if (obj6 == BeautyMode.w)
        {
            BeautifierEditCenter.a().a(((at)m.get(0)).d(), f().booleanValue(), true, beautifiertaskinfo);
        } else
        if (obj6 == BeautyMode.h)
        {
            BeautifierEditCenter.a().c(((at)m.get(0)).d(), true, beautifiertaskinfo);
        } else
        if (obj6 == BeautyMode.f)
        {
            BeautifierEditCenter.a().g(((at)m.get(0)).d(), true, beautifiertaskinfo);
        } else
        if (obj6 == BeautyMode.g)
        {
            BeautifierEditCenter.a().f(((at)m.get(0)).d(), true, beautifiertaskinfo);
        } else
        if (obj6 == BeautyMode.u)
        {
            BeautifierEditCenter.a().h(((at)m.get(0)).d(), true, beautifiertaskinfo);
        } else
        if (obj6 == BeautyMode.d)
        {
            BeautifierEditCenter.a().e(((at)m.get(0)).d(), true, beautifiertaskinfo);
        } else
        if (obj6 == BeautyMode.b)
        {
            if (m.size() == 0)
            {
                return false;
            }
            obj1 = new com.cyberlink.youcammakeup.jniproxy.r();
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj1)).a(((at)m.get(0)).a().intValue());
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj1)).b(((at)m.get(0)).b().intValue());
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj1)).c(((at)m.get(0)).c().intValue());
            if (flag)
            {
                a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.c);
            }
            BeautifierEditCenter.a().a(((at)m.get(0)).d(), ((com.cyberlink.youcammakeup.jniproxy.r) (obj1)), true, beautifiertaskinfo);
        } else
        if (obj6 == BeautyMode.c)
        {
            BeautifierEditCenter.a().d(((at)m.get(0)).d(), true, beautifiertaskinfo);
        } else
        if (obj6 == BeautyMode.a)
        {
            String s7 = StatusManager.j().e();
            List list3 = PanelDataCenter.a().a(s7);
            if (list3 == null || list3.size() < 2)
            {
                return false;
            }
            if (m.size() == 0)
            {
                return false;
            }
            com.cyberlink.youcammakeup.jniproxy.r r5 = new com.cyberlink.youcammakeup.jniproxy.r();
            r5.a(((at)m.get(0)).a().intValue());
            r5.b(((at)m.get(0)).b().intValue());
            r5.c(((at)m.get(0)).c().intValue());
            if (flag)
            {
                a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.d);
            }
            if (r == null)
            {
                if (G == null)
                {
                    G = new HashMap();
                }
                if (G.get(s7) != null)
                {
                    r = c((Pair)G.get(s7));
                    BeautifierEditCenter.a().a(((at)m.get(0)).d(), r5, (String)r.first, (String)r.second, s7, v, true, beautifiertaskinfo);
                    a(false);
                } else
                {
                    obj1 = null;
                    obj4 = null;
                    for (int l3 = 0; l3 < list3.size();)
                    {
                        obj5 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list3.get(l3)).b());
                        obj6 = obj1;
                        Object obj8 = obj4;
                        if (obj5 != null)
                        {
                            if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list3.get(l3)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.a)
                            {
                                obj1 = obj5;
                            }
                            obj6 = obj1;
                            obj8 = obj4;
                            if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list3.get(l3)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.b)
                            {
                                obj8 = obj5;
                                obj6 = obj1;
                            }
                        }
                        l3++;
                        obj1 = obj6;
                        obj4 = obj8;
                    }

                    if (obj1 == null || obj4 == null)
                    {
                        return false;
                    }
                    r = BeautifierEditCenter.a().a(((at)m.get(0)).d(), r5, ((Bitmap) (obj1)), ((Bitmap) (obj4)), s7, v, true, beautifiertaskinfo);
                    G.put(s7, r);
                    a(false);
                }
            } else
            {
                BeautifierEditCenter.a().a(((at)m.get(0)).d(), r5, (String)r.first, (String)r.second, s7, v, true, beautifiertaskinfo);
                a(false);
            }
        } else
        if (obj6 == BeautyMode.e)
        {
            BeautifierEditCenter.a().b(n, true, beautifiertaskinfo);
        } else
        if (obj6 == BeautyMode.s)
        {
            obj4 = StatusManager.j().e();
            obj5 = PanelDataCenter.a().a(((String) (obj4)));
            if (obj5 == null || ((List) (obj5)).size() < 1)
            {
                return false;
            }
            if (m.size() == 0 || m.size() < ((List) (obj5)).size())
            {
                return false;
            }
            obj6 = new s();
            for (int i4 = 0; i4 < ((List) (obj5)).size(); i4++)
            {
                ((s) (obj6)).a(new com.cyberlink.youcammakeup.jniproxy.r(((at)m.get(i4)).a().intValue(), ((at)m.get(i4)).b().intValue(), ((at)m.get(i4)).c().intValue()));
            }

            float f1 = 0.0F;
            if (obj4 != "default_original_eye_contact")
            {
                f1 = com.cyberlink.youcammakeup.utility.ai.a(0.0F, 100F, 1.0F, 1.5F, j);
            }
            if (flag)
            {
                a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.n);
            }
            if (E == null)
            {
                if (H == null)
                {
                    H = new HashMap();
                }
                if (H.get(obj4) != null)
                {
                    E = d((Pair)H.get(obj4));
                    BeautifierEditCenter.a().a(((at)m.get(0)).d(), f1, N(), ((s) (obj6)), (String)E.first, (List)E.second, ((String) (obj4)), true, beautifiertaskinfo);
                } else
                {
                    obj1 = null;
                    ArrayList arraylist = new ArrayList();
                    for (int j4 = 0; j4 < ((List) (obj5)).size(); j4++)
                    {
                        if (j4 == 0)
                        {
                            obj1 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj5)).get(j4)).d());
                        }
                        arraylist.add(i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj5)).get(j4)).b()));
                    }

                    E = BeautifierEditCenter.a().a(((at)m.get(0)).d(), f1, N(), ((s) (obj6)), ((Bitmap) (obj1)), arraylist, ((String) (obj4)), true, beautifiertaskinfo);
                    if (E != null)
                    {
                        H.put(obj4, E);
                    }
                }
            } else
            {
                BeautifierEditCenter.a().a(((at)m.get(0)).d(), f1, N(), ((s) (obj6)), (String)E.first, (List)E.second, ((String) (obj4)), true, beautifiertaskinfo);
            }
        } else
        if (obj6 == BeautyMode.x)
        {
            obj6 = StatusManager.j().e();
            if (obj6 == null)
            {
                return false;
            }
            boolean flag11 = ao();
            if (((String) (obj6)).equalsIgnoreCase("default_original_wig"))
            {
                flag11 = false;
            }
            List list = PanelDataCenter.a().a(((String) (obj6)));
            if (list == null || list.size() < 1)
            {
                return false;
            }
            if (m.size() == 0)
            {
                return false;
            }
            obj1 = ((at)m.get(0)).l();
            if (obj1 == null || obj1.length != 8)
            {
                return false;
            }
            bm bm1 = new bm();
            bm1.b(obj1[0]);
            bm1.c(obj1[1]);
            bm1.d(obj1[2]);
            bm1.a(obj1[3]);
            bm1.e(obj1[4]);
            bm1.f(obj1[5]);
            bm1.g(obj1[6]);
            bm1.h(obj1[7]);
            boolean flag16 = ap();
            beautifiertaskinfo.b(an());
            int l6;
            boolean flag5;
            boolean flag21;
            boolean flag26;
            if (!((String) (obj6)).equals(af.a()))
            {
                if (af.b() != null && !VenusHelper.a().a(af.b()))
                {
                    com.pf.common.utility.m.e("MotionControlHelper", "dumpWigOffsetData: failure");
                    l6 = Math.min(aP.size(), 2);
                    obj1 = new ArrayList();
                    obj4 = aP.keySet().iterator();
                    int k4 = 0;
                    do
                    {
                        if (!((Iterator) (obj4)).hasNext())
                        {
                            break;
                        }
                        ((List) (obj1)).add((String)((Iterator) (obj4)).next());
                        k4++;
                    } while (k4 != l6);
                    for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); com.pf.common.utility.m.b("MotionControlHelper", (new StringBuilder()).append("dumpWigOffsetData: patternID: ").append(((String) (obj4))).append(", delete file: ").append(((String) (obj5))).toString()))
                    {
                        obj4 = (String)((Iterator) (obj1)).next();
                        obj5 = ((com.cyberlink.youcammakeup.widgetpool.common.ah)aP.get(obj4)).b();
                        (new File(((String) (obj5)))).delete();
                        aP.remove(obj4);
                    }

                    flag5 = VenusHelper.a().a(af.b());
                    obj4 = (new StringBuilder()).append("retry dumpWigOffsetData: ");
                    if (flag5)
                    {
                        obj1 = "success";
                    } else
                    {
                        obj1 = "failure";
                    }
                    com.pf.common.utility.m.b("MotionControlHelper", ((StringBuilder) (obj4)).append(((String) (obj1))).toString());
                }
                if (af.c() != null)
                {
                    obj1 = new bi(af.c());
                } else
                {
                    obj1 = null;
                }
                if (aP.containsKey(obj6))
                {
                    obj4 = (com.cyberlink.youcammakeup.widgetpool.common.ah)aP.get(obj6);
                } else
                {
                    obj4 = new com.cyberlink.youcammakeup.widgetpool.common.ah(this);
                }
                af = ((com.cyberlink.youcammakeup.widgetpool.common.ah) (obj4));
                obj4 = af.b();
                if (obj4 != null && (new File(((String) (obj4)))).exists())
                {
                    VenusHelper.a().b(((String) (obj4)));
                } else
                {
                    VenusHelper.a().h();
                    obj4 = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
                }
                af.a(((String) (obj6)));
                af.b(((String) (obj4)));
                obj4 = af;
                if (af.c() != null)
                {
                    obj1 = af.c();
                }
                ((com.cyberlink.youcammakeup.widgetpool.common.ah) (obj4)).a(((bi) (obj1)));
                aP.remove(obj6);
                aP.put(obj6, af);
            }
            flag21 = Y();
            flag26 = o(((String) (obj6)));
            if (flag21)
            {
                if (com.cyberlink.youcammakeup.widgetpool.common.ah.a(af) == null)
                {
                    obj1 = new bi();
                    flag5 = false;
                } else
                {
                    obj1 = new bi(com.cyberlink.youcammakeup.widgetpool.common.ah.a(af));
                    flag5 = true;
                }
            } else
            {
                obj1 = com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().f();
                flag5 = true;
            }
            l6 = ((at)m.get(0)).d();
            if (flag)
            {
                a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.v);
            }
            if (q == null)
            {
                if (F == null)
                {
                    F = new ConcurrentHashMap();
                }
                if (F.get(obj6) != null)
                {
                    q = b((ae)F.get(obj6));
                    BeautifierEditCenter.a().a(flag11, flag21, flag26, flag16, flag5, ((bi) (obj1)), bm1, q, l6, true, beautifiertaskinfo);
                } else
                {
                    ArrayList arraylist1 = new ArrayList();
                    obj4 = null;
                    for (int l4 = 0; l4 < list.size(); l4++)
                    {
                        obj5 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list.get(l4)).b());
                        if (obj5 != null)
                        {
                            obj4 = obj5;
                        }
                    }

                    if (obj4 == null)
                    {
                        return false;
                    }
                    arraylist1.add(obj4);
                    q = BeautifierEditCenter.a().a(flag11, flag21, flag26, flag16, flag5, ((bi) (obj1)), bm1, arraylist1, l6, true, beautifiertaskinfo);
                    F.put(obj6, q);
                }
            } else
            {
                BeautifierEditCenter.a().a(flag11, flag21, flag26, flag16, flag5, ((bi) (obj1)), bm1, q, l6, true, beautifiertaskinfo);
            }
            if (!flag11)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            c(flag);
        } else
        if (obj6 == BeautyMode.z)
        {
            String s8 = StatusManager.j().e();
            if (s8 == null)
            {
                return false;
            }
            boolean flag12 = aq();
            if (s8.equalsIgnoreCase("default_original_eye_wear"))
            {
                flag12 = false;
            }
            obj5 = y(s8);
            if (obj5 == null)
            {
                obj1 = PanelDataCenter.a().a(s8);
                if (obj1 == null || ((List) (obj1)).size() < 1)
                {
                    return false;
                }
                obj5 = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj1)).get(0);
            }
            ah ah3 = new ah();
            ah3.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).u().x);
            ah3.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).u().y);
            ah ah7 = new ah();
            ah7.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).v().x);
            ah7.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).v().y);
            int i5 = ((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).A();
            beautifiertaskinfo.b(an());
            boolean flag6;
            boolean flag17;
            boolean flag22;
            if (!s8.equals(al.a()))
            {
                if (ag())
                {
                    flag6 = a(((BeautyMode) (obj6)), s8, al.a());
                    if (al.b() != null)
                    {
                        obj1 = new bi(al.b());
                    } else
                    {
                        obj1 = null;
                    }
                    if (aQ.containsKey(s8))
                    {
                        obj4 = (ab)aQ.get(s8);
                    } else
                    {
                        obj4 = new ab(this);
                    }
                    al = ((ab) (obj4));
                    if (aQ.containsKey(s8) && al.b() != null)
                    {
                        obj4 = al.b();
                    } else
                    {
                        obj4 = null;
                    }
                    if (!flag6)
                    {
                        obj1 = obj4;
                    }
                } else
                {
                    if (aQ.containsKey(s8))
                    {
                        obj1 = (ab)aQ.get(s8);
                    } else
                    {
                        obj1 = new ab(this);
                    }
                    al = ((ab) (obj1));
                    if (aQ.containsKey(s8) && al.b() != null)
                    {
                        obj1 = al.b();
                    } else
                    {
                        obj1 = null;
                    }
                }
                al.a(s8);
                al.a(((bi) (obj1)));
                aQ.remove(s8);
                aQ.put(s8, al);
            }
            flag17 = Z();
            flag22 = q(s8);
            if (flag17)
            {
                if (com.cyberlink.youcammakeup.widgetpool.common.ab.a(al) == null)
                {
                    obj1 = new bi();
                    flag6 = true;
                } else
                {
                    obj1 = new bi(com.cyberlink.youcammakeup.widgetpool.common.ab.a(al));
                    flag6 = false;
                }
            } else
            {
                obj1 = AccessoryDrawingCtrl.b(((BeautyMode) (obj6))).f();
                flag6 = false;
            }
            if (flag)
            {
                a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.w);
            }
            if (q == null)
            {
                obj4 = a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)));
                if (F == null)
                {
                    F = new ConcurrentHashMap();
                }
                if (F.get(obj4) != null)
                {
                    q = b((ae)F.get(obj4));
                    BeautifierEditCenter.a().a(flag12, flag17, flag22, flag6, q.a(0), ah3, ah7, i5, ((bi) (obj1)), true, beautifiertaskinfo);
                } else
                {
                    obj5 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).b());
                    if (obj5 == null)
                    {
                        return false;
                    }
                    q = new ae();
                    q.a(BeautifierEditCenter.a().a(flag12, flag17, flag22, flag6, ((Bitmap) (obj5)), ah3, ah7, i5, ((bi) (obj1)), true, beautifiertaskinfo));
                    F.put(obj4, q);
                }
            } else
            {
                BeautifierEditCenter.a().a(flag12, flag17, flag22, flag6, q.a(0), ah3, ah7, i5, ((bi) (obj1)), true, beautifiertaskinfo);
            }
            if (!flag12)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            d(flag);
        } else
        if (obj6 == BeautyMode.A)
        {
            String s9 = StatusManager.j().e();
            if (s9 == null)
            {
                return false;
            }
            boolean flag13 = ar();
            if (s9.equalsIgnoreCase("default_original_hair_band"))
            {
                flag13 = false;
            }
            obj5 = y(s9);
            if (obj5 == null)
            {
                obj1 = PanelDataCenter.a().a(s9);
                if (obj1 == null || ((List) (obj1)).size() < 1)
                {
                    return false;
                }
                obj5 = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj1)).get(0);
            }
            ah ah4 = new ah();
            ah4.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).u().x);
            ah4.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).u().y);
            ah ah8 = new ah();
            ah8.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).v().x);
            ah8.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).v().y);
            beautifiertaskinfo.b(an());
            boolean flag7;
            boolean flag18;
            boolean flag23;
            if (!s9.equals(ar.a()))
            {
                if (ag())
                {
                    flag7 = a(((BeautyMode) (obj6)), s9, ar.a());
                    if (ar.b() != null)
                    {
                        obj1 = new bi(ar.b());
                    } else
                    {
                        obj1 = null;
                    }
                    if (aR.containsKey(s9))
                    {
                        obj4 = (com.cyberlink.youcammakeup.widgetpool.common.ad)aR.get(s9);
                    } else
                    {
                        obj4 = new com.cyberlink.youcammakeup.widgetpool.common.ad(this);
                    }
                    ar = ((com.cyberlink.youcammakeup.widgetpool.common.ad) (obj4));
                    if (aR.containsKey(s9) && ar.b() != null)
                    {
                        obj4 = ar.b();
                    } else
                    {
                        obj4 = null;
                    }
                    if (!flag7)
                    {
                        obj1 = obj4;
                    }
                } else
                {
                    if (aR.containsKey(s9))
                    {
                        obj1 = (com.cyberlink.youcammakeup.widgetpool.common.ad)aR.get(s9);
                    } else
                    {
                        obj1 = new com.cyberlink.youcammakeup.widgetpool.common.ad(this);
                    }
                    ar = ((com.cyberlink.youcammakeup.widgetpool.common.ad) (obj1));
                    if (aR.containsKey(s9) && ar.b() != null)
                    {
                        obj1 = ar.b();
                    } else
                    {
                        obj1 = null;
                    }
                }
                ar.a(s9);
                ar.a(((bi) (obj1)));
                aR.remove(s9);
                aR.put(s9, ar);
            }
            flag18 = ac();
            flag23 = r(s9);
            if (flag18)
            {
                if (com.cyberlink.youcammakeup.widgetpool.common.ad.a(ar) == null)
                {
                    obj1 = new bi();
                    flag7 = true;
                } else
                {
                    obj1 = new bi(com.cyberlink.youcammakeup.widgetpool.common.ad.a(ar));
                    flag7 = false;
                }
            } else
            {
                obj1 = AccessoryDrawingCtrl.b(((BeautyMode) (obj6))).f();
                flag7 = false;
            }
            if (flag)
            {
                a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.x);
            }
            if (q == null)
            {
                obj4 = a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)));
                if (F == null)
                {
                    F = new ConcurrentHashMap();
                }
                if (F.get(obj4) != null)
                {
                    q = b((ae)F.get(obj4));
                    BeautifierEditCenter.a().a(flag13, flag18, flag23, flag7, q.a(0), ah4, ah8, ((bi) (obj1)), true, beautifiertaskinfo);
                } else
                {
                    obj5 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).b());
                    if (obj5 == null)
                    {
                        return false;
                    }
                    q = new ae();
                    q.a(BeautifierEditCenter.a().a(flag13, flag18, flag23, flag7, ((Bitmap) (obj5)), ah4, ah8, ((bi) (obj1)), true, beautifiertaskinfo));
                    F.put(obj4, q);
                }
            } else
            {
                BeautifierEditCenter.a().a(flag13, flag18, flag23, flag7, q.a(0), ah4, ah8, ((bi) (obj1)), true, beautifiertaskinfo);
            }
            if (!flag13)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            e(flag);
        } else
        if (obj6 == BeautyMode.B)
        {
            String s10 = StatusManager.j().e();
            if (s10 == null)
            {
                return false;
            }
            boolean flag14 = as();
            if (s10.equalsIgnoreCase("default_original_necklace"))
            {
                flag14 = false;
            }
            obj5 = y(s10);
            if (obj5 == null)
            {
                obj1 = PanelDataCenter.a().a(s10);
                if (obj1 == null || ((List) (obj1)).size() < 1)
                {
                    return false;
                }
                obj5 = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj1)).get(0);
            }
            ah ah5 = new ah();
            ah5.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).u().x);
            ah5.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).u().y);
            ah ah9 = new ah();
            ah9.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).v().x);
            ah9.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).v().y);
            beautifiertaskinfo.b(an());
            boolean flag8;
            boolean flag19;
            boolean flag24;
            if (!s10.equals(ax.a()))
            {
                if (ag())
                {
                    flag8 = a(((BeautyMode) (obj6)), s10, ax.a());
                    if (ax.b() != null)
                    {
                        obj1 = new bi(ax.b());
                    } else
                    {
                        obj1 = null;
                    }
                    if (aS.containsKey(s10))
                    {
                        obj4 = (af)aS.get(s10);
                    } else
                    {
                        obj4 = new af(this);
                    }
                    ax = ((af) (obj4));
                    if (aS.containsKey(s10) && ax.b() != null)
                    {
                        obj4 = ax.b();
                    } else
                    {
                        obj4 = null;
                    }
                    if (!flag8)
                    {
                        obj1 = obj4;
                    }
                } else
                {
                    if (aS.containsKey(s10))
                    {
                        obj1 = (af)aS.get(s10);
                    } else
                    {
                        obj1 = new af(this);
                    }
                    ax = ((af) (obj1));
                    if (aS.containsKey(s10) && ax.b() != null)
                    {
                        obj1 = ax.b();
                    } else
                    {
                        obj1 = null;
                    }
                }
                ax.a(s10);
                ax.a(((bi) (obj1)));
                aS.remove(s10);
                aS.put(s10, ax);
            }
            flag19 = af();
            flag24 = ai();
            if (flag19)
            {
                if (com.cyberlink.youcammakeup.widgetpool.common.af.a(ax) == null)
                {
                    obj1 = new bi();
                    flag8 = true;
                } else
                {
                    obj1 = new bi(com.cyberlink.youcammakeup.widgetpool.common.af.a(ax));
                    flag8 = false;
                }
            } else
            {
                obj1 = AccessoryDrawingCtrl.b(((BeautyMode) (obj6))).f();
                flag8 = false;
            }
            if (flag)
            {
                a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.y);
            }
            if (q == null)
            {
                obj4 = a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)));
                if (F == null)
                {
                    F = new ConcurrentHashMap();
                }
                if (F.get(obj4) != null)
                {
                    q = b((ae)F.get(obj4));
                    BeautifierEditCenter.a().b(flag14, flag19, flag24, flag8, q.a(0), ah5, ah9, ((bi) (obj1)), true, beautifiertaskinfo);
                } else
                {
                    obj5 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj5)).b());
                    if (obj5 == null)
                    {
                        return false;
                    }
                    q = new ae();
                    q.a(BeautifierEditCenter.a().b(flag14, flag19, flag24, flag8, ((Bitmap) (obj5)), ah5, ah9, ((bi) (obj1)), true, beautifiertaskinfo));
                    F.put(obj4, q);
                }
            } else
            {
                BeautifierEditCenter.a().b(flag14, flag19, flag24, flag8, q.a(0), ah5, ah9, ((bi) (obj1)), true, beautifiertaskinfo);
            }
            if (!flag14)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f(flag);
        } else
        if (obj6 == BeautyMode.C)
        {
            String s12 = StatusManager.j().e();
            if (s12 == null)
            {
                return false;
            }
            com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask1 = y(s12);
            if (mask1 == null)
            {
                obj1 = PanelDataCenter.a().a(s12);
                if (obj1 == null || ((List) (obj1)).size() < 1)
                {
                    return false;
                }
                mask1 = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj1)).get(0);
            }
            String s11 = a(mask1);
            boolean flag15 = at();
            if (s12.equalsIgnoreCase("default_original_earrings"))
            {
                flag15 = false;
            }
            ah ah10;
            ah ah12;
            ah ah13;
            ah ah14;
            boolean flag9;
            boolean flag20;
            boolean flag25;
            boolean flag27;
            boolean flag28;
            if (flag15 && u(s11))
            {
                flag20 = true;
            } else
            {
                flag20 = false;
            }
            if (flag15 && v(s11))
            {
                flag25 = true;
            } else
            {
                flag25 = false;
            }
            ah10 = new ah();
            ah10.a(mask1.w().x);
            ah10.b(mask1.w().y);
            ah12 = new ah();
            ah12.a(mask1.x().x);
            ah12.b(mask1.x().y);
            ah13 = new ah();
            ah13.a(mask1.y().x);
            ah13.b(mask1.y().y);
            ah14 = new ah();
            ah14.a(mask1.z().x);
            ah14.b(mask1.z().y);
            beautifiertaskinfo.b(an());
            if (!s12.equals(aE.a()))
            {
                if (ag())
                {
                    flag9 = a(((BeautyMode) (obj6)), s12, aE.a());
                    if (aE.b() != null)
                    {
                        obj1 = new bi(aE.b());
                    } else
                    {
                        obj1 = null;
                    }
                    if (aE.c() != null)
                    {
                        obj4 = new bi(aE.c());
                    } else
                    {
                        obj4 = null;
                    }
                    if (aT.containsKey(s12))
                    {
                        obj5 = (com.cyberlink.youcammakeup.widgetpool.common.z)aT.get(s12);
                    } else
                    {
                        obj5 = new com.cyberlink.youcammakeup.widgetpool.common.z(this);
                    }
                    aE = ((com.cyberlink.youcammakeup.widgetpool.common.z) (obj5));
                    if (aT.containsKey(s12) && aE.b() != null)
                    {
                        obj5 = aE.b();
                    } else
                    {
                        obj5 = null;
                    }
                    if (aT.containsKey(s12) && aE.c() != null)
                    {
                        obj6 = aE.c();
                    } else
                    {
                        obj6 = null;
                    }
                    if (flag9)
                    {
                        obj5 = obj1;
                    }
                    if (flag9)
                    {
                        obj1 = obj5;
                    } else
                    {
                        obj4 = obj6;
                        obj1 = obj5;
                    }
                } else
                {
                    if (aT.containsKey(s12))
                    {
                        obj1 = (com.cyberlink.youcammakeup.widgetpool.common.z)aT.get(s12);
                    } else
                    {
                        obj1 = new com.cyberlink.youcammakeup.widgetpool.common.z(this);
                    }
                    aE = ((com.cyberlink.youcammakeup.widgetpool.common.z) (obj1));
                    if (aT.containsKey(s12) && aE.b() != null)
                    {
                        obj1 = aE.b();
                    } else
                    {
                        obj1 = null;
                    }
                    if (aT.containsKey(s12) && aE.c() != null)
                    {
                        obj4 = aE.c();
                    } else
                    {
                        obj4 = null;
                    }
                }
                aE.a(s12);
                aE.a(((bi) (obj1)));
                aE.b(((bi) (obj4)));
                aT.remove(s12);
                aT.put(s12, aE);
            }
            flag9 = ak();
            flag27 = s(s11);
            flag28 = t(s11);
            if (flag9)
            {
                if (com.cyberlink.youcammakeup.widgetpool.common.z.a(aE) == null || com.cyberlink.youcammakeup.widgetpool.common.z.b(aE) == null)
                {
                    obj1 = new bi();
                    obj4 = new bi();
                    flag9 = true;
                } else
                {
                    obj1 = new bi(com.cyberlink.youcammakeup.widgetpool.common.z.a(aE));
                    obj4 = new bi(com.cyberlink.youcammakeup.widgetpool.common.z.b(aE));
                    flag9 = false;
                }
            } else
            {
                obj1 = AccessoryDrawingCtrl.a(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.d).f();
                obj4 = AccessoryDrawingCtrl.a(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.e).f();
                flag9 = false;
            }
            if (flag)
            {
                a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.z);
            }
            if (q == null)
            {
                if (F == null)
                {
                    F = new ConcurrentHashMap();
                }
                if (F.get(s11) != null)
                {
                    q = b((ae)F.get(s11));
                    if (q != null && q.b() > 1L)
                    {
                        obj5 = q.a(1);
                    } else
                    {
                        obj5 = q.a(0);
                    }
                    if (q != null && q.b() > 1L)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    BeautifierEditCenter.a().a(flag20, flag25, true, flag27, flag28, flag9, q.a(0), ((String) (obj5)), ah10, ah12, ah13, ah14, ((bi) (obj1)), ((bi) (obj4)), flag, true, beautifiertaskinfo);
                } else
                {
                    obj5 = i(mask1.b());
                    if (obj5 == null)
                    {
                        return false;
                    }
                    obj6 = i(mask1.e());
                    boolean flag3;
                    if (obj6 != null)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    q = new ae();
                    beautifiertaskinfo = BeautifierEditCenter.a().a(flag20, flag25, true, flag27, flag28, flag9, ((Bitmap) (obj5)), ((Bitmap) (obj6)), ah10, ah12, ah13, ah14, ((bi) (obj1)), ((bi) (obj4)), true, beautifiertaskinfo);
                    for (int i7 = 0; i7 < beautifiertaskinfo.size(); i7++)
                    {
                        if (i7 == 0 || i7 > 0 && flag3)
                        {
                            q.a((String)beautifiertaskinfo.get(i7));
                        }
                    }

                    F.put(s11, q);
                }
            } else
            {
                if (q != null && q.b() > 1L)
                {
                    obj5 = q.a(1);
                } else
                {
                    obj5 = q.a(0);
                }
                if (q != null && q.b() > 1L)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                BeautifierEditCenter.a().a(flag20, flag25, true, flag27, flag28, flag9, q.a(0), ((String) (obj5)), ah10, ah12, ah13, ah14, ((bi) (obj1)), ((bi) (obj4)), flag, true, beautifiertaskinfo);
            }
            if (!flag15)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i(flag);
        } else
        {
label2:
            {
                if (obj6 != BeautyMode.y)
                {
                    break label2;
                }
                obj1 = StatusManager.j().g();
                if (obj1 == null || m.size() == 0)
                {
                    return false;
                }
                obj4 = StatusManager.j().d();
                if (obj4 != null && ((i) (obj4)).u() != null)
                {
                    BeautifierEditCenter.a().d(ao());
                }
                obj4 = new com.cyberlink.youcammakeup.jniproxy.r();
                ((com.cyberlink.youcammakeup.jniproxy.r) (obj4)).a(((at)m.get(0)).a().intValue());
                ((com.cyberlink.youcammakeup.jniproxy.r) (obj4)).b(((at)m.get(0)).b().intValue());
                ((com.cyberlink.youcammakeup.jniproxy.r) (obj4)).c(((at)m.get(0)).c().intValue());
                if ("default_original_hair_dye".equalsIgnoreCase(((String) (obj1))))
                {
                    BeautifierEditCenter.a().a(0, 0, ((com.cyberlink.youcammakeup.jniproxy.r) (obj4)), true, beautifiertaskinfo);
                } else
                {
                    BeautifierEditCenter.a().a(((at)m.get(0)).d(), (int)j, ((com.cyberlink.youcammakeup.jniproxy.r) (obj4)), true, beautifiertaskinfo);
                }
            }
        }
_L6:
        return true;
        arraylist3 = new ArrayList();
        obj1 = null;
        obj4 = null;
        l2 = 0;
_L2:
        if (l2 >= list1.size())
        {
            break; /* Loop/switch isn't completed */
        }
        obj6 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(l2)).b());
        obj5 = obj1;
        if (obj6 == null)
        {
            break MISSING_BLOCK_LABEL_13670;
        }
        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(l2)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.c || ((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(l2)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.e)
        {
            obj1 = obj6;
        }
        obj5 = obj1;
        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(l2)).f() != com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.d)
        {
            break MISSING_BLOCK_LABEL_13670;
        }
        obj4 = obj1;
        obj1 = obj6;
_L9:
        l2++;
        obj5 = obj4;
        obj4 = obj1;
        obj1 = obj5;
        if (true) goto _L2; else goto _L1
_L1:
        if (obj1 == null && obj4 == null)
        {
            return false;
        }
        if (obj1 != null)
        {
            arraylist3.add(obj1);
        }
        if (obj4 != null)
        {
            arraylist3.add(obj4);
        }
        q = BeautifierEditCenter.a().a(((at)m.get(0)).d(), r3, arraylist3, bc2, s5, true, list4.size(), beautifiertaskinfo);
        F.put(s5, q);
        break MISSING_BLOCK_LABEL_1222;
        arraylist4 = new ArrayList();
        obj1 = null;
        obj4 = null;
        i3 = 0;
_L4:
        if (i3 >= list2.size())
        {
            break; /* Loop/switch isn't completed */
        }
        obj6 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(i3)).b());
        obj5 = obj1;
        if (obj6 == null)
        {
            break MISSING_BLOCK_LABEL_13659;
        }
        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(i3)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.c || ((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(i3)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.e)
        {
            obj1 = obj6;
        }
        obj5 = obj1;
        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(i3)).f() != com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.d)
        {
            break MISSING_BLOCK_LABEL_13659;
        }
        obj4 = obj1;
        obj1 = obj6;
_L8:
        i3++;
        obj5 = obj4;
        obj4 = obj1;
        obj1 = obj5;
        if (true) goto _L4; else goto _L3
_L3:
        if (obj1 == null && obj4 == null)
        {
            return false;
        }
        if (obj1 != null)
        {
            arraylist4.add(obj1);
        }
        if (obj4 != null)
        {
            arraylist4.add(obj4);
        }
        q = BeautifierEditCenter.a().b(((at)m.get(0)).d(), r4, arraylist4, bc3, s6, true, list5.size(), beautifiertaskinfo);
        F.put(s6, q);
        break MISSING_BLOCK_LABEL_1222;
        if (obj6 != BeautyMode.j)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return false;
        }
        if (a(StatusManager.j().f(), true, beautifiertaskinfo)) goto _L6; else goto _L5
_L5:
        return false;
        if (obj6 != BeautyMode.k) goto _L6; else goto _L7
_L7:
        int j5 = ((at)m.get(0)).d();
        if (!a(StatusManager.j().f(), (at)m.get(0), 100 - j5, true, beautifiertaskinfo))
        {
            return false;
        }
          goto _L6
        obj1 = obj4;
        obj4 = obj5;
          goto _L8
        obj1 = obj4;
        obj4 = obj5;
          goto _L9
    }

    private boolean b(o o1, BeautifierTaskInfo beautifiertaskinfo)
    {
        boolean flag = false;
        List list = o1.a();
        if (list.size() > 0)
        {
            o1 = o1.b((String)list.get(0));
            flag = a(list, o1, o1.d(), false, beautifiertaskinfo);
        }
        return flag;
    }

    private Pair c(Pair pair)
    {
        Pair pair1 = null;
        if (pair != null)
        {
            pair1 = Pair.create(pair.first, pair.second);
        }
        return pair1;
    }

    private static Pair c(BeautyMode beautymode)
    {
        float f1;
        float f2;
        f1 = 0.06F;
        f2 = 0.2F;
        com.cyberlink.youcammakeup.widgetpool.common._cls1.a[beautymode.ordinal()];
        JVM INSTR tableswitch 5 8: default 48
    //                   5 64
    //                   6 71
    //                   7 78
    //                   8 85;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        f1 = 0.0F;
        f2 = 0.0F;
_L7:
        return Pair.create(Float.valueOf(f2), Float.valueOf(f1));
_L2:
        f1 = 0.1F;
        continue; /* Loop/switch isn't completed */
_L3:
        f2 = 0.06F;
        continue; /* Loop/switch isn't completed */
_L4:
        f1 = 0.8F;
        continue; /* Loop/switch isn't completed */
_L5:
        f1 = 0.2F;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private Pair d(Pair pair)
    {
        Pair pair1 = null;
        if (pair != null)
        {
            pair1 = Pair.create(pair.first, pair.second);
        }
        return pair1;
    }

    public static MotionControlHelper e()
    {
        return com.cyberlink.youcammakeup.widgetpool.common.ag.a();
    }

    public static Bitmap i(String s1)
    {
        String s2;
        String s3;
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        if (s1 == null)
        {
            return null;
        }
        s2 = obj;
        s3 = obj1;
        if (s1.indexOf("assets://") != 0)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        s2 = obj;
        s3 = obj1;
        BufferedInputStream bufferedinputstream;
        try
        {
            bufferedinputstream = new BufferedInputStream(Globals.d().getAssets().open(s1.substring("assets://".length())));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.pf.common.utility.m.b("MotionControlHelper", "", s1);
            return s2;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.pf.common.utility.m.b("MotionControlHelper", "", s1);
            RestartService.a(Globals.d(), 0x7f07050b);
            return s3;
        }
        s2 = obj;
        s3 = obj1;
        s1 = BitmapFactory.decodeStream(bufferedinputstream, null, d);
        s2 = s1;
        s3 = s1;
        bufferedinputstream.close();
        return s1;
        s2 = obj;
        s3 = obj1;
        s1 = BitmapFactory.decodeFile(s1, d);
        return s1;
    }

    public static String z(String s1)
    {
        com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask1 = e().y(s1);
        com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask = mask1;
        if (mask1 == null)
        {
            List list = PanelDataCenter.a().a(s1);
            mask = mask1;
            if (list != null)
            {
                mask = mask1;
                if (list.size() >= 1)
                {
                    mask = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list.get(0);
                }
            }
        }
        if (mask != null)
        {
            s1 = a(mask);
        }
        return s1;
    }

    public boolean A()
    {
        StatusManager.j().a(Boolean.valueOf(false));
        t();
        a(true);
        boolean flag;
        try
        {
            flag = b(new BeautifierTaskInfo(true), true);
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return false;
        }
        return flag;
    }

    public void B()
    {
        BeautyMode beautymode = StatusManager.j().s();
        if (beautymode == BeautyMode.n)
        {
            BeautifierEditCenter.a().a(UIBeautifierCacheMode.r);
        } else
        {
            if (beautymode == BeautyMode.r)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.q);
                return;
            }
            if (beautymode == BeautyMode.s)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.t);
                return;
            }
            if (beautymode == BeautyMode.l)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.r);
                return;
            }
            if (beautymode == BeautyMode.m)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.r);
                return;
            }
            if (beautymode == BeautyMode.o)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.e);
                return;
            }
            if (beautymode == BeautyMode.u)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.f);
                return;
            }
            if (beautymode == BeautyMode.t)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.w);
                return;
            }
            if (beautymode == BeautyMode.p)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.g);
                return;
            }
            if (beautymode == BeautyMode.q)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.c);
                return;
            }
            if (beautymode == BeautyMode.v)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.s);
                return;
            }
            if (beautymode == BeautyMode.w)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.i);
                return;
            }
            if (beautymode == BeautyMode.h)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.h);
                return;
            }
            if (beautymode == BeautyMode.f)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.p);
                return;
            }
            if (beautymode == BeautyMode.g)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.n);
                return;
            }
            if (beautymode == BeautyMode.d)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.m);
                return;
            }
            if (beautymode == BeautyMode.b)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.j);
                return;
            }
            if (beautymode == BeautyMode.c)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.l);
                return;
            }
            if (beautymode == BeautyMode.a)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.d);
                return;
            }
            if (beautymode == BeautyMode.e)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.k);
                return;
            }
            if (beautymode == BeautyMode.x)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.u);
                return;
            }
            if (beautymode == BeautyMode.y)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.v);
                return;
            }
            if (beautymode == BeautyMode.j)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.x);
                return;
            }
            if (beautymode == BeautyMode.k)
            {
                BeautifierEditCenter.a().a(UIBeautifierCacheMode.y);
                return;
            }
        }
    }

    public r C()
    {
        String s1 = StatusManager.j().g();
        if (s1 == null || s1 != null && !PanelDataCenter.f(s1))
        {
            return new r();
        } else
        {
            return new r(StatusManager.j().e(), s1, null, m, ((at)m.get(0)).d());
        }
    }

    public u D()
    {
        String s1 = StatusManager.j().e();
        String s2 = StatusManager.j().g();
        List list = m;
        float f1;
        if (m != null && m.size() > 0)
        {
            f1 = ((at)m.get(0)).d();
        } else
        {
            f1 = 50F;
        }
        return new u(s1, s2, list, f1, af.b(), com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().f(), o(s1));
    }

    public k E()
    {
        return new k(StatusManager.j().e(), ((at)m.get(0)).d(), (at)m.get(0));
    }

    public n F()
    {
        String s1 = StatusManager.j().e();
        n n1 = new n(s1, AccessoryDrawingCtrl.b(BeautyMode.z).f(), q(s1));
        n1.a(y(s1));
        n1.a(w);
        return n1;
    }

    public p G()
    {
        String s1 = StatusManager.j().e();
        p p1 = new p(s1, AccessoryDrawingCtrl.b(BeautyMode.A).f(), r(s1));
        p1.a(y(s1));
        p1.a(w);
        return p1;
    }

    public t H()
    {
        String s1 = StatusManager.j().e();
        t t1 = new t(s1, AccessoryDrawingCtrl.b(BeautyMode.B).f(), ai());
        t1.a(y(s1));
        t1.a(w);
        return t1;
    }

    public l I()
    {
        String s1 = StatusManager.j().e();
        Object obj = z(s1);
        obj = new l(s1, AccessoryDrawingCtrl.a(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.d).f(), AccessoryDrawingCtrl.a(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.e).f(), s(((String) (obj))), t(((String) (obj))), u(((String) (obj))), v(((String) (obj))));
        ((l) (obj)).a(y(s1));
        ((l) (obj)).a(w);
        return ((l) (obj));
    }

    public r J()
    {
        String s1 = StatusManager.j().e();
        String s2 = StatusManager.j().g();
        if (s2 != null)
        {
            return new r(s1, s2, null, PanelDataCenter.a().i(s2).i(), ((at)m.get(0)).d());
        } else
        {
            return new r(s1, (at)m.get(0), ((at)m.get(0)).d());
        }
    }

    public o K()
    {
        Object obj = StatusManager.j().f();
        o o1 = new o();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); o1.a((String)((Iterator) (obj)).next())) { }
        return o1;
    }

    public o L()
    {
        Object obj = StatusManager.j().f();
        o o1 = new o();
        String s1;
        at at1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); o1.a(s1, at1))
        {
            s1 = (String)((Iterator) (obj)).next();
            at1 = (at)m.get(0);
            at1.a(100 - ((at)m.get(0)).d());
        }

        return o1;
    }

    public v M()
    {
        BeautyMode beautymode = StatusManager.j().s();
        v v1 = new v(beautymode);
        v1.a(StatusManager.j().e());
        v1.a(StatusManager.j().f());
        v1.b(StatusManager.j().g());
        com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d d1 = BeautifierEditCenter.a().d();
        v1.a(d1);
        i i1;
        if (beautymode == BeautyMode.n)
        {
            SwitcherMode switchermode = StatusManager.j().i();
            if (switchermode == null)
            {
                switchermode = com.cyberlink.youcammakeup.widgetpool.common.SwitcherMode.a;
            }
            int j1 = 0;
            while (j1 < m.size()) 
            {
                at at2 = ((at)m.get(j1)).m();
                SwitcherMode aswitchermode[] = SwitcherMode.values();
                int k1;
                if (j1 >= SwitcherMode.values().length)
                {
                    k1 = SwitcherMode.values().length - 1;
                } else
                {
                    k1 = j1;
                }
                v1.a(aswitchermode[k1], at2, Integer.valueOf(at2.d()), Integer.valueOf(at2.j()));
                j1++;
            }
            v1.d(switchermode);
        } else
        if (m != null && m.size() > 0)
        {
            at at1 = ((at)m.get(0)).m();
            v1.a(com.cyberlink.youcammakeup.widgetpool.common.SwitcherMode.a, at1, Integer.valueOf(at1.d()), Integer.valueOf(at1.j()));
        }
        if (beautymode == BeautyMode.r)
        {
            v1.a(Integer.valueOf((int)j));
            d1.b.b(false);
            d1.b.c(false);
        }
        if (beautymode == BeautyMode.s || beautymode == BeautyMode.y)
        {
            v1.a(Integer.valueOf((int)j));
        }
        v1.a(s);
        i1 = StatusManager.j().d();
        if (i1 != null)
        {
            v1.a(i1);
            return v1;
        } else
        {
            v1.a(new i());
            return v1;
        }
    }

    public int N()
    {
        return o;
    }

    public int O()
    {
        return p;
    }

    public float P()
    {
        return com.cyberlink.youcammakeup.utility.ai.a(0.0F, 100F, 1.0F, 1.5F, j) * (float)N();
    }

    public void Q()
    {
        Object obj = StatusManager.j().s();
        if (obj == BeautyMode.s)
        {
            List list = Arrays.asList(new String[] {
                com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a.toString()
            });
            list = PanelDataCenter.a().a(list, ((BeautyMode) (obj)));
            obj = PanelDataCenter.a().b(((BeautyMode) (obj)), com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a);
            if (obj != null && list != null)
            {
                try
                {
                    Z = new HashMap();
                    Z.put(((List) (obj)).get(0), ((aw)list.get(1)).a());
                    Z.put(((List) (obj)).get(1), ((aw)list.get(8)).a());
                    Z.put(((List) (obj)).get(2), ((aw)list.get(2)).a());
                    Z.put(((List) (obj)).get(3), ((aw)list.get(7)).a());
                    Z.put(((List) (obj)).get(4), ((aw)list.get(3)).a());
                    Z.put(((List) (obj)).get(5), ((aw)list.get(1)).a());
                    Z.put(((List) (obj)).get(6), ((aw)list.get(6)).a());
                    Z.put(((List) (obj)).get(7), ((aw)list.get(4)).a());
                    Z.put(((List) (obj)).get(8), ((aw)list.get(6)).a());
                }
                catch (Exception exception1)
                {
                    com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initEyeContactColorInfo exception = ").append(exception1.getMessage()).toString());
                }
                try
                {
                    aa = new HashMap();
                    aa.put(new at(Color.parseColor("#1a1a1a")), new at(Color.parseColor("#303030")));
                    return;
                }
                catch (Exception exception)
                {
                    com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("init EyeContactColorUIEngineMap exception = ").append(exception.getMessage()).toString());
                }
                return;
            }
        }
    }

    public void R()
    {
        Object obj = StatusManager.j().s();
        if (obj == BeautyMode.x) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((obj = PanelDataCenter.a().b(((BeautyMode) (obj)), com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a)) != null)
        {
            try
            {
                ab = new HashMap();
                obj = ((List) (obj)).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    String s1 = (String)((Iterator) (obj)).next();
                    ab.put(s1, PanelDataCenter.a().d(s1, null));
                }
            }
            catch (Exception exception)
            {
                com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initWigPaletteMap exception = ").append(exception.getMessage()).toString());
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void S()
    {
        Object obj = StatusManager.j().s();
        if (obj == BeautyMode.x)
        {
            obj = PanelDataCenter.a().a(((BeautyMode) (obj)));
            ac = new HashMap();
            int i1 = 0;
            while (i1 < ((List) (obj)).size()) 
            {
                ac.put(((List) (obj)).get(i1), new com.cyberlink.youcammakeup.widgetpool.common.ai(this));
                i1++;
            }
        }
    }

    public com.cyberlink.youcammakeup.widgetpool.common.ai T()
    {
        if (ac == null)
        {
            return new com.cyberlink.youcammakeup.widgetpool.common.ai(this);
        }
        String s1 = StatusManager.j().e();
        if (s1 == null || s1.equals("default_original_wig"))
        {
            return new com.cyberlink.youcammakeup.widgetpool.common.ai(this);
        }
        if (ac.get(s1) == null)
        {
            ac.put(s1, new com.cyberlink.youcammakeup.widgetpool.common.ai(this));
        }
        return (com.cyberlink.youcammakeup.widgetpool.common.ai)ac.get(s1);
    }

    public void U()
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj6;
        Object obj7;
        obj7 = null;
        obj2 = null;
        obj6 = null;
        obj1 = null;
        af = new com.cyberlink.youcammakeup.widgetpool.common.ah(this);
        aP = new LinkedHashMap();
        obj = StatusManager.j().d();
        if (obj != null) goto _L2; else goto _L1
_L1:
        u u1;
        return;
_L2:
        if ((u1 = ((i) (obj)).u()) == null || u1.a() == null) goto _L1; else goto _L3
_L3:
        boolean flag;
        af.a(u1.b());
        com.cyberlink.youcammakeup.widgetpool.common.ah.a(af, u1.h());
        af.b(u1.a());
        obj = new File(u1.a());
        flag = ((File) (obj)).exists();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initWigOffsetData() e: ").append(((IOException) (obj)).toString()).toString());
            }
            break MISSING_BLOCK_LABEL_180;
        }
        if (true) goto _L1; else goto _L4
_L4:
        throw new NullPointerException();
        return;
        File file;
        String s1 = UUID.randomUUID().toString();
        file = new File((new StringBuilder()).append(c).append("/").append(s1).toString());
        obj = new FileInputStream(((File) (obj)));
        Object obj3 = obj;
        obj2 = new FileOutputStream(file);
        obj1 = new byte[1024];
_L7:
        int i1 = ((InputStream) (obj)).read(((byte []) (obj1)));
        if (i1 <= 0) goto _L6; else goto _L5
_L5:
        ((OutputStream) (obj2)).write(((byte []) (obj1)), 0, i1);
          goto _L7
        obj3;
        obj1 = obj;
        obj = obj2;
        obj2 = obj3;
_L14:
        com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initWigOffsetData() e: ").append(((FileNotFoundException) (obj2)).toString()).toString());
        if (obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((InputStream) (obj1)).close();
        if (obj == null) goto _L1; else goto _L8
_L8:
        try
        {
            ((OutputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initWigOffsetData() e: ").append(((IOException) (obj)).toString()).toString());
        }
        return;
_L6:
        af.b(file.getAbsolutePath());
        aP.put(u1.b(), af);
        VenusHelper.a().b(af.b());
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((InputStream) (obj)).close();
        if (obj2 == null) goto _L1; else goto _L9
_L9:
        try
        {
            ((OutputStream) (obj2)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initWigOffsetData() e: ").append(((IOException) (obj)).toString()).toString());
        }
        return;
        obj1;
        obj = null;
        obj2 = obj7;
_L13:
        obj6 = obj2;
        obj3 = obj;
        com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initWigOffsetData() e: ").append(((IOException) (obj1)).toString()).toString());
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((InputStream) (obj)).close();
        if (obj2 == null) goto _L1; else goto _L10
_L10:
        try
        {
            ((OutputStream) (obj2)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initWigOffsetData() e: ").append(((IOException) (obj)).toString()).toString());
        }
        return;
        obj1;
        obj = null;
_L12:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_557;
        }
        ((InputStream) (obj)).close();
        if (obj2 != null)
        {
            try
            {
                ((OutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initWigOffsetData() e: ").append(((IOException) (obj)).toString()).toString());
            }
        }
        throw obj1;
        obj1;
        obj2 = obj6;
        obj = obj3;
        continue; /* Loop/switch isn't completed */
        obj1;
        continue; /* Loop/switch isn't completed */
        obj2;
        Object obj4 = obj1;
        obj1 = obj2;
        obj2 = obj;
        obj = obj4;
        if (true) goto _L12; else goto _L11
_L11:
        obj1;
        obj2 = obj7;
          goto _L13
        obj1;
          goto _L13
        obj2;
        obj = null;
          goto _L14
        obj2;
        Object obj5 = null;
        obj1 = obj;
        obj = obj5;
          goto _L14
    }

    public void V()
    {
        if (af != null)
        {
            VenusHelper.a().a(af.b());
        }
    }

    public void W()
    {
        VenusHelper.a().h();
        af = null;
        if (aP != null)
        {
            aP.clear();
            aP = null;
        }
    }

    public void X()
    {
        Object obj;
        int i1;
        i1 = 0;
        obj = StatusManager.j().s();
        if (obj == BeautyMode.x) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((obj = PanelDataCenter.a().a(((BeautyMode) (obj)))) != null)
        {
            ad = new HashMap();
            do
            {
                try
                {
                    if (i1 >= ((List) (obj)).size())
                    {
                        break;
                    }
                    ad.put(((List) (obj)).get(i1), Boolean.valueOf(false));
                }
                catch (Exception exception)
                {
                    com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initWigFlipMap exception = ").append(exception.getMessage()).toString());
                    return;
                }
                i1++;
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean Y()
    {
        return ae;
    }

    public boolean Z()
    {
        return ak;
    }

    public float a(SwitcherMode switchermode)
    {
        if (switchermode.ordinal() >= m.size())
        {
            return (float)((at)m.get(m.size() - 1)).d();
        } else
        {
            return (float)((at)m.get(switchermode.ordinal())).d();
        }
    }

    public Pair a(String s1)
    {
        if (u != null && u.get(s1) != null)
        {
            return (Pair)u.get(s1);
        } else
        {
            return null;
        }
    }

    public av a()
    {
        if (aO != null)
        {
            long l1 = StatusManager.j().l();
            a a1 = StatusManager.j().f(l1);
            if (a1 != null)
            {
                return (av)aO.get(a1.e);
            }
        }
        return null;
    }

    public void a(float f1)
    {
        j = f1;
    }

    public void a(int i1, int j1)
    {
        bc = i1;
        bd = j1;
    }

    public void a(int i1, boolean flag)
    {
        Y = new ArrayList();
        for (int j1 = 0; j1 < i1; j1++)
        {
            Y.add(Boolean.valueOf(flag));
        }

    }

    public void a(long l1, Object obj, UUID uuid)
    {
        u();
    }

    public void a(SeekBar seekbar)
    {
        k = seekbar;
        if (k != null)
        {
            if (StatusManager.j().s() == BeautyMode.x)
            {
                ((at)m.get(0)).a(100 - k.getProgress());
                return;
            } else
            {
                ((at)m.get(0)).a(k.getProgress());
                return;
            }
        } else
        {
            ((at)m.get(0)).a(0);
            return;
        }
    }

    public void a(av av1)
    {
        aO = new ArrayList();
        if (av1 == null) goto _L2; else goto _L1
_L1:
        aO.add(av1);
_L4:
        return;
_L2:
        long l1 = StatusManager.j().l();
        av1 = StatusManager.j().f(l1);
        if (av1 != null && av1.d() != null)
        {
            int i1 = 0;
            while (i1 < av1.d().size()) 
            {
                av av2 = VenusHelper.a().a(((com.cyberlink.youcammakeup.kernelctrl.ar)av1.d().get(i1)).b);
                aO.add(av2);
                i1++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(bi bi1)
    {
        af.a(bi1);
    }

    public void a(BeautifierTaskInfo beautifiertaskinfo)
    {
        BeautifierEditCenter.a().c(s.booleanValue(), false, beautifiertaskinfo);
    }

    public void a(a a1)
    {
        Object obj;
        List list;
        Object obj1;
        e = new HashMap();
        list = PanelDataCenter.a().a(BeautyMode.r);
        obj = StatusManager.j().d();
        if (obj != null && ((i) (obj)).a() != null && ((i) (obj)).a().b() != null)
        {
            obj = ((i) (obj)).a().b();
        } else
        {
            obj = null;
        }
        if (a1 == null) goto _L2; else goto _L1
_L1:
        obj1 = a1.d();
        if (obj1 != null) goto _L3; else goto _L2
_L2:
        int i1;
        return;
_L3:
        if ((i1 = a1.e) != -1)
        {
            z z1 = com.cyberlink.youcammakeup.kernelctrl.j.a(((com.cyberlink.youcammakeup.kernelctrl.ar)((List) (obj1)).get(i1)).c.b());
            obj1 = com.cyberlink.youcammakeup.kernelctrl.j.a(((com.cyberlink.youcammakeup.kernelctrl.ar)((List) (obj1)).get(i1)).c.c());
            z z2 = com.cyberlink.youcammakeup.kernelctrl.j.a(a1.a());
            a1 = com.cyberlink.youcammakeup.kernelctrl.j.a(a1.b());
            if (z2 != null && a1 != null)
            {
                int j1 = 0;
                while (j1 < list.size()) 
                {
                    com.cyberlink.youcammakeup.widgetpool.common.aa aa1 = new com.cyberlink.youcammakeup.widgetpool.common.aa(this);
                    if (list.get(j1) != null)
                    {
                        if (!((String)list.get(j1)).equals("Eyebrow_general"))
                        {
                            if (obj != null && ((String) (obj)).equals(list.get(j1)))
                            {
                                aa1.a(false);
                                aa1.a(z1);
                                aa1.b(((z) (obj1)));
                            } else
                            {
                                aa1.a(z2);
                                aa1.b(a1);
                            }
                        } else
                        {
                            aa1.a(false);
                            aa1.a(z2);
                            aa1.b(a1);
                        }
                    }
                    e.put(list.get(j1), aa1);
                    j1++;
                }
            }
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void a(BeautyMode beautymode)
    {
        switch (com.cyberlink.youcammakeup.widgetpool.common._cls1.a[beautymode.ordinal()])
        {
        default:
            return;

        case 11: // '\013'
            aI.clear();
            aJ.clear();
            aJ.putAll(aK);
            return;

        case 12: // '\f'
            aL.clear();
            break;
        }
        aM.clear();
        aM.putAll(aN);
    }

    public void a(BeautyMode beautymode, boolean flag)
    {
        switch (com.cyberlink.youcammakeup.widgetpool.common._cls1.a[beautymode.ordinal()])
        {
        default:
            return;

        case 11: // '\013'
            if (flag)
            {
                a(aI, aJ, aK);
            }
            aI.clear();
            aJ.clear();
            return;

        case 12: // '\f'
            break;
        }
        if (flag)
        {
            a(aL, aM, aN);
        }
        aL.clear();
        aM.clear();
    }

    public void a(aq aq1)
    {
        (new ac(this, aq1, h)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void a(at at1)
    {
        if (at1 != null)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(at1.m());
            m = arraylist;
            return;
        } else
        {
            com.pf.common.utility.m.d("MotionControlHelper", "Set a null color!");
            return;
        }
    }

    public void a(az az1, float f1)
    {
        u = new HashMap();
        Object obj = StatusManager.j().d();
        if (obj != null && ((i) (obj)).a() != null)
        {
            obj = ((i) (obj)).a();
            if (((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s) (obj)).b() != null && ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s) (obj)).b().equals("Eyebrow_general"))
            {
                u.put("Eyebrow_general", Pair.create(Float.valueOf(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s) (obj)).g()), Float.valueOf(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s) (obj)).a())));
                u.put("Eyebrow_others", Pair.create(Float.valueOf(50F), Float.valueOf(100F)));
                u.put("Eyebrow_general_sku", Pair.create(Float.valueOf(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s) (obj)).g()), Float.valueOf(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s) (obj)).a())));
                obj = u;
                if (az1 == null)
                {
                    f1 = 50F;
                }
                ((HashMap) (obj)).put("Eyebrow_others_sku", Pair.create(Float.valueOf(f1), Float.valueOf(100F)));
                return;
            } else
            {
                u.put("Eyebrow_general", Pair.create(Float.valueOf(10F), Float.valueOf(10F)));
                u.put("Eyebrow_others", Pair.create(Float.valueOf(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s) (obj)).g()), Float.valueOf(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s) (obj)).a())));
                u.put("Eyebrow_general_sku", Pair.create(Float.valueOf(10F), Float.valueOf(10F)));
                u.put("Eyebrow_others_sku", Pair.create(Float.valueOf(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s) (obj)).g()), Float.valueOf(((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s) (obj)).a())));
                return;
            }
        }
        u.put("Eyebrow_general", Pair.create(Float.valueOf(10F), Float.valueOf(10F)));
        u.put("Eyebrow_others", Pair.create(Float.valueOf(50F), Float.valueOf(100F)));
        u.put("Eyebrow_general_sku", Pair.create(Float.valueOf(10F), Float.valueOf(10F)));
        obj = u;
        if (az1 == null)
        {
            f1 = 50F;
        }
        ((HashMap) (obj)).put("Eyebrow_others_sku", Pair.create(Float.valueOf(f1), Float.valueOf(100F)));
    }

    public void a(SwitcherMode switchermode, float f1)
    {
        Object obj = StatusManager.j().e();
        if (obj == null)
        {
            com.pf.common.utility.m.e("MotionControlHelper", "updateShadowMap null patternID");
        } else
        {
            if (Q == null)
            {
                com.pf.common.utility.m.e("MotionControlHelper", "updateShadowMap null mShadowIntensities");
                return;
            }
            obj = (List)Q.get(obj);
            if (obj != null && ((List) (obj)).size() > switchermode.ordinal())
            {
                ((List) (obj)).set(switchermode.ordinal(), Integer.valueOf((int)f1));
                return;
            }
        }
    }

    public void a(SwitcherMode switchermode, boolean flag)
    {
        if (switchermode.ordinal() >= m.size())
        {
            return;
        } else
        {
            ((at)m.get(switchermode.ordinal())).a(flag);
            return;
        }
    }

    public void a(Boolean boolean1, boolean flag)
    {
        if (s != null && s.equals(boolean1))
        {
            return;
        } else
        {
            s = boolean1;
            StatusManager.j().a(com.cyberlink.youcammakeup.widgetpool.common.MotionName.a, flag);
            return;
        }
    }

    public void a(Integer integer)
    {
        t = integer;
    }

    public void a(String s1, float f1, float f2)
    {
        if (u != null && u.get(s1) != null)
        {
            u.put(s1, Pair.create(Float.valueOf(f1), Float.valueOf(f2)));
        }
    }

    public void a(String s1, z z1)
    {
        if (e != null && e.get(s1) != null)
        {
            ((com.cyberlink.youcammakeup.widgetpool.common.aa)e.get(s1)).a(com.cyberlink.youcammakeup.kernelctrl.j.a(z1));
        }
    }

    public void a(String s1, com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask)
    {
        if (aH != null)
        {
            aH.put(s1, mask);
        }
    }

    public void a(String s1, String s2)
    {
        if (ab == null || s2 == null)
        {
            return;
        } else
        {
            ab.put(s1, s2);
            return;
        }
    }

    public void a(String s1, boolean flag)
    {
        if (e != null && e.get(s1) != null)
        {
            ((com.cyberlink.youcammakeup.widgetpool.common.aa)e.get(s1)).a(flag);
        }
    }

    public void a(List list)
    {
        Object obj = StatusManager.j().e();
        if (obj != null) goto _L2; else goto _L1
_L1:
        com.pf.common.utility.m.e("MotionControlHelper", "updateShadowMap null patternID");
_L4:
        return;
_L2:
        if (Q == null)
        {
            com.pf.common.utility.m.e("MotionControlHelper", "updateShadowMap null mShadowIntensities");
            return;
        }
        obj = (List)Q.get(obj);
        if (obj != null && list != null && list.size() == ((List) (obj)).size())
        {
            int i1 = 0;
            while (i1 < list.size()) 
            {
                if (list.get(i1) != null)
                {
                    ((List) (obj)).set(i1, list.get(i1));
                }
                i1++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(boolean flag)
    {
        v = flag;
    }

    public void a(boolean flag, int i1)
    {
        String s1;
        if (StatusManager.j().s() == BeautyMode.x)
        {
            if ((s1 = StatusManager.j().e()) != null && !s1.equals("default_original_wig") && (com.cyberlink.youcammakeup.widgetpool.common.ai)ac.get(s1) != null)
            {
                com.cyberlink.youcammakeup.widgetpool.common.ai ai1 = new com.cyberlink.youcammakeup.widgetpool.common.ai(this);
                ai1.a(flag);
                if (i1 < 0)
                {
                    i1 = 0;
                }
                ai1.a(i1);
                ac.put(s1, ai1);
                return;
            }
        }
    }

    public boolean a(float f1, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        float f2;
        String s1;
        List list;
        s s2;
        boolean flag1;
        flag1 = false;
        f2 = 0.0F;
        s1 = StatusManager.j().e();
        for (list = PanelDataCenter.a().a(s1); list == null || list.size() < 1 || m.size() == 0;)
        {
            return flag;
        }

        s2 = new s();
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            s2.a(new com.cyberlink.youcammakeup.jniproxy.r(((at)m.get(i1)).a().intValue(), ((at)m.get(i1)).b().intValue(), ((at)m.get(i1)).c().intValue()));
        }

        if (s1 != "default_original_eye_contact")
        {
            f2 = com.cyberlink.youcammakeup.utility.ai.a(0.0F, 100F, 1.0F, 1.5F, j);
        }
        if (E != null) goto _L2; else goto _L1
_L1:
        if (H == null)
        {
            H = new HashMap();
        }
        if (H.get(s1) == null) goto _L4; else goto _L3
_L3:
        E = d((Pair)H.get(s1));
        BeautifierEditCenter.a().a((int)f1, f2, N(), s2, (String)E.first, (List)E.second, s1, flag, beautifiertaskinfo);
_L6:
        return true;
_L4:
        Bitmap bitmap = null;
        ArrayList arraylist = new ArrayList();
        for (int j1 = ((flag1) ? 1 : 0); j1 < list.size(); j1++)
        {
            if (j1 == 0)
            {
                bitmap = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list.get(j1)).d());
            }
            arraylist.add(i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list.get(j1)).b()));
        }

        E = BeautifierEditCenter.a().a((int)f1, f2, N(), s2, bitmap, arraylist, s1, flag, beautifiertaskinfo);
        if (E != null)
        {
            H.put(s1, E);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        BeautifierEditCenter.a().a((int)f1, f2, N(), s2, (String)E.first, (List)E.second, s1, flag, beautifiertaskinfo);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean a(int i1)
    {
        boolean flag1 = true;
        String s1 = StatusManager.j().e();
        boolean flag;
        if (s1 != null && s1.equals("Eyebrow_general"))
        {
            flag = false;
        } else
        {
            flag = flag1;
            if (Y != null)
            {
                flag = flag1;
                if (Y.size() > i1)
                {
                    return ((Boolean)Y.get(i1)).booleanValue();
                }
            }
        }
        return flag;
    }

    public boolean a(BeautifierTaskInfo beautifiertaskinfo, boolean flag)
    {
        BeautifierTaskInfo beautifiertaskinfo1;
        beautifiertaskinfo1 = beautifiertaskinfo;
        if (beautifiertaskinfo != null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        beautifiertaskinfo1 = new BeautifierTaskInfo(true);
        flag = b(beautifiertaskinfo1, flag);
        return flag;
        beautifiertaskinfo;
        beautifiertaskinfo.printStackTrace();
        return false;
    }

    public boolean a(i i1, BeautifierTaskInfo beautifiertaskinfo)
    {
        Object obj14;
        i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.a;
        if (i1 == null)
        {
            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.c;
            return false;
        }
        BeautifierEditCenter.a().a(null);
        Object obj3;
        if (i1.b() != null)
        {
            String s1 = i1.b().b();
            obj3 = i1.b().c();
            if (s1 == null || obj3 == null || i1.b().f().size() == 0)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.d;
                return false;
            }
            if (i1.b().f().get(0) == null)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.d;
                return false;
            }
            Object obj19 = new com.cyberlink.youcammakeup.jniproxy.r();
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj19)).a(((at)i1.b().f().get(0)).a().intValue());
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj19)).b(((at)i1.b().f().get(0)).b().intValue());
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj19)).c(((at)i1.b().f().get(0)).c().intValue());
            obj3 = PanelDataCenter.a().a(s1);
            if (obj3 == null || ((List) (obj3)).size() < 1)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.d;
                return false;
            }
            bc bc3 = new bc();
            Object obj10 = new ah();
            ((ah) (obj10)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj3)).get(0)).g().x);
            ((ah) (obj10)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj3)).get(0)).g().y);
            Object obj13 = new ah();
            ((ah) (obj13)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj3)).get(0)).i().x);
            ((ah) (obj13)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj3)).get(0)).i().y);
            Object obj17 = new ah();
            ((ah) (obj17)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj3)).get(0)).h().x);
            ((ah) (obj17)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj3)).get(0)).h().y);
            Object obj22 = new ah();
            ((ah) (obj22)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj3)).get(0)).j().x);
            ((ah) (obj22)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj3)).get(0)).j().y);
            bc3.a(((ah) (obj10)));
            bc3.c(((ah) (obj13)));
            bc3.b(((ah) (obj17)));
            bc3.d(((ah) (obj22)));
            obj10 = new av();
            obj13 = ((List) (obj3)).iterator();
            while (((Iterator) (obj13)).hasNext()) 
            {
                obj17 = ((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((Iterator) (obj13)).next()).k();
                int j1 = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.EyeShadowSide.a.ordinal();
                if (obj17 == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.EyeShadowSide.b)
                {
                    j1 = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.EyeShadowSide.b.ordinal();
                } else
                if (obj17 == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.EyeShadowSide.c)
                {
                    j1 = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.EyeShadowSide.c.ordinal();
                }
                ((av) (obj10)).a(j1);
            }
            obj13 = new av();
            ((av) (obj13)).a(((at)i1.b().f().get(0)).d());
            obj17 = new s();
            ((s) (obj17)).a(((com.cyberlink.youcammakeup.jniproxy.r) (obj19)));
            obj19 = new av();
            Object obj25;
            int k1;
            if (((at)i1.b().f().get(0)).k())
            {
                k1 = ((at)i1.b().f().get(0)).j();
            } else
            {
                k1 = 0;
            }
            ((av) (obj19)).a(k1);
            if (i1.b().f().size() > 1)
            {
                obj22 = (at)i1.b().f().get(1);
                obj25 = new com.cyberlink.youcammakeup.jniproxy.r();
                ((com.cyberlink.youcammakeup.jniproxy.r) (obj25)).a(((at) (obj22)).a().intValue());
                ((com.cyberlink.youcammakeup.jniproxy.r) (obj25)).b(((at) (obj22)).b().intValue());
                ((com.cyberlink.youcammakeup.jniproxy.r) (obj25)).c(((at) (obj22)).c().intValue());
                ((s) (obj17)).a(((com.cyberlink.youcammakeup.jniproxy.r) (obj25)));
                ((av) (obj13)).a(((at) (obj22)).d());
                ah ah20;
                ah ah22;
                ah ah23;
                ah ah24;
                if (((at) (obj22)).k())
                {
                    k1 = ((at) (obj22)).j();
                } else
                {
                    k1 = 0;
                }
                ((av) (obj19)).a(k1);
            }
            if (i1.b().f().size() > 2)
            {
                obj22 = (at)i1.b().f().get(2);
                obj25 = new com.cyberlink.youcammakeup.jniproxy.r();
                ((com.cyberlink.youcammakeup.jniproxy.r) (obj25)).a(((at) (obj22)).a().intValue());
                ((com.cyberlink.youcammakeup.jniproxy.r) (obj25)).b(((at) (obj22)).b().intValue());
                ((com.cyberlink.youcammakeup.jniproxy.r) (obj25)).c(((at) (obj22)).c().intValue());
                ((s) (obj17)).a(((com.cyberlink.youcammakeup.jniproxy.r) (obj25)));
                ((av) (obj13)).a(((at) (obj22)).d());
                if (((at) (obj22)).k())
                {
                    k1 = ((at) (obj22)).j();
                } else
                {
                    k1 = 0;
                }
                ((av) (obj19)).a(k1);
            }
            if (i1.b().f().size() > 3)
            {
                obj22 = (at)i1.b().f().get(3);
                obj25 = new com.cyberlink.youcammakeup.jniproxy.r();
                ((com.cyberlink.youcammakeup.jniproxy.r) (obj25)).a(((at) (obj22)).a().intValue());
                ((com.cyberlink.youcammakeup.jniproxy.r) (obj25)).b(((at) (obj22)).b().intValue());
                ((com.cyberlink.youcammakeup.jniproxy.r) (obj25)).c(((at) (obj22)).c().intValue());
                ((s) (obj17)).a(((com.cyberlink.youcammakeup.jniproxy.r) (obj25)));
                ((av) (obj13)).a(((at) (obj22)).d());
                if (((at) (obj22)).k())
                {
                    k1 = ((at) (obj22)).j();
                } else
                {
                    k1 = 0;
                }
                ((av) (obj19)).a(k1);
            }
            obj22 = i("assets://makeup/eyeshadow/bright.png");
            obj25 = PanelDataCenter.a().c(s1);
            if (((List) (obj25)).size() == 1)
            {
                k1 = 1;
            } else
            {
                k1 = 0;
            }
            if (obj25 != null && ((List) (obj25)).size() >= 1)
            {
                int i5 = 0;
                while (i5 < ((List) (obj25)).size()) 
                {
                    bc bc5 = new bc();
                    ah20 = new ah();
                    ah20.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj25)).get(i5)).c().x);
                    ah20.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj25)).get(i5)).c().y);
                    ah22 = new ah();
                    ah22.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj25)).get(i5)).e().x);
                    ah22.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj25)).get(i5)).e().y);
                    ah23 = new ah();
                    ah23.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj25)).get(i5)).d().x);
                    ah23.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj25)).get(i5)).d().y);
                    ah24 = new ah();
                    ah24.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj25)).get(i5)).f().x);
                    ah24.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj25)).get(i5)).f().y);
                    bc5.a(ah20);
                    bc5.c(ah22);
                    bc5.b(ah23);
                    bc5.d(ah24);
                    int l6 = ((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj25)).get(i5)).l();
                    int i8 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj25)).get(i5)).k());
                    Bitmap bitmap2 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj25)).get(i5)).a());
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj25)).get(i5)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.b)
                    {
                        BeautifierEditCenter.a().a(l6, i8, bitmap2, bc5);
                        if (k1 != 0)
                        {
                            BeautifierEditCenter.a().b(0, i8, bitmap2, bc5);
                        }
                    } else
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj25)).get(i5)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.c)
                    {
                        BeautifierEditCenter.a().b(l6, i8, bitmap2, bc5);
                        if (k1 != 0)
                        {
                            BeautifierEditCenter.a().a(0, i8, bitmap2, bc5);
                        }
                    } else
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj25)).get(i5)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.a)
                    {
                        BeautifierEditCenter.a().c(l6, i8, bitmap2, bc5);
                    }
                    i5++;
                }
            }
            if (I.get(s1) != null)
            {
                R = b((ae)I.get(s1));
                BeautifierEditCenter.a().a(((av) (obj13)), ((av) (obj19)), ((s) (obj17)), ((av) (obj10)), R, bc3, s1, false, ((List) (obj25)).size(), beautifiertaskinfo);
            } else
            {
                ArrayList arraylist2 = new ArrayList();
                for (int l1 = 0; l1 < ((List) (obj3)).size(); l1++)
                {
                    Bitmap bitmap3 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj3)).get(l1)).b());
                    if (bitmap3 != null)
                    {
                        arraylist2.add(bitmap3);
                    }
                }

                obj3 = BeautifierEditCenter.a().a(((av) (obj13)), ((av) (obj19)), ((s) (obj17)), ((av) (obj10)), arraylist2, ((Bitmap) (obj22)), bc3, s1, false, ((List) (obj25)).size(), beautifiertaskinfo);
                if (BeautifierEditCenter.a().e() != com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.BeautifierErrorCode.a)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.b;
                    return false;
                }
                R = ((ae) (obj3));
                I.put(s1, R);
            }
        }
        Object obj8;
        if (i1.c() != null)
        {
            obj3 = i1.c().b();
            if (obj3 == null)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.e;
                return false;
            }
            obj8 = PanelDataCenter.a().a(((String) (obj3)));
            if (obj8 == null || ((List) (obj8)).size() < 1)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.e;
                return false;
            }
            List list = i1.c().f();
            if (list == null || list.size() < ((List) (obj8)).size())
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.e;
                return false;
            }
            s s2 = new s();
            for (int i2 = 0; i2 < ((List) (obj8)).size(); i2++)
            {
                s2.a(new com.cyberlink.youcammakeup.jniproxy.r(((at)list.get(i2)).a().intValue(), ((at)list.get(i2)).b().intValue(), ((at)list.get(i2)).c().intValue()));
            }

            com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.m m1 = i1.c();
            float f1 = 0.0F;
            if (obj3 != "default_original_eye_contact")
            {
                f1 = com.cyberlink.youcammakeup.utility.ai.a(0.0F, 100F, 1.0F, 1.5F, m1.a());
            }
            if (P.get(obj3) != null)
            {
                X = d((Pair)P.get(obj3));
                BeautifierEditCenter.a().a((int)m1.g(), f1, N(), s2, (String)X.first, (List)X.second, ((String) (obj3)), false, beautifiertaskinfo);
            } else
            {
                Object obj = null;
                ArrayList arraylist = new ArrayList();
                for (int j2 = 0; j2 < ((List) (obj8)).size(); j2++)
                {
                    if (j2 == 0)
                    {
                        obj = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj8)).get(j2)).d());
                    }
                    arraylist.add(i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj8)).get(j2)).b()));
                }

                obj = BeautifierEditCenter.a().a((int)m1.g(), f1, N(), s2, ((Bitmap) (obj)), arraylist, ((String) (obj3)), false, beautifiertaskinfo);
                if (BeautifierEditCenter.a().e() != com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.BeautifierErrorCode.a)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.b;
                    return false;
                }
                X = ((Pair) (obj));
                P.put(obj3, X);
            }
        }
        e().h(i1.v());
        if (i1.a() != null)
        {
            obj8 = i1.a().b();
            if (obj8 == null)
            {
                i = ConfigErrorCode.f;
                return false;
            }
            List list1 = PanelDataCenter.a().a(((String) (obj8)));
            if (list1 == null || list1.size() < 1)
            {
                i = ConfigErrorCode.f;
                return false;
            }
            if (i1.a().e() == null)
            {
                i = ConfigErrorCode.f;
                return false;
            }
            obj14 = new com.cyberlink.youcammakeup.jniproxy.r();
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj14)).a(i1.a().e().a().intValue());
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj14)).b(i1.a().e().b().intValue());
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj14)).c(i1.a().e().c().intValue());
            com.cyberlink.youcammakeup.jniproxy.bb bb1 = new com.cyberlink.youcammakeup.jniproxy.bb();
            ah ah1 = new ah();
            ah1.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).l().x);
            ah1.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).l().y);
            obj3 = new ah();
            ((ah) (obj3)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).m().x);
            ((ah) (obj3)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).m().y);
            Object obj20 = new ah();
            ((ah) (obj20)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).n().x);
            ((ah) (obj20)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).n().y);
            bb1.a(ah1);
            bb1.b(((ah) (obj3)));
            bb1.c(((ah) (obj20)));
            obj20 = new com.cyberlink.youcammakeup.jniproxy.bb();
            ah1 = new ah();
            ah1.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).o().x);
            ah1.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).o().y);
            obj3 = new ah();
            ((ah) (obj3)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).p().x);
            ((ah) (obj3)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).p().y);
            Object obj23 = new ah();
            ((ah) (obj23)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).q().x);
            ((ah) (obj23)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).q().y);
            ((com.cyberlink.youcammakeup.jniproxy.bb) (obj20)).a(ah1);
            ((com.cyberlink.youcammakeup.jniproxy.bb) (obj20)).b(((ah) (obj3)));
            ((com.cyberlink.youcammakeup.jniproxy.bb) (obj20)).c(((ah) (obj23)));
            obj23 = new com.cyberlink.youcammakeup.jniproxy.bb();
            ah1 = new ah();
            ah1.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).r().x);
            ah1.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).r().y);
            obj3 = new ah();
            ((ah) (obj3)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).s().x);
            ((ah) (obj3)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).s().y);
            Object obj26 = new ah();
            ((ah) (obj26)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).t().x);
            ((ah) (obj26)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(0)).t().y);
            ((com.cyberlink.youcammakeup.jniproxy.bb) (obj23)).a(ah1);
            ((com.cyberlink.youcammakeup.jniproxy.bb) (obj23)).b(((ah) (obj3)));
            ((com.cyberlink.youcammakeup.jniproxy.bb) (obj23)).c(((ah) (obj26)));
            obj26 = PanelDataCenter.a().c(((String) (obj8)));
            if (obj26 != null && ((List) (obj26)).size() >= 1)
            {
                int k2 = 0;
                while (k2 < ((List) (obj26)).size()) 
                {
                    bc bc1 = new bc();
                    Object obj4 = new ah();
                    ((ah) (obj4)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj26)).get(k2)).g().x);
                    ((ah) (obj4)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj26)).get(k2)).g().y);
                    ah ah17 = new ah();
                    ah17.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj26)).get(k2)).i().x);
                    ah17.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj26)).get(k2)).i().y);
                    ah ah21 = new ah();
                    ah21.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj26)).get(k2)).h().x);
                    ah21.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj26)).get(k2)).h().y);
                    bc1.a(((ah) (obj4)));
                    bc1.c(ah17);
                    bc1.b(ah21);
                    int j5 = ((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj26)).get(k2)).l();
                    int i7 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj26)).get(k2)).k());
                    obj4 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj26)).get(k2)).a());
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj26)).get(k2)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.b)
                    {
                        BeautifierEditCenter.a().m(j5, i7, ((Bitmap) (obj4)), bc1);
                    } else
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj26)).get(k2)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.c)
                    {
                        BeautifierEditCenter.a().n(j5, i7, ((Bitmap) (obj4)), bc1);
                    } else
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)((List) (obj26)).get(k2)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.a)
                    {
                        BeautifierEditCenter.a().o(j5, i7, ((Bitmap) (obj4)), bc1);
                    }
                    k2++;
                }
            }
            boolean flag9 = false;
            boolean flag3 = flag9;
            if (i1.v() != null)
            {
                flag3 = flag9;
                if (f.get(i1.v()) != null)
                {
                    flag3 = ((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get(i1.v())).a();
                }
            }
            String s8 = i1.v();
            if (O.get(obj8) != null)
            {
                W = c((Pair)O.get(obj8));
                BeautifierEditCenter.a().a((int)(i1.a().g() * 0.7F), (int)(i1.a().a() * 0.5F), ((com.cyberlink.youcammakeup.jniproxy.r) (obj14)), (String)W.first, (String)W.second, bb1, ((com.cyberlink.youcammakeup.jniproxy.bb) (obj20)), ((com.cyberlink.youcammakeup.jniproxy.bb) (obj23)), ((String) (obj8)), false, flag3, false, s8, ((List) (obj26)).size(), beautifiertaskinfo);
            } else
            {
                Object obj1 = null;
                Object obj5 = null;
                for (int l2 = 0; l2 < list1.size(); l2++)
                {
                    obj5 = ((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(l2)).b();
                    obj1 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list1.get(l2)).c());
                    obj5 = i(((String) (obj5)));
                }

                obj1 = BeautifierEditCenter.a().a((int)(i1.a().g() * 0.7F), (int)(i1.a().a() * 0.5F), ((com.cyberlink.youcammakeup.jniproxy.r) (obj14)), ((Bitmap) (obj1)), ((Bitmap) (obj5)), bb1, ((com.cyberlink.youcammakeup.jniproxy.bb) (obj20)), ((com.cyberlink.youcammakeup.jniproxy.bb) (obj23)), ((String) (obj8)), false, flag3, false, s8, ((List) (obj26)).size(), beautifiertaskinfo);
                if (BeautifierEditCenter.a().e() != com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.BeautifierErrorCode.a)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.b;
                    return false;
                }
                W = ((Pair) (obj1));
                if (W != null)
                {
                    O.put(obj8, W);
                }
            }
        }
        if (i1.f() == null) goto _L2; else goto _L1
_L1:
        Object obj18;
        Object obj21;
        Object obj24;
        List list3;
        obj14 = i1.f().b();
        if (obj14 == null)
        {
            i = ConfigErrorCode.g;
            return false;
        }
        obj18 = PanelDataCenter.a().a(((String) (obj14)));
        if (obj18 == null || ((List) (obj18)).size() < 1)
        {
            i = ConfigErrorCode.g;
            return false;
        }
        if (i1.f().e() == null)
        {
            i = ConfigErrorCode.g;
            return false;
        }
        obj21 = new com.cyberlink.youcammakeup.jniproxy.r();
        ((com.cyberlink.youcammakeup.jniproxy.r) (obj21)).a(i1.f().e().a().intValue());
        ((com.cyberlink.youcammakeup.jniproxy.r) (obj21)).b(i1.f().e().b().intValue());
        ((com.cyberlink.youcammakeup.jniproxy.r) (obj21)).c(i1.f().e().c().intValue());
        obj24 = new bc();
        ah ah2 = new ah();
        ah2.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).g().x);
        ah2.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).g().y);
        ah ah3 = new ah();
        ah3.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).i().x);
        ah3.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).i().y);
        ah ah4 = new ah();
        ah4.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).h().x);
        ah4.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).h().y);
        ah ah6 = new ah();
        ah6.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).j().x);
        ah6.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).j().y);
        ((bc) (obj24)).a(ah2);
        ((bc) (obj24)).c(ah3);
        ((bc) (obj24)).b(ah4);
        ((bc) (obj24)).d(ah6);
        list3 = PanelDataCenter.a().c(((String) (obj14)));
        boolean flag;
        if (list3.size() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (list3 != null && list3.size() >= 1)
        {
            int k5 = 0;
            while (k5 < list3.size()) 
            {
                bc bc2 = new bc();
                Object obj6 = new ah();
                ((ah) (obj6)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).c().x);
                ((ah) (obj6)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).c().y);
                ah ah5 = new ah();
                ah5.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).e().x);
                ah5.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).e().y);
                ah ah7 = new ah();
                ah7.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).d().x);
                ah7.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).d().y);
                ah ah18 = new ah();
                ah18.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).f().x);
                ah18.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).f().y);
                bc2.a(((ah) (obj6)));
                bc2.c(ah5);
                bc2.b(ah7);
                bc2.d(ah18);
                int j7 = ((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).l();
                int j8 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).k());
                obj6 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).a());
                if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.b)
                {
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooPosition.c)
                    {
                        BeautifierEditCenter.a().g(j7, j8, ((Bitmap) (obj6)), bc2);
                    } else
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooPosition.d)
                    {
                        BeautifierEditCenter.a().h(j7, j8, ((Bitmap) (obj6)), bc2);
                    }
                    if (flag)
                    {
                        BeautifierEditCenter.a().i(0, j8, ((Bitmap) (obj6)), bc2);
                        BeautifierEditCenter.a().j(0, j8, ((Bitmap) (obj6)), bc2);
                    }
                } else
                if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.c)
                {
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooPosition.c)
                    {
                        BeautifierEditCenter.a().i(j7, j8, ((Bitmap) (obj6)), bc2);
                    } else
                    if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooPosition.d)
                    {
                        BeautifierEditCenter.a().j(j7, j8, ((Bitmap) (obj6)), bc2);
                    }
                    if (flag)
                    {
                        BeautifierEditCenter.a().g(0, j8, ((Bitmap) (obj6)), bc2);
                        BeautifierEditCenter.a().h(0, j8, ((Bitmap) (obj6)), bc2);
                    }
                } else
                if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooPosition.c)
                {
                    BeautifierEditCenter.a().k(j7, j8, ((Bitmap) (obj6)), bc2);
                } else
                if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(k5)).b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooPosition.d)
                {
                    BeautifierEditCenter.a().l(j7, j8, ((Bitmap) (obj6)), bc2);
                }
                k5++;
            }
        }
        if (K.get(obj14) == null) goto _L4; else goto _L3
_L3:
        T = b((ae)K.get(obj14));
        BeautifierEditCenter.a().b((int)i1.f().g(), ((com.cyberlink.youcammakeup.jniproxy.r) (obj21)), T, ((bc) (obj24)), ((String) (obj14)), false, list3.size(), beautifiertaskinfo);
_L2:
        if (i1.e() == null) goto _L6; else goto _L5
_L5:
        Object obj2;
        Object obj7;
        Object obj9;
        obj14 = i1.e().b();
        Object obj11;
        ArrayList arraylist3;
        int i3;
        if (obj14 == null)
        {
            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.i;
            return false;
        }
        obj18 = PanelDataCenter.a().a(((String) (obj14)));
        if (obj18 == null || ((List) (obj18)).size() < 1)
        {
            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.i;
            return false;
        }
        if (i1.e().e() == null)
        {
            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.i;
            return false;
        }
        obj21 = new com.cyberlink.youcammakeup.jniproxy.r();
        ((com.cyberlink.youcammakeup.jniproxy.r) (obj21)).a(i1.e().e().a().intValue());
        ((com.cyberlink.youcammakeup.jniproxy.r) (obj21)).b(i1.e().e().b().intValue());
        ((com.cyberlink.youcammakeup.jniproxy.r) (obj21)).c(i1.e().e().c().intValue());
        obj24 = new bc();
        obj2 = new ah();
        ((ah) (obj2)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).g().x);
        ((ah) (obj2)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).g().y);
        obj7 = new ah();
        ((ah) (obj7)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).i().x);
        ((ah) (obj7)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).i().y);
        obj9 = new ah();
        ((ah) (obj9)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).h().x);
        ((ah) (obj9)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).h().y);
        obj11 = new ah();
        ((ah) (obj11)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).j().x);
        ((ah) (obj11)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(0)).j().y);
        ((bc) (obj24)).a(((ah) (obj2)));
        ((bc) (obj24)).c(((ah) (obj7)));
        ((bc) (obj24)).b(((ah) (obj9)));
        ((bc) (obj24)).d(((ah) (obj11)));
        list3 = PanelDataCenter.a().c(((String) (obj14)));
        if (list3 != null && list3.size() >= 1)
        {
            int j3 = 0;
            while (j3 < list3.size()) 
            {
                obj2 = new bc();
                obj7 = new ah();
                ((ah) (obj7)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(j3)).c().x);
                ((ah) (obj7)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(j3)).c().y);
                obj9 = new ah();
                ((ah) (obj9)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(j3)).e().x);
                ((ah) (obj9)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(j3)).e().y);
                ah ah8 = new ah();
                ah8.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(j3)).d().x);
                ah8.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(j3)).d().y);
                ah ah19 = new ah();
                ah19.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(j3)).f().x);
                ah19.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(j3)).f().y);
                ((bc) (obj2)).a(((ah) (obj7)));
                ((bc) (obj2)).c(((ah) (obj9)));
                ((bc) (obj2)).b(ah8);
                ((bc) (obj2)).d(ah19);
                int l5 = ((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(j3)).l();
                int k7 = com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(j3)).k());
                obj7 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(j3)).a());
                if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(j3)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.b)
                {
                    BeautifierEditCenter.a().d(l5, k7, ((Bitmap) (obj7)), ((bc) (obj2)));
                } else
                if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(j3)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.c)
                {
                    BeautifierEditCenter.a().e(l5, k7, ((Bitmap) (obj7)), ((bc) (obj2)));
                } else
                if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask)list3.get(j3)).j() == com.cyberlink.youcammakeup.utility.PanelDataCenter.TattooMask.TattooEyeShadowSide.a)
                {
                    BeautifierEditCenter.a().f(l5, k7, ((Bitmap) (obj7)), ((bc) (obj2)));
                }
                j3++;
            }
        }
          goto _L7
_L4:
        arraylist3 = new ArrayList();
        obj2 = null;
        obj7 = null;
        i3 = 0;
_L9:
        if (i3 >= ((List) (obj18)).size())
        {
            break; /* Loop/switch isn't completed */
        }
        obj11 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(i3)).b());
        obj9 = obj2;
        if (obj11 == null)
        {
            break MISSING_BLOCK_LABEL_11299;
        }
        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(i3)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.c || ((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(i3)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.e)
        {
            obj2 = obj11;
        }
        obj9 = obj2;
        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(i3)).f() != com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.d)
        {
            break MISSING_BLOCK_LABEL_11299;
        }
        obj7 = obj2;
        obj2 = obj11;
_L15:
        i3++;
        obj9 = obj7;
        obj7 = obj2;
        obj2 = obj9;
        if (true) goto _L9; else goto _L8
_L8:
        if (obj2 == null && obj7 == null)
        {
            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.h;
            return false;
        }
        if (obj2 != null)
        {
            arraylist3.add(obj2);
        }
        if (obj7 != null)
        {
            arraylist3.add(obj7);
        }
        obj2 = BeautifierEditCenter.a().b((int)i1.f().g(), ((com.cyberlink.youcammakeup.jniproxy.r) (obj21)), arraylist3, ((bc) (obj24)), ((String) (obj14)), false, list3.size(), beautifiertaskinfo);
        if (BeautifierEditCenter.a().e() != com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.BeautifierErrorCode.a)
        {
            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.b;
            return false;
        }
        T = ((ae) (obj2));
        K.put(obj14, T);
          goto _L2
_L7:
        if (J.get(obj14) == null) goto _L11; else goto _L10
_L10:
        S = b((ae)J.get(obj14));
        BeautifierEditCenter.a().a((int)i1.e().g(), ((com.cyberlink.youcammakeup.jniproxy.r) (obj21)), S, ((bc) (obj24)), ((String) (obj14)), false, list3.size(), beautifiertaskinfo);
          goto _L6
_L11:
        arraylist4 = new ArrayList();
        obj2 = null;
        obj7 = null;
        k3 = 0;
_L13:
        if (k3 >= ((List) (obj18)).size())
        {
            break; /* Loop/switch isn't completed */
        }
        Bitmap bitmap = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(k3)).b());
        obj9 = obj2;
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_11288;
        }
        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(k3)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.c || ((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(k3)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.e)
        {
            obj2 = bitmap;
        }
        obj9 = obj2;
        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj18)).get(k3)).f() != com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.d)
        {
            break MISSING_BLOCK_LABEL_11288;
        }
        obj7 = obj2;
        obj2 = bitmap;
_L14:
        k3++;
        obj9 = obj7;
        obj7 = obj2;
        obj2 = obj9;
        if (true) goto _L13; else goto _L12
_L12:
        if (obj2 == null && obj7 == null)
        {
            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.j;
            return false;
        }
        if (obj2 != null)
        {
            arraylist4.add(obj2);
        }
        if (obj7 != null)
        {
            arraylist4.add(obj7);
        }
        obj2 = BeautifierEditCenter.a().a((int)i1.e().g(), ((com.cyberlink.youcammakeup.jniproxy.r) (obj21)), arraylist4, ((bc) (obj24)), ((String) (obj14)), false, list3.size(), beautifiertaskinfo);
        if (BeautifierEditCenter.a().e() != com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.BeautifierErrorCode.a)
        {
            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.b;
            return false;
        }
        S = ((ae) (obj2));
        J.put(obj14, S);
_L6:
        if (i1.g() != null)
        {
            obj18 = i1.g().b();
            ArrayList arraylist4;
            int k3;
            if (obj18 == null)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.k;
                return false;
            }
            obj21 = PanelDataCenter.a().a(((String) (obj18)));
            if (obj21 == null || ((List) (obj21)).size() < 1)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.k;
                return false;
            }
            if (i1.g().e() == null)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.k;
                return false;
            }
            obj24 = new com.cyberlink.youcammakeup.jniproxy.r();
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj24)).a(i1.g().e().a().intValue());
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj24)).b(i1.g().e().b().intValue());
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj24)).c(i1.g().e().c().intValue());
            if (N.get(obj18) != null)
            {
                V = c((Pair)N.get(obj18));
                BeautifierEditCenter.a().a((int)i1.g().g(), ((com.cyberlink.youcammakeup.jniproxy.r) (obj24)), (String)V.first, (String)V.second, ((String) (obj18)), true, false, beautifiertaskinfo);
            } else
            {
                obj2 = null;
                obj7 = null;
                for (int l3 = 0; l3 < ((List) (obj21)).size();)
                {
                    obj9 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj21)).get(l3)).b());
                    Object obj12 = obj2;
                    Object obj15 = obj7;
                    if (obj9 != null)
                    {
                        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj21)).get(l3)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.a)
                        {
                            obj2 = obj9;
                        }
                        obj12 = obj2;
                        obj15 = obj7;
                        if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj21)).get(l3)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.b)
                        {
                            obj15 = obj9;
                            obj12 = obj2;
                        }
                    }
                    l3++;
                    obj2 = obj12;
                    obj7 = obj15;
                }

                if (obj2 == null || obj7 == null)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.l;
                    return false;
                }
                obj2 = BeautifierEditCenter.a().a((int)i1.g().g(), ((com.cyberlink.youcammakeup.jniproxy.r) (obj24)), ((Bitmap) (obj2)), ((Bitmap) (obj7)), ((String) (obj18)), true, false, beautifiertaskinfo);
                if (BeautifierEditCenter.a().e() != com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.BeautifierErrorCode.a)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.b;
                    return false;
                }
                V = ((Pair) (obj2));
                N.put(obj18, V);
            }
        }
label0:
        {
label1:
            {
label2:
                {
                    if (i1.d() != null)
                    {
                        obj2 = i1.d();
                        obj7 = ((k) (obj2)).a();
                        if (obj7 == null)
                        {
                            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.m;
                            return false;
                        }
                        if (((k) (obj2)).c() == null)
                        {
                            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.m;
                            return false;
                        }
                        if (PanelDataCenter.a().p(((String) (obj7))) == null)
                        {
                            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.m;
                            return false;
                        }
                        obj9 = new com.cyberlink.youcammakeup.jniproxy.r();
                        ((com.cyberlink.youcammakeup.jniproxy.r) (obj9)).a(i1.d().c().a().intValue());
                        ((com.cyberlink.youcammakeup.jniproxy.r) (obj9)).b(i1.d().c().b().intValue());
                        ((com.cyberlink.youcammakeup.jniproxy.r) (obj9)).c(i1.d().c().c().intValue());
                        Object obj16 = PanelDataCenter.a().a(((String) (obj7)));
                        bc bc4 = new bc();
                        obj18 = new ah();
                        ((ah) (obj18)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj16)).get(0)).g().x);
                        ((ah) (obj18)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj16)).get(0)).g().y);
                        obj21 = new ah();
                        ((ah) (obj21)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj16)).get(0)).i().x);
                        ((ah) (obj21)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj16)).get(0)).i().y);
                        obj24 = new ah();
                        ((ah) (obj24)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj16)).get(0)).h().x);
                        ((ah) (obj24)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj16)).get(0)).h().y);
                        ah ah16 = new ah();
                        ah16.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj16)).get(0)).j().x);
                        ah16.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj16)).get(0)).j().y);
                        bc4.a(((ah) (obj18)));
                        bc4.c(((ah) (obj21)));
                        bc4.b(((ah) (obj24)));
                        bc4.d(ah16);
                        obj16 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj16)).get(0)).b());
                        if (obj16 == null)
                        {
                            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.n;
                            return false;
                        }
                        BeautifierEditCenter.a().a((int)((k) (obj2)).b(), ((com.cyberlink.youcammakeup.jniproxy.r) (obj9)), ((Bitmap) (obj16)), bc4, ((String) (obj7)), false, beautifiertaskinfo);
                        if (BeautifierEditCenter.a().e() != com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.BeautifierErrorCode.a)
                        {
                            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.b;
                            return false;
                        }
                    }
                    if (i1.h() != null)
                    {
                        if (s == null)
                        {
                            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.p;
                            return false;
                        }
                        obj2 = i1.h().b();
                        if (obj2 == null)
                        {
                            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.o;
                            return false;
                        }
                        obj2 = PanelDataCenter.a().p(((String) (obj2)));
                        if (obj2 == null)
                        {
                            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.o;
                            return false;
                        }
                        if (i1.h().c() == null)
                        {
                            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.o;
                            return false;
                        }
                        obj9 = i1.h().f();
                        if (((ax) (obj2)).h() == null)
                        {
                            break label2;
                        }
                        if (((ax) (obj2)).h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.a)
                        {
                            obj2 = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.LipstickType.b;
                        } else
                        if (((ax) (obj2)).h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.b)
                        {
                            obj2 = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.LipstickType.a;
                        } else
                        if (((ax) (obj2)).h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.c)
                        {
                            obj2 = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.LipstickType.c;
                        } else
                        if (((ax) (obj2)).h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.d)
                        {
                            obj2 = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.LipstickType.d;
                        } else
                        {
                            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.o;
                            return false;
                        }
                        if (((List) (obj9)).size() == 1)
                        {
                            int i4 = Color.rgb(((at)((List) (obj9)).get(0)).c().intValue(), ((at)((List) (obj9)).get(0)).b().intValue(), ((at)((List) (obj9)).get(0)).a().intValue());
                            BeautifierEditCenter.a().a((int)i1.h().g(), s.booleanValue(), ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.LipstickType) (obj2)), i4, ((at)((List) (obj9)).get(0)).f(), ((at)((List) (obj9)).get(0)).g(), false, beautifiertaskinfo);
                        } else
                        if (((List) (obj9)).size() == 2)
                        {
                            int j4 = (int)i1.h().g();
                            obj7 = PanelDataCenter.a().q(i1.h().d());
                            if (obj7 == null || ((ar) (obj7)).a() == null)
                            {
                                obj7 = PanelDataCenter.a().r(i1.h().c());
                            }
                            int i6 = Color.rgb(((at)((List) (obj9)).get(0)).c().intValue(), ((at)((List) (obj9)).get(0)).b().intValue(), ((at)((List) (obj9)).get(0)).a().intValue());
                            int l7 = Color.rgb(((at)((List) (obj9)).get(1)).c().intValue(), ((at)((List) (obj9)).get(1)).b().intValue(), ((at)((List) (obj9)).get(1)).a().intValue());
                            BeautifierEditCenter.a().a(j4, ((ar) (obj7)).b(), ((ar) (obj7)).c(), s.booleanValue(), ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.LipstickType) (obj2)), i6, l7, ((at)((List) (obj9)).get(0)).f(), ((at)((List) (obj9)).get(1)).f(), ((at)((List) (obj9)).get(0)).g(), ((at)((List) (obj9)).get(1)).g(), false, beautifiertaskinfo);
                        }
                    }
                    if (i1.i() == null)
                    {
                        break label0;
                    }
                    if (i1.i().e() == null)
                    {
                        i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.q;
                        return false;
                    }
                    break label1;
                }
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.o;
                return false;
            }
            obj2 = new com.cyberlink.youcammakeup.jniproxy.r();
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj2)).a(i1.i().e().a().intValue());
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj2)).b(i1.i().e().b().intValue());
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj2)).c(i1.i().e().c().intValue());
            BeautifierEditCenter.a().a((int)i1.i().g(), ((com.cyberlink.youcammakeup.jniproxy.r) (obj2)), false, beautifiertaskinfo);
        }
        if (i1.j() > 0.0F)
        {
            BeautifierEditCenter.a().a((int)i1.j(), false, beautifiertaskinfo);
        }
        if (i1.k() > 0.0F)
        {
            BeautifierEditCenter.a().b((int)i1.k(), false, beautifiertaskinfo);
        }
        if (i1.l() > 0.0F)
        {
            BeautifierEditCenter.a().d((int)i1.l(), false, beautifiertaskinfo);
        }
        if (i1.m() > 0.0F)
        {
            BeautifierEditCenter.a().e((int)i1.m(), false, beautifiertaskinfo);
        }
        if (i1.n() > 0.0F)
        {
            BeautifierEditCenter.a().f((int)i1.n(), false, beautifiertaskinfo);
        }
        if (i1.p() > 0.0F)
        {
            BeautifierEditCenter.a().c((int)i1.p(), false, beautifiertaskinfo);
        }
        if (i1.o() > 0.0F)
        {
            BeautifierEditCenter.a().g((int)i1.o(), false, beautifiertaskinfo);
        }
        if (i1.q() > 0.0F)
        {
            BeautifierEditCenter.a().a((int)i1.q(), f().booleanValue(), false, beautifiertaskinfo);
        }
        if (i1.r() > 0.0F)
        {
            BeautifierEditCenter.a().h((int)i1.r(), false, beautifiertaskinfo);
        }
        if (i1.s() != null)
        {
            BeautifierEditCenter.a().a(i1.s().booleanValue(), false, beautifiertaskinfo);
        }
        if (i1.t() != null)
        {
            BeautifierEditCenter.a().b(i1.t().booleanValue(), false, beautifiertaskinfo);
        }
        if (i1.u() != null)
        {
            String s3 = i1.u().b();
            if (s3 == null)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.r;
                return false;
            }
            List list2 = PanelDataCenter.a().a(s3);
            if (list2 == null || list2.size() < 1)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.r;
                return false;
            }
            if (i1.u().e() == null)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.r;
                return false;
            }
            boolean flag4 = true;
            if (s3.equalsIgnoreCase("default_original_wig"))
            {
                flag4 = false;
            }
            obj2 = i1.u().e().l();
            if (obj2 == null || obj2.length != 8)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.r;
                return false;
            }
            bm bm1 = new bm();
            bm1.b(obj2[0]);
            bm1.c(obj2[1]);
            bm1.d(obj2[2]);
            bm1.a(obj2[3]);
            bm1.e(obj2[4]);
            bm1.f(obj2[5]);
            bm1.g(obj2[6]);
            bm1.h(obj2[7]);
            boolean flag15 = i1.u().j();
            int j6 = (int)i1.u().g();
            i1.u().h();
            boolean flag20 = ap();
            boolean flag10 = true;
            af = new com.cyberlink.youcammakeup.widgetpool.common.ah(this, s3, i1.u().a(), i1.u().h());
            VenusHelper.a().b(af.b());
            if (com.cyberlink.youcammakeup.widgetpool.common.ah.a(af) == null)
            {
                obj7 = new bi();
                flag10 = false;
            } else
            {
                obj7 = new bi(com.cyberlink.youcammakeup.widgetpool.common.ah.a(af));
            }
            if (L.get(s3) != null)
            {
                U = b((ae)L.get(s3));
                BeautifierEditCenter.a().a(flag4, true, flag15, flag20, flag10, ((bi) (obj7)), bm1, U, j6, false, beautifiertaskinfo);
            } else
            {
                ArrayList arraylist1 = new ArrayList();
                obj2 = null;
                for (int k4 = 0; k4 < list2.size(); k4++)
                {
                    obj9 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list2.get(k4)).b());
                    if (obj9 != null)
                    {
                        obj2 = obj9;
                    }
                }

                if (obj2 == null)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.s;
                    return false;
                }
                arraylist1.add(obj2);
                obj2 = BeautifierEditCenter.a().a(flag4, true, flag15, flag20, flag10, ((bi) (obj7)), bm1, arraylist1, j6, false, beautifiertaskinfo);
                if (BeautifierEditCenter.a().e() != com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.BeautifierErrorCode.a)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.b;
                    return false;
                }
                U = ((ae) (obj2));
                L.put(s3, U);
            }
        }
        if (i1.y() != null)
        {
            obj9 = i1.y().a();
            if (obj9 == null)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.t;
                return false;
            }
            boolean flag5 = true;
            if (((String) (obj9)).equalsIgnoreCase("default_original_eye_wear"))
            {
                flag5 = false;
            }
            obj7 = i1.y().b();
            obj2 = obj7;
            if (obj7 == null)
            {
                obj2 = PanelDataCenter.a().a(((String) (obj9)));
                if (obj2 == null || ((List) (obj2)).size() < 1)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.t;
                    return false;
                }
                obj2 = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj2)).get(0);
            }
            obj9 = new ah();
            ((ah) (obj9)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).u().x);
            ((ah) (obj9)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).u().y);
            ah ah9 = new ah();
            ah9.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).v().x);
            ah9.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).v().y);
            int l4 = ((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).A();
            al = new ab(this, i1.y().a(), i1.y().f());
            boolean flag16 = i1.y().g();
            String s4;
            boolean flag11;
            if (com.cyberlink.youcammakeup.widgetpool.common.ab.a(al) == null)
            {
                obj7 = new bi();
                flag11 = true;
            } else
            {
                obj7 = new bi(com.cyberlink.youcammakeup.widgetpool.common.ab.a(al));
                flag11 = false;
            }
            s4 = a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)));
            if (ai.get(s4) != null)
            {
                ah = b((ae)ai.get(s4));
                BeautifierEditCenter.a().a(flag5, true, flag16, flag11, ah.a(0), ((ah) (obj9)), ah9, l4, ((bi) (obj7)), false, beautifiertaskinfo);
            } else
            {
                obj2 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).b());
                if (obj2 == null)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.u;
                    return false;
                }
                ah = new ae();
                obj2 = BeautifierEditCenter.a().a(flag5, true, flag16, flag11, ((Bitmap) (obj2)), ((ah) (obj9)), ah9, l4, ((bi) (obj7)), false, beautifiertaskinfo);
                if (BeautifierEditCenter.a().e() != com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.BeautifierErrorCode.a)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.b;
                    return false;
                }
                ah.a(((String) (obj2)));
                ai.put(s4, ah);
            }
        }
        if (i1.z() != null)
        {
            obj9 = i1.z().a();
            if (obj9 == null)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.v;
                return false;
            }
            boolean flag6 = true;
            if (((String) (obj9)).equalsIgnoreCase("default_original_hair_band"))
            {
                flag6 = false;
            }
            obj7 = i1.z().b();
            obj2 = obj7;
            if (obj7 == null)
            {
                obj2 = PanelDataCenter.a().a(((String) (obj9)));
                if (obj2 == null || ((List) (obj2)).size() < 1)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.v;
                    return false;
                }
                obj2 = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj2)).get(0);
            }
            obj9 = new ah();
            ((ah) (obj9)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).u().x);
            ((ah) (obj9)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).u().y);
            ah ah10 = new ah();
            ah10.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).v().x);
            ah10.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).v().y);
            ar = new com.cyberlink.youcammakeup.widgetpool.common.ad(this, i1.z().a(), i1.z().f());
            boolean flag17 = i1.z().g();
            String s5;
            boolean flag12;
            if (com.cyberlink.youcammakeup.widgetpool.common.ad.a(ar) == null)
            {
                obj7 = new bi();
                flag12 = true;
            } else
            {
                obj7 = new bi(com.cyberlink.youcammakeup.widgetpool.common.ad.a(ar));
                flag12 = false;
            }
            s5 = a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)));
            if (ao.get(s5) != null)
            {
                an = b((ae)ao.get(s5));
                BeautifierEditCenter.a().a(flag6, true, flag17, flag12, an.a(0), ((ah) (obj9)), ah10, ((bi) (obj7)), false, beautifiertaskinfo);
            } else
            {
                obj2 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).b());
                if (obj2 == null)
                {
                    i = ConfigErrorCode.w;
                    return false;
                }
                an = new ae();
                obj2 = BeautifierEditCenter.a().a(flag6, true, flag17, flag12, ((Bitmap) (obj2)), ((ah) (obj9)), ah10, ((bi) (obj7)), false, beautifiertaskinfo);
                if (BeautifierEditCenter.a().e() != com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.BeautifierErrorCode.a)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.b;
                    return false;
                }
                an.a(((String) (obj2)));
                ao.put(s5, an);
            }
        }
        if (i1.A() != null)
        {
            obj9 = i1.A().a();
            if (obj9 == null)
            {
                i = ConfigErrorCode.x;
                return false;
            }
            boolean flag7 = true;
            if (((String) (obj9)).equalsIgnoreCase("default_original_necklace"))
            {
                flag7 = false;
            }
            obj7 = i1.A().b();
            obj2 = obj7;
            if (obj7 == null)
            {
                obj2 = PanelDataCenter.a().a(((String) (obj9)));
                if (obj2 == null || ((List) (obj2)).size() < 1)
                {
                    i = ConfigErrorCode.x;
                    return false;
                }
                obj2 = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj2)).get(0);
            }
            obj9 = new ah();
            ((ah) (obj9)).a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).u().x);
            ((ah) (obj9)).b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).u().y);
            ah ah11 = new ah();
            ah11.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).v().x);
            ah11.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).v().y);
            boolean flag18 = i1.A().g();
            ax = new af(this, i1.A().a(), i1.A().f());
            String s6;
            boolean flag13;
            if (com.cyberlink.youcammakeup.widgetpool.common.af.a(ax) == null)
            {
                obj7 = new bi();
                flag13 = true;
            } else
            {
                obj7 = new bi(com.cyberlink.youcammakeup.widgetpool.common.af.a(ax));
                flag13 = false;
            }
            s6 = a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)));
            if (au.get(s6) != null)
            {
                at = b((ae)au.get(s6));
                BeautifierEditCenter.a().b(flag7, true, flag18, flag13, at.a(0), ((ah) (obj9)), ah11, ((bi) (obj7)), false, beautifiertaskinfo);
            } else
            {
                obj2 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).b());
                if (obj2 == null)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.y;
                    return false;
                }
                at = new ae();
                obj2 = BeautifierEditCenter.a().b(flag7, true, flag18, flag13, ((Bitmap) (obj2)), ((ah) (obj9)), ah11, ((bi) (obj7)), false, beautifiertaskinfo);
                if (BeautifierEditCenter.a().e() != com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.BeautifierErrorCode.a)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.b;
                    return false;
                }
                at.a(((String) (obj2)));
                au.put(s6, at);
            }
        }
        if (i1.B() != null)
        {
            obj9 = i1.B().a();
            if (obj9 == null)
            {
                i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.z;
                return false;
            }
            boolean flag1 = true;
            if (((String) (obj9)).equalsIgnoreCase("default_original_earrings"))
            {
                flag1 = false;
            }
            boolean flag8;
            boolean flag14;
            if (flag1 && i1.B().j())
            {
                flag8 = true;
            } else
            {
                flag8 = false;
            }
            if (flag1 && i1.B().k())
            {
                flag14 = true;
            } else
            {
                flag14 = false;
            }
            obj7 = i1.B().b();
            obj2 = obj7;
            if (obj7 == null)
            {
                obj2 = PanelDataCenter.a().a(((String) (obj9)));
                if (obj2 == null || ((List) (obj2)).size() < 1)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.z;
                    return false;
                }
                obj2 = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)((List) (obj2)).get(0);
            }
            String s7 = a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)));
            ah ah12 = new ah();
            ah12.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).w().x);
            ah12.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).w().y);
            ah ah13 = new ah();
            ah13.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).x().x);
            ah13.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).x().y);
            ah ah14 = new ah();
            ah14.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).y().x);
            ah14.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).y().y);
            ah ah15 = new ah();
            ah15.a(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).z().x);
            ah15.b(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).z().y);
            boolean flag22 = ak();
            boolean flag23 = s(s7);
            boolean flag24 = t(s7);
            aE = new com.cyberlink.youcammakeup.widgetpool.common.z(this, i1.B().a(), i1.B().f(), i1.B().g());
            boolean flag19;
            if (com.cyberlink.youcammakeup.widgetpool.common.z.a(aE) == null || com.cyberlink.youcammakeup.widgetpool.common.z.b(aE) == null)
            {
                obj7 = new bi();
                obj9 = new bi();
                flag19 = true;
            } else
            {
                obj7 = new bi(com.cyberlink.youcammakeup.widgetpool.common.z.a(aE));
                obj9 = new bi(com.cyberlink.youcammakeup.widgetpool.common.z.b(aE));
                flag19 = false;
            }
            if (aA.get(s7) != null)
            {
                az = b((ae)aA.get(s7));
                boolean flag21;
                if (az != null && az.b() > 1L)
                {
                    obj2 = az.a(1);
                } else
                {
                    obj2 = az.a(0);
                }
                if (az != null && az.b() > 1L)
                {
                    flag21 = true;
                } else
                {
                    flag21 = false;
                }
                BeautifierEditCenter.a().a(flag8, flag14, flag22, flag23, flag24, flag19, az.a(0), ((String) (obj2)), ah12, ah13, ah14, ah15, ((bi) (obj7)), ((bi) (obj9)), flag21, false, beautifiertaskinfo);
            } else
            {
                Bitmap bitmap1 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).b());
                if (bitmap1 == null)
                {
                    i = ConfigErrorCode.A;
                    return false;
                }
                obj2 = i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask) (obj2)).e());
                boolean flag2;
                if (obj2 != null)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                az = new ae();
                obj2 = BeautifierEditCenter.a().a(flag8, flag14, flag22, flag23, flag24, flag19, bitmap1, ((Bitmap) (obj2)), ah12, ah13, ah14, ah15, ((bi) (obj7)), ((bi) (obj9)), false, beautifiertaskinfo);
                if (BeautifierEditCenter.a().e() != com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter.BeautifierErrorCode.a)
                {
                    i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.b;
                    return false;
                }
                for (int k6 = 0; k6 < ((List) (obj2)).size(); k6++)
                {
                    if (k6 == 0 || k6 > 0 && flag2)
                    {
                        az.a((String)((List) (obj2)).get(k6));
                    }
                }

                aA.put(s7, az);
            }
        }
        if (i1.C() != null)
        {
            obj2 = i1.C().e();
            if (obj2 == null)
            {
                i = ConfigErrorCode.B;
                return false;
            }
            obj7 = new com.cyberlink.youcammakeup.jniproxy.r();
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj7)).a(((at) (obj2)).a().intValue());
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj7)).b(((at) (obj2)).b().intValue());
            ((com.cyberlink.youcammakeup.jniproxy.r) (obj7)).c(((at) (obj2)).c().intValue());
            if (m.get(0) instanceof com.cyberlink.youcammakeup.widgetpool.common.a.k)
            {
                BeautifierEditCenter.a().a(0, 0, ((com.cyberlink.youcammakeup.jniproxy.r) (obj7)), false, beautifiertaskinfo);
            } else
            {
                BeautifierEditCenter.a().a((int)i1.C().a(), (int)i1.C().g(), ((com.cyberlink.youcammakeup.jniproxy.r) (obj7)), false, beautifiertaskinfo);
            }
        }
        if (i1.D() != null && !a(i1.D(), beautifiertaskinfo))
        {
            i = ConfigErrorCode.C;
            return false;
        }
        if (i1.E() != null && !b(i1.E(), beautifiertaskinfo))
        {
            i = ConfigErrorCode.D;
            return false;
        } else
        {
            BeautifierEditCenter.a().a(beautifiertaskinfo);
            i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.a;
            return true;
        }
        obj2 = obj7;
        obj7 = obj9;
          goto _L14
        obj2 = obj7;
        obj7 = obj9;
          goto _L15
    }

    public boolean a(r r1)
    {
        Object obj;
        boolean flag1;
        flag1 = false;
        obj = r1.c();
        obj = PanelDataCenter.a().i(((String) (obj)));
        if (r1.f().size() == ((aw) (obj)).b()) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        int i1 = 0;
        do
        {
            flag = flag1;
            if (i1 >= ((aw) (obj)).b())
            {
                continue;
            }
            at at1 = (at)((aw) (obj)).i().get(i1);
            at at2 = (at)r1.f().get(i1);
            if (!at1.equals(at2) || at1.k() != at2.k())
            {
                return true;
            }
            i1++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean a(SwitcherMode switchermode, at at1, boolean flag)
    {
        BeautyMode beautymode = StatusManager.j().s();
        if (beautymode != BeautyMode.x)
        {
            StatusManager.j().a(Boolean.valueOf(false));
        }
        m.set(switchermode.ordinal(), at1.m());
        if (beautymode == BeautyMode.x)
        {
            q(true);
            return true;
        }
        try
        {
            flag = b(new BeautifierTaskInfo(flag), true);
        }
        // Misplaced declaration of an exception variable
        catch (SwitcherMode switchermode)
        {
            switchermode.printStackTrace();
            return false;
        }
        return flag;
    }

    public boolean a(Boolean boolean1)
    {
        if (l == null)
        {
            return false;
        }
        j = l.getProgress();
        boolean flag;
        try
        {
            flag = b(new BeautifierTaskInfo(boolean1.booleanValue()), false);
        }
        // Misplaced declaration of an exception variable
        catch (Boolean boolean1)
        {
            boolean1.printStackTrace();
            return false;
        }
        return flag;
    }

    public boolean a(boolean flag, boolean flag1)
    {
        n = flag;
        try
        {
            flag = b(new BeautifierTaskInfo(flag1), false);
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return false;
        }
        return flag;
    }

    public void aA()
    {
        aB();
        aH = new HashMap();
    }

    public void aB()
    {
        if (aH != null)
        {
            aH.clear();
            aH = null;
        }
    }

    public boolean aC()
    {
        return bf;
    }

    public void aa()
    {
        Object obj;
        int i1;
        i1 = 0;
        obj = StatusManager.j().s();
        if (obj == BeautyMode.z) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((obj = PanelDataCenter.a().a(((BeautyMode) (obj)))) != null)
        {
            aj = new HashMap();
            do
            {
                try
                {
                    if (i1 >= ((List) (obj)).size())
                    {
                        break;
                    }
                    aj.put(((List) (obj)).get(i1), Boolean.valueOf(false));
                }
                catch (Exception exception)
                {
                    com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initEyeWearFlipMap exception = ").append(exception.getMessage()).toString());
                    return;
                }
                i1++;
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void ab()
    {
        al = new ab(this);
        aQ = new LinkedHashMap();
        Object obj = StatusManager.j().d();
        if (obj != null)
        {
            if ((obj = ((i) (obj)).y()) != null)
            {
                al.a(((n) (obj)).a());
                com.cyberlink.youcammakeup.widgetpool.common.ab.a(al, ((n) (obj)).f());
                aQ.put(((n) (obj)).a(), al);
                return;
            }
        }
    }

    public boolean ac()
    {
        return aq;
    }

    public void ad()
    {
        Object obj;
        int i1;
        i1 = 0;
        obj = StatusManager.j().s();
        if (obj == BeautyMode.A) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((obj = PanelDataCenter.a().a(((BeautyMode) (obj)))) != null)
        {
            ap = new HashMap();
            do
            {
                try
                {
                    if (i1 >= ((List) (obj)).size())
                    {
                        break;
                    }
                    ap.put(((List) (obj)).get(i1), Boolean.valueOf(false));
                }
                catch (Exception exception)
                {
                    com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initHairBandFlipMap exception = ").append(exception.getMessage()).toString());
                    return;
                }
                i1++;
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void ae()
    {
        ar = new com.cyberlink.youcammakeup.widgetpool.common.ad(this);
        aR = new LinkedHashMap();
        Object obj = StatusManager.j().d();
        if (obj != null)
        {
            if ((obj = ((i) (obj)).z()) != null)
            {
                ar.a(((p) (obj)).a());
                com.cyberlink.youcammakeup.widgetpool.common.ad.a(ar, ((p) (obj)).f());
                aR.put(((p) (obj)).a(), ar);
                return;
            }
        }
    }

    public boolean af()
    {
        return aw;
    }

    public boolean ag()
    {
        return aU;
    }

    public void ah()
    {
        for (BeautyMode beautymode = StatusManager.j().s(); beautymode != BeautyMode.B || PanelDataCenter.a().a(beautymode) == null;)
        {
            return;
        }

        g = false;
    }

    public boolean ai()
    {
        return g;
    }

    public void aj()
    {
        ax = new af(this);
        aS = new LinkedHashMap();
        Object obj = StatusManager.j().d();
        if (obj != null)
        {
            if ((obj = ((i) (obj)).A()) != null)
            {
                ax.a(((t) (obj)).a());
                com.cyberlink.youcammakeup.widgetpool.common.af.a(ax, ((t) (obj)).f());
                aS.put(((t) (obj)).a(), ax);
                return;
            }
        }
    }

    public boolean ak()
    {
        return aD;
    }

    public void al()
    {
        Object obj = StatusManager.j().s();
        if (obj == BeautyMode.C) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1;
        if ((obj = PanelDataCenter.a().a(((BeautyMode) (obj)))) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        aB = new HashMap();
        i1 = 0;
_L4:
        if (i1 >= ((List) (obj)).size())
        {
            break; /* Loop/switch isn't completed */
        }
        aB.put(((List) (obj)).get(i1), Boolean.valueOf(false));
        i1++;
        if (true) goto _L4; else goto _L3
        Exception exception1;
        exception1;
        com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initEarringsFlipMap exception = ").append(exception1.getMessage()).toString());
_L3:
        aC = new HashMap();
        int j1 = 0;
        do
        {
            try
            {
                if (j1 >= ((List) (obj)).size())
                {
                    break;
                }
                aC.put(((List) (obj)).get(j1), Boolean.valueOf(false));
            }
            catch (Exception exception)
            {
                com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initEarringsFlipMap exception = ").append(exception.getMessage()).toString());
                return;
            }
            j1++;
        } while (true);
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void am()
    {
        aE = new com.cyberlink.youcammakeup.widgetpool.common.z(this);
        aT = new LinkedHashMap();
        Object obj = StatusManager.j().d();
        if (obj != null)
        {
            if ((obj = ((i) (obj)).B()) != null)
            {
                aE.a(((l) (obj)).a());
                com.cyberlink.youcammakeup.widgetpool.common.z.a(aE, ((l) (obj)).f());
                com.cyberlink.youcammakeup.widgetpool.common.z.b(aE, ((l) (obj)).g());
                aT.put(((l) (obj)).a(), aE);
                return;
            }
        }
    }

    public boolean an()
    {
        return aV;
    }

    public boolean ao()
    {
        return aW;
    }

    public boolean ap()
    {
        return aX;
    }

    public boolean aq()
    {
        return aY;
    }

    public boolean ar()
    {
        return aZ;
    }

    public boolean as()
    {
        return ba;
    }

    public boolean at()
    {
        return bb;
    }

    public void au()
    {
        BeautyMode beautymode;
        boolean flag;
        flag = false;
        beautymode = StatusManager.j().s();
        if (beautymode == BeautyMode.C) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ArrayList arraylist;
        int j1;
        arraylist = new ArrayList();
        List list = PanelDataCenter.a().a(beautymode);
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            arraylist.addAll(A((String)list.get(i1)));
        }

        arraylist.addAll(b(beautymode));
        aF = new HashMap();
        j1 = 0;
_L4:
        if (j1 >= arraylist.size())
        {
            break; /* Loop/switch isn't completed */
        }
        aF.put(arraylist.get(j1), Boolean.valueOf(true));
        j1++;
        if (true) goto _L4; else goto _L3
        Exception exception1;
        exception1;
        com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initEarringsFlipMap exception = ").append(exception1.getMessage()).toString());
_L3:
        aG = new HashMap();
        int k1 = ((flag) ? 1 : 0);
        do
        {
            try
            {
                if (k1 >= arraylist.size())
                {
                    break;
                }
                aG.put(arraylist.get(k1), Boolean.valueOf(true));
            }
            catch (Exception exception)
            {
                com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("initEarringsFlipMap exception = ").append(exception.getMessage()).toString());
                return;
            }
            k1++;
        } while (true);
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void av()
    {
        com.cyberlink.youcammakeup.utility.bb.b(new File(h));
        com.cyberlink.youcammakeup.utility.bb.a(h);
    }

    public int aw()
    {
        return bc;
    }

    public int ax()
    {
        return bd;
    }

    public boolean ay()
    {
        return be;
    }

    public ConfigErrorCode az()
    {
        ConfigErrorCode configerrorcode = i;
        i = com.cyberlink.youcammakeup.widgetpool.common.ConfigErrorCode.a;
        return configerrorcode;
    }

    public at b(at at1)
    {
        while (aa == null || at1 == null || !aa.containsKey(at1)) 
        {
            return at1;
        }
        return (at)aa.get(at1);
    }

    public Boolean b(SwitcherMode switchermode)
    {
        if (switchermode.ordinal() >= m.size())
        {
            return Boolean.valueOf(false);
        } else
        {
            return Boolean.valueOf(((at)m.get(switchermode.ordinal())).k());
        }
    }

    public void b()
    {
        Q.clear();
        Q = new HashMap();
        String s1 = StatusManager.j().g();
        if (s1 != null)
        {
            List list = PanelDataCenter.a().a(s1, null);
            int i1 = 0;
            while (i1 < list.size()) 
            {
                String s2 = (String)list.get(i1);
                if (s2 != null)
                {
                    Object obj1 = StatusManager.j().d();
                    Object obj = new ArrayList();
                    if (obj1 != null && ((i) (obj1)).b() != null && s1.equals(((i) (obj1)).b().c()))
                    {
                        for (obj1 = ((i) (obj1)).b().f().iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(Integer.valueOf(((at)((Iterator) (obj1)).next()).d()))) { }
                    } else
                    {
                        obj = PanelDataCenter.a().b(s2, s1);
                    }
                    Q.put(s2, obj);
                }
                i1++;
            }
        }
    }

    public void b(int i1)
    {
        o = i1;
    }

    public void b(int i1, boolean flag)
    {
        if (Y != null && Y.size() > i1)
        {
            Y.set(i1, Boolean.valueOf(flag));
        }
    }

    public void b(SeekBar seekbar)
    {
        l = seekbar;
        if (l != null)
        {
            j = l.getProgress();
            return;
        } else
        {
            j = 0.0F;
            return;
        }
    }

    public void b(bi bi1)
    {
        al.a(bi1);
    }

    public void b(a a1)
    {
        Object obj;
        ArrayList arraylist;
        Map map;
        Object obj1;
        f = new HashMap();
        arraylist = new ArrayList();
        arraylist.add("default_original_looks");
        arraylist.addAll(bo.a(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, new com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode[] {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.c, com.cyberlink.youcammakeup.utility.PanelDataCenter.SupportMode.a
        }));
        arraylist.addAll(bo.a(new com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType[] {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b
        }));
        arraylist.addAll(bo.a(new com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType[] {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c
        }));
        obj = StatusManager.j().d();
        if (obj != null && ((i) (obj)).a() != null && ((i) (obj)).a().b() != null)
        {
            obj = ((i) (obj)).a().b();
        } else
        {
            obj = null;
        }
        map = PanelDataCenter.a().a(BeautyMode.r, true);
        if (a1 == null) goto _L2; else goto _L1
_L1:
        obj1 = a1.d();
        if (obj1 != null) goto _L3; else goto _L2
_L2:
        int i1;
        return;
_L3:
        if ((i1 = a1.e) != -1)
        {
            z z1 = com.cyberlink.youcammakeup.kernelctrl.j.a(((com.cyberlink.youcammakeup.kernelctrl.ar)((List) (obj1)).get(i1)).c.b());
            obj1 = com.cyberlink.youcammakeup.kernelctrl.j.a(((com.cyberlink.youcammakeup.kernelctrl.ar)((List) (obj1)).get(i1)).c.c());
            z z2 = com.cyberlink.youcammakeup.kernelctrl.j.a(a1.a());
            z z3 = com.cyberlink.youcammakeup.kernelctrl.j.a(a1.b());
            if (z2 != null && z3 != null)
            {
                int j1 = 0;
                while (j1 < arraylist.size()) 
                {
                    com.cyberlink.youcammakeup.widgetpool.common.ae ae1 = new com.cyberlink.youcammakeup.widgetpool.common.ae(this);
                    if (arraylist.get(j1) != null)
                    {
                        a1 = (String)arraylist.get(j1);
                        if (map.containsKey(a1))
                        {
                            a1 = (String)map.get(a1);
                        } else
                        {
                            a1 = null;
                        }
                        ae1.a(a1);
                        if (a1 != null && obj != null && ((String) (obj)).equals(a1))
                        {
                            ae1.a(false);
                            ae1.a(z1);
                            ae1.b(((z) (obj1)));
                        } else
                        if (a1 == null)
                        {
                            ae1.a(false);
                            ae1.a(z2);
                            ae1.b(z3);
                        } else
                        {
                            ae1.a(true);
                            ae1.a(z2);
                            ae1.b(z3);
                        }
                    }
                    f.put(arraylist.get(j1), ae1);
                    j1++;
                }
            }
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void b(String s1, z z1)
    {
        if (e != null && e.get(s1) != null)
        {
            ((com.cyberlink.youcammakeup.widgetpool.common.aa)e.get(s1)).b(com.cyberlink.youcammakeup.kernelctrl.j.a(z1));
        }
    }

    public void b(String s1, boolean flag)
    {
        if (f != null && f.get(s1) != null)
        {
            ((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get(s1)).a(flag);
        }
    }

    public void b(List list)
    {
        Iterator iterator = list.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (((at)iterator.next()).j() <= 0) goto _L4; else goto _L3
_L3:
        return;
_L2:
        list = list.iterator();
        while (list.hasNext()) 
        {
            ((at)list.next()).b(100);
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void b(boolean flag)
    {
        for (Iterator iterator = m.iterator(); iterator.hasNext(); ((at)iterator.next()).a(flag)) { }
    }

    public boolean b(Boolean boolean1)
    {
        if (k == null)
        {
            return false;
        }
        BeautyMode beautymode = StatusManager.j().s();
        if (beautymode == BeautyMode.x)
        {
            ((at)m.get(0)).a(100 - k.getProgress());
        } else
        if (beautymode != BeautyMode.n)
        {
            ((at)m.get(0)).a(k.getProgress());
        } else
        {
            SwitcherMode switchermode = StatusManager.j().i();
            ((at)m.get(switchermode.ordinal())).a(k.getProgress());
            a(switchermode, k.getProgress());
            M();
        }
        if (beautymode == BeautyMode.x)
        {
            q(boolean1.booleanValue());
            return true;
        }
        boolean flag;
        try
        {
            flag = b(new BeautifierTaskInfo(boolean1.booleanValue()), false);
        }
        // Misplaced declaration of an exception variable
        catch (Boolean boolean1)
        {
            boolean1.printStackTrace();
            return false;
        }
        return flag;
    }

    public boolean b(String s1)
    {
        while (s1 == null || e == null || e.get(s1) == null) 
        {
            return true;
        }
        return ((com.cyberlink.youcammakeup.widgetpool.common.aa)e.get(s1)).a();
    }

    public int c(SwitcherMode switchermode)
    {
        if (switchermode.ordinal() >= m.size())
        {
            return 0;
        } else
        {
            return ((at)m.get(switchermode.ordinal())).j();
        }
    }

    public z c(String s1)
    {
        while (s1 == null || e == null || e.get(s1) == null) 
        {
            return null;
        }
        return com.cyberlink.youcammakeup.kernelctrl.j.a(((com.cyberlink.youcammakeup.widgetpool.common.aa)e.get(s1)).b());
    }

    public HashMap c()
    {
        return new HashMap(Q);
    }

    public void c(int i1)
    {
        p = i1;
    }

    public void c(bi bi1)
    {
        ar.a(bi1);
    }

    public void c(a a1)
    {
        long l1 = StatusManager.j().l();
        Object obj = Globals.d().t();
        boolean flag = false;
        if (obj != null)
        {
            flag = ((EditViewActivity) (obj)).A();
        }
        if (flag)
        {
            obj = StatusManager.j().l(l1);
        } else
        {
            obj = StatusManager.j().i(l1);
        }
        if (a1 != null && obj != null)
        {
            a1.a(com.cyberlink.youcammakeup.kernelctrl.j.a(((a) (obj)).a()));
            a1.b(com.cyberlink.youcammakeup.kernelctrl.j.a(((a) (obj)).b()));
        }
    }

    public void c(Boolean boolean1)
    {
        BeautifierEditCenter.a().e(boolean1.booleanValue());
    }

    public void c(String s1, z z1)
    {
        if (f != null && f.get(s1) != null)
        {
            ((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get(s1)).a(com.cyberlink.youcammakeup.kernelctrl.j.a(z1));
        }
    }

    public void c(String s1, boolean flag)
    {
        if (ad == null)
        {
            return;
        } else
        {
            ad.put(s1, Boolean.valueOf(flag));
            return;
        }
    }

    public void c(List list)
    {
        int i1 = 0;
        while (i1 < list.size()) 
        {
            if (i1 < m.size())
            {
                ((at)m.get(i1)).a(((Integer)list.get(i1)).intValue());
            } else
            {
                com.pf.common.utility.m.d("MotionControlHelper", "There are more intensities than colors! Create default color for surplus intensity!");
                at at1 = new at(0);
                at1.a(((Integer)list.get(i1)).intValue());
                m.add(at1);
            }
            i1++;
        }
        a(list);
    }

    public void c(boolean flag)
    {
        ae = flag;
    }

    public z d(String s1)
    {
        while (s1 == null || e == null || e.get(s1) == null) 
        {
            return null;
        }
        return com.cyberlink.youcammakeup.kernelctrl.j.a(((com.cyberlink.youcammakeup.widgetpool.common.aa)e.get(s1)).c());
    }

    public List d()
    {
        String s1 = StatusManager.j().e();
        if (s1 == null)
        {
            com.pf.common.utility.m.e("MotionControlHelper", "getCurShadowIntensityList null patternID");
            return null;
        }
        if (Q == null)
        {
            com.pf.common.utility.m.e("MotionControlHelper", "getCurShadowIntensityList null mShadowIntensities");
            return null;
        } else
        {
            return (List)Q.get(s1);
        }
    }

    public void d(bi bi1)
    {
        ax.a(bi1);
    }

    public void d(String s1, z z1)
    {
        if (f != null && f.get(s1) != null)
        {
            ((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get(s1)).b(com.cyberlink.youcammakeup.kernelctrl.j.a(z1));
        }
    }

    public void d(String s1, boolean flag)
    {
        if (aj == null)
        {
            return;
        } else
        {
            aj.put(s1, Boolean.valueOf(flag));
            return;
        }
    }

    public void d(List list)
    {
        if (list != null && list.size() > 0)
        {
            ArrayList arraylist = new ArrayList();
            for (list = list.iterator(); list.hasNext(); arraylist.add(((at)list.next()).m())) { }
            m = arraylist;
            return;
        } else
        {
            com.pf.common.utility.m.d("MotionControlHelper", "Set a null colorList!");
            return;
        }
    }

    public void d(boolean flag)
    {
        ak = flag;
    }

    public void e(bi bi1)
    {
        aE.a(bi1);
    }

    public void e(String s1, boolean flag)
    {
        if (ap == null)
        {
            return;
        } else
        {
            ap.put(s1, Boolean.valueOf(flag));
            return;
        }
    }

    public void e(boolean flag)
    {
        aq = flag;
    }

    public boolean e(String s1)
    {
        while (s1 == null || f == null || f.get(s1) == null) 
        {
            return true;
        }
        return ((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get(s1)).a();
    }

    public z f(String s1)
    {
        while (s1 == null || f == null || f.get(s1) == null) 
        {
            return null;
        }
        return com.cyberlink.youcammakeup.kernelctrl.j.a(((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get(s1)).b());
    }

    public Boolean f()
    {
        return s;
    }

    public void f(bi bi1)
    {
        aE.b(bi1);
    }

    public void f(String s1, boolean flag)
    {
        if (aB == null)
        {
            return;
        } else
        {
            aB.put(s1, Boolean.valueOf(flag));
            return;
        }
    }

    public void f(boolean flag)
    {
        aw = flag;
    }

    public z g(String s1)
    {
        while (s1 == null || f == null || f.get(s1) == null) 
        {
            return null;
        }
        return com.cyberlink.youcammakeup.kernelctrl.j.a(((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get(s1)).c());
    }

    public void g()
    {
        int i1 = 0;
        if (e != null) goto _L2; else goto _L1
_L1:
        Object obj1;
        return;
_L2:
        if (((String) (obj1 = StatusManager.j().e())).equals("Eyebrow_general"))
        {
            List list = PanelDataCenter.a().a(BeautyMode.r);
            long l1 = StatusManager.j().l();
            Object obj = Globals.d().t();
            boolean flag;
            if (obj != null)
            {
                flag = ((EditViewActivity) (obj)).A();
            } else
            {
                flag = false;
            }
            if (flag)
            {
                obj = StatusManager.j().l(l1);
            } else
            {
                obj = StatusManager.j().i(l1);
            }
            if (obj != null)
            {
                obj = com.cyberlink.youcammakeup.kernelctrl.j.a(((com.cyberlink.youcammakeup.widgetpool.common.aa)e.get(obj1)).b());
                obj1 = com.cyberlink.youcammakeup.kernelctrl.j.a(((com.cyberlink.youcammakeup.widgetpool.common.aa)e.get(obj1)).c());
                if (obj != null && obj1 != null)
                {
                    while (i1 < list.size()) 
                    {
                        if (list.get(i1) != null && e.get(list.get(i1)) != null && ((com.cyberlink.youcammakeup.widgetpool.common.aa)e.get(list.get(i1))).a())
                        {
                            ((com.cyberlink.youcammakeup.widgetpool.common.aa)e.get(list.get(i1))).a(((z) (obj)));
                            ((com.cyberlink.youcammakeup.widgetpool.common.aa)e.get(list.get(i1))).b(((z) (obj1)));
                        }
                        i1++;
                    }
                }
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void g(String s1, boolean flag)
    {
        if (aC == null)
        {
            return;
        } else
        {
            aC.put(s1, Boolean.valueOf(flag));
            return;
        }
    }

    public void g(boolean flag)
    {
        aU = flag;
    }

    public void h()
    {
        e = null;
    }

    public void h(String s1)
    {
_L2:
        return;
        if (f == null || f.get(s1) == null || f.get("default_original_looks") == null || !((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get(s1)).d() && !((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get(s1)).e()) goto _L2; else goto _L1
_L1:
        if (!((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get("default_original_looks")).d() && !((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get("default_original_looks")).e())
        {
            break; /* Loop/switch isn't completed */
        }
        long l1 = StatusManager.j().l();
        Object obj1 = StatusManager.j().f(l1);
        if (obj1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = ((a) (obj1)).d();
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        int i1 = ((a) (obj1)).e;
        if (i1 == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = com.cyberlink.youcammakeup.kernelctrl.j.a(((com.cyberlink.youcammakeup.kernelctrl.ar)((List) (obj)).get(i1)).c.b());
        obj = com.cyberlink.youcammakeup.kernelctrl.j.a(((com.cyberlink.youcammakeup.kernelctrl.ar)((List) (obj)).get(i1)).c.c());
        if (((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get("default_original_looks")).d())
        {
            ((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get("default_original_looks")).a(((z) (obj1)));
        }
        if (((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get("default_original_looks")).e())
        {
            ((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get("default_original_looks")).b(((z) (obj)));
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L3
_L3:
        if (((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get(s1)).d())
        {
            z z1 = com.cyberlink.youcammakeup.kernelctrl.j.a(((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get("default_original_looks")).b());
            ((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get(s1)).a(z1);
        }
        if (((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get(s1)).e())
        {
            z z2 = com.cyberlink.youcammakeup.kernelctrl.j.a(((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get("default_original_looks")).c());
            ((com.cyberlink.youcammakeup.widgetpool.common.ae)f.get(s1)).b(z2);
            return;
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void h(String s1, boolean flag)
    {
        if (aF == null)
        {
            return;
        } else
        {
            aF.put(s1, Boolean.valueOf(flag));
            return;
        }
    }

    public void h(boolean flag)
    {
        g = flag;
    }

    public void i()
    {
        f = null;
    }

    public void i(String s1, boolean flag)
    {
        if (aG == null)
        {
            return;
        } else
        {
            aG.put(s1, Boolean.valueOf(flag));
            return;
        }
    }

    public void i(boolean flag)
    {
        aD = flag;
    }

    public String j(String s1)
    {
        if (Z == null)
        {
            return null;
        } else
        {
            return (String)Z.get(s1);
        }
    }

    public void j(boolean flag)
    {
        aV = flag;
    }

    public boolean j()
    {
        return f != null;
    }

    public String k(String s1)
    {
        if (ab == null)
        {
            ab = new HashMap();
        }
        String s3 = (String)ab.get(s1);
        String s2 = s3;
        if (s3 == null)
        {
            s2 = PanelDataCenter.a().d(s1, null);
            a(s1, s2);
        }
        return s2;
    }

    public void k()
    {
        String s1 = StatusManager.j().e();
        Object obj = af.b();
        File file;
        if (obj != null)
        {
            if (((File) (obj = new File(((String) (obj))))).exists() && ((File) (obj)).renameTo(file = new File((new StringBuilder()).append(b).append("/").append(((File) (obj)).getName()).toString())))
            {
                af.b(file.getAbsolutePath());
                aP.put(s1, af);
                return;
            }
        }
    }

    public void k(boolean flag)
    {
        aW = flag;
    }

    public void l()
    {
        x = null;
        y = null;
        z = null;
        B = null;
        A = null;
        C = null;
        D = null;
        E = null;
        ag = null;
        am = null;
        as = null;
        ay = null;
        R = null;
        S = null;
        T = null;
        U = null;
        V = null;
        W = null;
        ah = null;
        an = null;
        at = null;
        az = null;
        M.clear();
        q = null;
        r = null;
    }

    public void l(String s1)
    {
        while (ab == null || !ab.containsKey(s1)) 
        {
            return;
        }
        ab.remove(s1);
    }

    public void l(boolean flag)
    {
        aX = flag;
    }

    public void m()
    {
        BeautyMode beautymode = StatusManager.j().s();
        com.cyberlink.youcammakeup.widgetpool.common._cls1.a[beautymode.ordinal()];
        JVM INSTR tableswitch 1 13: default 80
    //                   1 111
    //                   2 111
    //                   3 111
    //                   4 111
    //                   5 111
    //                   6 111
    //                   7 111
    //                   8 111
    //                   9 123
    //                   10 123
    //                   11 135
    //                   12 135
    //                   13 141;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L3 _L3 _L4 _L4 _L5
_L1:
        com.pf.common.utility.m.e("MotionControlHelper", (new StringBuilder()).append("[setMappingTable] mode is ").append(beautymode.name()).toString());
        return;
_L2:
        F = new ConcurrentHashMap();
        return;
_L3:
        G = new HashMap();
        return;
_L4:
        a(beautymode);
        return;
_L5:
        H = new HashMap();
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void m(String s1)
    {
        while (ac == null || !ac.containsKey(s1)) 
        {
            return;
        }
        ac.remove(s1);
    }

    public void m(boolean flag)
    {
        aY = flag;
    }

    public void n()
    {
        I.clear();
        J.clear();
        K.clear();
        M.clear();
        L.clear();
        N.clear();
        O.clear();
        P.clear();
        ai.clear();
        ao.clear();
        au.clear();
        aA.clear();
        a(BeautyMode.j);
        a(BeautyMode.k);
    }

    public void n(String s1)
    {
        while (aP == null || !aP.containsKey(s1)) 
        {
            return;
        }
        aP.remove(s1);
    }

    public void n(boolean flag)
    {
        aZ = flag;
    }

    public void o(boolean flag)
    {
        ba = flag;
    }

    public boolean o()
    {
        BeautyMode beautymode = StatusManager.j().s();
        if (beautymode == BeautyMode.n)
        {
            if (x != null)
            {
                q = b(x);
                return true;
            }
        } else
        if (beautymode == BeautyMode.m)
        {
            if (z != null)
            {
                q = b(z);
                return true;
            }
        } else
        if (beautymode == BeautyMode.l)
        {
            if (y != null)
            {
                q = b(y);
                return true;
            }
        } else
        if (beautymode == BeautyMode.x)
        {
            if (A != null)
            {
                q = b(A);
                return true;
            }
        } else
        if (beautymode == BeautyMode.a)
        {
            if (C != null)
            {
                r = c(C);
                return true;
            }
        } else
        if (beautymode == BeautyMode.r)
        {
            if (D != null)
            {
                r = c(D);
                return true;
            }
        } else
        if (beautymode == BeautyMode.z)
        {
            if (ag != null)
            {
                q = b(ag);
                return true;
            }
        } else
        if (beautymode == BeautyMode.t)
        {
            if (B != null)
            {
                q = b(B);
                return true;
            }
        } else
        if (beautymode == BeautyMode.A)
        {
            if (am != null)
            {
                q = b(am);
                return true;
            }
        } else
        if (beautymode == BeautyMode.B)
        {
            if (as != null)
            {
                q = b(as);
                return true;
            }
        } else
        if (beautymode == BeautyMode.C && ay != null)
        {
            q = b(ay);
            return true;
        }
        return false;
    }

    public boolean o(String s1)
    {
        if (ad == null)
        {
            return false;
        }
        s1 = (Boolean)ad.get(s1);
        boolean flag;
        if (s1 == null)
        {
            flag = false;
        } else
        {
            flag = s1.booleanValue();
        }
        return flag;
    }

    public void p()
    {
        Object obj = StatusManager.j().d();
        if (obj != null)
        {
            x = null;
            if (((i) (obj)).b() != null && I != null)
            {
                ae ae1 = (ae)I.get(((i) (obj)).b().b());
                if (ae1 != null)
                {
                    x = b(ae1);
                    I.remove(((i) (obj)).b().b());
                }
            }
            y = null;
            if (((i) (obj)).e() != null && J != null)
            {
                ae ae2 = (ae)J.get(((i) (obj)).e().b());
                if (ae2 != null)
                {
                    y = b(ae2);
                    J.remove(((i) (obj)).e().b());
                }
            }
            z = null;
            if (((i) (obj)).f() != null && K != null)
            {
                ae ae3 = (ae)K.get(((i) (obj)).f().b());
                if (ae3 != null)
                {
                    z = b(ae3);
                    K.remove(((i) (obj)).f().b());
                }
            }
            B = null;
            if (((i) (obj)).d() != null && M != null)
            {
                ae ae4 = (ae)M.get(((i) (obj)).d().a());
                if (ae4 != null)
                {
                    B = b(ae4);
                    M.remove(((i) (obj)).d().a());
                }
            }
            A = null;
            if (((i) (obj)).u() != null && L != null)
            {
                ae ae5 = (ae)L.get(((i) (obj)).u().b());
                if (ae5 != null)
                {
                    A = b(ae5);
                    L.remove(((i) (obj)).u().b());
                }
            }
            C = null;
            if (((i) (obj)).g() != null && N != null)
            {
                Pair pair = (Pair)N.get(((i) (obj)).g().b());
                if (pair != null)
                {
                    C = c(pair);
                    N.remove(((i) (obj)).g().b());
                }
            }
            D = null;
            if (((i) (obj)).a() != null && O != null)
            {
                Pair pair1 = (Pair)O.get(((i) (obj)).a().b());
                if (pair1 != null)
                {
                    D = c(pair1);
                    O.remove(((i) (obj)).a().b());
                }
            }
            E = null;
            if (((i) (obj)).c() != null && P != null)
            {
                Pair pair2 = (Pair)P.get(((i) (obj)).c().b());
                if (pair2 != null)
                {
                    E = d(pair2);
                    P.remove(((i) (obj)).c().b());
                }
            }
            ag = null;
            if (((i) (obj)).y() != null && ai != null)
            {
                String s1 = z(((i) (obj)).y().a());
                ae ae7 = (ae)ai.get(s1);
                if (ae7 != null)
                {
                    ag = b(ae7);
                    ai.remove(s1);
                }
            }
            am = null;
            if (((i) (obj)).z() != null && ao != null)
            {
                String s2 = z(((i) (obj)).z().a());
                ae ae8 = (ae)ao.get(s2);
                if (ae8 != null)
                {
                    am = b(ae8);
                    ao.remove(s2);
                }
            }
            as = null;
            if (((i) (obj)).A() != null && au != null)
            {
                String s3 = z(((i) (obj)).A().a());
                ae ae9 = (ae)au.get(s3);
                if (ae9 != null)
                {
                    as = b(ae9);
                    au.remove(s3);
                }
            }
            ay = null;
            if (((i) (obj)).B() != null && aA != null)
            {
                obj = z(((i) (obj)).B().a());
                ae ae6 = (ae)aA.get(obj);
                if (ae6 != null)
                {
                    ay = b(ae6);
                    aA.remove(obj);
                    return;
                }
            }
        }
    }

    public void p(String s1)
    {
        while (ad == null || !ad.containsKey(s1)) 
        {
            return;
        }
        ad.remove(s1);
    }

    public void p(boolean flag)
    {
        bb = flag;
    }

    public void q()
    {
        Object obj = StatusManager.j().s();
        String s1 = StatusManager.j().e();
        if (s1 != null)
        {
            if (obj == BeautyMode.n)
            {
                if (F == null)
                {
                    F = new ConcurrentHashMap();
                }
                obj = (ae)F.get(s1);
                if (obj != null)
                {
                    x = b(((ae) (obj)));
                }
                F.remove(s1);
            } else
            {
                if (obj == BeautyMode.m)
                {
                    if (F == null)
                    {
                        F = new ConcurrentHashMap();
                    }
                    obj = (ae)F.get(s1);
                    if (obj != null)
                    {
                        z = b(((ae) (obj)));
                    }
                    F.remove(s1);
                    return;
                }
                if (obj == BeautyMode.l)
                {
                    if (F == null)
                    {
                        F = new ConcurrentHashMap();
                    }
                    obj = (ae)F.get(s1);
                    if (obj != null)
                    {
                        y = b(((ae) (obj)));
                    }
                    F.remove(s1);
                    return;
                }
                if (obj == BeautyMode.x)
                {
                    if (F == null)
                    {
                        F = new ConcurrentHashMap();
                    }
                    obj = (ae)F.get(s1);
                    if (obj != null)
                    {
                        A = b(((ae) (obj)));
                    }
                    F.remove(s1);
                    return;
                }
                if (obj == BeautyMode.a)
                {
                    if (G == null)
                    {
                        G = new HashMap();
                    }
                    obj = (Pair)G.get(s1);
                    if (obj != null)
                    {
                        C = c(((Pair) (obj)));
                    }
                    G.remove(s1);
                    return;
                }
                if (obj == BeautyMode.r)
                {
                    if (G == null)
                    {
                        G = new HashMap();
                    }
                    obj = (Pair)G.get(s1);
                    if (obj != null)
                    {
                        D = c(((Pair) (obj)));
                    }
                    G.remove(s1);
                    return;
                }
                if (obj == BeautyMode.s)
                {
                    if (H == null)
                    {
                        H = new HashMap();
                    }
                    obj = (Pair)H.get(s1);
                    if (obj != null)
                    {
                        E = d(((Pair) (obj)));
                    }
                    H.remove(s1);
                    return;
                }
                if (obj == BeautyMode.t)
                {
                    if (F == null)
                    {
                        F = new ConcurrentHashMap();
                    }
                    obj = (ae)F.get(s1);
                    if (obj != null)
                    {
                        B = b(((ae) (obj)));
                    }
                    F.remove(s1);
                    return;
                }
                if (obj == BeautyMode.z)
                {
                    if (F == null)
                    {
                        F = new ConcurrentHashMap();
                    }
                    s1 = z(s1);
                    obj = (ae)F.get(s1);
                    if (obj != null)
                    {
                        ag = b(((ae) (obj)));
                    }
                    F.remove(s1);
                    return;
                }
                if (obj == BeautyMode.A)
                {
                    if (F == null)
                    {
                        F = new ConcurrentHashMap();
                    }
                    s1 = z(s1);
                    obj = (ae)F.get(s1);
                    if (obj != null)
                    {
                        am = b(((ae) (obj)));
                    }
                    F.remove(s1);
                    return;
                }
                if (obj == BeautyMode.B)
                {
                    if (F == null)
                    {
                        F = new ConcurrentHashMap();
                    }
                    s1 = z(s1);
                    obj = (ae)F.get(s1);
                    if (obj != null)
                    {
                        as = b(((ae) (obj)));
                    }
                    F.remove(s1);
                    return;
                }
                if (obj == BeautyMode.C)
                {
                    if (F == null)
                    {
                        F = new ConcurrentHashMap();
                    }
                    s1 = z(s1);
                    ae ae1 = (ae)F.get(s1);
                    if (ae1 != null)
                    {
                        ay = b(ae1);
                    }
                    F.remove(s1);
                    return;
                }
            }
        }
    }

    public void q(boolean flag)
    {
        if (StatusManager.j().s() == BeautyMode.x && m.size() != 0)
        {
            int ai1[] = ((at)m.get(0)).l();
            if (ai1 != null && ai1.length == 8)
            {
                bm bm1 = new bm();
                bm1.b(ai1[0]);
                bm1.c(ai1[1]);
                bm1.d(ai1[2]);
                bm1.a(ai1[3]);
                bm1.e(ai1[4]);
                bm1.f(ai1[5]);
                bm1.g(ai1[6]);
                bm1.h(ai1[7]);
                int i1 = ((at)m.get(0)).d();
                if (flag)
                {
                    a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.v);
                }
                VenusHelper.a().a(bm1, i1, flag);
                return;
            }
        }
    }

    public boolean q(String s1)
    {
        if (aj == null)
        {
            return false;
        }
        s1 = (Boolean)aj.get(s1);
        boolean flag;
        if (s1 == null)
        {
            flag = false;
        } else
        {
            flag = s1.booleanValue();
        }
        return flag;
    }

    public void r()
    {
        if (F != null)
        {
            for (Iterator iterator = F.entrySet().iterator(); iterator.hasNext(); a((ae)((java.util.Map.Entry)iterator.next()).getValue())) { }
            F = null;
        }
        if (G != null)
        {
            for (Iterator iterator1 = G.entrySet().iterator(); iterator1.hasNext(); a((Pair)((java.util.Map.Entry)iterator1.next()).getValue())) { }
            G = null;
        }
        if (H != null)
        {
            for (Iterator iterator2 = H.entrySet().iterator(); iterator2.hasNext(); b((Pair)((java.util.Map.Entry)iterator2.next()).getValue())) { }
            H = null;
        }
    }

    public void r(boolean flag)
    {
        be = flag;
    }

    public boolean r(String s1)
    {
        if (ap == null)
        {
            return false;
        }
        s1 = (Boolean)ap.get(s1);
        boolean flag;
        if (s1 == null)
        {
            flag = false;
        } else
        {
            flag = s1.booleanValue();
        }
        return flag;
    }

    public void s()
    {
        if (I != null)
        {
            for (Iterator iterator = I.entrySet().iterator(); iterator.hasNext(); a((ae)((java.util.Map.Entry)iterator.next()).getValue())) { }
            I.clear();
        }
        if (J != null)
        {
            for (Iterator iterator1 = J.entrySet().iterator(); iterator1.hasNext(); a((ae)((java.util.Map.Entry)iterator1.next()).getValue())) { }
            J.clear();
        }
        if (K != null)
        {
            for (Iterator iterator2 = K.entrySet().iterator(); iterator2.hasNext(); a((ae)((java.util.Map.Entry)iterator2.next()).getValue())) { }
            K.clear();
        }
        if (M != null)
        {
            for (Iterator iterator3 = M.entrySet().iterator(); iterator3.hasNext(); a((ae)((java.util.Map.Entry)iterator3.next()).getValue())) { }
            M.clear();
        }
        if (L != null)
        {
            for (Iterator iterator4 = L.entrySet().iterator(); iterator4.hasNext(); a((ae)((java.util.Map.Entry)iterator4.next()).getValue())) { }
            L.clear();
        }
        if (N != null)
        {
            for (Iterator iterator5 = N.entrySet().iterator(); iterator5.hasNext(); a((Pair)((java.util.Map.Entry)iterator5.next()).getValue())) { }
            N.clear();
        }
        if (O != null)
        {
            for (Iterator iterator6 = O.entrySet().iterator(); iterator6.hasNext(); a((Pair)((java.util.Map.Entry)iterator6.next()).getValue())) { }
            O.clear();
        }
        if (P != null)
        {
            for (Iterator iterator7 = P.entrySet().iterator(); iterator7.hasNext(); b((Pair)((java.util.Map.Entry)iterator7.next()).getValue())) { }
            P.clear();
        }
        if (ai != null)
        {
            for (Iterator iterator8 = ai.entrySet().iterator(); iterator8.hasNext(); a((ae)((java.util.Map.Entry)iterator8.next()).getValue())) { }
            ai.clear();
        }
        if (ao != null)
        {
            for (Iterator iterator9 = ao.entrySet().iterator(); iterator9.hasNext(); a((ae)((java.util.Map.Entry)iterator9.next()).getValue())) { }
            ao.clear();
        }
        if (au != null)
        {
            for (Iterator iterator10 = au.entrySet().iterator(); iterator10.hasNext(); a((ae)((java.util.Map.Entry)iterator10.next()).getValue())) { }
            au.clear();
        }
        if (aA != null)
        {
            for (Iterator iterator11 = aA.entrySet().iterator(); iterator11.hasNext(); a((ae)((java.util.Map.Entry)iterator11.next()).getValue())) { }
            aA.clear();
        }
    }

    public void s(boolean flag)
    {
        bf = flag;
    }

    public boolean s(String s1)
    {
        if (aB == null)
        {
            return false;
        }
        s1 = (Boolean)aB.get(s1);
        boolean flag;
        if (s1 == null)
        {
            flag = false;
        } else
        {
            flag = s1.booleanValue();
        }
        return flag;
    }

    public void t()
    {
        R = null;
        S = null;
        T = null;
        V = null;
        W = null;
        ah = null;
        an = null;
        at = null;
        az = null;
        q = null;
        r = null;
        E = null;
        X = null;
    }

    public boolean t(String s1)
    {
        if (aC == null)
        {
            return false;
        }
        s1 = (Boolean)aC.get(s1);
        boolean flag;
        if (s1 == null)
        {
            flag = false;
        } else
        {
            flag = s1.booleanValue();
        }
        return flag;
    }

    public void u()
    {
        com.cyberlink.youcammakeup.utility.bb.b(new File(a));
        com.cyberlink.youcammakeup.utility.bb.a(b);
        com.cyberlink.youcammakeup.utility.bb.a(c);
        aK.clear();
        aN.clear();
    }

    public boolean u(String s1)
    {
        if (aF == null)
        {
            return false;
        }
        s1 = (Boolean)aF.get(s1);
        boolean flag;
        if (s1 == null)
        {
            flag = false;
        } else
        {
            flag = s1.booleanValue();
        }
        return flag;
    }

    public void v()
    {
        com.cyberlink.youcammakeup.utility.bb.b(new File(c));
        com.cyberlink.youcammakeup.utility.bb.a(c);
    }

    public boolean v(String s1)
    {
        if (aG == null)
        {
            return false;
        }
        s1 = (Boolean)aG.get(s1);
        boolean flag;
        if (s1 == null)
        {
            flag = false;
        } else
        {
            flag = s1.booleanValue();
        }
        return flag;
    }

    public float w()
    {
        return j;
    }

    public String w(String s1)
    {
        if (s1 != null)
        {
            if ((s1 = PanelDataCenter.a().p(s1)).h() != null)
            {
                if (s1.h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.a)
                {
                    return "assets://makeup/lipstick/texture_lipstick_bright.png";
                }
                if (s1.h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.b)
                {
                    return "assets://makeup/lipstick/texture_lipstick_thick.png";
                }
                if (s1.h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.c)
                {
                    return "assets://makeup/lipstick/texture_lipstick_gloss.png";
                }
            }
        }
        return "assets://makeup/lipstick/texture_lipstick_gloss.png";
    }

    public void x()
    {
        if (k != null);
    }

    public void x(String s1)
    {
        w = s1;
    }

    public com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask y(String s1)
    {
        if (aH == null || s1 == null)
        {
            return null;
        } else
        {
            return (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)aH.get(s1);
        }
    }

    public void y()
    {
        if (k != null);
    }

    public boolean z()
    {
        if (StatusManager.j().s() != BeautyMode.x)
        {
            return false;
        } else
        {
            q(true);
            return true;
        }
    }

    static 
    {
        d = new android.graphics.BitmapFactory.Options();
        d.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
    }

    private class ConfigErrorCode extends Enum
    {

        public static final ConfigErrorCode A;
        public static final ConfigErrorCode B;
        public static final ConfigErrorCode C;
        public static final ConfigErrorCode D;
        private static final ConfigErrorCode E[];
        public static final ConfigErrorCode a;
        public static final ConfigErrorCode b;
        public static final ConfigErrorCode c;
        public static final ConfigErrorCode d;
        public static final ConfigErrorCode e;
        public static final ConfigErrorCode f;
        public static final ConfigErrorCode g;
        public static final ConfigErrorCode h;
        public static final ConfigErrorCode i;
        public static final ConfigErrorCode j;
        public static final ConfigErrorCode k;
        public static final ConfigErrorCode l;
        public static final ConfigErrorCode m;
        public static final ConfigErrorCode n;
        public static final ConfigErrorCode o;
        public static final ConfigErrorCode p;
        public static final ConfigErrorCode q;
        public static final ConfigErrorCode r;
        public static final ConfigErrorCode s;
        public static final ConfigErrorCode t;
        public static final ConfigErrorCode u;
        public static final ConfigErrorCode v;
        public static final ConfigErrorCode w;
        public static final ConfigErrorCode x;
        public static final ConfigErrorCode y;
        public static final ConfigErrorCode z;

        public static ConfigErrorCode valueOf(String s1)
        {
            return (ConfigErrorCode)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/common/MotionControlHelper$ConfigErrorCode, s1);
        }

        public static ConfigErrorCode[] values()
        {
            return (ConfigErrorCode[])E.clone();
        }

        static 
        {
            a = new ConfigErrorCode("NONE", 0);
            b = new ConfigErrorCode("DUMP_CACHE_FAILED", 1);
            c = new ConfigErrorCode("CONTROL_SETTING_INVALID", 2);
            d = new ConfigErrorCode("EYESHADOW_SETTING_INVALID", 3);
            e = new ConfigErrorCode("EYECONTACT_SETTING_INVALID", 4);
            f = new ConfigErrorCode("EYEBROW_SETTING_INVALID", 5);
            g = new ConfigErrorCode("EYELASH_SETTING_INVALID", 6);
            h = new ConfigErrorCode("EYELASH_MASK_INVALID", 7);
            i = new ConfigErrorCode("EYELINE_SETTING_INVALID", 8);
            j = new ConfigErrorCode("EYELINE_MASK_INVALID", 9);
            k = new ConfigErrorCode("BLUSH_SETTING_INVALID", 10);
            l = new ConfigErrorCode("BLUSH_MASK_INVALID", 11);
            m = new ConfigErrorCode("DOUBLE_EYELID_SETTING_INVALID", 12);
            n = new ConfigErrorCode("DOUBLE_EYELID_MASK_INVALID", 13);
            o = new ConfigErrorCode("LIPSTICK_SETTING_INVALID", 14);
            p = new ConfigErrorCode("MOUTH_NOT_OPEN", 15);
            q = new ConfigErrorCode("SKIN_TONER_SETTING_INVALID", 16);
            r = new ConfigErrorCode("WIG_SETTING_INVALID", 17);
            s = new ConfigErrorCode("WIG_MASK_INVALID", 18);
            t = new ConfigErrorCode("EYEWEAR_SETTING_INVALID", 19);
            u = new ConfigErrorCode("EYEWEAR_MASK_INVALID", 20);
            v = new ConfigErrorCode("HAIRBAND_SETTING_INVALID", 21);
            w = new ConfigErrorCode("HAIRBAHD_MASK_INVALID", 22);
            x = new ConfigErrorCode("NECKLACE_SETTING_INVALID", 23);
            y = new ConfigErrorCode("NECKLACE_MASK_INVALID", 24);
            z = new ConfigErrorCode("EARRING_SETTING_INVALID", 25);
            A = new ConfigErrorCode("EARRING_MASK_INVALID", 26);
            B = new ConfigErrorCode("HAIRDYE_SETTING_INVALID", 27);
            C = new ConfigErrorCode("CONFIG_FACE_ART_ERROR", 28);
            D = new ConfigErrorCode("CONFIG_FACE_WIDGET_ERROR", 29);
            E = (new ConfigErrorCode[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n, o, p, q, r, s, t, 
                u, v, w, x, y, z, A, B, C, D
            });
        }

        private ConfigErrorCode(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class SwitcherMode extends Enum
    {

        public static final SwitcherMode a;
        public static final SwitcherMode b;
        public static final SwitcherMode c;
        public static final SwitcherMode d;
        private static final SwitcherMode e[];

        public static SwitcherMode valueOf(String s1)
        {
            return (SwitcherMode)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/common/MotionControlHelper$SwitcherMode, s1);
        }

        public static SwitcherMode[] values()
        {
            return (SwitcherMode[])e.clone();
        }

        static 
        {
            a = new SwitcherMode("FIRST_COLOR", 0);
            b = new SwitcherMode("SECOND_COLOR", 1);
            c = new SwitcherMode("THIRD_COLOR", 2);
            d = new SwitcherMode("FOURTH_COLOR", 3);
            e = (new SwitcherMode[] {
                a, b, c, d
            });
        }

        private SwitcherMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class MotionName extends Enum
    {

        public static final MotionName a;
        private static final MotionName b[];

        public static MotionName valueOf(String s1)
        {
            return (MotionName)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/common/MotionControlHelper$MotionName, s1);
        }

        public static MotionName[] values()
        {
            return (MotionName[])b.clone();
        }

        static 
        {
            a = new MotionName("MouthOpen", 0);
            b = (new MotionName[] {
                a
            });
        }

        private MotionName(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
