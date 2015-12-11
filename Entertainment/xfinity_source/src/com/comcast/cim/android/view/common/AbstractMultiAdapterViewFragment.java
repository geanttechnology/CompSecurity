// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.comcast.cim.android.view.common:
//            AbstractMultiViewFragment

public abstract class AbstractMultiAdapterViewFragment extends AbstractMultiViewFragment
{

    public AbstractMultiAdapterViewFragment()
    {
    }

    protected abstract android.widget.AdapterView.OnItemClickListener getOnItemClickListener();

    protected abstract android.widget.AdapterView.OnItemLongClickListener getOnItemLongClickListener();

    protected void initInfoView(int i, AbstractMultiViewFragment.AdapterViewInfo adapterviewinfo)
    {
        adapterviewinfo.view = (AdapterView)getView().findViewById(i);
        ((AdapterView)adapterviewinfo.view).setAdapter(adapterviewinfo.adapter);
        ((AdapterView)adapterviewinfo.view).setOnItemClickListener(getOnItemClickListener());
        ((AdapterView)adapterviewinfo.view).setOnItemLongClickListener(getOnItemLongClickListener());
    }
}
