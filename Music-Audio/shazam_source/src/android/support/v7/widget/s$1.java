// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            s

final class a
    implements Runnable
{

    final s a;

    public final void run()
    {
        View view = a.g;
        if (view != null && view.getWindowToken() != null)
        {
            a.c();
        }
    }

    (s s1)
    {
        a = s1;
        super();
    }
}
