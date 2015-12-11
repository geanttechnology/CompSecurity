// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.LinkedList;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.codec.DecodeMonitor;
import org.apache.james.mime4j.io.LineNumberInputStream;
import org.apache.james.mime4j.util.CharsetUtil;

// Referenced classes of package org.apache.james.mime4j.stream:
//            EntityState, RecursionMode, MimeConfig, DefaultFieldBuilder, 
//            FallbackBodyDescriptorBuilder, MimeEntity, EntityStateMachine, BodyDescriptor, 
//            RawField, BodyDescriptorBuilder, FieldBuilder, Field

public class MimeTokenStream
{

    private final BodyDescriptorBuilder bodyDescBuilder;
    private final MimeConfig config;
    private EntityStateMachine currentStateMachine;
    private final LinkedList entities;
    private final FieldBuilder fieldBuilder;
    private final DecodeMonitor monitor;
    private RecursionMode recursionMode;
    private MimeEntity rootentity;
    private EntityState state;

    public MimeTokenStream()
    {
        this(null);
    }

    public MimeTokenStream(MimeConfig mimeconfig)
    {
        this(mimeconfig, null, null, null);
    }

    public MimeTokenStream(MimeConfig mimeconfig, DecodeMonitor decodemonitor, BodyDescriptorBuilder bodydescriptorbuilder)
    {
        this(mimeconfig, decodemonitor, null, bodydescriptorbuilder);
    }

    public MimeTokenStream(MimeConfig mimeconfig, DecodeMonitor decodemonitor, FieldBuilder fieldbuilder, BodyDescriptorBuilder bodydescriptorbuilder)
    {
        entities = new LinkedList();
        state = EntityState.T_END_OF_STREAM;
        recursionMode = RecursionMode.M_RECURSE;
        if (mimeconfig == null)
        {
            mimeconfig = new MimeConfig();
        }
        config = mimeconfig;
        if (fieldbuilder == null)
        {
            fieldbuilder = new DefaultFieldBuilder(config.getMaxHeaderLen());
        }
        fieldBuilder = fieldbuilder;
        if (decodemonitor == null)
        {
            if (config.isStrictParsing())
            {
                decodemonitor = DecodeMonitor.STRICT;
            } else
            {
                decodemonitor = DecodeMonitor.SILENT;
            }
        }
        monitor = decodemonitor;
        if (bodydescriptorbuilder == null)
        {
            bodydescriptorbuilder = new FallbackBodyDescriptorBuilder();
        }
        bodyDescBuilder = bodydescriptorbuilder;
    }

    public MimeTokenStream(MimeConfig mimeconfig, BodyDescriptorBuilder bodydescriptorbuilder)
    {
        this(mimeconfig, null, null, bodydescriptorbuilder);
    }

    private void doParse(InputStream inputstream, EntityState entitystate)
    {
        InputStream inputstream1 = null;
        Object obj = inputstream;
        if (config.isCountLineNumbers())
        {
            obj = new LineNumberInputStream(inputstream);
            inputstream = ((InputStream) (obj));
            inputstream1 = inputstream;
        }
        rootentity = new MimeEntity(inputstream1, ((InputStream) (obj)), config, entitystate, EntityState.T_END_MESSAGE, monitor, fieldBuilder, bodyDescBuilder);
        rootentity.setRecursionMode(recursionMode);
        currentStateMachine = rootentity;
        entities.clear();
        entities.add(currentStateMachine);
        state = currentStateMachine.getState();
    }

    public static final String stateToString(EntityState entitystate)
    {
        return MimeEntity.stateToString(entitystate);
    }

    public BodyDescriptor getBodyDescriptor()
    {
        return currentStateMachine.getBodyDescriptor();
    }

    public MimeConfig getConfig()
    {
        return config;
    }

    public InputStream getDecodedInputStream()
    {
        return currentStateMachine.getDecodedContentStream();
    }

    public Field getField()
    {
        return currentStateMachine.getField();
    }

    public InputStream getInputStream()
    {
        return currentStateMachine.getContentStream();
    }

    public Reader getReader()
    {
        Object obj = getBodyDescriptor().getCharset();
        if (obj == null || "".equals(obj))
        {
            obj = CharsetUtil.US_ASCII;
        } else
        {
            obj = Charset.forName(((String) (obj)));
        }
        return new InputStreamReader(getDecodedInputStream(), ((Charset) (obj)));
    }

    public RecursionMode getRecursionMode()
    {
        return recursionMode;
    }

    public EntityState getState()
    {
        return state;
    }

    public boolean isRaw()
    {
        return recursionMode == RecursionMode.M_RAW;
    }

    public EntityState next()
        throws IOException, MimeException
    {
        if (state == EntityState.T_END_OF_STREAM || currentStateMachine == null)
        {
            throw new IllegalStateException("No more tokens are available.");
        }
_L3:
        if (currentStateMachine != null)
        {
            EntityStateMachine entitystatemachine = currentStateMachine.advance();
            if (entitystatemachine != null)
            {
                entities.add(entitystatemachine);
                currentStateMachine = entitystatemachine;
            }
            state = currentStateMachine.getState();
            if (state != EntityState.T_END_OF_STREAM)
            {
                return state;
            }
        } else
        {
            state = EntityState.T_END_OF_STREAM;
            return state;
        }
        if (true) goto _L2; else goto _L1
_L2:
        entities.removeLast();
        if (entities.isEmpty())
        {
            currentStateMachine = null;
        } else
        {
            currentStateMachine = (EntityStateMachine)entities.getLast();
            currentStateMachine.setRecursionMode(recursionMode);
        }
        if (true) goto _L3; else goto _L1
_L1:
    }

    public void parse(InputStream inputstream)
    {
        doParse(inputstream, EntityState.T_START_MESSAGE);
    }

    public Field parseHeadless(InputStream inputstream, String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Content type may not be null");
        }
        Object obj;
        RawField rawfield;
        try
        {
            rawfield = new RawField("Content-Type", s);
            s = bodyDescBuilder.addField(rawfield);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IllegalArgumentException(inputstream.getMessage());
        }
        obj = s;
        if (s == null)
        {
            obj = rawfield;
        }
        doParse(inputstream, EntityState.T_END_HEADER);
        try
        {
            next();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IllegalStateException(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IllegalStateException(inputstream);
        }
        return ((Field) (obj));
    }

    public void setRecursionMode(RecursionMode recursionmode)
    {
        recursionMode = recursionmode;
        if (currentStateMachine != null)
        {
            currentStateMachine.setRecursionMode(recursionmode);
        }
    }

    public void stop()
    {
        rootentity.stop();
    }
}
