// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.support.design.widget.al;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.paypal.android.sdk:
//            gn, fy, ju, ki, 
//            gp, fz, gb, gh, 
//            gq, hk, hc

public abstract class ha
{

    public static final Logger a = Logger.getLogger(com/paypal/android/sdk/gn.getName());
    public static ha b;

    public ha()
    {
    }

    public abstract al a(gn gn1);

    public abstract ki a(fy fy, ju ju);

    public abstract void a(fy fy, gp gp);

    public abstract void a(fy fy, Object obj);

    public abstract void a(fz fz, fy fy);

    public abstract void a(gb gb, SSLSocket sslsocket, boolean flag);

    public abstract void a(gh gh, String s);

    public abstract void a(gn gn1, fy fy, ju ju, gq gq);

    public abstract boolean a(fy fy);

    public abstract int b(fy fy);

    public abstract hk b(gn gn1);

    public abstract void b(fy fy, ju ju);

    public abstract hc c(gn gn1);

    public abstract boolean c(fy fy);

}
