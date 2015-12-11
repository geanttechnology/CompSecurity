// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.aiv;

import android.app.Activity;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.util.ActivityUtils;
import java.util.List;

// Referenced classes of package com.amazon.mShop.aiv:
//            AivHttpIntentActivity

static final class nit> extends nit>
{

    public void performCommand(Activity activity, List list)
    {
        ActivityUtils.launchDetailsPage(activity, new ProductController((String)list.get(3), ClickStreamTag.ORIGIN_DEFAULT), new int[0]);
    }

    (String s, int i, String s1)
    {
        super(s, i, s1, null);
    }
}
