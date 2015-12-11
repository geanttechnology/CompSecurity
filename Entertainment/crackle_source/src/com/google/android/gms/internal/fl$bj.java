// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            fk, fl, eg

final class uF extends fk
{

    final fl tZ;
    private final com.google.android.gms.common.api. uF;

    public void a(int i, Bundle bundle)
    {
        bundle.setClassLoader(getClass().getClassLoader());
        Status status = new Status(i);
        tZ.a(new <init>(tZ, uF, status, bundle));
    }

    public us(fl fl1, com.google.android.gms.common.api. )
    {
        tZ = fl1;
        super();
        uF = (com.google.android.gms.common.api.)eg.b(, "Holder must not be null");
    }
}
