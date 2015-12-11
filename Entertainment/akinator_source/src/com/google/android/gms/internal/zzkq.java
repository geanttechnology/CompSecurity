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
//            zzku, zzkp

public class zzkq
{

    private static final zzl zzVo = new zzl("GameManagerMessage");
    protected final zzkp zzXM;
    protected final String zzYf;
    protected final long zzYg;
    protected final JSONObject zzYh;
    protected final int zzYl;
    protected final int zzYm;
    protected final String zzYn;
    protected final int zzYo;
    protected final int zzYp;
    protected final List zzYq;
    protected final JSONObject zzYr;
    protected final String zzYs;
    protected final String zzYt;

    public zzkq(int i, int j, String s, JSONObject jsonobject, int k, int l, List list, 
            JSONObject jsonobject1, String s1, String s2, long l1, String s3, zzkp zzkp1)
    {
        zzYl = i;
        zzYm = j;
        zzYn = s;
        zzYh = jsonobject;
        zzYo = k;
        zzYp = l;
        zzYq = list;
        zzYr = jsonobject1;
        zzYs = s1;
        zzYf = s2;
        zzYg = l1;
        zzYt = s3;
        zzXM = zzkp1;
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
                        obj = new zzku(((JSONObject) (obj)));
                    }
                    catch (JSONException jsonexception)
                    {
                        zzVo.zzc(jsonexception, "Exception when attempting to parse PlayerInfoMessageComponent at index %d", new Object[] {
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

    protected static zzkq zzh(JSONObject jsonobject)
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
            zzVo.zzf("Unrecognized Game Message type %d", new Object[] {
                Integer.valueOf(i)
            });
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            zzVo.zzc(jsonobject, "Exception while parsing GameManagerMessage from json", new Object[0]);
        }
        break; /* Loop/switch isn't completed */
_L3:
        jsonobject = new zzkq(i, jsonobject.optInt("statusCode"), jsonobject.optString("errorDescription"), jsonobject.optJSONObject("extraMessageData"), jsonobject.optInt("gameplayState"), jsonobject.optInt("lobbyState"), zza(jsonobject.optJSONArray("players")), jsonobject.optJSONObject("gameData"), jsonobject.optString("gameStatusText"), jsonobject.optString("playerId"), -1L, null, null);
        return jsonobject;
_L2:
        zzkp zzkp1 = null;
        JSONObject jsonobject1 = jsonobject.optJSONObject("gameManagerConfig");
        if (jsonobject1 == null) goto _L5; else goto _L4
_L4:
        zzkp1 = new zzkp(jsonobject1);
_L5:
        jsonobject = new zzkq(i, jsonobject.optInt("statusCode"), jsonobject.optString("errorDescription"), jsonobject.optJSONObject("extraMessageData"), jsonobject.optInt("gameplayState"), jsonobject.optInt("lobbyState"), zza(jsonobject.optJSONArray("players")), jsonobject.optJSONObject("gameData"), jsonobject.optString("gameStatusText"), jsonobject.optString("playerId"), jsonobject.optLong("requestId"), jsonobject.optString("playerToken"), zzkp1);
        return jsonobject;
        return null;
    }

    public final JSONObject getExtraMessageData()
    {
        return zzYh;
    }

    public final JSONObject getGameData()
    {
        return zzYr;
    }

    public final int getGameplayState()
    {
        return zzYo;
    }

    public final int getLobbyState()
    {
        return zzYp;
    }

    public final String getPlayerId()
    {
        return zzYf;
    }

    public final long getRequestId()
    {
        return zzYg;
    }

    public final int getStatusCode()
    {
        return zzYm;
    }

    public final int zzmI()
    {
        return zzYl;
    }

    public final String zzmJ()
    {
        return zzYn;
    }

    public final List zzmK()
    {
        return zzYq;
    }

    public final String zzmL()
    {
        return zzYs;
    }

    public final String zzmM()
    {
        return zzYt;
    }

    public final zzkp zzmN()
    {
        return zzXM;
    }

}
