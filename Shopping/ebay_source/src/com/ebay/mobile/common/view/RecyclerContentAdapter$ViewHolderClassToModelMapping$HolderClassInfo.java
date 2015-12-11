// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;

// Referenced classes of package com.ebay.mobile.common.view:
//            RecyclerContentAdapter, ViewHolder

static class constructor
{

    private final Constructor constructor;
    private final int layoutResourceId;

    public ViewHolder createViewHolder(ViewGroup viewgroup, LayoutInflater layoutinflater)
    {
        viewgroup = layoutinflater.inflate(layoutResourceId, viewgroup, false);
        try
        {
            viewgroup = (ViewHolder)constructor.newInstance(new Object[] {
                viewgroup
            });
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            viewgroup.printStackTrace();
            return null;
        }
        return viewgroup;
    }

    public (Class class1, int i)
    {
        layoutResourceId = i;
        Object obj = null;
        try
        {
            class1 = class1.getDeclaredConstructor(new Class[] {
                android/view/View
            });
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            class1 = obj;
        }
        constructor = class1;
    }
}
