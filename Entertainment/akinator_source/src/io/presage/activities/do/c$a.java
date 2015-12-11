// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.activities.do;


// Referenced classes of package io.presage.activities.do:
//            c

public static final class  extends Enum
{

    public static final b a;
    public static final b b;
    private static final b c[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(io/presage/activities/do/c$a, s);
    }

    public static [] values()
    {
        return ([])c.clone();
    }

    static 
    {
        a = new <init>("ACTIVITY_HELPER_TYPE_WEB_VIEW", 0);
        b = new <init>("ACTIVITY_HELPER_TYPE_VIDEO", 1);
        c = (new c[] {
            a, b
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
