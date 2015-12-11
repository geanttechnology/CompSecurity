// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.impl;

import java.io.IOException;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.TextBuffer;

// Referenced classes of package org.codehaus.jackson.impl:
//            JsonParserMinimalBase, JsonReadContext

public abstract class JsonParserBase extends JsonParserMinimalBase
{

    protected byte _binaryValue[];
    protected ByteArrayBuilder _byteArrayBuilder;
    protected boolean _closed;
    protected long _currInputProcessed;
    protected int _currInputRow;
    protected int _currInputRowStart;
    protected int _inputEnd;
    protected int _inputPtr;
    protected final IOContext _ioContext;
    protected boolean _nameCopied;
    protected char _nameCopyBuffer[];
    protected JsonToken _nextToken;
    protected JsonReadContext _parsingContext;
    protected final TextBuffer _textBuffer;
    protected int _tokenInputCol;
    protected int _tokenInputRow;
    protected long _tokenInputTotal;

    protected JsonParserBase(IOContext iocontext, int i)
    {
        _inputPtr = 0;
        _inputEnd = 0;
        _currInputProcessed = 0L;
        _currInputRow = 1;
        _currInputRowStart = 0;
        _tokenInputTotal = 0L;
        _tokenInputRow = 1;
        _tokenInputCol = 0;
        _nameCopyBuffer = null;
        _nameCopied = false;
        _byteArrayBuilder = null;
        _features = i;
        _ioContext = iocontext;
        _textBuffer = iocontext.constructTextBuffer();
        _parsingContext = JsonReadContext.createRootContext(_tokenInputRow, _tokenInputCol);
    }

    protected abstract void _closeInput()
        throws IOException;

    protected void _handleEOF()
        throws JsonParseException
    {
        if (!_parsingContext.inRoot())
        {
            _reportInvalidEOF((new StringBuilder()).append(": expected close marker for ").append(_parsingContext.getTypeDesc()).append(" (from ").append(_parsingContext.getStartLocation(_ioContext.getSourceReference())).append(")").toString());
        }
    }

    protected void _releaseBuffers()
        throws IOException
    {
        _textBuffer.releaseBuffers();
        char ac[] = _nameCopyBuffer;
        if (ac != null)
        {
            _nameCopyBuffer = null;
            _ioContext.releaseNameCopyBuffer(ac);
        }
    }

    protected void _reportMismatchedEndMarker(int i, char c)
        throws JsonParseException
    {
        String s = (new StringBuilder()).append("").append(_parsingContext.getStartLocation(_ioContext.getSourceReference())).toString();
        _reportError((new StringBuilder()).append("Unexpected close marker '").append((char)i).append("': expected '").append(c).append("' (for ").append(_parsingContext.getTypeDesc()).append(" starting at ").append(s).append(")").toString());
    }

    public void close()
        throws IOException
    {
        if (_closed)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        _closed = true;
        _closeInput();
        _releaseBuffers();
        return;
        Exception exception;
        exception;
        _releaseBuffers();
        throw exception;
    }

    public JsonLocation getCurrentLocation()
    {
        int i = _inputPtr;
        int j = _currInputRowStart;
        return new JsonLocation(_ioContext.getSourceReference(), (_currInputProcessed + (long)_inputPtr) - 1L, _currInputRow, (i - j) + 1);
    }

    public String getCurrentName()
        throws IOException, JsonParseException
    {
        if (_currToken == JsonToken.START_OBJECT || _currToken == JsonToken.START_ARRAY)
        {
            return _parsingContext.getParent().getCurrentName();
        } else
        {
            return _parsingContext.getCurrentName();
        }
    }

    protected abstract boolean loadMore()
        throws IOException;

    protected final void loadMoreGuaranteed()
        throws IOException
    {
        if (!loadMore())
        {
            _reportInvalidEOF();
        }
    }
}
