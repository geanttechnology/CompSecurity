// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import com.groupon.models.qadiscussions.QaDiscussionPaginationWrapper;
import java.util.List;

// Referenced classes of package com.groupon.callbacks:
//            QandARequestCallback

public abstract class DefaultQandARequestCallback
    implements QandARequestCallback
{

    public DefaultQandARequestCallback()
    {
    }

    public void onCancel()
    {
    }

    public void onDiscussionsSuccess(QaDiscussionPaginationWrapper qadiscussionpaginationwrapper)
    {
    }

    public void onException(Exception exception)
    {
    }

    public void onFinally()
    {
    }

    public void onPostsSuccess(List list)
    {
    }
}
