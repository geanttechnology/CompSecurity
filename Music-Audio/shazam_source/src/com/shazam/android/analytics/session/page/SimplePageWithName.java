// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.page;

import com.shazam.i.e.a;
import java.util.Map;

// Referenced classes of package com.shazam.android.analytics.session.page:
//            Page

public abstract class SimplePageWithName
    implements Page
{

    public SimplePageWithName()
    {
    }

    public Map getAdditionalEventParameters()
    {
        return a.a(0);
    }
}
