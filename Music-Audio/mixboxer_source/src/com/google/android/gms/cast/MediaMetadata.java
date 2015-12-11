// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.Bundle;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.dp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata
{
    private static class a
    {

        private final Map kS = new HashMap();
        private final Map kT = new HashMap();
        private final Map kU = new HashMap();

        public int A(String s)
        {
            s = (Integer)kU.get(s);
            if (s != null)
            {
                return s.intValue();
            } else
            {
                return 0;
            }
        }

        public a a(String s, String s1, int i)
        {
            kS.put(s, s1);
            kT.put(s1, s);
            kU.put(s, Integer.valueOf(i));
            return this;
        }

        public String y(String s)
        {
            return (String)kS.get(s);
        }

        public String z(String s)
        {
            return (String)kT.get(s);
        }

        public a()
        {
        }
    }


    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private static final String kO[] = {
        null, "String", "int", "double", "ISO-8601 date String"
    };
    private static final a kP = (new a()).a("com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime", 4).a("com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate", 4).a("com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate", 4).a("com.google.android.gms.cast.metadata.TITLE", "title", 1).a("com.google.android.gms.cast.metadata.SUBTITLE", "subtitle", 1).a("com.google.android.gms.cast.metadata.ARTIST", "artist", 1).a("com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist", 1).a("com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName", 1).a("com.google.android.gms.cast.metadata.COMPOSER", "composer", 1).a("com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber", 2).a("com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber", 2).a("com.google.android.gms.cast.metadata.SEASON_NUMBER", "season", 2).a("com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode", 2).a("com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle", 1).a("com.google.android.gms.cast.metadata.STUDIO", "studio", 1).a("com.google.android.gms.cast.metadata.WIDTH", "width", 2).a("com.google.android.gms.cast.metadata.HEIGHT", "height", 2).a("com.google.android.gms.cast.metadata.LOCATION_NAME", "location", 1).a("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude", 3).a("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude", 3);
    private final Bundle kQ;
    private int kR;
    private final List ki;

    public MediaMetadata()
    {
        this(0);
    }

    public MediaMetadata(int i)
    {
        ki = new ArrayList();
        kQ = new Bundle();
        kR = i;
    }

    private void a(String s, int i)
        throws IllegalArgumentException
    {
        int j = kP.A(s);
        if (j != i && j != 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Value for ").append(s).append(" must be a ").append(kO[i]).toString());
        } else
        {
            return;
        }
    }

    private transient void a(JSONObject jsonobject, String as[])
    {
        String s;
        Object obj;
        int i;
        int j;
        try
        {
            j = as.length;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            break; /* Loop/switch isn't completed */
        }
        i = 0;
_L14:
        if (i >= j) goto _L2; else goto _L1
_L1:
        s = as[i];
        if (!kQ.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_249;
        }
        kP.A(s);
        JVM INSTR tableswitch 1 4: default 258
    //                   1 72
    //                   2 95
    //                   3 118
    //                   4 72;
           goto _L3 _L4 _L5 _L6 _L4
_L3:
        break MISSING_BLOCK_LABEL_249;
_L4:
        jsonobject.put(kP.y(s), kQ.getString(s));
        break MISSING_BLOCK_LABEL_249;
_L5:
        jsonobject.put(kP.y(s), kQ.getInt(s));
        break MISSING_BLOCK_LABEL_249;
_L6:
        jsonobject.put(kP.y(s), kQ.getDouble(s));
        break MISSING_BLOCK_LABEL_249;
_L2:
        as = kQ.keySet().iterator();
_L9:
        do
        {
            if (!as.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            s = (String)as.next();
        } while (s.startsWith("com.google."));
        obj = kQ.get(s);
        if (!(obj instanceof String)) goto _L8; else goto _L7
_L7:
        jsonobject.put(s, obj);
          goto _L9
_L8:
        if (!(obj instanceof Integer)) goto _L11; else goto _L10
_L10:
        jsonobject.put(s, obj);
          goto _L9
_L11:
        if (!(obj instanceof Double)) goto _L9; else goto _L12
_L12:
        jsonobject.put(s, obj);
          goto _L9
        i++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L14; else goto _L13
_L13:
    }

    private boolean a(Bundle bundle, Bundle bundle1)
    {
label0:
        {
            if (bundle.size() != bundle1.size())
            {
                return false;
            }
            Iterator iterator = bundle.keySet().iterator();
            Object obj;
            Object obj1;
label1:
            do
            {
                String s;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    s = (String)iterator.next();
                    obj = bundle.get(s);
                    obj1 = bundle1.get(s);
                    if ((obj instanceof Bundle) && (obj1 instanceof Bundle) && !a((Bundle)obj, (Bundle)obj1))
                    {
                        return false;
                    }
                    if (obj != null)
                    {
                        continue label1;
                    }
                } while (obj1 == null && bundle1.containsKey(s));
                return false;
            } while (obj.equals(obj1));
            return false;
        }
        return true;
    }

    private transient void b(JSONObject jsonobject, String as[])
    {
        as = new HashSet(Arrays.asList(as));
        Iterator iterator = jsonobject.keys();
_L9:
        String s;
        Object obj;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (String)iterator.next();
        s = kP.z(((String) (obj)));
        if (s == null) goto _L2; else goto _L1
_L1:
        boolean flag = as.contains(s);
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = jsonobject.get(((String) (obj)));
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        kP.A(s);
        JVM INSTR tableswitch 1 4: default 326
    //                   1 120
    //                   2 181
    //                   3 209
    //                   4 145;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        continue; /* Loop/switch isn't completed */
_L4:
        if (obj instanceof String)
        {
            kQ.putString(s, (String)obj);
        }
        continue; /* Loop/switch isn't completed */
_L7:
        try
        {
            if ((obj instanceof String) && dp.G((String)obj) != null)
            {
                kQ.putString(s, (String)obj);
            }
        }
        catch (JSONException jsonexception) { }
        continue; /* Loop/switch isn't completed */
_L5:
        if (obj instanceof Integer)
        {
            kQ.putInt(s, ((Integer)obj).intValue());
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (obj instanceof Double)
        {
            kQ.putDouble(s, ((Double)obj).doubleValue());
        }
        continue; /* Loop/switch isn't completed */
_L2:
        obj = jsonobject.get(((String) (obj)));
        if (obj instanceof String)
        {
            kQ.putString(s, (String)obj);
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof Integer)
        {
            kQ.putInt(s, ((Integer)obj).intValue());
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            if (obj instanceof Double)
            {
                kQ.putDouble(s, ((Double)obj).doubleValue());
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject) { }
        break; /* Loop/switch isn't completed */
        if (true) goto _L9; else goto _L8
_L8:
    }

    public JSONObject aP()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("metadataType", kR);
        }
        catch (JSONException jsonexception) { }
        dp.a(jsonobject, ki);
        kR;
        JVM INSTR tableswitch 0 4: default 68
    //                   0 79
    //                   1 110
    //                   2 141
    //                   3 177
    //                   4 231;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        a(jsonobject, new String[0]);
        return jsonobject;
_L2:
        a(jsonobject, new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"
        });
        return jsonobject;
_L3:
        a(jsonobject, new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"
        });
        return jsonobject;
