// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

// Referenced classes of package android.support.v7:
//            aft, afs

private static final class a
    implements Serializable, WildcardType
{

    private final Type a;
    private final Type b;

    public boolean equals(Object obj)
    {
        return (obj instanceof WildcardType) && aft.a(this, (WildcardType)obj);
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
            return aft.a;
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
            return (new StringBuilder()).append("? super ").append(aft.f(b)).toString();
        }
        if (a == java/lang/Object)
        {
            return "?";
        } else
        {
            return (new StringBuilder()).append("? extends ").append(aft.f(a)).toString();
        }
    }

    public dType(Type atype[], Type atype1[])
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
        afs.a(flag);
        if (atype.length == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        afs.a(flag);
        if (atype1.length == 1)
        {
            afs.a(atype1[0]);
            aft.h(atype1[0]);
            if (atype[0] == java/lang/Object)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            afs.a(flag);
            b = aft.d(atype1[0]);
            a = java/lang/Object;
            return;
        } else
        {
            afs.a(atype[0]);
            aft.h(atype[0]);
            b = null;
            a = aft.d(atype[0]);
            return;
        }
    }
}
