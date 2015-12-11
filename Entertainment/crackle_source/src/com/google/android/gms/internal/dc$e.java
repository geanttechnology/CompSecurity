// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.internal:
//            db, dc, eg

final class  extends db
{

    private final com.google.android.gms.common.api.r jW;
    final dc jX;

    public void a(int i, DataHolder dataholder)
    {
        jX.a(new <init>(jX, jW, i, dataholder));
    }

    public (dc dc1, com.google.android.gms.common.api.r r)
    {
        jX = dc1;
        super();
        jW = (com.google.android.gms.common.api.)eg.b(r, "Result holder must not be null");
    }
}
