// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;

// Referenced classes of package jumiomobile:
//            ei

class em
    implements android.view.View.OnFocusChangeListener
{

    final ei a;

    em(ei ei1)
    {
        a = ei1;
        super();
    }

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            if (!ei.f(a))
            {
                ei.a(a, true);
            }
            return;
        } else
        {
            ei.a(a, false);
            return;
        }
    }
}
