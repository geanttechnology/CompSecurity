// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.DialogInterface;

// Referenced classes of package jumiomobile:
//            kt, gs, nu, ku

class lg
    implements android.content.DialogInterface.OnClickListener
{

    final kt a;

    private lg(kt kt1)
    {
        a = kt1;
        super();
    }

    lg(kt kt1, ku ku)
    {
        this(kt1);
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        kt.b(a).G();
        kt.b(a).z();
        a.c(true);
        a.b(true);
        a.i = false;
        kt.h(a);
        kt.a(a).a(false, false);
        kt.a(a).setShowLoading(false);
        kt.a(a).a(true);
        kt.a(a).setShowHelpButton(true);
    }
}
