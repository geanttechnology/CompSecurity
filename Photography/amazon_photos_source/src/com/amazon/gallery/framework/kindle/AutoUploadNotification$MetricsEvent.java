// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;


// Referenced classes of package com.amazon.gallery.framework.kindle:
//            AutoUploadNotification

public static final class  extends Enum
{

    private static final AutoSaveDialogNotAccepted $VALUES[];
    public static final AutoSaveDialogNotAccepted AutoSaveDialogAccepted;
    public static final AutoSaveDialogNotAccepted AutoSaveDialogDisplayed;
    public static final AutoSaveDialogNotAccepted AutoSaveDialogNotAccepted;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/AutoUploadNotification$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AutoSaveDialogDisplayed = new <init>("AutoSaveDialogDisplayed", 0);
        AutoSaveDialogAccepted = new <init>("AutoSaveDialogAccepted", 1);
        AutoSaveDialogNotAccepted = new <init>("AutoSaveDialogNotAccepted", 2);
        $VALUES = (new .VALUES[] {
            AutoSaveDialogDisplayed, AutoSaveDialogAccepted, AutoSaveDialogNotAccepted
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
