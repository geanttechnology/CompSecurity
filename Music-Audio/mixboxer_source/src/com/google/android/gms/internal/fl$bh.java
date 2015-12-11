// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.internal:
//            fk, fl, eg

final class uE extends fk
{

    final fl tZ;
    private final com.google.android.gms.common.api.older uE;

    public void o(DataHolder dataholder)
    {
        tZ.a(new <init>(tZ, uE, dataholder));
    }

    public r(fl fl1, com.google.android.gms.common.api.older older)
    {
        tZ = fl1;
        super();
        uE = (com.google.android.gms.common.api.)eg.b(older, "Holder must not be null");
    }
}
