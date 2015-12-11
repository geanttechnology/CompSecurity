// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AmazonOOAdRegistrationExecutor, AmazonOOAdPreferencesURLListener

class val.adPreferencesURL
    implements Runnable
{

    final val.adPreferencesURL this$0;
    final String val$adPreferencesURL;

    public void run()
    {
        cess._mth100(this._cls0.this).onAdPreferencesURLFetched(val$adPreferencesURL);
    }

    ()
    {
        this$0 = final_;
        val$adPreferencesURL = String.this;
        super();
    }
}
