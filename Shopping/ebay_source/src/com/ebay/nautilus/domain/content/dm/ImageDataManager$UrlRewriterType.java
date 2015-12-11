// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.text.TextUtils;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ImageDataManager

public static final class  extends Enum
{

    private static final AKAMAI $VALUES[];
    public static final AKAMAI AKAMAI;
    public static final AKAMAI EPS;
    public static final AKAMAI NONE;
    public static final AKAMAI ZOOM_GALLERY;
    public static final AKAMAI ZOOM_MERCH;
    public static final AKAMAI ZOOM_VIEWITEM;

    public static  from(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_15;
        }
        s = valueOf(s);
        return s;
        s;
        return NONE;
    }

    public static NONE valueOf(String s)
    {
        return (NONE)Enum.valueOf(com/ebay/nautilus/domain/content/dm/ImageDataManager$UrlRewriterType, s);
    }

    public static NONE[] values()
    {
        return (NONE[])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        EPS = new <init>("EPS", 1);
        ZOOM_GALLERY = new <init>("ZOOM_GALLERY", 2);
        ZOOM_VIEWITEM = new <init>("ZOOM_VIEWITEM", 3);
        ZOOM_MERCH = new <init>("ZOOM_MERCH", 4);
        AKAMAI = new <init>("AKAMAI", 5);
        $VALUES = (new .VALUES[] {
            NONE, EPS, ZOOM_GALLERY, ZOOM_VIEWITEM, ZOOM_MERCH, AKAMAI
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
