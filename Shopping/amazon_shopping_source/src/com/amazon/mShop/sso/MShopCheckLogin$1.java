// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;


// Referenced classes of package com.amazon.mShop.sso:
//            MShopCheckLogin

class this._cls0
    implements Runnable
{

    final MShopCheckLogin this$0;

    public void run()
    {
        MShopCheckLogin.access$000(MShopCheckLogin.this, null);
        if (MShopCheckLogin.access$100(MShopCheckLogin.this) != null)
        {
            MShopCheckLogin.access$100(MShopCheckLogin.this).onError();
        }
    }

    bscriber()
    {
        this$0 = MShopCheckLogin.this;
        super();
    }
}
