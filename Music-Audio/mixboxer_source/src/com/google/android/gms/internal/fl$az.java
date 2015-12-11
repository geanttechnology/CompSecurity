// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            fk, fl, eg

final class uz extends fk
{

    final fl tZ;
    private final com.google.android.gms.common.api. uz;

    public void onTurnBasedMatchCanceled(int i, String s)
    {
        Status status = new Status(i);
        tZ.a(new <init>(tZ, uz, status, s));
    }

    public us(fl fl1, com.google.android.gms.common.api. )
    {
        tZ = fl1;
        super();
        uz = (com.google.android.gms.common.api.)eg.b(, "Holder must not be null");
    }
}
