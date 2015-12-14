// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.s;


// Referenced classes of package myobfuscated.s:
//            s, e, c

final class d
    implements s
{

    int a;
    int b;
    android.graphics.Bitmap.Config c;
    private final e d;

    public d(e e1)
    {
        d = e1;
    }

    public final void a()
    {
        d.a(this);
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof d)
        {
            obj = (d)obj;
            flag = flag1;
            if (a == ((d) (obj)).a)
            {
                flag = flag1;
                if (b == ((d) (obj)).b)
                {
                    flag = flag1;
                    if (c == ((d) (obj)).c)
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        int j = a;
        int k = b;
        int i;
        if (c != null)
        {
            i = c.hashCode();
        } else
        {
            i = 0;
        }
        return i + (j * 31 + k) * 31;
    }

    public final String toString()
    {
        return myobfuscated.s.c.c(a, b, c);
    }
}
