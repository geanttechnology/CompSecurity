// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.util.Assertions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.android.exoplayer.text:
//            SubtitleParser, Subtitle

public final class SubtitleParserHelper
    implements android.os.Handler.Callback
{

    private IOException error;
    private final Handler handler;
    private final SubtitleParser parser;
    private boolean parsing;
    private Subtitle result;
    private SampleHolder sampleHolder;

    public SubtitleParserHelper(Looper looper, SubtitleParser subtitleparser)
    {
        handler = new Handler(looper, this);
        parser = subtitleparser;
        flush();
    }

    public void flush()
    {
        this;
        JVM INSTR monitorenter ;
        sampleHolder = new SampleHolder(1);
        parsing = false;
        result = null;
        error = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public Subtitle getAndClearResult()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (error != null)
        {
            throw error;
        }
        break MISSING_BLOCK_LABEL_32;
        Exception exception;
        exception;
        error = null;
        result = null;
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        Subtitle subtitle = result;
        error = null;
        result = null;
        this;
        JVM INSTR monitorexit ;
        return subtitle;
    }

    public SampleHolder getSampleHolder()
    {
        this;
        JVM INSTR monitorenter ;
        SampleHolder sampleholder = sampleHolder;
        this;
        JVM INSTR monitorexit ;
        return sampleholder;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean handleMessage(Message message)
    {
        SampleHolder sampleholder = (SampleHolder)message.obj;
        Subtitle subtitle;
        message = new ByteArrayInputStream(sampleholder.data.array(), 0, sampleholder.size);
        subtitle = parser.parse(message, null, sampleHolder.timeUs);
        message = null;
_L3:
        this;
        JVM INSTR monitorenter ;
        if (sampleHolder == sampleholder)
        {
            break MISSING_BLOCK_LABEL_63;
        }
_L1:
        this;
        JVM INSTR monitorexit ;
        return true;
        result = subtitle;
        error = message;
        parsing = false;
          goto _L1
        message;
        this;
        JVM INSTR monitorexit ;
        throw message;
        message;
        subtitle = null;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public boolean isParsing()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = parsing;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void startParseOperation()
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        if (parsing)
        {
            flag = false;
        }
        Assertions.checkState(flag);
        parsing = true;
        result = null;
        error = null;
        handler.obtainMessage(0, sampleHolder).sendToTarget();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
