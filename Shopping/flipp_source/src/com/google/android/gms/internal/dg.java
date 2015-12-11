// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            ee, do, et, cb, 
//            df, bz

public abstract class dg extends ee
{

    private final bz a;
    private final df b;

    public dg(bz bz, df df1)
    {
        a = bz;
        b = df1;
    }

    private static cb a(do do1, bz bz)
    {
        try
        {
            do1 = do1.a(bz);
        }
        // Misplaced declaration of an exception variable
        catch (do do1)
        {
            et.a("Could not fetch ad response from ad request service.", do1);
            return null;
        }
        return do1;
    }

    public final void a()
    {
        Object obj = d();
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = new cb(0);
_L4:
        c();
        b.a(((cb) (obj)));
        return;
_L2:
        cb cb1 = a(((do) (obj)), a);
        obj = cb1;
        if (cb1 != null) goto _L4; else goto _L3
_L3:
        obj = new cb(0);
          goto _L4
        Exception exception;
        exception;
        c();
        throw exception;
    }

    public final void b_()
    {
        c();
    }

    public abstract void c();

    public abstract do d();
}
