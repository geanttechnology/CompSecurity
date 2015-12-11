// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            cw, cu, ew, an

public final class am extends cw
{

    private String a;
    private String b;
    private an c;
    private String d;

    public am(an an1, String s)
    {
        a = cu.a.a();
        b = ew.a.a();
        c = an1;
        d = s;
    }

    public final JSONArray a()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("event", Integer.valueOf(c.ordinal()));
        hashmap.put("viewName", d);
        return (new JSONArray()).put(b).put(5).put(new JSONObject(hashmap));
    }

    public final String f()
    {
        return a;
    }
}
