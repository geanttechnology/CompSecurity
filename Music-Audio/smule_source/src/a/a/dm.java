// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            dp, v, ay, au, 
//            en

public final class dm
    implements dp
{

    public Map a;

    public dm(v v1)
    {
        a = new HashMap();
        a.put("app_id", v1.a());
        a.put("hashed_device_id", v1.c());
        a.put("library_version", "5.0.6");
    }

    public final dm a(String s, String s1)
    {
        a.put(s, s1);
        return this;
    }

    public final dm a(String s, JSONArray jsonarray)
    {
        a.put(s, jsonarray);
        return this;
    }

    public final dp a(ay ay1)
    {
        String s = ay1.b;
        a.put(ay1.b, (new au(ay1)).a);
        return this;
    }

    public final void a(OutputStream outputstream)
    {
        en.b();
        outputstream.write((new JSONObject(a)).toString().getBytes("UTF8"));
    }

    public final String toString()
    {
        String s;
        try
        {
            s = (new JSONObject(a)).toString(4);
        }
        catch (JSONException jsonexception)
        {
            en.a();
            return null;
        }
        return s;
    }
}
