// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;

// Referenced classes of package jumiomobile:
//            nu, na

class nb
    implements android.view.View.OnLayoutChangeListener
{

    final nu a;
    final na b;

    nb(na na1, nu nu1)
    {
        b = na1;
        a = nu1;
        super();
    }

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        if (a.getVisibility() == 0)
        {
            i = a.getHeight();
        } else
        {
            i = 0;
        }
        if (na.a(b) != i)
        {
            na.a(b, i);
            ((android.widget.RelativeLayout.LayoutParams)b.getLayoutParams()).setMargins(0, na.a(b), 0, 0);
            b.requestLayout();
        }
    }
}
