// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaStatus, MediaQueueItem

private class zzUQ
{

    private int zzUO;
    private List zzUP;
    private SparseArray zzUQ;
    final MediaStatus zzUR;

    private void clear()
    {
        zzUO = 0;
        zzUP.clear();
        zzUQ.clear();
    }

    static void zza(zzUQ zzuq)
    {
        zzuq.clear();
    }

    private void zza(MediaQueueItem amediaqueueitem[])
    {
        zzUP.clear();
        zzUQ.clear();
        for (int i = 0; i < amediaqueueitem.length; i++)
        {
            MediaQueueItem mediaqueueitem = amediaqueueitem[i];
            zzUP.add(mediaqueueitem);
            zzUQ.put(mediaqueueitem.getItemId(), Integer.valueOf(i));
        }

    }

    static boolean zza(etItemId etitemid, JSONObject jsonobject)
        throws JSONException
    {
        return etitemid.zzg(jsonobject);
    }

    private Integer zzaN(int i)
    {
        return (Integer)zzUQ.get(i);
    }

    private boolean zzg(JSONObject jsonobject)
        throws JSONException
    {
        int j;
        boolean flag1;
        j = 2;
        flag1 = true;
        if (!jsonobject.has("repeatMode")) goto _L2; else goto _L1
_L1:
        Object obj;
        int i;
        int k;
        k = zzUO;
        obj = jsonobject.getString("repeatMode");
        i = -1;
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 4: default 76
    //                   -1118317585: 244
    //                   -962896020: 229
    //                   1645938909: 214
    //                   1645952171: 199;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        i;
        JVM INSTR tableswitch 0 3: default 108
    //                   0 259
    //                   1 265
    //                   2 112
    //                   3 271;
           goto _L8 _L9 _L10 _L11 _L12
_L8:
        j = k;
_L11:
        if (zzUO == j) goto _L2; else goto _L13
_L13:
        boolean flag;
        zzUO = j;
        flag = true;
_L14:
        if (jsonobject.has("items"))
        {
            jsonobject = jsonobject.getJSONArray("items");
            j = jsonobject.length();
            obj = new SparseArray();
            for (i = 0; i < j; i++)
            {
                ((SparseArray) (obj)).put(i, Integer.valueOf(jsonobject.getJSONObject(i).getInt("itemId")));
            }

            MediaQueueItem amediaqueueitem[] = new MediaQueueItem[j];
            i = 0;
            while (i < j) 
            {
                Integer integer = (Integer)((SparseArray) (obj)).get(i);
                JSONObject jsonobject1 = jsonobject.getJSONObject(i);
                MediaQueueItem mediaqueueitem = zzaL(integer.intValue());
                if (mediaqueueitem != null)
                {
                    boolean flag2 = mediaqueueitem.zzg(jsonobject1);
                    amediaqueueitem[i] = mediaqueueitem;
                    if (i != zzaN(integer.intValue()).intValue())
                    {
                        flag = true;
                    } else
                    {
                        flag |= flag2;
                    }
                } else
                if (integer.intValue() == MediaStatus.zza(zzUR))
                {
                    amediaqueueitem[i] = (new uilder(MediaStatus.zzb(zzUR))).build();
                    amediaqueueitem[i].zzg(jsonobject1);
                    flag = true;
                } else
                {
                    amediaqueueitem[i] = new MediaQueueItem(jsonobject1);
                    flag = true;
                }
                i++;
            }
            if (zzUP.size() != j)
            {
                flag = flag1;
            }
            zza(amediaqueueitem);
            return flag;
        } else
        {
            return flag;
        }
_L7:
        if (((String) (obj)).equals("REPEAT_OFF"))
        {
            i = 0;
        }
          goto _L3
_L6:
        if (((String) (obj)).equals("REPEAT_ALL"))
        {
            i = 1;
        }
          goto _L3
_L5:
        if (((String) (obj)).equals("REPEAT_SINGLE"))
        {
            i = 2;
        }
          goto _L3
_L4:
        if (((String) (obj)).equals("REPEAT_ALL_AND_SHUFFLE"))
        {
            i = 3;
        }
          goto _L3
_L9:
        j = 0;
          goto _L11
_L10:
        j = 1;
          goto _L11
_L12:
        j = 3;
          goto _L11
_L2:
        flag = false;
          goto _L14
    }

    public int getItemCount()
    {
        return zzUP.size();
    }

    public int getRepeatMode()
    {
        return zzUO;
    }

    public MediaQueueItem zzaL(int i)
    {
        Integer integer = (Integer)zzUQ.get(i);
        if (integer == null)
        {
            return null;
        } else
        {
            return (MediaQueueItem)zzUP.get(integer.intValue());
        }
    }

    public MediaQueueItem zzaM(int i)
    {
        if (i < 0 || i >= zzUP.size())
        {
            return null;
        } else
        {
            return (MediaQueueItem)zzUP.get(i);
        }
    }

    public List zzmd()
    {
        return Collections.unmodifiableList(zzUP);
    }

    uilder(MediaStatus mediastatus)
    {
        zzUR = mediastatus;
        super();
        zzUO = 0;
        zzUP = new ArrayList();
        zzUQ = new SparseArray();
    }
}
