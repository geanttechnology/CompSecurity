// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            HandShake

class b
{

    long a;
    long b;
    boolean c;
    final HandShake d;

    final void a(android.content.peHandShake pehandshake, String s)
    {
        pehandshake.utLong((new StringBuilder("handshake_lastvideo_")).append(s).toString(), a);
        pehandshake.utLong((new StringBuilder("handshake_videointerval_")).append(s).toString(), b);
    }

    (HandShake handshake)
    {
        d = handshake;
        super();
        a = 0L;
        b = 0L;
    }
}
