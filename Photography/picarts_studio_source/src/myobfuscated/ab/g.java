// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ab;

import android.graphics.Bitmap;
import com.bumptech.glide.k;
import java.nio.ByteBuffer;
import java.util.List;
import myobfuscated.aj.j;
import myobfuscated.p.b;
import myobfuscated.z.a;

// Referenced classes of package myobfuscated.ab:
//            d, e, i

public final class g extends a
{

    public g(d d1)
    {
        super(d1);
    }

    public final Class a()
    {
        return myobfuscated/ab/d;
    }

    public final int c()
    {
        i l = ((d)a).a.a;
        myobfuscated.p.a a1 = l.a;
        int i1 = a1.a.limit();
        int j1 = a1.d.length;
        int k1 = a1.e.length;
        return j.a(l.a().getWidth(), l.a().getHeight(), l.a().getConfig()) + (k1 * 4 + (i1 + j1));
    }

    public final void d()
    {
        ((d)a).stop();
        Object obj = (d)a;
        obj.b = true;
        obj = ((d) (obj)).a.a;
        ((i) (obj)).c.clear();
        ((i) (obj)).c();
        obj.e = false;
        if (((i) (obj)).g != null)
        {
            ((i) (obj)).d.a(((i) (obj)).g);
            obj.g = null;
        }
        if (((i) (obj)).i != null)
        {
            ((i) (obj)).d.a(((i) (obj)).i);
            obj.i = null;
        }
        myobfuscated.p.a a1 = ((i) (obj)).a;
        a1.g = null;
        if (a1.d != null)
        {
            a1.h.a(a1.d);
        }
        if (a1.e != null)
        {
            b b1 = a1.h;
            int ai[] = a1.e;
            if (b1.b != null)
            {
                b1.b.a(ai, [I);
            }
        }
        if (a1.i != null)
        {
            b b2 = a1.h;
            Bitmap bitmap = a1.i;
            b2.a.a(bitmap);
        }
        a1.i = null;
        a1.a = null;
        a1.j = false;
        if (a1.b != null)
        {
            a1.h.a(a1.b);
        }
        if (a1.c != null)
        {
            a1.h.a(a1.c);
        }
        obj.h = true;
    }
}
