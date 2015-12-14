// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.panzoomview;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;

// Referenced classes of package w.panzoomview:
//            BaseImageView, f

public class b
{

    public int a;
    public int b;
    public UIImageOrientation c;
    public int d;
    public int e;
    public boolean f;
    public float g;
    public float h;
    public float i;
    public Matrix j;
    public f k;
    public RectF l;
    final BaseImageView m;

    public b(BaseImageView baseimageview)
    {
        m = baseimageview;
        super();
        a = -1;
        b = -1;
        c = UIImageOrientation.b;
        d = -1;
        e = -1;
        f = false;
        g = m.a;
        h = -1F;
        i = -1F;
        j = null;
        k = null;
        l = null;
    }

    public b(BaseImageView baseimageview, b b1)
    {
        m = baseimageview;
        super();
        a = -1;
        b = -1;
        c = UIImageOrientation.b;
        d = -1;
        e = -1;
        f = false;
        g = m.a;
        h = -1F;
        i = -1F;
        j = null;
        k = null;
        l = null;
        a = b1.a;
        b = b1.b;
        c = b1.c;
        d = b1.d;
        e = b1.e;
        f = b1.f;
        g = b1.g;
        h = b1.h;
        i = b1.i;
        j = new Matrix(b1.j);
        k = new f(b1.k);
        l = new RectF(b1.l);
    }
}
