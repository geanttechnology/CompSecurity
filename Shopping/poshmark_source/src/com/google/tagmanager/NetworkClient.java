// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.io.IOException;
import java.io.InputStream;

interface NetworkClient
{

    public static final int DEFAULT_CONNECTION_TIMEOUT_MILLIS = 20000;
    public static final int DEFAULT_SOCKET_TIMEOUT_MILLIS = 20000;

    public abstract void close();

    public abstract InputStream getInputStream(String s)
        throws IOException;

    public abstract void sendPostRequest(String s, byte abyte0[])
        throws IOException;
}
