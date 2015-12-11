// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import android.support.v4.app.r;
import android.support.v4.e.a;
import e.c.d;
import e.j;

// Referenced classes of package e.d.a:
//            h

final class i extends j
{

    private j a;
    private h b;

    i(h h1, j j1, j j2)
    {
        b = h1;
        a = j2;
        super(j1);
    }

    public final void a()
    {
        a.a();
    }

    public final void a(Object obj)
    {
        try
        {
            a.a(e.d.a.h.a(b).a(obj));
            return;
        }
        catch (Throwable throwable)
        {
            android.support.v4.e.a.a(throwable);
            a(r.a(throwable, obj));
            return;
        }
    }

    public final void a(Throwable throwable)
    {
        a.a(throwable);
    }
}
