// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            EpsUrlMatcher

public static class  extends 
{

    public static final Pattern pattern = Pattern.compile("https://((?:securethumbs[1-9]?)\\.ebay\\.com)/d/([^/]+)/m/([^/]+)\\.jpg", 2);


    public (String s, Matcher matcher)
    {
        super(s, matcher);
    }
}
