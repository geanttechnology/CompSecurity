// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            kg

public static final class  extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(android/support/v7/kg$a, s);
    }

    public static [] values()
    {
        return ([])d.clone();
    }

    static 
    {
        a = new <init>("UNKNOWN", 0);
        b = new <init>("MALE", 1);
        c = new <init>("FEMALE", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
