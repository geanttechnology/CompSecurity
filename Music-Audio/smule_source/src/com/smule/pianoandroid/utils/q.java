// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import com.smule.android.c.a;
import com.smule.android.c.c;
import com.smule.android.c.d;
import com.smule.android.c.f;
import com.smule.android.c.g;
import com.smule.android.c.o;
import com.smule.android.c.w;
import com.smule.android.c.x;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.i;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.data.model.GameReward;
import com.smule.pianoandroid.magicpiano.a.k;
import java.util.Iterator;
import java.util.List;

public class q extends a
{

    private static boolean b = false;

    public static void A()
    {
        com.smule.android.c.w.a().a("trial_popup_sub_clk");
    }

    public static void B()
    {
        com/smule/pianoandroid/utils/q;
        JVM INSTR monitorenter ;
        boolean flag = b;
        if (!flag) goto _L2; else goto _L1
_L1:
        com/smule/pianoandroid/utils/q;
        JVM INSTR monitorexit ;
        return;
_L2:
        long l1 = com.smule.android.c.w.f("app_time");
        com.smule.android.c.w.c("app_time");
        com.smule.android.c.w.a().a("app_launch_complete", null, null, Long.toString(l1));
        b = true;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private static c a(ListingV2 listingv2)
    {
        if (listingv2.a())
        {
            return c.d;
        }
        if (listingv2.isFree)
        {
            return c.a;
        }
        if (com.smule.android.network.managers.i.a().c(listingv2.productId))
        {
            return c.b;
        } else
        {
            return c.c;
        }
    }

    public static void a(int i1)
    {
        boolean flag = true;
        if (i1 < 1)
        {
            flag = false;
        }
        a(flag, "Day must be positive, non-zero");
        com.smule.android.c.w.a().a("dailychallenge_pgview", null, null, Integer.toString(i1));
    }

    public static void a(d d1, List list)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            if (((GameReward)list.next()).getRewardType().equals(com.smule.pianoandroid.data.model.GameReward.Type.COINS))
            {
                a(d1, null, null, null);
            }
        } while (true);
    }

    public static void a(SongV2 songv2, String s1)
    {
        ListingV2 listingv2 = ak.a().f(songv2.songId);
        if (listingv2 != null)
        {
            a(songv2.songId, listingv2.price, a(listingv2).a(), s1);
        }
    }

    public static void a(SongV2 songv2, String s1, Number number)
    {
        ListingV2 listingv2 = ak.a().f(songv2.songId);
        if (listingv2 != null)
        {
            a(songv2.songId, listingv2.price, a(listingv2).a(), s1, number);
        }
    }

    public static void a(String s1, o o1, f f1)
    {
        a(s1, "songUid is required");
        com.smule.android.c.w.a().a("song_sharetype_click", s1, o1.a(), null, null, null, f1.a());
    }

    public static void a(String s1, k k1, String s2, long l1, f f1)
    {
        a(s1, null, null, s2, l1, f1, new g(k1) {

            final k a;

            public x a(x x1)
            {
                x1.j = a.name();
                return x1;
            }

            
            {
                a = k1;
                super();
            }
        });
    }

    public static void a(String s1, k k1, String s2, f f1)
    {
        a(s1, null, null, s2, f1, new g(k1) {

            final k a;

            public x a(x x1)
            {
                x1.j = a.name().toLowerCase();
                return x1;
            }

            
            {
                a = k1;
                super();
            }
        });
    }

    public static void a(String s1, String s2, int i1)
    {
        a(s1, "songUid is required");
        com.smule.android.c.w.a().a("store_needsmoola_pgview", s1, s2, Integer.toString(i1));
    }

    public static void a(String s1, boolean flag)
    {
        a(s1, "songUid is required");
        w w1 = com.smule.android.c.w.a();
        String s2;
        if (flag)
        {
            s2 = "on";
        } else
        {
            s2 = "off";
        }
        w1.a("tut_mix_complete", s1, null, null, s2);
    }

    public static void a(String s1, boolean flag, f f1)
    {
        a(s1, "songUid is required");
        com.smule.android.c.w.a().a("song_share_pgview", s1, Boolean.toString(flag), null, null, null, f1.a());
    }

    public static void b(int i1)
    {
        boolean flag = true;
        if (i1 < 1)
        {
            flag = false;
        }
        a(flag, "Level must be positive, non-zero");
        com.smule.android.c.w.a().a("game_levelup_pgview", Integer.toString(i1));
    }

    public static void b(String s1, k k1, String s2, f f1)
    {
        a(s1, null, null, s2, 0, f1, new g(k1) {

            final k a;

            public x a(x x1)
            {
                x1.j = a.name();
                x1.g = null;
                return x1;
            }

            
            {
                a = k1;
                super();
            }
        });
    }

    public static void c(String s1, String s2, f f1)
    {
        a(s1, "songUid is required");
        a(s2, "section is required");
        com.smule.android.c.w.a().a("song_play_charged", s1, s2, null, null, null, f1.a());
    }

    public static void d(String s1)
    {
        a(s1, "SongUid is required");
        com.smule.android.c.w.a().a("dailychallenge_play_complete", s1);
    }

    public static void e(String s1)
    {
        a(s1, "SongUid is required");
        com.smule.android.c.w.a().a("dailychallenge_play_start", s1);
    }

    public static void f(String s1)
    {
        a(s1, "SongUid is required");
        com.smule.android.c.w.a().a("dailychallenge_play_exit", s1);
    }

    public static void g(String s1)
    {
        a(s1, "SongUid is required");
        com.smule.android.c.w.a().a("dailychallenge_play1_click", s1);
    }

    public static void h(String s1)
    {
        a(s1, "SongUid is required");
        com.smule.android.c.w.a().a("dailychallenge_play2_click", s1);
    }

    public static void i(String s1)
    {
        a(s1, "Achievement Uid is required");
        com.smule.android.c.w.a().a("achievement_satisfied", null, null, s1);
    }

    public static void j(String s1)
    {
        a(s1, "songUid is required");
        com.smule.android.c.w.a().a("tut_newsong_click", s1, true);
    }

    public static void k(String s1)
    {
        a(s1, "songUid is required");
        com.smule.android.c.w.a().a("tut_newsong_complete", s1, true);
    }

    public static void l(String s1)
    {
        a(s1, "songUid is required");
        com.smule.android.c.w.a().a("tut_newsong_start", s1, true);
    }

    public static void m(String s1)
    {
        a(s1, "songUid is required");
        com.smule.android.c.w.a().a("tut_mix_click", s1);
    }

    public static void n(String s1)
    {
        a(s1, "songUid is required");
        com.smule.android.c.w.a().a("tut_mix_start", s1);
    }

    public static void o()
    {
        com.smule.android.c.w.a().a("songbook_pgview");
    }

    public static void o(String s1)
    {
        a(s1, "songUid is required");
        com.smule.android.c.w.a().a("song_new_song", s1);
    }

    public static void p()
    {
        com.smule.android.c.w.a().a("globe_pgview");
    }

    public static void q()
    {
        com.smule.android.c.w.a().a("achievement_pgview");
    }

    public static void r()
    {
        com.smule.android.c.w.a().a("profile_pgview");
    }

    public static void s()
    {
        com.smule.android.c.w.a().a("solo_pgview");
    }

    public static void t()
    {
        com.smule.android.c.w.a().a("reg_cta_popup");
    }

    public static void u()
    {
        com.smule.android.c.w.a().a("tut_levelup", true);
    }

    public static void v()
    {
        com.smule.android.c.w.a().a("tut_newsong_quit", true);
    }

    public static void w()
    {
        com.smule.android.c.w.a().a("tut_song_start", true);
    }

    public static void x()
    {
        com.smule.android.c.w.a().a("tut_song_complete", true);
    }

    public static void y()
    {
        com.smule.android.c.w.a().a("store_pgview");
    }

    public static void z()
    {
        com.smule.android.c.w.a().a("store_cta_pgview");
    }

}
