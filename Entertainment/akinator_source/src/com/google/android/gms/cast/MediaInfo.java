// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaMetadata, MediaTrack, TextTrackStyle

public final class MediaInfo
{
    public static class Builder
    {

        private final MediaInfo zzWd;

        public MediaInfo build()
            throws IllegalArgumentException
        {
            zzWd.zzmx();
            return zzWd;
        }

        public Builder setContentType(String s)
            throws IllegalArgumentException
        {
            zzWd.setContentType(s);
            return this;
        }

        public Builder setCustomData(JSONObject jsonobject)
        {
            zzWd.setCustomData(jsonobject);
            return this;
        }

        public Builder setMediaTracks(List list)
        {
            zzWd.zzq(list);
            return this;
        }

        public Builder setMetadata(MediaMetadata mediametadata)
        {
            zzWd.zza(mediametadata);
            return this;
        }

        public Builder setStreamDuration(long l)
            throws IllegalArgumentException
        {
            zzWd.zzx(l);
            return this;
        }

        public Builder setStreamType(int i)
            throws IllegalArgumentException
        {
            zzWd.setStreamType(i);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle texttrackstyle)
        {
            zzWd.setTextTrackStyle(texttrackstyle);
            return this;
        }

        public Builder(String s)
            throws IllegalArgumentException
        {
            if (TextUtils.isEmpty(s))
            {
                throw new IllegalArgumentException("Content ID cannot be empty");
            } else
            {
                zzWd = new MediaInfo(s);
                return;
            }
        }
    }


    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1L;
    private final String zzVV;
    private int zzVW;
    private String zzVX;
    private MediaMetadata zzVY;
    private long zzVZ;
    private List zzWa;
    private TextTrackStyle zzWb;
    private JSONObject zzWc;

