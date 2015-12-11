// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            EpsUrlMatcher

public static class setId extends nents
{

    private static final int INDEX_ENCODED_INFO_PLUS = 2;
    private static final int INDEX_MEMBER_IMAGE_ID = 3;
    private static final int INDEX_SET_ID = 4;
    public static final int MIN_REQUIRED_MATCHES = 4;
    public static final Pattern pattern = Pattern.compile("http://([A-Za-z0-9.]+\\.(?:ebay|ebayimg)\\.com)/00/\\$([^_]*)_([0-9]+)\\.jpg(?:\\?set_id=(.*)|)", 2);
    public final String encodedInfo;
    public final String memberImageId;
    public final String setId;


    public nents(String s, Matcher matcher)
    {
        Object obj = null;
        super(s, 5, matcher);
        int i = matcher.groupCount();
        if (i >= 2)
        {
            s = matcher.group(2);
        } else
        {
            s = null;
        }
        encodedInfo = s;
        if (i >= 3)
        {
            s = matcher.group(3);
        } else
        {
            s = null;
        }
        memberImageId = s;
        s = obj;
        if (i >= 4)
        {
            s = matcher.group(4);
        }
        setId = s;
    }
}
