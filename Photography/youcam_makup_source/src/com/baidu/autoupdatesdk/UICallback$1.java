// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk;


// Referenced classes of package com.baidu.autoupdatesdk:
//            UICallback, ICallback

class c
    implements Runnable
{

    final int a;
    final String b;
    final Object c;
    final UICallback d;

    public void run()
    {
        try
        {
            UICallback.a(d).onCallback(a, b, c);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    (UICallback uicallback, int i, String s, Object obj)
    {
        d = uicallback;
        a = i;
        b = s;
        c = obj;
        super();
    }
}
