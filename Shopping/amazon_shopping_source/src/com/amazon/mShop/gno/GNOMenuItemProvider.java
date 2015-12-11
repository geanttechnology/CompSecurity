// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import java.util.Collection;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItem

public abstract class GNOMenuItemProvider
{

    public GNOMenuItemProvider()
    {
    }

    public abstract GNODrawerItem getItem(String s);

    public abstract Collection getItems();
}
