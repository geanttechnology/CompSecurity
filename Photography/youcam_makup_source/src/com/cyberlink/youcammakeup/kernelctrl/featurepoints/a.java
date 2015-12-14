// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.featurepoints;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.cyberlink.youcammakeup.jniproxy.aa;
import com.cyberlink.youcammakeup.jniproxy.ah;
import com.cyberlink.youcammakeup.jniproxy.ai;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.aj;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ak;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.featurepoints:
//            b

public class a
{

    private static float a(PanZoomViewer panzoomviewer, RectF rectf, float f)
    {
        return f / rectf.width();
    }

    public static b a(PanZoomViewer panzoomviewer, FeaturePointsDef.FeatureSets featuresets, FeaturePointsDef.FeaturePoints featurepoints)
    {
        panzoomviewer.n();
        q q1 = panzoomviewer.getInfo();
        RectF rectf = (RectF)q1.m.get(featurepoints);
        featurepoints = rectf;
        if (rectf == null)
        {
            featurepoints = new ArrayList();
            featurepoints.add(q1.i.get(q1.j));
            ar ar1 = (ar)VenusHelper.a(q1.b, q1.c, featurepoints, q1.d).get(0);
            featurepoints = new RectF(ar1.b.b(), ar1.b.c(), ar1.b.d(), ar1.b.e());
            if (!featurepoints.contains(ar1.c.l().b().b(), ar1.c.l().b().c()))
            {
                featurepoints.bottom = ar1.c.l().b().c();
            }
        }
        float f = (float)(panzoomviewer.getWidth() * 4) / 5F;
        if (featuresets == FeaturePointsDef.FeatureSets.d || featuresets == FeaturePointsDef.FeatureSets.g || featuresets == FeaturePointsDef.FeatureSets.k)
        {
            f = (float)panzoomviewer.getWidth() / 3F;
        }
        if (featuresets == FeaturePointsDef.FeatureSets.f)
        {
            f = (float)panzoomviewer.getWidth() / 3F;
        }
        a(panzoomviewer, q1, ((RectF) (featurepoints)), Math.min(a(panzoomviewer, ((RectF) (featurepoints)), f), q1.q.b));
        panzoomviewer = new float[9];
        q1.q.e.getValues(panzoomviewer);
        f = panzoomviewer[0];
        return new b(new PointF(Math.abs(panzoomviewer[2]), Math.abs(panzoomviewer[5])), f);
    }

    public static void a(PanZoomViewer panzoomviewer, b b1)
    {
        panzoomviewer.a((new ak()).a(aj.b).b(b1.a).a(-1F).b(b1.b).a(true).b(true).a(300L).a(), null);
    }

    private static void a(PanZoomViewer panzoomviewer, q q1, RectF rectf, float f)
    {
        float f1 = rectf.left;
        float f2 = rectf.width() / 2.0F;
        float f3 = rectf.top;
        float f4 = rectf.height() / 2.0F;
        panzoomviewer.a((new ak()).a(aj.b).b(new PointF(f1 + f2, f3 + f4)).a(-1F).b(f).a(true).b(true).a(300L).a(), null);
    }
}
