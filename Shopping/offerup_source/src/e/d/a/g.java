// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import android.support.v4.app.r;
import e.c.d;
import e.j;

// Referenced classes of package e.d.a:
//            f

final class g extends j
{

    private j a;
    private f b;

    g(f f1, j j1, j j2)
    {
        b = f1;
        a = j2;
        super(j1);
    }

    public final void a()
    {
        a.a();
    }

    public final void a(Object obj)
    {
        if (((Boolean)f.a(b).a(obj)).booleanValue())
        {
            a.a(obj);
            return;
        }
        try
        {
            a(1L);
            return;
        }
        catch (Throwable throwable)
        {
            a.a(r.a(throwable, obj));
        }
        return;
    }

    public final void a(Throwable throwable)
    {
        a.a(throwable);
    }
}
