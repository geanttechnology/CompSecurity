// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;


// Referenced classes of package co.vine.android.recorder:
//            BaseFinishProcessTask

public abstract class AbstractEncodingRunnable
    implements Runnable
{

    public AbstractEncodingRunnable()
    {
    }

    public abstract void setAsyncTask(BaseFinishProcessTask basefinishprocesstask);

    public abstract void terminate();
}
