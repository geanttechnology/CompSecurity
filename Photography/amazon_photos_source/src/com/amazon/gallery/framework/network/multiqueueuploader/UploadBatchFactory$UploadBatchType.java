// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;


// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            UploadBatchFactory

public static final class  extends Enum
{

    private static final NONE $VALUES[];
    public static final NONE CAMERA_PHOTO;
    public static final NONE CAMERA_VIDEO;
    public static final NONE NONE;
    public static final NONE NON_CAMERA_PHOTO;
    public static final NONE NON_CAMERA_VIDEO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/network/multiqueueuploader/UploadBatchFactory$UploadBatchType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CAMERA_PHOTO = new <init>("CAMERA_PHOTO", 0);
        CAMERA_VIDEO = new <init>("CAMERA_VIDEO", 1);
        NON_CAMERA_PHOTO = new <init>("NON_CAMERA_PHOTO", 2);
        NON_CAMERA_VIDEO = new <init>("NON_CAMERA_VIDEO", 3);
        NONE = new <init>("NONE", 4);
        $VALUES = (new .VALUES[] {
            CAMERA_PHOTO, CAMERA_VIDEO, NON_CAMERA_PHOTO, NON_CAMERA_VIDEO, NONE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
