// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.smule.android.c.aa;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.magicpiano.ProductListFragment;
import com.smule.pianoandroid.magicpiano.a.e;
import com.smule.pianoandroid.magicpiano.ai;
import com.smule.pianoandroid.magicpiano.ak;
import com.smule.pianoandroid.magicpiano.b.a;
import com.smule.pianoandroid.magicpiano.b.b;
import com.smule.pianoandroid.magicpiano.b.p;
import com.smule.pianoandroid.magicpiano.b.q;
import com.smule.pianoandroid.magicpiano.i;
import com.smule.pianoandroid.magicpiano.j;
import java.util.HashMap;

// Referenced classes of package com.smule.pianoandroid.utils:
//            u, o, i

public class t
    implements ak, b, q, j
{

    public static u e = null;
    private static final String f = com/smule/pianoandroid/utils/t.getSimpleName();
    i a;
    p b;
    FragmentActivity c;
    FragmentManager d;
    private int g;
    private SongV2 h;
    private boolean i;
    private boolean j;
    private String k;
    private boolean l;

    public t(FragmentActivity fragmentactivity)
    {
        i = false;
        j = false;
        l = false;
        c = fragmentactivity;
        d = c.getSupportFragmentManager();
        k = c.getResources().getString(0x7f0c00d7);
    }

    static int a(t t1, int i1)
    {
        t1.g = i1;
        return i1;
    }

    public static void b()
    {
        if (e != null)
        {
            e.d();
        }
    }

    private void b(boolean flag)
    {
        FragmentActivity fragmentactivity = c;
        String s;
        if (flag)
        {
            s = c.getString(0x7f0c00db);
        } else
        {
            s = c.getString(0x7f0c00dc);
        }
        a = new i(fragmentactivity, s);
        a.a(this);
        a.setCancelable(true);
        a.a(true);
    }

    static String f()
    {
        return f;
    }

    private void g()
    {
        l = true;
    }

    private void h()
    {
        l = false;
    }

    private void i()
    {
        boolean flag1 = true;
        if (h == null || h.resourceFilePaths == null || h.resourceFilePaths.size() <= 0) goto _L2; else goto _L1
_L1:
        if (a != null)
        {
            a.dismiss();
            a = null;
        }
        if (j)
        {
            c.finish();
        }
        boolean flag = flag1;
        if (g != 2)
        {
            if (g == 1)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        com.smule.pianoandroid.utils.o.a(c, flag, g, (String)h.resourceFilePaths.get("main"), h.title, h.songId, h.artist);
_L4:
        b = null;
        h();
        return;
_L2:
        if (a != null)
        {
            a.a(2, k, true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(ListingV2 listingv2)
    {
        if (b == null)
        {
            b(true);
            b = new p(c, listingv2.song, this, a);
            g = 2;
            b.execute(new Void[0]);
            com.smule.pianoandroid.magicpiano.a.e.a("previewed_song", listingv2.song);
            g();
        }
    }

    public void a(ListingV2 listingv2, boolean flag)
    {
        listingv2 = listingv2.song;
        b(false);
        b = new p(c, listingv2, this, a);
        g = 0;
        aa.c(f, (new StringBuilder()).append("Downloading ").append(((SongV2) (listingv2)).songId).append(" for play").toString());
        b.execute(new Void[0]);
        g();
    }

    public void a(SongV2 songv2)
    {
        h = songv2;
        if (c == null)
        {
            h = null;
            i();
            h();
            return;
        }
        if (!c.isFinishing())
        {
            i();
            return;
        } else
        {
            i = true;
            return;
        }
    }

    public void a(String s)
    {
        b(false);
        b = new p(c, s, this, a);
        g = 0;
        aa.c(f, (new StringBuilder()).append("Downloading ").append(s).append(" for play").toString());
        b.execute(new Void[0]);
        g();
    }

    public void a(boolean flag)
    {
        j = flag;
    }

    public void a(boolean flag, boolean flag1, Integer integer, ListingV2 listingv2)
    {
        if (c == null)
        {
            h();
            return;
        }
        if (flag)
        {
            if (flag1)
            {
                class a
                    implements ak, Runnable
                {

                    t a;
                    ListingV2 b;
                    final t c;

                    public void a(ListingV2 listingv2_1, boolean flag2)
                    {
                        if (c.a == null)
                        {
                            c.a = new i(c.c, c.c.getString(0x7f0c00dc));
                            c.a.show();
                        }
                        c.a.a(0, c.c.getString(0x7f0c00dc), true);
                        c.a.a(a);
                        b = listingv2_1;
                        c.b = new p(c.c, listingv2_1.song, a, c.a);
                        com.smule.pianoandroid.utils.t.a(c, 0);
                        aa.c(t.f(), (new StringBuilder()).append("Downloading ").append(listingv2_1.productId).append(" for play").toString());
                        c.b.execute(new Void[0]);
                    }

                    public void run()
                    {
                        ListingV2 listingv2_1 = com.smule.pianoandroid.utils.i.d().a();
                        if (listingv2_1.b() && !listingv2_1.isFree)
                        {
                            if (c.a != null)
                            {
                                c.a.dismiss();
                                c.a = null;
                            }
                            ai.a(c.c, listingv2_1, false, this).show();
                            return;
                        } else
                        {
                            a(b, false);
                            return;
                        }
                    }

            a(t t2, ListingV2 listingv2)
            {
                c = t.this;
                super();
                a = t2;
                b = listingv2;
            }
                }

                integer = new a(this, listingv2);
                if (!listingv2.isFree && com.smule.pianoandroid.magicpiano.b.a.a(c))
                {
                    com.smule.pianoandroid.utils.o.a(c, integer, integer, c.getResources().getString(0x7f0c021e), c.getResources().getString(0x7f0c021d));
                    return;
                } else
                {
                    integer.run();
                    return;
                }
            }
            if (integer.intValue() == 2)
            {
                com.smule.pianoandroid.utils.o.a(c, listingv2);
            } else
            if (listingv2.isFree)
            {
                a.a(2, c.getResources().getString(0x7f0c0059), true);
            } else
            {
                a.a(2, c.getResources().getString(0x7f0c01f8), true);
            }
            com.smule.android.network.managers.ak.a().h();
            h();
            return;
        } else
        {
            a.a(2, c.getResources().getString(0x7f0c0045), true);
            h();
            return;
        }
    }

    public void b(ListingV2 listingv2)
    {
        com.smule.android.c.a.a(com.smule.android.c.p.a, listingv2.price, listingv2.productId, listingv2.a(), ProductListFragment.a);
        a a1 = new a(listingv2, this);
        String s = String.format(c.getResources().getString(0x7f0c005a), new Object[] {
            listingv2.song.title
        });
        a = new i(c, s);
        a.setCancelable(false);
        a.a(false);
        aa.c(f, (new StringBuilder()).append("Claiming list item ").append(listingv2.productId).append(" for play").toString());
        a1.execute(new Void[0]);
        g();
    }

    public void b(SongV2 songv2)
    {
        if (b == null)
        {
            b(true);
            b = new p(c, songv2, this, a);
            g = 1;
            b.execute(new Void[0]);
            com.smule.pianoandroid.magicpiano.a.e.a("previewed_song", songv2);
            g();
        }
    }

    public void c()
    {
        e = null;
        c = null;
        d = null;
        if (b != null)
        {
            b.cancel(true);
            b = null;
        }
        if (a != null)
        {
            a.dismiss();
            a = null;
        }
    }

    public void c(ListingV2 listingv2)
    {
        com.smule.android.c.a.a(com.smule.android.c.p.a, listingv2.price, listingv2.productId, listingv2.a(), ProductListFragment.a);
        String s;
        if (listingv2.isFree)
        {
            s = c.getResources().getString(0x7f0c005a);
        } else
        {
            s = c.getResources().getString(0x7f0c01fa);
        }
        s = String.format(s, new Object[] {
            listingv2.song.title
        });
        a = new i(c, s);
        a.setCancelable(false);
        a.a(false);
        b();
        (new a(listingv2, this)).execute(new Void[0]);
        g();
    }

    public void c_()
    {
        if (b != null)
        {
            b.cancel(true);
            b = null;
        }
        if (a != null)
        {
            a.dismiss();
            a = null;
        }
    }

    public void d()
    {
        if (i)
        {
            i();
            i = false;
        }
    }

    public boolean e()
    {
        return l;
    }

}
