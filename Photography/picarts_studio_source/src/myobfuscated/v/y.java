// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;


// Referenced classes of package myobfuscated.v:
//            v

final class y
    implements v
{

    private final String a;

    y(String s)
    {
        a = s;
    }

    public final String a()
    {
        return a;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof y)
        {
            obj = (y)obj;
            return a.equals(((y) (obj)).a);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return a.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("StringHeaderFactory{value='")).append(a).append('\'').append('}').toString();
    }
}
