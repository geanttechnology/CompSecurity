// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.af;
import android.support.v7.ag;
import android.support.v7.ah;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

// Referenced classes of package android.support.v7.internal.view.menu:
//            o, j, i, q

public final class n
{

    public static Menu a(Context context, af af)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return new o(context, af);
        } else
        {
            throw new UnsupportedOperationException();
        }
    }

    public static MenuItem a(Context context, ag ag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            return new j(context, ag);
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return new i(context, ag);
        } else
        {
            throw new UnsupportedOperationException();
        }
    }

    public static SubMenu a(Context context, ah ah)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return new q(context, ah);
        } else
        {
            throw new UnsupportedOperationException();
        }
    }
}
