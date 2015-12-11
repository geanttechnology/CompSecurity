// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;

// Referenced classes of package com.google.protobuf:
//            MessageLiteOrBuilder, CodedOutputStream, CodedInputStream, ExtensionRegistryLite

public interface MessageLite
    extends MessageLiteOrBuilder
{
    public static interface Builder
        extends MessageLiteOrBuilder, Cloneable
    {

        public abstract MessageLite build();

        public abstract Builder mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
            throws IOException;
    }


    public abstract int getSerializedSize();

    public abstract Builder toBuilder();

    public abstract byte[] toByteArray();

    public abstract void writeTo(CodedOutputStream codedoutputstream)
        throws IOException;
}
