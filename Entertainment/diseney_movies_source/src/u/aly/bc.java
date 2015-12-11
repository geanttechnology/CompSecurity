// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            cd

public final class bc extends Enum
    implements cd
{

    public static final bc a;
    public static final bc b;
    public static final bc c;
    public static final bc d;
    private static final bc f[];
    private final int e;

    private bc(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static bc a(int i)
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

    public static bc valueOf(String s)
    {
        return (bc)Enum.valueOf(u/aly/bc, s);
    }

    public static bc[] values()
    {
        bc abc[] = f;
        int i = abc.length;
        bc abc1[] = new bc[i];
        System.arraycopy(abc, 0, abc1, 0, i);
        return abc1;
    }

    public int a()
    {
        return e;
    }

    static 
    {
        a = new bc("ANDROID", 0, 0);
        b = new bc("IOS", 1, 1);
        c = new bc("WINDOWS_PHONE", 2, 2);
        d = new bc("WINDOWS_RT", 3, 3);
        f = (new bc[] {
            a, b, c, d
        });
    }
}
