// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            df, y, eh, en

public final class ei
{

    public static eh a(y y1)
    {
        JSONObject jsonobject;
        Object obj;
        jsonobject = null;
        obj = y1.a(df.i.a(), df.i.b());
        if (obj == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        try
        {
            obj = new JSONObject(((String) (obj)));
        }
        catch (JSONException jsonexception)
        {
            en.b();
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
            flag = y1.c(df.l.a(), df.l.b());
        }
        return new eh(flag);
_L2:
        jsonobject = null;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
