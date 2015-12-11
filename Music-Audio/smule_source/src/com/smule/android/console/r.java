// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import android.util.DisplayMetrics;
import android.view.Display;
import com.smule.android.f.a;
import com.smule.android.h;

// Referenced classes of package com.smule.android.console:
//            a, p

public class r
{

    public static void a(Display display, p p1)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        p1.b((new StringBuilder()).append(com.smule.android.console.a.a(h.display_height)).append(": ").append(com.smule.android.f.a.b(display)).toString());
        p1.b((new StringBuilder()).append(com.smule.android.console.a.a(h.display_width)).append(": ").append(com.smule.android.f.a.a(display)).toString());
        p1.b((new StringBuilder()).append(com.smule.android.console.a.a(h.metrics_density)).append(": ").append(displaymetrics.density).toString());
        p1.b((new StringBuilder()).append(com.smule.android.console.a.a(h.metrics_densityDpi)).append(": ").append(displaymetrics.densityDpi).toString());
        p1.b((new StringBuilder()).append(com.smule.android.console.a.a(h.metrics_scaledDensity)).append(": ").append(displaymetrics.scaledDensity).toString());
        p1.b((new StringBuilder()).append(com.smule.android.console.a.a(h.metrics_heightPixels)).append(": ").append(displaymetrics.heightPixels).toString());
        p1.b((new StringBuilder()).append(com.smule.android.console.a.a(h.metrics_widthPixels)).append(": ").append(displaymetrics.widthPixels).toString());
        p1.b((new StringBuilder()).append(com.smule.android.console.a.a(h.metrics_xdpi)).append(": ").append(displaymetrics.xdpi).toString());
        p1.b((new StringBuilder()).append(com.smule.android.console.a.a(h.metrics_ydpi)).append(": ").append(displaymetrics.ydpi).toString());
    }
}
