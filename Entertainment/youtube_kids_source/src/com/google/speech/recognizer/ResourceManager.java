// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.speech.recognizer;


public abstract class ResourceManager
{

    private long nativeObj;

    public ResourceManager()
    {
        nativeObj = nativeConstruct();
    }

    private native long nativeConstruct();

    private native void nativeDelete(long l);

    private native int nativeInitFromFile(long l, String s, String as[]);

    private native int nativeInitFromProto(long l, byte abyte0[], String as[]);

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

    long getNativeObject()
    {
        return nativeObj;
    }

    public int initFromFile(String s, String as[])
    {
        validate();
        return nativeInitFromFile(nativeObj, s, as);
    }

    public int initFromProto(byte abyte0[], String as[])
    {
        validate();
        return nativeInitFromProto(nativeObj, abyte0, as);
    }
}
