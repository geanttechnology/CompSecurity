// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class ms
{

    private static final String a = ms.getSimpleName();
    private ArrayList b;

    public ms(String s)
    {
        b = new ArrayList();
        try
        {
            s = new JSONObject(s);
            mt mt1;
            for (Iterator iterator = s.keys(); iterator.hasNext(); b.add(mt1))
            {
                mt1 = mt.a(s.get((String)iterator.next()).toString());
            }

        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            kf.e(a, (new StringBuilder()).append("Error parsing String to JSONArray:").append(s.getLocalizedMessage()).toString());
        }
    }

    public ArrayList a()
    {
        return b;
    }

}
