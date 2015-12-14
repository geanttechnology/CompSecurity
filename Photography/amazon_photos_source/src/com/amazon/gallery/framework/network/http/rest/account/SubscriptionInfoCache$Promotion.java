// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.account;


// Referenced classes of package com.amazon.gallery.framework.network.http.rest.account:
//            SubscriptionInfoCache

public static class id
{

    private final String id;
    private final String title;
    private final String url;

    public String getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getUrl()
    {
        return url;
    }

    public (String s, String s1, String s2)
    {
        title = s;
        url = s1;
        id = s2;
    }
}
