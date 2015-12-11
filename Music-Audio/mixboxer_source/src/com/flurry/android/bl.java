// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

final class bl
{

    private int dA;
    private int dB;
    private String dv;
    private long dw;
    private long dx;
    private int dy;
    private int dz;

    bl()
    {
    }

    bl(DataInput datainput)
        throws IOException
    {
        dv = datainput.readUTF();
        dw = datainput.readLong();
        dx = datainput.readLong();
        dy = datainput.readInt();
        dz = datainput.readInt();
        dA = datainput.readInt();
        dB = datainput.readInt();
    }

    bl(String s, long l, long l1, int i, int j, 
            int k)
    {
        dv = s;
        dw = l;
        dx = l1;
        dz = i;
        dA = j;
        dB = k;
        dy = 0;
    }

    final void a(DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeUTF(dv);
        dataoutput.writeLong(dw);
        dataoutput.writeLong(dx);
        dataoutput.writeInt(dy);
        dataoutput.writeInt(dz);
        dataoutput.writeInt(dA);
        dataoutput.writeInt(dB);
    }

    public final bl aa()
    {
        bl bl1 = new bl(dv, dw, dx, dz, dA, dB);
        bl1.dy = dy;
        return bl1;
    }

    public final String ab()
    {
        return dv;
    }

    public final int ac()
    {
        return dy;
    }

    public final void ad()
    {
        dy = dy + 1;
    }

    public final int ae()
    {
        return dz;
    }

    public final int af()
    {
        return dA;
    }

    public final int ag()
    {
        return dB;
    }

    public final long ah()
    {
        return dx;
    }

    public final long ai()
    {
        return dw;
    }
}
