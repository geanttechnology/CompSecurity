// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.Window;

final class o
    implements q
{

    private m a;

    o(m m1)
    {
        a = m1;
        super();
    }

    public final View a(int i)
    {
        return a.findViewById(i);
    }

    public final boolean a()
    {
        Window window = a.getWindow();
        return window != null && window.peekDecorView() != null;
    }
}
