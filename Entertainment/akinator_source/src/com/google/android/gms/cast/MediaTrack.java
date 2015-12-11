// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack
{
    public static class Builder
    {

        private final MediaTrack zzWL;

        public MediaTrack build()
        {
            return zzWL;
        }

        public Builder setContentId(String s)
        {
            zzWL.setContentId(s);
            return this;
        }

        public Builder setContentType(String s)
        {
            zzWL.setContentType(s);
            return this;
        }

        public Builder setCustomData(JSONObject jsonobject)
        {
            zzWL.setCustomData(jsonobject);
            return this;
        }

        public Builder setLanguage(String s)
        {
            zzWL.setLanguage(s);
            return this;
        }

        public Builder setLanguage(Locale locale)
        {
            zzWL.setLanguage(com.google.android.gms.cast.internal.zzf.zzb(locale));
            return this;
        }

        public Builder setName(String s)
        {
            zzWL.setName(s);
            return this;
        }

        public Builder setSubtype(int i)
            throws IllegalArgumentException
        {
            zzWL.zzaV(i);
            return this;
        }

        public Builder(long l, int i)
            throws IllegalArgumentException
        {
            zzWL = new MediaTrack(l, i);
        }
    }


    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private String mName;
    private long zzRr;
    private String zzVT;
    private String zzVV;
    private String zzVX;
    private int zzWJ;
    private int zzWK;
    private JSONObject zzWc;

    MediaTrack(long l, int i)
        throws IllegalArgumentException
    {
        clear();
        zzRr = l;
        if (i <= 0 || i > 3)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid type ").append(i).toString());
        } else
        {
            zzWJ = i;
            return;
        }
    }

    MediaTrack(JSONObject jsonobject)
        throws JSONException
    {
        zzf(jsonobject);
    }

    private void clear()
    {
        zzRr = 0L;
        zzWJ = 0;
        zzVV = null;
        mName = null;
        zzVT = null;
        zzWK = -1;
        zzWc = null;
    }

    private void zzf(JSONObject jsonobject)
        throws JSONException
    {
        clear();
        zzRr = jsonobject.getLong("trackId");
        String s = jsonobject.getString("type");
        if ("TEXT".equals(s))
        {
            zzWJ = 1;
        } else
        if ("AUDIO".equals(s))
        {
            zzWJ = 2;
        } else
        if ("VIDEO".equals(s))
        {
            zzWJ = 3;
        } else
        {
            throw new JSONException((new StringBuilder()).append("invalid type: ").append(s).toString());
        }
        zzVV = jsonobject.optString("trackContentId", null);
        zzVX = jsonobject.optString("trackContentType", null);
        mName = jsonobject.optString("name", null);
        zzVT = jsonobject.optString("language", null);
        if (jsonobject.has("subtype"))
        {
            s = jsonobject.getString("subtype");
            if ("SUBTITLES".equals(s))
            {
                zzWK = 1;
            } else
            if ("CAPTIONS".equals(s))
            {
                zzWK = 2;
            } else
            if ("DESCRIPTIONS".equals(s))
            {
                zzWK = 3;
            } else
            if ("CHAPTERS".equals(s))
            {
                zzWK = 4;
            } else
            if ("METADATA".equals(s))
            {
                zzWK = 5;
            } else
            {
                throw new JSONException((new StringBuilder()).append("invalid subtype: ").append(s).toString());
            }
        } else
        {
            zzWK = 0;
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
        if (!(obj instanceof MediaTrack)) goto _L4; else goto _L3
_L3:
        obj = (MediaTrack)obj;
        boolean flag;
        boolean flag1;
        if (zzWc == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((MediaTrack) (obj)).zzWc == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag5;
        if (flag != flag1) goto _L4; else goto _L5
_L5:
        if (zzWc == null || ((MediaTrack) (obj)).zzWc == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag5;
        if (!zzmu.zzd(zzWc, ((MediaTrack) (obj)).zzWc)) goto _L4; else goto _L6
_L6:
        boolean flag3;
        if (zzRr == ((MediaTrack) (obj)).zzRr && zzWJ == ((MediaTrack) (obj)).zzWJ && com.google.android.gms.cast.internal.zzf.zza(zzVV, ((MediaTrack) (obj)).zzVV) && com.google.android.gms.cast.internal.zzf.zza(zzVX, ((MediaTrack) (obj)).zzVX) && com.google.android.gms.cast.internal.zzf.zza(mName, ((MediaTrack) (obj)).mName) && com.google.android.gms.cast.internal.zzf.zza(zzVT, ((MediaTrack) (obj)).zzVT) && zzWK == ((MediaTrack) (obj)).zzWK)
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

    public long getId()
    {
        return zzRr;
    }

    public String getLanguage()
    {
        return zzVT;
    }

    public String getName()
    {
        return mName;
    }

    public int getSubtype()
    {
        return zzWK;
    }

    public int getType()
    {
        return zzWJ;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Long.valueOf(zzRr), Integer.valueOf(zzWJ), zzVV, zzVX, mName, zzVT, Integer.valueOf(zzWK), zzWc
        });
    }

    public void setContentId(String s)
    {
        zzVV = s;
    }

    public void setContentType(String s)
    {
        zzVX = s;
    }

    void setCustomData(JSONObject jsonobject)
    {
        zzWc = jsonobject;
    }

    void setLanguage(String s)
    {
        zzVT = s;
    }

    void setName(String s)
    {
        mName = s;
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("trackId", zzRr);
        zzWJ;
        JVM INSTR tableswitch 1 3: default 276
    //                   1 180
    //                   2 192
    //                   3 204;
           goto _L1 _L2 _L3 _L4
_L1:
        if (zzVV != null)
        {
            jsonobject.put("trackContentId", zzVV);
        }
        if (zzVX != null)
        {
            jsonobject.put("trackContentType", zzVX);
        }
        if (mName != null)
        {
            jsonobject.put("name", mName);
        }
        if (!TextUtils.isEmpty(zzVT))
        {
            jsonobject.put("language", zzVT);
        }
        zzWK;
        JVM INSTR tableswitch 1 5: default 279
    //                   1 216
    //                   2 228
    //                   3 240
    //                   4 252
    //                   5 264;
           goto _L5 _L6 _L7 _L8 _L9 _L10
_L5:
        if (zzWc == null) goto _L12; else goto _L11
_L11:
        jsonobject.put("customData", zzWc);
        return jsonobject;
_L2:
        try
        {
            jsonobject.put("type", "TEXT");
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        jsonobject.put("type", "AUDIO");
        continue; /* Loop/switch isn't completed */
_L4:
        jsonobject.put("type", "VIDEO");
        continue; /* Loop/switch isn't completed */
_L6:
        jsonobject.put("subtype", "SUBTITLES");
          goto _L5
_L7:
        jsonobject.put("subtype", "CAPTIONS");
          goto _L5
_L8:
        jsonobject.put("subtype", "DESCRIPTIONS");
          goto _L5
_L9:
        jsonobject.put("subtype", "CHAPTERS");
          goto _L5
_L10:
        jsonobject.put("subtype", "METADATA");
          goto _L5
_L12:
        return jsonobject;
        if (true) goto _L1; else goto _L13
_L13:
    }

    void zzaV(int i)
        throws IllegalArgumentException
    {
        if (i <= -1 || i > 5)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid subtype ").append(i).toString());
        }
        if (i != 0 && zzWJ != 1)
        {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        } else
        {
            zzWK = i;
            return;
        }
    }
}
