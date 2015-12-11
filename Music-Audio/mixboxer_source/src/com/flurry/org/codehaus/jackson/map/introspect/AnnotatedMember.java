// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.introspect;

import com.flurry.org.codehaus.jackson.map.util.ClassUtil;
import java.lang.reflect.Member;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.introspect:
//            Annotated, AnnotationMap

public abstract class AnnotatedMember extends Annotated
{

    protected final AnnotationMap _annotations;

    protected AnnotatedMember(AnnotationMap annotationmap)
    {
        _annotations = annotationmap;
    }

    public final void fixAccess()
    {
        ClassUtil.checkAndFixAccess(getMember());
    }

    protected AnnotationMap getAllAnnotations()
    {
        return _annotations;
    }

    public abstract Class getDeclaringClass();

    public abstract Member getMember();

    public abstract void setValue(Object obj, Object obj1)
        throws UnsupportedOperationException, IllegalArgumentException;
}
