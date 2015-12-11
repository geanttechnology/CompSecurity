// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IInterface;

// Referenced classes of package com.google.android.gms.internal:
//            ix, iu, io

final class iv
    implements ix
{

    final iu a;

    private iv(iu iu1)
    {
        a = iu1;
        super();
    }

    iv(iu iu1, byte byte0)
    {
        this(iu1);
    }

    public final void a()
    {
        iu.a(a);
    }

    public final IInterface b()
    {
        return (io)iu.b(a);
    }
}
