// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.template;

import com.twinprime.msgpack.MessagePackable;
import com.twinprime.msgpack.MessageTypeException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.twinprime.msgpack.template:
//            Template, GenericTemplate, IntegerTemplate, LongTemplate, 
//            StringTemplate, ShortTemplate, DoubleTemplate, AnyTemplate, 
//            MessagePackableTemplate, MapTemplate

public class TemplateRegistry
{

    Map cache;
    private Map genericCache;
    private TemplateRegistry parent;

    private TemplateRegistry()
    {
        parent = null;
        parent = null;
        genericCache = new HashMap();
        cache = new HashMap();
        registerTemplates();
        cache = Collections.unmodifiableMap(cache);
    }

    public TemplateRegistry(TemplateRegistry templateregistry)
    {
        parent = null;
        if (templateregistry != null)
        {
            parent = templateregistry;
        } else
        {
            parent = new TemplateRegistry();
        }
        cache = new HashMap();
        genericCache = new HashMap();
        registerTemplatesWhichRefersRegistry();
    }

    private Template lookupCache(Type type)
    {
        Template template = (Template)cache.get(type);
        if (template != null)
        {
            return template;
        }
        try
        {
            type = parent.lookupCache(type);
        }
        // Misplaced declaration of an exception variable
        catch (Type type)
        {
            type = template;
        }
        return type;
    }

    private Template lookupGenericInterfaceTypes(ParameterizedType parameterizedtype)
    {
        Template template;
        Template template1;
        Object obj;
        Type type;
        type = parameterizedtype.getRawType();
        obj = null;
        template1 = null;
        template = obj;
        Class aclass[] = ((Class)type).getInterfaces();
        template = obj;
        int j = aclass.length;
        int i;
        i = 0;
        template = template1;
_L2:
        template1 = template;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        template1 = lookupGenericTypeImpl0(parameterizedtype, aclass[i]);
        template = template1;
        if (template != null)
        {
            return template;
        }
        i++;
        if (true) goto _L2; else goto _L1
        parameterizedtype;
        template1 = template;
_L1:
        return template1;
    }

    private Template lookupGenericSuperclasses(ParameterizedType parameterizedtype)
    {
        Template template;
        Object obj;
        Template template1;
        obj = parameterizedtype.getRawType();
        template = null;
        template1 = null;
        Class class1 = ((Class)obj).getSuperclass();
        obj = class1;
        template = template1;
        if (class1 == null)
        {
            return null;
        }
          goto _L1
_L3:
        template = template1;
        obj = ((Class) (obj)).getSuperclass();
        template = template1;
_L1:
        template1 = template;
        if (obj == java/lang/Object)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        template1 = lookupGenericTypeImpl0(parameterizedtype, ((Type) (obj)));
        if (template1 == null) goto _L3; else goto _L2
_L2:
        template = template1;
        register(parameterizedtype, template1);
        return template1;
        parameterizedtype;
        template1 = template;
        return template1;
    }

    private Template lookupGenericType(ParameterizedType parameterizedtype)
    {
        Template template = lookupGenericTypeImpl(parameterizedtype);
        if (template != null)
        {
            return template;
        }
        try
        {
            template = parent.lookupGenericTypeImpl(parameterizedtype);
        }
        catch (NullPointerException nullpointerexception)
        {
            Template template1 = lookupGenericInterfaceTypes(parameterizedtype);
            if (template1 != null)
            {
                return template1;
            }
            parameterizedtype = lookupGenericSuperclasses(parameterizedtype);
            if (parameterizedtype != null)
            {
                return parameterizedtype;
            } else
            {
                return null;
            }
        }
label0:
        {
            if (template != null)
            {
                return template;
            }
            break label0;
        }
    }

    private Template lookupGenericTypeImpl(ParameterizedType parameterizedtype)
    {
        return lookupGenericTypeImpl0(parameterizedtype, parameterizedtype.getRawType());
    }

    private Template lookupGenericTypeImpl0(ParameterizedType parameterizedtype, Type type)
    {
        type = (GenericTemplate)genericCache.get(type);
        if (type == null)
        {
            return null;
        }
        parameterizedtype = parameterizedtype.getActualTypeArguments();
        Template atemplate[] = new Template[parameterizedtype.length];
        for (int i = 0; i < parameterizedtype.length; i++)
        {
            atemplate[i] = lookup(parameterizedtype[i]);
        }

        return type.build(atemplate);
    }

    private Template lookupInterfaceTypes(Class class1)
    {
        Template template;
        Class aclass[];
        int i;
        int j;
        aclass = class1.getInterfaces();
        template = null;
        j = aclass.length;
        i = 0;
_L3:
        if (i >= j) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = aclass[i];
        template = (Template)cache.get(obj);
        if (template != null)
        {
            register(class1, template);
            return template;
        }
        obj = parent.lookupCache(((Type) (obj)));
        template = ((Template) (obj));
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        template = ((Template) (obj));
        register(class1, ((Template) (obj)));
        return ((Template) (obj));
        NullPointerException nullpointerexception;
        nullpointerexception;
        i++;
          goto _L3
_L2:
        return template;
    }

