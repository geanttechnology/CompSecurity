// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;

// Referenced classes of package com.google.protobuf:
//            AbstractParser, DynamicMessage, InvalidProtocolBufferException, CodedInputStream, 
//            ExtensionRegistryLite

class nit> extends AbstractParser
{

    final DynamicMessage this$0;

    public DynamicMessage parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        ilder ilder = DynamicMessage.newBuilder(DynamicMessage.access$200(DynamicMessage.this));
        try
        {
            ilder.mergeFrom(codedinputstream, extensionregistrylite);
        }
        // Misplaced declaration of an exception variable
        catch (CodedInputStream codedinputstream)
        {
            throw codedinputstream.setUnfinishedMessage(ilder.buildPartial());
        }
        // Misplaced declaration of an exception variable
        catch (CodedInputStream codedinputstream)
        {
            throw (new InvalidProtocolBufferException(codedinputstream.getMessage())).setUnfinishedMessage(ilder.buildPartial());
        }
        return ilder.buildPartial();
    }

    public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(codedinputstream, extensionregistrylite);
    }

    fferException()
    {
        this$0 = DynamicMessage.this;
        super();
    }
}
