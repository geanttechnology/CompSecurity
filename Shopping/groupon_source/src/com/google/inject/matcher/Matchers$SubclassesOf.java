// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.matcher;

import java.io.Serializable;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package com.google.inject.matcher:
//            AbstractMatcher, Matchers

private static class ions.checkNotNull extends AbstractMatcher
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private final Class superclass;

    public boolean equals(Object obj)
    {
        return (obj instanceof ions.checkNotNull) && ((ions.checkNotNull)obj).superclass.equals(superclass);
    }

    public int hashCode()
    {
        return superclass.hashCode() * 37;
    }

    public boolean matches(Class class1)
    {
        return superclass.isAssignableFrom(class1);
    }

    public volatile boolean matches(Object obj)
    {
        return matches((Class)obj);
    }

    public String toString()
    {
        return (new StringBuilder()).append("subclassesOf(").append(superclass.getSimpleName()).append(".class)").toString();
    }

    public ions(Class class1)
    {
        superclass = (Class)Preconditions.checkNotNull(class1, "superclass");
    }
}
