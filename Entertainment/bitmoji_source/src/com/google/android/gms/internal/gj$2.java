// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            gj, fx

class <init> extends <init>
{

    final boolean HH;
    final gj HS;
    final String HT;

    protected volatile void a(com.google.android.gms.common.api. )
        throws RemoteException
    {
        a((fx));
    }

    protected void a(fx fx1)
    {
        fx1.a(this, HT, HH);
    }

    .a(gj gj1, String s, boolean flag)
    {
        HS = gj1;
        HT = s;
        HH = flag;
        super(null);
    }
}
