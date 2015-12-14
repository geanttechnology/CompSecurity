// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.ab;


// Referenced classes of package it.sephiroth.android.library.ab:
//            AB

public static final class  extends Enum
{

    private static final GroupB $VALUES[];
    public static final GroupB GroupA;
    public static final GroupB GroupB;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(it/sephiroth/android/library/ab/AB$Group, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        GroupA = new <init>("GroupA", 0);
        GroupB = new <init>("GroupB", 1);
        $VALUES = (new .VALUES[] {
            GroupA, GroupB
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
