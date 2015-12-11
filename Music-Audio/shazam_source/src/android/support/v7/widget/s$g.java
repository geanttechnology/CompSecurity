// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.widget.PopupWindow;

// Referenced classes of package android.support.v7.widget:
//            s

private final class <init>
    implements Runnable
{

    final s a;

    public final void run()
    {
        if (s.a(a) != null && s.a(a).getCount() > s.a(a).getChildCount() && s.a(a).getChildCount() <= a.e)
        {
            s.b(a).setInputMethodMode(2);
            a.c();
        }
    }

    private (s s1)
    {
        a = s1;
        super();
    }

    a(s s1, byte byte0)
    {
        this(s1);
    }
}
