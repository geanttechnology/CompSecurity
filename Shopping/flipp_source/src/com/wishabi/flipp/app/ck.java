// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.support.v4.view.cd;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.widget.ViewPagerIndicator;

// Referenced classes of package com.wishabi.flipp.app:
//            HelpActivity

final class ck
    implements cd
{

    final ViewPagerIndicator a;
    final HelpActivity b;

    ck(HelpActivity helpactivity, ViewPagerIndicator viewpagerindicator)
    {
        b = helpactivity;
        a = viewpagerindicator;
        super();
    }

    public final void a()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)b.getSystemService("input_method");
        View view = b.getCurrentFocus();
        if (view != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    public final void a(int i)
    {
        a.a.a((new StringBuilder("TutorialScreen")).append(i).toString());
        a.invalidate();
    }
}
