// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

private static final class nonicalize
    implements Serializable, GenericArrayType
{

    private static final long serialVersionUID = 0L;
    private final Type a;

    public final boolean equals(Object obj)
    {
        return (obj instanceof GenericArrayType) && uals(this, (GenericArrayType)obj);
    }

    public final Type getGenericComponentType()
    {
        return a;
    }

    public final int hashCode()
    {
        return a.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder()).append(peToString(a)).append("[]").toString();
    }

    public (Type type)
    {
        a = nonicalize(type);
    }
}
