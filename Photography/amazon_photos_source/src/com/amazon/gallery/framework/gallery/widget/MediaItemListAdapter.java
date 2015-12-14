// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ViewFactory

public class MediaItemListAdapter extends ArrayAdapter
{

    private static final String TAG = com/amazon/gallery/framework/gallery/widget/MediaItemListAdapter.getName();
    private final List items;
    private final ViewFactory viewFactory;

    public MediaItemListAdapter(Context context, List list, ViewFactory viewfactory)
    {
        super(context, 0, list);
        viewFactory = viewfactory;
        items = list;
    }

    public List getItems()
    {
        return items;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = (MediaItem)getItem(i);
        return viewFactory.getView(i, viewgroup, view);
    }

}
