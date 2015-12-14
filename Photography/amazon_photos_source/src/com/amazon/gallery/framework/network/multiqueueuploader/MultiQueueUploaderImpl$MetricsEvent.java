// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;


// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            MultiQueueUploaderImpl

public static final class a extends Enum
{

    private static final UploadFreeTimeFile $VALUES[];
    public static final UploadFreeTimeFile AutoSaveEditedFile;
    public static final UploadFreeTimeFile AutoSaveFile;
    public static final UploadFreeTimeFile AutoSaveFreeTime;
    public static final UploadFreeTimeFile UploadFile;
    public static final UploadFreeTimeFile UploadFreeTimeFile;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/amazon/gallery/framework/network/multiqueueuploader/MultiQueueUploaderImpl$MetricsEvent, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    static 
    {
        AutoSaveFile = new <init>("AutoSaveFile", 0);
        AutoSaveEditedFile = new <init>("AutoSaveEditedFile", 1);
        AutoSaveFreeTime = new <init>("AutoSaveFreeTime", 2);
        UploadFile = new <init>("UploadFile", 3);
        UploadFreeTimeFile = new <init>("UploadFreeTimeFile", 4);
        $VALUES = (new .VALUES[] {
            AutoSaveFile, AutoSaveEditedFile, AutoSaveFreeTime, UploadFile, UploadFreeTimeFile
        });
    }

    private a(String s, int i)
    {
        super(s, i);
    }
}
