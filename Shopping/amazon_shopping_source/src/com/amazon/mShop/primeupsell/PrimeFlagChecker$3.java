// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.primeupsell;

import com.amazon.rio.j2me.client.services.mShop.LoginResponse;

// Referenced classes of package com.amazon.mShop.primeupsell:
//            PrimeFlagChecker

class esponse
    implements Runnable
{

    final PrimeFlagChecker this$0;
    final LoginResponse val$loginResponse;

    public void run()
    {
label0:
        {
            PrimeFlagChecker.access$100(PrimeFlagChecker.this, val$loginResponse);
            if (PrimeFlagChecker.access$000(PrimeFlagChecker.this) != null)
            {
                if (val$loginResponse == null)
                {
                    break label0;
                }
                PrimeFlagChecker.access$000(PrimeFlagChecker.this).onComplete();
            }
            return;
        }
        PrimeFlagChecker.access$000(PrimeFlagChecker.this).onError();
    }

    esponse()
    {
        this$0 = final_primeflagchecker;
        val$loginResponse = LoginResponse.this;
        super();
    }
}
