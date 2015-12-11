// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

final class et
    implements fa
{

    private ep a;

    et(ep ep1)
    {
        a = ep1;
    }

    public final void a(View view)
    {
        if (ep.c(a) >= 0)
        {
            dz.a(view, 2, null);
        }
        if (ep.a(a) != null)
        {
            ep.a(a).run();
        }
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof fa)
        {
            obj = (fa)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((fa) (obj)).a(view);
        }
    }

    public final void b(View view)
    {
        if (ep.c(a) >= 0)
        {
            dz.a(view, ep.c(a), null);
            ep.a(a, -1);
        }
        if (ep.b(a) != null)
        {
            ep.b(a).run();
        }
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof fa)
        {
            obj = (fa)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((fa) (obj)).b(view);
        }
    }

    public final void c(View view)
    {
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof fa)
        {
            obj = (fa)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((fa) (obj)).c(view);
        }
    }
}
