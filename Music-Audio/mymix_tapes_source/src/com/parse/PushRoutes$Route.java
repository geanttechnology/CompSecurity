// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Activity;
import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            PushRoutes, Parse, ManifestInfo

public static final class iconId
{

    private final String activityClassName;
    private final int iconId;

    public static iconId newFromJSON(JSONObject jsonobject)
    {
        Object obj = null;
        Object obj1 = null;
        boolean flag = false;
        String s = obj1;
        int i = ((flag) ? 1 : 0);
        if (jsonobject != null)
        {
            jsonobject = jsonobject.optJSONObject("data");
            s = obj1;
            i = ((flag) ? 1 : 0);
            if (jsonobject != null)
            {
                s = jsonobject.optString("activityClass", null);
                i = jsonobject.optInt("icon", 0);
            }
        }
        jsonobject = obj;
        if (s != null)
        {
            jsonobject = obj;
            if (i != 0)
            {
                jsonobject = new <init>(s, i);
            }
        }
        return jsonobject;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (obj instanceof <init>)
                {
                    obj = (<init>)obj;
                    if (!activityClassName.equals(((activityClassName) (obj)).activityClassName) || iconId != ((iconId) (obj)).iconId)
                    {
                        break label0;
                    }
                    flag = true;
                }
            }
            return flag;
        }
        return false;
    }

    public Class getActivityClass()
    {
        Class class1 = null;
        Class class2 = Class.forName(activityClassName);
        class1 = class2;
_L2:
        Class class3 = class1;
        if (class1 != null)
        {
            class3 = class1;
            if (!android/app/Activity.isAssignableFrom(class1))
            {
                class3 = null;
            }
        }
        if (class3 == null)
        {
            Parse.logE("com.parse.PushRoutes", (new StringBuilder()).append("Activity class ").append(activityClassName).append(" registered to handle push no ").append("longer exists. Call PushService.subscribe with an activity class that does exist.").toString());
        }
        return class3;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
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
        JSONObject jsonobject = new JSONObject();
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("appName", ManifestInfo.getDisplayName());
        jsonobject1.put("activityPackage", Parse.applicationContext.getPackageName());
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
