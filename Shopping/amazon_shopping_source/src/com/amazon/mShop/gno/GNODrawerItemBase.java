// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.net.RefMarkerObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItem, GNODrawer

public abstract class GNODrawerItemBase
    implements GNODrawerItem
{

    private List mChildren;
    private GNODrawerItem mParent;
    private String mRefMarker;

    public GNODrawerItemBase()
    {
    }

    public boolean allowDividers()
    {
        return true;
    }

    public volatile Collection getChildren()
    {
        return getChildren();
    }

    public List getChildren()
    {
        if (mChildren != null)
        {
            return mChildren;
        } else
        {
            return Collections.emptyList();
        }
    }

    public GNODrawerItem getParent()
    {
        return mParent;
    }

    public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
    {
        if (mRefMarker != null)
        {
            RefMarkerObserver.logRefMarker(mRefMarker);
        }
    }

    public void setChildren(Collection collection)
    {
        if (collection instanceof List)
        {
            mChildren = (List)collection;
        } else
        {
            mChildren = new ArrayList(collection);
        }
        collection = mChildren.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            GNODrawerItem gnodraweritem = (GNODrawerItem)collection.next();
            if (gnodraweritem instanceof GNODrawerItemBase)
            {
                ((GNODrawerItemBase)gnodraweritem).mParent = this;
            }
        } while (true);
    }

    public void setRefMarker(String s)
    {
        mRefMarker = s;
    }
}
