// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.plus.internal.e;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.internal:
//            il

class .b extends .b
{

    final il RH;
    final Collection RI;

    protected volatile void a(com.google.android.gms.common.api. )
        throws RemoteException
    {
        a((e));
    }

    protected void a(e e1)
    {
        e1.a(this, RI);
    }

    .b(il il1, com.google.android.gms.common.api. , Collection collection)
    {
        RH = il1;
        RI = collection;
        super();
    }
}
