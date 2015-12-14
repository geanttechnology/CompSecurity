// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;

// Referenced classes of package com.google.protobuf:
//            Parser, ExtensionRegistryLite, InvalidProtocolBufferException, MessageLite, 
//            UninitializedMessageException, AbstractMessageLite, ByteString, CodedInputStream

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
        } else
        {
            return new UninitializedMessageException(messagelite);
        }
    }

    public MessageLite parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return checkMessageInitialized(parsePartialFrom(bytestring, extensionregistrylite));
    }

    public MessageLite parseFrom(byte abyte0[])
        throws InvalidProtocolBufferException
    {
        return parseFrom(abyte0, EMPTY_REGISTRY);
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

    public volatile Object parseFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parseFrom(bytestring, extensionregistrylite);
    }

    public volatile Object parseFrom(byte abyte0[])
        throws InvalidProtocolBufferException
    {
        return parseFrom(abyte0);
    }

    public volatile Object parseFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parseFrom(abyte0, extensionregistrylite);
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

    public volatile Object parsePartialFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(bytestring, extensionregistrylite);
    }

}
