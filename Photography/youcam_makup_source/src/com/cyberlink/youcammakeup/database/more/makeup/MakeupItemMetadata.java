// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.makeup;

import android.content.ContentValues;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.e;
import com.cyberlink.youcammakeup.utility.cc;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.makeup:
//            f

public class MakeupItemMetadata
    implements e
{

    private UnlockMethod A;
    private JSONObject a;
    private long b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private URI h;
    private URI i;
    private URI j;
    private String k;
    private Calendar l;
    private Calendar m;
    private Long n;
    private List o;
    private boolean p;
    private String q;
    private List r;
    private String s;
    private String t;
    private String u;
    private String v;
    private List w;
    private URI x;
    private boolean y;
    private boolean z;

    public MakeupItemMetadata(JSONObject jsonobject)
    {
        boolean flag = false;
        super();
        a = jsonobject;
        b = jsonobject.optLong("mkId");
        c = jsonobject.optString("type");
        d = jsonobject.optString("guid");
        e = jsonobject.optString("name");
        f = jsonobject.optString("vendor");
        g = jsonobject.optString("description");
        h = URI.create(jsonobject.optString("thumbnailURL"));
        Object obj;
        if (jsonobject.has("previewImgURL"))
        {
            obj = URI.create(jsonobject.getString("previewImgURL"));
        } else
        {
            obj = null;
        }
        i = ((URI) (obj));
        j = URI.create(jsonobject.getString("downloadURL"));
        k = jsonobject.optString("downloadChecksum");
        obj = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
        l = Calendar.getInstance();
        l.setTime(((SimpleDateFormat) (obj)).parse(jsonobject.optString("publishDate")));
        m = null;
        s = jsonobject.optString("unlockTitle");
        t = jsonobject.optString("unlockDescription");
        u = jsonobject.optString("unlockSucceededDescription");
        v = jsonobject.optString("unlockKeyId");
        p = false;
        y = jsonobject.optBoolean("editMode");
        z = jsonobject.optBoolean("liveMode");
        A = UnlockMethod.a(jsonobject.optString("unlockMethod").toUpperCase(Locale.US));
        if (jsonobject.has("expiredDate"))
        {
            m = Calendar.getInstance();
            m.setTime(((SimpleDateFormat) (obj)).parse(jsonobject.getString("expiredDate")));
        }
        n = Long.valueOf(jsonobject.optLong("tipId"));
        o = null;
        if (jsonobject.has("referEffects"))
        {
            obj = jsonobject.getJSONArray("referEffects");
            o = new ArrayList(((JSONArray) (obj)).length());
            for (int i1 = 0; i1 < ((JSONArray) (obj)).length(); i1++)
            {
                f f1 = new f(this, (JSONObject)((JSONArray) (obj)).get(i1));
                o.add(f1);
            }

        }
        q = jsonobject.optString("unlockType");
        if (jsonobject.has("chorusLockedURLs"))
        {
            JSONArray jsonarray = jsonobject.getJSONArray("chorusLockedURLs");
            r = new ArrayList(jsonarray.length());
            for (int j1 = 0; j1 < jsonarray.length(); j1++)
            {
                URI uri = URI.create(jsonarray.getString(j1));
                r.add(uri);
            }

        }
        if (jsonobject.has("keyURL"))
        {
            x = URI.create(jsonobject.getString("keyURL"));
        }
        if (jsonobject.has("unlockNames"))
        {
            jsonobject = jsonobject.getJSONArray("unlockNames");
            w = new ArrayList(jsonobject.length());
            for (int k1 = ((flag) ? 1 : 0); k1 < jsonobject.length(); k1++)
            {
                String s1 = jsonobject.getString(k1);
                w.add(s1);
            }

        }
        if (q != null && q.equals("Locked"))
        {
            p = true;
            if (!u.isEmpty())
            {
                cc.a(v, u);
            }
        }
    }

    public long a()
    {
        return b;
    }

    public ContentValues a(long l1, long l2)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("MIid", Long.valueOf(l1));
        contentvalues.put("Cid", Long.valueOf(l2));
        contentvalues.put("JsonString", a.toString());
        contentvalues.put("Ext_1", d);
        contentvalues.put("Ext_2", "");
        return contentvalues;
    }

    public String b()
    {
        return d;
    }

    public String c()
    {
        return e;
    }

    public String d()
    {
        return f;
    }

    public String e()
    {
        return g;
    }

    public URI f()
    {
        return h;
    }

    public URI g()
    {
        return i;
    }

    public Calendar h()
    {
        return l;
    }

    public Calendar i()
    {
        return m;
    }

    public List j()
    {
        return o;
    }

    public boolean k()
    {
        while (p && (cc.a(A) || cc.d(v))) 
        {
            return false;
        }
        return p;
    }

    public long l()
    {
        return b;
    }

    public String m()
    {
        return d;
    }

    public String n()
    {
        return "makeup";
    }

    public URI o()
    {
        return j;
    }

    public List p()
    {
        return r;
    }

    public URI q()
    {
        return x;
    }

    public List r()
    {
        return w;
    }

    public String s()
    {
        return s;
    }

    public String t()
    {
        return t;
    }

    public String u()
    {
        return v;
    }

    public JSONObject v()
    {
        return a;
    }

    public boolean w()
    {
        return y;
    }

    public boolean x()
    {
        return z;
    }

    public UnlockMethod y()
    {
        return A;
    }

    private class UnlockMethod extends Enum
    {

        public static final UnlockMethod a;
        public static final UnlockMethod b;
        public static final UnlockMethod c;
        private static final UnlockMethod d[];

        static UnlockMethod a(String s1)
        {
            return b(s1);
        }

        private static UnlockMethod b(String s1)
        {
            try
            {
                s1 = valueOf(s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return c;
            }
            return s1;
        }

        public static UnlockMethod valueOf(String s1)
        {
            return (UnlockMethod)Enum.valueOf(com/cyberlink/youcammakeup/database/more/makeup/MakeupItemMetadata$UnlockMethod, s1);
        }

        public static UnlockMethod[] values()
        {
            return (UnlockMethod[])d.clone();
        }

        static 
        {
            a = new UnlockMethod("SHARE", 0);
            b = new UnlockMethod("BC_LOGIN", 1);
            c = new UnlockMethod("OTHER", 2);
            d = (new UnlockMethod[] {
                a, b, c
            });
        }

        private UnlockMethod(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
