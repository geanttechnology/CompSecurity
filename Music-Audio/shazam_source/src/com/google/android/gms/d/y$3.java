// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.content.IntentFilter;

// Referenced classes of package com.google.android.gms.d:
//            y, ae

final class a
    implements 
{

    final y a;

    public final void a(Object obj)
    {
        y y1;
        obj = (ae)obj;
        y.a(a);
        y1 = a;
        ((ae) (obj)).a("/updateActiveView", y1.f);
        ((ae) (obj)).a("/untrackActiveViewUnit", y1.g);
        ((ae) (obj)).a("/visibilityChanged", y1.h);
        y1 = a;
        obj = y1.a;
        obj;
        JVM INSTR monitorenter ;
        if (y1.d == null) goto _L2; else goto _L1
_L1:
        a.a(false);
        return;
_L2:
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.SCREEN_ON");
        intentfilter.addAction("android.intent.action.SCREEN_OFF");
        y1.d = new <init>(y1);
        y1.b.registerReceiver(y1.d, intentfilter);
        obj;
        JVM INSTR monitorexit ;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (y y1)
    {
        a = y1;
        super();
    }
}
