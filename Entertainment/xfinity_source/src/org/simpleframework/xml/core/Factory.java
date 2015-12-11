// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Modifier;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Context, Support, OverrideType, OverrideValue, 
//            InstantiationException

abstract class Factory
{

    protected Context context;
    protected Class override;
    protected Support support;
    protected Type type;

    protected Factory(Context context1, Type type1)
    {
        this(context1, type1, null);
    }

    protected Factory(Context context1, Type type1, Class class1)
    {
        support = context1.getSupport();
        override = class1;
        context = context1;
        type = type1;
    }

    private Type getPrimitive(Type type1, Class class1)
        throws Exception
    {
        Object obj = support;
        Class class2 = Support.getPrimitive(class1);
        obj = type1;
        if (class2 != class1)
        {
            obj = new OverrideType(type1, class2);
        }
        return ((Type) (obj));
    }

    public static boolean isCompatible(Class class1, Class class2)
    {
        Class class3 = class1;
        if (class1.isArray())
        {
            class3 = class1.getComponentType();
        }
        return class3.isAssignableFrom(class2);
    }

    public static boolean isInstantiable(Class class1)
    {
        for (int i = class1.getModifiers(); Modifier.isAbstract(i) || Modifier.isInterface(i);)
        {
            return false;
        }

        return true;
    }

    public Value getConversion(InputNode inputnode)
        throws Exception
    {
        Value value = context.getOverride(type, inputnode);
        inputnode = value;
        if (value != null)
        {
            inputnode = value;
            if (override != null)
            {
                Class class1 = value.getType();
                inputnode = value;
                if (!isCompatible(override, class1))
                {
                    inputnode = new OverrideValue(value, override);
                }
            }
        }
        return inputnode;
    }

    public Object getInstance()
        throws Exception
    {
        Class class1 = getType();
        if (!isInstantiable(class1))
        {
            throw new InstantiationException("Type %s can not be instantiated", new Object[] {
                class1
            });
        } else
        {
            return class1.newInstance();
        }
    }

    protected Value getOverride(InputNode inputnode)
        throws Exception
    {
        Value value = getConversion(inputnode);
        if (value != null)
        {
            inputnode = inputnode.getPosition();
            Class class1 = value.getType();
            if (!isCompatible(getType(), class1))
            {
                throw new InstantiationException("Incompatible %s for %s at %s", new Object[] {
                    class1, type, inputnode
                });
            }
        }
        return value;
    }

    public Class getType()
    {
        if (override != null)
        {
            return override;
        } else
        {
            return type.getType();
        }
    }

    public boolean setOverride(Type type1, Object obj, OutputNode outputnode)
        throws Exception
    {
        Class class1 = type1.getType();
        Type type2 = type1;
        if (class1.isPrimitive())
        {
            type2 = getPrimitive(type1, class1);
        }
        return context.setOverride(type2, obj, outputnode);
    }
}
