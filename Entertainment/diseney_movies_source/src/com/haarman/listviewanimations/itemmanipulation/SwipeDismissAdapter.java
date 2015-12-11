// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.haarman.listviewanimations.itemmanipulation;

import android.widget.BaseAdapter;
import android.widget.ListView;
import com.haarman.listviewanimations.BaseAdapterDecorator;

// Referenced classes of package com.haarman.listviewanimations.itemmanipulation:
//            SwipeDismissListViewTouchListener, OnDismissCallback

public class SwipeDismissAdapter extends BaseAdapterDecorator
{

    private OnDismissCallback mCallback;

    public SwipeDismissAdapter(BaseAdapter baseadapter, OnDismissCallback ondismisscallback)
    {
        super(baseadapter);
        mCallback = ondismisscallback;
    }

    public void setListView(ListView listview)
    {
        super.setListView(listview);
        listview.setOnTouchListener(new SwipeDismissListViewTouchListener(listview, mCallback));
    }
}
