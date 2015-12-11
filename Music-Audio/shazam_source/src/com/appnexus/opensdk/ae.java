// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.view.View;
import com.appnexus.opensdk.b.l;

// Referenced classes of package com.appnexus.opensdk:
//            r, ac

final class ae
    implements r
{

    View a;
    ac b;

    ae(ac ac1)
    {
        b = ac1;
    }

    public final View b()
    {
        return a;
    }

    public final boolean c()
    {
        return b.f;
    }

    public final int d()
    {
        if (a != null)
        {
            return a.getWidth();
        } else
        {
            return -1;
        }
    }

    public final void destroy()
    {
        b.b();
        l.a(a);
    }

    public final int e()
    {
        if (a != null)
        {
            return a.getHeight();
        } else
        {
            return -1;
        }
    }

    public final void f()
    {
        b.h();
        destroy();
    }

    public final void onPause()
    {
        b.i();
    }

    public final void onResume()
    {
        b.j();
    }
}
