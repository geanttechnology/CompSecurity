// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Activity;
import android.content.Context;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            PLog, Parse, ManifestInfo

class PushRoutes
{
    public static final class Route
    {

        private final String activityClassName;
        private final int iconId;

        public static Route newFromJSON(JSONObject jsonobject)
        {
            Object obj;
            int i;
            i = 0;
            obj = null;
            if (jsonobject == null) goto _L2; else goto _L1
_L1:
            JSONObject jsonobject1 = jsonobject.optJSONObject("data");
            if (jsonobject1 == null) goto _L2; else goto _L3
_L3:
            jsonobject = jsonobject1.optString("activityClass", null);
            i = jsonobject1.optInt("icon", 0);
_L5:
            Route route = obj;
            if (jsonobject != null)
            {
                route = obj;
                if (i != 0)
                {
                    route = new Route(jsonobject, i);
                }
            }
            return route;
_L2:
            jsonobject = null;
            if (true) goto _L5; else goto _L4
_L4:
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (obj instanceof Route)
                {
                    obj = (Route)obj;
                    flag = flag1;
                    if (activityClassName.equals(((Route) (obj)).activityClassName))
                    {
                        flag = flag1;
                        if (iconId == ((Route) (obj)).iconId)
                        {
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        }

        public Class getActivityClass()
        {
            Object obj = null;
            Class class1;
            try
            {
                class1 = Class.forName(activityClassName);
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                classnotfoundexception = null;
            }
            if (class1 != null && !android/app/Activity.isAssignableFrom(class1))
            {
                class1 = obj;
            }
            if (class1 == null)
            {
                PLog.e("com.parse.PushRoutes", (new StringBuilder()).append("Activity class ").append(activityClassName).append(" registered to handle push no ").append("longer exists. Call PushService.subscribe with an activity class that does exist.").toString());
            }
            return class1;
        }

        public int getIconId()
        {
            return iconId;
        }

        public int hashCode()
        {
            return (activityClassName.hashCode() + 31) * 31 + iconId;
        }

        public JSONObject toJSON()
            throws JSONException
        {
            Context context = Parse.getApplicationContext();
            JSONObject jsonobject = new JSONObject();
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("appName", ManifestInfo.getDisplayName(context));
            jsonobject1.put("activityPackage", context.getPackageName());
            jsonobject1.put("activityClass", activityClassName);
            jsonobject1.put("icon", iconId);
            jsonobject.put("data", jsonobject1);
            jsonobject.put("name", "com.parse.StandardPushCallback");
            return jsonobject;
        }

        public String toString()
        {
            return (new StringBuilder()).append(super.toString()).append(" (activityClassName: ").append(activityClassName).append(" iconId: ").append(iconId).append(")").toString();
        }

        public Route(String s, int i)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("activityClassName can't be null");
            }
            if (i == 0)
            {
                throw new IllegalArgumentException("iconId can't be 0");
            } else
            {
                activityClassName = s;
                iconId = i;
                return;
            }
        }
    }


    private static final Pattern CHANNEL_PATTERN = Pattern.compile("^$|^[a-zA-Z][A-Za-z0-9_-]*$");
    private static final String TAG = "com.parse.PushRoutes";
    private final HashMap channels = new HashMap();

    public PushRoutes(JSONObject jsonobject)
    {
        if (jsonobject != null)
        {
            JSONObject jsonobject1 = jsonobject.optJSONObject("routes");
            if (jsonobject1 != null)
            {
                Iterator iterator = jsonobject1.keys();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s = (String)iterator.next();
                    Route route = Route.newFromJSON(jsonobject1.optJSONObject(s));
                    if (s != null && route != null)
                    {
                        put(s, route);
                    }
                } while (true);
            }
            jsonobject = jsonobject.optJSONObject("defaultRoute");
            if (jsonobject != null)
            {
                jsonobject = Route.newFromJSON(jsonobject);
                if (jsonobject != null)
                {
                    put(null, jsonobject);
                }
            }
        }
    }

    public static boolean isValidChannelName(String s)
    {
        com/parse/PushRoutes;
        JVM INSTR monitorenter ;
        boolean flag = CHANNEL_PATTERN.matcher(s).matches();
        com/parse/PushRoutes;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public Route get(String s)
    {
        return (Route)channels.get(s);
    }

    public Set getChannels()
    {
        return Collections.unmodifiableSet(channels.keySet());
    }

    public Route put(String s, Route route)
    {
        if (route == null)
        {
            throw new IllegalArgumentException("Can't insert null route");
        }
        if (s != null && !isValidChannelName(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid channel name: ").append(s).toString());
        } else
        {
            return (Route)channels.put(s, route);
        }
    }

    public Route remove(String s)
    {
        return (Route)channels.remove(s);
    }

    public JSONObject toJSON()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        JSONObject jsonobject1 = new JSONObject();
        for (Iterator iterator = channels.entrySet().iterator(); iterator.hasNext();)
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = (Route)((java.util.Map.Entry) (obj)).getValue();
            if (s == null)
            {
                jsonobject.put("defaultRoute", ((Route) (obj)).toJSON());
            } else
            {
                jsonobject1.put(s, ((Route) (obj)).toJSON());
            }
        }

        jsonobject.put("routes", jsonobject1);
        return jsonobject;
    }

}
