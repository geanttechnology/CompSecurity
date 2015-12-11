// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import co.vine.android.util.VineProgressEvent;

// Referenced classes of package co.vine.android.service:
//            UploadProgressListener, VineUploadService

public class this._cls0 extends UploadProgressListener
{

    public static final double PROGRESS_RATIO_TRANSCODE = 0.65000000000000002D;
    public static final double PROGRESS_RATIO_UPLOAD = 0.33000000000000002D;
    final VineUploadService this$0;

    private void sendMessageToActivity(Message message)
    {
        try
        {
            VineUploadService.access$100().send(message);
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
        if (VineUploadService.access$100() != null)
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
        if (VineUploadService.access$100() != null)
        {
            sendMessageToActivity(Message.obtain(null, 4));
        }
    }

    public void progressChanged(VineProgressEvent vineprogressevent)
    {
        currentSize = currentSize + (long)vineprogressevent.getBytesTransfered();
        int i = (int)((currentSize * 100L) / size);
        if (VineUploadService.access$100() != null && Math.abs(lastProgress - i) > 2)
        {
            lastProgress = i;
            vineprogressevent = new Bundle();
            vineprogressevent.putDouble("upload_progress", i);
            sendMessageToActivity(Message.obtain(null, 6, vineprogressevent));
        }
    }

    public void updateTranscodeProgress(int i)
    {
        if (VineUploadService.access$100() != null && Math.abs(lastProgress - i) > 2)
        {
            lastProgress = i;
            Bundle bundle = new Bundle();
            bundle.putDouble("transcode_progress", i);
            sendMessageToActivity(Message.obtain(null, 5, bundle));
        }
    }

    public (String s)
    {
        this$0 = VineUploadService.this;
        super(s);
    }
}
