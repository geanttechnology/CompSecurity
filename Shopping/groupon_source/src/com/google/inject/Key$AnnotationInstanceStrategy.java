// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject;

import java.lang.annotation.Annotation;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package com.google.inject:
//            Key

static class ons.checkNotNull
    implements ons.checkNotNull
{

    final Annotation annotation;

    public boolean equals(Object obj)
    {
        if (!(obj instanceof ons.checkNotNull))
        {
            return false;
        } else
        {
            obj = (ons.checkNotNull)obj;
            return annotation.equals(((annotation) (obj)).annotation);
        }
    }

    public Annotation getAnnotation()
    {
        return annotation;
    }

    public Class getAnnotationType()
    {
        return annotation.annotationType();
    }

    public boolean hasAttributes()
    {
        return true;
    }

    public int hashCode()
    {
        return annotation.hashCode();
    }

    public String toString()
    {
        return annotation.toString();
    }

    public annotation withoutAttributes()
    {
        return new t>(getAnnotationType(), annotation);
    }

    ons(Annotation annotation1)
    {
        annotation = (Annotation)Preconditions.checkNotNull(annotation1, "annotation");
    }
}
