// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership;


// Referenced classes of package com.target.mothership:
//            c

public static final class  extends Enum
{

    private static final NoLocation $VALUES[];
    public static final NoLocation InStore;
    public static final NoLocation NoLocation;
    public static final NoLocation OutOfStore;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/mothership/c$b, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        InStore = new <init>("InStore", 0);
        OutOfStore = new <init>("OutOfStore", 1);
        NoLocation = new <init>("NoLocation", 2);
        $VALUES = (new .VALUES[] {
            InStore, OutOfStore, NoLocation
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
