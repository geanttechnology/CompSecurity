// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzf;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzmu

public final class zzku
{

    private final int zzWw;
    private final String zzYf;
    private final JSONObject zzYv;

    public zzku(String s, int i, JSONObject jsonobject)
    {
        zzYf = s;
        zzWw = i;
        zzYv = jsonobject;
    }

    public zzku(JSONObject jsonobject)
        throws JSONException
    {
        this(jsonobject.optString("playerId"), jsonobject.optInt("playerState"), jsonobject.optJSONObject("playerData"));
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof zzku))
        {
            if (zzWw == ((zzku) (obj = (zzku)obj)).getPlayerState() && zzf.zza(zzYf, ((zzku) (obj)).getPlayerId()) && zzmu.zzd(zzYv, ((zzku) (obj)).getPlayerData()))
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
}
