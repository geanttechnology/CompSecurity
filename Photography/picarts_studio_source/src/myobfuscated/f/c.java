// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.f;

import bo.app.bx;
import bo.app.ct;
import bo.app.ep;
import myobfuscated.i.a;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.f:
//            f, b

public abstract class c extends f
    implements b
{

    public String a;
    public String b;
    private boolean o;

    protected c()
    {
        o = false;
    }

    public c(JSONObject jsonobject, bx bx1)
    {
        super(jsonobject, bx1);
        o = false;
        if (!ep.c(jsonobject.optString("zipped_assets_url")))
        {
            a = jsonobject.optString("zipped_assets_url");
        }
    }

    public final boolean a(String s)
    {
        if (ep.b(f) && ep.b(g))
        {
            return false;
        }
        if (o)
        {
            myobfuscated.i.a.a(c, "Button click already logged for this message. Ignoring.");
            return false;
        }
        if (h == null)
        {
            myobfuscated.i.a.c(c, "Cannot log a button click because the AppboyManager is null.");
            return false;
        }
        try
        {
            s = ct.a(f, g, s);
            h.a(s);
            o = true;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            h.a(s);
            return false;
        }
        return true;
    }

    public final String u()
    {
        return b;
    }
}
