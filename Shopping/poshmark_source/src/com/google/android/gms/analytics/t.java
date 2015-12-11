// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.di;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.google.android.gms.analytics:
//            f, ak, aa, a, 
//            m, g, ag, s, 
//            h, GoogleAnalytics, u, y

class t extends Thread
    implements f
{

    private static t sd;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile String qX;
    private final LinkedBlockingQueue rZ = new LinkedBlockingQueue();
    private volatile boolean sa;
    private volatile List sb;
    private volatile String sc;
    private volatile ag se;

    private t(Context context)
    {
        super("GAThread");
        sa = false;
        mClosed = false;
        if (context != null)
        {
            mContext = context.getApplicationContext();
        } else
        {
            mContext = context;
        }
        start();
    }

    static int C(String s1)
    {
        int k = 1;
        if (!TextUtils.isEmpty(s1))
        {
            int j = s1.length();
            int i = 0;
            j--;
            do
            {
                k = i;
                if (j < 0)
                {
                    break;
                }
                k = s1.charAt(j);
                k = (i << 6 & 0xfffffff) + k + (k << 14);
                int l = 0xfe00000 & k;
                i = k;
                if (l != 0)
                {
                    i = k ^ l >> 21;
                }
                j--;
            } while (true);
        }
        return k;
    }

    static String a(t t1)
    {
        return t1.qX;
    }

    static String a(t t1, String s1)
    {
        t1.sc = s1;
        return s1;
    }

    private String a(Throwable throwable)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        PrintStream printstream = new PrintStream(bytearrayoutputstream);
        throwable.printStackTrace(printstream);
        printstream.flush();
        return new String(bytearrayoutputstream.toByteArray());
    }

    static boolean a(t t1, Map map)
    {
        return t1.p(map);
    }

    static Context b(t t1)
    {
        return t1.mContext;
    }

    static void b(t t1, Map map)
    {
        t1.r(map);
    }

    static String c(t t1)
    {
        return t1.sc;
    }

    static void c(t t1, Map map)
    {
        t1.q(map);
    }

    static String d(t t1, Map map)
    {
        return t1.o(map);
    }

    static List d(t t1)
    {
        return t1.sb;
    }

    static ag e(t t1)
    {
        return t1.se;
    }

    private String o(Map map)
    {
        if (map.containsKey("useSecure"))
        {
            if (ak.d((String)map.get("useSecure"), true))
            {
                return "https:";
            } else
            {
                return "http:";
            }
        } else
        {
            return "https:";
        }
    }

    private boolean p(Map map)
    {
        if (map.get("&sf") == null)
        {
            return false;
        }
        double d1 = ak.a((String)map.get("&sf"), 100D);
        if (d1 >= 100D)
        {
            return false;
        }
        if ((double)(C((String)map.get("&cid")) % 10000) >= d1 * 100D)
        {
            if (map.get("&t") == null)
            {
                map = "unknown";
            } else
            {
                map = (String)map.get("&t");
            }
            aa.v(String.format("%s hit sampled out", new Object[] {
                map
            }));
            return true;
        } else
        {
            return false;
        }
    }

    static t q(Context context)
    {
        if (sd == null)
        {
            sd = new t(context);
        }
        return sd;
    }

    private void q(Map map)
    {
        m m1 = com.google.android.gms.analytics.a.m(mContext);
        ak.a(map, "&adid", m1.getValue("&adid"));
        ak.a(map, "&ate", m1.getValue("&ate"));
    }

    static String r(Context context)
    {
        Object obj;
        byte abyte0[];
        int i;
        obj = context.openFileInput("gaInstallData");
        abyte0 = new byte[8192];
        i = ((FileInputStream) (obj)).read(abyte0, 0, 8192);
        if (((FileInputStream) (obj)).available() <= 0)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        aa.t("Too much campaign data, ignoring it.");
        ((FileInputStream) (obj)).close();
        context.deleteFile("gaInstallData");
        return null;
        try
        {
            ((FileInputStream) (obj)).close();
            context.deleteFile("gaInstallData");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aa.u("No campaign data found.");
            return null;
        }
        catch (IOException ioexception)
        {
            aa.t("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        aa.w("Campaign file is empty.");
        return null;
        obj = new String(abyte0, 0, i);
        aa.u((new StringBuilder()).append("Campaign found: ").append(((String) (obj))).toString());
        return ((String) (obj));
    }

    private void r(Map map)
    {
        g g1 = g.bt();
        ak.a(map, "&an", g1.getValue("&an"));
        ak.a(map, "&av", g1.getValue("&av"));
        ak.a(map, "&aid", g1.getValue("&aid"));
        ak.a(map, "&aiid", g1.getValue("&aiid"));
        map.put("&v", "1");
    }

    void a(Runnable runnable)
    {
        rZ.add(runnable);
    }

    public void bk()
    {
        a(new Runnable() {

            final t sg;

            public void run()
            {
                t.e(sg).bk();
            }

            
            {
                sg = t.this;
                super();
            }
        });
    }

    public void bp()
    {
        a(new Runnable() {

            final t sg;

            public void run()
            {
                t.e(sg).bp();
            }

            
            {
                sg = t.this;
                super();
            }
        });
    }

    public void br()
    {
        a(new Runnable() {

            final t sg;

            public void run()
            {
                t.e(sg).br();
            }

            
            {
                sg = t.this;
                super();
            }
        });
    }

    public LinkedBlockingQueue bs()
    {
        return rZ;
    }

    public Thread getThread()
    {
        return this;
    }

    protected void init()
    {
        se.bI();
        sb = new ArrayList();
        sb.add(new di("appendVersion", "&_v".substring(1), "ma4.0.0"));
        sb.add(new di("appendQueueTime", "&qt".substring(1), null));
        sb.add(new di("appendCacheBuster", "&z".substring(1), null));
    }

    public void n(Map map)
    {
        String s1;
        HashMap hashmap;
        hashmap = new HashMap(map);
        s1 = (String)map.get("&ht");
        map = s1;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        Long.valueOf(s1);
        map = s1;
_L2:
        if (map == null)
        {
            hashmap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        a(new Runnable(hashmap) {

            final Map sf;
            final t sg;

            public void run()
            {
                if (TextUtils.isEmpty((CharSequence)sf.get("&cid")))
                {
                    sf.put("&cid", t.a(sg));
                }
                if (GoogleAnalytics.getInstance(t.b(sg)).getAppOptOut() || t.a(sg, sf))
                {
                    return;
                }
                if (!TextUtils.isEmpty(t.c(sg)))
                {
                    u.bR().r(true);
                    sf.putAll((new HitBuilders.HitBuilder()).setCampaignParamsFromUrl(t.c(sg)).build());
                    u.bR().r(false);
                    t.a(sg, null);
                }
                t.b(sg, sf);
                t.c(sg, sf);
                Map map1 = y.s(sf);
                t.e(sg).b(map1, Long.valueOf((String)sf.get("&ht")).longValue(), t.d(sg, sf), t.d(sg));
            }

            
            {
                sg = t.this;
                sf = map;
                super();
            }
        });
        return;
        map;
        map = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void run()
    {
        Process.setThreadPriority(10);
        Runnable runnable;
        Object obj;
        try
        {
            Thread.sleep(5000L);
        }
        catch (InterruptedException interruptedexception)
        {
            aa.w("sleep interrupted in GAThread initialize");
        }
        try
        {
            if (se == null)
            {
                se = new s(mContext, this);
            }
            init();
            qX = h.bu().getValue("&cid");
            if (qX == null)
            {
                sa = true;
            }
            sc = r(mContext);
            aa.v("Initialized GA Thread");
        }
        catch (Throwable throwable)
        {
            aa.t((new StringBuilder()).append("Error initializing the GAThread: ").append(a(throwable)).toString());
            aa.t("Google Analytics will not start up.");
            sa = true;
        }
        if (mClosed)
        {
            break; /* Loop/switch isn't completed */
        }
        runnable = (Runnable)rZ.take();
        if (!sa)
        {
            runnable.run();
        }
        continue; /* Loop/switch isn't completed */
        obj;
        try
        {
            aa.u(((InterruptedException) (obj)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            aa.t((new StringBuilder()).append("Error on GAThread: ").append(a(((Throwable) (obj)))).toString());
            aa.t("Google Analytics is shutting down.");
            sa = true;
        }
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_79;
_L1:
    }
}
