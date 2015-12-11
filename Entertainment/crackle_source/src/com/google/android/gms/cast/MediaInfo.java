// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.dh;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.fe;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaMetadata

public final class MediaInfo
{
    public static class Builder
    {

        private final MediaInfo kN;

        public MediaInfo build()
            throws IllegalArgumentException
        {
            kN.aO();
            return kN;
        }

        public Builder setContentType(String s)
            throws IllegalArgumentException
        {
            kN.setContentType(s);
            return this;
        }

        public Builder setCustomData(JSONObject jsonobject)
        {
            kN.a(jsonobject);
            return this;
        }

        public Builder setMetadata(MediaMetadata mediametadata)
        {
            kN.a(mediametadata);
            return this;
        }

        public Builder setStreamDuration(long l)
            throws IllegalArgumentException
        {
            kN.f(l);
            return this;
        }

        public Builder setStreamType(int i)
            throws IllegalArgumentException
        {
            kN.setStreamType(i);
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
                kN = new MediaInfo(s);
                return;
            }
        }
    }


    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    private final String kH;
    private int kI;
    private String kJ;
    private MediaMetadata kK;
    private long kL;
    private JSONObject kM;

    MediaInfo(String s)
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else
        {
            kH = s;
            kI = -1;
            return;
        }
    }

    MediaInfo(JSONObject jsonobject)
        throws JSONException
    {
        kH = jsonobject.getString("contentId");
        Object obj = jsonobject.getString("streamType");
        if ("NONE".equals(obj))
        {
            kI = 0;
        } else
        if ("BUFFERED".equals(obj))
        {
            kI = 1;
        } else
        if ("LIVE".equals(obj))
        {
            kI = 2;
        } else
        {
            kI = -1;
        }
        kJ = jsonobject.getString("contentType");
        if (jsonobject.has("metadata"))
        {
            obj = jsonobject.getJSONObject("metadata");
            kK = new MediaMetadata(((JSONObject) (obj)).getInt("metadataType"));
            kK.b(((JSONObject) (obj)));
        }
        kL = dh.b(jsonobject.optDouble("duration", 0.0D));
        kM = jsonobject.optJSONObject("customData");
    }

    void a(MediaMetadata mediametadata)
    {
        kK = mediametadata;
    }

    void a(JSONObject jsonobject)
    {
        kM = jsonobject;
    }

    void aO()
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(kH))
        {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        if (TextUtils.isEmpty(kJ))
        {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        if (kI == -1)
        {
            throw new IllegalArgumentException("a valid stream type must be specified");
        } else
        {
            return;
        }
    }

    public JSONObject aP()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("contentId", kH);
        kI;
        JVM INSTR tableswitch 1 2: default 134
    //                   1 142
    //                   2 125;
           goto _L1 _L2 _L3
_L2:
        break MISSING_BLOCK_LABEL_142;
_L6:
        Object obj;
        jsonobject.put("streamType", obj);
        if (kJ != null)
        {
            jsonobject.put("contentType", kJ);
        }
        if (kK != null)
        {
            jsonobject.put("metadata", kK.aP());
        }
        jsonobject.put("duration", dh.h(kL));
        if (kM == null) goto _L5; else goto _L4
_L4:
        jsonobject.put("customData", kM);
        return jsonobject;
_L3:
        obj = "LIVE";
          goto _L6
        obj;
        return jsonobject;
_L1:
        obj = "NONE";
          goto _L6
_L5:
        return jsonobject;
        obj = "BUFFERED";
          goto _L6
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
        if (kM == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((MediaInfo) (obj)).kM == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag5;
        if (flag != flag1) goto _L4; else goto _L5
_L5:
        if (kM == null || ((MediaInfo) (obj)).kM == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag5;
        if (!fe.d(kM, ((MediaInfo) (obj)).kM)) goto _L4; else goto _L6
_L6:
        boolean flag3;
        if (dh.a(kH, ((MediaInfo) (obj)).kH) && kI == ((MediaInfo) (obj)).kI && dh.a(kJ, ((MediaInfo) (obj)).kJ) && dh.a(kK, ((MediaInfo) (obj)).kK) && kL == ((MediaInfo) (obj)).kL)
        {
            flag3 = flag4;
        } else
        {
            flag3 = false;
        }
        return flag3;
    }

    void f(long l)
        throws IllegalArgumentException
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException("Stream duration cannot be negative");
        } else
        {
            kL = l;
            return;
        }
    }

    public String getContentId()
    {
        return kH;
    }

    public String getContentType()
    {
        return kJ;
    }

    public JSONObject getCustomData()
    {
        return kM;
    }

    public MediaMetadata getMetadata()
    {
        return kK;
    }

    public long getStreamDuration()
    {
        return kL;
    }

    public int getStreamType()
    {
        return kI;
    }

    public int hashCode()
    {
        return ee.hashCode(new Object[] {
            kH, Integer.valueOf(kI), kJ, kK, Long.valueOf(kL), String.valueOf(kM)
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
            kJ = s;
            return;
        }
    }

    void setStreamType(int i)
        throws IllegalArgumentException
    {
        if (i < -1 || i > 2)
        {
            throw new IllegalArgumentException("invalid stream type");
        } else
        {
            kI = i;
            return;
        }
    }
}
