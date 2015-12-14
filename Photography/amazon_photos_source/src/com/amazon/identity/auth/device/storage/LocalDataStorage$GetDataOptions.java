// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;


// Referenced classes of package com.amazon.identity.auth.device.storage:
//            LocalDataStorage

private static final class  extends Enum
{

    private static final NotDeleted $VALUES[];
    public static final NotDeleted Deleted;
    public static final NotDeleted DirtyOnly;
    public static final NotDeleted NotDeleted;
    public static final NotDeleted NotDirtyOnly;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/auth/device/storage/LocalDataStorage$GetDataOptions, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DirtyOnly = new <init>("DirtyOnly", 0);
        NotDirtyOnly = new <init>("NotDirtyOnly", 1);
        Deleted = new <init>("Deleted", 2);
        NotDeleted = new <init>("NotDeleted", 3);
        $VALUES = (new .VALUES[] {
            DirtyOnly, NotDirtyOnly, Deleted, NotDeleted
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
