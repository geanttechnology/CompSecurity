// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.upload;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.c;
import com.socialin.android.d;
import com.socialin.gson.Gson;
import com.socialin.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.picsart.upload:
//            d

public class UploadItem
{

    public static final String b[] = {
        "picsart", "facebook", "twitter", "dropbox", "flickr", "deviantart", "tumblr"
    };
    public static final String c[] = {
        "picsart.resized", "facebook", "twitter", "picsart", "dropbox", "flickr", "deviantart", "tumblr"
    };
    private static String n = com/socialin/android/picsart/upload/UploadItem.getSimpleName();
    public int a;
    public String d;
    public int e[] = {
        0, 0, 0, 0, 0, 0, 0, 0
    };
    public int f[];
    public List g;
    public Adress h;
    public Type i;
    public long j;
    public int k;
    public int l;
    public int m;
    private final String o[] = {
        "facebook", "twitter", "dropbox", "flickr", "deviantart", "tumblr", "picsart.resized", "picsart"
    };
    private int p[];
    private long q;

    private UploadItem()
    {
        a = 0;
        p = new int[8];
        f = new int[9];
        g = new ArrayList(10);
        q = 0L;
    }

    public static int a(String s)
    {
        while ("picsart".equals(s) || "picsart.resized".equals(s) || !b(s)) 
        {
            return 0;
        }
        return 0;
    }

