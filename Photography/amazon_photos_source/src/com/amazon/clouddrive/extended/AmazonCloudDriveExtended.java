// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended;

import com.amazon.clouddrive.AmazonCloudDrive;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.model.GetChangesExtendedResponse;
import com.amazon.clouddrive.extended.model.ListNodesExtendedResponse;
import com.amazon.clouddrive.extended.model.UploadFileExtendedResponse;
import com.amazon.clouddrive.handlers.ProgressListener;
import com.amazon.clouddrive.model.GetChangesRequest;
import com.amazon.clouddrive.model.ListNodesRequest;
import com.amazon.clouddrive.model.UploadFileRequest;

public interface AmazonCloudDriveExtended
    extends AmazonCloudDrive
{

    public abstract GetChangesExtendedResponse getChangesExtended(GetChangesRequest getchangesrequest)
        throws CloudDriveException, InterruptedException;

    public abstract ListNodesExtendedResponse listNodesExtended(ListNodesRequest listnodesrequest)
        throws CloudDriveException, InterruptedException;

    public abstract UploadFileExtendedResponse uploadFileExtended(UploadFileRequest uploadfilerequest, ProgressListener progresslistener)
        throws CloudDriveException, InterruptedException;
}
