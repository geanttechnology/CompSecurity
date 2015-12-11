// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;

class nit> extends nit>
{

    final State zzaUT;

    public void zza(Status status, GoogleNowAuthState googlenowauthstate)
    {
        if (a(zzaUT))
        {
            Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
        }
        zzaUT.b(new nit>(status, googlenowauthstate));
    }

    State(State state)
    {
        zzaUT = state;
        super();
    }
}
