// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.matcher;

import java.io.Serializable;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package com.google.inject.matcher:
//            AbstractMatcher, Matchers

private static class tions.checkNotNull extends AbstractMatcher
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private final Object value;

    public boolean equals(Object obj)
    {
        return (obj instanceof tions.checkNotNull) && ((tions.checkNotNull)obj).value == value;
    }

    public int hashCode()
    {
        return System.identityHashCode(value) * 37;
    }

    public boolean matches(Object obj)
    {
        return value == obj;
    }

    public String toString()
    {
        return (new StringBuilder()).append("identicalTo(").append(value).append(")").toString();
    }

    public tions(Object obj)
    {
        value = Preconditions.checkNotNull(obj, "value");
    }
}
