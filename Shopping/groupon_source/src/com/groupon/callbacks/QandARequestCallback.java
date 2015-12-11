// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import com.groupon.models.qadiscussions.QaDiscussionPaginationWrapper;
import java.util.List;

public interface QandARequestCallback
{

    public abstract void onCancel();

    public abstract void onDiscussionsSuccess(QaDiscussionPaginationWrapper qadiscussionpaginationwrapper);

    public abstract void onException(Exception exception);

    public abstract void onFinally();

    public abstract void onPostsSuccess(List list);
}
