// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;


// Referenced classes of package android.support.design.widget:
//            az, Snackbar

final class at
    implements az
{

    private Snackbar a;

    at(Snackbar snackbar)
    {
        a = snackbar;
        super();
    }

    public final void a()
    {
        Snackbar.b(a);
        Snackbar.c(a).setOnLayoutChangeListener(null);
    }
}
