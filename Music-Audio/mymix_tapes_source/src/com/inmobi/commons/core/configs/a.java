// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.configs;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class com.inmobi.commons.core.configs.a
{
    public static final class a
    {

        private HashMap a;

        static HashMap a(a a1)
        {
            return a1.a;
        }

        public HashMap a()
        {
            return a;
        }

        public a()
        {
            a = new HashMap();
            a.put("O1", Boolean.valueOf(true));
            a.put("SID", Boolean.valueOf(true));
            a.put("LID", Boolean.valueOf(true));
            a.put("UM5", Boolean.valueOf(true));
            a.put("GPID", Boolean.valueOf(true));
            a.put("IMID", Boolean.valueOf(true));
            a.put("AIDL", Boolean.valueOf(true));
        }
    }


    private a a;

    public com.inmobi.commons.core.configs.a()
    {
        a = new a();
    }

    public abstract String a();

    public void a(JSONObject jsonobject)
        throws JSONException
    {
        jsonobject = jsonobject.getJSONObject("includeIds");
        for (int i = 0; i < jsonobject.length(); i++)
        {
            a.a(a).put("O1", Boolean.valueOf(jsonobject.getBoolean("O1")));
            a.a(a).put("SID", Boolean.valueOf(jsonobject.getBoolean("SID")));
            a.a(a).put("LID", Boolean.valueOf(jsonobject.getBoolean("LID")));
            a.a(a).put("UM5", Boolean.valueOf(jsonobject.getBoolean("UM5")));
            a.a(a).put("GPID", Boolean.valueOf(jsonobject.getBoolean("GPID")));
            a.a(a).put("IMID", Boolean.valueOf(jsonobject.getBoolean("IMID")));
            a.a(a).put("AIDL", Boolean.valueOf(jsonobject.getBoolean("AIDL")));
        }

    }

    public JSONObject b()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("O1", a.a(a).get("O1"));
        jsonobject1.put("SID", a.a(a).get("SID"));
        jsonobject1.put("LID", a.a(a).get("LID"));
        jsonobject1.put("UM5", a.a(a).get("UM5"));
        jsonobject1.put("GPID", a.a(a).get("GPID"));
        jsonobject1.put("IMID", a.a(a).get("IMID"));
        jsonobject1.put("AIDL", a.a(a).get("AIDL"));
        jsonobject.put("includeIds", jsonobject1);
        return jsonobject;
    }

    public abstract boolean c();

    public abstract com.inmobi.commons.core.configs.a d();

    public boolean equals(Object obj)
    {
        while (obj == null || obj.getClass() != getClass() || !a().equals(((com.inmobi.commons.core.configs.a)obj).a())) 
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        return a().hashCode();
    }

    public a o()
    {
        return a;
    }
}
