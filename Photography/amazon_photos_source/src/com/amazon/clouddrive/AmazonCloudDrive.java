// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive;

import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.ListNodesRequest;
import com.amazon.clouddrive.model.ListNodesResponse;

public interface AmazonCloudDrive
{

    public abstract ListNodesResponse listNodes(ListNodesRequest listnodesrequest)
        throws CloudDriveException, InterruptedException;
}
