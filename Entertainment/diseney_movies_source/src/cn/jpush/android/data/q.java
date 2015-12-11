// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;
import cn.jpush.android.util.n;
import cn.jpush.android.util.x;

// Referenced classes of package cn.jpush.android.data:
//            p

final class q extends Thread
{

    final String a;
    final Context b;
    final String c;

    q(String s, Context context, String s1)
    {
        a = s;
        b = context;
        c = s1;
        super();
    }

    public final void run()
    {
        boolean flag1 = false;
        String s = null;
        int i = 0;
        boolean flag;
        do
        {
            flag = flag1;
            if (i >= 4)
            {
                break;
            }
            i++;
            String s1 = n.a(a, 5, 8000L);
            s = s1;
            if (n.a(s1))
            {
                continue;
            }
            flag = true;
            s = s1;
            break;
        } while (true);
        if (flag && !TextUtils.isEmpty(s))
        {
            cn.jpush.android.data.p.a(b, s);
            return;
        } else
        {
            ServiceInterface.a(c, 1021, cn.jpush.android.util.a.b(b, a), b);
            ServiceInterface.a(c, 996, b);
            x.c();
            return;
        }
    }
}
