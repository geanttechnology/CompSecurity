// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import com.groupon.models.Place;
import java.util.List;

// Referenced classes of package com.groupon.adapter:
//            FilteringAdapter

public class LocationIndexerAdapter extends FilteringAdapter
{

    public LocationIndexerAdapter(Context context, int i, List list)
    {
        super(context, i, list);
    }

    protected String getStringRepresentation(Place place)
    {
        return place.value;
    }

    protected volatile String getStringRepresentation(Object obj)
    {
        return getStringRepresentation((Place)obj);
    }
}
