// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.parser;

import java.io.IOException;
import java.io.InputStream;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.codec.DecodeMonitor;
import org.apache.james.mime4j.stream.BodyDescriptorBuilder;
import org.apache.james.mime4j.stream.EntityState;
import org.apache.james.mime4j.stream.MimeConfig;
import org.apache.james.mime4j.stream.MimeTokenStream;
import org.apache.james.mime4j.stream.RecursionMode;

// Referenced classes of package org.apache.james.mime4j.parser:
//            ContentHandler

public class MimeStreamParser
{

    private boolean contentDecoding;
    private ContentHandler handler;
    private final MimeTokenStream mimeTokenStream;

    public MimeStreamParser()
    {
        this(new MimeTokenStream(new MimeConfig(), null, null));
    }

    public MimeStreamParser(MimeConfig mimeconfig)
    {
        this(mimeconfig, null, null);
    }

    public MimeStreamParser(MimeConfig mimeconfig, DecodeMonitor decodemonitor, BodyDescriptorBuilder bodydescriptorbuilder)
    {
        if (mimeconfig != null)
        {
            mimeconfig = mimeconfig.clone();
        } else
        {
            mimeconfig = new MimeConfig();
        }
        this(new MimeTokenStream(mimeconfig, decodemonitor, bodydescriptorbuilder));
    }

    public MimeStreamParser(MimeTokenStream mimetokenstream)
    {
        handler = null;
        mimeTokenStream = mimetokenstream;
        contentDecoding = false;
    }

    public boolean isContentDecoding()
    {
        return contentDecoding;
    }

    public boolean isRaw()
    {
        return mimeTokenStream.isRaw();
    }

    public void parse(InputStream inputstream)
        throws MimeException, IOException
    {
        MimeConfig mimeconfig = mimeTokenStream.getConfig();
        static class _cls1
        {

            static final int $SwitchMap$org$apache$james$mime4j$stream$EntityState[];

            static 
            {
                $SwitchMap$org$apache$james$mime4j$stream$EntityState = new int[EntityState.values().length];
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_BODY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_BODYPART.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_HEADER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_MESSAGE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_MULTIPART.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_END_OF_STREAM.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_EPILOGUE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_FIELD.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_PREAMBLE.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_RAW_ENTITY.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_START_BODYPART.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_START_HEADER.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_START_MESSAGE.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$apache$james$mime4j$stream$EntityState[EntityState.T_START_MULTIPART.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (mimeconfig.getHeadlessParsing() != null)
        {
            inputstream = mimeTokenStream.parseHeadless(inputstream, mimeconfig.getHeadlessParsing());
            handler.startMessage();
            handler.startHeader();
            handler.field(inputstream);
            handler.endHeader();
        } else
        {
            mimeTokenStream.parse(inputstream);
        }
_L17:
        inputstream = mimeTokenStream.getState();
        _cls1..SwitchMap.org.apache.james.mime4j.stream.EntityState[inputstream.ordinal()];
        JVM INSTR tableswitch 1 14: default 152
    //                   1 190
    //                   2 246
    //                   3 258
    //                   4 270
    //                   5 282
    //                   6 425
    //                   7 294
    //                   8 313
    //                   9 332
    //                   10 351
    //                   11 370
    //                   12 382
    //                   13 394
    //                   14 406;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L15:
        break MISSING_BLOCK_LABEL_406;
_L7:
        break MISSING_BLOCK_LABEL_425;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalStateException((new StringBuilder()).append("Invalid state: ").append(inputstream).toString());
_L2:
        org.apache.james.mime4j.stream.BodyDescriptor bodydescriptor = mimeTokenStream.getBodyDescriptor();
        if (contentDecoding)
        {
            inputstream = mimeTokenStream.getDecodedInputStream();
        } else
        {
            inputstream = mimeTokenStream.getInputStream();
        }
        handler.body(bodydescriptor, inputstream);
_L18:
        mimeTokenStream.next();
        if (true) goto _L17; else goto _L16
_L16:
        handler.endBodyPart();
          goto _L18
_L4:
        handler.endHeader();
          goto _L18
_L5:
        handler.endMessage();
          goto _L18
_L6:
        handler.endMultipart();
          goto _L18
_L8:
        handler.epilogue(mimeTokenStream.getInputStream());
          goto _L18
_L9:
        handler.field(mimeTokenStream.getField());
          goto _L18
_L10:
        handler.preamble(mimeTokenStream.getInputStream());
          goto _L18
_L11:
        handler.raw(mimeTokenStream.getInputStream());
          goto _L18
_L12:
        handler.startBodyPart();
          goto _L18
_L13:
        handler.startHeader();
          goto _L18
_L14:
        handler.startMessage();
          goto _L18
        handler.startMultipart(mimeTokenStream.getBodyDescriptor());
          goto _L18
    }

    public void setContentDecoding(boolean flag)
    {
        contentDecoding = flag;
    }

    public void setContentHandler(ContentHandler contenthandler)
    {
        handler = contenthandler;
    }

    public void setFlat()
    {
        mimeTokenStream.setRecursionMode(RecursionMode.M_FLAT);
    }

    public void setRaw()
    {
        mimeTokenStream.setRecursionMode(RecursionMode.M_RAW);
    }

    public void setRecurse()
    {
        mimeTokenStream.setRecursionMode(RecursionMode.M_RECURSE);
    }

    public void stop()
    {
        mimeTokenStream.stop();
    }
}
