// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.tagmanager.protobuf:
//            Parser, ExtensionRegistryLite, InvalidProtocolBufferException, MessageLite, 
//            UninitializedMessageException, AbstractMessageLite, AbstractMutableMessageLite, CodedInputStream, 
//            ByteString

public abstract class AbstractParser
    implements Parser
{

    private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();

    public AbstractParser()
    {
    }

    private MessageLite checkMessageInitialized(MessageLite messagelite)
        throws InvalidProtocolBufferException
    {
        if (messagelite != null && !messagelite.isInitialized())
        {
            throw newUninitializedMessageException(messagelite).asInvalidProtocolBufferException().setUnfinishedMessage(messagelite);
        } else
        {
            return messagelite;
        }
    }

    private UninitializedMessageException newUninitializedMessageException(MessageLite messagelite)
    {
        if (messagelite instanceof AbstractMessageLite)
        {
            return ((AbstractMessageLite)messagelite).newUninitializedMessageException();
        }
        if (messagelite instanceof AbstractMutableMessageLite)
        {
            return ((AbstractMutableMessageLite)messagelite).newUninitializedMessageException();
        } else
        {
            return new UninitializedMessageException(messagelite);
        }
    }

    public MessageLite parseDelimitedFrom(InputStream inputstream)
        throws InvalidProtocolBufferException
    {
        return parseDelimitedFrom(inputstream, EMPTY_REGISTRY);
    }

    public MessageLite parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return checkMessageInitialized(parsePartialDelimitedFrom(inputstream, extensionregistrylite));
    }

    public volatile Object parseDelimitedFrom(InputStream inputstream)
        throws InvalidProtocolBufferException
    {
        return parseDelimitedFrom(inputstream);
    }

    public volatile Object parseDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parseDelimitedFrom(inputstream, extensionregistrylite);
    }

    public MessageLite parseFrom(ByteString bytestring)
        throws InvalidProtocolBufferException
    {
        return parseFrom(bytestring, EMPTY_REGISTRY);
    }

    public MessageLite parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return checkMessageInitialized(parsePartialFrom(bytestring, extensionregistrylite));
    }

    public MessageLite parseFrom(CodedInputStream codedinputstream)
        throws InvalidProtocolBufferException
    {
        return parseFrom(codedinputstream, EMPTY_REGISTRY);
    }

    public MessageLite parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return checkMessageInitialized((MessageLite)parsePartialFrom(codedinputstream, extensionregistrylite));
    }

    public MessageLite parseFrom(InputStream inputstream)
        throws InvalidProtocolBufferException
    {
        return parseFrom(inputstream, EMPTY_REGISTRY);
    }

    public MessageLite parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return checkMessageInitialized(parsePartialFrom(inputstream, extensionregistrylite));
    }

    public MessageLite parseFrom(byte abyte0[])
        throws InvalidProtocolBufferException
    {
        return parseFrom(abyte0, EMPTY_REGISTRY);
    }

    public MessageLite parseFrom(byte abyte0[], int i, int j)
        throws InvalidProtocolBufferException
    {
        return parseFrom(abyte0, i, j, EMPTY_REGISTRY);
    }

    public MessageLite parseFrom(byte abyte0[], int i, int j, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return checkMessageInitialized(parsePartialFrom(abyte0, i, j, extensionregistrylite));
    }

    public MessageLite parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parseFrom(abyte0, 0, abyte0.length, extensionregistrylite);
    }

    public volatile Object parseFrom(ByteString bytestring)
        throws InvalidProtocolBufferException
    {
        return parseFrom(bytestring);
    }

    public volatile Object parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parseFrom(bytestring, extensionregistrylite);
    }

    public volatile Object parseFrom(CodedInputStream codedinputstream)
        throws InvalidProtocolBufferException
    {
        return parseFrom(codedinputstream);
    }

    public volatile Object parseFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parseFrom(codedinputstream, extensionregistrylite);
    }

    public volatile Object parseFrom(InputStream inputstream)
        throws InvalidProtocolBufferException
    {
        return parseFrom(inputstream);
    }

    public volatile Object parseFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parseFrom(inputstream, extensionregistrylite);
    }

    public volatile Object parseFrom(byte abyte0[])
        throws InvalidProtocolBufferException
    {
        return parseFrom(abyte0);
    }

    public volatile Object parseFrom(byte abyte0[], int i, int j)
        throws InvalidProtocolBufferException
    {
        return parseFrom(abyte0, i, j);
    }

    public volatile Object parseFrom(byte abyte0[], int i, int j, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parseFrom(abyte0, i, j, extensionregistrylite);
    }

    public volatile Object parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parseFrom(abyte0, extensionregistrylite);
    }

    public MessageLite parsePartialDelimitedFrom(InputStream inputstream)
        throws InvalidProtocolBufferException
    {
        return parsePartialDelimitedFrom(inputstream, EMPTY_REGISTRY);
    }

    public MessageLite parsePartialDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        int i;
        try
        {
            i = inputstream.read();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new InvalidProtocolBufferException(inputstream.getMessage());
        }
        if (i == -1)
        {
            return null;
        }
        i = CodedInputStream.readRawVarint32(i, inputstream);
        return parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(inputstream, i), extensionregistrylite);
    }

    public volatile Object parsePartialDelimitedFrom(InputStream inputstream)
        throws InvalidProtocolBufferException
    {
        return parsePartialDelimitedFrom(inputstream);
    }

    public volatile Object parsePartialDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parsePartialDelimitedFrom(inputstream, extensionregistrylite);
    }

    public MessageLite parsePartialFrom(ByteString bytestring)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(bytestring, EMPTY_REGISTRY);
    }

    public MessageLite parsePartialFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        try
        {
            bytestring = bytestring.newCodedInput();
            extensionregistrylite = (MessageLite)parsePartialFrom(((CodedInputStream) (bytestring)), extensionregistrylite);
        }
        // Misplaced declaration of an exception variable
        catch (ByteString bytestring)
        {
            throw bytestring;
        }
        bytestring.checkLastTagWas(0);
        return extensionregistrylite;
        bytestring;
        throw bytestring.setUnfinishedMessage(extensionregistrylite);
        bytestring;
        throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", bytestring);
    }

    public MessageLite parsePartialFrom(CodedInputStream codedinputstream)
        throws InvalidProtocolBufferException
    {
        return (MessageLite)parsePartialFrom(codedinputstream, EMPTY_REGISTRY);
    }

    public MessageLite parsePartialFrom(InputStream inputstream)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(inputstream, EMPTY_REGISTRY);
    }

    public MessageLite parsePartialFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        inputstream = CodedInputStream.newInstance(inputstream);
        extensionregistrylite = (MessageLite)parsePartialFrom(((CodedInputStream) (inputstream)), extensionregistrylite);
        try
        {
            inputstream.checkLastTagWas(0);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw inputstream.setUnfinishedMessage(extensionregistrylite);
        }
        return extensionregistrylite;
    }

    public MessageLite parsePartialFrom(byte abyte0[])
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(abyte0, 0, abyte0.length, EMPTY_REGISTRY);
    }

    public MessageLite parsePartialFrom(byte abyte0[], int i, int j)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(abyte0, i, j, EMPTY_REGISTRY);
    }

    public MessageLite parsePartialFrom(byte abyte0[], int i, int j, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        try
        {
            abyte0 = CodedInputStream.newInstance(abyte0, i, j);
            extensionregistrylite = (MessageLite)parsePartialFrom(((CodedInputStream) (abyte0)), extensionregistrylite);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw abyte0;
        }
        abyte0.checkLastTagWas(0);
        return extensionregistrylite;
        abyte0;
        throw abyte0.setUnfinishedMessage(extensionregistrylite);
        abyte0;
        throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", abyte0);
    }

    public MessageLite parsePartialFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(abyte0, 0, abyte0.length, extensionregistrylite);
    }

    public volatile Object parsePartialFrom(ByteString bytestring)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(bytestring);
    }

    public volatile Object parsePartialFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(bytestring, extensionregistrylite);
    }

    public volatile Object parsePartialFrom(CodedInputStream codedinputstream)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(codedinputstream);
    }

    public volatile Object parsePartialFrom(InputStream inputstream)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(inputstream);
    }

    public volatile Object parsePartialFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(inputstream, extensionregistrylite);
    }

    public volatile Object parsePartialFrom(byte abyte0[])
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(abyte0);
    }

    public volatile Object parsePartialFrom(byte abyte0[], int i, int j)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(abyte0, i, j);
    }

    public volatile Object parsePartialFrom(byte abyte0[], int i, int j, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(abyte0, i, j, extensionregistrylite);
    }

    public volatile Object parsePartialFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(abyte0, extensionregistrylite);
    }

}
