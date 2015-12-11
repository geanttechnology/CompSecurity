// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.impl;

import java.io.IOException;
import java.io.InputStream;
import org.codehaus.jackson.io.IOContext;

// Referenced classes of package org.codehaus.jackson.impl:
//            JsonNumericParserBase

public abstract class StreamBasedParserBase extends JsonNumericParserBase
{

    protected boolean _bufferRecyclable;
    protected byte _inputBuffer[];
    protected InputStream _inputStream;

    protected StreamBasedParserBase(IOContext iocontext, int i, InputStream inputstream, byte abyte0[], int j, int k, boolean flag)
    {
        super(iocontext, i);
        _inputStream = inputstream;
        _inputBuffer = abyte0;
        _inputPtr = j;
        _inputEnd = k;
        _bufferRecyclable = flag;
    }

    protected void _closeInput()
        throws IOException
    {
        if (_inputStream != null)
        {
            if (_ioContext.isResourceManaged() || isEnabled(org.codehaus.jackson.JsonParser.Feature.AUTO_CLOSE_SOURCE))
            {
                _inputStream.close();
            }
            _inputStream = null;
        }
    }

    protected void _releaseBuffers()
        throws IOException
    {
        super._releaseBuffers();
        if (_bufferRecyclable)
        {
            byte abyte0[] = _inputBuffer;
            if (abyte0 != null)
            {
                _inputBuffer = null;
                _ioContext.releaseReadIOBuffer(abyte0);
            }
        }
    }

    protected final boolean loadMore()
        throws IOException
    {
        boolean flag1 = false;
        _currInputProcessed = _currInputProcessed + (long)_inputEnd;
        _currInputRowStart = _currInputRowStart - _inputEnd;
        boolean flag = flag1;
        if (_inputStream != null)
        {
            int i = _inputStream.read(_inputBuffer, 0, _inputBuffer.length);
            if (i > 0)
            {
                _inputPtr = 0;
                _inputEnd = i;
                flag = true;
            } else
            {
                _closeInput();
                flag = flag1;
                if (i == 0)
                {
                    throw new IOException((new StringBuilder()).append("InputStream.read() returned 0 characters when trying to read ").append(_inputBuffer.length).append(" bytes").toString());
                }
            }
        }
        return flag;
    }
}
