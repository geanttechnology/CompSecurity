// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;

import com.amazon.clouddrive.model.CloudDriveRequest;
import java.util.List;

public interface BulkAddRemoveRequest
    extends CloudDriveRequest
{

    public abstract List getNodeIds();

    public abstract String getOp();

    public abstract String getResourceVersion();
}
