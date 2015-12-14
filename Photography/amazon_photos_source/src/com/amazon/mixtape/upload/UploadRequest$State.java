// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.upload;


// Referenced classes of package com.amazon.mixtape.upload:
//            UploadRequest

public static final class  extends Enum
{

    private static final SIDELINED $VALUES[];
    public static final SIDELINED BLOCKED;
    public static final SIDELINED DONE;
    public static final SIDELINED QUEUED;
    public static final SIDELINED SIDELINED;
    public static final SIDELINED STARTED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mixtape/upload/UploadRequest$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DONE = new <init>("DONE", 0);
        STARTED = new <init>("STARTED", 1);
        QUEUED = new <init>("QUEUED", 2);
        BLOCKED = new <init>("BLOCKED", 3);
        SIDELINED = new <init>("SIDELINED", 4);
        $VALUES = (new .VALUES[] {
            DONE, STARTED, QUEUED, BLOCKED, SIDELINED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
