// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;


// Referenced classes of package com.amazon.device.crashmanager:
//            ArtifactUploader

private static final class  extends Enum
{

    private static final SKIP $VALUES[];
    public static final SKIP RETRY;
    public static final SKIP SKIP;
    public static final SKIP SUCCESS;

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
        RETRY = new <init>("RETRY", 1);
        SKIP = new <init>("SKIP", 2);
        $VALUES = (new .VALUES[] {
            SUCCESS, RETRY, SKIP
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