    MediaInfo(String s)
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else
        {
            zzVV = s;
            zzVW = -1;
            zzVZ = -1L;
            return;
        }
    }

    MediaInfo(JSONObject jsonobject)
        throws JSONException
    {
        int i = 0;
        super();
        zzVV = jsonobject.getString("contentId");
        Object obj = jsonobject.getString("streamType");
        if ("NONE".equals(obj))
        {
            zzVW = 0;
        } else
        if ("BUFFERED".equals(obj))
        {
            zzVW = 1;
        } else
        if ("LIVE".equals(obj))
        {
            zzVW = 2;
        } else
        {
            zzVW = -1;
        }
        zzVX = jsonobject.getString("contentType");
        if (jsonobject.has("metadata"))
        {
            obj = jsonobject.getJSONObject("metadata");
            zzVY = new MediaMetadata(((JSONObject) (obj)).getInt("metadataType"));
            zzVY.zzf(((JSONObject) (obj)));
        }
        zzVZ = -1L;
        if (jsonobject.has("duration") && !jsonobject.isNull("duration"))
        {
            double d = jsonobject.optDouble("duration", 0.0D);
            if (!Double.isNaN(d) && !Double.isInfinite(d))
            {
                zzVZ = zzf.zzg(d);
            }
        }
        if (jsonobject.has("tracks"))
        {
            zzWa = new ArrayList();
            for (obj = jsonobject.getJSONArray("tracks"); i < ((JSONArray) (obj)).length(); i++)
            {
                MediaTrack mediatrack = new MediaTrack(((JSONArray) (obj)).getJSONObject(i));
                zzWa.add(mediatrack);
            }

        } else
        {
            zzWa = null;
        }
        if (jsonobject.has("textTrackStyle"))
        {
            JSONObject jsonobject1 = jsonobject.getJSONObject("textTrackStyle");
            TextTrackStyle texttrackstyle = new TextTrackStyle();
            texttrackstyle.zzf(jsonobject1);
            zzWb = texttrackstyle;
        } else
        {
            zzWb = null;
        }
        zzWc = jsonobject.optJSONObject("customData");
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
        if (!(obj instanceof MediaInfo)) goto _L4; else goto _L3
_L3:
        obj = (MediaInfo)obj;
        boolean flag;
        boolean flag1;
        if (zzWc == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((MediaInfo) (obj)).zzWc == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag5;
        if (flag != flag1) goto _L4; else goto _L5
_L5:
        if (zzWc == null || ((MediaInfo) (obj)).zzWc == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag5;
        if (!zzmu.zzd(zzWc, ((MediaInfo) (obj)).zzWc)) goto _L4; else goto _L6
_L6:
        boolean flag3;
        if (zzf.zza(zzVV, ((MediaInfo) (obj)).zzVV) && zzVW == ((MediaInfo) (obj)).zzVW && zzf.zza(zzVX, ((MediaInfo) (obj)).zzVX) && zzf.zza(zzVY, ((MediaInfo) (obj)).zzVY) && zzVZ == ((MediaInfo) (obj)).zzVZ)
        {
            flag3 = flag4;
        } else
        {
            flag3 = false;
        }
        return flag3;
    }

    public String getContentId()
    {
        return zzVV;
    }

    public String getContentType()
    {
        return zzVX;
    }

    public JSONObject getCustomData()
    {
        return zzWc;
    }

    public List getMediaTracks()
    {
        return zzWa;
    }

    public MediaMetadata getMetadata()
    {
        return zzVY;
    }

    public long getStreamDuration()
    {
        return zzVZ;
    }

    public int getStreamType()
    {
        return zzVW;
    }

    public TextTrackStyle getTextTrackStyle()
    {
        return zzWb;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzVV, Integer.valueOf(zzVW), zzVX, zzVY, Long.valueOf(zzVZ), String.valueOf(zzWc)
        });
    }

    void setContentType(String s)
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else
        {
            zzVX = s;
            return;
        }
    }

    void setCustomData(JSONObject jsonobject)
    {
        zzWc = jsonobject;
    }

    void setStreamType(int i)
        throws IllegalArgumentException
    {
        if (i < -1 || i > 2)
        {
            throw new IllegalArgumentException("invalid stream type");
        } else
        {
            zzVW = i;
            return;
        }
    }

    public void setTextTrackStyle(TextTrackStyle texttrackstyle)
    {
        zzWb = texttrackstyle;
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("contentId", zzVV);
        zzVW;
        JVM INSTR tableswitch 1 2: default 232
    //                   1 241
    //                   2 247;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_247;
_L12:
        Object obj;
        jsonobject.put("streamType", obj);
        if (zzVX != null)
        {
            jsonobject.put("contentType", zzVX);
        }
        if (zzVY != null)
        {
            jsonobject.put("metadata", zzVY.toJson());
        }
        if (zzVZ > -1L) goto _L5; else goto _L4
_L4:
        jsonobject.put("duration", JSONObject.NULL);
_L9:
        if (zzWa == null) goto _L7; else goto _L6
_L6:
        obj = new JSONArray();
        for (Iterator iterator = zzWa.iterator(); iterator.hasNext(); ((JSONArray) (obj)).put(((MediaTrack)iterator.next()).toJson())) { }
          goto _L8
_L5:
        jsonobject.put("duration", zzf.zzA(zzVZ));
          goto _L9
_L8:
        jsonobject.put("tracks", obj);
_L7:
        if (zzWb != null)
        {
            jsonobject.put("textTrackStyle", zzWb.toJson());
        }
        if (zzWc == null) goto _L11; else goto _L10
_L10:
        jsonobject.put("customData", zzWc);
        return jsonobject;
_L1:
        obj = "NONE";
          goto _L12
        obj;
_L11:
        return jsonobject;
_L2:
        obj = "BUFFERED";
          goto _L12
        obj = "LIVE";
          goto _L12
    }

    void zza(MediaMetadata mediametadata)
    {
        zzVY = mediametadata;
    }

    void zzmx()
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(zzVV))
        {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        if (TextUtils.isEmpty(zzVX))
        {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        if (zzVW == -1)
        {
            throw new IllegalArgumentException("a valid stream type must be specified");
        } else
        {
            return;
        }
    }

    void zzq(List list)
    {
        zzWa = list;
    }

    void zzx(long l)
        throws IllegalArgumentException
    {
        if (l < 0L && l != -1L)
        {
            throw new IllegalArgumentException("Invalid stream duration");
        } else
        {
            zzVZ = l;
            return;
        }
    }
}
