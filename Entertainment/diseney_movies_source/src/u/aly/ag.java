// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            cd

public final class ag extends Enum
    implements cd
{

    public static final ag a;
    public static final ag b;
    public static final ag c;
    public static final ag d;
    private static final ag f[];
    private final int e;

    private ag(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static ag a(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return a;

        case 1: // '\001'
            return b;

        case 2: // '\002'
            return c;

        case 3: // '\003'
            return d;
        }
    }

    public static ag valueOf(String s)
    {
        return (ag)Enum.valueOf(u/aly/ag, s);
    }

    public static ag[] values()
    {
        ag aag[] = f;
        int i = aag.length;
        ag aag1[] = new ag[i];
        System.arraycopy(aag, 0, aag1, 0, i);
        return aag1;
    }

    public int a()
    {
        return e;
    }

    static 
    {
        a = new ag("ACCESS_TYPE_UNKNOWN", 0, 0);
        b = new ag("ACCESS_TYPE_2G_3G", 1, 1);
        c = new ag("ACCESS_TYPE_WIFI", 2, 2);
        d = new ag("ACCESS_TYPE_ETHERNET", 3, 3);
        f = (new ag[] {
            a, b, c, d
        });
    }
}
