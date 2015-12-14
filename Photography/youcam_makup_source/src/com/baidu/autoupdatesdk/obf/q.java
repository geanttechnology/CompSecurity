// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.os.Handler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            o, aj

public class q extends o
{

    private static final int f = 1;
    private String a;
    private RandomAccessFile b;
    private long c;
    private a d;
    private int e;

    public q(Handler handler)
    {
        super(handler);
        c = 0L;
        e = -100;
    }

    private void b(int i, long l1, long l2)
    {
        if (i - e < 1)
        {
            return;
        } else
        {
            e = i;
            a(i, l1, l2);
            return;
        }
    }

    private void e(Throwable throwable, String s)
    {
        d = a.d;
        if (b != null)
        {
            try
            {
                b.close();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            b = null;
        }
        a(throwable, s);
    }

    private void k()
    {
        d = a.b;
        a();
    }

    private void l()
    {
        d = a.e;
        b();
    }

    public void a()
    {
        aj.a("BDAutoUpdateSDK", "FileHttpResponseHandler\uFF1AonDownloadStart");
    }

    public void a(int i, long l1, long l2)
    {
        if (i % 10 == 0)
        {
            aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("FileHttpResponseHandler\uFF1AonDownloadPercent: ").append(i).toString());
        }
    }

    public void a(int i, String s)
    {
        super.a(i, s);
        if (d == a.d || b == null)
        {
            return;
        }
        try
        {
            long l1 = b.length();
            c = (long)i + l1;
            b((int)((100L * l1) / c), l1, c);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            e(s, null);
        }
        s.printStackTrace();
    }

    public void a(String s)
    {
        a = s;
    }

    public void a(Throwable throwable, String s)
    {
        aj.a("BDAutoUpdateSDK", "FileHttpResponseHandler\uFF1AonDownloadFail");
    }

    public void a(byte abyte0[], int i)
    {
        super.a(abyte0, i);
        if (d == a.d || b == null)
        {
            return;
        }
        try
        {
            b.write(abyte0, 0, i);
            long l1 = b.length();
            b((int)((100L * l1) / c), l1, c);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            e(abyte0, null);
        }
        abyte0.printStackTrace();
    }

    public void b()
    {
        aj.a("BDAutoUpdateSDK", "FileHttpResponseHandler\uFF1AonDownloadSuccess");
    }

    public void b(Throwable throwable, String s)
    {
        super.b(throwable, s);
        e(throwable, s);
    }

    public void c()
    {
        super.c();
    }

    public void d()
    {
        super.d();
        k();
        try
        {
            if (b != null)
            {
                b.close();
            }
            b = new RandomAccessFile(a, "rw");
            long l1 = b.length();
            b.seek(l1);
            if (c <= 0L)
            {
                c = 0x7fffffffL;
            }
            return;
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            e(filenotfoundexception, null);
            filenotfoundexception.printStackTrace();
            return;
        }
        catch (IOException ioexception)
        {
            e(ioexception, null);
            ioexception.printStackTrace();
            return;
        }
    }

    public void e()
    {
        super.e();
        if (d == a.d || b == null)
        {
            return;
        }
        try
        {
            b.close();
            b = null;
            b(100, c, c);
            l();
            return;
        }
        catch (IOException ioexception)
        {
            e(((Throwable) (ioexception)), null);
            ioexception.printStackTrace();
            return;
        }
    }

    public void j()
    {
        if (b != null)
        {
            try
            {
                b.close();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            b = null;
        }
    }

    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        private static final a f[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/baidu/autoupdatesdk/obf/q$a, s);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        static 
        {
            a = new a("NULL", 0);
            b = new a("START", 1);
            c = new a("DOWNLIADING", 2);
            d = new a("FAIL", 3);
            e = new a("SUCCESS", 4);
            f = (new a[] {
                a, b, c, d, e
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

}
