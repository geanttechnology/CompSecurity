// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Spinner;

// Referenced classes of package jumiomobile:
//            ey

class ez
    implements android.view.View.OnFocusChangeListener
{

    final Context a;
    final ey b;

    ez(ey ey1, Context context)
    {
        b = ey1;
        a = context;
        super();
    }

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            ((InputMethodManager)a.getSystemService("input_method")).hideSoftInputFromWindow(b.e.getWindowToken(), 2);
            b.e.performClick();
        }
    }
}
