// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.h;

import bo.app.ep;
import com.appboy.Constants;
import myobfuscated.f.e;
import myobfuscated.i.a;
import org.json.JSONException;
import org.json.JSONObject;

public class b
    implements e
{

    private static final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    public final JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            if (!ep.c(b))
            {
                jsonobject.put("source", b);
            }
            if (!ep.c(c))
            {
                jsonobject.put("campaign", c);
            }
            if (!ep.c(d))
            {
                jsonobject.put("adgroup", d);
            }
            if (!ep.c(e))
            {
                jsonobject.put("ad", e);
            }
        }
        catch (JSONException jsonexception)
        {
            myobfuscated.i.a.c(a, "Caught exception creating AttributionData Json.", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public Object forJsonPut()
    {
        return a();
    }

    static 
    {
        a = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, myobfuscated/h/b.getName()
        });
    }
}
