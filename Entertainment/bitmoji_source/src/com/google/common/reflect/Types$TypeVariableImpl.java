// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

// Referenced classes of package com.google.common.reflect:
//            Types

private static final class bounds
{

    private final ImmutableList bounds;
    private final GenericDeclaration genericDeclaration;
    private final String name;

    public boolean equals(Object obj)
    {
        if (!eEquals.NATIVE_TYPE_VARIABLE_ONLY) goto _L2; else goto _L1
_L1:
        if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof ationHandler)) goto _L4; else goto _L3
_L3:
        obj = ationHandler.access._mth600((ationHandler)Proxy.getInvocationHandler(obj));
        if (!name.equals(((name) (obj)).getName()) || !genericDeclaration.equals(((genericDeclaration) (obj)).getGenericDeclaration()) || !bounds.equals(((bounds) (obj)).bounds)) goto _L6; else goto _L5
_L5:
        return true;
_L6:
        return false;
_L4:
        return false;
_L2:
        if (obj instanceof TypeVariable)
        {
            obj = (TypeVariable)obj;
            if (!name.equals(((TypeVariable) (obj)).getName()) || !genericDeclaration.equals(((TypeVariable) (obj)).getGenericDeclaration()))
            {
                return false;
            }
        } else
        {
            return false;
        }
        if (true) goto _L5; else goto _L7
_L7:
    }

    public Type[] getBounds()
    {
        return Types.access$300(bounds);
    }

    public GenericDeclaration getGenericDeclaration()
    {
        return genericDeclaration;
    }

    public String getName()
    {
        return name;
    }

    public String getTypeName()
    {
        return name;
    }

    public int hashCode()
    {
        return genericDeclaration.hashCode() ^ name.hashCode();
    }

    public String toString()
    {
        return name;
    }

    ationHandler(GenericDeclaration genericdeclaration, String s, Type atype[])
    {
        Types.access$200(atype, "bound for type variable");
        genericDeclaration = (GenericDeclaration)Preconditions.checkNotNull(genericdeclaration);
        name = (String)Preconditions.checkNotNull(s);
        bounds = ImmutableList.copyOf(atype);
    }
}
