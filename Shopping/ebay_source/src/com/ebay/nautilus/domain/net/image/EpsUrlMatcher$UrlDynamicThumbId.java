// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            EpsUrlMatcher

public static class galleryVersion extends galleryVersion
{

    private static final int INDEX_GALLERY_VERSION = 4;
    private static final int INDEX_ITEM_ID = 3;
    private static final int INDEX_SIZE = 2;
    public static final int MIN_REQUIRED_MATCHES = 3;
    public static final Pattern pattern = Pattern.compile("http://((?:thumbs[1-9]?|mthumbs)\\.ebaystatic\\.com)/d/([^/]+)/pict/([^_]+)_([0-9]+)\\.jpg", 2);
    public final String galleryVersion;
    public final String itemId;
    public final String size;


    public (String s, Matcher matcher)
    {
        Object obj = null;
        super(s, 1, matcher);
        int i = matcher.groupCount();
        if (i >= 2)
        {
            s = matcher.group(2);
        } else
        {
            s = null;
        }
        size = s;
        if (i >= 3)
        {
            s = matcher.group(3);
        } else
        {
            s = null;
        }
        itemId = s;
        s = obj;
        if (i >= 4)
        {
            s = matcher.group(4);
        }
        galleryVersion = s;
    }
}
