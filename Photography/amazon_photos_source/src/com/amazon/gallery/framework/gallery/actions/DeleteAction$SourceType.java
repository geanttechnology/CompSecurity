// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;


// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteAction

protected static final class  extends Enum
{

    private static final CLOUD $VALUES[];
    public static final CLOUD CLOUD;
    public static final CLOUD DEFAULT;
    public static final CLOUD LOCAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/gallery/actions/DeleteAction$SourceType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DEFAULT = new <init>("DEFAULT", 0);
        LOCAL = new <init>("LOCAL", 1);
        CLOUD = new <init>("CLOUD", 2);
        $VALUES = (new .VALUES[] {
            DEFAULT, LOCAL, CLOUD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
