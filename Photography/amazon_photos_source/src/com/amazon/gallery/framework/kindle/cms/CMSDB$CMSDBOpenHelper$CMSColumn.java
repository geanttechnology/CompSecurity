// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;


// Referenced classes of package com.amazon.gallery.framework.kindle.cms:
//            CMSDB

static final class  extends Enum
{

    private static final TIMESTAMP $VALUES[];
    public static final TIMESTAMP ID;
    public static final TIMESTAMP TIMESTAMP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/cms/CMSDB$CMSDBOpenHelper$CMSColumn, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ID = new <init>("ID", 0);
        TIMESTAMP = new <init>("TIMESTAMP", 1);
        $VALUES = (new .VALUES[] {
            ID, TIMESTAMP
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
