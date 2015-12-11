// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.internal.dg;

// Referenced classes of package com.google.android.gms.cast:
//            Cast

class kp extends kp
{

    final r ko;
    final String kp;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((dg));
    }

    protected void a(dg dg1)
    {
        try
        {
            dg1.b(kp, null, this);
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

    ( , String s)
    {
        ko = ;
        kp = s;
        super(null);
    }
}
