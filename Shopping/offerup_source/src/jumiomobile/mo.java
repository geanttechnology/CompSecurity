// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


// Referenced classes of package jumiomobile:
//            mn, nu

class mo
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final mn a;

    mo(mn mn1)
    {
        a = mn1;
        super();
    }

    public void onGlobalLayout()
    {
        mn mn1 = a;
        int i;
        if (mn.a(a).getVisibility() == 0)
        {
            i = mn.a(a).getHeight();
        } else
        {
            i = 0;
        }
        mn.a(mn1, i);
        mn.a(a, true);
        a.invalidate();
    }
}
