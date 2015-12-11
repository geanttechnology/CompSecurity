// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;

// Referenced classes of package jumiomobile:
//            kt, gs, ku

final class lf
    implements android.view.View.OnClickListener
{

    final kt a;

    private lf(kt kt1)
    {
        a = kt1;
        super();
    }

    lf(kt kt1, ku ku)
    {
        this(kt1);
    }

    public final void onClick(View view)
    {
        kt.b(a).F();
        kt.a(a, kt.b(a).s());
        kt.b(a, a.d, 100);
        kt.b(a, a.c, 100);
        kt.a(a, false);
    }
}
