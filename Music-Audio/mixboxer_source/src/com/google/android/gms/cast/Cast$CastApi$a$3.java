// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.internal.dg;

// Referenced classes of package com.google.android.gms.cast:
//            Cast

class kq extends kq
{

    final r ko;
    final String kp;
    final boolean kq;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((dg));
    }

    protected void a(dg dg1)
    {
        try
        {
            dg1.a(kp, kq, this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (dg dg1)
        {
            r(2001);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (dg dg1)
        {
            r(8);
        }
    }

    ( , String s, boolean flag)
    {
        ko = ;
        kp = s;
        kq = flag;
        super(null);
    }
}
