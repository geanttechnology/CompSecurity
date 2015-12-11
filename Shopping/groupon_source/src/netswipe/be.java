// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.view.View;

// Referenced classes of package netswipe:
//            ba

class be
    implements android.view.View.OnFocusChangeListener
{

    final ba a;

    be(ba ba1)
    {
        a = ba1;
        super();
    }

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            if (!ba.f(a))
            {
                ba.a(a, true);
            }
            return;
        } else
        {
            ba.a(a, false);
            return;
        }
    }
}
