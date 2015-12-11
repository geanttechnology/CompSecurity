// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaInfo

public class MediaQueueItem
{
    public static class Builder
    {

        private final MediaQueueItem zzWs;

        public MediaQueueItem build()
        {
            zzWs.zzmx();
            return zzWs;
        }

        public Builder clearItemId()
        {
            zzWs.zzaR(0);
            return this;
        }

        public Builder setActiveTrackIds(long al[])
        {
            zzWs.zza(al);
            return this;
        }

        public Builder setAutoplay(boolean flag)
        {
            zzWs.zzU(flag);
            return this;
        }

        public Builder setCustomData(JSONObject jsonobject)
        {
            zzWs.setCustomData(jsonobject);
            return this;
        }

        public Builder setPlaybackDuration(double d)
        {
            zzWs.zzd(d);
            return this;
        }

        public Builder setPreloadTime(double d)
            throws IllegalArgumentException
        {
            zzWs.zze(d);
            return this;
        }

        public Builder setStartTime(double d)
            throws IllegalArgumentException
        {
            zzWs.zzc(d);
            return this;
        }

        public Builder(MediaInfo mediainfo)
            throws IllegalArgumentException
        {
            zzWs = new MediaQueueItem(mediainfo);
        }

        public Builder(MediaQueueItem mediaqueueitem)
            throws IllegalArgumentException
        {
            zzWs = new MediaQueueItem(mediaqueueitem);
        }

        public Builder(JSONObject jsonobject)
            throws JSONException
        {
            zzWs = new MediaQueueItem(jsonobject);
        }
    }


    public static final double DEFAULT_PLAYBACK_DURATION = (1.0D / 0.0D);
    public static final int INVALID_ITEM_ID = 0;
    private JSONObject zzWc;
    private MediaInfo zzWl;
    private int zzWm;
    private boolean zzWn;
    private double zzWo;
    private double zzWp;
    private double zzWq;
    private long zzWr[];

    private MediaQueueItem(MediaInfo mediainfo)
        throws IllegalArgumentException
    {
        zzWm = 0;
        zzWn = true;
        zzWp = (1.0D / 0.0D);
        if (mediainfo == null)
        {
            throw new IllegalArgumentException("media cannot be null.");
        } else
        {
            zzWl = mediainfo;
            return;
        }
    }


    private MediaQueueItem(MediaQueueItem mediaqueueitem)
        throws IllegalArgumentException
    {
        zzWm = 0;
        zzWn = true;
        zzWp = (1.0D / 0.0D);
        zzWl = mediaqueueitem.getMedia();
        if (zzWl == null)
        {
            throw new IllegalArgumentException("media cannot be null.");
        } else
        {
            zzWm = mediaqueueitem.getItemId();
            zzWn = mediaqueueitem.getAutoplay();
            zzWo = mediaqueueitem.getStartTime();
            zzWp = mediaqueueitem.getPlaybackDuration();
            zzWq = mediaqueueitem.getPreloadTime();
            zzWr = mediaqueueitem.getActiveTrackIds();
            zzWc = mediaqueueitem.getCustomData();
            return;
        }
    }


    MediaQueueItem(JSONObject jsonobject)
        throws JSONException
    {
        zzWm = 0;
        zzWn = true;
        zzWp = (1.0D / 0.0D);
        zzg(jsonobject);
    }

    public boolean equals(Object obj)
    {
        boolean flag4;
        boolean flag5;
        flag4 = true;
        flag5 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag2 = true;
_L4:
        return flag2;
_L2:
        flag2 = flag5;
        if (!(obj instanceof MediaQueueItem)) goto _L4; else goto _L3
_L3:
        obj = (MediaQueueItem)obj;
        boolean flag;
        boolean flag1;
        if (zzWc == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((MediaQueueItem) (obj)).zzWc == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag5;
        if (flag != flag1) goto _L4; else goto _L5
_L5:
        if (zzWc == null || ((MediaQueueItem) (obj)).zzWc == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag5;
        if (!zzmu.zzd(zzWc, ((MediaQueueItem) (obj)).zzWc)) goto _L4; else goto _L6
_L6:
        boolean flag3;
        if (zzf.zza(zzWl, ((MediaQueueItem) (obj)).zzWl) && zzWm == ((MediaQueueItem) (obj)).zzWm && zzWn == ((MediaQueueItem) (obj)).zzWn && zzWo == ((MediaQueueItem) (obj)).zzWo && zzWp == ((MediaQueueItem) (obj)).zzWp && zzWq == ((MediaQueueItem) (obj)).zzWq && zzf.zza(zzWr, ((MediaQueueItem) (obj)).zzWr))
        {
            flag3 = flag4;
        } else
        {
            flag3 = false;
        }
        return flag3;
    }

    public long[] getActiveTrackIds()
    {
        return zzWr;
    }

    public boolean getAutoplay()
    {
        return zzWn;
    }

    public JSONObject getCustomData()
    {
        return zzWc;
    }

    public int getItemId()
    {
        return zzWm;
    }

    public MediaInfo getMedia()
    {
        return zzWl;
    }

    public double getPlaybackDuration()
    {
        return zzWp;
    }

    public double getPreloadTime()
    {
        return zzWq;
    }

    public double getStartTime()
    {
        return zzWo;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzWl, Integer.valueOf(zzWm), Boolean.valueOf(zzWn), Double.valueOf(zzWo), Double.valueOf(zzWp), Double.valueOf(zzWq), zzWr, String.valueOf(zzWc)
        });
    }

