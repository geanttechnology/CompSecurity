// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map;

import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedClass;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMethod;
import com.flurry.org.codehaus.jackson.map.introspect.VisibilityChecker;
import com.flurry.org.codehaus.jackson.map.type.TypeBindings;
import com.flurry.org.codehaus.jackson.map.util.Annotations;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BeanDescription
{

    protected final JavaType _type;

    protected BeanDescription(JavaType javatype)
    {
        _type = javatype;
    }

    public abstract TypeBindings bindingsForBeanType();

    public abstract AnnotatedMethod findAnyGetter();

    public abstract AnnotatedMethod findAnySetter();

    public abstract AnnotatedConstructor findDefaultConstructor();

    public abstract LinkedHashMap findDeserializableFields(VisibilityChecker visibilitychecker, Collection collection);

    public abstract LinkedHashMap findGetters(VisibilityChecker visibilitychecker, Collection collection);

    public abstract Map findInjectables();

    public abstract AnnotatedMethod findJsonValueMethod();

    public abstract List findProperties();

    public abstract Map findSerializableFields(VisibilityChecker visibilitychecker, Collection collection);

    public abstract LinkedHashMap findSetters(VisibilityChecker visibilitychecker);

    public Class getBeanClass()
    {
        return _type.getRawClass();
    }

    public abstract Annotations getClassAnnotations();

    public abstract AnnotatedClass getClassInfo();

    public abstract Set getIgnoredPropertyNames();

    public JavaType getType()
    {
        return _type;
    }

    public abstract boolean hasKnownClassAnnotations();

    public abstract JavaType resolveType(Type type);
}
