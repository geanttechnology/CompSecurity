// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;

// Referenced classes of package android.support.v4.view:
//            cw, cj, ap

final class cn
    implements cw
{

    cj a;

    cn(cj cj1)
    {
        a = cj1;
    }

    public final void a(View view)
    {
        if (cj.d(a) >= 0)
        {
            ap.a(view, 2, null);
        }
        if (cj.a(a) != null)
        {
            cj.a(a).run();
        }
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof cw)
        {
            obj = (cw)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((cw) (obj)).a(view);
        }
    }

    public final void b(View view)
    {
        if (cj.d(a) >= 0)
        {
            ap.a(view, cj.d(a), null);
            cj.c(a);
        }
        if (cj.b(a) != null)
        {
            cj.b(a).run();
        }
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof cw)
        {
            obj = (cw)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((cw) (obj)).b(view);
        }
    }

    public final void c(View view)
    {
        Object obj = view.getTag(0x7e000000);
        if (obj instanceof cw)
        {
            obj = (cw)obj;
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            ((cw) (obj)).c(view);
        }
    }
}
