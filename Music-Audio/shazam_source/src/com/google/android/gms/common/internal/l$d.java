// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;

// Referenced classes of package com.google.android.gms.common.internal:
//            l, w

public static final class b extends b
{

    private l a;
    private final int b;

    public final void a(int i, Bundle bundle)
    {
        w.a(a, "onAccountValidationComplete can be called only once per call to validateAccount");
        l l1 = a;
        int j = b;
        l1.d.sendMessage(l1.d.obtainMessage(5, j, -1, new <init>(l1, i, bundle)));
        a = null;
    }

    public final void a(int i, IBinder ibinder, Bundle bundle)
    {
        w.a(a, "onPostInitComplete can be called only once per call to getRemoteService");
        a.a(i, ibinder, bundle, b);
        a = null;
    }

    public (l l1, int i)
    {
        a = l1;
        b = i;
    }
}
