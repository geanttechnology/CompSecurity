// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.wearcom.b;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.o;

// Referenced classes of package com.shazam.android.wearcom.b:
//            c

public final class b
    implements com.shazam.android.wearcom.b.c
{

    public b()
    {
    }

    public final Status a(com.google.android.gms.common.api.c c1, Intent intent)
    {
        intent = (PutDataRequest)intent.getParcelableExtra("extraData");
        return ((com.google.android.gms.wearable.c.a)o.a.a(c1, intent).a()).a();
    }
}
