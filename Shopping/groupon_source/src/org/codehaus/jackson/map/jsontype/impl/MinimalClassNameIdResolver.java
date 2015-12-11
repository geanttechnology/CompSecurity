// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.jsontype.impl;

import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;

// Referenced classes of package org.codehaus.jackson.map.jsontype.impl:
//            ClassNameIdResolver

public class MinimalClassNameIdResolver extends ClassNameIdResolver
{

    protected final String _basePackageName;
    protected final String _basePackagePrefix;

    protected MinimalClassNameIdResolver(JavaType javatype, TypeFactory typefactory)
    {
        super(javatype, typefactory);
        javatype = javatype.getRawClass().getName();
        int i = javatype.lastIndexOf('.');
        if (i < 0)
        {
            _basePackageName = "";
            _basePackagePrefix = ".";
            return;
        } else
        {
            _basePackagePrefix = javatype.substring(0, i + 1);
            _basePackageName = javatype.substring(0, i);
            return;
        }
    }

    public String idFromValue(Object obj)
    {
        String s = obj.getClass().getName();
        obj = s;
        if (s.startsWith(_basePackagePrefix))
        {
            obj = s.substring(_basePackagePrefix.length() - 1);
        }
        return ((String) (obj));
    }

    public JavaType typeFromId(String s)
    {
        Object obj = s;
        if (s.startsWith("."))
        {
            obj = new StringBuilder(s.length() + _basePackageName.length());
            if (_basePackageName.length() == 0)
            {
                ((StringBuilder) (obj)).append(s.substring(1));
            } else
            {
                ((StringBuilder) (obj)).append(_basePackageName).append(s);
            }
            obj = ((StringBuilder) (obj)).toString();
        }
        return super.typeFromId(((String) (obj)));
    }
}
