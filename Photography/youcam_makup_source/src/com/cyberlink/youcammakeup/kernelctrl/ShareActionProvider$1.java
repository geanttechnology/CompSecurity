// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import com.cyberlink.youcammakeup.utility.o;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            aa, ShareActionProvider

class c
    implements aa
{

    final o a;
    final String b;
    final String c;
    final ShareActionProvider d;

    public void a()
    {
        a.g(ShareActionProvider.b(d));
    }

    public void a(int i)
    {
        a.a(i);
    }

    public void a(Exception exception)
    {
        ShareActionProvider.a(d, exception);
    }

    public void a(ArrayList arraylist)
    {
        a.g(ShareActionProvider.b(d));
        d.a(b, c, "image/*", arraylist);
    }

    A(ShareActionProvider shareactionprovider, o o1, String s, String s1)
    {
        d = shareactionprovider;
        a = o1;
        b = s;
        c = s1;
        super();
    }
}
