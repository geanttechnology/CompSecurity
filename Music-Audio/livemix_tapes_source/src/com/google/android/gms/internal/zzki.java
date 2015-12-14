// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzls

public final class zzki
    implements PlayerInfo
{

    private final int zzUF;
    private final JSONObject zzWD;
    private final boolean zzWE;
    private final String zzWn;

    public zzki(String s, int i, JSONObject jsonobject, boolean flag)
    {
        zzWn = s;
        zzUF = i;
        zzWD = jsonobject;
        zzWE = flag;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof PlayerInfo))
        {
            if (zzWE == ((PlayerInfo) (obj = (PlayerInfo)obj)).isControllable() && zzUF == ((PlayerInfo) (obj)).getPlayerState() && zzf.zza(zzWn, ((PlayerInfo) (obj)).getPlayerId()) && zzls.zzd(zzWD, ((PlayerInfo) (obj)).getPlayerData()))
            {
                return true;
            }
        }
        return false;
    }

    public JSONObject getPlayerData()
    {
        return zzWD;
    }

    public String getPlayerId()
    {
        return zzWn;
    }

    public int getPlayerState()
    {
        return zzUF;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzWn, Integer.valueOf(zzUF), zzWD, Boolean.valueOf(zzWE)
        });
    }

    public boolean isConnected()
    {
        switch (zzUF)
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
        return zzWE;
    }
}
