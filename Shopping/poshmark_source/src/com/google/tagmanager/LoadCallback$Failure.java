// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            LoadCallback

public static final class  extends Enum
{

    private static final SERVER_ERROR $VALUES[];
    public static final SERVER_ERROR IO_ERROR;
    public static final SERVER_ERROR NOT_AVAILABLE;
    public static final SERVER_ERROR SERVER_ERROR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/tagmanager/LoadCallback$Failure, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NOT_AVAILABLE = new <init>("NOT_AVAILABLE", 0);
        IO_ERROR = new <init>("IO_ERROR", 1);
        SERVER_ERROR = new <init>("SERVER_ERROR", 2);
        $VALUES = (new .VALUES[] {
            NOT_AVAILABLE, IO_ERROR, SERVER_ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
