// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.json.JSONObject;

public class pl extends pi
{

    public String a;
    public String b;

    public pl()
    {
    }

    public static pl a(JSONObject jsonobject)
    {
        pl pl1 = new pl();
        if (jsonobject != null)
        {
            try
            {
                pl1.a = kv.a(jsonobject, "latitude");
                pl1.b = kv.a(jsonobject, "longitude");
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                jsonobject.printStackTrace();
                return pl1;
            }
        }
        return pl1;
    }
}
