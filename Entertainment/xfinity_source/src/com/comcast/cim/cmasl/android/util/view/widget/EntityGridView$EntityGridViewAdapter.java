// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.view.LayoutInflater;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.widget:
//            ViewHolderBaseAdapter, EntityGridView

public static abstract class entities extends ViewHolderBaseAdapter
{

    private List entities;

    public int getCount()
    {
        return entities.size();
    }

    public Object getItem(int i)
    {
        return entities.get(i);
    }

    public void setEntities(List list)
    {
        entities = list;
    }

    public Y(LayoutInflater layoutinflater)
    {
        super(layoutinflater);
        entities = new ArrayList();
    }
}
