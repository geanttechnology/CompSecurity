// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class 
    implements com.google.android.gms.internal.ifier
{

    private final Player zzawa;

    public void zza(OnNearbyPlayerDetectedListener onnearbyplayerdetectedlistener)
    {
        onnearbyplayerdetectedlistener.zza(zzawa);
    }

    public void zznN()
    {
    }

    public void zzq(Object obj)
    {
        zza((OnNearbyPlayerDetectedListener)obj);
    }
}
