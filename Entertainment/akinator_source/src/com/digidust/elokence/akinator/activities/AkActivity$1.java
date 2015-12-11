// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import com.digidust.elokence.akinator.webservices.AkDefiWS;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity

class this._cls0 extends Thread
{

    final AkActivity this$0;

    public void run()
    {
        (new AkDefiWS()).call();
    }

    ()
    {
        this$0 = AkActivity.this;
        super();
    }
}
