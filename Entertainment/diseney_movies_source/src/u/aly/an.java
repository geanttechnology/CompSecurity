// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            cd

public final class an extends Enum
    implements cd
{

    public static final an a;
    public static final an b;
    private static final an d[];
    private final int c;

    private an(String s, int i, int j)
    {
        super(s, i);
        c = j;
    }

    public static an a(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return a;

        case 2: // '\002'
            return b;
        }
    }

    public static an valueOf(String s)
    {
        return (an)Enum.valueOf(u/aly/an, s);
    }

    public static an[] values()
    {
        an aan[] = d;
        int i = aan.length;
        an aan1[] = new an[i];
        System.arraycopy(aan, 0, aan1, 0, i);
        return aan1;
    }

    public int a()
    {
        return c;
    }

    static 
    {
        a = new an("LEGIT", 0, 1);
        b = new an("ALIEN", 1, 2);
        d = (new an[] {
            a, b
        });
    }
}
