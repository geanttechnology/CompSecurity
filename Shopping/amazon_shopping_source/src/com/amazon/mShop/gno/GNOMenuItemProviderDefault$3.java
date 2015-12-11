// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import com.amazon.mShop.smile.SmileHelper;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemProviderDefault

class this._cls0
    implements Callable
{

    final GNOMenuItemProviderDefault this$0;

    public Boolean call()
        throws Exception
    {
        boolean flag;
        if (!SmileHelper.isSmile())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    ()
    {
        this$0 = GNOMenuItemProviderDefault.this;
        super();
    }
}
