// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            db, dc, eg

final class  extends db
{

    com.google.android.gms.common.api.s jW;
    final dc jX;

    public void onSignOutComplete()
    {
        Status status = new Status(0);
        jX.a(new <init>(jX, jW, status));
    }

    public (dc dc1, com.google.android.gms.common.api.s s)
    {
        jX = dc1;
        super();
        jW = (com.google.android.gms.common.api.)eg.b(s, "Holder must not be null");
    }
}
