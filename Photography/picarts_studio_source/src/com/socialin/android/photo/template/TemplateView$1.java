// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.graphics.Rect;
import android.os.Handler;
import java.util.ArrayList;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.template:
//            TemplateView, Template, TemplateImage, TemplateActivity

final class g
    implements Runnable
{

    private long a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private TemplateView h;

    public final void run()
    {
        float f1 = Math.min(180L, System.currentTimeMillis() - a);
        TemplateView.a(h, TemplateView.a(h) - 0.3F);
        int i = (int)((float)b * TemplateView.a(h));
        int k = (int)((float)c * TemplateView.a(h));
        int i1 = d + (b - i) / 2;
        int j1 = e + (c - k) / 2;
        TemplateView.b(h).set(i1, j1, i + i1, k + j1);
        h.invalidate();
        if (f1 < 180F && TemplateView.a(h) >= 0.0F)
        {
            TemplateView.c(h).post(this);
            return;
        }
        TemplateView templateview = h;
        i = f;
        k = g;
        TemplateImage templateimage = (TemplateImage)templateview.p.f.get(i);
        TemplateImage templateimage1 = (TemplateImage)templateview.p.f.get(k);
        if (templateimage.k != null)
        {
            if (templateview.s)
            {
                templateview.s = false;
                templateview.a();
            }
            android.graphics.Bitmap bitmap = templateimage.k;
            android.graphics.Bitmap bitmap1 = templateimage1.k;
            Object obj = templateimage.l;
            java.util.HashMap hashmap = templateimage.m;
            int j = templateimage.n;
            int l = templateimage.o;
            String s = templateimage.p;
            templateimage.m = templateimage1.m;
            templateimage.l = templateimage1.l;
            templateimage.n = templateimage1.n;
            templateimage.o = templateimage1.o;
            templateimage.j = null;
            templateimage.p = templateimage1.p;
            templateimage1.m = hashmap;
            templateimage1.l = ((String) (obj));
            templateimage1.n = j;
            templateimage1.o = l;
            templateimage1.j = null;
            templateimage1.p = s;
            obj = (TemplateActivity)templateview.getContext();
            m.a(((android.app.Activity) (obj)), ((TemplateActivity) (obj)).a);
            (new <init>(templateview, templateimage1, bitmap1, templateimage, bitmap, ((TemplateActivity) (obj)))).start();
        }
        TemplateView.d(h);
        TemplateView.e(h);
    }

    y(TemplateView templateview, long l, int i, int j, int k, int i1, 
            int j1, int k1)
    {
        h = templateview;
        a = l;
        b = i;
        c = j;
        d = k;
        e = i1;
        f = j1;
        g = k1;
        super();
    }
}
