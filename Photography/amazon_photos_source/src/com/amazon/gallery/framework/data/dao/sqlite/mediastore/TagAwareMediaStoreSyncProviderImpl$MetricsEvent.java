// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;


// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediastore:
//            TagAwareMediaStoreSyncProviderImpl

public static final class  extends Enum
{

    private static final AddLocalFile $VALUES[];
    public static final AddLocalFile AddLocalFile;
    public static final AddLocalFile PhotoSideloaded;
    public static final AddLocalFile ScreenshotCaptured;
    public static final AddLocalFile VideoSideloaded;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/data/dao/sqlite/mediastore/TagAwareMediaStoreSyncProviderImpl$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PhotoSideloaded = new <init>("PhotoSideloaded", 0);
        VideoSideloaded = new <init>("VideoSideloaded", 1);
        ScreenshotCaptured = new <init>("ScreenshotCaptured", 2);
        AddLocalFile = new <init>("AddLocalFile", 3);
        $VALUES = (new .VALUES[] {
            PhotoSideloaded, VideoSideloaded, ScreenshotCaptured, AddLocalFile
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
