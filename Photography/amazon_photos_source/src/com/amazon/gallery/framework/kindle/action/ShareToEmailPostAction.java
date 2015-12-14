// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.gallery.actions.PostShareAction;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.ParentalControl;

public class ShareToEmailPostAction
    implements PostShareAction
{

    private final Activity activity;

    public ShareToEmailPostAction(Activity activity1)
    {
        activity = activity1;
    }

    public void onShareFailed(Exception exception)
    {
        if (exception instanceof ActivityNotFoundException)
        {
            exception = (ParentalControl)((BeanAwareActivity)activity).getApplicationBean(Keys.PARENTAL_CONTROL);
            if (exception.isMessagingBlocked(activity))
            {
                exception.promptMessagingBlocked(activity);
            }
        }
    }

    public void onShareSuccess()
    {
    }
}
