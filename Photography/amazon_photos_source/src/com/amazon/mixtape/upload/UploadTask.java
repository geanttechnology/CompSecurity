// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.upload;

import android.content.Context;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.util.Log;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.exceptions.ConflictError;
import com.amazon.clouddrive.exceptions.Forbidden;
import com.amazon.clouddrive.exceptions.InvalidParameter;
import com.amazon.clouddrive.exceptions.RebuildRequestException;
import com.amazon.clouddrive.extended.AmazonCloudDriveExtended;
import com.amazon.clouddrive.extended.model.UploadFileExtendedResponse;
import com.amazon.clouddrive.internal.utils.ThreadUtil;
import com.amazon.clouddrive.model.Suppress;
import com.amazon.clouddrive.model.UploadFileRequest;
import com.amazon.mixtape.account.AccountContextFactory;
import com.amazon.mixtape.account.MetadataStore;
import com.amazon.mixtape.metrics.MixtapeMetricRecorder;
import com.amazon.mixtape.service.MetadataSyncException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.amazon.mixtape.upload:
//            UploadRequest, UploadEventCode, UploadProviderHelper, UploadErrorCode, 
//            MeasuredProgressListener

class UploadTask extends AsyncTask
{
    public static interface Listener
    {

        public abstract void onCancelled(UploadTask uploadtask);

        public abstract void onComplete(UploadTask uploadtask);

        public abstract void onProgress(UploadTask uploadtask, long l, long l1);

        public abstract void onRequestReevaluate(UploadTask uploadtask);

        public abstract void onRunning(UploadTask uploadtask);

        public abstract void onSidelined(UploadTask uploadtask, UploadErrorCode uploaderrorcode);

        public abstract void onSuccess(UploadTask uploadtask, UploadFileExtendedResponse uploadfileextendedresponse);
    }


    private static final String TAG = com/amazon/mixtape/upload/UploadTask.getSimpleName();
    private final AmazonCloudDriveExtended mAmazonCloudDriveExtended;
    private final Context mContext;
    private final Listener mListener;
    private final MixtapeMetricRecorder mMetricRecorder;
    private final UploadProviderHelper mUploadProviderHelper;
    private UploadRequest mUploadRequest;

    private void handleError(Exception exception, UploadErrorCode uploaderrorcode)
        throws RemoteException, OperationApplicationException
    {
        Log.e(TAG, (new StringBuilder()).append("Encountered : ").append(uploaderrorcode).append(" ").append(exception.getClass().getSimpleName()).toString());
        mUploadProviderHelper.logEvent(mContext, mUploadRequest.getAccountId(), mUploadRequest.getId(), UploadEventCode.ERROR, uploaderrorcode, exception.getMessage());
        mUploadRequest.setLastError(uploaderrorcode);
        int i = mUploadRequest.incrementRetryExceptions();
        if (i % 3 == 0)
        {
            mUploadRequest.setPriority(mUploadRequest.getPriority() + 1);
        }
        if (i >= 9)
        {
            mMetricRecorder.addMetric(new com.amazon.mixtape.metrics.MixtapeMetric.Event("UploadSidelined"));
            mUploadRequest.setState(UploadRequest.State.SIDELINED);
            exception = new HashSet(mUploadRequest.getBlockers());
            exception.add(MixtapeBlockers.RequestBlockers.RETRY_LIMIT.name());
            mUploadRequest.setBlockers(exception);
        } else
        {
            mUploadRequest.setState(UploadRequest.State.QUEUED);
        }
        saveUploadRequest();
        if (mUploadRequest.getState() == UploadRequest.State.QUEUED)
        {
            mListener.onCancelled(this);
        } else
        {
            mListener.onSidelined(this, uploaderrorcode);
        }
        mListener.onRequestReevaluate(this);
    }

