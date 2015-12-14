// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class pp extends pi
{

    public pl a;
    public pk b;
    public String c;
    public String d;
    public String e;
    public float f;
    public float g;
    public float h;
    public String i;
    public float j;
    public float k;
    protected Map l;
    protected Map m;
    protected Map n;

    public pp()
    {
        l = null;
        m = null;
        n = null;
    }

    public static pp a(JSONObject jsonobject)
    {
        pp pp1;
        pp1 = new pp();
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        Object obj;
        if (jsonobject.has("coord"))
        {
            pp1.a = pl.a(kv.c(jsonobject, "display_location"));
        }
        pp1.b = new pk();
        if (!jsonobject.has("weather"))
        {
            break MISSING_BLOCK_LABEL_187;
        }
        obj = kv.b(jsonobject, "weather");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        if (((JSONArray) (obj)).length() > 0)
        {
            obj = ((JSONArray) (obj)).getJSONObject(0);
            String s = kv.a(((JSONObject) (obj)), "icon");
            pp1.c = (String)pp1.c().get(s);
            pp1.d = kv.a(((JSONObject) (obj)), "main");
            pp1.e = pp1.a(s);
            if (jsonobject.has("main"))
            {
                JSONObject jsonobject1 = kv.c(jsonobject, "main");
                pp1.k = kv.f(jsonobject1, "pressure");
                pp1.h = kv.f(jsonobject1, "humidity");
                pp1.g = kv.f(jsonobject1, "temp") - 273.15F;
                pp1.f = (pp1.g * 9F) / 5F + 32F;
            }
        }
        if (!jsonobject.has("wind"))
        {
            break MISSING_BLOCK_LABEL_231;
        }
        jsonobject = kv.c(jsonobject, "wind");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        pp1.j = kv.f(jsonobject, "wind");
        return pp1;
        pp1.j = 0.0F;
        return pp1;
        jsonobject;
        jsonobject.printStackTrace();
        return pp1;
    }

    public String a(String s)
    {
        if (ew.b())
        {
            s = (String)a().get(s);
        } else
        {
            s = (String)b().get(s);
        }
        if (s != null)
        {
            return s;
        } else
        {
            return "\u6674";
        }
    }

    public Map a()
    {
        if (l == null)
        {
            l = new HashMap(50);
            l.put("01d", "\u6674");
            l.put("01n", "\u6674");
            l.put("02d", "\u9634");
            l.put("02n", "\u9634");
            l.put("03d", "\u4E91");
            l.put("03n", "\u4E91");
            l.put("04d", "\u4E91");
            l.put("04n", "\u4E91");
            l.put("09d", "\u96E8");
            l.put("09n", "\u96E8");
            l.put("10d", "\u96E8");
            l.put("10n", "\u96E8");
            l.put("11d", "\u96F7");
            l.put("11n", "\u96F7");
            l.put("13d", "\u96EA");
            l.put("13n", "\u96EA");
            l.put("50d", "\u96FE");
            l.put("50n", "\u96FE");
        }
        return l;
    }

    public Map b()
    {
        if (m == null)
        {
            m = new HashMap(50);
            m.put("01d", "\u6674");
            m.put("01n", "\u6674");
            m.put("02d", "\u9670");
            m.put("02n", "\u9670");
            m.put("03d", "\u96F2");
            m.put("03n", "\u96F2");
            m.put("04d", "\u96F2");
            m.put("04n", "\u96F2");
            m.put("09d", "\u96E8");
            m.put("09n", "\u96E8");
            m.put("10d", "\u96E8");
            m.put("10n", "\u96E8");
            m.put("11d", "\u96F7");
            m.put("11n", "\u96F7");
            m.put("13d", "\u96EA");
            m.put("13n", "\u96EA");
            m.put("50d", "\u9727");
            m.put("50n", "\u9727");
        }
        return m;
    }

    public Map c()
    {
        if (n == null)
        {
            n = new HashMap(50);
            n.put("01d", "clear");
            n.put("01n", "nt_clear");
            n.put("02d", "partlysunny");
            n.put("02n", "nt_partlysunny");
            n.put("03d", "cloudy");
            n.put("03n", "nt_cloudy");
            n.put("04d", "mostlycloudy");
            n.put("04n", "nt_mostlycloudy");
            n.put("09d", "rain");
            n.put("09n", "rain");
            n.put("10d", "rain");
            n.put("10n", "rain");
            n.put("11d", "tstorms");
            n.put("11n", "nt_tstorms");
            n.put("13d", "snow");
            n.put("13n", "snow");
            n.put("50d", "fog");
            n.put("50n", "nt_fog");
        }
        return n;
    }
}
