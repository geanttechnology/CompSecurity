// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.DataSetObserver;

final class eza extends DataSetObserver
{

    private eyz a;

    eza(eyz eyz1)
    {
        a = eyz1;
        super();
    }

    public final void onChanged()
    {
        synchronized (a)
        {
            eyz.a(a, true);
        }
        a.invalidate();
        a.requestLayout();
        return;
        exception;
        eyz1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onInvalidated()
    {
        eyz.a(a);
        a.invalidate();
        a.requestLayout();
    }
}
