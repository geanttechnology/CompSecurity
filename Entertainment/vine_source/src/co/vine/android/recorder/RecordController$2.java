// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.graphics.Bitmap;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.recorder:
//            SwCombiningRunnable, RecordController, RecordingFile, AudioArray, 
//            SwVineFrameRecorder, BaseFinishProcessTask

class sk extends SwCombiningRunnable
{

    final RecordController this$0;

    ge(RecordingFile recordingfile, boolean flag, AudioArray audioarray, byte abyte0[], ArrayList arraylist, SwVineFrameRecorder swvineframerecorder, 
            BaseFinishProcessTask basefinishprocesstask, Bitmap bitmap, com.googlecode.javacv.cpp.e e)
    {
        this$0 = RecordController.this;
        super(recordingfile, flag, audioarray, abyte0, arraylist, swvineframerecorder, basefinishprocesstask, bitmap, e);
    }
}
