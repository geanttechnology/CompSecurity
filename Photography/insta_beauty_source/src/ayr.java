// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class ayr
    implements ayt
{

    private static ayr e = null;
    private WeakReference a;
    private ayu b;
    private long c;
    private long d;

    private ayr()
    {
        b = null;
        c = 0L;
        d = 0x6ddd00L;
    }

    public static ayr a()
    {
        if (e != null) goto _L2; else goto _L1
_L1:
        ayr;
        JVM INSTR monitorenter ;
        if (e == null)
        {
            e = new ayr();
        }
        ayr;
        JVM INSTR monitorexit ;
_L2:
        return e;
        Exception exception;
        exception;
        ayr;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(double d1, double d2)
    {
        Log.v("WeatherManager", (new StringBuilder()).append("WeatherManager System.currentTimeMillis():").append(System.currentTimeMillis()).toString());
        Log.v("WeatherManager", (new StringBuilder()).append("WeatherManager lastSuccessRequestTime:").append(c).toString());
        Log.v("WeatherManager", (new StringBuilder()).append("WeatherManager divere :").append(System.currentTimeMillis() - c).toString());
        if (System.currentTimeMillis() - c < d)
        {
            if (a != null && a.get() != null && b != null)
            {
                ((ayo)a.get()).requestCurrentConditionWithLocationFinished();
            }
            return;
        } else
        {
            String s = String.format("%sweather?lat=%f&lon=%f&APPID=%s", new Object[] {
                "http://api.openweathermap.org/data/2.5/", Double.valueOf(d1), Double.valueOf(d2), "dcaf8df52473d2bd04f9ab9c8d485c4e"
            });
            Log.v("WeatherManager", (new StringBuilder()).append("WeatherManagerrequestURL\uFF1A").append(s).toString());
            ays ays1 = new ays();
            ays1.a(this);
            ays1.execute(new String[] {
                s, "conditionWithLocation"
            });
            return;
        }
    }

    public void a(ayo ayo1)
    {
        a = new WeakReference(ayo1);
    }

    public void a(JSONObject jsonobject, String s)
    {
        if (!s.equalsIgnoreCase("conditionWithLocation") || jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        try
        {
            Log.v("WeatherManager", (new StringBuilder()).append("WeatherManagerresultJson :").append(jsonobject).toString());
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return;
        }
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        b = ayu.a(jsonobject);
        if (a != null && a.get() != null)
        {
            ((ayo)a.get()).requestCurrentConditionWithLocationFinished();
        }
        c = System.currentTimeMillis();
    }

    public ayu b()
    {
        return b;
    }

}
