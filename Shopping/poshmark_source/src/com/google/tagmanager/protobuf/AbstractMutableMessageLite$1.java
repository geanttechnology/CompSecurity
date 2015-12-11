// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;


// Referenced classes of package com.google.tagmanager.protobuf:
//            AbstractParser, AbstractMutableMessageLite, InvalidProtocolBufferException, MutableMessageLite, 
//            CodedInputStream, ExtensionRegistryLite

static final class val.defaultInstance extends AbstractParser
{

    final MutableMessageLite val$defaultInstance;

    public MutableMessageLite parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        MutableMessageLite mutablemessagelite = val$defaultInstance.newMessageForType();
        if (!mutablemessagelite.mergeFrom(codedinputstream, extensionregistrylite))
        {
            throw InvalidProtocolBufferException.parseFailure().setUnfinishedMessage(mutablemessagelite);
        } else
        {
            return mutablemessagelite;
        }
    }

    public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(codedinputstream, extensionregistrylite);
    }

    n(MutableMessageLite mutablemessagelite)
    {
        val$defaultInstance = mutablemessagelite;
        super();
    }
}
