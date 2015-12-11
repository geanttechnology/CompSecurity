// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.client.AppController;
import co.vine.android.recorder.RecordingFile;
import co.vine.android.util.UploadManager;
import java.io.File;

// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity

class val.thumbNailPath extends Thread
{

    final AbstractRecordingActivity this$0;
    final RecordingFile val$finalFile;
    final co.vine.android.util.unnable val$grabThumbnailRunnable;
    final String val$thumbNailPath;

    public void run()
    {
        if (val$grabThumbnailRunnable != null)
        {
            val$grabThumbnailRunnable.run();
        }
        if (AppController.getInstance(getApplicationContext()).isLoggedIn())
        {
            try
            {
                mUploadFile = UploadManager.addToUploadQueue(getApplicationContext(), val$finalFile, val$thumbNailPath, val$finalFile.folder.getName(), mIsMessaging, mConversationRowId);
            }
            catch (Exception exception)
            {
                throw new RuntimeException(exception);
            }
        }
        AbstractRecordingActivity.access$2402(AbstractRecordingActivity.this, null);
    }

    ailsRunnable()
    {
        this$0 = final_abstractrecordingactivity;
        val$grabThumbnailRunnable = unnable;
        val$finalFile = recordingfile;
        val$thumbNailPath = String.this;
        super();
    }
}
