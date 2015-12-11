// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import com.amazon.mShop.util.Util;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemGroup, GNODrawerItemHideable, GNODrawerItemSimple, GNODrawerItem

public static class children extends er
{

    protected List children;

    public GNODrawerItemGroup build()
    {
        GNODrawerItemGroup gnodraweritemgroup = (GNODrawerItemGroup)super.build();
        if (!Util.isEmpty(children))
        {
            gnodraweritemgroup.setChildren(children);
        }
        return gnodraweritemgroup;
    }

    public volatile GNODrawerItemHideable build()
    {
        return build();
    }

    public volatile GNODrawerItemSimple build()
    {
        return build();
    }

    public build withChild(GNODrawerItem gnodraweritem)
    {
        children.add(gnodraweritem);
        return (children)self();
    }

    public self withSubView(int i)
    {
        return (self)self();
    }

    public volatile  withSubView(int i)
    {
        return withSubView(i);
    }

    public (Context context, String s)
    {
        super(new GNODrawerItemGroup(context, s));
        super.withSubView(com.amazon.mShop.android.lib.oup_icon);
        children = new ArrayList();
    }

    public children(GNODrawerItemGroup gnodraweritemgroup)
    {
        super(gnodraweritemgroup);
        super.withSubView(com.amazon.mShop.android.lib.oup_icon);
        children = new ArrayList();
    }
}
