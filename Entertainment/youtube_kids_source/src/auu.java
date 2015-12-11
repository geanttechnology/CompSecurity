// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class auu
{

    private final String a;
    private int b;
    private String c;
    private auv d;
    private long e;
    private List f;
    private JSONObject g;

    auu(JSONObject jsonobject)
    {
        Object obj;
        a = jsonobject.getString("contentId");
        obj = jsonobject.getString("streamType");
        int i;
        if ("NONE".equals(obj))
        {
            b = 0;
        } else
        if ("BUFFERED".equals(obj))
        {
            b = 1;
        } else
        if ("LIVE".equals(obj))
        {
            b = 2;
        } else
        {
            b = -1;
        }
        c = jsonobject.getString("contentType");
        if (!jsonobject.has("metadata")) goto _L2; else goto _L1
_L1:
        obj = jsonobject.getJSONObject("metadata");
        d = new auv(((JSONObject) (obj)).getInt("metadataType"));
        Object obj1 = d;
        ((auv) (obj1)).b.clear();
        ((auv) (obj1)).a.clear();
        obj1.c = 0;
        String s;
        try
        {
            obj1.c = ((JSONObject) (obj)).getInt("metadataType");
        }
        catch (JSONException jsonexception) { }
        bab.a(((auv) (obj1)).a, ((JSONObject) (obj)));
        ((auv) (obj1)).c;
        JVM INSTR tableswitch 0 4: default 160
    //                   0 300
    //                   1 332
    //                   2 364
    //                   3 401
    //                   4 456;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_456;
_L3:
        ((auv) (obj1)).a(((JSONObject) (obj)), new String[0]);
_L2:
        e = (long)(jsonobject.optDouble("duration", 0.0D) * 1000D);
        if (jsonobject.has("tracks"))
        {
            f = new ArrayList();
            obj = jsonobject.getJSONArray("tracks");
            for (i = 0; i < ((JSONArray) (obj)).length(); i++)
            {
                obj1 = new auy(((JSONArray) (obj)).getJSONObject(i));
                f.add(obj1);
            }

        } else
        {
            f = null;
        }
        break MISSING_BLOCK_LABEL_516;
_L4:
        ((auv) (obj1)).a(((JSONObject) (obj)), new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"
        });
          goto _L2
_L5:
        ((auv) (obj1)).a(((JSONObject) (obj)), new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"
        });
          goto _L2
_L6:
        ((auv) (obj1)).a(((JSONObject) (obj)), new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE"
        });
          goto _L2
_L7:
        ((auv) (obj1)).a(((JSONObject) (obj)), new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE"
        });
          goto _L2
        ((auv) (obj1)).a(((JSONObject) (obj)), new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE"
        });
          goto _L2
        if (jsonobject.has("textTrackStyle"))
        {
            obj = jsonobject.getJSONObject("textTrackStyle");
            obj1 = new avm();
            ((avm) (obj1)).a();
            obj1.a = (float)((JSONObject) (obj)).optDouble("fontScale", 1.0D);
            obj1.b = avm.a(((JSONObject) (obj)).optString("foregroundColor"));
            obj1.c = avm.a(((JSONObject) (obj)).optString("backgroundColor"));
            if (((JSONObject) (obj)).has("edgeType"))
            {
                s = ((JSONObject) (obj)).getString("edgeType");
                if ("NONE".equals(s))
                {
                    obj1.d = 0;
                } else
                if ("OUTLINE".equals(s))
                {
                    obj1.d = 1;
                } else
                if ("DROP_SHADOW".equals(s))
                {
                    obj1.d = 2;
                } else
                if ("RAISED".equals(s))
                {
                    obj1.d = 3;
                } else
                if ("DEPRESSED".equals(s))
                {
                    obj1.d = 4;
                }
            }
            obj1.e = avm.a(((JSONObject) (obj)).optString("edgeColor"));
            if (((JSONObject) (obj)).has("windowType"))
            {
                s = ((JSONObject) (obj)).getString("windowType");
                if ("NONE".equals(s))
                {
                    obj1.f = 0;
                } else
                if ("NORMAL".equals(s))
                {
                    obj1.f = 1;
                } else
                if ("ROUNDED_CORNERS".equals(s))
                {
                    obj1.f = 2;
                }
            }
            obj1.g = avm.a(((JSONObject) (obj)).optString("windowColor"));
            if (((avm) (obj1)).f == 2)
            {
                obj1.h = ((JSONObject) (obj)).optInt("windowRoundedCornerRadius", 0);
            }
            obj1.i = ((JSONObject) (obj)).optString("fontFamily", null);
            if (((JSONObject) (obj)).has("fontGenericFamily"))
            {
                s = ((JSONObject) (obj)).getString("fontGenericFamily");
                if ("SANS_SERIF".equals(s))
                {
                    obj1.j = 0;
                } else
                if ("MONOSPACED_SANS_SERIF".equals(s))
                {
                    obj1.j = 1;
                } else
                if ("SERIF".equals(s))
                {
                    obj1.j = 2;
                } else
                if ("MONOSPACED_SERIF".equals(s))
                {
                    obj1.j = 3;
                } else
                if ("CASUAL".equals(s))
                {
                    obj1.j = 4;
                } else
                if ("CURSIVE".equals(s))
                {
                    obj1.j = 5;
                } else
                if ("SMALL_CAPITALS".equals(s))
                {
                    obj1.j = 6;
                }
            }
            if (((JSONObject) (obj)).has("fontStyle"))
            {
                s = ((JSONObject) (obj)).getString("fontStyle");
                if ("NORMAL".equals(s))
                {
                    obj1.k = 0;
                } else
                if ("BOLD".equals(s))
                {
                    obj1.k = 1;
                } else
                if ("ITALIC".equals(s))
                {
                    obj1.k = 2;
                } else
                if ("BOLD_ITALIC".equals(s))
                {
                    obj1.k = 3;
                }
            }
            obj1.l = ((JSONObject) (obj)).optJSONObject("customData");
        }
        g = jsonobject.optJSONObject("customData");
        return;
    }

    public final boolean equals(Object obj)
    {
        boolean flag3 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag2 = true;
_L4:
        return flag2;
_L2:
        flag2 = flag3;
        if (!(obj instanceof auu))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (auu)obj;
        boolean flag;
        boolean flag1;
        if (g == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((auu) (obj)).g == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = flag3;
        if (flag != flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (g == null || ((auu) (obj)).g == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag3;
        if (!ayf.a(g, ((auu) (obj)).g)) goto _L4; else goto _L3
_L3:
        flag2 = flag3;
        if (a.g(a, ((auu) (obj)).a))
        {
            flag2 = flag3;
            if (b == ((auu) (obj)).b)
            {
                flag2 = flag3;
                if (a.g(c, ((auu) (obj)).c))
                {
                    flag2 = flag3;
                    if (a.g(d, ((auu) (obj)).d))
                    {
                        flag2 = flag3;
                        if (e == ((auu) (obj)).e)
                        {
                            return true;
                        }
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            a, Integer.valueOf(b), c, d, Long.valueOf(e), String.valueOf(g)
        });
    }
}
