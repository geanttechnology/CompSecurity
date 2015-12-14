// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzls;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaInfo

public class MediaQueueItem
{
    public static class Builder
    {

        private final MediaQueueItem zzUB;

        public MediaQueueItem build()
        {
            zzUB.zzma();
            return zzUB;
        }

        public Builder clearItemId()
        {
            zzUB.zzaK(0);
            return this;
        }

        public Builder setActiveTrackIds(long al[])
        {
            zzUB.zza(al);
            return this;
        }

        public Builder setAutoplay(boolean flag)
        {
            zzUB.zzT(flag);
            return this;
        }

        public Builder setCustomData(JSONObject jsonobject)
        {
            zzUB.setCustomData(jsonobject);
            return this;
        }

        public Builder setPreloadTime(double d)
            throws IllegalArgumentException
        {
            zzUB.zzd(d);
            return this;
        }

        public Builder setStartTime(double d)
            throws IllegalArgumentException
        {
            zzUB.zzc(d);
            return this;
        }

        public Builder(MediaInfo mediainfo)
            throws IllegalArgumentException
        {
            zzUB = new MediaQueueItem(mediainfo);
        }

        public Builder(MediaQueueItem mediaqueueitem)
            throws IllegalArgumentException
        {
            zzUB = new MediaQueueItem(mediaqueueitem);
        }

        public Builder(JSONObject jsonobject)
            throws JSONException
        {
            zzUB = new MediaQueueItem(jsonobject);
        }
    }


    public static final double DEFAULT_PLAYBACK_DURATION = (1.0D / 0.0D);
    public static final int INVALID_ITEM_ID = 0;
    private long zzUA[];
    private JSONObject zzUl;
    private MediaInfo zzUu;
    private int zzUv;
    private boolean zzUw;
    private double zzUx;
    private double zzUy;
    private double zzUz;

    private MediaQueueItem(MediaInfo mediainfo)
        throws IllegalArgumentException
    {
        zzUv = 0;
        zzUw = true;
        zzUy = (1.0D / 0.0D);
        if (mediainfo == null)
        {
            throw new IllegalArgumentException("media cannot be null.");
        } else
        {
            zzUu = mediainfo;
            return;
        }
    }


    private MediaQueueItem(MediaQueueItem mediaqueueitem)
        throws IllegalArgumentException
    {
        zzUv = 0;
        zzUw = true;
        zzUy = (1.0D / 0.0D);
        zzUu = mediaqueueitem.getMedia();
        if (zzUu == null)
        {
            throw new IllegalArgumentException("media cannot be null.");
        } else
        {
            zzUv = mediaqueueitem.getItemId();
            zzUw = mediaqueueitem.getAutoplay();
            zzUx = mediaqueueitem.getStartTime();
            zzUy = mediaqueueitem.zzmb();
            zzUz = mediaqueueitem.getPreloadTime();
            zzUA = mediaqueueitem.getActiveTrackIds();
            zzUl = mediaqueueitem.getCustomData();
            return;
        }
    }


    MediaQueueItem(JSONObject jsonobject)
        throws JSONException
    {
        zzUv = 0;
        zzUw = true;
        zzUy = (1.0D / 0.0D);
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
        if (zzUl == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((MediaQueueItem) (obj)).zzUl == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag5;
        if (flag != flag1) goto _L4; else goto _L5
_L5:
        if (zzUl == null || ((MediaQueueItem) (obj)).zzUl == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag5;
        if (!zzls.zzd(zzUl, ((MediaQueueItem) (obj)).zzUl)) goto _L4; else goto _L6
_L6:
        boolean flag3;
        if (zzf.zza(zzUu, ((MediaQueueItem) (obj)).zzUu) && zzUv == ((MediaQueueItem) (obj)).zzUv && zzUw == ((MediaQueueItem) (obj)).zzUw && zzUx == ((MediaQueueItem) (obj)).zzUx && zzUy == ((MediaQueueItem) (obj)).zzUy && zzUz == ((MediaQueueItem) (obj)).zzUz && zzf.zza(zzUA, ((MediaQueueItem) (obj)).zzUA))
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
        return zzUA;
    }

    public boolean getAutoplay()
    {
        return zzUw;
    }

    public JSONObject getCustomData()
    {
        return zzUl;
    }

    public int getItemId()
    {
        return zzUv;
    }

    public MediaInfo getMedia()
    {
        return zzUu;
    }

    public double getPreloadTime()
    {
        return zzUz;
    }

    public double getStartTime()
    {
        return zzUx;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzUu, Integer.valueOf(zzUv), Boolean.valueOf(zzUw), Double.valueOf(zzUx), Double.valueOf(zzUy), Double.valueOf(zzUz), zzUA, String.valueOf(zzUl)
        });
    }

