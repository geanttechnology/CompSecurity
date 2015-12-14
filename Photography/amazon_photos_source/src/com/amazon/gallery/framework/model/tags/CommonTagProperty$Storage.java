// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.tags;


// Referenced classes of package com.amazon.gallery.framework.model.tags:
//            TagProperty, CommonTagProperty

public static final class  extends Enum
    implements TagProperty
{

    private static final CLOUD $VALUES[];
    public static final CLOUD CLOUD;
    public static final CLOUD LOCAL;
    public static final CLOUD NOT_SET;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/model/tags/CommonTagProperty$Storage, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NOT_SET = new <init>("NOT_SET", 0);
        LOCAL = new <init>("LOCAL", 1);
        CLOUD = new <init>("CLOUD", 2);
        $VALUES = (new .VALUES[] {
            NOT_SET, LOCAL, CLOUD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
