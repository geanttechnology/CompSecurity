// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bo.app;

import com.appboy.Constants;
import myobfuscated.f.m;
import myobfuscated.i.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class cp
{

    private static final String b;
    public final m a;

    public cp(JSONObject jsonobject)
    {
        JSONObject jsonobject1;
        jsonobject1 = jsonobject.optJSONObject("error");
        if (jsonobject1 == null) goto _L2; else goto _L1
_L1:
        jsonobject = new m(jsonobject1);
_L4:
        a = jsonobject;
        return;
        jsonobject;
        myobfuscated.i.a.b(b, (new StringBuilder("Encountered exception processing ResponseError: ")).append(jsonobject1.toString()).toString(), jsonobject);
_L2:
        jsonobject = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        b = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, bo/app/cp.getName()
        });
    }
}
