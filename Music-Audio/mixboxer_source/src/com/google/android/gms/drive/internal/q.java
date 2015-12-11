// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.iw;
import com.google.android.gms.internal.ix;
import com.google.android.gms.internal.iy;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.jb;
import java.io.IOException;

public final class q extends iz
{

    public static final q rs[] = new q[0];
    public String rt;
    public long ru;
    public long rv;
    private int rw;
    public int versionCode;

    public q()
    {
        versionCode = 1;
        rt = "";
        ru = -1L;
        rv = -1L;
        rw = -1;
    }

    public static q e(byte abyte0[])
        throws iy
    {
        return (q)iz.a(new q(), abyte0);
    }

    public q a(iw iw1)
        throws IOException
    {
        do
        {
            int i = iw1.fU();
            switch (i)
            {
            default:
                if (jb.a(iw1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                versionCode = iw1.fW();
                break;

            case 18: // '\022'
                rt = iw1.readString();
                break;

            case 24: // '\030'
                ru = iw1.fX();
                break;

            case 32: // ' '
                rv = iw1.fX();
                break;
            }
        } while (true);
    }

    public void a(ix ix1)
        throws IOException
    {
        ix1.d(1, versionCode);
        ix1.b(2, rt);
        ix1.c(3, ru);
        ix1.c(4, rv);
    }

    public iz b(iw iw1)
        throws IOException
    {
        return a(iw1);
    }

    public int cP()
    {
        int i = 0 + ix.e(1, versionCode) + ix.e(2, rt) + ix.d(3, ru) + ix.d(4, rv);
        rw = i;
        return i;
    }

}