_L4:
        a(jsonobject, new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE"
        });
        return jsonobject;
_L5:
        a(jsonobject, new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE"
        });
        return jsonobject;
_L6:
        a(jsonobject, new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE"
        });
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void addImage(WebImage webimage)
    {
        ki.add(webimage);
    }

    public void b(JSONObject jsonobject)
    {
        clear();
        kR = 0;
        try
        {
            kR = jsonobject.getInt("metadataType");
        }
        catch (JSONException jsonexception) { }
        dp.a(ki, jsonobject);
        kR;
        JVM INSTR tableswitch 0 4: default 68
    //                   0 78
    //                   1 108
    //                   2 138
    //                   3 173
    //                   4 226;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        b(jsonobject, new String[0]);
        return;
_L2:
        b(jsonobject, new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"
        });
        return;
_L3:
        b(jsonobject, new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE"
        });
        return;
_L4:
        b(jsonobject, new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE"
        });
        return;
_L5:
        b(jsonobject, new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE"
        });
        return;
_L6:
        b(jsonobject, new String[] {
            "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE"
        });
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void clear()
    {
        kQ.clear();
        ki.clear();
    }

    public void clearImages()
    {
        ki.clear();
    }

    public boolean containsKey(String s)
    {
        return kQ.containsKey(s);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof MediaMetadata))
            {
                return false;
            }
            obj = (MediaMetadata)obj;
            if (!a(kQ, ((MediaMetadata) (obj)).kQ) || !ki.equals(((MediaMetadata) (obj)).ki))
            {
                return false;
            }
        }
        return true;
    }

    public Calendar getDate(String s)
    {
        a(s, 4);
        s = kQ.getString(s);
        if (s != null)
        {
            return dp.G(s);
        } else
        {
            return null;
        }
    }

    public String getDateAsString(String s)
    {
        a(s, 4);
        return kQ.getString(s);
    }

    public double getDouble(String s)
    {
        a(s, 3);
        return kQ.getDouble(s);
    }

    public List getImages()
    {
        return ki;
    }

    public int getInt(String s)
    {
        a(s, 2);
        return kQ.getInt(s);
    }

    public int getMediaType()
    {
        return kR;
    }

    public String getString(String s)
    {
        a(s, 1);
        return kQ.getString(s);
    }

    public boolean hasImages()
    {
        return ki != null && !ki.isEmpty();
    }

    public int hashCode()
    {
        Iterator iterator = kQ.keySet().iterator();
        String s;
        int i;
        for (i = 17; iterator.hasNext(); i = kQ.get(s).hashCode() + i * 31)
        {
            s = (String)iterator.next();
        }

        return i * 31 + ki.hashCode();
    }

    public Set keySet()
    {
        return kQ.keySet();
    }

    public void putDate(String s, Calendar calendar)
    {
        a(s, 4);
        kQ.putString(s, dp.a(calendar));
    }

    public void putDouble(String s, double d)
    {
        a(s, 3);
        kQ.putDouble(s, d);
    }

    public void putInt(String s, int i)
    {
        a(s, 2);
        kQ.putInt(s, i);
    }

    public void putString(String s, String s1)
    {
        a(s, 1);
        kQ.putString(s, s1);
    }

}
