// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.speech.recognizer;

import euf;
import ewc;
import ewe;
import ewf;
import ewg;
import ewk;
import ewo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.speech.recognizer:
//            ResourceManager

public abstract class AbstractRecognizer
{

    private static final Logger logger = Logger.getLogger(com/google/speech/recognizer/AbstractRecognizer.getName());
    private List callbacks;
    private long nativeObj;
    private InputStream reader;
    private ResourceManager rm;

    public AbstractRecognizer()
    {
        callbacks = new ArrayList(1);
        nativeObj = nativeConstruct();
    }

    private native int nativeCancel(long l);

    private native long nativeConstruct();

    private native void nativeDelete(long l);

    public static native void nativeInit();

    private native int nativeInitFromFile(long l, long l1, String s);

    private native int nativeInitFromProto(long l, long l1, byte abyte0[]);

    private native byte[] nativeRun(long l, byte abyte0[]);

    private void validate()
    {
        if (nativeObj == 0L)
        {
            throw new IllegalStateException("recognizer is not initialized");
        } else
        {
            return;
        }
    }

    public int addCallback(ewc ewc1)
    {
        callbacks.add(ewc1);
        return 0;
    }

    public int cancel()
    {
        validate();
        return nativeCancel(nativeObj);
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (nativeObj != 0L)
        {
            nativeDelete(nativeObj);
            nativeObj = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize()
    {
        delete();
    }

    protected void handleAudioLevelEvent(byte abyte0[])
    {
        ewf ewf1 = new ewf();
        ewf1.a(abyte0);
        for (abyte0 = callbacks.iterator(); abyte0.hasNext(); ((ewc)abyte0.next()).handleAudioLevelEvent(ewf1)) { }
    }

    protected void handleEndpointerEvent(byte abyte0[])
    {
        ewg ewg1 = new ewg();
        ewg1.a(abyte0);
        for (abyte0 = callbacks.iterator(); abyte0.hasNext(); ((ewc)abyte0.next()).handleEndpointerEvent(ewg1)) { }
    }

    protected void handleRecognitionEvent(byte abyte0[])
    {
        ewk ewk1 = new ewk();
        ewk1.a(abyte0);
        for (abyte0 = callbacks.iterator(); abyte0.hasNext(); ((ewc)abyte0.next()).handleRecognitionEvent(ewk1)) { }
    }

    public int initFromFile(String s, ResourceManager resourcemanager)
    {
        validate();
        rm = resourcemanager;
        return nativeInitFromFile(nativeObj, resourcemanager.getNativeObject(), s);
    }

    public int initFromProto(byte abyte0[], ResourceManager resourcemanager)
    {
        validate();
        rm = resourcemanager;
        return nativeInitFromProto(nativeObj, resourcemanager.getNativeObject(), abyte0);
    }

    public int read(byte abyte0[])
    {
        if (abyte0.length == 0)
        {
            throw new IOException("illegal zero length buffer");
        }
        int j = reader.read(abyte0);
        int i = j;
        if (j == -1)
        {
            i = 0;
        }
        return i;
    }

    public ewe run(ewo ewo1)
    {
        validate();
        ewo1 = nativeRun(nativeObj, ewo1.c());
        try
        {
            ewo1 = (ewe)(new ewe()).a(ewo1);
        }
        // Misplaced declaration of an exception variable
        catch (ewo ewo1)
        {
            logger.log(Level.SEVERE, "bad protocol buffer from recognizer jni");
            return (new ewe()).a(2);
        }
        return ewo1;
    }

    public int setAudioReader(InputStream inputstream)
    {
        reader = inputstream;
        return 0;
    }

}
