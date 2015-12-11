// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;

import java.io.IOException;
import java.io.InputStream;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.codec.Base64InputStream;
import org.apache.james.mime4j.codec.DecodeMonitor;
import org.apache.james.mime4j.codec.QuotedPrintableInputStream;
import org.apache.james.mime4j.io.BufferedLineReaderInputStream;
import org.apache.james.mime4j.io.LimitedInputStream;
import org.apache.james.mime4j.io.LineNumberSource;
import org.apache.james.mime4j.io.LineReaderInputStream;
import org.apache.james.mime4j.io.LineReaderInputStreamAdaptor;
import org.apache.james.mime4j.io.MaxHeaderLimitException;
import org.apache.james.mime4j.io.MaxLineLimitException;
import org.apache.james.mime4j.io.MimeBoundaryInputStream;
import org.apache.james.mime4j.util.ByteArrayBuffer;
import org.apache.james.mime4j.util.MimeUtil;

// Referenced classes of package org.apache.james.mime4j.stream:
//            EntityStateMachine, MimeConfig, EntityState, DefaultFieldBuilder, 
//            BodyDescriptor, RecursionMode, RawEntity, BodyDescriptorBuilder, 
//            FieldBuilder, Event, MimeParseEventException, RawField, 
//            Field

class MimeEntity
    implements EntityStateMachine
{

    private BodyDescriptor body;
    private final BodyDescriptorBuilder bodyDescBuilder;
    private final MimeConfig config;
    private MimeBoundaryInputStream currentMimePartStream;
    private LineReaderInputStreamAdaptor dataStream;
    private boolean endOfHeader;
    private final EntityState endState;
    private Field field;
    private final FieldBuilder fieldBuilder;
    private int headerCount;
    private final BufferedLineReaderInputStream inbuffer;
    private int lineCount;
    private final LineNumberSource lineSource;
    private final ByteArrayBuffer linebuf;
    private final DecodeMonitor monitor;
    private RecursionMode recursionMode;
    private EntityState state;
    private byte tmpbuf[];

    MimeEntity(LineNumberSource linenumbersource, InputStream inputstream, BodyDescriptorBuilder bodydescriptorbuilder)
    {
        this(linenumbersource, inputstream, new MimeConfig(), EntityState.T_START_MESSAGE, EntityState.T_END_MESSAGE, DecodeMonitor.SILENT, ((FieldBuilder) (new DefaultFieldBuilder(-1))), bodydescriptorbuilder);
    }

    MimeEntity(LineNumberSource linenumbersource, InputStream inputstream, FieldBuilder fieldbuilder, BodyDescriptorBuilder bodydescriptorbuilder)
    {
        this(linenumbersource, inputstream, new MimeConfig(), EntityState.T_START_MESSAGE, EntityState.T_END_MESSAGE, DecodeMonitor.SILENT, fieldbuilder, bodydescriptorbuilder);
    }

    MimeEntity(LineNumberSource linenumbersource, InputStream inputstream, MimeConfig mimeconfig, BodyDescriptorBuilder bodydescriptorbuilder)
    {
        EntityState entitystate = EntityState.T_START_MESSAGE;
        EntityState entitystate1 = EntityState.T_END_MESSAGE;
        DecodeMonitor decodemonitor;
        if (mimeconfig.isStrictParsing())
        {
            decodemonitor = DecodeMonitor.STRICT;
        } else
        {
            decodemonitor = DecodeMonitor.SILENT;
        }
        this(linenumbersource, inputstream, mimeconfig, entitystate, entitystate1, decodemonitor, ((FieldBuilder) (new DefaultFieldBuilder(mimeconfig.getMaxHeaderLen()))), bodydescriptorbuilder);
    }

    MimeEntity(LineNumberSource linenumbersource, InputStream inputstream, MimeConfig mimeconfig, EntityState entitystate, EntityState entitystate1, DecodeMonitor decodemonitor, FieldBuilder fieldbuilder, 
            BodyDescriptorBuilder bodydescriptorbuilder)
    {
        config = mimeconfig;
        state = entitystate;
        endState = entitystate1;
        monitor = decodemonitor;
        fieldBuilder = fieldbuilder;
        bodyDescBuilder = bodydescriptorbuilder;
        linebuf = new ByteArrayBuffer(64);
        lineCount = 0;
        endOfHeader = false;
        headerCount = 0;
        lineSource = linenumbersource;
        inbuffer = new BufferedLineReaderInputStream(inputstream, 4096, mimeconfig.getMaxLineLen());
        dataStream = new LineReaderInputStreamAdaptor(inbuffer, mimeconfig.getMaxLineLen());
    }

    MimeEntity(LineNumberSource linenumbersource, InputStream inputstream, MimeConfig mimeconfig, EntityState entitystate, EntityState entitystate1, BodyDescriptorBuilder bodydescriptorbuilder)
    {
        DecodeMonitor decodemonitor;
        if (mimeconfig.isStrictParsing())
        {
            decodemonitor = DecodeMonitor.STRICT;
        } else
        {
            decodemonitor = DecodeMonitor.SILENT;
        }
        this(linenumbersource, inputstream, mimeconfig, entitystate, entitystate1, decodemonitor, ((FieldBuilder) (new DefaultFieldBuilder(mimeconfig.getMaxHeaderLen()))), bodydescriptorbuilder);
    }

    private void advanceToBoundary()
        throws IOException
    {
        if (!dataStream.eof())
        {
            if (tmpbuf == null)
            {
                tmpbuf = new byte[2048];
            }
            for (InputStream inputstream = getLimitedContentStream(); inputstream.read(tmpbuf) != -1;) { }
        }
    }

    private void clearMimePartStream()
    {
        currentMimePartStream = null;
        dataStream = new LineReaderInputStreamAdaptor(inbuffer, config.getMaxLineLen());
    }

    private void createMimePartStream()
        throws MimeException, IOException
    {
        String s = body.getBoundary();
        try
        {
            currentMimePartStream = new MimeBoundaryInputStream(inbuffer, s, config.isStrictParsing());
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new MimeException(illegalargumentexception.getMessage(), illegalargumentexception);
        }
        dataStream = new LineReaderInputStreamAdaptor(currentMimePartStream, config.getMaxLineLen());
    }

    private InputStream decodedStream(InputStream inputstream)
    {
        String s = body.getTransferEncoding();
        Object obj;
        if (MimeUtil.isBase64Encoding(s))
        {
            obj = new Base64InputStream(inputstream, monitor);
        } else
        {
            obj = inputstream;
            if (MimeUtil.isQuotedPrintableEncoded(s))
            {
                return new QuotedPrintableInputStream(inputstream, monitor);
            }
        }
        return ((InputStream) (obj));
    }

    private LineReaderInputStream getDataStream()
    {
        return dataStream;
    }

    private InputStream getLimitedContentStream()
    {
        long l = config.getMaxContentLen();
        if (l >= 0L)
        {
            return new LimitedInputStream(dataStream, l);
        } else
        {
            return dataStream;
        }
    }

    private int getLineNumber()
    {
        if (lineSource == null)
        {
            return -1;
        } else
        {
            return lineSource.getLineNumber();
        }
    }

    private EntityStateMachine nextMessage()
    {
        Object obj;
        if (currentMimePartStream != null)
        {
            obj = currentMimePartStream;
        } else
        {
            obj = inbuffer;
        }
        obj = decodedStream(((InputStream) (obj)));
        return nextMimeEntity(EntityState.T_START_MESSAGE, EntityState.T_END_MESSAGE, ((InputStream) (obj)));
    }

    private EntityStateMachine nextMimeEntity()
    {
        return nextMimeEntity(EntityState.T_START_BODYPART, EntityState.T_END_BODYPART, ((InputStream) (currentMimePartStream)));
    }

    private EntityStateMachine nextMimeEntity(EntityState entitystate, EntityState entitystate1, InputStream inputstream)
    {
        if (recursionMode == RecursionMode.M_RAW)
        {
            return new RawEntity(inputstream);
        } else
        {
            entitystate = new MimeEntity(lineSource, inputstream, config, entitystate, entitystate1, monitor, fieldBuilder, bodyDescBuilder.newChild());
            entitystate.setRecursionMode(recursionMode);
            return entitystate;
        }
    }

    private void readRawField()
        throws IOException, MimeException
    {
        LineReaderInputStream linereaderinputstream;
        if (endOfHeader)
        {
            throw new IllegalStateException();
        }
        linereaderinputstream = getDataStream();
_L2:
        int i;
        int j;
        try
        {
            if (linebuf.length() > 0)
            {
                fieldBuilder.append(linebuf);
            }
            linebuf.clear();
            if (linereaderinputstream.readLine(linebuf) == -1)
            {
                monitor(Event.HEADERS_PREMATURE_END);
                endOfHeader = true;
                return;
            }
        }
        catch (MaxLineLimitException maxlinelimitexception)
        {
            throw new MimeException(maxlinelimitexception);
        }
        j = linebuf.length();
        i = j;
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        i = j;
        if (linebuf.byteAt(j - 1) == 10)
        {
            i = j - 1;
        }
        j = i;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        j = i;
        if (linebuf.byteAt(i - 1) == 13)
        {
            j = i - 1;
        }
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        endOfHeader = true;
        return;
        lineCount = lineCount + 1;
        if (lineCount <= 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = linebuf.byteAt(0);
        if (i != 32 && i != 9)
        {
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static final String stateToString(EntityState entitystate)
    {
        static class _cls1
        {

            static final int $SwitchMap$org$apache$james$mime4j$stream$EntityState[];

            static 
            {
                $SwitchMap$org$apache$james$mime4j$stream$EntityState = new int[EntityState.values().length];
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_START_MESSAGE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_START_BODYPART.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_START_HEADER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_FIELD.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_HEADER.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_START_MULTIPART.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_PREAMBLE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_EPILOGUE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_BODY.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_MULTIPART.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_OF_STREAM.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_MESSAGE.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_RAW_ENTITY.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_BODYPART.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.org.apache.james.mime4j.stream.EntityState[entitystate.ordinal()])
        {
        default:
            return "Unknown";

        case 11: // '\013'
            return "End of stream";

        case 1: // '\001'
            return "Start message";

        case 12: // '\f'
            return "End message";

        case 13: // '\r'
            return "Raw entity";

        case 3: // '\003'
            return "Start header";

        case 4: // '\004'
            return "Field";

        case 5: // '\005'
            return "End header";

        case 6: // '\006'
            return "Start multipart";

        case 10: // '\n'
            return "End multipart";

        case 7: // '\007'
            return "Preamble";

        case 8: // '\b'
            return "Epilogue";

        case 2: // '\002'
            return "Start bodypart";

        case 14: // '\016'
            return "End bodypart";

        case 9: // '\t'
            return "Body";
        }
    }

    public EntityStateMachine advance()
        throws IOException, MimeException
    {
        _cls1..SwitchMap.org.apache.james.mime4j.stream.EntityState[state.ordinal()];
        JVM INSTR tableswitch 1 10: default 64
    //                   1 84
    //                   2 94
    //                   3 104
    //                   4 113
    //                   5 139
    //                   6 242
    //                   7 287
    //                   8 341
    //                   9 374
    //                   10 374;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L10
_L1:
        if (state != endState) goto _L12; else goto _L11
_L11:
        state = EntityState.T_END_OF_STREAM;
_L17:
        return null;
_L2:
        state = EntityState.T_START_HEADER;
        continue; /* Loop/switch isn't completed */
_L3:
        state = EntityState.T_START_HEADER;
        continue; /* Loop/switch isn't completed */
_L4:
        bodyDescBuilder.reset();
_L5:
        EntityState entitystate;
        if (nextField())
        {
            entitystate = EntityState.T_FIELD;
        } else
        {
            entitystate = EntityState.T_END_HEADER;
        }
        state = entitystate;
        continue; /* Loop/switch isn't completed */
_L6:
        body = bodyDescBuilder.build();
        String s = body.getMimeType();
        if (recursionMode == RecursionMode.M_FLAT)
        {
            state = EntityState.T_BODY;
        } else
        if (MimeUtil.isMultipart(s))
        {
            state = EntityState.T_START_MULTIPART;
            clearMimePartStream();
        } else
        {
            if (recursionMode != RecursionMode.M_NO_RECURSE && MimeUtil.isMessage(s))
            {
                state = EntityState.T_BODY;
                return nextMessage();
            }
            state = EntityState.T_BODY;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (dataStream.isUsed())
        {
            advanceToBoundary();
            state = EntityState.T_END_MULTIPART;
            continue; /* Loop/switch isn't completed */
        }
        createMimePartStream();
        state = EntityState.T_PREAMBLE;
        if (!currentMimePartStream.isEmptyStream())
        {
            continue; /* Loop/switch isn't completed */
        }
_L8:
        advanceToBoundary();
        if (!currentMimePartStream.eof() || currentMimePartStream.isLastPart()) goto _L14; else goto _L13
_L13:
        monitor(Event.MIME_BODY_PREMATURE_END);
_L16:
        boolean flag = currentMimePartStream.isFullyConsumed();
        clearMimePartStream();
        state = EntityState.T_EPILOGUE;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
_L9:
        state = EntityState.T_END_MULTIPART;
        continue; /* Loop/switch isn't completed */
_L14:
        if (currentMimePartStream.isLastPart()) goto _L16; else goto _L15
_L15:
        clearMimePartStream();
        createMimePartStream();
        return nextMimeEntity();
_L10:
        state = endState;
        if (true) goto _L17; else goto _L12
_L12:
        throw new IllegalStateException((new StringBuilder()).append("Invalid state: ").append(stateToString(state)).toString());
    }

    public BodyDescriptor getBodyDescriptor()
    {
        switch (_cls1..SwitchMap.org.apache.james.mime4j.stream.EntityState[getState().ordinal()])
        {
        case 10: // '\n'
        default:
            throw new IllegalStateException((new StringBuilder()).append("Invalid state :").append(stateToString(state)).toString());

        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 11: // '\013'
            return body;
        }
    }

    public InputStream getContentStream()
    {
        switch (_cls1..SwitchMap.org.apache.james.mime4j.stream.EntityState[state.ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Invalid state: ").append(stateToString(state)).toString());

        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
            return getLimitedContentStream();
        }
    }

    public InputStream getDecodedContentStream()
        throws IllegalStateException
    {
        return decodedStream(getContentStream());
    }

    public Field getField()
    {
        switch (_cls1..SwitchMap.org.apache.james.mime4j.stream.EntityState[getState().ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Invalid state :").append(stateToString(state)).toString());

        case 4: // '\004'
            return field;
        }
    }

    public RecursionMode getRecursionMode()
    {
        return recursionMode;
    }

    public EntityState getState()
    {
        return state;
    }

    protected String message(Event event)
    {
        int i;
        if (event == null)
        {
            event = "Event is unexpectedly null.";
        } else
        {
            event = event.toString();
        }
        i = getLineNumber();
        if (i <= 0)
        {
            return event;
        } else
        {
            return (new StringBuilder()).append("Line ").append(i).append(": ").append(event).toString();
        }
    }

    protected void monitor(Event event)
        throws MimeException, IOException
    {
        if (monitor.isListening())
        {
            String s = message(event);
            if (monitor.warn(s, "ignoring"))
            {
                throw new MimeParseEventException(event);
            }
        }
    }

    protected boolean nextField()
        throws MimeException, IOException
    {
        int i = config.getMaxHeaderCount();
_L4:
        if (!endOfHeader) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (i > 0 && headerCount >= i)
        {
            throw new MaxHeaderLimitException("Maximum header limit exceeded");
        }
        headerCount = headerCount + 1;
        fieldBuilder.reset();
        readRawField();
        Object obj = fieldBuilder.build();
        if (obj == null) goto _L4; else goto _L3
_L3:
        Field field1;
        if (((RawField) (obj)).getDelimiterIdx() != ((RawField) (obj)).getName().length())
        {
            monitor(Event.OBSOLETE_HEADER);
        }
        field1 = bodyDescBuilder.addField(((RawField) (obj)));
        if (field1 != null)
        {
            obj = field1;
        }
        field = ((Field) (obj));
        return true;
        MimeException mimeexception;
        mimeexception;
        monitor(Event.INVALID_HEADER);
        if (!config.isMalformedHeaderStartsBody()) goto _L4; else goto _L5
_L5:
        LineReaderInputStream linereaderinputstream = getDataStream();
        ByteArrayBuffer bytearraybuffer = fieldBuilder.getRaw();
        if (bytearraybuffer == null || !linereaderinputstream.unread(bytearraybuffer))
        {
            throw new MimeParseEventException(Event.INVALID_HEADER);
        }
          goto _L1
    }

    public void setRecursionMode(RecursionMode recursionmode)
    {
        recursionMode = recursionmode;
    }

    public void stop()
    {
        inbuffer.truncate();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getName()).append(" [").append(stateToString(state)).append("][").append(body.getMimeType()).append("][").append(body.getBoundary()).append("]").toString();
    }
}
