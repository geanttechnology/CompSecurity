// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import a;
import aaa;
import acd;
import acm;
import aen;
import aer;
import afi;
import afl;
import afz;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bgv;
import blu;
import blv;
import bmd;
import bmr;
import bov;
import bqb;
import bql;
import bqv;
import bqx;
import bri;
import btk;
import bvy;
import bw;
import bwa;
import com.google.android.apps.youtube.kids.application.KidsApplication;
import com.google.android.apps.youtube.kids.ui.HeaderTileGridLayout;
import com.google.android.apps.youtube.kids.ui.ParentalControlLaunchBar;
import com.google.android.apps.youtube.kids.ui.ScrollAwareHorizontalListView;
import com.google.android.apps.youtube.kids.ui.ScrollingSectionListGridView;
import ddn;
import ddo;
import dfx;
import dfy;
import din;
import dir;
import dlh;
import dmb;
import dos;
import eac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import mj;
import mp;
import nc;
import os;
import pc;
import wc;
import wd;
import wg;
import wh;
import zj;

// Referenced classes of package com.google.android.apps.youtube.kids.activities:
//            ParentalControlActivity, NewVersionAvailableActivity

public class BrowseActivity extends zj
    implements mj
{

    private aen k;
    private ImageView l;
    private FrameLayout m;
    private HeaderTileGridLayout n;
    private ParentalControlLaunchBar o;
    private long p;
    private boolean q;
    private boolean r;
    private boolean s;
    private blu t;
    private BitmapDrawable u;
    private wg v;
    private KidsApplication w;
    private bvy x;
    private BroadcastReceiver y;

    public BrowseActivity()
    {
        y = new wc(this);
    }

    private Drawable a(bql bql1)
    {
        if (bql1.a.b.a == 26)
        {
            return getResources().getDrawable(0x7f020270);
        }
        if (bql1.a.b.a == 27)
        {
            return getResources().getDrawable(0x7f020260);
        }
        if (bql1.a.b.a == 21)
        {
            return getResources().getDrawable(0x7f020261);
        }
        if (bql1.a.b.a == 32)
        {
            return getResources().getDrawable(0x7f020266);
        }
        if (bql1.a.b.a == 33)
        {
            return getResources().getDrawable(0x7f020252);
        }
        if (bql1.a.b.a != 14)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        bql1 = getResources().getDrawable(0x7f020257);
        return bql1;
        bql1;
        return null;
        bql1;
        return null;
    }

    private void a(int i)
    {
        p();
        a(i, true);
        if (!q && l.getDrawable() != null)
        {
            ((TextView)findViewById(0x7f100138)).setTextColor(-1);
            ((Button)findViewById(0x7f100139)).setTextColor(Color.parseColor("#e6ffffff"));
        }
    }

    private void a(bqv bqv1)
    {
        if (o() && (!r || !q))
        {
            return;
        }
        x = new bvy(e().f(), v.c);
        this.i.a(x, bwa.b, null);
        this.i.a(x, bqv1, null);
        r = false;
        p = System.currentTimeMillis();
        p();
        t = j();
        Object obj = bqv1.d();
        if (bqv1.a.b != null)
        {
            a(new btk(bqv1.a.b.a), false);
        }
        btk btk1 = bqv1.c();
        if (btk1 != null)
        {
            a(btk1, true);
        }
        if (obj instanceof bqx)
        {
            aer aer1 = new aer(this, t, this.i, this);
            bqv1 = n;
            obj = aer1.a(null, (bqx)obj);
            ((HeaderTileGridLayout) (bqv1)).b.removeAllViews();
            ((HeaderTileGridLayout) (bqv1)).b.setVisibility(0);
            ((HeaderTileGridLayout) (bqv1)).b.addView(((View) (obj)));
        } else
        {
            Object obj1 = n;
            ((HeaderTileGridLayout) (obj1)).b.removeAllViews();
            ((HeaderTileGridLayout) (obj1)).a.a();
            ((HeaderTileGridLayout) (obj1)).g.setX(0.0F);
            ((HeaderTileGridLayout) (obj1)).c.clear();
            ((HeaderTileGridLayout) (obj1)).d.clear();
            ((HeaderTileGridLayout) (obj1)).e.clear();
            obj1.h = -1;
            obj1.i = -1;
            obj1.j = null;
            if (bqv1.b == null)
            {
                bqv1.b = new ArrayList();
                obj1 = bqv1.a.a;
                if (obj1 != null)
                {
                    obj1 = ((dfy) (obj1)).c;
                    if (obj1 != null)
                    {
                        ddo addo[] = ((dos) (obj1)).a;
                        int i1 = addo.length;
                        for (int i = 0; i < i1; i++)
                        {
                            ddo ddo1 = addo[i];
                            if (ddo1.b != null)
                            {
                                bqv1.b.add(new bql(ddo1.b));
                            }
                        }

                    }
                }
            }
            bqv1 = bqv1.b;
            addo = bqv1.iterator();
            int j = 0;
            do
            {
                if (!addo.hasNext())
                {
                    break;
                }
                bql bql1 = (bql)addo.next();
                if (bql1.a().c().size() != 0)
                {
                    afi afi1 = new afi(this, bql1);
                    HeaderTileGridLayout headertilegridlayout = n;
                    String s1 = bql1.a.a;
                    Drawable drawable = a(bql1);
                    if (headertilegridlayout.b.getVisibility() != 0)
                    {
                        headertilegridlayout.b.setVisibility(0);
                    }
                    j = headertilegridlayout.a.d.getCount() - 1;
                    afi1.setOnClickListener(new afl(headertilegridlayout, afi1, j));
                    afi1.setContentDescription(s1);
                    android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
                    layoutparams.setMargins(0, 0, 0, headertilegridlayout.getResources().getDimensionPixelSize(0x7f0a0130));
                    headertilegridlayout.b.addView(afi1, layoutparams);
                    headertilegridlayout.c.add(Pair.create(Integer.valueOf(j), afi1));
                    headertilegridlayout.d.add(Pair.create(Integer.valueOf(j), drawable));
                    headertilegridlayout.e.add(Pair.create(Integer.valueOf(j), s1));
                    a(bql1.a(), true);
                    j = 1;
                }
            } while (true);
            n.a(0, false);
            n.a(0);
            k.a();
            if (bqv1.size() > 0 && j == 0)
            {
                a(0x7f0b00ec, true);
                return;
            }
        }
        m();
        bqv1 = w;
        obj = ((nc) (bqv1)).a.i();
        if (q && !a.e(bqv1) && ((SharedPreferences) (obj)).getBoolean("isFirstLaunchEver", true))
        {
            ((SharedPreferences) (obj)).edit().putBoolean("isFirstLaunchEver", false).apply();
            startActivity(ParentalControlActivity.a(this));
        }
        g.c(true);
    }

    public static void a(BrowseActivity browseactivity, String s1)
    {
        browseactivity.b(s1);
    }

    public static boolean a(BrowseActivity browseactivity)
    {
        return browseactivity.n();
    }

    public static boolean a(BrowseActivity browseactivity, boolean flag)
    {
        browseactivity.r = true;
        return true;
    }

    public static wg b(BrowseActivity browseactivity)
    {
        return browseactivity.v;
    }

    private void b(String s1)
    {
        l();
        v.a(s1);
    }

    private boolean n()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnectedOrConnecting();
    }

    private boolean o()
    {
        return p > System.currentTimeMillis() - 0x493e0L;
    }

    private void p()
    {
        if (!s)
        {
            s = true;
            LayoutInflater layoutinflater = LayoutInflater.from(this);
            int i;
            if (q)
            {
                i = 0x7f040037;
            } else
            {
                i = 0x7f040021;
            }
            layoutinflater.inflate(i, (ViewGroup)findViewById(0x7f1000b8));
            a();
        }
    }

    private static ColorFilter q()
    {
        ColorMatrix colormatrix = new ColorMatrix();
        colormatrix.setSaturation(0.7F);
        bmd.a(colormatrix, 0.7F);
        return new ColorMatrixColorFilter(colormatrix);
    }

    public final volatile void a(Object obj)
    {
        a((bqv)obj);
    }

    public final void a(mp mp)
    {
        g.c(false);
        a(0x7f0b018a);
    }

    public final bvy h()
    {
        return x;
    }

    public void onCreate(Bundle bundle)
    {
        setContentView(0x7f04001f);
        super.onCreate(bundle);
        o = (ParentalControlLaunchBar)findViewById(0x7f1000b9);
        m = (FrameLayout)findViewById(0x7f1000b5);
        n = (HeaderTileGridLayout)findViewById(0x7f1000b7);
        l = (ImageView)findViewById(0x7f1000b1);
        a(new wd(this));
        super.j = n.a;
        k = new aen(l);
        Object obj = n;
        obj.k = k;
        bundle = ((HeaderTileGridLayout) (obj)).a;
        obj = ((HeaderTileGridLayout) (obj)).k;
        ((ScrollingSectionListGridView) (bundle)).e.b = ((afx) (obj));
        bundle = n;
        obj = m;
        TextView textview = (TextView)findViewById(0x7f1000b6);
        bundle.g = ((View) (obj));
        bundle.f = textview;
        v = new wg(c().E(), this);
        bundle = v;
        bundle.getClass();
        a(new wh(bundle));
        q = v.a(getIntent()).equals("FEkids_home");
        w = (KidsApplication)getApplication();
        bundle = (bqv)w.f.getAndSet(null);
        if (bundle != null)
        {
            a(bundle);
        }
        r = false;
        bw.a(this).a(y, new IntentFilter("refresh_browse_activity_intent"));
    }

    public void onDestroy()
    {
        bw.a(this).a(y);
        super.onDestroy();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        bundle = (Bitmap)bundle.getParcelable("channelBackgroundBitmap");
        if (bundle != null)
        {
            u = new BitmapDrawable(l.getResources(), bundle);
            u.setColorFilter(q());
        }
    }

    public void onResume()
    {
        super.onResume();
        KidsApplication kidsapplication = (KidsApplication)getApplication();
        Object obj;
        if (q)
        {
            obj = kidsapplication.h().O();
            ((acm) (obj)).b(((nc) (kidsapplication)).a.i());
            bri bri1 = ((os) (obj)).a.a;
            int i;
            long l1;
            if (bri1.a() && bri1.a.a.b != null && bri1.a.a.b.b)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                i = 1;
            } else
            {
                long l2 = ((acm) (obj)).x().longValue();
                obj = ((os) (obj)).a.a;
                long l3;
                long l4;
                if (((bri) (obj)).a() && ((bri) (obj)).a.a.b != null && ((bri) (obj)).a.a.b.a)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                l3 = System.currentTimeMillis();
                l4 = ((nc) (kidsapplication)).a.i().getLong("UPGRADE_PROMT_SHOWN_MILLIS", 0L);
                if (i != 0 && l3 - l4 > l2)
                {
                    i = 2;
                } else
                {
                    i = 3;
                }
            }
            obj = NewVersionAvailableActivity.a(this, i);
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            l1 = System.currentTimeMillis();
            ((nc) (kidsapplication)).a.i().edit().putLong("UPGRADE_PROMT_SHOWN_MILLIS", l1).apply();
            startActivity(((Intent) (obj)));
        } else
        {
            if (!q)
            {
                if (u == null)
                {
                    KidsApplication kidsapplication1 = (KidsApplication)getApplicationContext();
                    obj = kidsapplication1.e;
                    kidsapplication1.e = null;
                    if (obj == null)
                    {
                        obj = null;
                    } else
                    {
                        int j1 = ((Bitmap) (obj)).getWidth();
                        int k1 = ((Bitmap) (obj)).getHeight();
                        int j;
                        int i1;
                        if (j1 > k1)
                        {
                            j = j1;
                            i1 = 1;
                        } else
                        {
                            j = k1;
                            i1 = 1;
                        }
                        for (; j / 2 > 400; j /= 2)
                        {
                            i1 <<= 1;
                        }

                        if (i1 > 1)
                        {
                            obj = Bitmap.createScaledBitmap(((Bitmap) (obj)), j1 / i1, k1 / i1, false);
                        }
                        obj = new blv(l.getContext(), ((Bitmap) (obj)), 10);
                        ((blv) (obj)).setColorFilter(q());
                    }
                    u = ((BitmapDrawable) (obj));
                }
                if (u != null)
                {
                    l.setImageDrawable(u);
                }
                o.a();
            }
            if (!o() || r && q)
            {
                if (n())
                {
                    v.b(getIntent());
                    b(v.a(getIntent()));
                } else
                {
                    a(0x7f0b00ef);
                    g.c(false);
                }
            } else
            {
                g.c(true);
            }
        }
        a();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (u != null)
        {
            bundle.putParcelable("channelBackgroundBitmap", u.getBitmap());
        }
    }

    public void onStart()
    {
        super.onStart();
        if (!a.e(this))
        {
            ((pc)c().r.b_()).a(getIntent().getData());
        }
    }
}
