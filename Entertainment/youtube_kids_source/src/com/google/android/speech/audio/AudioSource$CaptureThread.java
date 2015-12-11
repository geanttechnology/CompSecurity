// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import com.google.android.speech.listeners.OnReadyForSpeechListener;
import emp;
import f;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.android.speech.audio:
//            SpeechLevelGenerator

class mListener extends Thread
{

    private InputStream mLeader;
    private final OnReadyForSpeechListener mListener;
    private final int mReadSize;
    private final SpeechLevelGenerator mSpeechLevelGenerator;

    public void closeLeader()
    {
        emp.a(mLeader);
    }

    public void run()
    {
        byte abyte0[];
        boolean flag;
        f.b(mLeader);
        abyte0 = new byte[mReadSize];
        flag = true;
_L5:
        Exception exception;
        boolean flag1;
        int i;
        try
        {
            i = mLeader.read(abyte0);
        }
        catch (IOException ioexception)
        {
            emp.a(mLeader);
            return;
        }
        finally
        {
            emp.a(mLeader);
        }
        if (i == -1) goto _L2; else goto _L1
_L1:
        if (Thread.currentThread().isInterrupted()) goto _L2; else goto _L3
_L3:
        flag1 = flag;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        if (mListener != null)
        {
            mListener.onReadyForSpeech();
        }
        break MISSING_BLOCK_LABEL_119;
_L6:
        flag = flag1;
        if (mSpeechLevelGenerator == null) goto _L5; else goto _L4
_L4:
        mSpeechLevelGenerator.update(abyte0, 0, i);
        flag = flag1;
          goto _L5
_L2:
        emp.a(mLeader);
        return;
        throw exception;
        flag1 = false;
          goto _L6
    }

    public void setInputStream(InputStream inputstream)
    {
        mLeader = inputstream;
    }

    public er(int i, SpeechLevelGenerator speechlevelgenerator, OnReadyForSpeechListener onreadyforspeechlistener)
    {
        super("MicrophoneReader");
        mReadSize = i;
        mSpeechLevelGenerator = speechlevelgenerator;
        mListener = onreadyforspeechlistener;
    }
}
