// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            jg

private static final class  extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(android/support/v7/jg$e, s);
    }

    public static [] values()
    {
        return ([])e.clone();
    }

    static 
    {
        a = new <init>("SUCCESS", 0);
        b = new <init>("SERVER_ERROR", 1);
        c = new <init>("NO_CONNECTIVITY", 2);
        d = new <init>("UNKNOWN_ERROR", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
