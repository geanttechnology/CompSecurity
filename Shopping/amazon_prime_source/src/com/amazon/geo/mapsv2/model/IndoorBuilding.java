// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;
import com.amazon.geo.mapsv2.model.internal.IIndoorBuildingDelegate;
import com.amazon.geo.mapsv2.model.internal.IIndoorLevelDelegate;
import com.amazon.geo.mapsv2.pvt.Wrappers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            IndoorLevel

public final class IndoorBuilding
{

    private static final com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator INDOORLEVEL_CREATOR = new com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator() {

        public IndoorLevel newWrapper(IIndoorLevelDelegate iindoorleveldelegate)
        {
            return new IndoorLevel(iindoorleveldelegate);
        }

        public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
        {
            return newWrapper((IIndoorLevelDelegate)iobjectdelegate);
        }

    };
    IIndoorBuildingDelegate mDelegate;

    public IndoorBuilding(IIndoorBuildingDelegate iindoorbuildingdelegate)
    {
        mDelegate = iindoorbuildingdelegate;
        mDelegate.setWrapper(this);
    }

    private static List createListIndoorLevel(List list)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        list = null;
_L4:
        return list;
_L2:
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            list = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            arraylist.add(Wrappers.create((IIndoorLevelDelegate)iterator.next(), INDOORLEVEL_CREATOR));
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (IndoorBuilding)obj;
        if (mDelegate != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((IndoorBuilding) (obj)).mDelegate == null) goto _L1; else goto _L3
_L3:
        return false;
        if (mDelegate.equals(((IndoorBuilding) (obj)).mDelegate)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int getActiveLevelIndex()
    {
        return mDelegate.getActiveLevelIndex();
    }

    public int getDefaultLevelIndex()
    {
        return mDelegate.getDefaultLevelIndex();
    }

    public List getLevels()
    {
        return createListIndoorLevel(mDelegate.getLevels());
    }

    public int hashCode()
    {
        int i;
        if (mDelegate == null)
        {
            i = 0;
        } else
        {
            i = mDelegate.hashCode();
        }
        return i + 31;
    }

    public boolean isUnderground()
    {
        return mDelegate.isUnderground();
    }

}
