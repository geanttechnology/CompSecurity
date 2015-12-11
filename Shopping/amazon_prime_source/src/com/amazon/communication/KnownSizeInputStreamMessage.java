// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import java.io.InputStream;

// Referenced classes of package com.amazon.communication:
//            InputStreamMessageImpl

public class KnownSizeInputStreamMessage extends InputStreamMessageImpl
{

    private final int mPayloadSize;

    public KnownSizeInputStreamMessage(InputStream inputstream, int i)
    {
        super(inputstream);
        mPayloadSize = i;
    }

    public int getPayloadSize()
    {
        return mPayloadSize;
    }
}
