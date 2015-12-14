// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import org.json.JSONObject;

public class apu
{

    public boolean a;
    public boolean b;
    public boolean c;
    public aqe d;
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

    public apu()
    {
        a = false;
        b = false;
        c = false;
        k = false;
        l = false;
        m = false;
        n = null;
    }

    public static apu a(JSONObject jsonobject)
    {
        apu apu1 = new apu();
        Object obj;
        if (!jsonobject.isNull("id"))
        {
            apu1.b(jsonobject.getInt("id"));
        }
        if (!jsonobject.isNull("position"))
        {
            apu1.c(jsonobject.getInt("position"));
        }
        if (!jsonobject.isNull("appstoreID"))
        {
            apu1.a(jsonobject.getInt("appstoreID"));
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
        apu1.b(((String) (obj)));
        if (jsonobject.isNull("imageurl")) goto _L2; else goto _L1
_L1:
        obj = jsonobject.getString("imageurl");
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (((String) (obj)).equalsIgnoreCase(""))
        {
            return null;
        }
        apu1.c(((String) (obj)));
_L2:
        if (!jsonobject.isNull("schemurl"))
        {
            apu1.a(jsonobject.getString("schemurl"));
        }
        if (!jsonobject.isNull("clearWhenClicked"))
        {
            apu1.a(jsonobject.getBoolean("clearWhenClicked"));
        }
        if (!jsonobject.isNull("openIfExist"))
        {
            apu1.b(jsonobject.getBoolean("openIfExist"));
        }
        if (!jsonobject.isNull("closeNativeAD"))
        {
            apu1.d(jsonobject.getBoolean("closeNativeAD"));
        }
        obj = apu1;
        if (jsonobject.isNull("size"))
        {
            break MISSING_BLOCK_LABEL_245;
        }
        jsonobject = jsonobject.getJSONObject("size");
        apu1.a(new aqe(jsonobject.getInt("width"), jsonobject.getInt("height")));
        obj = apu1;
_L5:
        return ((apu) (obj));
        jsonobject;
        Crashlytics.logException(jsonobject);
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
        return null;
    }

    public aqe a()
    {
        return d;
    }

    public void a(int i1)
    {
        e = i1;
    }

    public void a(aqe aqe1)
    {
        d = aqe1;
    }

    public void a(String s)
    {
        h = s;
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
