// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;

// Referenced classes of package com.google.protobuf:
//            AbstractMessageLite, InvalidProtocolBufferException, ByteString, CodedInputStream, 
//            ExtensionRegistryLite

public static abstract class on
    implements on
{

    public abstract on clone();

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public clone mergeFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        try
        {
            bytestring = bytestring.newCodedInput();
            mergeFrom(((CodedInputStream) (bytestring)), extensionregistrylite);
            bytestring.checkLastTagWas(0);
        }
        // Misplaced declaration of an exception variable
        catch (ByteString bytestring)
        {
            throw bytestring;
        }
        // Misplaced declaration of an exception variable
        catch (ByteString bytestring)
        {
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", bytestring);
        }
        return this;
    }

    public abstract gWas mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException;

    public volatile gWas mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException
    {
        return mergeFrom(codedinputstream, extensionregistrylite);
    }

    public on()
    {
    }
}
