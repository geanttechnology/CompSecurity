// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.server;


// Referenced classes of package org.apache.thrift.server:
//            THsHaServer

private final class a
    implements Runnable
{

    private final rver.FrameBuffer a;

    public final void run()
    {
        a.invoke();
    }

    public rver.FrameBuffer(THsHaServer thshaserver, rver.FrameBuffer framebuffer)
    {
        a = framebuffer;
    }
}
