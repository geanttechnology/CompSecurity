// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.internal:
//            fk, fl, eg

final class  extends fk
{

    private final com.google.android.gms.common.api.r jW;
    final fl tZ;

    public void c(DataHolder dataholder)
    {
        tZ.a(new <init>(tZ, jW, dataholder));
    }

    (fl fl1, com.google.android.gms.common.api.r r)
    {
        tZ = fl1;
        super();
        jW = (com.google.android.gms.common.api.)eg.b(r, "Holder must not be null");
    }
}
