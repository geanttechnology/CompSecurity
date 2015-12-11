// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.d;

import com.gimbal.internal.c.c;
import com.gimbal.proguard.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gimbal.internal.d:
//            c, f, i

public class g extends com.gimbal.internal.d.c
{

    g()
    {
        this(false);
    }

    public g(boolean flag)
    {
        super(flag);
        com.gimbal.internal.c.c.f(com/gimbal/internal/d/g.getName());
        com.gimbal.internal.c.c.e(com/gimbal/internal/d/g.getName());
    }

    private JSONArray a(Collection collection)
    {
        JSONArray jsonarray;
        jsonarray = new JSONArray();
        collection = collection.iterator();
_L3:
        Object obj;
        if (!collection.hasNext())
        {
            break MISSING_BLOCK_LABEL_161;
        }
        obj = collection.next();
        if (!(obj instanceof String)) goto _L2; else goto _L1
_L1:
        jsonarray.put(obj.toString());
          goto _L3
_L2:
label0:
        {
            if (!(obj instanceof Double))
            {
                break label0;
            }
            jsonarray.put(((Double)obj).doubleValue());
        }
          goto _L3
label1:
        {
            if (!(obj instanceof Long))
            {
                break label1;
            }
            jsonarray.put(((Long)obj).longValue());
        }
          goto _L3
label2:
        {
            if (!(obj instanceof Integer))
            {
                break label2;
            }
            jsonarray.put(((Integer)obj).intValue());
        }
          goto _L3
label3:
        {
            if (!(obj instanceof Boolean))
            {
                break label3;
            }
            jsonarray.put(((Boolean)obj).booleanValue());
        }
          goto _L3
        try
        {
            jsonarray.put(b(obj));
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            throw new f(collection);
        }
          goto _L3
        return jsonarray;
    }

    private JSONArray a(Object aobj[])
    {
        JSONArray jsonarray;
        Object obj;
        int j;
        int k;
        try
        {
            jsonarray = new JSONArray();
            k = aobj.length;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new f(((Throwable) (aobj)));
        }
        j = 0;
_L2:
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        obj = aobj[j];
        if (obj instanceof String)
        {
            jsonarray.put(obj.toString());
            break MISSING_BLOCK_LABEL_159;
        }
        if (obj instanceof Double)
        {
            jsonarray.put(((Double)obj).doubleValue());
            break MISSING_BLOCK_LABEL_159;
        }
        if (obj instanceof Long)
        {
            jsonarray.put(((Long)obj).longValue());
            break MISSING_BLOCK_LABEL_159;
        }
        if (obj instanceof Integer)
        {
            jsonarray.put(((Integer)obj).intValue());
            break MISSING_BLOCK_LABEL_159;
        }
        if (obj instanceof Boolean)
        {
            jsonarray.put(((Boolean)obj).booleanValue());
            break MISSING_BLOCK_LABEL_159;
        }
        jsonarray.put(b(obj));
        break MISSING_BLOCK_LABEL_159;
        return jsonarray;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private JSONObject a(Map map)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        map = map.entrySet().iterator();
_L3:
        java.util.Map.Entry entry;
        String s;
        if (!map.hasNext())
        {
            break MISSING_BLOCK_LABEL_247;
        }
        entry = (java.util.Map.Entry)map.next();
        s = entry.getKey().toString();
        if (!(entry.getValue() instanceof String)) goto _L2; else goto _L1
_L1:
        jsonobject.put(s, entry.getValue().toString());
          goto _L3
_L2:
label0:
        {
            if (!(entry.getValue() instanceof Double))
            {
                break label0;
            }
            jsonobject.put(s, ((Double)entry.getValue()).doubleValue());
        }
          goto _L3
label1:
        {
            if (!(entry.getValue() instanceof Long))
            {
                break label1;
            }
            jsonobject.put(s, ((Long)entry.getValue()).longValue());
        }
          goto _L3
label2:
        {
            if (!(entry.getValue() instanceof Integer))
            {
                break label2;
            }
            jsonobject.put(s, ((Integer)entry.getValue()).intValue());
        }
          goto _L3
label3:
        {
            if (!(entry.getValue() instanceof Boolean))
            {
                break label3;
            }
            jsonobject.put(s, ((Boolean)entry.getValue()).booleanValue());
        }
          goto _L3
        try
        {
            jsonobject.put(s, b(entry.getValue()));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new f(map);
        }
          goto _L3
        return jsonobject;
    }

