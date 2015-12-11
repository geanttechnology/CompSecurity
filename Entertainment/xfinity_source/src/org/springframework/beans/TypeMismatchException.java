// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.beans;

import org.springframework.util.ClassUtils;

// Referenced classes of package org.springframework.beans:
//            PropertyAccessException

public class TypeMismatchException extends PropertyAccessException
{

    private Class requiredType;
    private transient Object value;

    public TypeMismatchException(Object obj, Class class1)
    {
        this(obj, class1, null);
    }

    public TypeMismatchException(Object obj, Class class1, Throwable throwable)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("Failed to convert value of type '").append(ClassUtils.getDescriptiveType(obj)).append("'");
        String s;
        if (class1 != null)
        {
            s = (new StringBuilder()).append(" to required type '").append(ClassUtils.getQualifiedName(class1)).append("'").toString();
        } else
        {
            s = "";
        }
        super(stringbuilder.append(s).toString(), throwable);
        value = obj;
        requiredType = class1;
    }
}
