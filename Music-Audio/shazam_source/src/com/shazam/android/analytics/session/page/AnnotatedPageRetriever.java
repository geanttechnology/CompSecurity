// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.page;

import com.shazam.android.analytics.session.exception.SessionInitializationException;
import com.shazam.android.annotation.analytics.WithPageView;

// Referenced classes of package com.shazam.android.analytics.session.page:
//            PageRetriever, Page

public class AnnotatedPageRetriever
    implements PageRetriever
{

    public AnnotatedPageRetriever()
    {
    }

    public Page retrievePageFrom(Object obj)
    {
        obj = ((WithPageView)obj.getClass().getAnnotation(com/shazam/android/annotation/analytics/WithPageView)).page();
        try
        {
            obj = (Page)((Class) (obj)).newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new SessionInitializationException("Could not create page from annotated class", ((Throwable) (obj)));
        }
        return ((Page) (obj));
    }
}
