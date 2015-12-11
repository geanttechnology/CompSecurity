// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.a;

import android.os.Bundle;
import com.facebook.f;
import com.facebook.internal.j;
import com.facebook.q;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.a:
//            a

static class 
    implements Serializable
{

    private static final HashSet c = new HashSet();
    private JSONObject a;
    private boolean b;
    private String d;

    private void a(String s)
        throws f
    {
        if (s == null || s.length() == 0 || s.length() > 40)
        {
            String s1 = s;
            if (s == null)
            {
                s1 = "<None Provided>";
            }
            throw new f(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[] {
                s1, Integer.valueOf(40)
            }));
        }
        boolean flag;
        synchronized (c)
        {
            flag = c.contains(s);
        }
        if (!flag)
        {
            if (!s.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$"))
            {
                break MISSING_BLOCK_LABEL_117;
            }
            synchronized (c)
            {
                c.add(s);
            }
        }
        return;
        s;
        hashset;
        JVM INSTR monitorexit ;
        throw s;
        s;
        hashset;
        JVM INSTR monitorexit ;
        throw s;
        throw new f(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[] {
            s
        }));
    }

    static boolean a(rmat rmat)
    {
        return rmat.b;
    }

    public String a()
    {
        return d;
    }

    public boolean b()
    {
        return b;
    }

    public JSONObject c()
    {
        return a;
    }

    public String toString()
    {
        String s = a.optString("_eventName");
        boolean flag = b;
        Object obj = a;
        if (!(obj instanceof JSONObject))
        {
            obj = ((JSONObject) (obj)).toString();
        } else
        {
            obj = JSONObjectInstrumentation.toString((JSONObject)obj);
        }
        return String.format("\"%s\", implicit: %b, json: %s", new Object[] {
            s, Boolean.valueOf(flag), obj
        });
    }


    public (String s, String s1, Double double1, Bundle bundle, boolean flag)
    {
        a(s1);
        d = s1;
        b = flag;
        a = new JSONObject();
        a.put("_eventName", s1);
        a.put("_logTime", System.currentTimeMillis() / 1000L);
        a.put("_ui", s);
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
        s = bundle.keySet().iterator();
_L10:
        if (!s.hasNext()) goto _L2; else goto _L3
_L3:
        s1 = (String)s.next();
        a(s1);
        double1 = ((Double) (bundle.get(s1)));
        if (!(double1 instanceof String) && !(double1 instanceof Number))
        {
            throw new f(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[] {
                double1, s1
            }));
        }
          goto _L4
_L5:
        return;
_L4:
        try
        {
            a.put(s1, double1.toString());
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            j.a(q.e, "AppEvents", "JSON encoding for app event failed: '%s'", new Object[] {
                s.toString()
            });
            a = null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            j.a(q.e, "AppEvents", "Invalid app event name or parameter:", new Object[] {
                s.toString()
            });
            a = null;
            return;
        }
        if (true) goto _L5; else goto _L2
_L2:
        if (b) goto _L5; else goto _L6
_L6:
        s1 = q.e;
        s = a;
        if (s instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_310;
        }
        s = s.toString();
_L8:
        j.a(s1, "AppEvents", "Created app event '%s'", new Object[] {
            s
        });
        return;
        s = JSONObjectInstrumentation.toString((JSONObject)s);
        if (true) goto _L8; else goto _L7
_L7:
        if (true) goto _L10; else goto _L9
_L9:
    }
}
