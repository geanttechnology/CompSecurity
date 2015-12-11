// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import android.os.Message;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

// Referenced classes of package com.a.a.a:
//            f, p

class q extends f
{

    final p a;

    q(p p1)
    {
        a = p1;
        super();
    }

    public void a(String s)
    {
        p.a(a, s);
    }

    public void a(Throwable throwable, String s)
    {
        p.a(a, a.a(throwable, s));
    }

    void a(HttpResponse httpresponse)
    {
        p.a(a, httpresponse.getStatusLine().getStatusCode());
        super.a(httpresponse);
    }

    protected void b(Message message)
    {
        a(message);
    }
}
