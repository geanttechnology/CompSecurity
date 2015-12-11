// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import co.vine.android.util.VineProgressEvent;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.service:
//            UploadProgressListener, VineUploadService

private class this._cls0 extends UploadProgressListener
{

    final VineUploadService this$0;

    private void updateNotification(String s, int i, int j, boolean flag)
    {
        SLog.d("Update notification: {}, {}.", Boolean.valueOf(flag), Integer.valueOf(lastProgress));
        android.support.v4.app.  = new android.support.v4.app..lastProgress(VineUploadService.this);
        ._mth0(VineUploadService.access$600(VineUploadService.this, s));
        ._mth0(0x7f0201ff);
        ._mth0(getText(i));
        ._mth0(getText(j));
        ._mth0(0L);
        ._mth0(true);
        if (flag)
        {
            if (lastProgress > 0)
            {
                .lastProgress(100, lastProgress, false);
            } else
            {
                .lastProgress(0, 0, true);
            }
        } else
        {
            .lastProgress(0, 0, true);
        }
        VineUploadService.access$700(VineUploadService.this, , 1);
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
        VineUploadService.access$400(VineUploadService.this, 1);
        if (flag)
        {
            VineUploadService.access$500(VineUploadService.this);
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

    public (String s)
    {
        this$0 = VineUploadService.this;
        super(s);
    }
}
