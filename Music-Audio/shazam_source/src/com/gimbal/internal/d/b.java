// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.d;

import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.gimbal.internal.d:
//            e, g, i

public final class b
{

    private final e a;
    private final g b;

    public b()
    {
        this(true);
    }

    private b(boolean flag)
    {
        a = new e(flag);
        b = new g(flag);
    }

    public static String b(Object obj)
    {
        Object obj1;
        g g1;
        g1 = null;
        obj1 = null;
        if (obj == null)
        {
            return "null";
        }
        b b1;
        b1 = new b(false);
        if (!obj.getClass().isArray() && !(obj instanceof Set) && !(obj instanceof List))
        {
            break MISSING_BLOCK_LABEL_71;
        }
        g1 = b1.b;
        if (obj != null)
        {
            obj1 = (JSONArray)g1.b(obj);
        }
        return ((JSONArray) (obj1)).toString(4);
        try
        {
            obj1 = b1.b;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return (new StringBuilder("-- toString() Failed --  ")).append(obj.getClass().getName()).toString();
        }
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj1 = g1;
_L4:
        return ((JSONObject) (obj1)).toString(4);
_L2:
        obj1 = (JSONObject)((g) (obj1)).b(obj);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final Object a(Class class1, String s)
    {
        return a.a(class1, s);
    }

    public final String a(Object obj)
    {
        g g1 = b;
        if (obj == null)
        {
            return null;
        } else
        {
            return g1.b(obj).toString();
        }
    }

    public final transient void a(i i, Class aclass[])
    {
        a.a(i, aclass);
        b.a(i, aclass);
    }
}
