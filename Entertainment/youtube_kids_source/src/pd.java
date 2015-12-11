// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import org.json.JSONException;
import org.json.JSONObject;

final class pd
    implements bhv
{

    private pc a;

    pd(pc pc1)
    {
        a = pc1;
        super();
    }

    public final void a(Object obj, Exception exception)
    {
        bmo.a("Could not fetch environment", exception);
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (Uri)obj;
        obj = (JSONObject)obj1;
        try
        {
            obj = ((JSONObject) (obj)).getJSONObject("environment");
            pc.a(a, ((JSONObject) (obj)).getString("country"), ((JSONObject) (obj)).getLong("start_time"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bmo.a("Could not fetch environment", ((Throwable) (obj)));
        }
    }
}
