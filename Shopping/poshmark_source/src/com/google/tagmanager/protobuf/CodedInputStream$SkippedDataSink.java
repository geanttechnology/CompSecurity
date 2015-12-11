// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.tagmanager.protobuf:
//            CodedInputStream

private class <init>
    implements <init>
{

    private ByteArrayOutputStream byteArrayStream;
    private int lastPos;
    final CodedInputStream this$0;

    ByteBuffer getSkippedData()
    {
        if (byteArrayStream == null)
        {
            return ByteBuffer.wrap(CodedInputStream.access$100(CodedInputStream.this), lastPos, CodedInputStream.access$000(CodedInputStream.this) - lastPos);
        } else
        {
            byteArrayStream.write(CodedInputStream.access$100(CodedInputStream.this), lastPos, CodedInputStream.access$000(CodedInputStream.this));
            return ByteBuffer.wrap(byteArrayStream.toByteArray());
        }
    }

    public void onRefill()
    {
        if (byteArrayStream == null)
        {
            byteArrayStream = new ByteArrayOutputStream();
        }
        byteArrayStream.write(CodedInputStream.access$100(CodedInputStream.this), lastPos, CodedInputStream.access$000(CodedInputStream.this) - lastPos);
        lastPos = 0;
    }

    private ()
    {
        this$0 = CodedInputStream.this;
        super();
        lastPos = CodedInputStream.access$000(CodedInputStream.this);
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
