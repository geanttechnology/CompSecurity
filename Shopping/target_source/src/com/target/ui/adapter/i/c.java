// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.model.store.interfaces.StoreOperatingHours;
import com.target.ui.adapter.b.e;
import com.target.ui.view.store.StoreHoursView;
import java.util.List;

public class c extends e
{
    public static class a
    {

        public StoreHoursView view;

        public a(View view1)
        {
            view = (StoreHoursView)view1;
        }
    }


    public c(Context context, List list)
    {
        super(context, list);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        StoreOperatingHours storeoperatinghours = (StoreOperatingHours)getItem(i);
        if (view == null)
        {
            view = new StoreHoursView(getContext());
            viewgroup = new a(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (a)view.getTag();
        }
        ((a) (viewgroup)).view.setDescription(storeoperatinghours.b());
        ((a) (viewgroup)).view.setHours(storeoperatinghours);
        return view;
    }
}
