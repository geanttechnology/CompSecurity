// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;

// Referenced classes of package com.google.tagmanager.protobuf:
//            GeneratedMessageLite, ByteString, CodedInputStream, MessageLite, 
//            CodedOutputStream, ExtensionRegistryLite

public static abstract class unknownFields extends unknownFields
{

    private ByteString unknownFields;

    public unknownFields clear()
    {
        unknownFields = ByteString.EMPTY;
        return this;
    }

    public volatile unknownFields clear()
    {
        return clear();
    }

    public volatile clear clone()
    {
        return clone();
    }

    public clone clone()
    {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public volatile clone clone()
    {
        return clone();
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public abstract GeneratedMessageLite getDefaultInstanceForType();

    public volatile MessageLite getDefaultInstanceForType()
    {
        return getDefaultInstanceForType();
    }

    public final ByteString getUnknownFields()
    {
        return unknownFields;
    }

    public abstract unknownFields mergeFrom(GeneratedMessageLite generatedmessagelite);

    protected boolean parseUnknownField(CodedInputStream codedinputstream, CodedOutputStream codedoutputstream, ExtensionRegistryLite extensionregistrylite, int i)
        throws IOException
    {
        return codedinputstream.skipField(i, codedoutputstream);
    }

    public final unknownFields setUnknownFields(ByteString bytestring)
    {
        unknownFields = bytestring;
        return this;
    }

    protected A()
    {
        unknownFields = ByteString.EMPTY;
    }
}
