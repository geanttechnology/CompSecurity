// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.s;


// Referenced classes of package myobfuscated.s:
//            s, v, t

final class u
    implements s
{

    int a;
    android.graphics.Bitmap.Config b;
    private final v c;

    public u(v v1)
    {
        c = v1;
    }

    public final void a()
    {
        c.a(this);
    }

    public final boolean equals(Object obj)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (!(obj instanceof u)) goto _L2; else goto _L1
_L1:
        obj = (u)obj;
        flag = flag1;
        if (a != ((u) (obj)).a) goto _L2; else goto _L3
_L3:
        if (b != null) goto _L5; else goto _L4
_L4:
        flag = flag1;
        if (((u) (obj)).b != null) goto _L2; else goto _L6
_L6:
        flag = true;
_L2:
        return flag;
_L5:
        flag = flag1;
        if (!b.equals(((u) (obj)).b)) goto _L2; else goto _L6
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
        return t.a(a, b);
    }
}
