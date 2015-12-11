// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;

// Referenced classes of package com.google.android.gms.internal:
//            dw, eg

public static final class po extends po
{

    private dw po;

    public void b(int i, IBinder ibinder, Bundle bundle)
    {
        eg.b("onPostInitComplete can be called only once per call to getServiceFromBroker", po);
        po.a(i, ibinder, bundle);
        po = null;
    }

    public (dw dw1)
    {
        po = dw1;
    }
}
