// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ci;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.ci:
//            b

public final class a
{

    String a;
    public ArrayList b;

    public a(JSONObject jsonobject)
    {
        a = jsonobject.getString("category_name");
        jsonobject = jsonobject.getJSONArray("items");
        b = new ArrayList(jsonobject.length());
        int i = 0;
_L2:
        if (i >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        b b1 = new b(jsonobject.getJSONObject(i));
        b.add(b1);
        i++;
        if (true) goto _L2; else goto _L1
        jsonobject;
        jsonobject.printStackTrace();
_L1:
    }
}
