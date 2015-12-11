// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map;

import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.type.JavaType;

// Referenced classes of package org.codehaus.jackson.map:
//            BeanProperty

public static class _contextAnnotations
    implements BeanProperty
{

    protected final Annotations _contextAnnotations;
    protected final AnnotatedMember _member;
    protected final String _name;
    protected final JavaType _type;

    public AnnotatedMember getMember()
    {
        return _member;
    }

    public String getName()
    {
        return _name;
    }

    public JavaType getType()
    {
        return _type;
    }

    public _type withType(JavaType javatype)
    {
        return new <init>(_name, javatype, _contextAnnotations, _member);
    }

    public tedMember(String s, JavaType javatype, Annotations annotations, AnnotatedMember annotatedmember)
    {
        _name = s;
        _type = javatype;
        _member = annotatedmember;
        _contextAnnotations = annotations;
    }
}
