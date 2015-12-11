// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.json.JSONException;
import org.json.JSONObject;

public class us
{

    private ahi a;
    private sr b;
    private JSONObject c;

    public us(ahi ahi1, sr sr1, JSONObject jsonobject)
    {
        a = ahi1;
        b = sr1;
        c = jsonobject;
    }

    public void a()
    {
        a.h();
    }

    public void a(String s, int i)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("asset", i);
            jsonobject.put("template", s);
            s = new JSONObject();
            s.put("ad", c);
            s.put("click", jsonobject);
            b.a("google.afma.nativeAds.handleClick", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            acb.b("Unable to create click JSON.", s);
        }
    }
}
