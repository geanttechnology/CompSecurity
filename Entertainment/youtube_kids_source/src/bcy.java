// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

public final class bcy
{

    private View a;

    public bcy()
    {
    }

    public final bcw a()
    {
        if (a == null)
        {
            return null;
        } else
        {
            return new bcw(a);
        }
    }

    public final void a(View view)
    {
        a = (View)b.a(view);
    }
}
