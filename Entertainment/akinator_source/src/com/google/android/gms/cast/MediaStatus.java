// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.util.SparseArray;
import com.google.android.gms.cast.internal.zzf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaInfo, MediaQueueItem

public final class MediaStatus
{
    private class zza
    {

        private int zzWF;
        private List zzWG;
        private SparseArray zzWH;
        final MediaStatus zzWI;

        private void clear()
        {
            zzWF = 0;
            zzWG.clear();
            zzWH.clear();
        }

        static void zza(zza zza1)
        {
            zza1.clear();
        }

        private void zza(MediaQueueItem amediaqueueitem[])
        {
            zzWG.clear();
            zzWH.clear();
            for (int i = 0; i < amediaqueueitem.length; i++)
            {
                MediaQueueItem mediaqueueitem = amediaqueueitem[i];
                zzWG.add(mediaqueueitem);
                zzWH.put(mediaqueueitem.getItemId(), Integer.valueOf(i));
            }

        }

        static boolean zza(zza zza1, JSONObject jsonobject)
            throws JSONException
        {
            return zza1.zzg(jsonobject);
        }

        private Integer zzaU(int i)
        {
            return (Integer)zzWH.get(i);
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
            k = zzWF;
            obj = jsonobject.getString("repeatMode");
            i = -1;
            ((String) (obj)).hashCode();
            JVM INSTR lookupswitch 4: default 76
        //                       -1118317585: 244
        //                       -962896020: 229
        //                       1645938909: 214
        //                       1645952171: 199;
               goto _L3 _L4 _L5 _L6 _L7
_L3:
            i;
            JVM INSTR tableswitch 0 3: default 108
        //                       0 259
        //                       1 265
        //                       2 112
        //                       3 271;
               goto _L8 _L9 _L10 _L11 _L12
_L8:
            j = k;
_L11:
            if (zzWF == j) goto _L2; else goto _L13
_L13:
            boolean flag;
            zzWF = j;
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
                    MediaQueueItem mediaqueueitem = zzaS(integer.intValue());
                    if (mediaqueueitem != null)
                    {
                        boolean flag2 = mediaqueueitem.zzg(jsonobject1);
                        amediaqueueitem[i] = mediaqueueitem;
                        if (i != zzaU(integer.intValue()).intValue())
                        {
                            flag = true;
                        } else
                        {
                            flag |= flag2;
                        }
                    } else
                    if (integer.intValue() == MediaStatus.zza(zzWI))
                    {
                        amediaqueueitem[i] = (new MediaQueueItem.Builder(MediaStatus.zzb(zzWI))).build();
                        amediaqueueitem[i].zzg(jsonobject1);
                        flag = true;
                    } else
                    {
                        amediaqueueitem[i] = new MediaQueueItem(jsonobject1);
                        flag = true;
                    }
                    i++;
                }
                if (zzWG.size() != j)
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
            return zzWG.size();
        }

        public int getRepeatMode()
        {
            return zzWF;
        }

        public MediaQueueItem zzaS(int i)
        {
            Integer integer = (Integer)zzWH.get(i);
            if (integer == null)
            {
                return null;
            } else
            {
                return (MediaQueueItem)zzWG.get(integer.intValue());
            }
        }

        public MediaQueueItem zzaT(int i)
        {
            if (i < 0 || i >= zzWG.size())
            {
                return null;
            } else
            {
                return (MediaQueueItem)zzWG.get(i);
            }
        }

        public List zzmz()
        {
            return Collections.unmodifiableList(zzWG);
        }

