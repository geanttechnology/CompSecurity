// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.model;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.model:
//            PropertyName, GraphObject, GraphObjectList, JsonUtil

final class graphObjectClass extends graphObjectClass
{

    private static final String CASTTOMAP_METHOD = "asMap";
    private static final String CAST_METHOD = "cast";
    private static final String CLEAR_METHOD = "clear";
    private static final String CONTAINSKEY_METHOD = "containsKey";
    private static final String CONTAINSVALUE_METHOD = "containsValue";
    private static final String ENTRYSET_METHOD = "entrySet";
    private static final String GETINNERJSONOBJECT_METHOD = "getInnerJSONObject";
    private static final String GETPROPERTY_METHOD = "getProperty";
    private static final String GET_METHOD = "get";
    private static final String ISEMPTY_METHOD = "isEmpty";
    private static final String KEYSET_METHOD = "keySet";
    private static final String PUTALL_METHOD = "putAll";
    private static final String PUT_METHOD = "put";
    private static final String REMOVEPROPERTY_METHOD = "removeProperty";
    private static final String REMOVE_METHOD = "remove";
    private static final String SETPROPERTY_METHOD = "setProperty";
    private static final String SIZE_METHOD = "size";
    private static final String VALUES_METHOD = "values";
    private final Class graphObjectClass;

    private final Object proxyGraphObjectGettersAndSetters(Method method, Object aobj[])
    {
        Object obj = method.getName();
        int i = method.getParameterTypes().length;
        PropertyName propertyname = (PropertyName)method.getAnnotation(com/facebook/model/PropertyName);
        if (propertyname != null)
        {
            obj = propertyname.value();
        } else
        {
            obj = oLowercaseWithUnderscores(((String) (obj)).substring(3));
        }
        if (i == 0)
        {
            aobj = ((Object []) (((JSONObject)state).opt(((String) (obj)))));
            obj = method.getReturnType();
            method = method.getGenericReturnType();
            Iterator iterator;
            if (method instanceof ParameterizedType)
            {
                method = (ParameterizedType)method;
            } else
            {
                method = null;
            }
            return ctedType(((Object) (aobj)), ((Class) (obj)), method);
        }
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        method = ((Method) (aobj[0]));
        if (!com/facebook/model/GraphObject.isAssignableFrom(method.getClass())) goto _L2; else goto _L1
_L1:
        method = ((GraphObject)method).getInnerJSONObject();
_L4:
        ((JSONObject)state).putOpt(((String) (obj)), method);
        return null;
_L2:
        if (!com/facebook/model/GraphObjectList.isAssignableFrom(method.getClass()))
        {
            break; /* Loop/switch isn't completed */
        }
        method = ((GraphObjectList)method).getInnerJSONArray();
        if (true) goto _L4; else goto _L3
_L3:
        if (java/lang/Iterable.isAssignableFrom(method.getClass()))
        {
            aobj = new JSONArray();
            iterator = ((Iterable)method).iterator();
            do
            {
                method = ((Method) (aobj));
                if (!iterator.hasNext())
                {
                    break;
                }
                method = ((Method) (iterator.next()));
                if (com/facebook/model/GraphObject.isAssignableFrom(method.getClass()))
                {
                    ((JSONArray) (aobj)).put(((GraphObject)method).getInnerJSONObject());
                } else
                {
                    ((JSONArray) (aobj)).put(method);
                }
            } while (true);
        }
        if (true) goto _L4; else goto _L5
_L5:
        return throwUnexpectedMethodSignature(method);
    }

