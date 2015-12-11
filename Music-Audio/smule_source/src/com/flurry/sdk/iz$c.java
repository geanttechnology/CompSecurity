// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

// Referenced classes of package com.flurry.sdk:
//            iy, iz

final class pe
    implements Serializable, WildcardType
{

    private final Type a;
    private final Type b;

    public boolean equals(Object obj)
    {
        return (obj instanceof WildcardType) && iz.a(this, (WildcardType)obj);
    }

    public Type[] getLowerBounds()
    {
        if (b != null)
        {
            return (new Type[] {
                b
            });
        } else
        {
            return iz.a;
        }
    }

    public Type[] getUpperBounds()
    {
        return (new Type[] {
            a
        });
    }

    public int hashCode()
    {
        int i;
        if (b != null)
        {
            i = b.hashCode() + 31;
        } else
        {
            i = 1;
        }
        return i ^ a.hashCode() + 31;
    }

    public String toString()
    {
        if (b != null)
        {
            return (new StringBuilder()).append("? super ").append(iz.f(b)).toString();
        }
        if (a == java/lang/Object)
        {
            return "?";
        } else
        {
            return (new StringBuilder()).append("? extends ").append(iz.f(a)).toString();
        }
    }

    public pe(Type atype[], Type atype1[])
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (atype1.length <= 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        iy.a(flag);
        if (atype.length == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        iy.a(flag);
        if (atype1.length == 1)
        {
            iy.a(atype1[0]);
            iz.h(atype1[0]);
            if (atype[0] == java/lang/Object)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            iy.a(flag);
            b = iz.d(atype1[0]);
            a = java/lang/Object;
            return;
        } else
        {
            iy.a(atype[0]);
            iz.h(atype[0]);
            b = null;
            a = iz.d(atype[0]);
            return;
        }
    }
}
