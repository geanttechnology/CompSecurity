// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.recorder.InlineVineRecorder;
import co.vine.android.recorder.RecordingFile;
import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;
import java.io.IOException;

// Referenced classes of package co.vine.android:
//            InlineRecorderManager

public class mFileToResume extends Thread
{

    private RecordingFile mFileToResume;
    final InlineRecorderManager this$0;

    public void run()
    {
        long l;
        try
        {
            Thread.sleep(1500L);
        }
        catch (InterruptedException interruptedexception)
        {
            SLog.e("Failed to sleep wait.");
        }
        l = System.currentTimeMillis();
        SLog.d("Start resuming for inline.");
        InlineRecorderManager.access$600(InlineRecorderManager.this).initPreviewSurface();
        InlineRecorderManager.access$600(InlineRecorderManager.this).swapSession("Inline record", mFileToResume);
        mFileToResume = null;
        InlineRecorderManager.access$600(InlineRecorderManager.this).start("Inline record", false, false);
        InlineRecorderManager.access$902(InlineRecorderManager.this, false);
        CrashUtil.log("Inline resume took {}ms.", new Object[] {
            Long.valueOf(System.currentTimeMillis() - l)
        });
    }

    public ()
        throws IOException
    {
        this$0 = InlineRecorderManager.this;
        super();
        try
        {
            mFileToResume = InlineRecorderManager.access$700(InlineRecorderManager.this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InlineRecorderManager inlinerecordermanager)
        {
            throw new IOException("Failed to create new recording file.");
        }
    }
}
