// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            hs

final class jY extends jY
{

    final hs DM;
    private final Status jY;

    protected void aL()
    {
    }

    protected void b(Object obj)
    {
        c((com.google.android.gms.common.api.)obj);
    }

    protected void c(com.google.android.gms.common.api. )
    {
        DM.disconnect();
        if ( != null)
        {
            .(jY);
        }
    }

    public tus(hs hs1, com.google.android.gms.common.api.s s, Status status)
    {
        DM = hs1;
        super(hs1, s);
        jY = status;
    }
}
