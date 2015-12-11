// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;


// Referenced classes of package com.pointinside.feeds:
//            BaseEntity

public static final class  extends Enum
{

    private static final DELETED $VALUES[];
    public static final DELETED CREATED;
    public static final DELETED DELETED;
    public static final DELETED MODIFIED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/feeds/BaseEntity$ServerAction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CREATED = new <init>("CREATED", 0);
        MODIFIED = new <init>("MODIFIED", 1);
        DELETED = new <init>("DELETED", 2);
        $VALUES = (new .VALUES[] {
            CREATED, MODIFIED, DELETED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
