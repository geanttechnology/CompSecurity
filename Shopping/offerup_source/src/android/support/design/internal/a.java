// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.internal;

import android.content.Context;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.m;
import android.view.SubMenu;

// Referenced classes of package android.support.design.internal:
//            e

public final class a extends i
{

    public a(Context context)
    {
        super(context);
    }

    public final SubMenu addSubMenu(int j, int k, int l, CharSequence charsequence)
    {
        charsequence = (m)a(j, k, l, charsequence);
        e e1 = new e(d(), this, charsequence);
        charsequence.a(e1);
        return e1;
    }
}
