// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.app.Activity;
import android.view.View;
import com.j.a.d.e;
import com.j.a.d.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.j.a.g:
//            w, d

public class u
{

    private static Object a(View view, Method method)
        throws InvocationTargetException, IllegalAccessException
    {
        Object obj;
        try
        {
            obj = method.invoke(view, new Object[0]);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return a(view, method);
        }
        return obj;
    }

    private static String a(Class class1)
    {
        String s = null;
        if (i.a().b().containsKey(class1.getSimpleName()))
        {
            s = class1.getSimpleName();
        } else
        if (!class1.getSimpleName().equals("View"))
        {
            return a(class1.getSuperclass());
        }
        return s;
    }

    public static JSONObject a(Class class1, View view)
        throws JSONException
    {
        JSONArray jsonarray;
        JSONArray jsonarray1;
        HashSet hashset1;
        HashSet hashset2;
        Iterator iterator;
        jsonarray = new JSONArray();
        jsonarray1 = new JSONArray();
        HashSet hashset = new HashSet(Arrays.asList(class1.getMethods()));
        class1 = a(class1);
        hashset1 = (HashSet)i.a().b().get(class1);
        hashset2 = (HashSet)i.a().c().get(class1);
        iterator = hashset.iterator();
_L2:
        JSONObject jsonobject;
        String s;
        Object obj;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (Method)iterator.next();
        s = ((Method) (obj)).getName();
        JSONObject jsonobject1 = new JSONObject();
        JSONArray jsonarray2 = new JSONArray();
        if (hashset1.contains(s))
        {
            obj = ((Method) (obj)).getParameterTypes();
            int k = obj.length;
            for (int j = 0; j < k; j++)
            {
                Class class2 = obj[j];
                class1 = class2;
                if (class2.isArray())
                {
                    class1 = class2.getComponentType();
                }
                jsonarray2.put(class1.getName());
            }

            jsonobject1.put("paramTypes", jsonarray2);
            jsonobject1.put("methodName", s);
            jsonarray.put(jsonobject1);
            hashset1.remove(s);
            continue; /* Loop/switch isn't completed */
        }
        if (!hashset2.contains(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        jsonobject = new JSONObject();
        if (!b(((Method) (obj)).getReturnType()))
        {
            continue; /* Loop/switch isn't completed */
        }
        class1 = ((Class) (a(view, ((Method) (obj)))));
        jsonobject.put("methodName", ((Method) (obj)).getName());
        if (class1 == null)
        {
            class1 = "null";
        }
        try
        {
            jsonobject.put("currentValue", class1);
            jsonarray1.put(jsonobject);
            hashset2.remove(s);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Class class1) { }
        // Misplaced declaration of an exception variable
        catch (Class class1) { }
        w.b("something", class1);
        if (true) goto _L2; else goto _L1
_L1:
        class1 = new JSONObject();
        view = new JSONArray();
        class1.put("methodName", "setWidth");
        view.put(Integer.TYPE.getName());
        class1.put("paramTypes", view);
        jsonarray.put(class1);
        class1 = new JSONObject();
        view = new JSONArray();
        class1.put("methodName", "setHeight");
        view.put(Integer.TYPE.getName());
        class1.put("paramTypes", view);
        jsonarray.put(class1);
        class1 = new JSONObject();
        class1.put("variables", jsonarray1);
        class1.put("setters", jsonarray);
        return class1;
    }

    public static void a(View view, String s, Object obj, String s1)
    {
        if (e.e().p() != null)
        {
            e.e().p().runOnUiThread(new d(obj, s, view, s1));
        }
    }

    private static boolean b(Class class1)
    {
        return class1.equals(java/lang/Integer) || class1.equals(java/lang/Boolean) || class1.equals(java/lang/CharSequence) || class1.equals(java/lang/String) || class1.equals(Float.TYPE) || class1.equals(Integer.TYPE) || class1.equals(Long.TYPE) || class1.equals(Short.TYPE) || class1.equals(java/lang/Number) || class1.equals(java/lang/CharSequence) || class1.equals(Double.TYPE) || class1.equals(Boolean.TYPE) || class1.equals(Byte.TYPE) || class1.equals(java/lang/StringBuilder) || class1.equals(java/lang/StringBuffer) || class1.equals(java/lang/Float) || class1.equals(java/lang/Double) || class1.equals(java/lang/Long) || class1.equals(java/lang/Short) || class1.equals(java/lang/Byte);
    }
}
