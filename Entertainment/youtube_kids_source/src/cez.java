// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class cez
{

    private static final Logger a = Logger.getLogger(cez.getCanonicalName());

    public cez()
    {
    }

    public static JSONObject a(cgo cgo1)
    {
        JSONObject jsonobject = new JSONObject();
        for (Iterator iterator = cgo1.iterator(); iterator.hasNext();)
        {
            cgq cgq1 = (cgq)iterator.next();
            try
            {
                jsonobject.put(cgq1.a, cgq1.b);
            }
            catch (JSONException jsonexception)
            {
                Logger logger = a;
                String s = String.valueOf(cgo1);
                String s1 = String.valueOf(jsonexception);
                logger.warning((new StringBuilder(String.valueOf(s).length() + 26 + String.valueOf(s1).length())).append("Error converting ").append(s).append(" to JSON ").append(s1).toString());
            }
        }

        return jsonobject;
    }

    static 
    {
        cez.getCanonicalName();
    }
}