        zza()
        {
            zzWI = MediaStatus.this;
            super();
            zzWF = 0;
            zzWG = new ArrayList();
            zzWH = new SparseArray();
        }
    }


    public static final long COMMAND_PAUSE = 1L;
    public static final long COMMAND_SEEK = 2L;
    public static final long COMMAND_SET_VOLUME = 4L;
    public static final long COMMAND_SKIP_BACKWARD = 32L;
    public static final long COMMAND_SKIP_FORWARD = 16L;
    public static final long COMMAND_TOGGLE_MUTE = 8L;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int REPEAT_MODE_REPEAT_ALL = 1;
    public static final int REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE = 3;
    public static final int REPEAT_MODE_REPEAT_OFF = 0;
    public static final int REPEAT_MODE_REPEAT_SINGLE = 2;
    private double zzWA;
    private boolean zzWB;
    private int zzWC;
    private int zzWD;
    private final zza zzWE = new zza();
    private JSONObject zzWc;
    private MediaInfo zzWd;
    private long zzWr[];
    private int zzWt;
    private long zzWu;
    private double zzWv;
    private int zzWw;
    private int zzWx;
    private long zzWy;
    private long zzWz;

    public MediaStatus(JSONObject jsonobject)
        throws JSONException
    {
        zzWt = 0;
        zzWC = 0;
        zzWD = 0;
        zza(jsonobject, 0);
    }

    static int zza(MediaStatus mediastatus)
    {
        return mediastatus.zzWt;
    }

    static MediaInfo zzb(MediaStatus mediastatus)
    {
        return mediastatus.zzWd;
    }

    private boolean zzh(int i, int j)
    {
        return i == 1 && j == 0;
    }

    public long[] getActiveTrackIds()
    {
        return zzWr;
    }

    public int getCurrentItemId()
    {
        return zzWt;
    }

    public JSONObject getCustomData()
    {
        return zzWc;
    }

    public int getIdleReason()
    {
        return zzWx;
    }

    public int getLoadingItemId()
    {
        return zzWC;
    }

    public MediaInfo getMediaInfo()
    {
        return zzWd;
    }

    public double getPlaybackRate()
    {
        return zzWv;
    }

    public int getPlayerState()
    {
        return zzWw;
    }

    public int getPreloadedItemId()
    {
        return zzWD;
    }

    public MediaQueueItem getQueueItem(int i)
    {
        return zzWE.zzaT(i);
    }

    public MediaQueueItem getQueueItemById(int i)
    {
        return zzWE.zzaS(i);
    }

    public int getQueueItemCount()
    {
        return zzWE.getItemCount();
    }

    public List getQueueItems()
    {
        return zzWE.zzmz();
    }

    public int getQueueRepeatMode()
    {
        return zzWE.getRepeatMode();
    }

    public long getStreamPosition()
    {
        return zzWy;
    }

    public double getStreamVolume()
    {
        return zzWA;
    }

    public boolean isMediaCommandSupported(long l)
    {
        return (zzWz & l) != 0L;
    }

    public boolean isMute()
    {
        return zzWB;
    }

    public int zza(JSONObject jsonobject, int i)
        throws JSONException
    {
        byte byte0 = 2;
        boolean flag = true;
        long l1 = jsonobject.getLong("mediaSessionId");
        int k;
        int l;
        if (l1 != zzWu)
        {
            zzWu = l1;
            k = 1;
        } else
        {
            k = 0;
        }
        l = k;
        if (jsonobject.has("playerState"))
        {
            Object obj = jsonobject.getString("playerState");
            int j;
            int i1;
            if (((String) (obj)).equals("IDLE"))
            {
                j = 1;
            } else
            if (((String) (obj)).equals("PLAYING"))
            {
                j = 2;
            } else
            if (((String) (obj)).equals("PAUSED"))
            {
                j = 3;
            } else
            if (((String) (obj)).equals("BUFFERING"))
            {
                j = 4;
            } else
            {
                j = 0;
            }
            i1 = k;
            if (j != zzWw)
            {
                zzWw = j;
                i1 = k | 2;
            }
            l = i1;
            if (j == 1)
            {
                l = i1;
                if (jsonobject.has("idleReason"))
                {
                    obj = jsonobject.getString("idleReason");
                    double d;
                    JSONArray jsonarray;
                    long l2;
                    boolean flag1;
                    if (((String) (obj)).equals("CANCELLED"))
                    {
                        j = byte0;
                    } else
                    if (((String) (obj)).equals("INTERRUPTED"))
                    {
                        j = 3;
                    } else
                    if (((String) (obj)).equals("FINISHED"))
                    {
                        j = 1;
                    } else
                    if (((String) (obj)).equals("ERROR"))
                    {
                        j = 4;
                    } else
                    {
                        j = 0;
                    }
                    l = i1;
                    if (j != zzWx)
                    {
                        zzWx = j;
                        l = i1 | 2;
                    }
                }
            }
        }
        j = l;
        if (jsonobject.has("playbackRate"))
        {
            d = jsonobject.getDouble("playbackRate");
            j = l;
            if (zzWv != d)
            {
                zzWv = d;
                j = l | 2;
            }
        }
        l = j;
        if (jsonobject.has("currentTime"))
        {
            l = j;
            if ((i & 2) == 0)
            {
                l2 = zzf.zzg(jsonobject.getDouble("currentTime"));
                l = j;
                if (l2 != zzWy)
                {
                    zzWy = l2;
                    l = j | 2;
                }
            }
        }
        k = l;
        if (jsonobject.has("supportedMediaCommands"))
        {
            l2 = jsonobject.getLong("supportedMediaCommands");
            k = l;
            if (l2 != zzWz)
            {
                zzWz = l2;
                k = l | 2;
            }
        }
        j = k;
        if (jsonobject.has("volume"))
        {
            j = k;
            if ((i & 1) == 0)
            {
                obj = jsonobject.getJSONObject("volume");
                d = ((JSONObject) (obj)).getDouble("level");
                i = k;
                if (d != zzWA)
                {
                    zzWA = d;
                    i = k | 2;
                }
                flag1 = ((JSONObject) (obj)).getBoolean("muted");
                j = i;
                if (flag1 != zzWB)
                {
                    zzWB = flag1;
                    j = i | 2;
                }
            }
        }
        if (!jsonobject.has("activeTrackIds")) goto _L2; else goto _L1
_L1:
        jsonarray = jsonobject.getJSONArray("activeTrackIds");
        l = jsonarray.length();
        obj = new long[l];
        for (i = 0; i < l; i++)
        {
            obj[i] = jsonarray.getLong(i);
        }

        if (zzWr != null) goto _L4; else goto _L3
_L3:
        i = ((flag) ? 1 : 0);
_L8:
        if (i != 0)
        {
            zzWr = ((long []) (obj));
        }
        k = i;
_L6:
        i = j;
        if (k != 0)
        {
            zzWr = ((long []) (obj));
            i = j | 2;
        }
        j = i;
        if (jsonobject.has("customData"))
        {
            zzWc = jsonobject.getJSONObject("customData");
            j = i | 2;
        }
        i = j;
        if (jsonobject.has("media"))
        {
            obj = jsonobject.getJSONObject("media");
            zzWd = new MediaInfo(((JSONObject) (obj)));
            j |= 2;
            i = j;
            if (((JSONObject) (obj)).has("metadata"))
            {
                i = j | 4;
            }
        }
        j = i;
        if (jsonobject.has("currentItemId"))
        {
            k = jsonobject.getInt("currentItemId");
            j = i;
            if (zzWt != k)
            {
                zzWt = k;
                j = i | 2;
            }
        }
        k = jsonobject.optInt("preloadedItemId", 0);
        i = j;
        if (zzWD != k)
        {
            zzWD = k;
            i = j | 0x10;
        }
        k = jsonobject.optInt("loadingItemId", 0);
        j = i;
        if (zzWC != k)
        {
            zzWC = k;
            j = i | 2;
        }
        if (!zzh(zzWw, zzWC))
        {
            i = j;
            if (zza.zza(zzWE, jsonobject))
            {
                i = j | 8;
            }
        } else
        {
            zzWt = 0;
            zzWC = 0;
            zzWD = 0;
            i = j;
            if (zzWE.getItemCount() > 0)
            {
                zza.zza(zzWE);
                return j | 8;
            }
        }
        return i;
_L4:
        i = ((flag) ? 1 : 0);
        if (zzWr.length != l)
        {
            continue; /* Loop/switch isn't completed */
        }
        for (k = 0; k < l; k++)
        {
            i = ((flag) ? 1 : 0);
            if (zzWr[k] != obj[k])
            {
                continue; /* Loop/switch isn't completed */
            }
        }

        break; /* Loop/switch isn't completed */
_L2:
        if (zzWr != null)
        {
            k = 1;
            obj = null;
        } else
        {
            obj = null;
            k = 0;
        }
        if (true) goto _L6; else goto _L5
_L5:
        i = 0;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public long zzmy()
    {
        return zzWu;
    }
}
