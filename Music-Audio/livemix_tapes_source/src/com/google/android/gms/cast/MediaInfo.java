// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzls;
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

        private final MediaInfo zzUm;

        public MediaInfo build()
            throws IllegalArgumentException
        {
            zzUm.zzma();
            return zzUm;
        }

        public Builder setContentType(String s)
            throws IllegalArgumentException
        {
            zzUm.setContentType(s);
            return this;
        }

        public Builder setCustomData(JSONObject jsonobject)
        {
            zzUm.setCustomData(jsonobject);
            return this;
        }

        public Builder setMediaTracks(List list)
        {
            zzUm.zzj(list);
            return this;
        }

        public Builder setMetadata(MediaMetadata mediametadata)
        {
            zzUm.zza(mediametadata);
            return this;
        }

        public Builder setStreamDuration(long l)
            throws IllegalArgumentException
        {
            zzUm.zzx(l);
            return this;
        }

        public Builder setStreamType(int i)
            throws IllegalArgumentException
        {
            zzUm.setStreamType(i);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle texttrackstyle)
        {
            zzUm.setTextTrackStyle(texttrackstyle);
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
                zzUm = new MediaInfo(s);
                return;
            }
        }
    }


    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1L;
    private final String zzUe;
    private int zzUf;
    private String zzUg;
    private MediaMetadata zzUh;
    private long zzUi;
    private List zzUj;
    private TextTrackStyle zzUk;
    private JSONObject zzUl;

    MediaInfo(String s)
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else
        {
            zzUe = s;
            zzUf = -1;
            zzUi = -1L;
            return;
        }
    }

    MediaInfo(JSONObject jsonobject)
        throws JSONException
    {
        int i = 0;
        super();
        zzUe = jsonobject.getString("contentId");
        Object obj = jsonobject.getString("streamType");
        if ("NONE".equals(obj))
        {
            zzUf = 0;
        } else
        if ("BUFFERED".equals(obj))
        {
            zzUf = 1;
        } else
        if ("LIVE".equals(obj))
        {
            zzUf = 2;
        } else
        {
            zzUf = -1;
        }
        zzUg = jsonobject.getString("contentType");
        if (jsonobject.has("metadata"))
        {
            obj = jsonobject.getJSONObject("metadata");
            zzUh = new MediaMetadata(((JSONObject) (obj)).getInt("metadataType"));
            zzUh.zzf(((JSONObject) (obj)));
        }
        zzUi = -1L;
        if (jsonobject.has("duration") && !jsonobject.isNull("duration"))
        {
            double d = jsonobject.optDouble("duration", 0.0D);
            if (!Double.isNaN(d) && !Double.isInfinite(d))
            {
                zzUi = zzf.zzf(d);
            }
        }
        if (jsonobject.has("tracks"))
        {
            zzUj = new ArrayList();
            for (obj = jsonobject.getJSONArray("tracks"); i < ((JSONArray) (obj)).length(); i++)
            {
                MediaTrack mediatrack = new MediaTrack(((JSONArray) (obj)).getJSONObject(i));
                zzUj.add(mediatrack);
            }

        } else
        {
            zzUj = null;
        }
        if (jsonobject.has("textTrackStyle"))
        {
            JSONObject jsonobject1 = jsonobject.getJSONObject("textTrackStyle");
            TextTrackStyle texttrackstyle = new TextTrackStyle();
            texttrackstyle.zzf(jsonobject1);
            zzUk = texttrackstyle;
        } else
        {
            zzUk = null;
        }
        zzUl = jsonobject.optJSONObject("customData");
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
        if (zzUl == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((MediaInfo) (obj)).zzUl == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag5;
        if (flag != flag1) goto _L4; else goto _L5
_L5:
        if (zzUl == null || ((MediaInfo) (obj)).zzUl == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag5;
        if (!zzls.zzd(zzUl, ((MediaInfo) (obj)).zzUl)) goto _L4; else goto _L6
_L6:
        boolean flag3;
        if (zzf.zza(zzUe, ((MediaInfo) (obj)).zzUe) && zzUf == ((MediaInfo) (obj)).zzUf && zzf.zza(zzUg, ((MediaInfo) (obj)).zzUg) && zzf.zza(zzUh, ((MediaInfo) (obj)).zzUh) && zzUi == ((MediaInfo) (obj)).zzUi)
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
        return zzUe;
    }

    public String getContentType()
    {
        return zzUg;
    }

    public JSONObject getCustomData()
    {
        return zzUl;
    }

    public List getMediaTracks()
    {
        return zzUj;
    }

    public MediaMetadata getMetadata()
    {
        return zzUh;
    }

    public long getStreamDuration()
    {
        return zzUi;
    }

    public int getStreamType()
    {
        return zzUf;
    }

    public TextTrackStyle getTextTrackStyle()
    {
        return zzUk;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzUe, Integer.valueOf(zzUf), zzUg, zzUh, Long.valueOf(zzUi), String.valueOf(zzUl)
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
            zzUg = s;
            return;
        }
    }

    void setCustomData(JSONObject jsonobject)
    {
        zzUl = jsonobject;
    }

    void setStreamType(int i)
        throws IllegalArgumentException
    {
        if (i < -1 || i > 2)
        {
            throw new IllegalArgumentException("invalid stream type");
        } else
        {
            zzUf = i;
            return;
        }
    }

    public void setTextTrackStyle(TextTrackStyle texttrackstyle)
    {
        zzUk = texttrackstyle;
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("contentId", zzUe);
        zzUf;
        JVM INSTR tableswitch 1 2: default 232
    //                   1 241
    //                   2 247;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_247;
_L12:
        Object obj;
        jsonobject.put("streamType", obj);
        if (zzUg != null)
        {
            jsonobject.put("contentType", zzUg);
        }
        if (zzUh != null)
        {
            jsonobject.put("metadata", zzUh.toJson());
        }
        if (zzUi > -1L) goto _L5; else goto _L4
_L4:
        jsonobject.put("duration", JSONObject.NULL);
_L9:
        if (zzUj == null) goto _L7; else goto _L6
_L6:
        obj = new JSONArray();
        for (Iterator iterator = zzUj.iterator(); iterator.hasNext(); ((JSONArray) (obj)).put(((MediaTrack)iterator.next()).toJson())) { }
          goto _L8
_L5:
        jsonobject.put("duration", zzf.zzA(zzUi));
          goto _L9
_L8:
        jsonobject.put("tracks", obj);
_L7:
        if (zzUk != null)
        {
            jsonobject.put("textTrackStyle", zzUk.toJson());
        }
        if (zzUl == null) goto _L11; else goto _L10
_L10:
        jsonobject.put("customData", zzUl);
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
        zzUh = mediametadata;
    }

    void zzj(List list)
    {
        zzUj = list;
    }

    void zzma()
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(zzUe))
        {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        if (TextUtils.isEmpty(zzUg))
        {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        if (zzUf == -1)
        {
            throw new IllegalArgumentException("a valid stream type must be specified");
        } else
        {
            return;
        }
    }

    void zzx(long l)
        throws IllegalArgumentException
    {
        if (l < 0L && l != -1L)
        {
            throw new IllegalArgumentException("Invalid stream duration");
        } else
        {
            zzUi = l;
            return;
        }
    }
}
