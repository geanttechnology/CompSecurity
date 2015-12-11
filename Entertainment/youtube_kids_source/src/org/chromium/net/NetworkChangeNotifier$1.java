// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;


// Referenced classes of package org.chromium.net:
//            NetworkChangeNotifier

class a
    implements oDetect.Observer
{

    private NetworkChangeNotifier a;

    public final void a(double d)
    {
        NetworkChangeNotifier.a(a, d);
    }

    public final void a(int i)
    {
        NetworkChangeNotifier.a(a, i);
    }

    oDetect.Observer(NetworkChangeNotifier networkchangenotifier)
    {
        a = networkchangenotifier;
        super();
    }
}
