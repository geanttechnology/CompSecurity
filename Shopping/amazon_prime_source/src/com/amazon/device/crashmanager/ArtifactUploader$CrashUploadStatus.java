// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;


// Referenced classes of package com.amazon.device.crashmanager:
//            ArtifactUploader

public static final class  extends Enum
{

    private static final SERVER_ERROR $VALUES[];
    public static final SERVER_ERROR FAILURE;
    public static final SERVER_ERROR SERVER_ERROR;
    public static final SERVER_ERROR SUCCESS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/device/crashmanager/ArtifactUploader$CrashUploadStatus, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SUCCESS = new <init>("SUCCESS", 0);
        FAILURE = new <init>("FAILURE", 1);
        SERVER_ERROR = new <init>("SERVER_ERROR", 2);
        $VALUES = (new .VALUES[] {
            SUCCESS, FAILURE, SERVER_ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
