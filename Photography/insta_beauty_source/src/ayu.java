// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ayu extends ayn
{

    public ayq a;
    public ayp b;
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

    public ayu()
    {
        l = null;
        m = null;
        n = null;
    }

    public static ayu a(JSONObject jsonobject)
    {
        ayu ayu1;
        ayu1 = new ayu();
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        Object obj;
        if (jsonobject.has("coord"))
        {
            ayu1.a = ayq.a(aqn.c(jsonobject, "display_location"));
        }
        ayu1.b = new ayp();
        if (!jsonobject.has("weather"))
        {
            break MISSING_BLOCK_LABEL_187;
        }
        obj = aqn.b(jsonobject, "weather");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        if (((JSONArray) (obj)).length() > 0)
        {
            obj = ((JSONArray) (obj)).getJSONObject(0);
            String s = aqn.a(((JSONObject) (obj)), "icon");
            ayu1.c = (String)ayu1.c().get(s);
            ayu1.d = aqn.a(((JSONObject) (obj)), "main");
            ayu1.e = ayu1.a(s);
            if (jsonobject.has("main"))
            {
                JSONObject jsonobject1 = aqn.c(jsonobject, "main");
                ayu1.k = aqn.f(jsonobject1, "pressure");
                ayu1.h = aqn.f(jsonobject1, "humidity");
                ayu1.g = aqn.f(jsonobject1, "temp") - 273.15F;
                ayu1.f = (ayu1.g * 9F) / 5F + 32F;
            }
        }
        if (!jsonobject.has("wind"))
        {
            break MISSING_BLOCK_LABEL_231;
        }
        jsonobject = aqn.c(jsonobject, "wind");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        ayu1.j = aqn.f(jsonobject, "wind");
        return ayu1;
        ayu1.j = 0.0F;
        return ayu1;
        jsonobject;
        jsonobject.printStackTrace();
        return ayu1;
    }

    public String a(String s)
    {
        if (yp.b())
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
