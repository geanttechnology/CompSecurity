// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            cw, cu, ew

public final class cg extends cw
{

    private String a;
    private String b;
    private String c;
    private String d;

    public cg(String s, String s1)
    {
        a = cu.a.a();
        b = ew.a.a();
        c = s;
        d = s1;
    }

    public final JSONArray a()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("name", c);
        hashmap.put("reason", d);
        return (new JSONArray()).put(b).put(6).put(new JSONObject(hashmap));
    }

    public final String f()
    {
        return a;
    }
}
