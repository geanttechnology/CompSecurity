// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.s;


// Referenced classes of package myobfuscated.s:
//            s, o

final class n
    implements s
{

    int a;
    Class b;
    private final o c;

    n(o o1)
    {
        c = o1;
    }

    public final void a()
    {
        c.a(this);
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof n)
        {
            obj = (n)obj;
            flag = flag1;
            if (a == ((n) (obj)).a)
            {
                flag = flag1;
                if (b == ((n) (obj)).b)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        int j = a;
        int i;
        if (b != null)
        {
            i = b.hashCode();
        } else
        {
            i = 0;
        }
        return i + j * 31;
    }

    public final String toString()
    {
        return (new StringBuilder("Key{size=")).append(a).append("array=").append(b).append('}').toString();
    }
}
