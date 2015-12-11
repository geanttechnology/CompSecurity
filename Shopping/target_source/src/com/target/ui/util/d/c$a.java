// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.d;


// Referenced classes of package com.target.ui.util.d:
//            c

private static final class  extends Enum
{

    private static final Saturday $VALUES[];
    public static final Saturday Friday;
    public static final Saturday Monday;
    public static final Saturday Saturday;
    public static final Saturday Sunday;
    public static final Saturday Thursday;
    public static final Saturday Tuesday;
    public static final Saturday Wednesday;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/util/d/c$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Sunday = new <init>("Sunday", 0);
        Monday = new <init>("Monday", 1);
        Tuesday = new <init>("Tuesday", 2);
        Wednesday = new <init>("Wednesday", 3);
        Thursday = new <init>("Thursday", 4);
        Friday = new <init>("Friday", 5);
        Saturday = new <init>("Saturday", 6);
        $VALUES = (new .VALUES[] {
            Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
