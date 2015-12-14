// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;

// Referenced classes of package com.google.protobuf:
//            MessageLite, UninitializedMessageException, CodedOutputStream, ByteString, 
//            InvalidProtocolBufferException, CodedInputStream, ExtensionRegistryLite

public abstract class AbstractMessageLite
    implements MessageLite
{
    public static abstract class Builder
        implements MessageLite.Builder
    {

        public abstract Builder clone();

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public Builder mergeFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
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

        public abstract Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException;

        public volatile MessageLite.Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException
        {
            return mergeFrom(codedinputstream, extensionregistrylite);
        }

        public Builder()
        {
        }
    }


    public AbstractMessageLite()
    {
    }

    UninitializedMessageException newUninitializedMessageException()
    {
        return new UninitializedMessageException(this);
    }

    public byte[] toByteArray()
    {
        byte abyte0[];
        try
        {
            abyte0 = new byte[getSerializedSize()];
            CodedOutputStream codedoutputstream = CodedOutputStream.newInstance(abyte0);
            writeTo(codedoutputstream);
            codedoutputstream.checkNoSpaceLeft();
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", ioexception);
        }
        return abyte0;
    }

    public ByteString toByteString()
    {
        Object obj;
        try
        {
            obj = ByteString.newCodedBuilder(getSerializedSize());
            writeTo(((ByteString.CodedBuilder) (obj)).getCodedOutput());
            obj = ((ByteString.CodedBuilder) (obj)).build();
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", ioexception);
        }
        return ((ByteString) (obj));
    }
}
