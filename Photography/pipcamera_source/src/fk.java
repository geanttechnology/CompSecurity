// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class fk extends FilterOutputStream
{

    final fj a;

    private fk(fj fj1, OutputStream outputstream)
    {
        a = fj1;
        super(outputstream);
    }

    fk(fj fj1, OutputStream outputstream, fi._cls1 _pcls1)
    {
        this(fj1, outputstream);
    }

    public void close()
    {
        try
        {
            out.close();
            return;
        }
        catch (IOException ioexception)
        {
            fj.a(a, true);
        }
    }

    public void flush()
    {
        try
        {
            out.flush();
            return;
        }
        catch (IOException ioexception)
        {
            fj.a(a, true);
        }
    }

    public void write(int i)
    {
        try
        {
            out.write(i);
            return;
        }
        catch (IOException ioexception)
        {
            fj.a(a, true);
        }
    }

    public void write(byte abyte0[], int i, int j)
    {
        try
        {
            out.write(abyte0, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            fj.a(a, true);
        }
    }
}
