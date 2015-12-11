// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class cre extends me
    implements cra
{

    public cre(int i, String s, mj mj)
    {
        super(i, s, mj);
    }

    public List b(mb mb1)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        arraylist = new ArrayList();
        arraylist.add("Default response logging.");
        int i = mb1.a;
        arraylist.add((new StringBuilder(20)).append("Status: ").append(i).append("\n").toString());
        String s;
        String s1;
        for (Iterator iterator = mb1.c.keySet().iterator(); iterator.hasNext(); arraylist.add((new StringBuilder(String.valueOf(s).length() + 9 + String.valueOf(s1).length())).append("Header:").append(s).append(":").append(s1).append("\n").toString()))
        {
            s = (String)iterator.next();
            s1 = (String)mb1.c.get(s);
        }

        break MISSING_BLOCK_LABEL_180;
        mb1;
        throw mb1;
        if (mb1.b != null)
        {
            int l = mb1.b.length;
            arraylist.add((new StringBuilder(31)).append("Actual data length: ").append(l).toString());
            for (mb1 = a.a(new String(mb1.b), 2048).iterator(); mb1.hasNext(); arraylist.add((String)mb1.next())) { }
            break MISSING_BLOCK_LABEL_283;
        }
        arraylist.add("Response had no data.");
        this;
        JVM INSTR monitorexit ;
        return arraylist;
    }

    public cpl j()
    {
        return null;
    }

    public final String j_()
    {
        return a();
    }

    public String k()
    {
        Object obj;
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append("Basic CURL command:");
        try
        {
            Map map = c();
            Iterator iterator = map.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                if (!s1.equals("Content-Type"))
                {
                    String s2 = (String)map.get(s1);
                    ((StringBuilder) (obj)).append((new StringBuilder(String.valueOf(s1).length() + 7 + String.valueOf(s2).length())).append("-H \"").append(s1).append(":").append(s2).append("\" ").toString());
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bmo.a("Auth failure.", ((Throwable) (obj)));
            return "Received exception while trying to get logs.";
        }
        String s = String.valueOf(a());
        ((StringBuilder) (obj)).append((new StringBuilder(String.valueOf(s).length() + 2)).append("'").append(s).append("'").toString());
        obj = ((StringBuilder) (obj)).toString();
        return ((String) (obj));
    }
}
