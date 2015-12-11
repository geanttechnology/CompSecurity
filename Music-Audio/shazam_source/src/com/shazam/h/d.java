// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.shazam.h:
//            x, o

public final class d
    implements x
{
    public static final class a
    {

        public final Collection a = new ArrayList();

        public final a a(x x1)
        {
            a.add(x1);
            return this;
        }

        public final d a()
        {
            return new d(this, (byte)0);
        }

        public a()
        {
        }
    }


    private final Collection b;

    private d(a a1)
    {
        b = a1.a;
    }

    d(a a1, byte byte0)
    {
        this(a1);
    }

    public final void onConnecting(URL url)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((x)iterator.next()).onConnecting(url)) { }
    }

    public final void onRequestSent(URL url, byte abyte0[])
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((x)iterator.next()).onRequestSent(url, abyte0)) { }
    }

    public final void onResponseReceived(URL url, o o)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((x)iterator.next()).onResponseReceived(url, o)) { }
    }
}