    private void handleInterrupted()
        throws RemoteException, OperationApplicationException
    {
        Log.v(TAG, "Upload was interrupted");
        mListener.onCancelled(this);
        mUploadRequest.setState(UploadRequest.State.QUEUED);
        mUploadProviderHelper.writeUploadRequest(mContext, mUploadRequest);
        mUploadProviderHelper.logEvent(mContext, mUploadRequest.getAccountId(), mUploadRequest.getId(), UploadEventCode.INTERRUPTED, null, null);
        mMetricRecorder.addMetric(new com.amazon.mixtape.metrics.MixtapeMetric.Event("UploadInterrupted"));
    }

    private void handleRequest()
        throws Exception
    {
        try
        {
            ThreadUtil.checkIfInterrupted();
            mListener.onRunning(this);
            mUploadRequest.setAttempts(mUploadRequest.getAttempts() + 1);
            mUploadRequest.setState(UploadRequest.State.STARTED);
            saveUploadRequest();
            ThreadUtil.checkIfInterrupted();
            UploadFileExtendedResponse uploadfileextendedresponse = upload();
            persistResponse(uploadfileextendedresponse);
            mUploadRequest.setState(UploadRequest.State.DONE);
            saveUploadRequest();
            mListener.onSuccess(this, uploadfileextendedresponse);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            handleInterrupted();
            return;
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            handleSidelineError(filenotfoundexception, UploadErrorCode.FILE_NOT_FOUND_EXCEPTION, MixtapeBlockers.RequestBlockers.FILE_NOT_FOUND);
            return;
        }
        catch (ConflictError conflicterror)
        {
            handleSidelineError(conflicterror, UploadErrorCode.CONFLICT_EXCEPTION, MixtapeBlockers.RequestBlockers.CONFLICT);
            return;
        }
        catch (Forbidden forbidden)
        {
            if ("INSUFFICIENT_STORAGE".equals(forbidden.getCode()))
            {
                handleError(forbidden, UploadErrorCode.FORBIDDEN_INSUFFICIENT_STORAGE);
                return;
            }
            if ("NO_ACTIVE_SUBSCRIPTION_FOUND".equals(forbidden.getCode()))
            {
                handleError(forbidden, UploadErrorCode.FORBIDDEN_NO_ACTIVE_SUBSCRIPTION_FOUND);
                return;
            } else
            {
                handleSidelineError(forbidden, UploadErrorCode.FORBIDDEN, MixtapeBlockers.RequestBlockers.FORBIDDEN);
                return;
            }
        }
        catch (RebuildRequestException rebuildrequestexception)
        {
            handleError(rebuildrequestexception, UploadErrorCode.REBUILD_EXCEPTION);
            return;
        }
        catch (InvalidParameter invalidparameter)
        {
            handleSidelineError(invalidparameter, UploadErrorCode.INVALID_PARAMETER, MixtapeBlockers.RequestBlockers.INVALID_PARAMETER);
            return;
        }
        catch (CloudDriveException clouddriveexception)
        {
            handleError(clouddriveexception, UploadErrorCode.CLOUD_DRIVE_EXCEPTION);
            return;
        }
        catch (Exception exception)
        {
            handleError(exception, UploadErrorCode.UNKNOWN_EXCEPTION);
            mMetricRecorder.addMetric(new com.amazon.mixtape.metrics.MixtapeMetric.Event("UploadCrashed"));
            throw exception;
        }
    }

    private void handleSidelineError(Exception exception, UploadErrorCode uploaderrorcode, MixtapeBlockers.RequestBlockers requestblockers)
        throws RemoteException, OperationApplicationException
    {
        Log.e(TAG, (new StringBuilder()).append("Encountered : ").append(uploaderrorcode).append(" ").append(exception.getClass().getSimpleName()).toString());
        mUploadProviderHelper.logEvent(mContext, mUploadRequest.getAccountId(), mUploadRequest.getId(), UploadEventCode.ERROR, uploaderrorcode, exception.getMessage());
        mUploadRequest.setLastError(uploaderrorcode);
        mUploadRequest.setState(UploadRequest.State.SIDELINED);
        exception = new HashSet(mUploadRequest.getBlockers());
        exception.add(requestblockers.name());
        mUploadRequest.setBlockers(exception);
        saveUploadRequest();
        mListener.onSidelined(this, uploaderrorcode);
        mListener.onRequestReevaluate(this);
    }

