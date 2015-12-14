// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class cfh
{

    private Map a;

    public cfh()
    {
        a = new TreeMap();
    }

    public void a()
    {
        a.clear();
    }

    public String b()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = a.entrySet().iterator();
        boolean flag = true;
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (flag)
            {
                flag = false;
                stringbuilder.append('?');
            } else
            {
                stringbuilder.append('&');
            }
            stringbuilder.append((String)entry.getKey());
            stringbuilder.append('=');
            stringbuilder.append(URLEncoder.encode((String)entry.getValue()));
        }
        return stringbuilder.toString();
    }
}
