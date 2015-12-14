// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ain extends aij
{

    private final File a;
    private final String b;
    private final String c;

    public ain(File file, String s, String s1, String s2)
    {
        super(s1);
        if (file == null)
        {
            throw new IllegalArgumentException("File may not be null");
        }
        a = file;
        if (s != null)
        {
            b = s;
        } else
        {
            b = file.getName();
        }
        c = s2;
    }

    public void a(OutputStream outputstream)
    {
        FileInputStream fileinputstream;
        if (outputstream == null)
        {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        fileinputstream = new FileInputStream(a);
        byte abyte0[] = new byte[4096];
_L1:
        int i = fileinputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        outputstream.write(abyte0, 0, i);
          goto _L1
        outputstream;
        fileinputstream.close();
        throw outputstream;
        outputstream.flush();
        fileinputstream.close();
        return;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public String d()
    {
        return "binary";
    }

    public long e()
    {
        return a.length();
    }
}
