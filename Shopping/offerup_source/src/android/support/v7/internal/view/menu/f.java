// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.d.a.a;
import android.support.v4.d.a.b;
import android.view.Menu;
import android.view.MenuItem;

// Referenced classes of package android.support.v7.internal.view.menu:
//            ab, t, o

public class f
{

    final Object b;

    f(Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        } else
        {
            b = obj;
            return;
        }
    }

    public static Menu a(Context context, a a1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return new ab(context, a1);
        } else
        {
            throw new UnsupportedOperationException();
        }
    }

    public static MenuItem a(Context context, b b1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            return new t(context, b1);
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return new o(context, b1);
        } else
        {
            throw new UnsupportedOperationException();
        }
    }
}
