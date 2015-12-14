// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import com.tencent.open.a.k;
import com.tencent.tauth.d;

// Referenced classes of package com.tencent.connect.b:
//            e, g

class i
    implements Runnable
{

    String a;
    final e b;

    public i(e e1, String s)
    {
        b = e1;
        super();
        a = "";
        a = s;
    }

    public void run()
    {
        k.b("openSDK_LOG.authDlg", (new StringBuilder()).append("-->timeoutUrl: ").append(a).append(" | mRetryUrl: ").append(e.i(b)).toString());
        if (a.equals(e.i(b)))
        {
            e.f(b).a(new d(9002, "\u8BF7\u6C42\u9875\u9762\u8D85\u65F6\uFF0C\u8BF7\u7A0D\u540E\u91CD\u8BD5\uFF01", e.i(b)));
            b.dismiss();
        }
    }
}
