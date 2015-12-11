// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzmu

public final class zzkt
    implements PlayerInfo
{

    private final int zzWw;
    private final String zzYf;
    private final JSONObject zzYv;
    private final boolean zzYw;

    public zzkt(String s, int i, JSONObject jsonobject, boolean flag)
    {
        zzYf = s;
        zzWw = i;
        zzYv = jsonobject;
        zzYw = flag;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof PlayerInfo))
        {
            if (zzYw == ((PlayerInfo) (obj = (PlayerInfo)obj)).isControllable() && zzWw == ((PlayerInfo) (obj)).getPlayerState() && zzf.zza(zzYf, ((PlayerInfo) (obj)).getPlayerId()) && zzmu.zzd(zzYv, ((PlayerInfo) (obj)).getPlayerData()))
            {
                return true;
            }
        }
        return false;
    }

    public JSONObject getPlayerData()
    {
        return zzYv;
    }

    public String getPlayerId()
    {
        return zzYf;
    }

    public int getPlayerState()
    {
        return zzWw;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzYf, Integer.valueOf(zzWw), zzYv, Boolean.valueOf(zzYw)
        });
    }

    public boolean isConnected()
    {
        switch (zzWw)
        {
        default:
            return false;

        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            return true;
        }
    }

    public boolean isControllable()
    {
        return zzYw;
    }
}
