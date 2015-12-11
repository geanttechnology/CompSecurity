// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.b;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            k

private class <init>
    implements Runnable
{

    final k a;

    public void run()
    {
        synchronized (k.a(a))
        {
            Intent intent = new Intent("com.google.android.location.places.METHOD_CALL");
            intent.setPackage("com.google.android.gms");
            intent.putStringArrayListExtra("PLACE_IDS", com.google.android.gms.location.places.internal.k.b(a));
            intent.putStringArrayListExtra("METHOD_NAMES", k.c(a));
            intent.putExtra("PACKAGE_NAME", k.d(a).getPackageName());
            intent.putExtra("CLIENT_VERSION", b.a);
            k.d(a).sendBroadcast(intent);
            k.a(a, null);
            com.google.android.gms.location.places.internal.k.b(a, null);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private _cls9(k k1)
    {
        a = k1;
        super();
    }

    a(k k1, a a1)
    {
        this(k1);
    }
}
