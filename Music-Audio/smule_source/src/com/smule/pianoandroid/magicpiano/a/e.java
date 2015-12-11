// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.a;

import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.network.managers.d;
import com.smule.android.network.managers.i;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import com.smule.magicpiano.MagicPerformanceStats;
import com.smule.pianoandroid.a.v;
import com.smule.pianoandroid.a.x;
import com.smule.pianoandroid.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano.a:
//            f, g

public class e
{

    private static final String a = com/smule/pianoandroid/magicpiano/a/e.getName();
    private static boolean b = false;
    private static int c = 0;
    private static Runnable d = null;
    private static final Object e = new Object();
    private static final List f = new ArrayList();
    private static f g = new f();

    public e()
    {
    }

    private static Map a(ListingV2 listingv2)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("uid", listingv2.listingId);
        hashmap.put("displayName", listingv2.song.title);
        hashmap.put("productType", listingv2.productType);
        hashmap.put("isNew", Boolean.valueOf(listingv2.isNew));
        hashmap.put("isOnSale", Boolean.valueOf(listingv2.sale));
        hashmap.put("isFree", Boolean.valueOf(listingv2.isFree));
        hashmap.put("price", Integer.valueOf(listingv2.price));
        return hashmap;
    }

    private static Map a(SongV2 songv2)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("songUID", songv2.songId);
        hashmap.put("genre", songv2.genre);
        hashmap.put("composer", songv2.artist);
        hashmap.put("songName", songv2.title);
        hashmap.put("owned", Boolean.valueOf(i.a().c(songv2.songId)));
        return hashmap;
    }

    private static Map a(MagicPerformanceStats magicperformancestats)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("score", Integer.valueOf(magicperformancestats.score()));
        hashmap.put("streak", Integer.valueOf(magicperformancestats.longestStreak));
        hashmap.put("totalPossible", Integer.valueOf(magicperformancestats.totalPointsPossible()));
        hashmap.put("perfect", magicperformancestats.isPerfect());
        hashmap.put("stars", Integer.valueOf(com.smule.pianoandroid.magicpiano.a.g.a().a(magicperformancestats.scoringHitChords(), magicperformancestats.totalScoringChords())));
        return hashmap;
    }

    public static void a()
    {
        if (b)
        {
            return;
        } else
        {
            b = true;
            Observer observer = new Observer() {

                public void update(Observable observable, Object obj)
                {
                    aa.a(e.c(), "Refreshing coin balance");
                    com.smule.android.network.managers.d.a().a(9);
                }

            };
            Observer observer1 = new Observer() {

                public void update(Observable observable, Object obj)
                {
                    aa.a(e.c(), "Adding song entitlement");
                    i.a().d((String)obj);
                }

            };
            h.a().a(x.c, observer);
            h.a().a(x.d, observer1);
            return;
        }
    }

    public static void a(Runnable runnable)
    {
label0:
        {
            synchronized (e)
            {
                if (c <= 0)
                {
                    break label0;
                }
                d = runnable;
            }
            return;
        }
        obj;
        JVM INSTR monitorexit ;
        if (runnable != null)
        {
            runnable.run();
            return;
        } else
        {
            return;
        }
        runnable;
        obj;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public static void a(String s, ListingV2 listingv2)
    {
        if (listingv2 == null)
        {
            return;
        } else
        {
            f();
            s = new v(s, "listing", a(listingv2), "song", a(listingv2.song));
            com.smule.pianoandroid.e.a.a().a(s, 1, g);
            return;
        }
    }

    public static void a(String s, SongV2 songv2)
    {
        if (songv2 == null)
        {
            return;
        } else
        {
            f();
            s = new v(s, "song", a(songv2));
            com.smule.pianoandroid.e.a.a().a(s, 1, g);
            return;
        }
    }

    public static void a(String s, SongV2 songv2, MagicPerformanceStats magicperformancestats)
    {
        if (songv2 == null)
        {
            return;
        } else
        {
            f();
            s = new v(s, "song", a(songv2), "stats", a(magicperformancestats), "settings", b(magicperformancestats));
            com.smule.pianoandroid.e.a.a().a(s, 1, g);
            return;
        }
    }

    private static Map b(MagicPerformanceStats magicperformancestats)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("difficulty", Integer.valueOf(magicperformancestats.difficulty));
        hashmap.put("gameModeEnabled", Boolean.valueOf(true));
        return hashmap;
    }

    public static boolean b()
    {
        List list = f;
        list;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (f.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        list;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static String c()
    {
        return a;
    }

    static List d()
    {
        return f;
    }

    static void e()
    {
        g();
    }

    private static void f()
    {
        synchronized (e)
        {
            c++;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static void g()
    {
        Runnable runnable;
        int j;
        synchronized (e)
        {
            c--;
            j = c;
            runnable = d;
        }
        if (j == 0 && runnable != null)
        {
            runnable.run();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
