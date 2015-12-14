// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzf;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzls

public final class zzkj
{

    private final int zzUF;
    private final JSONObject zzWD;
    private final String zzWn;

    public zzkj(String s, int i, JSONObject jsonobject)
    {
        zzWn = s;
        zzUF = i;
        zzWD = jsonobject;
    }

    public zzkj(JSONObject jsonobject)
        throws JSONException
    {
        this(jsonobject.optString("playerId"), jsonobject.optInt("playerState"), jsonobject.optJSONObject("playerData"));
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof zzkj))
        {
            if (zzUF == ((zzkj) (obj = (zzkj)obj)).getPlayerState() && zzf.zza(zzWn, ((zzkj) (obj)).getPlayerId()) && zzls.zzd(zzWD, ((zzkj) (obj)).getPlayerData()))
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
}