    private final Object proxyGraphObjectMethods(Object obj, Method method, Object aobj[])
    {
        String s = method.getName();
        if (s.equals("cast"))
        {
            method = (Class)aobj[0];
            if (method != null && method.isAssignableFrom(graphObjectClass))
            {
                return obj;
            } else
            {
                return graphObjectClass(method, (JSONObject)state);
            }
        }
        if (s.equals("getInnerJSONObject"))
        {
            return ((state)Proxy.getInvocationHandler(obj)).state;
        }
        if (s.equals("asMap"))
        {
            return state((JSONObject)state);
        }
        if (s.equals("getProperty"))
        {
            return ((JSONObject)state).opt((String)aobj[0]);
        }
        if (s.equals("setProperty"))
        {
            return setJSONProperty(aobj);
        }
        if (s.equals("removeProperty"))
        {
            ((JSONObject)state).remove((String)aobj[0]);
            return null;
        } else
        {
            return throwUnexpectedMethodSignature(method);
        }
    }

    private final Object proxyMapMethods(Method method, Object aobj[])
    {
        String s = method.getName();
        if (s.equals("clear"))
        {
            JsonUtil.jsonObjectClear((JSONObject)state);
            return null;
        }
        if (s.equals("containsKey"))
        {
            return Boolean.valueOf(((JSONObject)state).has((String)aobj[0]));
        }
        if (s.equals("containsValue"))
        {
            return Boolean.valueOf(JsonUtil.jsonObjectContainsValue((JSONObject)state, aobj[0]));
        }
        if (s.equals("entrySet"))
        {
            return JsonUtil.jsonObjectEntrySet((JSONObject)state);
        }
        if (s.equals("get"))
        {
            return ((JSONObject)state).opt((String)aobj[0]);
        }
        if (s.equals("isEmpty"))
        {
            boolean flag;
            if (((JSONObject)state).length() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return Boolean.valueOf(flag);
        }
        if (s.equals("keySet"))
        {
            return JsonUtil.jsonObjectKeySet((JSONObject)state);
        }
        if (s.equals("put"))
        {
            return setJSONProperty(aobj);
        }
        if (s.equals("putAll"))
        {
            if (aobj[0] instanceof Map)
            {
                method = (Map)aobj[0];
            } else
            if (aobj[0] instanceof GraphObject)
            {
                method = ((GraphObject)aobj[0]).asMap();
            } else
            {
                method = null;
            }
            JsonUtil.jsonObjectPutAll((JSONObject)state, method);
            return null;
        }
        if (s.equals("remove"))
        {
            ((JSONObject)state).remove((String)aobj[0]);
            return null;
        }
        if (s.equals("size"))
        {
            return Integer.valueOf(((JSONObject)state).length());
        }
        if (s.equals("values"))
        {
            return JsonUtil.jsonObjectValues((JSONObject)state);
        } else
        {
            return throwUnexpectedMethodSignature(method);
        }
    }

    private Object setJSONProperty(Object aobj[])
    {
        String s = (String)aobj[0];
        aobj = ((Object []) (throwUnexpectedMethodSignature(aobj[1])));
        try
        {
            ((JSONObject)state).putOpt(s, ((Object) (aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new IllegalArgumentException(((Throwable) (aobj)));
        }
        return null;
    }

    public final Object invoke(Object obj, Method method, Object aobj[])
    {
        Class class1 = method.getDeclaringClass();
        if (class1 == java/lang/Object)
        {
            return proxyObjectMethods(obj, method, aobj);
        }
        if (class1 == java/util/Map)
        {
            return proxyMapMethods(method, aobj);
        }
        if (class1 == com/facebook/model/GraphObject)
        {
            return proxyGraphObjectMethods(obj, method, aobj);
        }
        if (com/facebook/model/GraphObject.isAssignableFrom(class1))
        {
            return proxyGraphObjectGettersAndSetters(method, aobj);
        } else
        {
            return throwUnexpectedMethodSignature(method);
        }
    }

    public final String toString()
    {
        return String.format("GraphObject{graphObjectClass=%s, state=%s}", new Object[] {
            graphObjectClass.getSimpleName(), state
        });
    }

    public (JSONObject jsonobject, Class class1)
    {
        super(jsonobject);
        graphObjectClass = class1;
    }
}
