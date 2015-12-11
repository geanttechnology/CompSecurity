// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;

import android.view.View;

public final class b
{

    private android.view.WindowManager.LayoutParams a;
    private View b;

    public b(android.view.WindowManager.LayoutParams layoutparams, View view)
    {
        a = layoutparams;
        b = view;
    }

    public final android.view.WindowManager.LayoutParams a()
    {
        return a;
    }

    public final View b()
    {
        return b;
    }

    public final void c()
    {
        a = null;
        b = null;
    }
}
