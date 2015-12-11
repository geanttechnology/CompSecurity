// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.page;

import com.shazam.android.analytics.session.SessionConfigurable;

// Referenced classes of package com.shazam.android.analytics.session.page:
//            Page

public class PageConfiguration
{

    public PageConfiguration()
    {
    }

    public void configureIfAppropriate(Object obj, Page page)
    {
        if (obj instanceof SessionConfigurable)
        {
            ((SessionConfigurable)obj).configureWith(page);
        }
    }
}
