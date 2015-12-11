// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.request.OnRequestReceivedListener;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzBY
    implements com.google.android.gms.internal.ifier
{

    private final String zzBY;

    public void zza(OnRequestReceivedListener onrequestreceivedlistener)
    {
        onrequestreceivedlistener.onRequestRemoved(zzBY);
    }

    public void zznN()
    {
    }

    public void zzq(Object obj)
    {
        zza((OnRequestReceivedListener)obj);
    }

    (String s)
    {
        zzBY = s;
    }
}
