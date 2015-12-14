// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.app.ActionBarActivityDelegateBase;
import android.view.View;

public class g
    implements OnApplyWindowInsetsListener
{

    final ActionBarActivityDelegateBase a;

    public g(ActionBarActivityDelegateBase actionbaractivitydelegatebase)
    {
        a = actionbaractivitydelegatebase;
        super();
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowinsetscompat)
    {
        int i = windowinsetscompat.getSystemWindowInsetTop();
        int j = ActionBarActivityDelegateBase.c(a, i);
        view = windowinsetscompat;
        if (i != j)
        {
            view = windowinsetscompat.replaceSystemWindowInsets(windowinsetscompat.getSystemWindowInsetLeft(), j, windowinsetscompat.getSystemWindowInsetRight(), windowinsetscompat.getSystemWindowInsetBottom());
        }
        return view;
    }
}
