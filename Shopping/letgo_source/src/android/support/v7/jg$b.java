// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Bundle;
import com.facebook.h;
import com.facebook.s;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            jg, jv

static class ring
    implements Serializable
{

    private static final HashSet c = new HashSet();
    private JSONObject a;
    private boolean b;
    private String d;

    private void a(String s1)
        throws h
    {
        if (s1 == null || s1.length() == 0 || s1.length() > 40)
        {
            String s2 = s1;
            if (s1 == null)
            {
                s2 = "<None Provided>";
            }
            throw new h(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[] {
                s2, Integer.valueOf(40)
            }));
        }
        boolean flag;
        synchronized (c)
        {
            flag = c.contains(s1);
        }
        if (!flag)
        {
            if (!s1.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$"))
            {
                break MISSING_BLOCK_LABEL_117;
            }
            synchronized (c)
            {
                c.add(s1);
            }
        }
        return;
        s1;
        hashset;
        JVM INSTR monitorexit ;
        throw s1;
        s1;
        hashset;
        JVM INSTR monitorexit ;
        throw s1;
        throw new h(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[] {
            s1
        }));
    }

    public boolean a()
    {
        return b;
    }

    public JSONObject b()
    {
        return a;
    }

    public String toString()
    {
        return String.format("\"%s\", implicit: %b, json: %s", new Object[] {
            a.optString("_eventName"), Boolean.valueOf(b), a.toString()
        });
    }


    public (String s1, String s2, Double double1, Bundle bundle, boolean flag)
    {
        a(s2);
        d = s2;
        b = flag;
        a = new JSONObject();
        a.put("_eventName", s2);
        a.put("_logTime", System.currentTimeMillis() / 1000L);
        a.put("_ui", s1);
        if (double1 == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        a.put("_valueToSum", double1.doubleValue());
        if (b)
        {
            a.put("_implicitlyLogged", "1");
        }
        if (bundle == null) goto _L2; else goto _L1
_L1:
        s1 = bundle.keySet().iterator();
_L5:
        if (!s1.hasNext()) goto _L2; else goto _L3
_L3:
        s2 = (String)s1.next();
        a(s2);
        double1 = ((Double) (bundle.get(s2)));
        if (!(double1 instanceof String) && !(double1 instanceof Number))
        {
            throw new h(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[] {
                double1, s2
            }));
        }
          goto _L4
        s1;
        jv.a(s.e, "AppEvents", "JSON encoding for app event failed: '%s'", new Object[] {
            s1.toString()
        });
        a = null;
_L7:
        return;
_L4:
        a.put(s2, double1.toString());
          goto _L5
        s1;
        jv.a(s.e, "AppEvents", "Invalid app event name or parameter:", new Object[] {
            s1.toString()
        });
        a = null;
        return;
_L2:
        if (b) goto _L7; else goto _L6
_L6:
        jv.a(s.e, "AppEvents", "Created app event '%s'", new Object[] {
            a.toString()
        });
        return;
          goto _L5
    }
}
