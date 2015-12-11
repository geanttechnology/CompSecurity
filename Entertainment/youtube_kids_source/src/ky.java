// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

final class ky
    implements Runnable
{

    private kx a;

    ky(kx kx1)
    {
        a = kx1;
        super();
    }

    public final void run()
    {
        View view = a.e;
        if (view != null && view.getWindowToken() != null)
        {
            a.a();
        }
    }
}
