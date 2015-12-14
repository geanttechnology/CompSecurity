// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;


// Referenced classes of package com.amazon.gallery.thor.app:
//            BackupCloudDriveReceiver

public static final class  extends Enum
{

    private static final FirstTimeAutoUploadDisabled $VALUES[];
    public static final FirstTimeAutoUploadDisabled FirstTimeAutoUploadDisabled;
    public static final FirstTimeAutoUploadDisabled FirstTimeAutoUploadEnabled;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/app/BackupCloudDriveReceiver$BackupCloudDriveEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FirstTimeAutoUploadEnabled = new <init>("FirstTimeAutoUploadEnabled", 0);
        FirstTimeAutoUploadDisabled = new <init>("FirstTimeAutoUploadDisabled", 1);
        $VALUES = (new .VALUES[] {
            FirstTimeAutoUploadEnabled, FirstTimeAutoUploadDisabled
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
