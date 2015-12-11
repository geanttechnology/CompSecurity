// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            v, al

static final class 
{

    String a;
    String b;
    String c;
    int d;
    String e;

    public final String a()
    {
        Object obj;
        try
        {
            obj = new JSONObject();
            ((JSONObject) (obj)).put("appID", a);
            ((JSONObject) (obj)).put("appKey", b);
            ((JSONObject) (obj)).put("server", c);
            ((JSONObject) (obj)).put("port", d);
            e = ((JSONObject) (obj)).getString("sessionID");
            obj = ((JSONObject) (obj)).toString();
        }
        catch (JSONException jsonexception)
        {
            al.a("HandShake", "Error creating JSON from NuanceCredentials", jsonexception);
            return null;
        }
        return ((String) (obj));
    }

    public final String toString()
    {
        return (new StringBuilder("Credentials: appid=")).append(a).append(" server=").append(c).append(" port=").append(d).append(" appKey=").append(b).append("sessionID=").append(e).toString();
    }

    public (String s)
    {
        try
        {
            s = new JSONObject(s);
            a = s.getString("appID");
            b = s.getString("appKey");
            c = s.getString("server");
            d = s.getInt("port");
            e = s.getString("sessionID");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            al.a("HandShake", "Error parsing nuance string to json", s);
        }
    }
}
