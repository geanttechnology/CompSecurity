// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;

import java.io.InputStream;
import java.nio.ByteBuffer;

public interface Message
{

    public abstract Message extractPayload();

    public abstract InputStream getPayload();

    public abstract int getPayloadSize();

    public abstract void prependPayload(ByteBuffer bytebuffer);
}
