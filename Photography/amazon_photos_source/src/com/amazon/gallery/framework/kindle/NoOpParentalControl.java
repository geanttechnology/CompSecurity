// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.app.Activity;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            ParentalControl

public class NoOpParentalControl
    implements ParentalControl
{

    public NoOpParentalControl()
    {
    }

    public boolean isBlocked(Activity activity)
    {
        return false;
    }

    public boolean isMessagingBlocked(Activity activity)
    {
        return false;
    }

    public boolean isSocialNetworkingBlocked(Activity activity)
    {
        return false;
    }

    public void promptAndFinish(Activity activity)
    {
    }

    public void promptMessagingBlocked(Activity activity)
    {
    }

    public void promptSocialNetworkingBlocked(Activity activity)
    {
    }
}
