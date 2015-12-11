// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.activity:
//            Redeem, IntentFactory

private class <init>
    implements android.view.istener
{

    final Redeem this$0;

    public void onClick(View view)
    {
        startActivity(((IntentFactory)Redeem.access$1000(Redeem.this).get()).newCustomerServiceIntent());
    }

    private ()
    {
        this$0 = Redeem.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
