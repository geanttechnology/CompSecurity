// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package netswipe:
//            bm, aw

class bn
    implements Runnable
{

    final bm a;

    bn(bm bm1)
    {
        a = bm1;
        super();
    }

    public void run()
    {
        bm.a(a, a.getChildAt(0));
        ((InputMethodManager)a.getContext().getSystemService("input_method")).toggleSoftInputFromWindow(a.getApplicationWindowToken(), 1, 0);
        if ((a.getChildAt(0) instanceof aw) && ((aw)a.getChildAt(0)).getAutoShowNextView())
        {
            bm.b(a, a.getChildAt(0));
        }
    }
}
