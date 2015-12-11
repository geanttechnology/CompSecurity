// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.page;

import com.shazam.i.e.a;
import java.util.Map;

// Referenced classes of package com.shazam.android.analytics.session.page:
//            SimplePageWithName

public class VisualShazamPage extends SimplePageWithName
{

    public static final String VISUAL = "visual";
    private final Map additionalEventParameters = a.a(0);

    public VisualShazamPage()
    {
    }

    public Map getAdditionalEventParameters()
    {
        return additionalEventParameters;
    }

    public String getPageName()
    {
        return "visual";
    }

    public void setPageEndCause(String s)
    {
        additionalEventParameters.put("endcause", s);
    }
}
