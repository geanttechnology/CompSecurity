// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.client.p;
import com.google.android.gms.ads.internal.client.v;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.purchase.k;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.ay;
import com.google.android.gms.d.bb;
import com.google.android.gms.d.bi;
import com.google.android.gms.d.bs;
import com.google.android.gms.d.bt;
import com.google.android.gms.d.dh;
import com.google.android.gms.d.dv;
import com.google.android.gms.d.ea;
import com.google.android.gms.d.em;
import com.google.android.gms.d.eq;
import com.google.android.gms.d.gb;
import com.google.android.gms.d.gc;
import com.google.android.gms.d.gd;
import com.google.android.gms.d.gg;
import com.google.android.gms.d.gi;
import com.google.android.gms.d.go;
import com.google.android.gms.d.gu;
import com.google.android.gms.d.gw;
import com.google.android.gms.d.he;
import com.google.android.gms.d.hf;
import com.google.android.gms.d.id;
import com.google.android.gms.d.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.google.android.gms.ads.internal:
//            p, h

public final class q
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.ViewTreeObserver.OnScrollChangedListener
{
    public static final class a extends ViewSwitcher
    {

        final go a;
        final gw b;

        protected final void onAttachedToWindow()
        {
            super.onAttachedToWindow();
            if (b != null)
            {
                b.c();
            }
        }

        protected final void onDetachedFromWindow()
        {
            super.onDetachedFromWindow();
            if (b != null)
            {
                b.d();
            }
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionevent)
        {
            a.a(motionevent);
            return false;
        }

        public final void removeAllViews()
        {
            Object obj = new ArrayList();
            for (int i1 = 0; i1 < getChildCount(); i1++)
            {
                View view = getChildAt(i1);
                if (view != null && (view instanceof he))
                {
                    ((List) (obj)).add((he)view);
                }
            }

            super.removeAllViews();
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((he)((Iterator) (obj)).next()).destroy()) { }
        }

        public a(Context context, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener, android.view.ViewTreeObserver.OnScrollChangedListener onscrollchangedlistener)
        {
            super(context);
            a = new go(context);
            if (context instanceof Activity)
            {
                b = new gw((Activity)context, ongloballayoutlistener, onscrollchangedlistener);
                b.a();
                return;
            } else
            {
                b = null;
                return;
            }
        }
    }


    public gg A;
    View B;
    public int C;
    boolean D;
    boolean E;
    HashSet F;
    private int G;
    private int H;
    private gu I;
    final String a;
    public String b;
    public final Context c;
    final o d;
    public final VersionInfoParcel e;
    a f;
    public gi g;
    public gi h;
    public AdSizeParcel i;
    public gb j;
    public com.google.android.gms.d.gb.a k;
    public gc l;
    com.google.android.gms.ads.internal.client.o m;
    p n;
    v o;
    w p;
    em q;
    eq r;
    bs s;
    bt t;
    id u;
    id v;
    NativeAdOptionsParcel w;
    bi x;
    List y;
    k z;

    public q(Context context, AdSizeParcel adsizeparcel, String s1, VersionInfoParcel versioninfoparcel)
    {
        this(context, adsizeparcel, s1, versioninfoparcel, (byte)0);
    }

    private q(Context context, AdSizeParcel adsizeparcel, String s1, VersionInfoParcel versioninfoparcel, byte byte0)
    {
        A = null;
        B = null;
        C = 0;
        D = false;
        E = false;
        F = null;
        G = -1;
        H = -1;
        ay.a(context);
        if (com.google.android.gms.ads.internal.p.h().c() != null)
        {
            List list = ay.a();
            if (versioninfoparcel.c != 0)
            {
                list.add(Integer.toString(versioninfoparcel.c));
            }
            bb bb1 = com.google.android.gms.ads.internal.p.h().c();
            if (!list.isEmpty())
            {
                bb1.c.put("e", TextUtils.join(",", list));
            }
        }
        a = UUID.randomUUID().toString();
        if (adsizeparcel.e || adsizeparcel.i)
        {
            f = null;
        } else
        {
            f = new a(context, this, this);
            f.setMinimumWidth(adsizeparcel.g);
            f.setMinimumHeight(adsizeparcel.d);
            f.setVisibility(4);
        }
        i = adsizeparcel;
        b = s1;
        c = context;
        e = versioninfoparcel;
        d = new o(new h(this));
        I = new gu(200L);
        v = new id();
    }

    private void b(boolean flag)
    {
        int i1;
        i1 = 1;
        break MISSING_BLOCK_LABEL_3;
        Object obj1;
        obj = ((dv) (obj1)).j;
        obj;
        JVM INSTR monitorenter ;
        obj1.d = j1;
        obj1.e = k1;
        if (((dv) (obj1)).q == null || i1 == 0)
        {
            break MISSING_BLOCK_LABEL_299;
        }
        ai1 = ((dv) (obj1)).a();
        if (ai1 == null)
        {
            break MISSING_BLOCK_LABEL_313;
        }
        popupwindow = ((dv) (obj1)).q;
        com.google.android.gms.ads.internal.client.m.a();
        i1 = com.google.android.gms.ads.internal.util.client.a.a(((dv) (obj1)).l, ai1[0]);
        com.google.android.gms.ads.internal.client.m.a();
        popupwindow.update(i1, com.google.android.gms.ads.internal.util.client.a.a(((dv) (obj1)).l, ai1[1]), ((dv) (obj1)).q.getWidth(), ((dv) (obj1)).q.getHeight());
        ((dv) (obj1)).a(ai1[0], ai1[1]);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        ((dv) (obj1)).a(true);
          goto _L1
    }

    public final void a()
    {
        if (j != null && j.b != null)
        {
            j.b.destroy();
        }
    }

    public final void a(boolean flag)
    {
        if (C == 0 && j != null && j.b != null)
        {
            j.b.stopLoading();
        }
        if (g != null)
        {
            g.f();
        }
        if (h != null)
        {
            h.f();
        }
        if (flag)
        {
            j = null;
        }
    }

    public final void b()
    {
        if (j == null || j.m == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        j.m.c();
        return;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        return;
    }

    public final boolean c()
    {
        return C == 0;
    }

    public final void onGlobalLayout()
    {
        b(false);
    }

    public final void onScrollChanged()
    {
        b(true);
    }
}
