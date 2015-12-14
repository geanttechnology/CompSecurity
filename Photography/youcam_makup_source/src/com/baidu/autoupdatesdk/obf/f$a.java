// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            q, f

final class b extends q
{

    final f a;
    private boolean b;

    public void a()
    {
        super.a();
        f.c(a).a();
    }

    public void a(int i, long l, long l1)
    {
        super.a(i, l, l1);
        f.c(a).a(i, l, l1);
    }

    public void a(int i, String s)
    {
        super.a(i, s);
    }

    public void a(Message message)
    {
        super.a(message);
    }

    public void a(Throwable throwable, String s)
    {
        super.a(throwable, s);
        f.c(a).a(throwable, s);
    }

    public void a(byte abyte0[], int i)
    {
        super.a(abyte0, i);
        if (f.e(a) != null)
        {
            f.e(a).c();
        }
    }

    public void b()
    {
        super.b();
        f.c(a).b();
        b = true;
    }

    public void b(Throwable throwable, String s)
    {
        super.b(throwable, s);
        f.d(a);
    }

    public void c()
    {
        super.c();
        if (b)
        {
            a.a(true);
        }
    }

    public (f f1, Handler handler)
    {
        a = f1;
        super(handler);
        b = false;
    }
}