    private void persistResponse(UploadFileExtendedResponse uploadfileextendedresponse)
    {
        MetadataStore metadatastore = AccountContextFactory.getContextForAccountId(mContext, mUploadRequest.getAccountId()).createMetadataStore(mUploadProviderHelper.getUploadProviderAuthority());
        metadatastore.saveNodes(Collections.singletonList(uploadfileextendedresponse));
        try
        {
            metadatastore.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (UploadFileExtendedResponse uploadfileextendedresponse)
        {
            return;
        }
        uploadfileextendedresponse;
        Log.e(TAG, "Failed to save upload response to metadata store.");
        try
        {
            metadatastore.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (UploadFileExtendedResponse uploadfileextendedresponse)
        {
            return;
        }
        uploadfileextendedresponse;
        try
        {
            metadatastore.close();
        }
        catch (IOException ioexception) { }
        throw uploadfileextendedresponse;
    }

    private void saveUploadRequest()
        throws RemoteException, OperationApplicationException
    {
        mUploadProviderHelper.writeUploadRequest(mContext, mUploadRequest);
    }

    private UploadFileExtendedResponse upload()
        throws CloudDriveException, FileNotFoundException, InterruptedException
    {
        Object obj;
        Object obj1;
        com.amazon.mixtape.metrics.MixtapeMetric.Counter counter;
        boolean flag;
        if (mUploadRequest.getName() != null)
        {
            obj = mUploadRequest.getName();
        } else
        {
            obj = mUploadRequest.getFileUri().getLastPathSegment();
        }
        obj1 = new File(mUploadRequest.getFileUri().getPath());
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj1 = (new UploadFileRequest(((String) (obj)), new FileInputStream(((File) (obj1))), mUploadRequest.getFileSize())).withKind("FILE").withChunkedStreaming(flag);
        if (mUploadRequest.getParentId() != null)
        {
            ((UploadFileRequest) (obj1)).withParents(Collections.singletonList(mUploadRequest.getParentId()));
        }
        if (mUploadRequest.getSuppressDeduplication())
        {
            ((UploadFileRequest) (obj1)).setSuppress(Suppress.Deduplication);
        }
        if (mUploadRequest.getRenameOnNameConflict())
        {
            ((UploadFileRequest) (obj1)).setConflictResolution("RENAME");
        }
        obj = new MeasuredProgressListener(this, mListener);
        obj1 = mAmazonCloudDriveExtended.uploadFileExtended(((UploadFileRequest) (obj1)), ((com.amazon.clouddrive.handlers.ProgressListener) (obj)));
        Log.v(TAG, "UploadRequest completed successfully.");
        mUploadProviderHelper.logEvent(mContext, mUploadRequest.getAccountId(), mUploadRequest.getId(), UploadEventCode.SUCCESS, null, null);
        mMetricRecorder.addMetric(new com.amazon.mixtape.metrics.MixtapeMetric.Event("UploadSucceeded"));
        counter = new com.amazon.mixtape.metrics.MixtapeMetric.Counter("RetriesPerUpload");
        counter.increment(mUploadRequest.getRetryExceptions());
        mMetricRecorder.addMetric(counter);
        counter = new com.amazon.mixtape.metrics.MixtapeMetric.Counter("UploadFileRate");
        counter.increment(Math.round(((MeasuredProgressListener) (obj)).getMeanBytesPerMillis()));
        mMetricRecorder.addMetric(counter);
        return ((UploadFileExtendedResponse) (obj1));
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            handleRequest();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            Log.e(TAG, (new StringBuilder()).append("UploadTask encountered an unexpected exception while processing request: #").append(mUploadRequest.getId()).append(".").toString(), avoid);
            mMetricRecorder.addMetric(new com.amazon.mixtape.metrics.MixtapeMetric.Event("UploadCrashed"));
        }
        return null;
    }

    protected void onCancelled()
    {
        mListener.onCancelled(this);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        mListener.onComplete(this);
    }

}
