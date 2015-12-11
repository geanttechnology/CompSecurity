// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.tagmanager.protobuf:
//            MessageLiteOrBuilder, MessageLite, InvalidProtocolBufferException, ExtensionRegistryLite, 
//            ByteString, CodedInputStream

public static interface rException
    extends MessageLiteOrBuilder, Cloneable
{

    public abstract MessageLite build();

    public abstract MessageLite buildPartial();

    public abstract  clear();

    public abstract  clone();

    public abstract boolean mergeDelimitedFrom(InputStream inputstream)
        throws IOException;

    public abstract boolean mergeDelimitedFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException;

    public abstract e mergeFrom(ByteString bytestring)
        throws InvalidProtocolBufferException;

    public abstract e mergeFrom(ByteString bytestring, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException;

    public abstract rException mergeFrom(CodedInputStream codedinputstream)
        throws IOException;

    public abstract e mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException;

    public abstract e mergeFrom(InputStream inputstream)
        throws IOException;

    public abstract e mergeFrom(InputStream inputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException;

    public abstract e mergeFrom(byte abyte0[])
        throws InvalidProtocolBufferException;

    public abstract rException mergeFrom(byte abyte0[], int i, int j)
        throws InvalidProtocolBufferException;

    public abstract e mergeFrom(byte abyte0[], int i, int j, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException;

    public abstract e mergeFrom(byte abyte0[], ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException;
}
