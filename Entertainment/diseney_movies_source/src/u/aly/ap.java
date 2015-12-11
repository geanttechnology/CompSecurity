// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            cd

public final class ap extends Enum
    implements cd
{

    public static final ap a;
    public static final ap b;
    public static final ap c;
    private static final ap e[];
    private final int d;

    private ap(String s, int i, int j)
    {
        super(s, i);
        d = j;
    }

    public static ap a(int i)
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
        }
    }

    public static ap valueOf(String s)
    {
        return (ap)Enum.valueOf(u/aly/ap, s);
    }

    public static ap[] values()
    {
        ap aap[] = e;
        int i = aap.length;
        ap aap1[] = new ap[i];
        System.arraycopy(aap, 0, aap1, 0, i);
        return aap1;
    }

    public int a()
    {
        return d;
    }

    static 
    {
        a = new ap("MALE", 0, 0);
        b = new ap("FEMALE", 1, 1);
        c = new ap("UNKNOWN", 2, 2);
        e = (new ap[] {
            a, b, c
        });
    }
}
