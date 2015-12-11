// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            bn

public static final class tring extends Enum
{

    public static final b a;
    public static final b b;
    private static final b c[];

    public static tring valueOf(String s)
    {
        return (tring)Enum.valueOf(u/aly/bn$a, s);
    }

    public static tring[] values()
    {
        bject abject[] = c;
        int i = abject.length;
        bject abject1[] = new c[i];
        System.arraycopy(abject, 0, abject1, 0, i);
        return abject1;
    }

    static 
    {
        a = new <init>("SUCCESS", 0);
        b = new <init>("FAIL", 1);
        c = (new c[] {
            a, b
        });
    }

    private tring(String s, int i)
    {
        super(s, i);
    }
}
