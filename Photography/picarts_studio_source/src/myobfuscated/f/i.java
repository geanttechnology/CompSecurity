// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.f;

import bo.app.bx;
import bo.app.ct;
import bo.app.ep;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.i.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.f:
//            f, d, l

public abstract class i extends f
    implements d
{

    public String a;
    public int b;
    public int o;
    public List p;
    private boolean q;

    protected i()
    {
        b = 0;
        o = 0;
    }

    public i(JSONObject jsonobject, bx bx1)
    {
        this(jsonobject, bx1, jsonobject.optString("header"), jsonobject.optInt("header_text_color"), jsonobject.optInt("close_btn_color"));
        if (jsonobject.optJSONArray("btns") != null)
        {
            bx1 = new ArrayList();
            jsonobject = jsonobject.optJSONArray("btns");
            for (int j = 0; j < jsonobject.length(); j++)
            {
                bx1.add(new l(jsonobject.optJSONObject(j)));
            }

            p = bx1;
        }
    }

    private i(JSONObject jsonobject, bx bx1, String s, int j, int k)
    {
        super(jsonobject, bx1);
        b = 0;
        o = 0;
        a = s;
        b = j;
        o = k;
    }

    public final boolean a(l l1)
    {
        if (ep.b(f) && ep.b(g))
        {
            return false;
        }
        if (l1 == null)
        {
            myobfuscated.i.a.b(c, "Message button was null. Ignoring button click.");
            return false;
        }
        if (q)
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
            l1 = ct.a(f, g, l1);
            h.a(l1);
            q = true;
        }
        // Misplaced declaration of an exception variable
        catch (l l1)
        {
            h.a(l1);
            return false;
        }
        return true;
    }

    public final List u()
    {
        return p;
    }
}
