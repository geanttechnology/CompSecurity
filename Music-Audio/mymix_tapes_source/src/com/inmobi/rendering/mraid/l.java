// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.utilities.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class l
{

    private static String e = com/inmobi/rendering/mraid/l.getSimpleName();
    public boolean a;
    public String b;
    public String c;
    private String d;

    public l()
    {
        b = "none";
        c = "right";
        a = true;
        d = null;
    }

    public static l a(String s, l l1)
    {
        l l2 = new l();
        l2.d = s;
        try
        {
            s = new JSONObject(s);
            l2.b = s.optString("forceOrientation", l1.b);
            l2.a = s.optBoolean("allowOrientationChange", l1.a);
            l2.c = s.optString("direction", l1.c);
            if (!l2.b.equals("portrait") && !l2.b.equals("landscape"))
            {
                l2.b = "none";
            }
            if (!l2.c.equals("left") && !l2.c.equals("right"))
            {
                l2.c = "right";
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, e, "Invalid orientation properties string passed.", s);
            return null;
        }
        return l2;
    }

    public String a()
    {
        return d;
    }

}
