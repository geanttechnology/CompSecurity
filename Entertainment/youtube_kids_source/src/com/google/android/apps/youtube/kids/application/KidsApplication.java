// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.application;

import a;
import aaa;
import aca;
import acc;
import acr;
import ahs;
import ajl;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import bfj;
import bgv;
import bje;
import ble;
import blf;
import bli;
import bmf;
import bmj;
import bml;
import bmr;
import bqb;
import bri;
import btl;
import bye;
import cgk;
import chr;
import cnq;
import crh;
import czk;
import din;
import dlh;
import dvt;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import mh;
import nc;
import nd;
import os;
import qb;

public class KidsApplication extends nc
{

    public acr d;
    public Bitmap e;
    public AtomicReference f;

    public KidsApplication()
    {
    }

    public static boolean a(SharedPreferences sharedpreferences, int j)
    {
        boolean flag1 = false;
        sharedpreferences = bye.a(sharedpreferences);
        int l = sharedpreferences.length;
        int k = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (k < l)
                {
                    if (sharedpreferences[k] != j)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            k++;
        } while (true);
    }

    public final nd a()
    {
        return (aaa)super.a();
    }

    protected final nd b()
    {
        return new aaa(this, super.a, super.b);
    }

    protected final cnq e()
    {
        return new aca(this, super.a);
    }

    protected final void f()
    {
        aaa aaa1;
        Object obj;
        Object obj1;
        blf blf1;
        TimeUnit timeunit;
        bri bri1;
        super.f();
        new acc(getPackageName());
        obj = super.a;
        obj1 = ((bgv) (obj)).i();
        if (super.c)
        {
            ((SharedPreferences) (obj1)).edit().remove("com.google.android.libraries.youtube.innertube.pref.inner_tube_config").remove("com.google.android.libraries.youtube.innertube.pref.inner_tube_config_last_sync_timestamp").apply();
        }
        ((bgv) (obj)).e().a(null);
        d = new acr(this);
        aaa1 = (aaa)super.a();
        aaa1.D().a(bfj.b);
        aaa1.D().a(qb.b);
        aaa1.a().a();
        aaa1.G().a();
        if (i())
        {
            aaa1.n = new ahs(aaa1.a, aaa1.c, aaa1, null, aaa1.e, cgk.a);
            ahs ahs1 = aaa1.n;
            btl btl1 = ahs1.c.v();
            String s = ahs1.b.n();
            bml bml1 = ahs1.b.e();
            boolean flag = btl1.a;
            boolean flag1 = btl1.a;
            a.o = s;
            a.p = bml1;
            a.q = flag;
            a.r = flag1;
            ahs1.e = new chr(ahs1.a, ahs1.c);
        }
        aaa1.R();
        blf1 = ((bgv) (obj)).j();
        obj1 = new ble(((SharedPreferences) (obj1)), aaa1.S(), ((bgv) (obj)).b());
        blf1.b.put(((ble) (obj1)).a(), obj1);
        timeunit = TimeUnit.SECONDS;
        bri1 = ((os) (aaa1.O())).a.a;
        if (bri1.a != null && bri1.a.a != null && bri1.a.a.a != null) goto _L2; else goto _L1
_L1:
        int j = 0x15180;
_L4:
        obj1 = ((ble) (obj1)).a(timeunit.toMillis(j));
        blf1.e.execute(new bli(blf1, ((amv) (obj1))));
        obj = ((bgv) (obj)).d();
        ((bje) (obj)).a(aaa1.H());
        ((bje) (obj)).a(aaa1.K());
        ((bje) (obj)).a(aaa1.w());
        ((bje) (obj)).a((czk)aaa1.O.b_());
        ((bje) (obj)).a(aaa1.L());
        if (i())
        {
            aaa1.n.k().a = aaa1.H();
        }
        f = new AtomicReference();
        return;
_L2:
        int k = bri1.a.a.a.a;
        j = k;
        if (k <= 0)
        {
            j = 0x15180;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final bmf g()
    {
        return (aaa)super.a();
    }

    public final aaa h()
    {
        return (aaa)super.a();
    }

    public final boolean i()
    {
        return a(PreferenceManager.getDefaultSharedPreferences(this), 0xdc1fe);
    }
}
