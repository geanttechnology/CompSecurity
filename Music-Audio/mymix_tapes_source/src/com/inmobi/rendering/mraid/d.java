// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.core.utilities.info.c;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.rendering.mraid:
//            l

public class d
{

    private static final String c = com/inmobi/rendering/mraid/d.getSimpleName();
    public int a;
    public int b;
    private boolean d;
    private boolean e;
    private boolean f;
    private String g;

    public d()
    {
        a = DisplayInfo.a().b();
        b = DisplayInfo.a().a();
        d = false;
        f = true;
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("width", a);
            jsonobject.put("height", b);
            jsonobject.put("useCustomClose", d);
            jsonobject.put("isModal", f);
        }
        catch (JSONException jsonexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, c, (new StringBuilder()).append("Exception in composing ExpandProperties: ").append(jsonexception.getMessage()).toString());
        }
        g = jsonobject.toString();
    }

    public static d a(String s, d d1, l l)
    {
        d1 = new d();
        d1.g = s;
        try
        {
            s = new JSONObject(s);
            d1.f = true;
            if (s.has("useCustomClose"))
            {
                d1.e = true;
            }
            d1.d = s.optBoolean("useCustomClose", false);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, c, "Invalid expand properties string passed.", s);
            return d1;
        }
        return d1;
    }

    public boolean a()
    {
        return d;
    }

    public boolean b()
    {
        return e;
    }

    public String c()
    {
        return g;
    }

}
