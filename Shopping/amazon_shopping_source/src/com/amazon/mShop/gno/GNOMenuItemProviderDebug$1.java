// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemProviderDebug, GNODrawer

static final class val.clazz
    implements OnClickListener
{

    final Class val$clazz;

    public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
    {
        amazonactivity.startActivity(ActivityUtils.getStartActivityIntent(amazonactivity, val$clazz, -1));
    }

    OnClickListener(Class class1)
    {
        val$clazz = class1;
        super();
    }
}
