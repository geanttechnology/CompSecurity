// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.LimitedCache;

// Referenced classes of package org.simpleframework.xml.core:
//            ClassType, PathParser, Expression

class ExpressionBuilder
{

    private final Cache cache;
    private final Format format;
    private final Type type;

    public ExpressionBuilder(Class class1, Format format1)
    {
        this(((Type) (new ClassType(class1))), format1);
    }

    public ExpressionBuilder(Type type1, Format format1)
    {
        cache = new LimitedCache();
        format = format1;
        type = type1;
    }

    private Expression create(String s)
        throws Exception
    {
        PathParser pathparser = new PathParser(s, type, format);
        if (cache != null)
        {
            cache.cache(s, pathparser);
        }
        return pathparser;
    }

    public Expression build(String s)
        throws Exception
    {
        Expression expression1 = (Expression)cache.fetch(s);
        Expression expression = expression1;
        if (expression1 == null)
        {
            expression = create(s);
        }
        return expression;
    }
}
