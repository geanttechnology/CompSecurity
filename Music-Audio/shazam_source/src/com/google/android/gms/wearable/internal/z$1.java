// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            aw, z, ao, x

final class init> extends aw
{

    final String c;
    final String d;
    final byte e[];
    final z f;

    protected final g a(Status status)
    {
        return new <init>(status, -1);
    }

    protected final void a(com.google.android.gms.common.api.._cls1 _pcls1)
    {
        _pcls1 = (ao)_pcls1;
        String s = c;
        String s1 = d;
        byte abyte0[] = e;
        ((x)_pcls1.m()).a(new (this), s, s1, abyte0);
    }

    (z z1, c c1, String s, String s1, byte abyte0[])
    {
        f = z1;
        c = s;
        d = s1;
        e = abyte0;
        super(c1);
    }
}
