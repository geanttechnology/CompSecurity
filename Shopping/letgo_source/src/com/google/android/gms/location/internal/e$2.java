// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.c;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.internal:
//            e, j

class <init> extends <init>
{

    final List b;
    final e c;

    protected volatile void a(com.google.android.gms.common.api.._cls2 _pcls2)
        throws RemoteException
    {
        a((j)_pcls2);
    }

    protected void a(j j1)
        throws RemoteException
    {
        j1.a(b, this);
    }

    (e e1, c c1, List list)
    {
        c = e1;
        b = list;
        super(c1);
    }
}
