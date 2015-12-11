// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import android.os.Handler;
import android.os.Message;
import com.smule.android.h;

// Referenced classes of package com.smule.android.console:
//            m, a

public class s
{

    private Handler a;

    public s(Handler handler)
    {
        a = handler;
    }

    private void a(m m1)
    {
        a(m1, null);
    }

    public void a()
    {
        a(m.c);
    }

    public void a(int i)
    {
        a(m.d, Integer.valueOf(i));
    }

    public void a(m m1, Object obj)
    {
        Message message = Message.obtain();
        message.what = m1.ordinal();
        message.setTarget(a);
        message.obj = obj;
        message.sendToTarget();
    }

    public void a(String s1)
    {
        a(m.a, s1);
    }

    public void b()
    {
        a(m.b);
    }

    public void b(String s1)
    {
        a(m.a, (new StringBuilder()).append(s1).append("\n").toString());
    }

    public void c()
    {
        a(m.f);
    }

    public void c(String s1)
    {
        b((new StringBuilder()).append(com.smule.android.console.a.a(h.error_prefix)).append(s1).toString());
    }

    public void d()
    {
        a(m.e);
    }
}
