// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.wearcom.service;

import android.content.Context;
import android.content.Intent;
import com.shazam.android.wearcom.a;

// Referenced classes of package com.shazam.android.wearcom.service:
//            WearComIntentService, a

public final class b
    implements a
{

    private final Context a;

    public b(Context context)
    {
        a = context;
    }

    private Intent a(com.shazam.android.wearcom.service.a a1, String s)
    {
        Intent intent = new Intent(a, com/shazam/android/wearcom/service/WearComIntentService);
        intent.putExtra("extraWearAction", a1);
        intent.putExtra("extraActionToNotify", s);
        return intent;
    }

    public final void a(com.shazam.android.wearcom.a.a a1)
    {
        Intent intent = a(com.shazam.android.wearcom.service.a.a, a1.b);
        intent.putExtra("extraData", a1.a);
        a.startService(intent);
    }

    public final void a(com.shazam.android.wearcom.a.b b1)
    {
        Intent intent = a(a.b, b1.c);
        intent.setAction(b1.a);
        intent.putExtra("extraNodeId", b1.d);
        intent.putExtra("extraData", b1.b);
        a.startService(intent);
    }
}
