// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import java.net.URL;

// Referenced classes of package com.shazam.h:
//            o

public interface x
{

    public static final x a = new x() {

        public final void onConnecting(URL url)
        {
        }

        public final void onRequestSent(URL url, byte abyte0[])
        {
        }

        public final void onResponseReceived(URL url, o o)
        {
        }

    };

    public abstract void onConnecting(URL url);

    public abstract void onRequestSent(URL url, byte abyte0[]);

    public abstract void onResponseReceived(URL url, o o);

}
