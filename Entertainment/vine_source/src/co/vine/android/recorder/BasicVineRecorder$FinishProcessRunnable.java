// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import co.vine.android.VineLoggingException;
import co.vine.android.util.CrashUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

// Referenced classes of package co.vine.android.recorder:
//            BasicVineRecorder, RecordingFile, RecordSession, RecordSessionManager, 
//            ReusableHashAsyncTask, RecordController

public class this._cls0
{

    private boolean isResumed;
    final BasicVineRecorder this$0;

    public boolean doNotDeleteSession(boolean flag)
    {
        return flag;
    }

    public boolean isCompleteSession(boolean flag)
    {
        return flag;
    }

    public void onCompleteSessionFinish(boolean flag)
    {
        boolean flag3 = true;
        Object obj = mCurrentRecordingFile;
        if (obj == null)
        {
            CrashUtil.logException(new VineLoggingException("Failed to stop recording."));
        } else
        {
            RecordSession recordsession = ((RecordingFile) (obj)).getSession();
            recordsession.setAudioDataCount(recordsession.calculateAudioCount());
            recordsession.setVideoDataCount(recordsession.calculateVideoCount());
            if (!mDiscardChanges)
            {
                boolean flag1;
                boolean flag2;
                if (mFinished && ((RecordingFile) (obj)).hasData() && !canKeepRecording())
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                mDoNotDeleteSession = doNotDeleteSession(flag2);
                if (mEditedSegments.size() > 0 && recordsession.getVideoDataCount() > 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (mEditedSegments.size() > 0 && !flag1)
                {
                    CrashUtil.log("Invalid session found.");
                }
                if (flag1)
                {
                    try
                    {
                        RecordSessionManager.writeRecordingFile(((RecordingFile) (obj)), flag);
                    }
                    catch (IOException ioexception1)
                    {
                        if (flag)
                        {
                            throw new RuntimeException(ioexception1);
                        }
                        CrashUtil.log((new StringBuilder()).append("Failed to save the files due to IOException: ").append(ioexception1.getMessage()).toString());
                    }
                } else
                if (!mCanKeepRecording)
                {
                    try
                    {
                        RecordSessionManager.deleteSession(((RecordingFile) (obj)).folder, "Invalid session");
                    }
                    catch (IOException ioexception2)
                    {
                        CrashUtil.log((new StringBuilder()).append("Failed to delete session: ").append(ioexception2.getMessage()).toString());
                    }
                }
                if (flag)
                {
                    if (!((RecordingFile) (obj)).isLastSession)
                    {
                        obj.isSavedSession = true;
                        obj.isDirty = false;
                    }
                    if (flag1)
                    {
                        cleanThumbnails(false);
                    }
                }
                if (flag2)
                {
                    obj = BasicVineRecorder.this;
                    if (!flag1)
                    {
                        flag = flag3;
                    } else
                    {
                        flag = false;
                    }
                    ((BasicVineRecorder) (obj)).startHashTask(flag);
                    return;
                }
            } else
            {
                if (!mDoNotDeleteSession && !mCurrentRecordingFile.isSavedSession)
                {
                    try
                    {
                        CrashUtil.log("Session {} deleted.", new Object[] {
                            mCurrentRecordingFile.folder
                        });
                        RecordSessionManager.deleteSession(mCurrentRecordingFile.folder, "Discard Changes.");
                    }
                    catch (IOException ioexception)
                    {
                        CrashUtil.logException(ioexception, "Failed to delete session.", new Object[0]);
                    }
                }
                mToRemove.clear();
                return;
            }
        }
    }

    public void onIncompleteSessionFinish()
    {
        if (mFinished && !canKeepRecording() && mHashTask != null && !mHashTask.isComplete() && !isResumed)
        {
            isResumed = true;
            mHashTask.resumeAll();
        }
    }

    public boolean onMakeRecordingStop(String s, boolean flag, boolean flag1)
    {
        if (mVideoController != null)
        {
            boolean flag2 = mVideoController.isRecordingStarted();
            CrashUtil.log("Stop recording in VineRecorder from {} : wasRecordingStarted {} releasePreview {} saveSession {} mDiscardChanges {} mDoNotDeleteSession {} mCurrentRecordingFile {}", new Object[] {
                s, Boolean.valueOf(flag2), Boolean.valueOf(flag), Boolean.valueOf(flag1), Boolean.valueOf(mDiscardChanges), Boolean.valueOf(mDoNotDeleteSession), mCurrentRecordingFile
            });
            if (flag2)
            {
                endRelativeTime();
                grabThumbnailsRunnable = mVideoController.stop(mDiscardChanges, flag);
            }
            return flag2;
        } else
        {
            return false;
        }
    }

    protected void onPreCompleteSession(boolean flag)
    {
    }

    public void reset()
    {
        isResumed = false;
    }

    public void run(String s, boolean flag, boolean flag1)
    {
        this;
        JVM INSTR monitorenter ;
        flag = onMakeRecordingStop(s, flag, flag1);
        onPreCompleteSession(flag);
        if (!isCompleteSession(flag)) goto _L2; else goto _L1
_L1:
        onCompleteSessionFinish(flag1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        onIncompleteSessionFinish();
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public ()
    {
        this$0 = BasicVineRecorder.this;
        super();
    }
}
