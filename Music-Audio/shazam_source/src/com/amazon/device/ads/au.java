// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            cm, be, co, cn, 
//            bm, bn, cd, bo

class au
{

    protected static au d = new au(cm.a(), new be());
    private static final String e = com/amazon/device/ads/au.getSimpleName();
    protected final Object a = new Object();
    protected final Set b = Collections.synchronizedSet(new HashSet());
    protected final Set c = Collections.synchronizedSet(new HashSet());
    private final bm f;
    private bo g;
    private bn h;
    private final cm i;
    private final cn j;

    private au(cm cm1, bm bm1)
    {
        new co();
        j = co.a(e);
        i = cm1;
        f = bm1;
    }

    public static au a()
    {
        return d;
    }

    public final JSONArray b()
    {
        if (h != null) goto _L2; else goto _L1
_L1:
        java.io.File file = i.i;
        if (file != null) goto _L4; else goto _L3
_L3:
        j.d("No files directory has been set.", null);
_L8:
        boolean flag = false;
_L6:
        if (!flag)
        {
            j.d("Error creating file input handler.", null);
            return null;
        }
        break; /* Loop/switch isn't completed */
_L4:
        h = f.a(file, "AppEventsJsonFile");
_L2:
        if (h == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L8; else goto _L7
_L7:
        synchronized (a)
        {
            if (h.b())
            {
                break MISSING_BLOCK_LABEL_104;
            }
        }
        return null;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (h.f())
        {
            break MISSING_BLOCK_LABEL_128;
        }
        j.d("App Events File could not be opened.", null);
        obj;
        JVM INSTR monitorexit ;
        return null;
        JSONArray jsonarray = new JSONArray();
_L9:
        Object obj1 = h.h();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        obj1 = cd.a(((String) (obj1)));
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        c();
        h.close();
        obj;
        JVM INSTR monitorexit ;
        return null;
        jsonarray.put(obj1);
        c.add(((JSONObject) (obj1)).toString());
          goto _L9
        h.close();
        if (jsonarray.length() > 0)
        {
            return jsonarray;
        }
        obj;
        JVM INSTR monitorexit ;
        return null;
    }

    public final void c()
    {
        if (g != null) goto _L2; else goto _L1
_L1:
        Object obj = i.i;
        if (obj != null) goto _L4; else goto _L3
_L3:
        j.d("No files directory has been set.", null);
_L8:
        boolean flag = false;
_L6:
        if (!flag)
        {
            j.d("Error creating file output handler.", null);
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        g = f.b(((java.io.File) (obj)), "AppEventsJsonFile");
_L2:
        if (g == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L8; else goto _L7
_L7:
        obj = a;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        b.removeAll(c);
        if (b.isEmpty())
        {
            break MISSING_BLOCK_LABEL_262;
        }
        obj1 = new StringBuilder();
        Set set = b;
        set;
        JVM INSTR monitorenter ;
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((StringBuilder) (obj1)).append((String)iterator.next()).append("\n")) { }
        break MISSING_BLOCK_LABEL_179;
        obj1;
        set;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        set;
        JVM INSTR monitorexit ;
        boolean flag1 = g.a(bo.a.a);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        bo bo1 = g;
        obj1 = ((StringBuilder) (obj1)).toString();
        bo1.f();
        bo1.c.write(((String) (obj1)));
        b.clear();
        c.clear();
_L9:
        g.close();
_L10:
        obj;
        JVM INSTR monitorexit ;
        return;
        IOException ioexception;
        ioexception;
        j.c("Couldn't write the application event(s) to the file.", null);
          goto _L9
        i.b().deleteFile("AppEventsJsonFile");
        c.clear();
          goto _L10
    }

}
