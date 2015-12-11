// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.audio;

import com.google.common.net.MediaType;
import java.io.Closeable;

// Referenced classes of package com.amazon.blueshift.bluefront.android.audio:
//            AudioEncoderException

public interface AudioEncoder
    extends Closeable
{

    public abstract void close();

    public abstract byte[] encode(short aword0[], int i)
        throws AudioEncoderException;

    public abstract int getFrameSize();

    public abstract MediaType getMediaType();

    public abstract int getPacketSize();
}
