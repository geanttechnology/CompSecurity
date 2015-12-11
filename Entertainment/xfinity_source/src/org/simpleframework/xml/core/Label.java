// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;

// Referenced classes of package org.simpleframework.xml.core:
//            Contact, Context, Converter, Decorator, 
//            Expression

interface Label
{

    public abstract Annotation getAnnotation();

    public abstract Contact getContact();

    public abstract Converter getConverter(Context context)
        throws Exception;

    public abstract Decorator getDecorator()
        throws Exception;

    public abstract Type getDependent()
        throws Exception;

    public abstract Object getEmpty(Context context)
        throws Exception;

    public abstract String getEntry()
        throws Exception;

    public abstract Expression getExpression()
        throws Exception;

    public abstract Object getKey()
        throws Exception;

    public abstract Label getLabel(Class class1)
        throws Exception;

    public abstract String getName()
        throws Exception;

    public abstract String[] getNames()
        throws Exception;

    public abstract String getOverride();

    public abstract String getPath()
        throws Exception;

    public abstract String[] getPaths()
        throws Exception;

    public abstract Class getType();

    public abstract Type getType(Class class1)
        throws Exception;

    public abstract boolean isAttribute();

    public abstract boolean isCollection();

    public abstract boolean isData();

    public abstract boolean isInline();

    public abstract boolean isRequired();

    public abstract boolean isText();

    public abstract boolean isUnion();

    public abstract String toString();
}
