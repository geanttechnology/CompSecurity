// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import org.json.JSONObject;

public class ki
{

    public boolean a;
    public boolean b;
    public boolean c;
    public kp d;
    protected int e;
    public int f;
    public int g;
    public String h;
    public String i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;
    public byte n[];

    public ki()
    {
        a = false;
        b = false;
        c = false;
        k = false;
        l = false;
        m = false;
        n = null;
    }

    public static ki a(JSONObject jsonobject)
    {
        ki ki1 = new ki();
        Object obj;
        if (!jsonobject.isNull("id"))
        {
            ki1.b(jsonobject.getInt("id"));
        }
        if (!jsonobject.isNull("position"))
        {
            ki1.c(jsonobject.getInt("position"));
        }
        if (!jsonobject.isNull("appstoreID"))
        {
            ki1.a(jsonobject.getInt("appstoreID"));
        }
        if (jsonobject.isNull("url"))
        {
            break MISSING_BLOCK_LABEL_90;
        }
        obj = jsonobject.getString("url");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        ki1.b(((String) (obj)));
        if (jsonobject.isNull("imageurl")) goto _L2; else goto _L1
_L1:
        obj = jsonobject.getString("imageurl");
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (((String) (obj)).equalsIgnoreCase(""))
        {
            return null;
        }
        ki1.c(((String) (obj)));
_L2:
        if (!jsonobject.isNull("schemurl"))
        {
            ki1.a(jsonobject.getString("schemurl"));
        }
        if (!jsonobject.isNull("clearWhenClicked"))
        {
            ki1.a(jsonobject.getBoolean("clearWhenClicked"));
        }
        if (!jsonobject.isNull("openIfExist"))
        {
            ki1.b(jsonobject.getBoolean("openIfExist"));
        }
        if (!jsonobject.isNull("closeNativeAD"))
        {
            ki1.d(jsonobject.getBoolean("closeNativeAD"));
        }
        obj = ki1;
        if (jsonobject.isNull("size"))
        {
            break MISSING_BLOCK_LABEL_245;
        }
        jsonobject = jsonobject.getJSONObject("size");
        ki1.a(new kp(jsonobject.getInt("width"), jsonobject.getInt("height")));
        obj = ki1;
_L5:
        return ((ki) (obj));
        jsonobject;
        Crashlytics.logException(jsonobject);
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
        return null;
    }

    public kp a()
    {
        return d;
    }

    public void a(int i1)
    {
        e = i1;
    }

    public void a(String s)
    {
        h = s;
    }

    public void a(kp kp1)
    {
        d = kp1;
    }

    public void a(boolean flag)
    {
        b = flag;
    }

    public void b(int i1)
    {
        f = i1;
    }

    public void b(String s)
    {
        i = s;
    }

    public void b(boolean flag)
    {
        a = flag;
    }

    public void c(int i1)
    {
        g = i1;
    }

    public void c(String s)
    {
        j = s;
    }

    public void c(boolean flag)
    {
        c = flag;
    }

    public void d(boolean flag)
    {
        k = flag;
    }
}
