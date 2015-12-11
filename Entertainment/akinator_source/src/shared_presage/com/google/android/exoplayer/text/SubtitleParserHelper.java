// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import shared_presage.com.google.android.exoplayer.SampleHolder;
import shared_presage.com.google.android.exoplayer.util.Assertions;

// Referenced classes of package shared_presage.com.google.android.exoplayer.text:
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

    public final void flush()
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

    public final Subtitle getAndClearResult()
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

    public final SampleHolder getSampleHolder()
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

    public final boolean handleMessage(Message message)
    {
        Object obj;
        SampleHolder sampleholder;
        obj = null;
        sampleholder = (SampleHolder)message.obj;
        Subtitle subtitle;
        message = new ByteArrayInputStream(sampleholder.data.array(), 0, sampleholder.size);
        subtitle = parser.parse(message, null, sampleHolder.timeUs);
        message = obj;
_L2:
        this;
        JVM INSTR monitorenter ;
        if (sampleHolder == sampleholder)
        {
            result = subtitle;
            error = message;
            parsing = false;
        }
        this;
        JVM INSTR monitorexit ;
        return true;
        message;
        subtitle = null;
        if (true) goto _L2; else goto _L1
_L1:
        message;
        throw message;
    }

    public final boolean isParsing()
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

    public final void startParseOperation()
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
