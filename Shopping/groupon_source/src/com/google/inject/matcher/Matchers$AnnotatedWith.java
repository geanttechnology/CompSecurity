// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.matcher;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package com.google.inject.matcher:
//            AbstractMatcher, Matchers

private static class ons.checkNotNull extends AbstractMatcher
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private final Annotation annotation;

    public boolean equals(Object obj)
    {
        return (obj instanceof ons.checkNotNull) && ((ons.checkNotNull)obj).annotation.equals(annotation);
    }

    public int hashCode()
    {
        return annotation.hashCode() * 37;
    }

    public volatile boolean matches(Object obj)
    {
        return matches((AnnotatedElement)obj);
    }

    public boolean matches(AnnotatedElement annotatedelement)
    {
        annotatedelement = annotatedelement.getAnnotation(annotation.annotationType());
        return annotatedelement != null && annotation.equals(annotatedelement);
    }

    public String toString()
    {
        return (new StringBuilder()).append("annotatedWith(").append(annotation).append(")").toString();
    }

    public ons(Annotation annotation1)
    {
        annotation = (Annotation)Preconditions.checkNotNull(annotation1, "annotation");
        Matchers.access$200(annotation1.annotationType());
    }
}
