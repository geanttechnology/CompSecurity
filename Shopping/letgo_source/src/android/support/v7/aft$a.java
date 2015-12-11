// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

// Referenced classes of package android.support.v7:
//            aft

private static final class a
    implements Serializable, GenericArrayType
{

    private final Type a;

    public boolean equals(Object obj)
    {
        return (obj instanceof GenericArrayType) && aft.a(this, (GenericArrayType)obj);
    }

    public Type getGenericComponentType()
    {
        return a;
    }

    public int hashCode()
    {
        return a.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append(aft.f(a)).append("[]").toString();
    }

    public ArrayType(Type type)
    {
        a = aft.d(type);
    }
}
