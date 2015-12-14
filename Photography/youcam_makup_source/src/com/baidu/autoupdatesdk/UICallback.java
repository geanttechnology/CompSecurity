// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.baidu.autoupdatesdk:
//            ICallback

public class UICallback
    implements ICallback
{

    private ICallback a;

    private UICallback(ICallback icallback)
    {
        a = icallback;
    }

    static ICallback a(UICallback uicallback)
    {
        return uicallback.a;
    }

    private void a(int i, String s, Object obj)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable(i, s, obj) {

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

            
            {
                d = UICallback.this;
                a = i;
                b = s;
                c = obj;
                super();
            }
        });
    }

    public static UICallback wrap(ICallback icallback)
    {
        return new UICallback(icallback);
    }

    public void onCallback(int i, String s, Object obj)
    {
        if (a == null)
        {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            a(i, s, obj);
            return;
        }
        try
        {
            a.onCallback(i, s, obj);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }
}
