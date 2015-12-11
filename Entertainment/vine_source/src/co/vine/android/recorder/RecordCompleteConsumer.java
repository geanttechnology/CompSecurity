// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;


// Referenced classes of package co.vine.android.recorder:
//            RecordingFile

public interface RecordCompleteConsumer
    extends Runnable
{

    public abstract boolean isComplete();

    public abstract void onComplete(RecordingFile recordingfile, RecordCompleteConsumer recordcompleteconsumer);

    public abstract void onError(RecordingFile recordingfile, Exception exception, RecordCompleteConsumer recordcompleteconsumer);

    public abstract void reset();

    public abstract void resumeAll();

    public abstract void run();
}
