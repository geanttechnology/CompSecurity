// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.internal;

import android.content.Context;
import android.support.v7.internal.view.menu.ac;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.m;
import android.view.MenuItem;

// Referenced classes of package android.support.design.internal:
//            a

public final class e extends ac
{

    public e(Context context, a a, m m)
    {
        super(context, a, m);
    }

    private void q()
    {
        ((i)p()).b(true);
    }

    public final MenuItem add(int j)
    {
        MenuItem menuitem = super.add(j);
        q();
        return menuitem;
    }

    public final MenuItem add(int j, int k, int l, int i1)
    {
        MenuItem menuitem = super.add(j, k, l, i1);
        q();
        return menuitem;
    }

    public final MenuItem add(int j, int k, int l, CharSequence charsequence)
    {
        charsequence = super.add(j, k, l, charsequence);
        q();
        return charsequence;
    }

    public final MenuItem add(CharSequence charsequence)
    {
        charsequence = super.add(charsequence);
        q();
        return charsequence;
    }
}
