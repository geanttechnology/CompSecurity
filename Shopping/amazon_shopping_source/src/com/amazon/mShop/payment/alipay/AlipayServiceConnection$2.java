// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.payment.alipay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;

// Referenced classes of package com.amazon.mShop.payment.alipay:
//            AlipayServiceConnection

class this._cls0 extends com.alipay.android.app.b
{

    final AlipayServiceConnection this$0;

    public boolean isHideLoadingScreen()
        throws RemoteException
    {
        return false;
    }

    public void payEnd(boolean flag, String s)
        throws RemoteException
    {
    }

    public void startActivity(String s, String s1, int i, Bundle bundle)
        throws RemoteException
    {
        Intent intent = new Intent("android.intent.action.MAIN", null);
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        try
        {
            bundle1.putInt("CallingPid", i);
            intent.putExtras(bundle1);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        intent.setClassName(s, s1);
        AlipayServiceConnection.access$300(AlipayServiceConnection.this).startActivity(intent);
    }

    ()
    {
        this$0 = AlipayServiceConnection.this;
        super();
    }
}
