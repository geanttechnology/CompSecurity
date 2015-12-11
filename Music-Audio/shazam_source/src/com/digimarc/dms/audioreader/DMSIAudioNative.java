// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.audioreader;

import com.digimarc.dms.DMSIBaseReader;
import com.digimarc.dms.DMSMessage;
import com.digimarc.dms.DMSPayload;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.digimarc.dms.audioreader:
//            CpmAudio

public class DMSIAudioNative extends DMSIBaseReader
{

    public static final int DECODER_FACTORY_AFREHF_3 = 4;
    public static final int DECODER_FACTORY_AFREHF_6 = 5;
    public static final int DECODER_FACTORY_AFREHF_9 = 6;
    public static final int DECODER_FACTORY_AFRE_3 = 1;
    public static final int DECODER_FACTORY_AFRE_6 = 2;
    public static final int DECODER_FACTORY_AFRE_9 = 3;
    public static final int DECODER_FACTORY_TDS4_3 = 7;
    public static final int DECODER_FACTORY_TDS4_6 = 8;
    public static final int DECODER_FACTORY_TDS4_9 = 9;
    public static final int DECODER_FACTORY_TONE_3 = 10;
    public static final int DECODER_FACTORY_UNKNOWN = 0;
    private static final String TAG = "DMSAudioNative";
    private static DMSIAudioNative instance = null;
    private static int mAudioBufferLen = 0;
    private static String mDecoderName = null;
    private static int mDecoderType = 0;
    private final int MAX_THREADPOOL_SIZE = 5;
    private Thread mActiveThread;
    private int mDesiredSampleRate;
    private boolean mDisabled;
    private ExecutorService mExecutor;
    private Thread mReaderThread;

    public DMSIAudioNative()
    {
        mDesiredSampleRate = 16000;
        mExecutor = null;
        mReaderThread = null;
        mDisabled = false;
        try
        {
            System.loadLibrary("DMSAudioWatermark");
            native_init();
            return;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            throw unsatisfiedlinkerror;
        }
        catch (SecurityException securityexception)
        {
            throw securityexception;
        }
    }

    public static void configure(String s, int i)
    {
        mDecoderName = s;
        mAudioBufferLen = i;
        mDecoderType = getDecoderType(mDecoderName, mAudioBufferLen);
        (new StringBuilder("decoderName: ")).append(mDecoderName).append(", bufferLen (secs): ").append(i).append(", decoderType: ").append(mDecoderType);
    }

    private Runnable createRunnable(final int factoryType)
    {
        this;
        JVM INSTR monitorenter ;
        Runnable runnable = new Runnable() {

            final DMSIAudioNative this$0;
            final int val$factoryType;

            public void run()
            {
                mActiveThread = Thread.currentThread();
                (new StringBuilder("Read, factory=")).append(factoryType);
                readWatermarkThreadEntry(factoryType);
            }

            
            {
                this$0 = DMSIAudioNative.this;
                factoryType = i;
                super();
            }
        };
        this;
        JVM INSTR monitorexit ;
        return runnable;
        Exception exception;
        exception;
        throw exception;
    }

    private static final native void flushBuffer();

    private static int getDecoderType(String s, int i)
    {
        if (!s.contains("AFRE")) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 3 6: default 40
    //                   3 42
    //                   4 40
    //                   5 40
    //                   6 44;
           goto _L2 _L3 _L2 _L2 _L4
_L2:
        return 0;
_L3:
        return 1;
_L4:
        return 2;
    }

    public static DMSIAudioNative getInstance()
    {
        if (instance == null)
        {
            instance = new DMSIAudioNative();
        }
        return instance;
    }

    private long getPayloadType(int i)
    {
        switch (i)
        {
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        default:
            return 255L;

        case 0: // '\0'
            return 0L;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 10: // '\n'
            return 254L;
        }
    }

    public static void incomingAudioBuffer(byte abyte0[], int i)
    {
        com/digimarc/dms/audioreader/DMSIAudioNative;
        JVM INSTR monitorenter ;
        try
        {
            queueAudio(abyte0, i, mDecoderType);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[]) { }
        finally
        {
            com/digimarc/dms/audioreader/DMSIAudioNative;
        }
        return;
        throw abyte0;
    }

    private static final native void native_init();

    private static final native void native_release();

    private static final native void queueAudio(byte abyte0[], int i, int j);

    public static final native CpmAudio readAudioCPM(int i);

    private CpmAudio readWatermark(int i)
    {
        CpmAudio cpmaudio = null;
        CpmAudio cpmaudio1;
        try
        {
            cpmaudio1 = readAudioCPM(i);
        }
        catch (ConcurrentModificationException concurrentmodificationexception)
        {
            return cpmaudio;
        }
        if (cpmaudio1 == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        cpmaudio = cpmaudio1;
        cpmaudio1.parseCpmPath();
        return cpmaudio1;
    }

    private void readWatermarkThreadEntry(int i)
    {
        CpmAudio cpmaudio;
        try
        {
            long l = System.nanoTime();
            cpmaudio = readWatermark(i);
            l = System.nanoTime() - l;
            long l1 = l / 0xf4240L;
            (new StringBuilder("Elapsed ns: ")).append(l).append(", ms: ").append(l1);
        }
        catch (Throwable throwable)
        {
            return;
        }
        finally
        {
            throw exception;
        }
        if (cpmaudio == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        DMS_Notify_Marks(100, new DMSMessage(new DMSPayload(cpmaudio.getCpmPath()), name, 0));
    }

    private void startRead(int i)
    {
        try
        {
            mExecutor.execute(createRunnable(i));
            return;
        }
        catch (RejectedExecutionException rejectedexecutionexception)
        {
            return;
        }
    }

    private void stopReader()
    {
        mActiveThread.interrupt();
    }

    private static final native void toggleReadMark(boolean flag);

    protected void cancelDispatchedRead()
    {
        stopReader();
    }

    protected void disable()
    {
        this;
        JVM INSTR monitorenter ;
        mDisabled = true;
        flushBuffer();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean dispatchRead()
    {
        if (!mDisabled)
        {
            startRead(mDecoderType);
        }
        return true;
    }

    protected void enable()
    {
        this;
        JVM INSTR monitorenter ;
        mDisabled = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize()
    {
        native_release();
    }

    public void start()
    {
        disable();
        enable();
        if (mExecutor == null)
        {
            mExecutor = Executors.newFixedThreadPool(5);
        }
    }

    public void stop()
    {
        if (!mDisabled)
        {
            mDisabled = true;
            mExecutor.shutdown();
            try
            {
                mExecutor.awaitTermination(500L, TimeUnit.MILLISECONDS);
            }
            catch (InterruptedException interruptedexception) { }
            mExecutor = null;
        }
    }

    protected void toggleReadWaterMark(boolean flag)
    {
        toggleReadMark(flag);
    }

    protected void toggleReadWatermark(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        toggleReadMark(flag);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }



/*
    static Thread access$002(DMSIAudioNative dmsiaudionative, Thread thread)
    {
        dmsiaudionative.mActiveThread = thread;
        return thread;
    }

*/

}
