// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.aj;


public final class i
{

    private Class a;
    private Class b;
    private Class c;

    public i()
    {
    }

    public i(Class class1, Class class2)
    {
        a(class1, class2, null);
    }

    public i(Class class1, Class class2, Class class3)
    {
        a(class1, class2, class3);
    }

    public final void a(Class class1, Class class2, Class class3)
    {
        a = class1;
        b = class2;
        c = class3;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (i)obj;
            if (!a.equals(((i) (obj)).a))
            {
                return false;
            }
            if (!b.equals(((i) (obj)).b))
            {
                return false;
            }
            if (c == null && ((i) (obj)).c != null)
            {
                return false;
            }
            if (c != null && !c.equals(((i) (obj)).c))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int k = a.hashCode();
        int l = b.hashCode();
        int j;
        if (c != null)
        {
            j = c.hashCode();
        } else
        {
            j = 0;
        }
        return j + (k * 31 + l) * 31;
    }

    public final String toString()
    {
        return (new StringBuilder("MultiClassKey{first=")).append(a).append(", second=").append(b).append('}').toString();
    }
}
