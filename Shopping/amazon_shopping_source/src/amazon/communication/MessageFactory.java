// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;

import com.amazon.communication.ByteBufferChainMessageImpl;
import com.amazon.communication.InputStreamMessageImpl;
import java.io.InputStream;
import java.nio.ByteBuffer;

// Referenced classes of package amazon.communication:
//            Message

public final class MessageFactory
{

    private MessageFactory()
    {
    }

    public static Message createMessage(InputStream inputstream)
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("InputStream should not be null");
        } else
        {
            return new InputStreamMessageImpl(inputstream);
        }
    }

    public static Message createMessage(ByteBuffer abytebuffer[])
    {
        if (abytebuffer == null || abytebuffer.length == 0)
        {
            throw new IllegalArgumentException("ByteBuffer should not be null");
        } else
        {
            return new ByteBufferChainMessageImpl(abytebuffer);
        }
    }
}
