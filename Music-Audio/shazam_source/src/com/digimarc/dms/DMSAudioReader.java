// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import com.digimarc.dms.audioreader.DMSIAudioNative;
import org.json.JSONObject;

// Referenced classes of package com.digimarc.dms:
//            DMSOptionsAudio

public class DMSAudioReader extends DMSIAudioNative
{

    private static DMSIAudioNative mAudioNative;
    private boolean mReadyToDispatch;

    public DMSAudioReader()
    {
        mReadyToDispatch = false;
        mAudioNative = getInstance();
    }

    public void dispatch()
    {
        this;
        JVM INSTR monitorenter ;
        if (mReadyToDispatch)
        {
            mAudioNative.dispatchRead();
            mReadyToDispatch = false;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected String getReaderType()
    {
        return getAudioOptions().getDecoderFactoryName();
    }

    public void initWithJSONDictionary(JSONObject jsonobject)
    {
        super.initWithJSONDictionary(jsonobject);
    }

    void queueAudioData(byte abyte0[], int i)
    {
        try
        {
            DMSIAudioNative.incomingAudioBuffer(abyte0, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
        }
    }

    public void scheduleForDispatch()
    {
        this;
        JVM INSTR monitorenter ;
        mReadyToDispatch = readyToRunAtSessionCounter(getAudioProfile());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void start()
    {
        DMSIAudioNative.configure(getReaderType(), getAudioOptions().getBufferSeconds());
        mAudioNative.start();
        isOpen = true;
    }

    public void stop()
    {
        mAudioNative.stop();
        isOpen = false;
    }
}
