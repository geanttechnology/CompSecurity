// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.Surface;

final class aoj
    implements Runnable
{

    private Surface a;
    private aoh b;

    aoj(aoh aoh1, Surface surface)
    {
        b = aoh1;
        a = surface;
        super();
    }

    public final void run()
    {
        aol aol1 = b.a;
        Surface surface = a;
        aol1.a();
    }
}
