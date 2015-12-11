// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codebutler.android_websockets;


// Referenced classes of package com.codebutler.android_websockets:
//            WebSocketClient

public static interface 
{

    public abstract void onConnect();

    public abstract void onDisconnect(int i, String s);

    public abstract void onError(Exception exception);

    public abstract void onMessage(String s);

    public abstract void onMessage(byte abyte0[]);
}
