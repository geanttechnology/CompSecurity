// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

// Referenced classes of package com.google.android.gms.d:
//            hx, gq, gs, ll, 
//            is, kq

private static final class b extends hx
{

    private final a a;
    private final a b;

    protected final is a(gs gs1)
    {
        return is.a(new ByteArrayInputStream(gs1.b), ll.a(gs1));
    }

    protected final void a(Object obj)
    {
        obj = (InputStream)obj;
        b.a(a.a(((InputStream) (obj))));
    }

    public _cls1.b(String s, _cls1.b b1, _cls1.b b2)
    {
        super(s, new is.a(b2, b1) {

            final is.b a;
            final gq.a b;

            public final void a(kq kq)
            {
                a.a(b.a());
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
