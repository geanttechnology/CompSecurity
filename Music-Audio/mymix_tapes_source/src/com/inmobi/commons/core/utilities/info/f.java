// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities.info;

import com.inmobi.commons.core.utilities.Logger;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{

    private static final String a = com/inmobi/commons/core/utilities/info/f.getSimpleName();
    private static f b;
    private static Object c = new Object();
    private String d;
    private long e;
    private long f;
    private boolean g;

    private f()
    {
    }

    public static f a()
    {
        Object obj;
        obj = b;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        Object obj1 = c;
        obj1;
        JVM INSTR monitorenter ;
        f f1 = b;
        obj = f1;
        if (f1 != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        b = new f();
        obj = b;
        obj1;
        JVM INSTR monitorexit ;
        return ((f) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((f) (obj));
    }

    private void d()
    {
        d = null;
        e = 0L;
        f = 0L;
    }

    public void a(long l)
    {
        e = l;
    }

    public void a(String s)
    {
        d = s;
    }

    public void a(boolean flag)
    {
        g = flag;
        if (!g)
        {
            d();
        }
    }

    public JSONObject b()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("sid", d);
            jsonobject.put("s-ts", e);
            jsonobject.put("e-ts", f);
        }
        catch (JSONException jsonexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Problem converting session object to Json.", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public void b(long l)
    {
        f = l;
    }

    public HashMap c()
    {
        HashMap hashmap = new HashMap();
        if (g && d != null)
        {
            hashmap.put("u-s-id", d);
        }
        return hashmap;
    }

}
