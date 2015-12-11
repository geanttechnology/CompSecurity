// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package jumiomobile:
//            ep, ee

class eq
    implements Runnable
{

    final ep a;

    eq(ep ep1)
    {
        a = ep1;
        super();
    }

    public void run()
    {
        android.view.View view = a.getChildAt(0);
        if (ep.a(a, view))
        {
            ((InputMethodManager)a.getContext().getSystemService("input_method")).toggleSoftInputFromWindow(a.getApplicationWindowToken(), 1, 0);
        }
        if ((view instanceof ee) && ((ee)view).getAutoShowNextView())
        {
            ep.b(a, view);
        }
    }
}
