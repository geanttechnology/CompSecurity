// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session;

import com.shazam.android.analytics.session.exception.SessionInitializationException;
import com.shazam.android.annotation.analytics.WithPageView;

// Referenced classes of package com.shazam.android.analytics.session:
//            SessionCancellationPolicy

public class AnnotatedSessionCancellationPolicy
    implements SessionCancellationPolicy
{

    private static final String ERROR_MESSAGE = "Session annotated object %s specified a cancelable session but did not implement %s";

    public AnnotatedSessionCancellationPolicy()
    {
    }

    public boolean isSessionCanceled(Object obj)
    {
        if (((WithPageView)obj.getClass().getAnnotation(com/shazam/android/annotation/analytics/WithPageView)).cancelable())
        {
            if (obj instanceof SessionCancellationPolicy)
            {
                return ((SessionCancellationPolicy)obj).isSessionCanceled(obj);
            } else
            {
                throw new SessionInitializationException(String.format("Session annotated object %s specified a cancelable session but did not implement %s", new Object[] {
                    obj.toString(), com/shazam/android/analytics/session/SessionCancellationPolicy.toString()
                }));
            }
        } else
        {
            return false;
        }
    }
}
