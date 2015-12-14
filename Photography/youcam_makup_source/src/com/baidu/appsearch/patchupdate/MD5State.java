// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.appsearch.patchupdate;


class MD5State
{

    byte buffer[];
    long count;
    int state[];

    public MD5State()
    {
        buffer = new byte[64];
        count = 0L;
        state = new int[4];
        state[0] = 0x67452301;
        state[1] = 0xefcdab89;
        state[2] = 0x98badcfe;
        state[3] = 0x10325476;
    }

    public MD5State(MD5State md5state)
    {
        boolean flag = false;
        this();
        int i = 0;
        int j;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i >= buffer.length)
            {
                break;
            }
            buffer[i] = md5state.buffer[i];
            i++;
        } while (true);
        for (; j < state.length; j++)
        {
            state[j] = md5state.state[j];
        }

        count = md5state.count;
    }
}