    private Template lookupSuperclassInterfaceTypes(Class class1)
    {
        Template template;
        Class class2;
        class2 = class1.getSuperclass();
        template = null;
        Object obj = null;
        if (class2 == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        template = obj;
_L3:
        if (class2 == java/lang/Object) goto _L2; else goto _L1
_L1:
        template = lookupInterfaceTypes(class2);
        if (template != null)
        {
            register(class1, template);
            return template;
        }
        Template template1 = parent.lookupCache(class2);
        template = template1;
        if (template1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        template = template1;
        register(class1, template1);
        return template1;
        NullPointerException nullpointerexception;
        nullpointerexception;
        class2 = class2.getSuperclass();
          goto _L3
_L2:
        return template;
    }

    private Template lookupSuperclasses(Class class1)
    {
        Template template;
        Class class2;
        class2 = class1.getSuperclass();
        template = null;
        Object obj = null;
        if (class2 == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        template = obj;
_L3:
        if (class2 == java/lang/Object) goto _L2; else goto _L1
_L1:
        template = (Template)cache.get(class2);
        if (template != null)
        {
            register(class1, template);
            return template;
        }
        Template template1 = parent.lookupCache(class2);
        template = template1;
        if (template1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        template = template1;
        register(class1, template1);
        return template1;
        NullPointerException nullpointerexception;
        nullpointerexception;
        class2 = class2.getSuperclass();
          goto _L3
_L2:
        return template;
    }

    private void registerTemplates()
    {
        register(Integer.TYPE, IntegerTemplate.getInstance());
        register(java/lang/Integer, IntegerTemplate.getInstance());
        register(Long.TYPE, LongTemplate.getInstance());
        register(java/lang/Long, LongTemplate.getInstance());
        register(java/lang/String, StringTemplate.getInstance());
        register(java/lang/Short, ShortTemplate.getInstance());
        register(java/lang/Double, DoubleTemplate.getInstance());
        registerTemplatesWhichRefersRegistry();
    }

    public Template lookup(Type type)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = type;
        if (!(type instanceof ParameterizedType)) goto _L2; else goto _L1
_L1:
        obj = (ParameterizedType)type;
        type = lookupGenericType(((ParameterizedType) (obj)));
        if (type == null) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return type;
_L4:
        obj = ((ParameterizedType) (obj)).getRawType();
_L2:
        type = lookupCache(((Type) (obj)));
        if (type == null) goto _L5; else goto _L3
_L5:
label0:
        {
            if (!(obj instanceof WildcardType) && !(obj instanceof TypeVariable))
            {
                break label0;
            }
            type = new AnyTemplate(this);
            register(((Type) (obj)), type);
        }
          goto _L3
        Class class1;
label1:
        {
            class1 = (Class)obj;
            if (!com/twinprime/msgpack/MessagePackable.isAssignableFrom(class1))
            {
                break label1;
            }
            type = new MessagePackableTemplate(class1);
            register(class1, type);
        }
          goto _L3
label2:
        {
            if (!class1.isInterface())
            {
                break label2;
            }
            type = new AnyTemplate(this);
            register(((Type) (obj)), type);
        }
          goto _L3
        type = lookupInterfaceTypes(class1);
        if (type == null) goto _L6; else goto _L3
_L6:
        type = lookupSuperclasses(class1);
        if (type == null) goto _L7; else goto _L3
_L7:
        type = lookupSuperclassInterfaceTypes(class1);
        if (type == null) goto _L8; else goto _L3
_L8:
        throw new MessageTypeException((new StringBuilder()).append("Cannot find template for ").append(class1).append(" class.  ").append("Try to add @Message annotation to the class or call MessagePack.register(Type).").toString());
        type;
        this;
        JVM INSTR monitorexit ;
        throw type;
    }

    public void register(Type type, Template template)
    {
        this;
        JVM INSTR monitorenter ;
        if (template != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new NullPointerException("Template object is null");
        type;
        this;
        JVM INSTR monitorexit ;
        throw type;
        if (!(type instanceof ParameterizedType))
        {
            break MISSING_BLOCK_LABEL_51;
        }
        cache.put(((ParameterizedType)type).getRawType(), template);
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        cache.put(type, template);
          goto _L1
    }

    protected void registerTemplatesWhichRefersRegistry()
    {
        AnyTemplate anytemplate = new AnyTemplate(this);
        register(java/util/Map, new MapTemplate(anytemplate, anytemplate));
    }
}
