// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.activities.do;


// Referenced classes of package io.presage.activities.do:
//            a

public static final class  extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(io/presage/activities/do/a$a, s);
    }

    public static [] values()
    {
        return ([])e.clone();
    }

    static 
    {
        a = new <init>("STATE_DEFAULT", 0);
        b = new <init>("STATE_CANCELED", 1);
        c = new <init>("STATE_CLOSED", 2);
        d = new <init>("STATE_ERRORED", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
