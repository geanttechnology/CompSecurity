// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
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

// Referenced classes of package com.google.analytics.tracking.android:
//            h, an, ba, i, 
//            o, ag, af, ah, 
//            v, aw, k

final class ae extends Thread
    implements h
{

    private static ae g;
    private final LinkedBlockingQueue a = new LinkedBlockingQueue();
    private volatile boolean b;
    private volatile boolean c;
    private volatile List d;
    private volatile String e;
    private volatile String f;
    private volatile aw h;
    private final Context i;

    private ae(Context context)
    {
        super("GAThread");
        b = false;
        c = false;
        if (context != null)
        {
            i = context.getApplicationContext();
        } else
        {
            i = context;
        }
        start();
    }

    static ae a(Context context)
    {
        if (g == null)
        {
            g = new ae(context);
        }
        return g;
    }

    static String a(ae ae1)
    {
        return ae1.f;
    }

    private static String a(Throwable throwable)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        PrintStream printstream = new PrintStream(bytearrayoutputstream);
        throwable.printStackTrace(printstream);
        printstream.flush();
        return new String(bytearrayoutputstream.toByteArray());
    }

    private void a(Runnable runnable)
    {
        a.add(runnable);
    }

    static Context b(ae ae1)
    {
        return ae1.i;
    }

    private static String b(Context context)
    {
        Object obj;
        byte abyte0[];
        int j;
        obj = context.openFileInput("gaInstallData");
        abyte0 = new byte[8192];
        j = ((FileInputStream) (obj)).read(abyte0, 0, 8192);
        if (((FileInputStream) (obj)).available() <= 0)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        an.a("Too much campaign data, ignoring it.");
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
            an.b("No campaign data found.");
            return null;
        }
        catch (IOException ioexception)
        {
            an.a("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
        if (j > 0)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        an.d("Campaign file is empty.");
        return null;
        obj = new String(abyte0, 0, j);
        an.b((new StringBuilder("Campaign found: ")).append(((String) (obj))).toString());
        return ((String) (obj));
    }

    static boolean b(Map map)
    {
        if (map.get("&sf") != null)
        {
            double d1 = ba.b((String)map.get("&sf"));
            if (d1 < 100D)
            {
                String s = (String)map.get("&cid");
                int j;
                if (!TextUtils.isEmpty(s))
                {
                    int l = s.length() - 1;
                    j = 0;
                    for (; l >= 0; l--)
                    {
                        int i1 = s.charAt(l);
                        i1 = (j << 6 & 0xfffffff) + i1 + (i1 << 14);
                        int j1 = 0xfe00000 & i1;
                        j = i1;
                        if (j1 != 0)
                        {
                            j = i1 ^ j1 >> 21;
                        }
                    }

                } else
                {
                    j = 1;
                }
                if ((double)(j % 10000) >= d1 * 100D)
                {
                    if (map.get("&t") == null)
                    {
                        map = "unknown";
                    } else
                    {
                        map = (String)map.get("&t");
                    }
                    an.c(String.format("%s hit sampled out", new Object[] {
                        map
                    }));
                    return true;
                }
            }
        }
        return false;
    }

    static String c(ae ae1)
    {
        return ae1.e;
    }

    static void c(Map map)
    {
        i j = com.google.analytics.tracking.android.i.a();
        ba.a(map, "&an", j.a("&an"));
        ba.a(map, "&av", j.a("&av"));
        ba.a(map, "&aid", j.a("&aid"));
        ba.a(map, "&aiid", j.a("&aiid"));
        map.put("&v", "1");
    }

    static String d(ae ae1)
    {
        ae1.e = null;
        return null;
    }

    static String d(Map map)
    {
        if (map.containsKey("useSecure") && !ba.c((String)map.get("useSecure")))
        {
            return "http:";
        } else
        {
            return "https:";
        }
    }

    static List e(ae ae1)
    {
        return ae1.d;
    }

    static aw f(ae ae1)
    {
        return ae1.h;
    }

    public final void a()
    {
        a(((Runnable) (new ag(this))));
    }

    public final void a(Map map)
    {
        String s;
        HashMap hashmap;
        hashmap = new HashMap(map);
        s = (String)map.get("&ht");
        map = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        Long.valueOf(s).longValue();
        map = s;
_L2:
        if (map == null)
        {
            hashmap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        a(((Runnable) (new af(this, hashmap))));
        return;
        map;
        map = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void b()
    {
        a(new ah(this));
    }

    public final LinkedBlockingQueue c()
    {
        return a;
    }

    public final Thread d()
    {
        return this;
    }

    public final void run()
    {
        Runnable runnable;
        Object obj;
        try
        {
            Thread.sleep(5000L);
        }
        catch (InterruptedException interruptedexception)
        {
            an.d("sleep interrupted in GAThread initialize");
        }
        try
        {
            if (h == null)
            {
                h = new v(i, this);
            }
            h.e();
            d = new ArrayList();
            d.add(new Command("appendVersion", "&_v".substring(1), "ma3.0.1"));
            d.add(new Command("appendQueueTime", "&qt".substring(1), null));
            d.add(new Command("appendCacheBuster", "&z".substring(1), null));
            f = k.a().a("&cid");
            e = b(i);
        }
        catch (Throwable throwable)
        {
            an.a((new StringBuilder("Error initializing the GAThread: ")).append(a(throwable)).toString());
            an.a("Google Analytics will not start up.");
            b = true;
        }
        if (c)
        {
            break; /* Loop/switch isn't completed */
        }
        runnable = (Runnable)a.take();
        if (!b)
        {
            runnable.run();
        }
        continue; /* Loop/switch isn't completed */
        obj;
        try
        {
            an.b(((InterruptedException) (obj)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            an.a((new StringBuilder("Error on GAThread: ")).append(a(((Throwable) (obj)))).toString());
            an.a("Google Analytics is shutting down.");
            b = true;
        }
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_158;
_L1:
    }
}
