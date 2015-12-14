// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.handlers;

import com.amazon.clouddrive.model.CloudDriveRequest;

public interface AsyncHandler
{

    public abstract void onCanceled(CloudDriveRequest clouddriverequest);

    public abstract void onError(CloudDriveRequest clouddriverequest, Exception exception);

    public abstract void onSuccess(CloudDriveRequest clouddriverequest, Object obj);
}
