// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net.http;

import com.sessionm.core.i;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class d
{

    private File eJ;
    private ByteArrayOutputStream gI;
    private byte gJ[];
    private String gK;

    public d(ByteArrayOutputStream bytearrayoutputstream)
    {
        gI = bytearrayoutputstream;
    }

    public void b(File file)
    {
        eJ = file;
    }

    public String bA()
    {
        if (gI == null)
        {
            return null;
        }
        if (gK != null)
        {
            return gK;
        } else
        {
            gK = gI.toString();
            return gK;
        }
    }

    public byte[] bB()
    {
        if (gI == null)
        {
            return null;
        }
        if (gJ != null)
        {
            return gJ;
        } else
        {
            gJ = gI.toByteArray();
            return gJ;
        }
    }

    public File bz()
    {
        return eJ;
    }

    protected void finalize()
    {
        if (gI != null)
        {
            i.a(gI);
        }
        try
        {
            super.finalize();
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }
}
