// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.facebook.j;
import com.facebook.p;

// Referenced classes of package android.support.v7:
//            kb, jz

static final class b
    implements com.facebook.Request.b
{

    final a a;
    final String b;

    public void a(p p1)
    {
        if (p1.a() != null)
        {
            a.a(p1.a().e());
            return;
        } else
        {
            jz.a(b, p1.b());
            a.a(p1.b());
            return;
        }
    }

    t.b(t.b b1, String s)
    {
        a = b1;
        b = s;
        super();
    }
}
