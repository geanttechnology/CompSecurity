// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;

import bl;
import d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Referenced classes of package com.nuance.nmsp.client.sdk.oem:
//            h

public final class d
    implements bl
{

    private File a;
    private FileInputStream b;

    public d()
    {
        a = null;
        b = null;
    }

    public final int a(byte abyte0[], int i)
    {
        if (a == null)
        {
            return -1;
        }
        if (b == null)
        {
            try
            {
                b = new FileInputStream(a);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                a = null;
                return -1;
            }
        }
        try
        {
            i = b.read(abyte0, 0, i);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            try
            {
                b.close();
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[]) { }
            b = null;
            a = null;
            return -1;
        }
        return i;
    }

    public final void a()
    {
        if (b != null)
        {
            try
            {
                b.close();
            }
            catch (IOException ioexception) { }
        }
        b = null;
        a = null;
    }

    public final boolean a(String s, bl.a a1)
    {
        a = new File(s);
        boolean flag;
        if (a1 == bl.a.a)
        {
            if (!a.exists())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a = null;
        }
        return !flag;
    }

    public final long b()
    {
        if (a == null)
        {
            return -1L;
        } else
        {
            return a.length();
        }
    }

    public final boolean c()
    {
        if (a != null)
        {
            File file;
            if (b != null)
            {
                try
                {
                    b.close();
                }
                catch (IOException ioexception) { }
            }
            b = null;
            file = a;
            a = null;
            return file.delete();
        } else
        {
            return false;
        }
    }

    static 
    {
        d.a(com/nuance/nmsp/client/sdk/oem/h);
    }
}
