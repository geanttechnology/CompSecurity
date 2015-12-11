// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;


// Referenced classes of package com.crashlytics.android.core:
//            CodedOutputStream, ByteString

final class logBytes extends sage
{

    private static final int PROTOBUF_TAG = 6;
    ByteString logBytes;

    public final int getPropertiesSize()
    {
        return CodedOutputStream.computeBytesSize(1, logBytes);
    }

    public final void writeProperties(CodedOutputStream codedoutputstream)
    {
        codedoutputstream.writeBytes(1, logBytes);
    }

    public sage(ByteString bytestring)
    {
        super(6, new sage[0]);
        logBytes = bytestring;
    }
}
