// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafeBrowsingData;

// Referenced classes of package com.google.android.gms.internal:
//            zzps, zzpw

class  extends zzps
{

    final ngData zzaNK;

    public void zza(Status status, SafeBrowsingData safebrowsingdata)
    {
        zzaNK.a(new nit>(status, safebrowsingdata));
    }

    ngData(ngData ngdata)
    {
        zzaNK = ngdata;
        super();
    }
}
