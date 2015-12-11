// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket.handshake;


// Referenced classes of package org.java_websocket.handshake:
//            ClientHandshake, HandshakeBuilder

public interface ClientHandshakeBuilder
    extends ClientHandshake, HandshakeBuilder
{

    public abstract void setResourceDescriptor(String s);
}
