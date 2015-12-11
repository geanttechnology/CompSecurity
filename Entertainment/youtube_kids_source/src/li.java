// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.PopupWindow;

final class li
    implements Runnable
{

    private kx a;

    li(kx kx1)
    {
        a = kx1;
        super();
    }

    public final void run()
    {
        if (kx.a(a) != null && kx.a(a).getCount() > kx.a(a).getChildCount() && kx.a(a).getChildCount() <= a.d)
        {
            kx.b(a).setInputMethodMode(2);
            a.a();
        }
    }
}
