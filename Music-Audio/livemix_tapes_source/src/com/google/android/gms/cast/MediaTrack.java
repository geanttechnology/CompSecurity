// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzls;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack
{
    public static class Builder
    {

        private final MediaTrack zzUU;

        public MediaTrack build()
        {
            return zzUU;
        }

        public Builder setContentId(String s)
        {
            zzUU.setContentId(s);
            return this;
        }

        public Builder setContentType(String s)
        {
            zzUU.setContentType(s);
            return this;
        }

        public Builder setCustomData(JSONObject jsonobject)
        {
            zzUU.setCustomData(jsonobject);
            return this;
        }

        public Builder setLanguage(String s)
        {
            zzUU.setLanguage(s);
            return this;
        }

        public Builder setLanguage(Locale locale)
        {
            zzUU.setLanguage(com.google.android.gms.cast.internal.zzf.zzb(locale));
            return this;
        }

        public Builder setName(String s)
        {
            zzUU.setName(s);
            return this;
        }

        public Builder setSubtype(int i)
            throws IllegalArgumentException
        {
            zzUU.zzaO(i);
            return this;
        }

        public Builder(long l, int i)
            throws IllegalArgumentException
        {
            zzUU = new MediaTrack(l, i);
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
    private long zzQD;
    private int zzUS;
    private int zzUT;
    private String zzUc;
    private String zzUe;
    private String zzUg;
    private JSONObject zzUl;

    MediaTrack(long l, int i)
        throws IllegalArgumentException
    {
        clear();
        zzQD = l;
        if (i <= 0 || i > 3)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid type ").append(i).toString());
        } else
        {
            zzUS = i;
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
        zzQD = 0L;
        zzUS = 0;
        zzUe = null;
        mName = null;
        zzUc = null;
        zzUT = -1;
        zzUl = null;
    }

    private void zzf(JSONObject jsonobject)
        throws JSONException
    {
        clear();
        zzQD = jsonobject.getLong("trackId");
        String s = jsonobject.getString("type");
        if ("TEXT".equals(s))
        {
            zzUS = 1;
        } else
        if ("AUDIO".equals(s))
        {
            zzUS = 2;
        } else
        if ("VIDEO".equals(s))
        {
            zzUS = 3;
        } else
        {
            throw new JSONException((new StringBuilder()).append("invalid type: ").append(s).toString());
        }
        zzUe = jsonobject.optString("trackContentId", null);
        zzUg = jsonobject.optString("trackContentType", null);
        mName = jsonobject.optString("name", null);
        zzUc = jsonobject.optString("language", null);
        if (jsonobject.has("subtype"))
        {
            s = jsonobject.getString("subtype");
            if ("SUBTITLES".equals(s))
            {
                zzUT = 1;
            } else
            if ("CAPTIONS".equals(s))
            {
                zzUT = 2;
            } else
            if ("DESCRIPTIONS".equals(s))
            {
                zzUT = 3;
            } else
            if ("CHAPTERS".equals(s))
            {
                zzUT = 4;
            } else
            if ("METADATA".equals(s))
            {
                zzUT = 5;
            } else
            {
                throw new JSONException((new StringBuilder()).append("invalid subtype: ").append(s).toString());
            }
        } else
        {
            zzUT = 0;
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
        if (!(obj instanceof MediaTrack)) goto _L4; else goto _L3
_L3:
        obj = (MediaTrack)obj;
        boolean flag;
        boolean flag1;
        if (zzUl == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((MediaTrack) (obj)).zzUl == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag5;
        if (flag != flag1) goto _L4; else goto _L5
_L5:
        if (zzUl == null || ((MediaTrack) (obj)).zzUl == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag5;
        if (!zzls.zzd(zzUl, ((MediaTrack) (obj)).zzUl)) goto _L4; else goto _L6
_L6:
        boolean flag3;
        if (zzQD == ((MediaTrack) (obj)).zzQD && zzUS == ((MediaTrack) (obj)).zzUS && com.google.android.gms.cast.internal.zzf.zza(zzUe, ((MediaTrack) (obj)).zzUe) && com.google.android.gms.cast.internal.zzf.zza(zzUg, ((MediaTrack) (obj)).zzUg) && com.google.android.gms.cast.internal.zzf.zza(mName, ((MediaTrack) (obj)).mName) && com.google.android.gms.cast.internal.zzf.zza(zzUc, ((MediaTrack) (obj)).zzUc) && zzUT == ((MediaTrack) (obj)).zzUT)
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

    public long getId()
    {
        return zzQD;
    }

    public String getLanguage()
    {
        return zzUc;
    }

    public String getName()
    {
        return mName;
    }

    public int getSubtype()
    {
        return zzUT;
    }

    public int getType()
    {
        return zzUS;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Long.valueOf(zzQD), Integer.valueOf(zzUS), zzUe, zzUg, mName, zzUc, Integer.valueOf(zzUT), zzUl
        });
    }

    public void setContentId(String s)
    {
        zzUe = s;
    }

    public void setContentType(String s)
    {
        zzUg = s;
    }

    void setCustomData(JSONObject jsonobject)
    {
        zzUl = jsonobject;
    }

    void setLanguage(String s)
    {
        zzUc = s;
    }

    void setName(String s)
    {
        mName = s;
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("trackId", zzQD);
        zzUS;
        JVM INSTR tableswitch 1 3: default 276
    //                   1 180
    //                   2 192
    //                   3 204;
           goto _L1 _L2 _L3 _L4
_L1:
        if (zzUe != null)
        {
            jsonobject.put("trackContentId", zzUe);
        }
        if (zzUg != null)
        {
            jsonobject.put("trackContentType", zzUg);
        }
        if (mName != null)
        {
            jsonobject.put("name", mName);
        }
        if (!TextUtils.isEmpty(zzUc))
        {
            jsonobject.put("language", zzUc);
        }
        zzUT;
        JVM INSTR tableswitch 1 5: default 279
    //                   1 216
    //                   2 228
    //                   3 240
    //                   4 252
    //                   5 264;
           goto _L5 _L6 _L7 _L8 _L9 _L10
_L5:
        if (zzUl == null) goto _L12; else goto _L11
_L11:
        jsonobject.put("customData", zzUl);
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

    void zzaO(int i)
        throws IllegalArgumentException
    {
        if (i <= -1 || i > 5)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid subtype ").append(i).toString());
        }
        if (i != 0 && zzUS != 1)
        {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        } else
        {
            zzUT = i;
            return;
        }
    }
}
