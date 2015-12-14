// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.upload;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.amazon.mixtape.metrics.MixtapeMetricRecorder;
import com.amazon.mixtape.utils.Lazy;

// Referenced classes of package com.amazon.mixtape.upload:
//            UploadEventCode, UploadErrorCode, UploadRequest

class UploadProviderHelper
{

    private static final String TAG = com/amazon/mixtape/upload/UploadProviderHelper.getSimpleName();
    private final Lazy mMetricRecorder;
    private String mUploadProviderAuthority;

    public String getUploadProviderAuthority()
    {
        return mUploadProviderAuthority;
    }

    void logEvent(Context context, String s, int i, UploadEventCode uploadeventcode, UploadErrorCode uploaderrorcode, String s1)
    {
        s = com.amazon.mixtape.provider.UploadContract.LogEntry.getContentUri(mUploadProviderAuthority, s);
        ContentValues contentvalues = new ContentValues();
        if (uploadeventcode != null)
        {
            contentvalues.put(com.amazon.mixtape.provider.UploadContract.LogEntry.EVENT, Integer.valueOf(uploadeventcode.toInt()));
        }
        if (uploaderrorcode != null)
        {
            contentvalues.put(com.amazon.mixtape.provider.UploadContract.LogEntry.ERROR, Integer.valueOf(uploaderrorcode.toInt()));
        }
        contentvalues.put(com.amazon.mixtape.provider.UploadContract.LogEntry.MESSAGE, s1);
        contentvalues.put(com.amazon.mixtape.provider.UploadContract.LogEntry.UPLOAD_REQUEST, Integer.valueOf(i));
        contentvalues.put(com.amazon.mixtape.provider.UploadContract.LogEntry.TIME, Long.valueOf(System.currentTimeMillis()));
        context.getContentResolver().insert(s, contentvalues);
    }

    void writeUploadRequest(Context context, UploadRequest uploadrequest)
        throws RemoteException, OperationApplicationException
    {
        com.amazon.mixtape.metrics.MixtapeMetric.Event event = new com.amazon.mixtape.metrics.MixtapeMetric.Event("UploadRequested");
        context.getContentResolver().applyBatch(mUploadProviderAuthority, uploadrequest.getWriteOperations(mUploadProviderAuthority));
        ((MixtapeMetricRecorder)mMetricRecorder.get()).addMetric(event);
        return;
        context;
        ((MixtapeMetricRecorder)mMetricRecorder.get()).addMetric(event);
        throw context;
    }

}
