// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;

import java.util.regex.Matcher;

// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            EpsUrlMatcher

public static class hostName
{

    final String hostName;
    final Matcher matcher;
    public final int type;
    final String url;

    (String s, int i, Matcher matcher1)
    {
        type = i;
        matcher = matcher1;
        url = s;
        if (matcher1 != null && matcher1.groupCount() > 0)
        {
            hostName = matcher1.group(0);
            return;
        } else
        {
            hostName = null;
            return;
        }
    }
}
