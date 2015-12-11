// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers.a;

import android.content.Context;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.a;
import com.smule.android.network.managers.n;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.smule.android.network.managers.a:
//            c

public class d
    implements c
{

    private static final String a = com/smule/android/network/managers/a/d.getName();
    private String b;
    private n c;

    public d()
    {
        b = (new StringBuilder()).append(com.smule.android.network.core.b.d().n()).append("-").append("settings").toString();
    }

    private void a(JsonNode jsonnode, Map map)
    {
        if (!jsonnode.isTextual()) goto _L2; else goto _L1
_L1:
        String s = jsonnode.textValue();
        if (map.containsKey(s))
        {
            map = (String)map.get(s);
            try
            {
                if (jsonnode instanceof TextNode)
                {
                    Field field = com/fasterxml/jackson/databind/node/TextNode.getDeclaredField("_value");
                    field.setAccessible(true);
                    field.set(jsonnode, map);
                }
            }
            catch (Exception exception)
            {
                aa.b(a, (new StringBuilder()).append("Failed to replace [").append(s).append("] with [").append(map).append("]").toString(), exception);
            }
            aa.a(a, (new StringBuilder()).append("Replaced [").append(jsonnode).append("]").toString());
        }
_L4:
        return;
_L2:
        if (!jsonnode.isArray())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonnode = jsonnode.iterator();
        while (jsonnode.hasNext()) 
        {
            a((JsonNode)jsonnode.next(), map);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (jsonnode.isContainerNode())
        {
            jsonnode = jsonnode.fields();
            while (jsonnode.hasNext()) 
            {
                a((JsonNode)((java.util.Map.Entry)jsonnode.next()).getValue(), map);
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private void b()
    {
        Map map;
        aa.a(a, (new StringBuilder()).append("Start localizing ").append(c).toString());
        map = c.a(b);
        if (map == null) goto _L2; else goto _L1
_L1:
        a a1 = com.smule.android.network.managers.a.a();
        a1;
        JVM INSTR monitorenter ;
        Iterator iterator = map.keySet().iterator();
_L4:
        Map map1;
        Object obj;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_188;
            }
            obj = (String)iterator.next();
            map1 = (Map)map.get(obj);
            obj = com.smule.android.network.managers.a.a().a((new StringBuilder()).append(com.smule.android.network.core.b.d().n()).append(".").append(((String) (obj))).toString());
        } while (obj == null);
        obj = ((Map) (obj)).values().iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            a((JsonNode)((Iterator) (obj)).next(), map1);
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        a1;
        JVM INSTR monitorexit ;
        throw exception;
        a1;
        JVM INSTR monitorexit ;
_L2:
        h.a().a("APP_SETTINGS_LOADED_EVENT", new Object[0]);
        return;
    }

    public Object a(Object obj)
    {
        throw new UnsupportedOperationException("SNPSettingsLocalizationProvider doesn't support this operation");
    }

    public String a()
    {
        return b;
    }

    public void a(Context context)
    {
    }

    public void a(n n1)
    {
        c = n1;
        com.smule.android.network.managers.a.a().b();
        com.smule.android.network.managers.a.a().d();
        b();
        com.smule.android.network.managers.a.a().b();
    }

}
