// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.b.f;

// Referenced classes of package org.simpleframework.xml.core:
//            af, ai, ak, an, 
//            be

interface bx
{

    public abstract Annotation getAnnotation();

    public abstract af getContact();

    public abstract ak getConverter(ai ai);

    public abstract an getDecorator();

    public abstract f getDependent();

    public abstract Object getEmpty(ai ai);

    public abstract String getEntry();

    public abstract be getExpression();

    public abstract Object getKey();

    public abstract bx getLabel(Class class1);

    public abstract String getName();

    public abstract String[] getNames();

    public abstract String getOverride();

    public abstract String getPath();

    public abstract String[] getPaths();

    public abstract Class getType();

    public abstract f getType(Class class1);

    public abstract boolean isAttribute();

    public abstract boolean isCollection();

    public abstract boolean isData();

    public abstract boolean isInline();

    public abstract boolean isRequired();

    public abstract boolean isText();

    public abstract boolean isTextList();

    public abstract boolean isUnion();

    public abstract String toString();
}
