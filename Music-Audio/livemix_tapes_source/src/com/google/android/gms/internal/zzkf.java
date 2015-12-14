// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzkj, zzke

public class zzkf
{

    private static final zzl zzTy = new zzl("GameManagerMessage");
    protected final zzke zzVU;
    protected final String zzWA;
    protected final String zzWB;
    protected final String zzWn;
    protected final long zzWo;
    protected final JSONObject zzWp;
    protected final int zzWt;
    protected final int zzWu;
    protected final String zzWv;
    protected final int zzWw;
    protected final int zzWx;
    protected final List zzWy;
    protected final JSONObject zzWz;

    public zzkf(int i, int j, String s, JSONObject jsonobject, int k, int l, List list, 
            JSONObject jsonobject1, String s1, String s2, long l1, String s3, zzke zzke1)
    {
        zzWt = i;
        zzWu = j;
        zzWv = s;
        zzWp = jsonobject;
        zzWw = k;
        zzWx = l;
        zzWy = list;
        zzWz = jsonobject1;
        zzWA = s1;
        zzWn = s2;
        zzWo = l1;
        zzWB = s3;
        zzVU = zzke1;
    }

    private static List zza(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray == null)
        {
            return arraylist;
        }
        int i = 0;
        do
        {
            while (i < jsonarray.length()) 
            {
                Object obj = jsonarray.optJSONObject(i);
                if (obj != null)
                {
                    try
                    {
                        obj = new zzkj(((JSONObject) (obj)));
                    }
                    catch (JSONException jsonexception)
                    {
                        zzTy.zzc(jsonexception, "Exception when attempting to parse PlayerInfoMessageComponent at index %d", new Object[] {
                            Integer.valueOf(i)
                        });
                        jsonexception = null;
                    }
                    if (obj != null)
                    {
                        arraylist.add(obj);
                    }
                }
                i++;
            }
            return arraylist;
        } while (true);
    }

    protected static zzkf zzh(JSONObject jsonobject)
    {
        int i = jsonobject.optInt("type", -1);
        i;
        JVM INSTR tableswitch 1 2: default 32
    //                   1 144
    //                   2 54;
           goto _L1 _L2 _L3
_L1:
        try
        {
            zzTy.zzf("Unrecognized Game Message type %d", new Object[] {
                Integer.valueOf(i)
            });
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            zzTy.zzc(jsonobject, "Exception while parsing GameManagerMessage from json", new Object[0]);
        }
        break; /* Loop/switch isn't completed */
_L3:
        jsonobject = new zzkf(i, jsonobject.optInt("statusCode"), jsonobject.optString("errorDescription"), jsonobject.optJSONObject("extraMessageData"), jsonobject.optInt("gameplayState"), jsonobject.optInt("lobbyState"), zza(jsonobject.optJSONArray("players")), jsonobject.optJSONObject("gameData"), jsonobject.optString("gameStatusText"), jsonobject.optString("playerId"), -1L, null, null);
        return jsonobject;
_L2:
        zzke zzke1 = null;
        JSONObject jsonobject1 = jsonobject.optJSONObject("gameManagerConfig");
        if (jsonobject1 == null) goto _L5; else goto _L4
_L4:
        zzke1 = new zzke(jsonobject1);
_L5:
        jsonobject = new zzkf(i, jsonobject.optInt("statusCode"), jsonobject.optString("errorDescription"), jsonobject.optJSONObject("extraMessageData"), jsonobject.optInt("gameplayState"), jsonobject.optInt("lobbyState"), zza(jsonobject.optJSONArray("players")), jsonobject.optJSONObject("gameData"), jsonobject.optString("gameStatusText"), jsonobject.optString("playerId"), jsonobject.optLong("requestId"), jsonobject.optString("playerToken"), zzke1);
        return jsonobject;
        return null;
    }

    public final JSONObject getExtraMessageData()
    {
        return zzWp;
    }

    public final JSONObject getGameData()
    {
        return zzWz;
    }

    public final int getGameplayState()
    {
        return zzWw;
    }

    public final int getLobbyState()
    {
        return zzWx;
    }

    public final String getPlayerId()
    {
        return zzWn;
    }

    public final long getRequestId()
    {
        return zzWo;
    }

    public final int getStatusCode()
    {
        return zzWu;
    }

    public final int zzmm()
    {
        return zzWt;
    }

    public final String zzmn()
    {
        return zzWv;
    }

    public final List zzmo()
    {
        return zzWy;
    }

    public final String zzmp()
    {
        return zzWA;
    }

    public final String zzmq()
    {
        return zzWB;
    }

    public final zzke zzmr()
    {
        return zzVU;
    }

}
