// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map;

import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;

public abstract class BeanPropertyDefinition
{

    public BeanPropertyDefinition()
    {
    }

    public boolean couldDeserialize()
    {
        return getMutator() != null;
    }

    public abstract AnnotatedMember getAccessor();

    public abstract AnnotatedField getField();

    public abstract AnnotatedMethod getGetter();

    public abstract AnnotatedMember getMutator();

    public abstract String getName();

    public abstract AnnotatedMethod getSetter();

    public abstract boolean hasField();

    public abstract boolean hasGetter();

    public abstract boolean hasSetter();
}
