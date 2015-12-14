// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;


// Referenced classes of package com.applovin.impl.sdk:
//            aq, bw, AppLovinSdkImpl, as, 
//            av

class ar
    implements Runnable
{

    final aq a;

    ar(aq aq1)
    {
        a = aq1;
        super();
    }

    public void run()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(aq.a(a));
        builder.setTitle((CharSequence)aq.b(a).a(bw.X));
        builder.setMessage((CharSequence)aq.b(a).a(bw.Y));
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence)aq.b(a).a(bw.Z), new as(this));
        builder.setNegativeButton((CharSequence)aq.b(a).a(bw.aa), new av(this));
        builder.show();
    }
}
