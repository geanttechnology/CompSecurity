// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;


// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            FolderSelectionActivity

public static final class  extends Enum
{

    private static final InFolderSettings $VALUES[];
    public static final InFolderSettings InFolderSettings;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/app/activity/FolderSelectionActivity$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        InFolderSettings = new <init>("InFolderSettings", 0);
        $VALUES = (new .VALUES[] {
            InFolderSettings
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
