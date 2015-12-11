// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;

import java.io.Serializable;

public class MD5State
    implements Serializable
{

    long bitCount;
    byte buffer[];
    int state[];
    boolean valid;

    public MD5State()
    {
        valid = true;
        state = new int[4];
        buffer = new byte[64];
        reset();
    }

    public void copy(MD5State md5state)
    {
        System.arraycopy(md5state.buffer, 0, buffer, 0, buffer.length);
        System.arraycopy(md5state.state, 0, state, 0, state.length);
        valid = md5state.valid;
        bitCount = md5state.bitCount;
    }

    void reset()
    {
        state[0] = 0x67452301;
        state[1] = 0xefcdab89;
        state[2] = 0x98badcfe;
        state[3] = 0x10325476;
        bitCount = 0L;
    }
}
