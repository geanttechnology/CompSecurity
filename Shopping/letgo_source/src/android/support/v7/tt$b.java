// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            ve, tt, tv, yj, 
//            vw, xs

private static class b extends ve
{

    private final a a;
    private final a b;

    protected vw a(tv tv1)
    {
        return vw.a(new ByteArrayInputStream(tv1.b), yj.a(tv1));
    }

    protected void a(InputStream inputstream)
    {
        b.a(a.b(inputstream));
    }

    protected void a(Object obj)
    {
        a((InputStream)obj);
    }

    public _cls1.b(String s, _cls1.b b1, _cls1.b b2)
    {
        super(0, s, new vw.a(b2, b1) {

            final vw.b a;
            final tt.a b;

            public void a(xs xs)
            {
                a.a(b.b());
            }

            
            {
                a = b1;
                b = a1;
                super();
            }
        });
        a = b1;
        b = b2;
    }
}
