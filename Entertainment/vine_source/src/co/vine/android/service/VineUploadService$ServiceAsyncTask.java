// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import co.vine.android.VineLoggingException;
import co.vine.android.api.VineUpload;
import co.vine.android.recorder.HashAsyncTask;
import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.UploadManager;
import com.edisonwang.android.slog.SLog;
import java.io.File;

// Referenced classes of package co.vine.android.service:
//            VineUploadService, VineServiceConnection, UploadProgressListener

public class mIsPrivate extends AsyncTask
{

    public final String action;
    public final long conversationRowId;
    private int mExecutionStatus;
    private boolean mIsDiscarded;
    private boolean mIsPrivate;
    private boolean mIsRetry;
    private UploadProgressListener mListener;
    public VineUpload mUpload;
    public final String path;
    final VineUploadService this$0;
    public final String thumbnail;

    private void onComplete()
    {
        co/vine/android/service/VineUploadService;
        JVM INSTR monitorenter ;
        VineUploadService.access$400(VineUploadService.this, 1);
        VineUploadService.access$202(VineUploadService.this, null);
        Intent intent = new Intent("co.vine.android.UPLOAD_RESULT");
        intent.putExtra("upload_status", mExecutionStatus);
        intent.putExtra("path", path);
        intent.putExtra("thumbnail", thumbnail);
        sendBroadcast(intent, "co.vine.android.BROADCAST");
        VineUploadService.access$1200(VineUploadService.this);
        co/vine/android/service/VineUploadService;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        co/vine/android/service/VineUploadService;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected transient Boolean doInBackground(Void avoid[])
    {
        co/vine/android/service/VineUploadService$ServiceAsyncTask;
        JVM INSTR monitorenter ;
        if (mUpload == null)
        {
            mUpload = UploadManager.getUpload(getContext(), path);
        }
        if (mUpload != null && mUpload.status != -1)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        co/vine/android/service/VineUploadService$ServiceAsyncTask;
        JVM INSTR monitorexit ;
        return Boolean.valueOf(false);
        if (!"bPost".equals(action))
        {
            break MISSING_BLOCK_LABEL_134;
        }
        avoid = new Bundle();
        avoid.putParcelable("upload", mUpload);
        VineUploadService.access$800(VineUploadService.this).queueAndExecute(98, avoid);
        if (!mIsRetry && mListener != null)
        {
            mListener.showPostNotification(thumbnail);
        }
        co/vine/android/service/VineUploadService$ServiceAsyncTask;
        JVM INSTR monitorexit ;
        return Boolean.valueOf(true);
        avoid;
        co/vine/android/service/VineUploadService$ServiceAsyncTask;
        JVM INSTR monitorexit ;
        throw avoid;
        String s;
        String s1;
        if (!"aUpload".equals(action))
        {
            break MISSING_BLOCK_LABEL_450;
        }
        avoid = new File(path);
        if (!avoid.exists())
        {
            break MISSING_BLOCK_LABEL_244;
        }
        s = HashAsyncTask.getMD5Checksum(path);
        s1 = mUpload.hash;
        if (s.equals(s1))
        {
            break MISSING_BLOCK_LABEL_244;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        if (s1.length() == 0)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        SLog.e("Invalid hash: actual {}, expected {}.", s, s1);
        co/vine/android/service/VineUploadService$ServiceAsyncTask;
        JVM INSTR monitorexit ;
        return Boolean.valueOf(false);
        CrashUtil.logException(new VineLoggingException((new StringBuilder()).append("Expected hash was invalid: ").append(s1).toString()));
        co.vine.android.recorder.RecordSessionVersion recordsessionversion = UploadManager.getVersionFromPath(path);
        String s2 = avoid.getAbsolutePath();
        if (mListener != null)
        {
            mListener.size = avoid.length() + (new File(thumbnail)).length();
        }
        avoid = VineUploadService.access$900(VineUploadService.this).upload(this, mListener, s2, thumbnail, path, mIsPrivate, recordsessionversion);
        if (!isCancelled())
        {
            break MISSING_BLOCK_LABEL_335;
        }
        co/vine/android/service/VineUploadService$ServiceAsyncTask;
        JVM INSTR monitorexit ;
        return Boolean.valueOf(false);
        if (avoid == null)
        {
            break MISSING_BLOCK_LABEL_418;
        }
        UploadManager.setUploadTime(getContext(), mUpload);
        UploadManager.setUris(getContext(), mUpload, avoid);
        UploadManager.setStatus(getContext(), mUpload, 1);
        if (!TextUtils.isEmpty(mUpload.postInfo))
        {
            startService(VineUploadService.getPostIntent(getContext(), mUpload, mIsRetry));
        }
        co/vine/android/service/VineUploadService$ServiceAsyncTask;
        JVM INSTR monitorexit ;
        return Boolean.valueOf(true);
        SLog.d("Current status: {}", Integer.valueOf(mUpload.status));
        co/vine/android/service/VineUploadService$ServiceAsyncTask;
        JVM INSTR monitorexit ;
        return Boolean.valueOf(false);
        avoid;
        SLog.e("Failed to upload.", avoid);
        co/vine/android/service/VineUploadService$ServiceAsyncTask;
        JVM INSTR monitorexit ;
        return Boolean.valueOf(false);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof doInBackground))
            {
                return false;
            }
            obj = (doInBackground)obj;
            if (path == null ? ((path) (obj)).path != null : !path.equals(((path) (obj)).path))
            {
                return false;
            }
            if (action == null ? ((action) (obj)).action != null : !action.equals(((action) (obj)).action))
            {
                return false;
            }
        }
        return true;
    }

    public Context getContext()
    {
        return VineUploadService.this;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (path != null)
        {
            i = path.hashCode();
        } else
        {
            i = 0;
        }
        if (action != null)
        {
            j = action.hashCode();
        }
        return i * 31 + j;
    }

    protected void onCancelled()
    {
        SLog.d("Task cancelled. {}, {}.", path, action);
        if (!mIsDiscarded)
        {
            VineUploadService.access$1100(VineUploadService.this, path);
        }
        onComplete();
    }

    protected void onPostExecute(Boolean boolean1)
    {
        boolean flag = boolean1.booleanValue();
        if (mIsDiscarded) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        mExecutionStatus = 2;
        if ("aUpload".equals(action) && TextUtils.isEmpty(mUpload.postInfo))
        {
            mExecutionStatus = 3;
        }
_L6:
        onComplete();
_L2:
        return;
_L4:
        mExecutionStatus = 1;
        boolean1 = VineUploadService.getNotifyFailedIntent(getContext());
        if (boolean1 != null)
        {
            startService(boolean1);
            if (mUpload != null)
            {
                UploadManager.setStatus(getContext(), mUpload, 2, null);
                if ("aUpload".equals(action) && mUpload.isPrivate)
                {
                    VineUploadService.access$1000(VineUploadService.this, mUpload.path);
                }
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    public void setIsDiscarded(boolean flag)
    {
        mIsDiscarded = flag;
    }

    public (String s, String s1, Intent intent, UploadProgressListener uploadprogresslistener)
    {
        this$0 = VineUploadService.this;
        super();
        path = s;
        action = s1;
        conversationRowId = intent.getLongExtra("conversation_row_id", -1L);
        mListener = uploadprogresslistener;
        thumbnail = RecordConfigUtils.getThumbnailPath(s);
        mIsRetry = intent.getBooleanExtra("is_retry", false);
        mIsPrivate = intent.getBooleanExtra("is_private", false);
    }
}
