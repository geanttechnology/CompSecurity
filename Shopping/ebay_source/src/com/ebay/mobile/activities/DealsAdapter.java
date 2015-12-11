// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            DealsItem, Cache

class DealsAdapter extends ArrayAdapter
{

    private final ImageCache imageCache;
    private final LayoutInflater inflater;

    public DealsAdapter(Context context, ImageCache imagecache, List list)
    {
        super(context, 0x7f030088, 0x1020014, list);
        imageCache = imagecache;
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public boolean areAllItemsEnabled()
    {
        return false;
    }

    public long getItemId(int i)
    {
        return ((DealsItem)super.getItem(i)).id;
    }

    public int getItemViewType(int i)
    {
        return ((DealsItem)getItem(i)).type;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1;
        DealsItem dealsitem;
        boolean flag;
        view1 = view;
        flag = DeviceConfiguration.getAsync().get(DcsBoolean.showEEKRatings);
        dealsitem = (DealsItem)getItem(i);
        view = view1;
        if (view1 != null) goto _L2; else goto _L1
_L1:
        dealsitem.type;
        JVM INSTR tableswitch 0 2: default 64
    //                   0 72
    //                   1 137
    //                   2 152;
           goto _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_152;
_L3:
        throw new RuntimeException();
_L4:
        view = inflater.inflate(0x7f030088, viewgroup, false);
_L2:
        if (dealsitem.type == 0)
        {
            Cache cache = (Cache)view.getTag();
            viewgroup = cache;
            if (cache == null)
            {
                viewgroup = new Cache(view);
                view.setTag(viewgroup);
            }
            viewgroup.set(dealsitem, imageCache, flag);
            return view;
        } else
        {
            ((TextView)view.findViewById(0x1020014)).setText(dealsitem.title);
            return view;
        }
_L5:
        view = inflater.inflate(0x7f030085, viewgroup, false);
          goto _L2
        view = inflater.inflate(0x7f030154, viewgroup, false);
          goto _L2
    }

    public int getViewTypeCount()
    {
        return 3;
    }

    public boolean isEnabled(int i)
    {
        return getItemViewType(i) != 2;
    }
}
