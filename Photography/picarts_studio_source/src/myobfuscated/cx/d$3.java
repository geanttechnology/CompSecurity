// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cx;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.socialin.android.d;

// Referenced classes of package myobfuscated.cx:
//            d

final class it>
    implements Runnable
{

    private Activity a;

    public final void run()
    {
        if (a.getCurrentFocus() == null)
        {
            a.getWindow().setSoftInputMode(3);
            return;
        }
        try
        {
            ((InputMethodManager)a.getSystemService("input_method")).hideSoftInputFromWindow(a.getCurrentFocus().getWindowToken(), 2);
            return;
        }
        catch (Exception exception)
        {
            d.b(d.a, "hide Keayboard", exception);
        }
        return;
    }

    (Activity activity)
    {
        a = activity;
        super();
    }
}