    void setCustomData(JSONObject jsonobject)
    {
        zzUl = jsonobject;
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray;
        long al[];
        int j;
        jsonobject.put("media", zzUu.toJson());
        if (zzUv != 0)
        {
            jsonobject.put("itemId", zzUv);
        }
        jsonobject.put("autoplay", zzUw);
        jsonobject.put("startTime", zzUx);
        if (zzUy != (1.0D / 0.0D))
        {
            jsonobject.put("playbackDuration", zzUy);
        }
        jsonobject.put("preloadTime", zzUz);
        if (zzUA == null || zzUA.length <= 0)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        jsonarray = new JSONArray();
        al = zzUA;
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
        if (zzUl != null)
        {
            jsonobject.put("customData", zzUl);
        }
        return jsonobject;
    }

    void zzT(boolean flag)
    {
        zzUw = flag;
    }

    void zza(long al[])
    {
        zzUA = al;
    }

    void zzaK(int i)
    {
        zzUv = i;
    }

    void zzc(double d)
        throws IllegalArgumentException
    {
        if (Double.isNaN(d) || d < 0.0D)
        {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        } else
        {
            zzUx = d;
            return;
        }
    }

    void zzd(double d)
        throws IllegalArgumentException
    {
        if (Double.isNaN(d) || d < 0.0D)
        {
            throw new IllegalArgumentException("preloadTime cannot be negative or NaN.");
        } else
        {
            zzUz = d;
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
            zzUu = new MediaInfo(jsonobject.getJSONObject("media"));
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
            if (zzUv != i)
            {
                zzUv = i;
                flag = true;
            }
        }
        flag1 = flag;
        if (jsonobject.has("autoplay"))
        {
            boolean flag2 = jsonobject.getBoolean("autoplay");
            flag1 = flag;
            if (zzUw != flag2)
            {
                zzUw = flag2;
                flag1 = true;
            }
        }
        flag = flag1;
        if (jsonobject.has("startTime"))
        {
            double d = jsonobject.getDouble("startTime");
            flag = flag1;
            if (Math.abs(d - zzUx) > 9.9999999999999995E-08D)
            {
                zzUx = d;
                flag = true;
            }
        }
        flag1 = flag;
        if (jsonobject.has("playbackDuration"))
        {
            double d1 = jsonobject.getDouble("playbackDuration");
            flag1 = flag;
            if (Math.abs(d1 - zzUy) > 9.9999999999999995E-08D)
            {
                zzUy = d1;
                flag1 = true;
            }
        }
        flag = flag1;
        if (jsonobject.has("preloadTime"))
        {
            double d2 = jsonobject.getDouble("preloadTime");
            flag = flag1;
            if (Math.abs(d2 - zzUz) > 9.9999999999999995E-08D)
            {
                zzUz = d2;
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

        if (zzUA != null) goto _L4; else goto _L3
_L3:
        j = 1;
_L6:
        if (j != 0)
        {
            zzUA = al;
            flag = true;
        }
        if (jsonobject.has("customData"))
        {
            zzUl = jsonobject.getJSONObject("customData");
            return true;
        } else
        {
            return flag;
        }
_L4:
        if (zzUA.length != k)
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
            if (zzUA[j] != al[j])
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

    void zzma()
        throws IllegalArgumentException
    {
        if (zzUu == null)
        {
            throw new IllegalArgumentException("media cannot be null.");
        }
        if (Double.isNaN(zzUx) || zzUx < 0.0D)
        {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        if (Double.isNaN(zzUy))
        {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }
        if (Double.isNaN(zzUz) || zzUz < 0.0D)
        {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        } else
        {
            return;
        }
    }

    public double zzmb()
    {
        return zzUy;
    }
}
