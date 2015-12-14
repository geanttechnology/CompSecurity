// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.OnRequestReceivedListener;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzatQ
    implements com.google.android.gms.common.api.ier
{

    private final GameRequest zzatQ;

    public void zza(OnRequestReceivedListener onrequestreceivedlistener)
    {
        onrequestreceivedlistener.onRequestReceived(zzatQ);
    }

    public void zznh()
    {
    }

    public void zzo(Object obj)
    {
        zza((OnRequestReceivedListener)obj);
    }

    (GameRequest gamerequest)
    {
        zzatQ = gamerequest;
    }
}
