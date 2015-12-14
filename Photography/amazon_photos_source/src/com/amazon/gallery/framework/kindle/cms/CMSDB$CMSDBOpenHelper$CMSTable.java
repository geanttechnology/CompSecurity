// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;


// Referenced classes of package com.amazon.gallery.framework.kindle.cms:
//            CMSDB

static final class  extends Enum
{

    private static final RECENT_ALBUMS $VALUES[];
    public static final RECENT_ALBUMS RECENT_ALBUMS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/cms/CMSDB$CMSDBOpenHelper$CMSTable, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RECENT_ALBUMS = new <init>("RECENT_ALBUMS", 0);
        $VALUES = (new .VALUES[] {
            RECENT_ALBUMS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
