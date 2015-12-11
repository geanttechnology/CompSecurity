// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;


// Referenced classes of package com.wishabi.flipp.widget:
//            ak, ab, ae, af

final class ac
    implements ak
{

    final ab a;

    ac(ab ab1)
    {
        a = ab1;
        super();
    }

    public final void a()
    {
        if (a.l == null)
        {
            return;
        } else
        {
            a.l.a(a.c());
            return;
        }
    }

    public final void a(af af1)
    {
        if (a.l == null)
        {
            return;
        }
        ae ae1 = a.l;
        int i = a.c();
        boolean flag;
        if (!af1.getIsClipped())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ae1.a(i, flag);
    }

    public final void b()
    {
        if (a.l == null)
        {
            return;
        } else
        {
            a.l.b(a.c());
            return;
        }
    }

    public final void c()
    {
        if (a.l == null)
        {
            return;
        } else
        {
            a.l.a();
            return;
        }
    }

    public final void d()
    {
        if (a.l == null)
        {
            return;
        } else
        {
            a.l.c(a.c());
            return;
        }
    }
}
