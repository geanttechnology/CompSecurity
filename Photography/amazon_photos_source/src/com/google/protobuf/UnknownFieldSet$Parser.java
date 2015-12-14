// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;

// Referenced classes of package com.google.protobuf:
//            AbstractParser, UnknownFieldSet, InvalidProtocolBufferException, CodedInputStream, 
//            ExtensionRegistryLite

public static final class ception extends AbstractParser
{

    public UnknownFieldSet parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        extensionregistrylite = UnknownFieldSet.newBuilder();
        try
        {
            extensionregistrylite.mergeFrom(codedinputstream);
        }
        // Misplaced declaration of an exception variable
        catch (CodedInputStream codedinputstream)
        {
            throw codedinputstream.setUnfinishedMessage(extensionregistrylite.buildPartial());
        }
        // Misplaced declaration of an exception variable
        catch (CodedInputStream codedinputstream)
        {
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(extensionregistrylite.buildPartial());
        }
        return extensionregistrylite.buildPartial();
    }

    public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(codedinputstream, extensionregistrylite);
    }

    public ception()
    {
    }
}