    void setCustomData(JSONObject jsonobject)
    {
        zzWc = jsonobject;
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray;
        long al[];
        int j;
        jsonobject.put("media", zzWl.toJson());
        if (zzWm != 0)
        {
            jsonobject.put("itemId", zzWm);
        }
        jsonobject.put("autoplay", zzWn);
        jsonobject.put("startTime", zzWo);
        if (zzWp != (1.0D / 0.0D))
        {
            jsonobject.put("playbackDuration", zzWp);
        }
        jsonobject.put("preloadTime", zzWq);
        if (zzWr == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        jsonarray = new JSONArray();
        al = zzWr;
        j = al.length;
        int i = 0;
        while (i < j) 
        {
            try
            {
                jsonarray.put(al[i]);
            }
            catch (JSONException jsonexception)
            {
                return jsonobject;
            }
            i++;
        }
        jsonobject.put("activeTrackIds", jsonarray);
        if (zzWc != null)
        {
            jsonobject.put("customData", zzWc);
        }
        return jsonobject;
    }

    void zzU(boolean flag)
    {
        zzWn = flag;
    }

    void zza(long al[])
    {
        zzWr = al;
    }

    void zzaR(int i)
    {
        zzWm = i;
    }

    void zzc(double d)
        throws IllegalArgumentException
    {
        if (Double.isNaN(d) || d < 0.0D)
        {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        } else
        {
            zzWo = d;
            return;
        }
    }

    void zzd(double d)
        throws IllegalArgumentException
    {
        if (Double.isNaN(d))
        {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        } else
        {
            zzWp = d;
            return;
        }
    }

    void zze(double d)
        throws IllegalArgumentException
    {
        if (Double.isNaN(d) || d < 0.0D)
        {
            throw new IllegalArgumentException("preloadTime cannot be negative or NaN.");
        } else
        {
            zzWq = d;
            return;
        }
    }

    public boolean zzg(JSONObject jsonobject)
        throws JSONException
    {
        long al[];
        JSONArray jsonarray;
        int j;
        int k;
        boolean flag;
        boolean flag1;
        if (jsonobject.has("media"))
        {
            zzWl = new MediaInfo(jsonobject.getJSONObject("media"));
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag = flag1;
        if (jsonobject.has("itemId"))
        {
            int i = jsonobject.getInt("itemId");
            flag = flag1;
            if (zzWm != i)
            {
                zzWm = i;
                flag = true;
            }
        }
        flag1 = flag;
        if (jsonobject.has("autoplay"))
        {
            boolean flag2 = jsonobject.getBoolean("autoplay");
            flag1 = flag;
            if (zzWn != flag2)
            {
                zzWn = flag2;
                flag1 = true;
            }
        }
        flag = flag1;
        if (jsonobject.has("startTime"))
        {
            double d = jsonobject.getDouble("startTime");
            flag = flag1;
            if (Math.abs(d - zzWo) > 9.9999999999999995E-08D)
            {
                zzWo = d;
                flag = true;
            }
        }
        flag1 = flag;
        if (jsonobject.has("playbackDuration"))
        {
            double d1 = jsonobject.getDouble("playbackDuration");
            flag1 = flag;
            if (Math.abs(d1 - zzWp) > 9.9999999999999995E-08D)
            {
                zzWp = d1;
                flag1 = true;
            }
        }
        flag = flag1;
        if (jsonobject.has("preloadTime"))
        {
            double d2 = jsonobject.getDouble("preloadTime");
            flag = flag1;
            if (Math.abs(d2 - zzWq) > 9.9999999999999995E-08D)
            {
                zzWq = d2;
                flag = true;
            }
        }
        if (!jsonobject.has("activeTrackIds")) goto _L2; else goto _L1
_L1:
        jsonarray = jsonobject.getJSONArray("activeTrackIds");
        k = jsonarray.length();
        al = new long[k];
        for (j = 0; j < k; j++)
        {
            al[j] = jsonarray.getLong(j);
        }

        if (zzWr != null) goto _L4; else goto _L3
_L3:
        j = 1;
_L6:
        if (j != 0)
        {
            zzWr = al;
            flag = true;
        }
        if (jsonobject.has("customData"))
        {
            zzWc = jsonobject.getJSONObject("customData");
            return true;
        } else
        {
            return flag;
        }
_L4:
        if (zzWr.length != k)
        {
            j = 1;
            continue; /* Loop/switch isn't completed */
        }
        j = 0;
        do
        {
            if (j >= k)
            {
                break;
            }
            if (zzWr[j] != al[j])
            {
                j = 1;
                continue; /* Loop/switch isn't completed */
            }
            j++;
        } while (true);
        j = 0;
        continue; /* Loop/switch isn't completed */
_L2:
        j = 0;
        al = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    void zzmx()
        throws IllegalArgumentException
    {
        if (zzWl == null)
        {
            throw new IllegalArgumentException("media cannot be null.");
        }
        if (Double.isNaN(zzWo) || zzWo < 0.0D)
        {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        if (Double.isNaN(zzWp))
        {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }
        if (Double.isNaN(zzWq) || zzWq < 0.0D)
        {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        } else
        {
            return;
        }
    }
}
