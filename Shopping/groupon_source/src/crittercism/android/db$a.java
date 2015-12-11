// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            db, cb, aw, dg

public static final class 
{

    public static db a(aw aw1)
    {
        JSONObject jsonobject;
        Object obj;
        jsonobject = null;
        obj = aw1.a(cb.j.a(), cb.j.b());
        if (obj == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        try
        {
            obj = new JSONObject(((String) (obj)));
        }
        catch (JSONException jsonexception)
        {
            dg.b();
            continue; /* Loop/switch isn't completed */
        }
        jsonobject = ((JSONObject) (obj));
_L4:
        if (jsonobject != null)
        {
            flag = jsonobject.optBoolean("optOutStatusSet", false);
        } else
        {
            flag = false;
        }
        if (flag)
        {
            flag = jsonobject.optBoolean("optOutStatus", false);
        } else
        {
            flag = aw1.c(cb.m.a(), cb.m.b());
        }
        return new db(flag);
_L2:
        jsonobject = null;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
