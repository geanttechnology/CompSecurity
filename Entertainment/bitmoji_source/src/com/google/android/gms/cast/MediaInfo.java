// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.fp;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaMetadata

public final class MediaInfo
{
    public static class Builder
    {

        private final MediaInfo wQ;

        public MediaInfo build()
            throws IllegalArgumentException
        {
            wQ.cS();
            return wQ;
        }

        public Builder setContentType(String s)
            throws IllegalArgumentException
        {
            wQ.setContentType(s);
            return this;
        }

        public Builder setCustomData(JSONObject jsonobject)
        {
            wQ.a(jsonobject);
            return this;
        }

        public Builder setMetadata(MediaMetadata mediametadata)
        {
            wQ.a(mediametadata);
            return this;
        }

        public Builder setStreamDuration(long l)
            throws IllegalArgumentException
        {
            wQ.j(l);
            return this;
        }

        public Builder setStreamType(int i)
            throws IllegalArgumentException
        {
            wQ.setStreamType(i);
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
                wQ = new MediaInfo(s);
                return;
            }
        }
    }


    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    private final String wK;
    private int wL;
    private String wM;
    private MediaMetadata wN;
    private long wO;
    private JSONObject wP;

    MediaInfo(String s)
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else
        {
            wK = s;
            wL = -1;
            return;
        }
    }

    MediaInfo(JSONObject jsonobject)
        throws JSONException
    {
        wK = jsonobject.getString("contentId");
        Object obj = jsonobject.getString("streamType");
        if ("NONE".equals(obj))
        {
            wL = 0;
        } else
        if ("BUFFERED".equals(obj))
        {
            wL = 1;
        } else
        if ("LIVE".equals(obj))
        {
            wL = 2;
        } else
        {
            wL = -1;
        }
        wM = jsonobject.getString("contentType");
        if (jsonobject.has("metadata"))
        {
            obj = jsonobject.getJSONObject("metadata");
            wN = new MediaMetadata(((JSONObject) (obj)).getInt("metadataType"));
            wN.b(((JSONObject) (obj)));
        }
        wO = dr.b(jsonobject.optDouble("duration", 0.0D));
        wP = jsonobject.optJSONObject("customData");
    }

    void a(MediaMetadata mediametadata)
    {
        wN = mediametadata;
    }

    void a(JSONObject jsonobject)
    {
        wP = jsonobject;
    }

    void cS()
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(wK))
        {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        if (TextUtils.isEmpty(wM))
        {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        if (wL == -1)
        {
            throw new IllegalArgumentException("a valid stream type must be specified");
        } else
        {
            return;
        }
    }

    public JSONObject cT()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("contentId", wK);
        wL;
        JVM INSTR tableswitch 1 2: default 134
    //                   1 142
    //                   2 125;
           goto _L1 _L2 _L3
_L2:
        break MISSING_BLOCK_LABEL_142;
_L6:
        Object obj;
        jsonobject.put("streamType", obj);
        if (wM != null)
        {
            jsonobject.put("contentType", wM);
        }
        if (wN != null)
        {
            jsonobject.put("metadata", wN.cT());
        }
        jsonobject.put("duration", dr.l(wO));
        if (wP == null) goto _L5; else goto _L4
_L4:
        jsonobject.put("customData", wP);
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
        if (wP == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((MediaInfo) (obj)).wP == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag5;
        if (flag != flag1) goto _L4; else goto _L5
_L5:
        if (wP == null || ((MediaInfo) (obj)).wP == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag5;
        if (!fp.d(wP, ((MediaInfo) (obj)).wP)) goto _L4; else goto _L6
_L6:
        boolean flag3;
        if (dr.a(wK, ((MediaInfo) (obj)).wK) && wL == ((MediaInfo) (obj)).wL && dr.a(wM, ((MediaInfo) (obj)).wM) && dr.a(wN, ((MediaInfo) (obj)).wN) && wO == ((MediaInfo) (obj)).wO)
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
        return wK;
    }

    public String getContentType()
    {
        return wM;
    }

    public JSONObject getCustomData()
    {
        return wP;
    }

    public MediaMetadata getMetadata()
    {
        return wN;
    }

    public long getStreamDuration()
    {
        return wO;
    }

    public int getStreamType()
    {
        return wL;
    }

    public int hashCode()
    {
        return ep.hashCode(new Object[] {
            wK, Integer.valueOf(wL), wM, wN, Long.valueOf(wO), String.valueOf(wP)
        });
    }

    void j(long l)
        throws IllegalArgumentException
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException("Stream duration cannot be negative");
        } else
        {
            wO = l;
            return;
        }
    }

    void setContentType(String s)
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else
        {
            wM = s;
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
            wL = i;
            return;
        }
    }
}
