// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;


// Referenced classes of package com.amazon.device.crashmanager:
//            ArtifactUploader

private static final class  extends Enum
{

    private static final SERVER_ERROR $VALUES[];
    public static final SERVER_ERROR DE_DUPED;
    public static final SERVER_ERROR FAILED;
    public static final SERVER_ERROR SERVER_ERROR;
    public static final SERVER_ERROR SKIP;
    public static final SERVER_ERROR SUCCESS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SUCCESS = new <init>("SUCCESS", 0);
        DE_DUPED = new <init>("DE_DUPED", 1);
        SKIP = new <init>("SKIP", 2);
        FAILED = new <init>("FAILED", 3);
        SERVER_ERROR = new <init>("SERVER_ERROR", 4);
        $VALUES = (new .VALUES[] {
            SUCCESS, DE_DUPED, SKIP, FAILED, SERVER_ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
