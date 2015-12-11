// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import android.content.res.Resources;
import com.amazon.mShop.util.Util;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemProviderDefault

class val.context
    implements Callable
{

    final GNOMenuItemProviderDefault this$0;
    final Context val$context;

    public Boolean call()
        throws Exception
    {
        boolean flag;
        if (Util.isEmpty(val$context.getResources().getString(com.amazon.mShop.android.lib.)) || Util.isEmpty(val$context.getResources().getString(com.amazon.mShop.android.lib._url)))
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
        this$0 = final_gnomenuitemproviderdefault;
        val$context = Context.this;
        super();
    }
}
