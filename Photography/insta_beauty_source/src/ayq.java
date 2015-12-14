// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.json.JSONObject;

public class ayq extends ayn
{

    public String a;
    public String b;

    public ayq()
    {
    }

    public static ayq a(JSONObject jsonobject)
    {
        ayq ayq1 = new ayq();
        if (jsonobject != null)
        {
            try
            {
                ayq1.a = aqn.a(jsonobject, "latitude");
                ayq1.b = aqn.a(jsonobject, "longitude");
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                jsonobject.printStackTrace();
                return ayq1;
            }
        }
        return ayq1;
    }
}
