// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.graphics.Matrix;
import android.graphics.RectF;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            q, ImageViewer, w

public class t
{

    public boolean a;
    public float b;
    public float c;
    public float d;
    public Matrix e;
    public w f;
    public RectF g;
    final q h;

    public t(q q1)
    {
        h = q1;
        super();
        a = false;
        b = h.t.d;
        c = -1F;
        d = -1F;
        e = null;
        f = null;
        g = null;
    }

    public t(q q1, t t1)
    {
        h = q1;
        super();
        a = false;
        b = h.t.d;
        c = -1F;
        d = -1F;
        e = null;
        f = null;
        g = null;
        a = t1.a;
        b = t1.b;
        c = t1.c;
        d = t1.d;
        e = new Matrix(t1.e);
        f = null;
        if (t1.f != null)
        {
            f = new w(t1.f.a(), t1.f.b(), t1.f.c(), t1.f.d(), t1.f.e());
        }
    }
}
