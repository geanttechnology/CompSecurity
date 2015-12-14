// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.FileOutputStream;

class id
    implements Runnable
{

    final String a;
    final String b;
    final ic c;

    id(ic ic1, String s, String s1)
    {
        c = ic1;
        a = s;
        b = s1;
        super();
    }

    public void run()
    {
        byte abyte0[] = ic.a(c, a);
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(new File(b));
            fileoutputstream.write(abyte0);
            fileoutputstream.flush();
            fileoutputstream.close();
            ib.a(ic.a(c)).a(b);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
