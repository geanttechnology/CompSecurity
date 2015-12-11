// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.damnhandy.uri.template;

import com.damnhandy.uri.template.impl.VariableExpansionException;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.damnhandy.uri.template:
//            VarExploder, UriTransient, VarName

public class DefaultVarExploder
    implements VarExploder
{

    private Map pairs;
    private Object source;

    public DefaultVarExploder(Object obj)
    {
        pairs = new LinkedHashMap();
        setSource(obj);
    }

    private Object getValue(Method method)
    {
        if (method == null)
        {
            return null;
        }
        try
        {
            method = ((Method) (method.invoke(source, new Object[0])));
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            throw new VariableExpansionException(method);
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            throw new VariableExpansionException(method);
        }
        // Misplaced declaration of an exception variable
        catch (Method method)
        {
            throw new VariableExpansionException(method);
        }
        return method;
    }

    private void initValues()
    {
        Class class1 = source.getClass();
        if (class1.isAnnotation() || class1.isArray() || class1.isEnum() || class1.isPrimitive())
        {
            throw new IllegalArgumentException("The value must an object");
        }
        BeanInfo beaninfo;
        PropertyDescriptor apropertydescriptor[];
        int j;
        try
        {
            beaninfo = Introspector.getBeanInfo(class1);
        }
        catch (IntrospectionException introspectionexception)
        {
            throw new VariableExpansionException(introspectionexception);
        }
        apropertydescriptor = beaninfo.getPropertyDescriptors();
        j = apropertydescriptor.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = apropertydescriptor[i];
            Method method = ((PropertyDescriptor) (obj)).getReadMethod();
            if (method.isAnnotationPresent(com/damnhandy/uri/template/UriTransient) || ((PropertyDescriptor) (obj)).getName().equals("class"))
            {
                continue;
            }
            Object obj1 = getValue(method);
            obj = ((PropertyDescriptor) (obj)).getName();
            if (method.isAnnotationPresent(com/damnhandy/uri/template/VarName))
            {
                obj = ((VarName)method.getAnnotation(com/damnhandy/uri/template/VarName)).value();
            }
            if (obj1 != null)
            {
                pairs.put(obj, obj1);
            }
        }

        scanFields(class1);
    }

    private void scanFields(Class class1)
    {
        if (!class1.isInterface())
        {
            Field afield[] = class1.getDeclaredFields();
            int j = afield.length;
            int i = 0;
            while (i < j) 
            {
                Object obj = afield[i];
                String s = ((Field) (obj)).getName();
                if (pairs.containsKey(s))
                {
                    if (((Field) (obj)).isAnnotationPresent(com/damnhandy/uri/template/UriTransient))
                    {
                        pairs.remove(s);
                    } else
                    if (((Field) (obj)).isAnnotationPresent(com/damnhandy/uri/template/VarName))
                    {
                        obj = ((VarName)((Field) (obj)).getAnnotation(com/damnhandy/uri/template/VarName)).value();
                        pairs.put(obj, pairs.get(s));
                        pairs.remove(s);
                    }
                }
                i++;
            }
        }
        if (!class1.getSuperclass().equals(java/lang/Object))
        {
            scanFields(class1.getSuperclass());
        }
    }

    public Map getNameValuePairs()
    {
        return pairs;
    }

    public Collection getValues()
    {
        return pairs.values();
    }

    public void setSource(Object obj)
    {
        source = obj;
        initValues();
    }
}
