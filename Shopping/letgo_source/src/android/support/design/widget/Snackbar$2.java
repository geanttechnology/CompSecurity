// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.View;

// Referenced classes of package android.support.design.widget:
//            Snackbar, e

class a
    implements a
{

    final Snackbar a;

    public void a(int i)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            e.a().d(Snackbar.a(a));
            return;

        case 0: // '\0'
            e.a().e(Snackbar.a(a));
            return;
        }
    }

    public void a(View view)
    {
        a.a();
    }

    (Snackbar snackbar)
    {
        a = snackbar;
        super();
    }
}
