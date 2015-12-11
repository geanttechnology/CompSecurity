// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.util.DebugUtil;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemProviderDebug, GNODrawer

class this._cls0
    implements OnClickListener
{

    final GNOMenuItemProviderDebug this$0;

    public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
    {
        DebugUtil.overrideWeblabAssignment(amazonactivity);
    }

    OnClickListener()
    {
        this$0 = GNOMenuItemProviderDebug.this;
        super();
    }
}
