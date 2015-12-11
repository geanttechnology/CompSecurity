// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import co.vine.android.StartActivity;
import co.vine.android.VineLoggingException;
import co.vine.android.api.VineUpload;
import co.vine.android.client.AppController;
import co.vine.android.client.Session;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.recorder.HashAsyncTask;
import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.recorder.RecordSessionVersion;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.UploadManager;
import co.vine.android.util.Util;
import co.vine.android.util.VineProgressEvent;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

// Referenced classes of package co.vine.android.service:
//            VineServiceConnection, VineService, UploadProgressListener

public class VineUploadService extends Service
    implements VineServiceConnection.ServiceResponseHandler
{
    public class IPCProgressListener extends UploadProgressListener
    {

        public static final double PROGRESS_RATIO_TRANSCODE = 0.65000000000000002D;
        public static final double PROGRESS_RATIO_UPLOAD = 0.33000000000000002D;
        final VineUploadService this$0;

        private void sendMessageToActivity(Message message)
        {
            try
            {
                VineUploadService.sUploadResultReceiver.send(message);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                return;
            }
        }

        public void onPostFinished(boolean flag)
        {
            Bundle bundle = new Bundle();
            if (VineUploadService.sUploadResultReceiver != null)
            {
                bundle.putBoolean("success", flag);
                sendMessageToActivity(Message.obtain(null, 7, bundle));
                if (!flag)
                {
                    bundle.putDouble("upload_progress", 0.0D);
                    sendMessageToActivity(Message.obtain(null, 6, bundle));
                }
            }
        }

        public void onTranscodeStarted()
        {
            if (VineUploadService.sUploadResultReceiver != null)
            {
                sendMessageToActivity(Message.obtain(null, 4));
            }
        }

        public void progressChanged(VineProgressEvent vineprogressevent)
        {
            currentSize = currentSize + (long)vineprogressevent.getBytesTransfered();
            int i = (int)((currentSize * 100L) / size);
            if (VineUploadService.sUploadResultReceiver != null && Math.abs(lastProgress - i) > 2)
            {
                lastProgress = i;
                vineprogressevent = new Bundle();
                vineprogressevent.putDouble("upload_progress", i);
                sendMessageToActivity(Message.obtain(null, 6, vineprogressevent));
            }
        }

        public void updateTranscodeProgress(int i)
        {
            if (VineUploadService.sUploadResultReceiver != null && Math.abs(lastProgress - i) > 2)
            {
                lastProgress = i;
                Bundle bundle = new Bundle();
                bundle.putDouble("transcode_progress", i);
                sendMessageToActivity(Message.obtain(null, 5, bundle));
            }
        }

        public IPCProgressListener(String s)
        {
            this$0 = VineUploadService.this;
            super(s);
        }
    }

    private class IncomingHandler extends Handler
    {

        final VineUploadService this$0;

        public void handleMessage(Message message)
        {
            SLog.dWithTag("VineUploadService", (new StringBuilder()).append("Message received, what=").append(message.what).append(", replyTo=").append(message.replyTo).toString());
            message.what;
            JVM INSTR tableswitch 1 2: default 64
        //                       1 65
        //                       2 168;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            if ((message = message.replyTo) != null)
            {
                VineUploadService.sUploadResultReceiver = message;
                Bundle bundle = new Bundle();
                ServiceAsyncTask serviceasynctask = mCurrentTask;
                if (serviceasynctask != null)
                {
                    bundle.putLong("conversation_row_id", serviceasynctask.conversationRowId);
                    bundle.putString("thumbnail", serviceasynctask.thumbnail);
                    boolean flag;
                    if (!android.os.AsyncTask.Status.FINISHED.equals(serviceasynctask.getStatus()))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    bundle.putBoolean("is_active", flag);
                }
                try
                {
                    message.send(Message.obtain(null, 3, bundle));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    SLog.e("Failed to reply.", message);
                }
                return;
            }
              goto _L1
_L3:
            VineUploadService.sUploadResultReceiver = null;
            return;
        }

        private IncomingHandler()
        {
            this$0 = VineUploadService.this;
            super();
        }

    }

    private class NotificationProgressListener extends UploadProgressListener
    {

        final VineUploadService this$0;

        private void updateNotification(String s, int i, int j, boolean flag)
        {
            SLog.d("Update notification: {}, {}.", Boolean.valueOf(flag), Integer.valueOf(lastProgress));
            android.support.v4.app.NotificationCompat.Builder builder = new android.support.v4.app.NotificationCompat.Builder(VineUploadService.this);
            builder.setLargeIcon(setScaledNotificationIcon(s));
            builder.setSmallIcon(0x7f0201ff);
            builder.setContentTitle(getText(i));
            builder.setContentText(getText(j));
            builder.setWhen(0L);
            builder.setOngoing(true);
            if (flag)
            {
                if (lastProgress > 0)
                {
                    builder.setProgress(100, lastProgress, false);
                } else
                {
                    builder.setProgress(0, 0, true);
                }
            } else
            {
                builder.setProgress(0, 0, true);
            }
            showNotification(builder, 1);
        }

        private void updateTranscodeNotification(String s)
        {
            updateNotification(s, 0x7f0e0184, 0x7f0e0185, true);
        }

        private void updateUploadNotification(String s)
        {
            updateNotification(s, 0x7f0e0261, 0x7f0e0262, true);
        }

        public void onPostFinished(boolean flag)
        {
            clearNotification(1);
            if (flag)
            {
                cancelFailedNofitication();
            }
        }

        public void onTranscodeStarted()
        {
        }

        public void progressChanged(VineProgressEvent vineprogressevent)
        {
            currentSize = currentSize + (long)vineprogressevent.getBytesTransfered();
            int i = (int)((currentSize * 100L) / size);
            if (Math.abs(lastProgress - i) > 2)
            {
                lastProgress = i;
                updateUploadNotification(thumbnail);
            }
        }

        public void showPostNotification(String s)
        {
            updateNotification(s, 0x7f0e0183, 0x7f0e0049, true);
        }

        public void updateTranscodeProgress(int i)
        {
            if (Math.abs(lastProgress - i) > 2)
            {
                lastProgress = i;
                updateTranscodeNotification(thumbnail);
            }
        }

        public NotificationProgressListener(String s)
        {
            this$0 = VineUploadService.this;
            super(s);
        }
    }

    public class ServiceAsyncTask extends AsyncTask
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
            clearNotification(1);
            mCurrentTask = null;
            Intent intent = new Intent("co.vine.android.UPLOAD_RESULT");
            intent.putExtra("upload_status", mExecutionStatus);
            intent.putExtra("path", path);
            intent.putExtra("thumbnail", thumbnail);
            sendBroadcast(intent, "co.vine.android.BROADCAST");
            executeNext();
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
            mVineServiceConnection.queueAndExecute(98, avoid);
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
            RecordSessionVersion recordsessionversion = UploadManager.getVersionFromPath(path);
            String s2 = avoid.getAbsolutePath();
            if (mListener != null)
            {
                mListener.size = avoid.length() + (new File(thumbnail)).length();
            }
            avoid = mUploadManager.upload(this, mListener, s2, thumbnail, path, mIsPrivate, recordsessionversion);
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
                if (!(obj instanceof ServiceAsyncTask))
                {
                    return false;
                }
                obj = (ServiceAsyncTask)obj;
                if (path == null ? ((ServiceAsyncTask) (obj)).path != null : !path.equals(((ServiceAsyncTask) (obj)).path))
                {
                    return false;
                }
                if (action == null ? ((ServiceAsyncTask) (obj)).action != null : !action.equals(((ServiceAsyncTask) (obj)).action))
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
                discardUpload(path);
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
                        markPreMergedMessageAsUploadFailed(mUpload.path);
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

        public ServiceAsyncTask(String s, String s1, Intent intent, UploadProgressListener uploadprogresslistener)
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

    public class SessionChangedReceiver extends BroadcastReceiver
    {

        final VineUploadService this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (intent != null && ("co.vine.android.session.logout".equals(intent.getAction()) || "co.vine.android.session.login".equals(intent.getAction())))
            {
                VineAccountHelper.resetActiveSession();
            }
        }

        public SessionChangedReceiver()
        {
            this$0 = VineUploadService.this;
            super();
        }
    }


    public static final String ACTION_CLEAR_NOTIFICATIONS = "clear_notifications";
    public static final String ACTION_DISCARD = "discard";
    public static final String ACTION_DISCARD_ALL = "discard_all";
    public static final String ACTION_DRAFT_UPGRADE_COUNT = "action_get_draft_count";
    public static final String ACTION_NOTIFY_FAILED = "cNotify";
    public static final String ACTION_POST = "bPost";
    public static final String ACTION_PREMERGE_AND_POST = "bMergeAndPost";
    public static final String ACTION_SHOW_NOTIFICATIONS = "show_notifications";
    public static final String ACTION_UPLOAD = "aUpload";
    public static final String ACTION_UPLOAD_RESULT = "co.vine.android.UPLOAD_RESULT";
    public static final String AG_CHANNEL_ID = "channelId";
    public static final String AG_CONVERSATION_ROW_ID = "conversation_row_id";
    public static final String AG_DESCRIPTION = "description";
    public static final String AG_ENTITIES = "entities";
    public static final String AG_HASH = "hash";
    public static final String AG_IS_PRIVATE = "is_private";
    public static final String AG_MAX_LOOPS = "maxLoops";
    public static final String AG_MESSAGE = "message";
    public static final String AG_MESSAGE_ROW_ID = "message_row_id";
    public static final String AG_PATH = "path";
    public static final String AG_POST_ID = "postId";
    public static final String AG_POST_TO_FACEBOOK = "postToFacebook";
    public static final String AG_POST_TO_TWITTER = "postToTwitter";
    public static final String AG_RECIPIENTS = "recipients";
    public static final String AG_REFERENCE = "reference";
    public static final String AG_SHOW_NOTIFICATIONS = "show_notifications";
    public static final String AG_THUMBNAIL = "thumbnail";
    public static final String AG_THUMB_URL = "thumbUrl";
    public static final String AG_TIMESTAMP = "created";
    public static final String AG_UPLOAD = "upload";
    public static final String AG_UPLOAD_RESULT = "upload_status";
    public static final String AG_VIDEO_URL = "videoUrl";
    public static final String EXTRA_IS_ACTIVE = "is_active";
    public static final String EXTRA_SUCCESS = "success";
    public static final String EXTRA_TRANSCODE_PROGRESS = "transcode_progress";
    public static final String EXTRA_UPLOAD_PROGRESS = "upload_progress";
    private static final int MAX_BITMAP_SIZE = 10;
    public static final int MESSAGE_COUNT_UPDATE = 8;
    public static final int MESSAGE_POST_FINISHED = 7;
    public static final int MESSAGE_RESULT_RECEIVER_WAS_SET = 3;
    public static final int MESSAGE_SET_RESULT_RECEIVER = 1;
    public static final int MESSAGE_TRANSCODE_PROGRESS_CHANGED = 5;
    public static final int MESSAGE_TRANSCODE_STARTED = 4;
    public static final int MESSAGE_UNSET_DRAFT_RECEIVER = 9;
    public static final int MESSAGE_UNSET_RESULT_RECEIVER = 2;
    public static final int MESSAGE_UPLOAD_PROGRESS_CHANGED = 6;
    private static final int NOTIFICATION_FAILED_ID = 0;
    private static final int NOTIFICATION_PROGRESS_ID = 1;
    private static final String NOTIFICATION_TAG = "upload_notification";
    public static final int RESULT_NEED_POST_INFO = 3;
    public static final int RESULT_STATUS_FAILED = 1;
    public static final int RESULT_STATUS_SUCCEEDED = 2;
    public static final int RESULT_STATUS_UPLOADING = 0;
    private static final int SMALL_ICON = 0x7f0201ff;
    private static final String TAG = "VineUploadService";
    private static boolean sShowProgress;
    private static Messenger sUploadResultReceiver;
    private HashMap mBitmaps;
    private ServiceAsyncTask mCurrentTask;
    private Bitmap mDefaultNotificationIcon;
    private boolean mIsBinded;
    private final int mLock[] = new int[0];
    private Messenger mMessenger;
    private NotificationManager mNotificationManager;
    private int mNotificationPanelSize;
    private LinkedHashSet mPendingTasks;
    private LinkedHashSet mPendingVMTasks;
    private SessionChangedReceiver mSessionChangedReceiver;
    private LinkedList mStartIds;
    private UploadManager mUploadManager;
    private VineServiceConnection mVineServiceConnection;

    public VineUploadService()
    {
        mNotificationPanelSize = -1;
        mVineServiceConnection = new VineServiceConnection(this, this);
    }

    private void cancelFailedNofitication()
    {
        this;
        JVM INSTR monitorenter ;
        if (UploadManager.uploadListIsEmpty(this))
        {
            clearNotification(0);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void clearNotification(int i)
    {
        this;
        JVM INSTR monitorenter ;
        mNotificationManager.cancel("upload_notification", i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void discardTask(String s)
    {
        SLog.d("Discard task for path={}", s);
        Object obj = mCurrentTask;
        if (obj != null && TextUtils.equals(((ServiceAsyncTask) (obj)).path, s))
        {
            ((ServiceAsyncTask) (obj)).setIsDiscarded(true);
            ((ServiceAsyncTask) (obj)).cancel(true);
            SLog.d("In-progress task has been cancelled, path={}", s);
        }
        obj = new ArrayList();
        Iterator iterator = mPendingTasks.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ServiceAsyncTask serviceasynctask = (ServiceAsyncTask)iterator.next();
            if (serviceasynctask != null && TextUtils.equals(serviceasynctask.path, s))
            {
                ((ArrayList) (obj)).add(serviceasynctask);
            }
        } while (true);
        iterator = mPendingVMTasks.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ServiceAsyncTask serviceasynctask1 = (ServiceAsyncTask)iterator.next();
            if (serviceasynctask1 != null && TextUtils.equals(serviceasynctask1.path, s))
            {
                ((ArrayList) (obj)).add(serviceasynctask1);
            }
        } while (true);
        if (!((ArrayList) (obj)).isEmpty())
        {
            SLog.d("Queued task(s) will be cancelled.");
            mPendingTasks.removeAll(((java.util.Collection) (obj)));
            mPendingVMTasks.removeAll(((java.util.Collection) (obj)));
        }
        discardUpload(s);
    }

    private void discardUpload(String s)
    {
        SLog.d("Discard video: {}", Boolean.valueOf((new File(s)).delete()));
        SLog.d("Discard encoded video: {}", Boolean.valueOf((new File((new StringBuilder()).append(s).append(UploadManager.getVersionFromPath(s).videoOutputExtension).toString())).delete()));
        SLog.d("Discard thumbnail: {}", Boolean.valueOf((new File(RecordConfigUtils.getThumbnailPath(s))).delete()));
        UploadManager.deleteUploadRecord(this, s);
        cancelFailedNofitication();
    }

    private void executeNext()
    {
        SLog.d("Pending tasks: {}", mPendingTasks);
        SLog.d("Pending vm tasks: {}", mPendingVMTasks);
        if (mCurrentTask != null)
        {
            SLog.d("mCurrentTask is not null, will not execute next");
            return;
        }
        int ai[] = mLock;
        ai;
        JVM INSTR monitorenter ;
        if (mPendingVMTasks.isEmpty()) goto _L2; else goto _L1
_L1:
        Object obj = mPendingVMTasks;
_L3:
        if (((LinkedHashSet) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_136;
        }
        obj = ((LinkedHashSet) (obj)).iterator();
        ServiceAsyncTask serviceasynctask = (ServiceAsyncTask)((Iterator) (obj)).next();
        if (!isRunning(serviceasynctask))
        {
            serviceasynctask.execute(new Void[0]);
            SLog.d("Started executing task: action={}, path={}", serviceasynctask.action, serviceasynctask.path);
        }
        mCurrentTask = serviceasynctask;
        ((Iterator) (obj)).remove();
_L4:
        return;
        obj;
        ai;
        JVM INSTR monitorexit ;
        throw obj;
_L2:
        obj = mPendingTasks;
          goto _L3
        (new Handler()).post(new Runnable() {

            final VineUploadService this$0;

            public void run()
            {
                stopIfNoTasksLeft();
            }

            
            {
                this$0 = VineUploadService.this;
                super();
            }
        });
          goto _L4
    }

    public static Intent getClearNotificationsIntent(Context context)
    {
        context = new Intent(context, co/vine/android/service/VineUploadService);
        context.setAction("clear_notifications");
        return context;
    }

    public static Intent getDiscardAllIntent(Context context)
    {
        context = new Intent(context, co/vine/android/service/VineUploadService);
        context.setAction("discard_all");
        return context;
    }

    public static Intent getDiscardIntent(Context context, String s)
    {
        context = new Intent(context, co/vine/android/service/VineUploadService);
        context.setAction("discard");
        context.putExtra("path", s);
        return context;
    }

    public static Intent getNotifyFailedIntent(Context context)
    {
        Object obj = null;
        String s = null;
        String s1 = null;
        long l = AppController.getInstance(context).getActiveSessionReadOnly().getUserId();
        Object obj1 = ContentUris.withAppendedId(co.vine.android.provider.VineUploads.Uploads.CONTENT_URI, l);
        obj1 = context.getContentResolver().query(((android.net.Uri) (obj1)), co.vine.android.provider.VineUploadsDatabaseSQL.UploadsQuery.PROJECTION, "status=? AND is_private=?", new String[] {
            String.valueOf(2), "0"
        }, "_id ASC");
        if (obj1 != null)
        {
            s = obj;
            if (((Cursor) (obj1)).moveToFirst())
            {
                do
                {
                    s = ((Cursor) (obj1)).getString(1);
                    if (UploadManager.getVersionFromPath(s) == RecordSessionVersion.SW_MP4)
                    {
                        UploadManager.removeFromUploadQueue(context, s1);
                        s = s1;
                    }
                    s1 = s;
                } while (((Cursor) (obj1)).moveToNext());
            }
            ((Cursor) (obj1)).close();
        }
        if (s != null)
        {
            context = new Intent(context, co/vine/android/service/VineUploadService);
            context.setAction("cNotify");
            context.putExtra("path", s);
            return context;
        } else
        {
            return null;
        }
    }

    public static Intent getPostIntent(Context context, VineUpload vineupload, boolean flag)
    {
        if (!TextUtils.isEmpty(vineupload.postInfo))
        {
            co.vine.android.api.VineUpload.PostInfo postinfo = co.vine.android.api.VineUpload.PostInfo.fromJsonString(vineupload.postInfo);
            context = getPostIntent(context, vineupload.path, postinfo.caption, postinfo.postToTwitter, postinfo.postToFacebook, postinfo.channelId, flag, postinfo.entities, postinfo.recipients, postinfo.message, vineupload.conversationRowId, postinfo.maxLoops);
            context.putExtra("upload", vineupload);
            return context;
        } else
        {
            return null;
        }
    }

    public static Intent getPostIntent(Context context, String s, String s1, boolean flag, boolean flag1, long l, boolean flag2, 
            ArrayList arraylist, ArrayList arraylist1, String s2, long l1, int i)
    {
        context = new Intent(context, co/vine/android/service/VineUploadService);
        context.setAction("bPost");
        context.putExtra("is_retry", flag2);
        context.putExtra("path", s);
        context.putExtra("description", s1);
        context.putExtra("postToTwitter", flag);
        context.putExtra("postToFacebook", flag1);
        context.putExtra("channelId", l);
        context.putExtra("entities", arraylist);
        context.putExtra("recipients", arraylist1);
        context.putExtra("message", s2);
        context.putExtra("created", System.currentTimeMillis());
        context.putExtra("conversation_row_id", l1);
        context.putExtra("maxLoops", i);
        return context;
    }

    public static Intent getShowProgressIntent(Context context)
    {
        context = new Intent(context, co/vine/android/service/VineUploadService);
        context.setAction("show_notifications");
        return context;
    }

    public static Intent getUploadIntent(Context context, String s, String s1, String s2, String s3, boolean flag, long l)
    {
        sShowProgress = false;
        context = new Intent(context, co/vine/android/service/VineUploadService);
        context.setAction("aUpload");
        context.putExtra("path", s);
        context.putExtra("hash", s1);
        context.putExtra("thumbnail", s2);
        context.putExtra("reference", s3);
        context.putExtra("is_private", flag);
        context.putExtra("show_notifications", true);
        context.putExtra("conversation_row_id", l);
        return context;
    }

    public static Intent getVMPostIntent(Context context, String s, boolean flag, long l, long l1, ArrayList arraylist, 
            String s1, long l2, String s2, String s3, int i)
    {
        context = new Intent(context, co/vine/android/service/VineUploadService);
        if (flag)
        {
            context.setAction("bPost");
            if (TextUtils.isEmpty(s))
            {
                VineUpload vineupload = new VineUpload();
                vineupload.mergedMessageId = l;
                vineupload.isPrivate = true;
                vineupload.status = 1;
                vineupload.conversationRowId = l1;
                context.putExtra("upload", vineupload);
            }
        } else
        {
            context.setAction("bMergeAndPost");
        }
        context.putExtra("is_private", true);
        context.putExtra("is_retry", flag);
        context.putExtra("path", s);
        context.putExtra("recipients", arraylist);
        context.putExtra("message", s1);
        context.putExtra("postId", l2);
        context.putExtra("videoUrl", s2);
        context.putExtra("thumbUrl", s3);
        context.putExtra("created", System.currentTimeMillis());
        context.putExtra("conversation_row_id", l1);
        context.putExtra("maxLoops", i);
        return context;
    }

    public static Intent getVMPostIntent(Context context, String s, boolean flag, long l, ArrayList arraylist, String s1, int i)
    {
        return getVMPostIntent(context, s, flag, -1L, l, arraylist, s1, -1L, null, null, i);
    }

    public static Intent getVMSharePostIntent(Context context, boolean flag, long l, ArrayList arraylist, long l1, String s, 
            String s1)
    {
        return getVMPostIntent(context, null, flag, -1L, l, arraylist, null, l1, s, s1, 0);
    }

    private boolean isRunning(ServiceAsyncTask serviceasynctask)
    {
        return serviceasynctask != null && serviceasynctask.getStatus().equals(android.os.AsyncTask.Status.RUNNING);
    }

    private void markPreMergedMessageAsUploadFailed(String s)
    {
        Bundle bundle = new Bundle();
        AppController.injectServiceBundle(bundle, VineAccountHelper.getActiveSession(this, true));
        bundle.putString("upload_path", s);
        mVineServiceConnection.queueAndExecute(100, bundle);
    }

    private void preMergeMessage(VineUpload vineupload)
    {
        Bundle bundle = new Bundle();
        AppController.injectServiceBundle(bundle, VineAccountHelper.getActiveSession(this, true));
        bundle.putParcelable("upload", vineupload);
        mVineServiceConnection.queueAndExecute(93, bundle);
    }

    private void processCommand(String s, String s1, Intent intent, UploadProgressListener uploadprogresslistener)
    {
        ServiceAsyncTask serviceasynctask;
        SLog.d("Process command for action={}, path={}", s1, s);
        serviceasynctask = new ServiceAsyncTask(s, s1, intent, uploadprogresslistener);
        if (!"aUpload".equals(s1)) goto _L2; else goto _L1
_L1:
        if (!mPendingTasks.contains(serviceasynctask) && !mPendingVMTasks.contains(serviceasynctask))
        {
            s1 = intent.getStringExtra("hash");
            boolean flag = intent.getBooleanExtra("is_private", false);
            UploadManager.addOrUpdateUpload(this, s, s1, intent.getStringExtra("reference"), flag, intent.getLongExtra("conversation_row_id", 0L), -1L);
            if (flag)
            {
                s1 = mPendingVMTasks;
            } else
            {
                s1 = mPendingTasks;
            }
            if (s1.add(serviceasynctask))
            {
                SLog.d("Upload task added for path={}", s);
            }
        } else
        {
            SLog.d("Upload task is already in queue for path={}", s);
        }
_L4:
        executeNext();
        return;
_L2:
        if ("bMergeAndPost".equals(s1))
        {
            s1 = getPostInfoFromIntent(intent);
            if (!TextUtils.isEmpty(s))
            {
                s = UploadManager.getUpload(this, s);
                UploadManager.setPostInfo(this, s, s1);
            } else
            {
                s = new VineUpload();
                s.postInfo = s1.toString();
                s.isPrivate = true;
                s.status = 1;
                s.conversationRowId = intent.getLongExtra("conversation_row_id", -1L);
            }
            preMergeMessage(s);
            continue; /* Loop/switch isn't completed */
        }
        if ("bPost".equals(s1))
        {
            VineUpload vineupload = UploadManager.getUpload(this, s);
            s1 = vineupload;
            if (vineupload == null)
            {
                s1 = (VineUpload)intent.getParcelableExtra("upload");
            }
            if (s1 == null)
            {
                SLog.e("Error posting. No upload via path nor via argument: {}.", s);
                return;
            }
            if (TextUtils.isEmpty(((VineUpload) (s1)).postInfo))
            {
                UploadManager.setPostInfo(this, s1, getPostInfoFromIntent(intent));
            }
            switch (((VineUpload) (s1)).status)
            {
            default:
                SLog.d("Invalid state={} for path={}", Integer.valueOf(((VineUpload) (s1)).status), s);
                break;

            case 0: // '\0'
                intent = new ServiceAsyncTask(s, "aUpload", intent, uploadprogresslistener);
                if (((VineUpload) (s1)).isPrivate)
                {
                    s1 = mPendingVMTasks;
                } else
                {
                    s1 = mPendingTasks;
                }
                if (!intent.equals(mCurrentTask) && s1.add(intent))
                {
                    SLog.d("Upload task added for path={}", s, ((ServiceAsyncTask) (intent)).action);
                }
                if (s1.add(serviceasynctask))
                {
                    SLog.d("Post task added for path={}", s, serviceasynctask.action);
                }
                break;

            case 1: // '\001'
            case 2: // '\002'
                if (!TextUtils.isEmpty(((VineUpload) (s1)).path) && ((VineUpload) (s1)).videoUrl == null)
                {
                    UploadManager.setStatus(this, s1, 0);
                    startService(getPostIntent(this, s1, true));
                    return;
                }
                if (!serviceasynctask.equals(mCurrentTask))
                {
                    if (((VineUpload) (s1)).isPrivate)
                    {
                        intent = mPendingVMTasks;
                    } else
                    {
                        intent = mPendingTasks;
                    }
                    serviceasynctask.mUpload = s1;
                    if (intent.add(serviceasynctask))
                    {
                        SLog.d("Post task added for path={}", s, serviceasynctask.action);
                    }
                }
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!"cNotify".equals(s1))
        {
            break; /* Loop/switch isn't completed */
        }
        if (!TextUtils.isEmpty(s))
        {
            sShowProgress = true;
            SLog.d("Notify failed upload for path={}.", s);
            showFailedNotification(s);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!"discard".equals(s1)) goto _L4; else goto _L5
_L5:
        discardTask(s);
        return;
    }

    private Bitmap setScaledNotificationIcon(String s)
    {
label0:
        {
            if (TextUtils.isEmpty(s))
            {
                break label0;
            }
            Bitmap bitmap1 = (Bitmap)mBitmaps.get(s);
            Bitmap bitmap = bitmap1;
            if (bitmap1 == null)
            {
                if (mNotificationPanelSize == -1)
                {
                    mNotificationPanelSize = getResources().getDimensionPixelSize(0x7f0b0060);
                }
                bitmap = BitmapFactory.decodeFile(s);
                if (bitmap == null)
                {
                    break label0;
                }
                bitmap = Bitmap.createScaledBitmap(bitmap, mNotificationPanelSize, mNotificationPanelSize, true);
                if (bitmap == null)
                {
                    break label0;
                }
                if (mBitmaps.size() >= 10)
                {
                    mBitmaps.clear();
                }
                mBitmaps.put(s, bitmap);
            }
            return bitmap;
        }
        if (mDefaultNotificationIcon == null)
        {
            mDefaultNotificationIcon = BitmapFactory.decodeResource(getResources(), 0x7f020198);
        }
        mBitmaps.put(s, mDefaultNotificationIcon);
        return mDefaultNotificationIcon;
    }

    private void showFailedNotification(String s)
    {
        VineUpload vineupload = UploadManager.getUpload(this, s);
        if (vineupload == null)
        {
            return;
        } else
        {
            SLog.d("Show failed notification for {}, upload expired? {}.", s, Boolean.valueOf(vineupload.isExpired()));
            s = new android.support.v4.app.NotificationCompat.Builder(this);
            s.setSmallIcon(0x7f0201ff);
            s.setLargeIcon(setScaledNotificationIcon(vineupload.thumbnailPath));
            s.setContentIntent(PendingIntent.getActivity(this, 0, StartActivity.getStartIntent(this, "co.vine.android.UPLOAD_LIST"), 0));
            s.setContentTitle(getText(0x7f0e017b));
            s.setContentText(getText(0x7f0e0244));
            s.setAutoCancel(false);
            showNotification(s, 0);
            return;
        }
    }

    private void showNotification(android.support.v4.app.NotificationCompat.Builder builder, int i)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = sShowProgress;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        mNotificationManager.notify("upload_notification", i, builder.build());
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        builder.setLargeIcon(null);
        mNotificationManager.notify("upload_notification", i, builder.build());
        if (true) goto _L2; else goto _L1
_L1:
        builder;
        throw builder;
    }

    private void stopIfNoTasksLeft()
    {
        if (mPendingVMTasks.isEmpty() && mPendingTasks.isEmpty() && !isRunning(mCurrentTask))
        {
            stopService();
        }
    }

    private void stopService()
    {
        int ai[] = mLock;
        ai;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mStartIds.iterator(); iterator.hasNext(); stopSelf(((Integer)iterator.next()).intValue())) { }
        break MISSING_BLOCK_LABEL_48;
        Exception exception;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
        mStartIds.clear();
        ai;
        JVM INSTR monitorexit ;
    }

    public co.vine.android.api.VineUpload.PostInfo getPostInfoFromIntent(Intent intent)
    {
        String s = intent.getStringExtra("description");
        boolean flag = intent.getBooleanExtra("postToTwitter", false);
        boolean flag1 = intent.getBooleanExtra("postToFacebook", false);
        long l = intent.getLongExtra("channelId", -1L);
        ArrayList arraylist = intent.getParcelableArrayListExtra("entities");
        String s1 = intent.getStringExtra("message");
        long l1 = intent.getLongExtra("postId", -1L);
        String s2 = intent.getStringExtra("videoUrl");
        String s3 = intent.getStringExtra("thumbUrl");
        int i = intent.getIntExtra("maxLoops", 0);
        return new co.vine.android.api.VineUpload.PostInfo(s, flag, flag1, l, arraylist, s1, l1, s2, s3, intent.getLongExtra("created", 0L), (ArrayList)intent.getSerializableExtra("recipients"), i);
    }

    public void handleServiceResponse(int i, int j, String s, Bundle bundle)
    {
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   93: 223
    //                   98: 29;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        s = (VineUpload)bundle.getParcelable("upload");
        if (j != 200)
        {
            break; /* Loop/switch isn't completed */
        }
        SLog.d("Post successful.");
        cancelFailedNofitication();
        boolean flag;
        if (!((VineUpload) (s)).isPrivate)
        {
            SharedPreferences sharedpreferences = Util.getDefaultSharedPrefs(this);
            android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putInt("profile_post_count", sharedpreferences.getInt("profile_post_count", 0) + 1);
            editor.apply();
        } else
        {
            String s1 = bundle.getString("post_url");
            String s2 = bundle.getString("thumbnail_url");
            if (s1 != null && s2 != null)
            {
                UploadManager.prepopulateCache(this, ((VineUpload) (s)).path, s1, s2);
            }
        }
        flag = bundle.getBoolean("should_delete_upload", false);
        if (!TextUtils.isEmpty(((VineUpload) (s)).path) && !flag)
        {
            discardUpload(((VineUpload) (s)).path);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        bundle = getNotifyFailedIntent(this);
        if (bundle != null)
        {
            startService(bundle);
            if (s != null)
            {
                UploadManager.setStatus(this, s, 2, ((VineUpload) (s)).captchaUrl);
                return;
            }
        }
          goto _L1
_L2:
        s = (VineUpload)bundle.getParcelable("upload");
        long l = bundle.getLong("premerged_message_id");
        s.mergedMessageId = l;
        bundle = s.getPostInfo();
        SLog.d("Pre merge message complete. Path {} Row {} {}", ((VineUpload) (s)).path, Long.valueOf(l), bundle.toString());
        if (((VineUpload) (s)).path != null)
        {
            UploadManager.setPostInfo(this, s, bundle);
            UploadManager.setUploadMessageRowId(this, ((VineUpload) (s)).path, l);
        }
        startService(getPostIntent(this, s, false));
        return;
    }

    public IBinder onBind(Intent intent)
    {
        return mMessenger.getBinder();
    }

    public void onCreate()
    {
        super.onCreate();
        mPendingTasks = new LinkedHashSet();
        mPendingVMTasks = new LinkedHashSet();
        mUploadManager = new UploadManager(this);
        mStartIds = new LinkedList();
        mNotificationManager = (NotificationManager)getSystemService("notification");
        VineAccountHelper.resetActiveSession();
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("co.vine.android.session.logout");
        intentfilter.addAction("co.vine.android.session.login");
        mSessionChangedReceiver = new SessionChangedReceiver();
        mBitmaps = new HashMap();
        registerReceiver(mSessionChangedReceiver, intentfilter, "co.vine.android.BROADCAST", null);
        mMessenger = new Messenger(new IncomingHandler());
        mIsBinded = bindService(new Intent(this, co/vine/android/service/VineService), mVineServiceConnection, 1);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mIsBinded)
        {
            unbindService(mVineServiceConnection);
        }
        if (mSessionChangedReceiver != null)
        {
            unregisterReceiver(mSessionChangedReceiver);
        }
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        SLog.d("onStartCommand, intent={}", intent);
        int ai[] = mLock;
        ai;
        JVM INSTR monitorenter ;
        mStartIds.add(Integer.valueOf(j));
        if (intent != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        ai;
        JVM INSTR monitorexit ;
        return 2;
        String s;
        String s1;
        s = intent.getAction();
        s1 = intent.getStringExtra("path");
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        throw new IllegalArgumentException("VineUploadService must be started with an explicit intent; set an action.");
        intent;
        ai;
        JVM INSTR monitorexit ;
        throw intent;
        if (!"discard_all".equals(s)) goto _L2; else goto _L1
_L1:
        for (intent = UploadManager.getAllPaths(this).keySet().iterator(); intent.hasNext(); discardTask((String)intent.next())) { }
        cancelFailedNofitication();
_L3:
        ai;
        JVM INSTR monitorexit ;
        return 1;
_L2:
label0:
        {
            if (!"show_notifications".equals(s))
            {
                break label0;
            }
            sShowProgress = true;
        }
          goto _L3
label1:
        {
            if (!"clear_notifications".equals(s))
            {
                break label1;
            }
            sShowProgress = false;
            clearNotification(0);
            clearNotification(1);
        }
        if (true) goto _L3; else goto _L4
_L4:
        Object obj = null;
        if (!TextUtils.isEmpty(s1))
        {
            if (!intent.getBooleanExtra("show_notifications", false))
            {
                break MISSING_BLOCK_LABEL_221;
            }
            obj = new NotificationProgressListener(s1);
        }
_L5:
        processCommand(s1, s, intent, ((UploadProgressListener) (obj)));
          goto _L3
        obj = new IPCProgressListener(s1);
          goto _L5
    }

    public boolean onUnbind(Intent intent)
    {
        sUploadResultReceiver = null;
        stopIfNoTasksLeft();
        return false;
    }




/*
    static Messenger access$102(Messenger messenger)
    {
        sUploadResultReceiver = messenger;
        return messenger;
    }

*/





/*
    static ServiceAsyncTask access$202(VineUploadService vineuploadservice, ServiceAsyncTask serviceasynctask)
    {
        vineuploadservice.mCurrentTask = serviceasynctask;
        return serviceasynctask;
    }

*/







}