    private Object c(Object obj)
    {
        if (super.c)
        {
            com.gimbal.proguard.a.a(obj);
        }
        JSONObject jsonobject;
        Class class1;
        Iterator iterator;
        jsonobject = new JSONObject();
        a.get(obj.getClass());
        class1 = obj.getClass();
        iterator = b(class1).iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Method method = (Method)iterator.next();
        if (method.getParameterTypes().length != 0 || method.getName().equals("getClass")) goto _L4; else goto _L3
_L3:
        Object obj1 = method.getName();
        if (((String) (obj1)).length() <= 3 || !((String) (obj1)).startsWith("get") || !Character.isUpperCase(((String) (obj1)).charAt(3))) goto _L6; else goto _L5
_L5:
        obj1 = method.getName().substring(3);
_L13:
        if (obj1 == null) goto _L8; else goto _L7
_L7:
        String s;
        String s1;
        try
        {
            s1 = (new StringBuilder()).append(Character.toLowerCase(((String) (obj1)).charAt(0))).append(((String) (obj1)).substring(1)).toString();
            obj1 = (i)b.get(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new f(((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new f(((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new f(((Throwable) (obj)));
        }
        if (obj1 == null) goto _L10; else goto _L9
_L9:
        obj1 = ((i) (obj1)).a(s1);
        if (obj1 == null) goto _L10; else goto _L11
_L11:
        if (obj1 == null) goto _L4; else goto _L12
_L12:
        a(class1);
        method.setAccessible(true);
        jsonobject.put(((String) (obj1)), b(method.invoke(obj, new Object[0])));
          goto _L4
_L6:
        if (((String) (obj1)).length() <= 2 || !((String) (obj1)).startsWith("is") || !Character.isUpperCase(((String) (obj1)).charAt(2)))
        {
            break MISSING_BLOCK_LABEL_364;
        }
        obj1 = method.getName().substring(2);
          goto _L13
_L10:
        obj1 = (i)b.get(java/lang/Void);
        if (obj1 == null) goto _L15; else goto _L14
_L14:
        s = ((i) (obj1)).a(s1);
        obj1 = s;
        if (s != null) goto _L11; else goto _L15
_L15:
        obj1 = s1;
          goto _L11
_L8:
        obj1 = null;
          goto _L11
_L2:
        return jsonobject;
        obj1 = null;
          goto _L13
    }

    public final Object b(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        Object obj1 = null;
_L4:
        return obj1;
_L2:
        if (!(obj instanceof String))
        {
            break MISSING_BLOCK_LABEL_22;
        }
        obj = obj.toString();
        return obj;
        obj1 = obj;
        if (obj instanceof Number) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        if (obj instanceof Boolean) goto _L4; else goto _L5
_L5:
        try
        {
            if (obj.getClass().isEnum())
            {
                return a(obj);
            }
            if (!obj.getClass().isArray())
            {
                break MISSING_BLOCK_LABEL_108;
            }
            if (obj.getClass().getComponentType().isPrimitive())
            {
                throw new f("Can't handle arrays of primitives yet");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new f(((Throwable) (obj)));
        }
        return a((Object[])obj);
        if (obj instanceof Collection)
        {
            return a((Collection)obj);
        }
        if (obj instanceof Map)
        {
            return a((Map)obj);
        }
        obj = c(obj);
        return obj;
    }
}
