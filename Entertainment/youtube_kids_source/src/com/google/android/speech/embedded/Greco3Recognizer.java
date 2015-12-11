// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import a;
import android.util.Log;
import com.google.speech.recognizer.AbstractRecognizer;
import dak;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.google.android.speech.embedded:
//            Greco3Mode, Greco3Callback

public class Greco3Recognizer extends AbstractRecognizer
{

    private static final String TAG = "Vs.G3Recognizer";
    private static boolean sSharedLibraryLoaded = false;
    private final int mBytesPerSample;
    private final RecognizerCallbackWrapper mCallback = new RecognizerCallbackWrapper(null);
    private long mProgressMs;
    private int mSamplingRate;

    public Greco3Recognizer(int i, int j)
    {
        mSamplingRate = i;
        mBytesPerSample = j;
        addCallback(mCallback);
    }

    public static Greco3Recognizer create(Greco3EngineManager.Resources resources, int i, int j)
    {
        Greco3Recognizer greco3recognizer = new Greco3Recognizer(i, j);
        File file = new File(resources.configFile);
        if (Greco3Mode.isAsciiConfiguration(file))
        {
            i = greco3recognizer.initFromFile(resources.configFile, resources.resources);
        } else
        {
            byte abyte0[] = getFileBytes(file);
            if (abyte0 == null || abyte0.length == 0)
            {
                Log.e("Vs.G3Recognizer", (new StringBuilder("Error reading g3 config file: ")).append(resources.configFile).toString());
                return null;
            }
            i = greco3recognizer.initFromProto(abyte0, resources.resources);
        }
        if (i == 0)
        {
            return greco3recognizer;
        } else
        {
            Log.e("Vs.G3Recognizer", (new StringBuilder("Failed to bring up g3, Status code: ")).append(i).toString());
            return null;
        }
    }

    private static byte[] getFileBytes(File file)
    {
        try
        {
            file = a.a(file);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return null;
        }
        return file;
    }

    public static void maybeLoadSharedLibrary()
    {
        com/google/android/speech/embedded/Greco3Recognizer;
        JVM INSTR monitorenter ;
        boolean flag = sSharedLibraryLoaded;
        if (!flag) goto _L2; else goto _L1
_L1:
        com/google/android/speech/embedded/Greco3Recognizer;
        JVM INSTR monitorexit ;
        return;
_L2:
        System.loadLibrary("google_recognizer_jni_l");
_L4:
        nativeInit();
        sSharedLibraryLoaded = true;
        if (true) goto _L1; else goto _L3
_L3:
        Object obj;
        obj;
        throw obj;
        obj;
        System.loadLibrary("google_recognizer_jni");
          goto _L4
    }

    public int cancel()
    {
        mCallback.invalidate();
        return super.cancel();
    }

    protected int read(byte abyte0[])
    {
        int i;
        try
        {
            i = super.read(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            mCallback.notifyError(new dak("Audio error", abyte0));
            throw abyte0;
        }
        if (i > 0)
        {
            mProgressMs = mProgressMs + (long)((i * 1000) / (mBytesPerSample * mSamplingRate));
            if (mProgressMs % 200L == 0L)
            {
                mCallback.updateProgress(mProgressMs);
            }
        }
        return i;
    }

    public void setCallback(Greco3Callback greco3callback)
    {
        mCallback.mDelegate = greco3callback;
        mProgressMs = 0L;
    }

    public void setSamplingRate(int i)
    {
        mSamplingRate = i;
    }


    private class RecognizerCallbackWrapper
        implements ewc
    {

        private Greco3Callback mDelegate;

        public void handleAudioLevelEvent(ewf ewf)
        {
            if (mDelegate != null)
            {
                mDelegate.handleAudioLevelEvent(ewf);
            }
        }

        public void handleEndpointerEvent(ewg ewg)
        {
            if (mDelegate != null)
            {
                mDelegate.handleEndpointerEvent(ewg);
            }
        }

        public void handleRecognitionEvent(ewk ewk)
        {
            if (mDelegate != null)
            {
                mDelegate.handleRecognitionEvent(ewk);
            }
        }

        public void invalidate()
        {
            mDelegate = null;
        }

        public void notifyError(dap dap)
        {
            if (mDelegate != null)
            {
                mDelegate.handleError(dap);
            }
        }

        public void updateProgress(long l)
        {
            if (mDelegate != null)
            {
                mDelegate.handleProgressUpdate(l);
            }
        }


/*
        static Greco3Callback access$102(RecognizerCallbackWrapper recognizercallbackwrapper, Greco3Callback greco3callback)
        {
            recognizercallbackwrapper.mDelegate = greco3callback;
            return greco3callback;
        }

*/

        private RecognizerCallbackWrapper()
        {
        }

        RecognizerCallbackWrapper(_cls1 _pcls1)
        {
            this();
        }
    }

}
