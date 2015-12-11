// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.tagmanager.protobuf:
//            GeneratedMessageLite, MessageLite

public static class enumValueOf
{

    final MessageLite containingTypeDefaultInstance;
    final Object defaultValue;
    final  descriptor;
    final Method enumValueOf;
    final MessageLite messageDefaultInstance;
    final Class singularType;

    Object fromFieldSetType(Object obj)
    {
        if (descriptor.isRepeated())
        {
            if (descriptor.getLiteJavaType() == .getLiteJavaType)
            {
                ArrayList arraylist = new ArrayList();
                Iterator iterator = ((List)obj).iterator();
                do
                {
                    obj = arraylist;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    arraylist.add(singularFromFieldSetType(iterator.next()));
                } while (true);
            }
            return obj;
        } else
        {
            return singularFromFieldSetType(obj);
        }
    }

    public MessageLite getContainingTypeDefaultInstance()
    {
        return containingTypeDefaultInstance;
    }

    public MessageLite getMessageDefaultInstance()
    {
        return messageDefaultInstance;
    }

    public int getNumber()
    {
        return descriptor.getNumber();
    }

    Object singularFromFieldSetType(Object obj)
    {
        Object obj1 = obj;
        if (descriptor.getLiteJavaType() == .getLiteJavaType)
        {
            obj1 = GeneratedMessageLite.invokeOrDie(enumValueOf, null, new Object[] {
                (Integer)obj
            });
        }
        return obj1;
    }

    Object singularToFieldSetType(Object obj)
    {
        Object obj1 = obj;
        if (descriptor.getLiteJavaType() == .getLiteJavaType)
        {
            obj1 = Integer.valueOf(((.getLiteJavaType)obj).getLiteJavaType());
        }
        return obj1;
    }

    Object toFieldSetType(Object obj)
    {
        if (descriptor.isRepeated())
        {
            if (descriptor.getLiteJavaType() == .getLiteJavaType)
            {
                ArrayList arraylist = new ArrayList();
                Iterator iterator = ((List)obj).iterator();
                do
                {
                    obj = arraylist;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    arraylist.add(singularToFieldSetType(iterator.next()));
                } while (true);
            }
            return obj;
        } else
        {
            return singularToFieldSetType(obj);
        }
    }

    (MessageLite messagelite, Object obj, MessageLite messagelite1,  , Class class1)
    {
        if (messagelite == null)
        {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (.getLiteType() == .getLiteType && messagelite1 == null)
        {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        containingTypeDefaultInstance = messagelite;
        defaultValue = obj;
        messageDefaultInstance = messagelite1;
        descriptor = ;
        singularType = class1;
        if (com/google/tagmanager/protobuf/Internal$EnumLite.isAssignableFrom(class1))
        {
            enumValueOf = GeneratedMessageLite.getMethodOrDie(class1, "valueOf", new Class[] {
                Integer.TYPE
            });
            return;
        } else
        {
            enumValueOf = null;
            return;
        }
    }
}
