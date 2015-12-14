// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.az;

import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.az:
//            d

public final class c
{

    public String a;
    public String b;
    public ArrayList c;
    private String d;

    public c(JSONObject jsonobject, String s)
    {
        c = new ArrayList();
        a = jsonobject.getString("name");
        d = (new StringBuilder()).append(s).append(a).append("/").toString();
        s = new File(d);
        if (!s.exists())
        {
            s.mkdirs();
        }
        b = (new StringBuilder()).append(d).append(a).toString();
        jsonobject = jsonobject.getJSONArray("items");
        int i = 0;
_L2:
        if (i >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        s = new d(jsonobject.getJSONObject(i), d);
        c.add(s);
        i++;
        if (true) goto _L2; else goto _L1
        jsonobject;
        jsonobject.printStackTrace();
_L1:
    }
}
