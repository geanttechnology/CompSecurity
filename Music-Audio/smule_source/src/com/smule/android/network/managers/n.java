// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.c.aa;
import com.smule.android.f.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.smule.android.network.managers:
//            LocalizationManager

public class n
{

    private Map a;

    private n()
    {
        a = new HashMap();
    }

    public n(JsonNode jsonnode)
    {
        this();
        java.util.Map.Entry entry;
        String s;
        for (jsonnode = jsonnode.fields(); jsonnode.hasNext(); a(s.substring(0, s.indexOf('.')), s.substring(s.indexOf('.') + 1, s.lastIndexOf('.')), s.substring(s.lastIndexOf('.') + 1), ((JsonNode)entry.getValue()).textValue()))
        {
            entry = (java.util.Map.Entry)jsonnode.next();
            s = (String)entry.getKey();
        }

    }

    n(LocalizationManager._cls1 _pcls1)
    {
        this();
    }

    public String a()
    {
        Object obj = new HashMap();
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Iterator iterator1 = ((Map)entry.getValue()).entrySet().iterator();
            while (iterator1.hasNext()) 
            {
                java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
                Iterator iterator2 = ((Map)entry1.getValue()).entrySet().iterator();
                while (iterator2.hasNext()) 
                {
                    java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator2.next();
                    ((Map) (obj)).put((new StringBuilder()).append((String)entry.getKey()).append(".").append((String)entry1.getKey()).append(".").append((String)entry2.getKey()).toString(), entry2.getValue());
                }
            }
        }

        try
        {
            obj = e.a().writeValueAsString(obj);
        }
        catch (JsonProcessingException jsonprocessingexception)
        {
            aa.b(LocalizationManager.b(), "Failed to serialize config", jsonprocessingexception);
            return null;
        }
        return ((String) (obj));
    }

    public String a(String s, String s1, String s2)
    {
        s = (Map)a.get(s);
        if (s != null)
        {
            s = (Map)s.get(s1);
            if (s != null)
            {
                return (String)s.get(s2);
            }
        }
        return null;
    }

    public Map a(String s)
    {
        return (Map)a.get(s);
    }

    void a(String s, String s1, String s2, String s3)
    {
        if (!a.containsKey(s))
        {
            a.put(s, new HashMap());
        }
        s = (Map)a.get(s);
        if (!s.containsKey(s1))
        {
            s.put(s1, new HashMap());
        }
        ((Map)s.get(s1)).put(s2, s3);
    }
}
