// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.jniproxy.aa;
import com.cyberlink.youcammakeup.jniproxy.ab;
import com.cyberlink.youcammakeup.jniproxy.ac;
import com.cyberlink.youcammakeup.jniproxy.ad;
import com.cyberlink.youcammakeup.jniproxy.af;
import com.cyberlink.youcammakeup.jniproxy.ag;
import com.cyberlink.youcammakeup.jniproxy.ah;
import com.cyberlink.youcammakeup.jniproxy.ak;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.jniproxy.z;
import com.pf.common.utility.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel:
//            d, b, c, FPSampleController

public class FeaturePointGuideView extends ImageView
{

    private boolean A;
    private Pair B;
    private Canvas C;
    private Bitmap D;
    private RectF E;
    private FPSampleController F;
    private int G;
    private android.animation.ValueAnimator.AnimatorUpdateListener H = new android.animation.ValueAnimator.AnimatorUpdateListener() {

        final FeaturePointGuideView a;

        public void onAnimationUpdate(ValueAnimator valueanimator)
        {
            float f1 = valueanimator.getAnimatedFraction();
            FeaturePointGuideView.a(a).left = (int)((float)(FeaturePointGuideView.b(a).left - FeaturePointGuideView.c(a).left) * f1 + (float)FeaturePointGuideView.c(a).left);
            FeaturePointGuideView.a(a).top = (int)((float)(FeaturePointGuideView.b(a).top - FeaturePointGuideView.c(a).top) * f1 + (float)FeaturePointGuideView.c(a).top);
            FeaturePointGuideView.a(a).right = (int)((float)(FeaturePointGuideView.b(a).right - FeaturePointGuideView.c(a).right) * f1 + (float)FeaturePointGuideView.c(a).right);
            FeaturePointGuideView.a(a).bottom = (int)(f1 * (float)(FeaturePointGuideView.b(a).bottom - FeaturePointGuideView.c(a).bottom) + (float)FeaturePointGuideView.c(a).bottom);
            if (FeaturePointGuideView.a(a).left < 0)
            {
                FeaturePointGuideView.a(a).right = FeaturePointGuideView.a(a).right - FeaturePointGuideView.a(a).left;
                FeaturePointGuideView.a(a).left = 0;
            } else
            if (FeaturePointGuideView.a(a).right > FeaturePointGuideView.d(a).right)
            {
                FeaturePointGuideView.a(a).left = FeaturePointGuideView.a(a).left - (FeaturePointGuideView.a(a).right - FeaturePointGuideView.d(a).right);
                FeaturePointGuideView.a(a).right = FeaturePointGuideView.d(a).right;
            }
            if (FeaturePointGuideView.a(a).top < 0)
            {
                FeaturePointGuideView.a(a).bottom = FeaturePointGuideView.a(a).bottom - FeaturePointGuideView.a(a).top;
                FeaturePointGuideView.a(a).top = 0;
            } else
            if (FeaturePointGuideView.a(a).bottom > FeaturePointGuideView.d(a).bottom)
            {
                FeaturePointGuideView.a(a).top = FeaturePointGuideView.a(a).top - (FeaturePointGuideView.a(a).bottom - FeaturePointGuideView.d(a).bottom);
                FeaturePointGuideView.a(a).bottom = FeaturePointGuideView.d(a).bottom;
            }
            a.invalidate();
        }

            
            {
                a = FeaturePointGuideView.this;
                super();
            }
    };
    private final int a;
    private final String b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Rect g;
    private Rect h;
    private Rect i;
    private Rect j;
    private RectF k;
    private RectF l;
    private com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints m;
    private Map n;
    private Pair o;
    private GestureDetector p;
    private Animation q;
    private Animation r;
    private ValueAnimator s;
    private Map t;
    private boolean u;
    private List v;
    private List w;
    private List x;
    private List y;
    private List z;

    public FeaturePointGuideView(Context context)
    {
        super(context);
        a = 200;
        b = "featurepointguide";
        p = null;
        G = 120;
        a(context);
    }

