// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            go, fx

class <init> extends <init>
{

    final int HP;
    final go Ik;
    final int Il;
    final int Im;

    protected volatile void a(com.google.android.gms.common.api. )
        throws RemoteException
    {
        a((fx));
    }

    protected void a(fx fx1)
    {
        fx1.a(this, Il, Im, HP);
    }

    .a(go go1, int i, int j, int k)
    {
        Ik = go1;
        Il = i;
        Im = j;
        HP = k;
        super(null);
    }
}