    public static UploadItem a(Cursor cursor)
    {
        byte abyte0[];
        int i1;
        long l1;
        abyte0 = cursor.getBlob(cursor.getColumnIndex("upload_item"));
        i1 = cursor.getInt(cursor.getColumnIndex("upload_status"));
        l1 = cursor.getLong(cursor.getColumnIndex("created_at"));
        Object obj;
        obj = new JSONObject(new String(abyte0));
        ((JSONObject) (obj)).put("status", i1);
        ((JSONObject) (obj)).put("created", l1);
        ((JSONObject) (obj)).put("id", cursor.getLong(cursor.getColumnIndex("_id")));
        obj = a(((JSONObject) (obj)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        obj.j = cursor.getLong(cursor.getColumnIndex("_id"));
        return ((UploadItem) (obj));
        cursor;
        obj = null;
_L2:
        com.socialin.android.d.b(n, "create", cursor);
        return ((UploadItem) (obj));
        cursor;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static UploadItem a(JSONObject jsonobject)
    {
        boolean flag = false;
        UploadItem uploaditem = new UploadItem();
        Object obj;
        int i1;
        try
        {
            uploaditem.j = jsonobject.optInt("id");
            uploaditem.q = jsonobject.optLong("created");
            uploaditem.k = jsonobject.optInt("status");
            obj = jsonobject.getJSONArray("booleans");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            com.socialin.android.d.b(n, "create by json", jsonobject);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            com.socialin.android.d.b(n, "create by json", jsonobject);
            return null;
        }
        i1 = 0;
        if (i1 >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        uploaditem.f[i1] = ((JSONArray) (obj)).getInt(i1);
        i1++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_51;
_L1:
        obj = jsonobject.getJSONArray("retried");
        i1 = 0;
_L4:
        if (i1 >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        uploaditem.e[i1] = ((JSONArray) (obj)).getInt(i1);
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        obj = jsonobject.getJSONArray("strings");
        i1 = 0;
_L6:
        if (i1 >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        uploaditem.g.add(((JSONArray) (obj)).getString(i1));
        i1++;
        if (true) goto _L6; else goto _L5
_L5:
        obj = jsonobject.getJSONArray("postedTo");
        i1 = ((flag) ? 1 : 0);
_L8:
        if (i1 >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        uploaditem.p[i1] = ((JSONArray) (obj)).getInt(i1);
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
        obj = jsonobject.optJSONObject("location");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        uploaditem.h = (Adress)com.socialin.android.c.a().fromJson(((JSONObject) (obj)).toString(), com/socialin/android/apiv3/model/Adress);
        uploaditem.d = jsonobject.optString("curNetworkName");
        uploaditem.l = jsonobject.optInt("width");
        uploaditem.m = jsonobject.optInt("height");
        uploaditem.i = j(jsonobject.optString("type").toUpperCase());
        return uploaditem;
    }

    private static UploadItem a(int ai[], List list, Adress adress, int i1, int j1, Type type)
    {
        UploadItem uploaditem;
        uploaditem = new UploadItem();
        uploaditem.f = (int[])ai.clone();
        uploaditem.g = (List)((ArrayList)list).clone();
        uploaditem.q = System.currentTimeMillis();
        uploaditem.l = i1;
        uploaditem.m = j1;
        uploaditem.i = type;
        if (adress == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        uploaditem.h = (Adress)com.socialin.android.c.a().fromJson(adress.toJson().toString(), com/socialin/android/apiv3/model/Adress);
        return uploaditem;
        ai;
_L2:
        com.socialin.android.d.b(n, "create", ai);
        return uploaditem;
        ai;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private String a(int i1)
    {
        if (i1 >= 0 && i1 < 8)
        {
            return o[i1];
        } else
        {
            return "";
        }
    }

    private static JSONObject a(com.socialin.android.picsart.upload.d d1, String s, String s1)
    {
        List list = d1.b();
        list.add(s);
        list.add(s1);
        list.add(null);
        d1 = a(d1.a(), list, ((Adress) (null)), d1.i, d1.j, Type.STICKER);
        try
        {
            d1 = d1.h();
        }
        // Misplaced declaration of an exception variable
        catch (com.socialin.android.picsart.upload.d d1)
        {
            com.socialin.android.d.b(n, "createStickerJson", d1);
            return null;
        }
        return d1;
    }

    public static JSONObject a(com.socialin.android.picsart.upload.d d1, String s, String s1, String s2)
    {
        List list = d1.b();
        list.add(s2);
        list.add(s);
        list.add(s1);
        d1 = a(d1.a(), list, d1.q, d1.i, d1.j, Type.PHOTO);
        try
        {
            d1 = d1.h();
        }
        // Misplaced declaration of an exception variable
        catch (com.socialin.android.picsart.upload.d d1)
        {
            com.socialin.android.d.b(n, "createJson", d1);
            return null;
        }
        return d1;
    }

    public static JSONObject a(String s, String s1, String s2, String s3, int i1, int j1)
    {
        com.socialin.android.picsart.upload.d d1 = new com.socialin.android.picsart.upload.d();
        d1.l = s;
        d1.m = s1;
        d1.i = i1;
        d1.j = j1;
        d1.n = "";
        d1.p = "";
        return a(d1, s2, s3);
    }

    public static boolean b(String s)
    {
        for (int i1 = 0; i1 < 6; i1++)
        {
            if (s.equals((new String[] {
    "facebook", "twitter", "dropbox", "flickr", "deviantart", "tumblr"
})[i1]))
            {
                return true;
            }
        }

        return false;
    }

    private static Type j(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_23;
        }
        s = Type.valueOf(s);
        return s;
        s;
        com.socialin.android.d.a(n, s);
        return Type.PHOTO;
    }

    public final ContentValues a()
    {
        ContentValues contentvalues = new ContentValues(4);
        long l1;
        if (q != 0L)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        l1 = System.currentTimeMillis();
_L1:
        contentvalues.put("created_at", Long.valueOf(l1));
        contentvalues.put("upload_item", h().toString());
        contentvalues.put("upload_status", Integer.valueOf(k));
        return contentvalues;
        try
        {
            l1 = q;
        }
        catch (JSONException jsonexception)
        {
            com.socialin.android.d.b("uploadItem", "toContentValues", jsonexception);
            return null;
        }
          goto _L1
    }

    public final String b()
    {
        return (String)g.get(0);
    }

    public final String c()
    {
        return (String)g.get(1);
    }

    public final void c(String s)
    {
        g.set(0, s);
    }

    public final String d()
    {
        return (String)g.get(4);
    }

    public final boolean d(String s)
    {
        int j1 = i(s);
        int i1;
        if ("picsart".equals(s))
        {
            i1 = 1;
        } else
        {
            i1 = i(s);
            if (i1 <= 6 && f[i1] > 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
        }
        return i1 != 0 && !e(s) && e[j1] <= a(s);
    }

    public final String e()
    {
        if (g.size() >= 9)
        {
            return (String)g.get(8);
        } else
        {
            return null;
        }
    }

    public final boolean e(String s)
    {
        int i1 = i(s);
        return i1 < 8 && p[i1] > 0;
    }

    public final String f()
    {
        if (g.size() >= 10)
        {
            return (String)g.get(9);
        } else
        {
            return null;
        }
    }

    public final void f(String s)
    {
        int i1 = i(s);
        if (i1 < 8)
        {
            p[i1] = 1;
        }
        if (k())
        {
            k = 3;
        } else
        if (j())
        {
            k = 2;
            return;
        }
    }

    public final void g(String s)
    {
        int i1 = i(s);
        s = e;
        s[i1] = s[i1] + 1;
        if (j())
        {
            k = 2;
            s = e;
            int j1 = i("facebook");
            a("facebook");
            s[j1] = 1;
        }
    }

    public final boolean g()
    {
        return Type.PHOTO.equals(i);
    }

    public final JSONObject h()
    {
        boolean flag = false;
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("status", k);
        jsonobject.put("created", q);
        jsonobject.put("curNetworkName", d);
        jsonobject.put("id", j);
        jsonobject.put("width", l);
        jsonobject.put("height", m);
        jsonobject.put("type", i.toString().toLowerCase());
        Object obj = new JSONArray();
        for (int i1 = 0; i1 < f.length; i1++)
        {
            ((JSONArray) (obj)).put(f[i1]);
        }

        jsonobject.put("booleans", obj);
        obj = new JSONArray();
        for (int j1 = 0; j1 < e.length; j1++)
        {
            ((JSONArray) (obj)).put(e[j1]);
        }

        jsonobject.put("retried", obj);
        obj = new JSONArray();
        for (int k1 = 0; k1 < p.length; k1++)
        {
            ((JSONArray) (obj)).put(p[k1]);
        }

        jsonobject.put("postedTo", obj);
        obj = new JSONArray();
        for (int l1 = ((flag) ? 1 : 0); l1 < g.size(); l1++)
        {
            ((JSONArray) (obj)).put(g.get(l1));
        }

        jsonobject.put("strings", obj);
        if (h != null)
        {
            obj = h.toJson();
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            jsonobject.put("location", obj);
        }
        return jsonobject;
    }

    public final boolean h(String s)
    {
        int i1 = i(s);
        return i1 >= e.length - 1 || f[i1] > 0;
    }

    public final int i(String s)
    {
        for (int i1 = 0; i1 < 8; i1++)
        {
            if (s.equals(o[i1]))
            {
                return i1;
            }
        }

        return 0x1869f;
    }

    public final boolean i()
    {
        return f[6] > 0;
    }

    public final boolean j()
    {
        int i1;
        if (i())
        {
            i1 = i("picsart.resized");
        } else
        {
            i1 = i("picsart");
        }
        return p[i1] == 0 && e[i1] > a("picsart");
    }

    public final boolean k()
    {
        for (int i1 = 0; i1 < 8; i1++)
        {
            if (h(a(i1)) && p[i1] == 0)
            {
                return false;
            }
        }

        return true;
    }

    public final boolean l()
    {
        for (int i1 = 0; i1 < 8; i1++)
        {
            String s = a(i1);
            if ((!h(s) || p[i1] != 1) && (!h(s) || p[i1] != 0 || e[i1] <= a(s)) && h(s))
            {
                return false;
            }
        }

        return true;
    }


    /* member class not found */
    class Type {}

}
