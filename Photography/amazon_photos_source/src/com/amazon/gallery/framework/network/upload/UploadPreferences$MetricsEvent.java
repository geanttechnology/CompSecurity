// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.upload;


// Referenced classes of package com.amazon.gallery.framework.network.upload:
//            UploadPreferences

public static final class  extends Enum
{

    private static final DisableAutoVideoSave $VALUES[];
    public static final DisableAutoVideoSave DisableAutoPhotoSave;
    public static final DisableAutoVideoSave DisableAutoVideoSave;
    public static final DisableAutoVideoSave EnableAutoPhotoSave;
    public static final DisableAutoVideoSave EnableAutoVideoSave;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/network/upload/UploadPreferences$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EnableAutoPhotoSave = new <init>("EnableAutoPhotoSave", 0);
        DisableAutoPhotoSave = new <init>("DisableAutoPhotoSave", 1);
        EnableAutoVideoSave = new <init>("EnableAutoVideoSave", 2);
        DisableAutoVideoSave = new <init>("DisableAutoVideoSave", 3);
        $VALUES = (new .VALUES[] {
            EnableAutoPhotoSave, DisableAutoPhotoSave, EnableAutoVideoSave, DisableAutoVideoSave
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
