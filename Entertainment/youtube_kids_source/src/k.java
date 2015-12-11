// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

final class k
    implements q
{

    private j a;

    k(j j1)
    {
        a = j1;
        super();
    }

    public final View a(int i)
    {
        if (a.K == null)
        {
            throw new IllegalStateException("Fragment does not have a view");
        } else
        {
            return a.K.findViewById(i);
        }
    }

    public final boolean a()
    {
        return a.K != null;
    }
}
