// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.c;


// Referenced classes of package c.a.a.a.a.c:
//            u

public final class o extends Enum
{

    public static final int a = 2;
    public static final int b = 3;
    public static final int c = 4;
    private static int d = 1;
    private static final int e[] = {
        1, 2, 3, 4
    };

    static int a(u u1, Object obj)
    {
        int i;
        if (obj instanceof u)
        {
            i = ((u)obj).getPriority$16699175();
        } else
        {
            i = 2;
        }
        return i - 1 - (u1.getPriority$16699175() - 1);
    }

}
