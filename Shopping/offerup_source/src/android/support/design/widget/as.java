// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;


// Referenced classes of package android.support.design.widget:
//            bi, Snackbar, ba

final class as
    implements bi
{

    private Snackbar a;

    as(Snackbar snackbar)
    {
        a = snackbar;
        super();
    }

    public final void a()
    {
        Snackbar.a(a, 0);
    }

    public final void a(int i)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            ba.a().c(Snackbar.a(a));
            return;

        case 0: // '\0'
            ba.a().d(Snackbar.a(a));
            return;
        }
    }
}
