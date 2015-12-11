// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;


// Referenced classes of package com.abtnprojects.ambatana.ui.activities.profile:
//            UserProfileActivity

public static final class  extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/abtnprojects/ambatana/ui/activities/profile/UserProfileActivity$b, s);
    }

    public static [] values()
    {
        return ([])d.clone();
    }

    static 
    {
        a = new <init>("TAB_SELL", 0);
        b = new <init>("TAB_SOLD", 1);
        c = new <init>("TAB_FAVORITES", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
