// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Activity;
import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            PushRoutes, PLog, Parse, ManifestInfo

public static final class iconId
{

    private final String activityClassName;
    private final int iconId;

    public static iconId newFromJSON(JSONObject jsonobject)
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
        iconId iconid = obj;
        if (jsonobject != null)
        {
            iconid = obj;
            if (i != 0)
            {
                iconid = new <init>(jsonobject, i);
            }
        }
        return iconid;
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
            if (obj instanceof <init>)
            {
                obj = (<init>)obj;
                flag = flag1;
                if (activityClassName.equals(((activityClassName) (obj)).activityClassName))
                {
                    flag = flag1;
                    if (iconId == ((iconId) (obj)).iconId)
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

    public ption(String s, int i)
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