    public FeaturePointGuideView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 200;
        b = "featurepointguide";
        p = null;
        G = 120;
        a(context);
    }

    public FeaturePointGuideView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = 200;
        b = "featurepointguide";
        p = null;
        G = 120;
        a(context);
    }

    static Rect a(FeaturePointGuideView featurepointguideview)
    {
        return featurepointguideview.h;
    }

    private GuideSet a(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints)
    {
        Iterator iterator = t.entrySet().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        java.util.Map.Entry entry;
        d d1;
        entry = (java.util.Map.Entry)iterator.next();
        d1 = (d)entry.getValue();
        if (!d1.b.contains(featurepoints)) goto _L4; else goto _L3
_L3:
        a(true, d1.b);
        featurepoints = (GuideSet)entry.getKey();
_L6:
        if (featurepoints == null)
        {
            a(false, ((List) (null)));
        }
        return featurepoints;
_L2:
        featurepoints = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a(Context context)
    {
        i = new Rect();
        j = new Rect();
        g();
        s = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        s.setDuration(300L);
        s.addUpdateListener(H);
        p = new GestureDetector(context, new b(this));
        t = new HashMap();
        context = new d(this);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.T);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.U);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.V);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.b);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.c);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.d);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.e);
        a((PointF)n.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a), ((d) (context)).a);
        t.put(GuideSet.a, context);
        context = new d(this);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.P);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Q);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.R);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.g);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.h);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.i);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.j);
        a((PointF)n.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f), ((d) (context)).a);
        t.put(GuideSet.b, context);
        context = new d(this);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.k);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.l);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.m);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.n);
        a((PointF)n.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.k), ((d) (context)).a);
        t.put(GuideSet.c, context);
        context = new d(this);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.y);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.z);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.A);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.E);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.F);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.G);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.H);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.I);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.J);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.K);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.L);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.B);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.C);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.M);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.N);
        a((PointF)n.get(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.A), ((d) (context)).a);
        t.put(GuideSet.d, context);
        context = new d(this);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.p);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.q);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.r);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.s);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.t);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.v);
        ((d) (context)).b.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.x);
        t.put(GuideSet.e, context);
        v = new ArrayList();
        v.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.p);
        v.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.q);
        v.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.r);
        v.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.s);
        v.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.t);
        v.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.v);
        v.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.x);
        h();
    }

    private void a(PointF pointf, Rect rect)
    {
        rect.left = (int)(pointf.x - 200F);
        rect.top = (int)(pointf.y - 200F);
        rect.right = (int)(pointf.x + 200F);
        rect.bottom = (int)(pointf.y + 200F);
    }

    private void a(aa aa1)
    {
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.x, new PointF(aa1.b().b(), aa1.b().c()));
    }

    private void a(ab ab1, ab ab2)
    {
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.t, new PointF(ab1.b().b(), ab1.b().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.v, new PointF(ab2.b().b(), ab2.b().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.u, new PointF(ab1.c().b(), ab1.c().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.w, new PointF(ab2.c().b(), ab2.c().c()));
    }

    private void a(ac ac1, ac ac2)
    {
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a, new PointF(ac1.f().b(), ac1.f().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.b, new PointF(ac1.b().b(), ac1.b().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.c, new PointF(ac1.c().b(), ac1.c().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.d, new PointF(ac1.d().b(), ac1.d().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.e, new PointF(ac1.e().b(), ac1.e().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f, new PointF(ac2.f().b(), ac2.f().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.g, new PointF(ac2.b().b(), ac2.b().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.h, new PointF(ac2.c().b(), ac2.c().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.i, new PointF(ac2.d().b(), ac2.d().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.j, new PointF(ac2.e().b(), ac2.e().c()));
    }

    private void a(ad ad1)
    {
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Y, new PointF(ad1.c().b(), ad1.c().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.X, new PointF(ad1.b().b(), ad1.b().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Z, new PointF(ad1.d().b(), ad1.d().c()));
    }

    private void a(af af1)
    {
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.y, new PointF(af1.b().b(), af1.b().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.z, new PointF(af1.e().b(), af1.e().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.A, new PointF(af1.c().b(), af1.c().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.E, new PointF(af1.h().b(), af1.h().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.F, new PointF(af1.i().b(), af1.i().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.G, new PointF(af1.j().b(), af1.j().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.H, new PointF(af1.k().b(), af1.k().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.I, new PointF(af1.q().b(), af1.q().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.J, new PointF(af1.p().b(), af1.p().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.K, new PointF(af1.o().b(), af1.o().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.L, new PointF(af1.n().b(), af1.n().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.B, new PointF(af1.d().b(), af1.d().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.C, new PointF(af1.f().b(), af1.f().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.M, new PointF(af1.m().b(), af1.m().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.N, new PointF(af1.l().b(), af1.l().c()));
    }

    private void a(ag ag1)
    {
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.k, new PointF(ag1.c().b(), ag1.c().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.l, new PointF(ag1.d().b(), ag1.d().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.m, new PointF(ag1.e().b(), ag1.e().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.n, new PointF(ag1.b().b(), ag1.b().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.o, new PointF(ag1.f().b(), ag1.f().c()));
    }

    private void a(ak ak1, ak ak2)
    {
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.p, new PointF(ak1.b().b(), ak1.b().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.q, new PointF(ak1.c().b(), ak1.c().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.r, new PointF(ak2.b().b(), ak2.b().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.s, new PointF(ak2.c().b(), ak2.c().c()));
    }

    private void a(z z1, z z2)
    {
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.T, new PointF(z1.b().b(), z1.b().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.U, new PointF(z1.c().b(), z1.c().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.V, new PointF(z1.d().b(), z1.d().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.P, new PointF(z2.b().b(), z2.b().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Q, new PointF(z2.c().b(), z2.c().c()));
        n.put(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.R, new PointF(z2.d().b(), z2.d().c()));
    }

    private void a(boolean flag, List list)
    {
        Iterator iterator = ((Map)o.second).entrySet().iterator();
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            c c1 = (c)entry.getValue();
            boolean flag1;
            if (flag)
            {
                flag1 = list.contains(entry.getKey());
            } else
            {
                flag1 = true;
            }
            c1.c = flag1;
        }
    }

    static Rect b(FeaturePointGuideView featurepointguideview)
    {
        return featurepointguideview.j;
    }

    static Rect c(FeaturePointGuideView featurepointguideview)
    {
        return featurepointguideview.i;
    }

    static Rect d(FeaturePointGuideView featurepointguideview)
    {
        return featurepointguideview.g;
    }

    static RectF e(FeaturePointGuideView featurepointguideview)
    {
        return featurepointguideview.l;
    }

    static Animation f(FeaturePointGuideView featurepointguideview)
    {
        return featurepointguideview.q;
    }

    static FPSampleController g(FeaturePointGuideView featurepointguideview)
    {
        return featurepointguideview.F;
    }

    private void g()
    {
        n = new HashMap(40);
        y y1 = getPointsfromINI();
        a(y1.d(), y1.e());
        a(y1.f(), y1.g());
        a(y1.h(), y1.i());
        a(y1.j());
        a(y1.l());
        a(y1.m());
        a(y1.k());
        a(y1.b(), y1.c());
    }

    private y getPointsfromINI()
    {
        y y1;
        Object obj;
        obj = Globals.d().getAssets();
        if (obj == null)
        {
            com.pf.common.utility.m.e("FeaturePointGuideView", "getFeaturePointFromFile: Null Assets.");
        }
        y1 = new y();
        String as[] = ((AssetManager) (obj)).list("featurepointguide");
        if (as == null) goto _L2; else goto _L1
_L1:
        obj = new BufferedReader(new InputStreamReader(((AssetManager) (obj)).open((new StringBuilder()).append("featurepointguide").append(File.separator).append(as[0]).toString())));
        if (obj == null) goto _L2; else goto _L3
_L3:
        int i1 = 0;
        ac ac1;
        ac ac2;
        ab ab1;
        ab ab2;
        ak ak1;
        ak ak2;
        ag ag1;
        aa aa1;
        af af1;
        z z1;
        z z2;
        ad ad1;
        ah ah1;
        ac1 = new ac();
        ac2 = new ac();
        ab1 = new ab();
        ab2 = new ab();
        ak1 = new ak();
        ak2 = new ak();
        ag1 = new ag();
        aa1 = new aa();
        af1 = new af();
        z1 = new z();
        z2 = new z();
        ad1 = new ad();
        ah1 = new ah();
_L7:
        String s1 = ((BufferedReader) (obj)).readLine();
        if (s1 == null) goto _L5; else goto _L4
_L4:
        String as1[] = s1.split("=");
        if (as1.length <= 1) goto _L7; else goto _L6
_L6:
        float f1 = Float.parseFloat(as1[1]);
        if (i1 != 0) goto _L9; else goto _L8
_L8:
        try
        {
            ah1.a(f1);
            break MISSING_BLOCK_LABEL_2316;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
        }
          goto _L2
_L9:
        if (i1 != 1) goto _L11; else goto _L10
_L10:
        ah1.b(f1);
        z1.a(ah1);
        break MISSING_BLOCK_LABEL_2316;
_L2:
        return y1;
_L11:
        if (i1 != 2)
        {
            break MISSING_BLOCK_LABEL_307;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 3)
        {
            break MISSING_BLOCK_LABEL_329;
        }
        ah1.b(f1);
        z1.b(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 4)
        {
            break MISSING_BLOCK_LABEL_344;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 5)
        {
            break MISSING_BLOCK_LABEL_366;
        }
        ah1.b(f1);
        z1.c(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 6)
        {
            break MISSING_BLOCK_LABEL_382;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 7)
        {
            break MISSING_BLOCK_LABEL_405;
        }
        ah1.b(f1);
        z1.d(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 8)
        {
            break MISSING_BLOCK_LABEL_421;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 9)
        {
            break MISSING_BLOCK_LABEL_444;
        }
        ah1.b(f1);
        ac1.a(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 10)
        {
            break MISSING_BLOCK_LABEL_460;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 11)
        {
            break MISSING_BLOCK_LABEL_483;
        }
        ah1.b(f1);
        ac1.b(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 12)
        {
            break MISSING_BLOCK_LABEL_499;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 13)
        {
            break MISSING_BLOCK_LABEL_522;
        }
        ah1.b(f1);
        ac1.c(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 14)
        {
            break MISSING_BLOCK_LABEL_538;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 15)
        {
            break MISSING_BLOCK_LABEL_561;
        }
        ah1.b(f1);
        ac1.d(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 16)
        {
            break MISSING_BLOCK_LABEL_577;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 17)
        {
            break MISSING_BLOCK_LABEL_600;
        }
        ah1.b(f1);
        ac1.e(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 18)
        {
            break MISSING_BLOCK_LABEL_616;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 19)
        {
            break MISSING_BLOCK_LABEL_639;
        }
        ah1.b(f1);
        z2.a(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 20)
        {
            break MISSING_BLOCK_LABEL_655;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 21)
        {
            break MISSING_BLOCK_LABEL_678;
        }
        ah1.b(f1);
        z2.b(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 22)
        {
            break MISSING_BLOCK_LABEL_694;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 23)
        {
            break MISSING_BLOCK_LABEL_717;
        }
        ah1.b(f1);
        z2.c(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 24)
        {
            break MISSING_BLOCK_LABEL_733;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 25)
        {
            break MISSING_BLOCK_LABEL_756;
        }
        ah1.b(f1);
        z2.d(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 26)
        {
            break MISSING_BLOCK_LABEL_772;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 27)
        {
            break MISSING_BLOCK_LABEL_795;
        }
        ah1.b(f1);
        ac2.a(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 28)
        {
            break MISSING_BLOCK_LABEL_811;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 29)
        {
            break MISSING_BLOCK_LABEL_834;
        }
        ah1.b(f1);
        ac2.b(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 30)
        {
            break MISSING_BLOCK_LABEL_850;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 31)
        {
            break MISSING_BLOCK_LABEL_873;
        }
        ah1.b(f1);
        ac2.c(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 32)
        {
            break MISSING_BLOCK_LABEL_889;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 33)
        {
            break MISSING_BLOCK_LABEL_912;
        }
        ah1.b(f1);
        ac2.d(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 34)
        {
            break MISSING_BLOCK_LABEL_928;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 35)
        {
            break MISSING_BLOCK_LABEL_951;
        }
        ah1.b(f1);
        ac2.e(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 36)
        {
            break MISSING_BLOCK_LABEL_967;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 37)
        {
            break MISSING_BLOCK_LABEL_990;
        }
        ah1.b(f1);
        ag1.a(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 38)
        {
            break MISSING_BLOCK_LABEL_1006;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 39)
        {
            break MISSING_BLOCK_LABEL_1029;
        }
        ah1.b(f1);
        ag1.b(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 40)
        {
            break MISSING_BLOCK_LABEL_1045;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 41)
        {
            break MISSING_BLOCK_LABEL_1068;
        }
        ah1.b(f1);
        ag1.c(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 42)
        {
            break MISSING_BLOCK_LABEL_1084;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 43)
        {
            break MISSING_BLOCK_LABEL_1107;
        }
        ah1.b(f1);
        ag1.d(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 44)
        {
            break MISSING_BLOCK_LABEL_1123;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 45)
        {
            break MISSING_BLOCK_LABEL_1146;
        }
        ah1.b(f1);
        af1.a(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 46)
        {
            break MISSING_BLOCK_LABEL_1162;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 47)
        {
            break MISSING_BLOCK_LABEL_1185;
        }
        ah1.b(f1);
        af1.b(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 48)
        {
            break MISSING_BLOCK_LABEL_1201;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 49)
        {
            break MISSING_BLOCK_LABEL_1224;
        }
        ah1.b(f1);
        af1.c(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 50)
        {
            break MISSING_BLOCK_LABEL_1240;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 51)
        {
            break MISSING_BLOCK_LABEL_1263;
        }
        ah1.b(f1);
        af1.d(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 52)
        {
            break MISSING_BLOCK_LABEL_1279;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 53)
        {
            break MISSING_BLOCK_LABEL_1302;
        }
        ah1.b(f1);
        af1.e(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 54)
        {
            break MISSING_BLOCK_LABEL_1318;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 55)
        {
            break MISSING_BLOCK_LABEL_1341;
        }
        ah1.b(f1);
        af1.f(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 56)
        {
            break MISSING_BLOCK_LABEL_1357;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 57)
        {
            break MISSING_BLOCK_LABEL_1380;
        }
        ah1.b(f1);
        aa1.a(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 58)
        {
            break MISSING_BLOCK_LABEL_1396;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 59)
        {
            break MISSING_BLOCK_LABEL_1419;
        }
        ah1.b(f1);
        ab1.a(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 60)
        {
            break MISSING_BLOCK_LABEL_1435;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 61)
        {
            break MISSING_BLOCK_LABEL_1458;
        }
        ah1.b(f1);
        ab1.b(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 62)
        {
            break MISSING_BLOCK_LABEL_1474;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 63)
        {
            break MISSING_BLOCK_LABEL_1497;
        }
        ah1.b(f1);
        ak1.a(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 64)
        {
            break MISSING_BLOCK_LABEL_1513;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 65)
        {
            break MISSING_BLOCK_LABEL_1536;
        }
        ah1.b(f1);
        ak1.b(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 66)
        {
            break MISSING_BLOCK_LABEL_1552;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 67)
        {
            break MISSING_BLOCK_LABEL_1575;
        }
        ah1.b(f1);
        ab2.a(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 68)
        {
            break MISSING_BLOCK_LABEL_1591;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 69)
        {
            break MISSING_BLOCK_LABEL_1614;
        }
        ah1.b(f1);
        ab2.b(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 70)
        {
            break MISSING_BLOCK_LABEL_1630;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 71)
        {
            break MISSING_BLOCK_LABEL_1653;
        }
        ah1.b(f1);
        ak2.a(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 72)
        {
            break MISSING_BLOCK_LABEL_1669;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 73)
        {
            break MISSING_BLOCK_LABEL_1692;
        }
        ah1.b(f1);
        ak2.b(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 74)
        {
            break MISSING_BLOCK_LABEL_1708;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 75)
        {
            break MISSING_BLOCK_LABEL_1731;
        }
        ah1.b(f1);
        af1.h(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 76)
        {
            break MISSING_BLOCK_LABEL_1747;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 77)
        {
            break MISSING_BLOCK_LABEL_1770;
        }
        ah1.b(f1);
        af1.g(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 78)
        {
            break MISSING_BLOCK_LABEL_1786;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 79)
        {
            break MISSING_BLOCK_LABEL_1809;
        }
        ah1.b(f1);
        af1.j(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 80)
        {
            break MISSING_BLOCK_LABEL_1825;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 81)
        {
            break MISSING_BLOCK_LABEL_1848;
        }
        ah1.b(f1);
        af1.i(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 82)
        {
            break MISSING_BLOCK_LABEL_1864;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 83)
        {
            break MISSING_BLOCK_LABEL_1887;
        }
        ah1.b(f1);
        af1.l(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 84)
        {
            break MISSING_BLOCK_LABEL_1903;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 85)
        {
            break MISSING_BLOCK_LABEL_1926;
        }
        ah1.b(f1);
        af1.k(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 86)
        {
            break MISSING_BLOCK_LABEL_1942;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 87)
        {
            break MISSING_BLOCK_LABEL_1965;
        }
        ah1.b(f1);
        af1.m(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 88)
        {
            break MISSING_BLOCK_LABEL_1981;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 89)
        {
            break MISSING_BLOCK_LABEL_2004;
        }
        ah1.b(f1);
        af1.n(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 90)
        {
            break MISSING_BLOCK_LABEL_2020;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 91)
        {
            break MISSING_BLOCK_LABEL_2043;
        }
        ah1.b(f1);
        af1.o(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 92)
        {
            break MISSING_BLOCK_LABEL_2059;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 93)
        {
            break MISSING_BLOCK_LABEL_2082;
        }
        ah1.b(f1);
        af1.p(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 94)
        {
            break MISSING_BLOCK_LABEL_2098;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 95)
        {
            break MISSING_BLOCK_LABEL_2121;
        }
        ah1.b(f1);
        ag1.e(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 96)
        {
            break MISSING_BLOCK_LABEL_2137;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 97)
        {
            break MISSING_BLOCK_LABEL_2160;
        }
        ah1.b(f1);
        ad1.a(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 98)
        {
            break MISSING_BLOCK_LABEL_2176;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 99)
        {
            break MISSING_BLOCK_LABEL_2199;
        }
        ah1.b(f1);
        ad1.b(ah1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 100)
        {
            break MISSING_BLOCK_LABEL_2215;
        }
        ah1.a(f1);
        break MISSING_BLOCK_LABEL_2316;
        if (i1 != 101)
        {
            break MISSING_BLOCK_LABEL_2316;
        }
        ah1.b(f1);
        ad1.c(ah1);
        break MISSING_BLOCK_LABEL_2316;
_L5:
        y1.a(z1);
        y1.b(z2);
        y1.a(ac1);
        y1.b(ac2);
        y1.a(ab1);
        y1.b(ab2);
        y1.a(ak1);
        y1.b(ak2);
        y1.a(aa1);
        y1.a(af1);
        y1.a(ag1);
        y1.a(ad1);
        ((BufferedReader) (obj)).close();
        return y1;
        i1++;
          goto _L7
    }

    private void h()
    {
        w = new ArrayList();
        y = new ArrayList();
        x = new ArrayList();
        z = new ArrayList();
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.T);
        y.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.U);
        x.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.V);
        z.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.W);
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.P);
        y.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.Q);
        x.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.R);
        z.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.S);
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.b);
        y.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.c);
        x.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.d);
        z.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.e);
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.g);
        y.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.h);
        x.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.i);
        z.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.j);
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.t);
        y.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.t);
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.e);
        z.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.e);
        x.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.v);
        y.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.v);
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.n);
        y.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.k);
        x.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.l);
        z.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.m);
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.y);
        x.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.z);
        y.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.A);
        y.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.B);
        z.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.C);
        z.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.D);
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.E);
        x.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.F);
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.G);
        x.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.H);
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.N);
        x.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.M);
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.L);
        x.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.K);
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.J);
        x.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.I);
        z.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.x);
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.p);
        y.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.p);
        w.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.q);
        z.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.q);
        x.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.r);
        y.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.r);
        x.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.s);
        z.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.s);
    }

    public void a()
    {
        A = false;
        m = null;
        if (g != null)
        {
            j.set(g);
        }
        if (h != null)
        {
            i.set(h);
        }
        if (u)
        {
            a(((com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints) (null)));
            s.start();
        }
    }

    public void b()
    {
        startAnimation(r);
    }

    public void c()
    {
        startAnimation(q);
    }

    public void d()
    {
        if (u)
        {
            return;
        }
        c = BitmapFactory.decodeResource(getResources(), 0x7f0206c0);
        d = BitmapFactory.decodeResource(getResources(), 0x7f0206c1);
        e = BitmapFactory.decodeResource(getResources(), 0x7f0206c2);
        f = BitmapFactory.decodeResource(getResources(), 0x7f0206d2);
        ArrayList arraylist = new ArrayList();
        arraylist.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.a);
        arraylist.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.f);
        arraylist.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.B);
        arraylist.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.C);
        arraylist.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.M);
        arraylist.add(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.N);
        o = new Pair(new Rect(), new HashMap(n.size()));
        Iterator iterator = n.entrySet().iterator();
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            c c1 = new c(this);
            Bitmap bitmap;
            if (arraylist.contains(entry.getKey()))
            {
                bitmap = f;
            } else
            {
                bitmap = e;
            }
            c1.b = bitmap;
            ((Map)o.second).put(entry.getKey(), c1);
        }
        g = new Rect(G + 0, G + 0, c.getWidth() - G, c.getHeight() - G);
        h = new Rect(g);
        ((d)t.get(GuideSet.e)).a.set(g);
        u = true;
    }

    public void e()
    {
        com.cyberlink.youcammakeup.utility.aa.a(c);
        com.cyberlink.youcammakeup.utility.aa.a(d);
        com.cyberlink.youcammakeup.utility.aa.a(e);
        com.cyberlink.youcammakeup.utility.aa.a(f);
        com.cyberlink.youcammakeup.utility.aa.a(D);
        D = null;
        C = null;
        o = null;
        u = false;
    }

    public boolean f()
    {
        return u;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        float f3 = k.width() / (float)h.width();
        float f4 = k.height() / (float)h.height();
        float f2 = e.getWidth();
        float f1 = e.getHeight();
        Iterator iterator;
        boolean flag;
        if (A)
        {
            f2 = e.getWidth();
            float f5 = ((Float)B.first).floatValue();
            f1 = e.getHeight();
            f1 = ((Float)B.first).floatValue() * f1;
            f2 *= f5;
        } else
        {
            f1 *= f3;
            f2 *= f3;
        }
        if (D == null)
        {
            D = Bitmap.createBitmap((int)k.width(), (int)k.height(), android.graphics.Bitmap.Config.ARGB_8888);
        }
        if (C == null)
        {
            C = new Canvas(D);
        }
        if (E == null)
        {
            E = new RectF();
            E.left = 0.0F;
            E.top = 0.0F;
            E.right = k.width();
            E.bottom = k.height();
        }
        D.eraseColor(0);
        C.drawBitmap(c, h, E, null);
        if (!((Rect)o.first).equals(h))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        iterator = n.entrySet().iterator();
        while (iterator.hasNext()) 
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            c c1 = (c)((Map)o.second).get(((java.util.Map.Entry) (obj)).getKey());
            RectF rectf = c1.a;
            if (flag)
            {
                rectf.left = (((PointF)((java.util.Map.Entry) (obj)).getValue()).x - (float)h.left) * f3 - f2 / 2.0F;
                rectf.top = (((PointF)((java.util.Map.Entry) (obj)).getValue()).y - (float)h.top) * f4 - f1 / 2.0F;
                rectf.right = rectf.left + f2;
                rectf.bottom = rectf.top + f1;
            }
            if (A && ((java.util.Map.Entry) (obj)).getKey() == com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints.x && !k.contains(rectf))
            {
                float f6 = rectf.bottom;
                float f7 = k.bottom;
                rectf.top = rectf.top - (f6 - f7);
                rectf.bottom = k.bottom;
            }
            if (m == ((java.util.Map.Entry) (obj)).getKey())
            {
                obj = d;
            } else
            {
                obj = c1.b;
            }
            C.drawBitmap(((Bitmap) (obj)), null, rectf, null);
        }
        canvas.drawBitmap(D, null, k, null);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        float f1 = (float)getWidth() / 342F;
        k = new RectF();
        k.left = 9F * f1;
        k.top = 35F * f1;
        k.right = k.left + 270F * f1;
        k.bottom = k.top + 270F * f1;
        l = new RectF();
        l.left = 289F * f1;
        l.right = 342F * f1;
        l.top = 87F * f1;
        l.bottom = 256F * f1;
        Rect rect = ((d)t.get(GuideSet.a)).a;
        B = new Pair(Float.valueOf(k.width() / (float)rect.width()), Float.valueOf(k.height() / (float)rect.height()));
        q = new TranslateAnimation(0.0F, -(260F * f1), 0.0F, 0.0F);
        q.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final FeaturePointGuideView a;

            public void onAnimationEnd(Animation animation)
            {
                a.setVisibility(4);
                FeaturePointGuideView.g(a).b();
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                a = FeaturePointGuideView.this;
                super();
            }
        });
        q.setDuration(300L);
        r = new TranslateAnimation(-(260F * f1), 0.0F, 0.0F, 0.0F);
        r.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final FeaturePointGuideView a;

            public void onAnimationEnd(Animation animation)
            {
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
                a.setVisibility(0);
            }

            
            {
                a = FeaturePointGuideView.this;
                super();
            }
        });
        r.setDuration(300L);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return p.onTouchEvent(motionevent);
    }

    public void setControler(FPSampleController fpsamplecontroller)
    {
        F = fpsamplecontroller;
    }

    public void setFocusPoint(com.cyberlink.youcammakeup.kernelctrl.featurepoints.FeaturePointsDef.FeaturePoints featurepoints)
    {
        if (n.containsKey(featurepoints) && u)
        {
            m = featurepoints;
            A = false;
            if (true)
            {
                PointF pointf = (PointF)n.get(featurepoints);
                float f2 = 195F / 2.0F;
                float f1 = 195F / 2.0F;
                float f4 = 201F / 2.0F;
                float f3 = 201F / 2.0F;
                if (w.contains(featurepoints))
                {
                    f2 = 195F * 0.3F;
                    f1 = 195F - f2;
                } else
                if (x.contains(featurepoints))
                {
                    f1 = 195F * 0.3F;
                    f2 = 195F - f1;
                }
                if (y.contains(featurepoints))
                {
                    f4 = 201F * 0.3F;
                    f3 = 201F - f4;
                } else
                if (z.contains(featurepoints))
                {
                    f3 = 201F * 0.3F;
                    f4 = 201F - f3;
                }
                j.left = (int)(pointf.x - f2);
                j.top = (int)(pointf.y - f4);
                j.right = (int)(f1 + pointf.x);
                j.bottom = (int)(pointf.y + f3);
            } else
            {
                if (v.contains(featurepoints))
                {
                    A = true;
                }
                j.set(((d)t.get(null)).a);
            }
            i.set(h);
            s.start();
        }
    }

    private class GuideSet extends Enum
    {

        public static final GuideSet a;
        public static final GuideSet b;
        public static final GuideSet c;
        public static final GuideSet d;
        public static final GuideSet e;
        private static final GuideSet f[];

        public static GuideSet valueOf(String s1)
        {
            return (GuideSet)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/featurepoints/samplepanel/FeaturePointGuideView$GuideSet, s1);
        }

        public static GuideSet[] values()
        {
            return (GuideSet[])f.clone();
        }

        static 
        {
            a = new GuideSet("LeftEyeGuideSet", 0);
            b = new GuideSet("RightEyeGuideSet", 1);
            c = new GuideSet("NoseGuideSet", 2);
            d = new GuideSet("MouthGuideSet", 3);
            e = new GuideSet("ShapeGuideSet", 4);
            f = (new GuideSet[] {
                a, b, c, d, e
            });
        }

        private GuideSet(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
