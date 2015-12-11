// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.IOException;

// Referenced classes of package com.google.protobuf:
//            MessageLiteOrBuilder, MessageLite, CodedInputStream, ExtensionRegistryLite

public static interface e
    extends MessageLiteOrBuilder, Cloneable
{

    public abstract MessageLite build();

    public abstract e mergeFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws IOException;
}
