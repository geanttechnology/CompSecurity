// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.speech.grammar;

import java.nio.charset.Charset;
import java.util.logging.Logger;

public abstract class AbstractGrammarCompiler
{

    private static final Logger logger = Logger.getLogger(com/google/speech/grammar/AbstractGrammarCompiler.getName());
    private long nativeObj;

    public AbstractGrammarCompiler()
    {
        nativeObj = nativeConstruct();
    }

    private void assertValidState()
    {
        if (nativeObj == 0L)
        {
            throw new IllegalStateException("Recognizer not initialized");
        } else
        {
            return;
        }
    }

    private static native boolean nativeCompile(long l, byte abyte0[]);

    private static native long nativeConstruct();

    private static native boolean nativeDelete(long l);

    private static native boolean nativeInitFromFile(long l, String s, String as[]);

    private static native boolean nativeInitFromProto(long l, byte abyte0[], String as[]);

    private static native boolean nativeReadCache(long l, String s);

    private static native boolean nativeWriteCache(long l, String s, boolean flag);

    private static native boolean nativeWriteClgFst(long l, String s, String s1);

    private static native boolean nativeWriteSemanticFst(long l, String s, String s1);

    public boolean compileAbnf(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        assertValidState();
        flag = nativeCompile(nativeObj, s.getBytes(Charset.forName("UTF-8")));
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
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

    public boolean initFromFile(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        assertValidState();
        flag = nativeInitFromFile(nativeObj, s, new String[] {
            s1
        });
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public boolean initFromProto(byte abyte0[], String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        assertValidState();
        flag = nativeInitFromProto(nativeObj, abyte0, new String[] {
            s
        });
        this;
        JVM INSTR monitorexit ;
        return flag;
        abyte0;
        throw abyte0;
    }

    public boolean readCache(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        assertValidState();
        flag = nativeReadCache(nativeObj, s);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public boolean writeCache(String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        assertValidState();
        flag = nativeWriteCache(nativeObj, s, flag);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public boolean writeClgFst(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        assertValidState();
        flag = nativeWriteClgFst(nativeObj, s, s1);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public boolean writeSemanticFst(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        assertValidState();
        flag = nativeWriteSemanticFst(nativeObj, s, s1);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

}
