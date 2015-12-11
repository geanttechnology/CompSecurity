// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.msgpack.Template;
import org.msgpack.annotation.MessagePackDelegate;
import org.msgpack.annotation.MessagePackMessage;
import org.msgpack.annotation.MessagePackOrdinalEnum;

// Referenced classes of package org.msgpack.template:
//            BuiltInTemplateLoader, GenericTemplate, TemplateBuilder, DefaultTemplate

public class TemplateRegistry
{

    private static Map genericMap = new HashMap();
    private static Map map = new HashMap();

    private static boolean isAnnotated(Class class1, Class class2)
    {
        return class1.getAnnotation(class2) != null;
    }

    public static Template lookup(Type type)
    {
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorenter ;
        type = lookupImpl(type, false, true);
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorexit ;
        return type;
        type;
        throw type;
    }

    public static Template lookup(Type type, boolean flag)
    {
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorenter ;
        type = lookupImpl(type, flag, true);
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorexit ;
        return type;
        type;
        throw type;
    }

    private static Template lookupGenericImpl(ParameterizedType parameterizedtype)
    {
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorenter ;
        Object obj;
        obj = parameterizedtype.getRawType();
        obj = (GenericTemplate)genericMap.get(obj);
        if (obj != null) goto _L2; else goto _L1
_L1:
        parameterizedtype = null;
_L6:
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorexit ;
        return parameterizedtype;
_L2:
        Template atemplate[];
        parameterizedtype = parameterizedtype.getActualTypeArguments();
        atemplate = new Template[parameterizedtype.length];
        int i = 0;
_L4:
        if (i >= parameterizedtype.length)
        {
            break; /* Loop/switch isn't completed */
        }
        atemplate[i] = lookup(parameterizedtype[i]);
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        parameterizedtype = ((GenericTemplate) (obj)).build(atemplate);
        if (true) goto _L6; else goto _L5
_L5:
        parameterizedtype;
        throw parameterizedtype;
    }

    private static Template lookupImpl(Type type, boolean flag, boolean flag1)
    {
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorenter ;
        Object obj = type;
        if (!(type instanceof ParameterizedType)) goto _L2; else goto _L1
_L1:
        obj = lookupGenericImpl((ParameterizedType)type);
        if (obj == null) goto _L4; else goto _L3
_L3:
        type = ((Type) (obj));
_L8:
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorexit ;
        return type;
_L4:
        obj = ((ParameterizedType)type).getRawType();
_L2:
        type = (Template)map.get(obj);
        if (type != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof GenericArrayType)
        {
            type = TemplateBuilder.buildArray(((Type) (obj)));
            register(((Type) (obj)), type);
            continue; /* Loop/switch isn't completed */
        }
        Class class1;
        class1 = (Class)obj;
        if (class1.isArray())
        {
            type = TemplateBuilder.buildArray(class1);
            register(class1, type);
            continue; /* Loop/switch isn't completed */
        }
        if (isAnnotated(class1, org/msgpack/annotation/MessagePackMessage))
        {
            type = TemplateBuilder.build(class1);
            register(class1, type);
            continue; /* Loop/switch isn't completed */
        }
        if (isAnnotated(class1, org/msgpack/annotation/MessagePackDelegate))
        {
            throw new UnsupportedOperationException((new StringBuilder()).append("not supported yet. : ").append(class1.getName()).toString());
        }
        break MISSING_BLOCK_LABEL_182;
        type;
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorexit ;
        throw type;
        if (isAnnotated(class1, org/msgpack/annotation/MessagePackOrdinalEnum))
        {
            type = TemplateBuilder.buildOrdinalEnum(class1);
            register(class1, type);
            continue; /* Loop/switch isn't completed */
        }
        Class aclass[];
        int j;
        aclass = class1.getInterfaces();
        j = aclass.length;
        Template template;
        for (int i = 0; i >= j; i++)
        {
            break MISSING_BLOCK_LABEL_258;
        }

        type = aclass[i];
        type = (Template)map.get(type);
        if (type == null)
        {
            break MISSING_BLOCK_LABEL_357;
        }
        register(class1, type);
        continue; /* Loop/switch isn't completed */
        type = class1.getSuperclass();
        if (type == null)
        {
            break MISSING_BLOCK_LABEL_329;
        }
_L6:
        if (type == java/lang/Object)
        {
            break MISSING_BLOCK_LABEL_310;
        }
        template = (Template)map.get(type);
        if (template == null)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        register(class1, template);
        type = template;
        continue; /* Loop/switch isn't completed */
        type = type.getSuperclass();
        if (true) goto _L6; else goto _L5
_L5:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_329;
        }
        type = TemplateBuilder.build(class1);
        register(class1, type);
        continue; /* Loop/switch isn't completed */
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_352;
        }
        type = new DefaultTemplate(class1);
        register(class1, type);
        continue; /* Loop/switch isn't completed */
        type = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static void register(Type type, Template template)
    {
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorenter ;
        Type type1 = type;
        if (type instanceof ParameterizedType)
        {
            type1 = ((ParameterizedType)type).getRawType();
        }
        map.put(type1, template);
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorexit ;
        return;
        type;
        throw type;
    }

    public static void registerGeneric(Type type, GenericTemplate generictemplate)
    {
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorenter ;
        Type type1 = type;
        if (type instanceof ParameterizedType)
        {
            type1 = ((ParameterizedType)type).getRawType();
        }
        genericMap.put(type1, generictemplate);
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorexit ;
        return;
        type;
        throw type;
    }

    public static Template tryLookup(Type type)
    {
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorenter ;
        type = lookupImpl(type, false, false);
        org/msgpack/template/TemplateRegistry;
        JVM INSTR monitorexit ;
        return type;
        type;
        throw type;
    }

    static 
    {
        BuiltInTemplateLoader.load();
    }
}
