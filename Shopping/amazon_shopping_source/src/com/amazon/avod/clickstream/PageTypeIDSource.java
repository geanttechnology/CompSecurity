// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.clickstream;

import com.google.common.base.Preconditions;

// Referenced classes of package com.amazon.avod.clickstream:
//            ClickstreamParam

public final class PageTypeIDSource extends Enum
    implements ClickstreamParam
{

    private static final PageTypeIDSource $VALUES[];
    public static final PageTypeIDSource ASIN;
    public static final PageTypeIDSource IMDB_CAST_ID;
    public static final PageTypeIDSource IMDB_CHARACTER_ID;
    public static final PageTypeIDSource IMDB_SCENE_ID;
    public static final PageTypeIDSource IMDB_SOUNDTRACK_ID;
    public static final PageTypeIDSource IMDB_TRIVIA_ID;
    public static final PageTypeIDSource XRAY_DOCUMENT_ID;
    private final String mReportableString;

    private PageTypeIDSource(String s, int i, String s1)
    {
        super(s, i);
        boolean flag;
        if (s1.length() <= 20)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "PageTypeIDSource length limit exceeded.");
        mReportableString = s1;
    }

    public static PageTypeIDSource valueOf(String s)
    {
        return (PageTypeIDSource)Enum.valueOf(com/amazon/avod/clickstream/PageTypeIDSource, s);
    }

    public static PageTypeIDSource[] values()
    {
        return (PageTypeIDSource[])$VALUES.clone();
    }

    public String getReportableString()
    {
        return mReportableString;
    }

    static 
    {
        ASIN = new PageTypeIDSource("ASIN", 0, "ASIN");
        XRAY_DOCUMENT_ID = new PageTypeIDSource("XRAY_DOCUMENT_ID", 1, "VSID");
        IMDB_CAST_ID = new PageTypeIDSource("IMDB_CAST_ID", 2, "NCONST");
        IMDB_CHARACTER_ID = new PageTypeIDSource("IMDB_CHARACTER_ID", 3, "CHCONST");
        IMDB_SOUNDTRACK_ID = new PageTypeIDSource("IMDB_SOUNDTRACK_ID", 4, "SNCONST");
        IMDB_TRIVIA_ID = new PageTypeIDSource("IMDB_TRIVIA_ID", 5, "TRCONST");
        IMDB_SCENE_ID = new PageTypeIDSource("IMDB_SCENE_ID", 6, "SCCONST");
        $VALUES = (new PageTypeIDSource[] {
            ASIN, XRAY_DOCUMENT_ID, IMDB_CAST_ID, IMDB_CHARACTER_ID, IMDB_SOUNDTRACK_ID, IMDB_TRIVIA_ID, IMDB_SCENE_ID
        });
    }
}
