// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.appevents:
//            AppEventsLogger

static class jsonObject
    implements Serializable
{

    private static final HashSet validatedIdentifiers = new HashSet();
    private boolean isImplicit;
    private JSONObject jsonObject;
    private String name;

    private void validateIdentifier(String s)
        throws FacebookException
    {
        if (s == null || s.length() == 0 || s.length() > 40)
        {
            String s1 = s;
            if (s == null)
            {
                s1 = "<None Provided>";
            }
            throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[] {
                s1, Integer.valueOf(40)
            }));
        }
        boolean flag;
        synchronized (validatedIdentifiers)
        {
            flag = validatedIdentifiers.contains(s);
        }
        if (!flag)
        {
            if (!s.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$"))
            {
                break MISSING_BLOCK_LABEL_117;
            }
            synchronized (validatedIdentifiers)
            {
                validatedIdentifiers.add(s);
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
        throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[] {
            s
        }));
    }

    public boolean getIsImplicit()
    {
        return isImplicit;
    }

    public JSONObject getJSONObject()
    {
        return jsonObject;
    }

    public String toString()
    {
        return String.format("\"%s\", implicit: %b, json: %s", new Object[] {
            jsonObject.optString("_eventName"), Boolean.valueOf(isImplicit), jsonObject.toString()
        });
    }


    public (Context context, String s, Double double1, Bundle bundle, boolean flag)
    {
        validateIdentifier(s);
        name = s;
        isImplicit = flag;
        jsonObject = new JSONObject();
        jsonObject.put("_eventName", s);
        jsonObject.put("_logTime", System.currentTimeMillis() / 1000L);
        jsonObject.put("_ui", Utility.getActivityName(context));
        if (double1 == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        jsonObject.put("_valueToSum", double1.doubleValue());
        if (isImplicit)
        {
            jsonObject.put("_implicitlyLogged", "1");
        }
        if (bundle == null) goto _L2; else goto _L1
_L1:
        context = bundle.keySet().iterator();
_L5:
        if (!context.hasNext()) goto _L2; else goto _L3
_L3:
        s = (String)context.next();
        validateIdentifier(s);
        double1 = ((Double) (bundle.get(s)));
        if (!(double1 instanceof String) && !(double1 instanceof Number))
        {
            throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[] {
                double1, s
            }));
        }
          goto _L4
        context;
        Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", new Object[] {
            context.toString()
        });
        jsonObject = null;
_L7:
        return;
_L4:
        jsonObject.put(s, double1.toString());
          goto _L5
        context;
        Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event name or parameter:", new Object[] {
            context.toString()
        });
        jsonObject = null;
        return;
_L2:
        if (isImplicit) goto _L7; else goto _L6
_L6:
        Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", new Object[] {
            jsonObject.toString()
        });
        return;
          goto _L5
    }
}
