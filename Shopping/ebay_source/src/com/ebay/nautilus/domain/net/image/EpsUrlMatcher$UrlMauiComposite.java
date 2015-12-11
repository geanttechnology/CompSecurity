// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            EpsUrlMatcher

public static class setId extends setId
{

    private static final int INDEX_ENCODED_INFO_PLUS = 4;
    private static final int INDEX_IMAGE_DIMENSION = 2;
    private static final int INDEX_MEMBER_IMAGE_ID = 5;
    private static final int INDEX_SET_ID = 6;
    private static final int INDEX_ZMETA_GUID = 3;
    public static final int MIN_REQUIRED_MATCHES = 6;
    public static final Pattern pattern = Pattern.compile("http://([A-Za-z0-9.]+\\.(?:ebay|ebayimg)\\.com)/00/(?:s/([^/]+)/)?(?:z/([^/]+)/)?\\$([^_]*)_([0-9]+)\\.jpg(?:\\?set_id=(.*)|)", 2);
    public final String encodedInfo;
    public final String imageDimension;
    public final String memberImageId;
    public final String setId;
    public final String zmetaGuid;


    public (String s, Matcher matcher)
    {
        Object obj = null;
        super(s, 6, matcher);
        int i = matcher.groupCount();
        if (i >= 2)
        {
            s = matcher.group(2);
        } else
        {
            s = null;
        }
        imageDimension = s;
        if (i >= 3)
        {
            s = matcher.group(3);
        } else
        {
            s = null;
        }
        zmetaGuid = s;
        if (i >= 4)
        {
            s = matcher.group(4);
        } else
        {
            s = null;
        }
        encodedInfo = s;
        if (i >= 5)
        {
            s = matcher.group(5);
        } else
        {
            s = null;
        }
        memberImageId = s;
        s = obj;
        if (i >= 6)
        {
            s = matcher.group(6);
        }
        setId = s;
    }
}
