// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;


// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            AbstractShareAction

public static final class  extends Enum
{

    private static final ShareFile $VALUES[];
    public static final ShareFile ShareClicked;
    public static final ShareFile ShareFile;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/gallery/actions/AbstractShareAction$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ShareClicked = new <init>("ShareClicked", 0);
        ShareFile = new <init>("ShareFile", 1);
        $VALUES = (new .VALUES[] {
            ShareClicked, ShareFile
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
