// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.widget.EditText;
import com.groupon.adapter.BaseGlobalSearchLocationIndexerAdapter;
import com.groupon.models.Place;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import com.groupon.util.SearchInterfaceProvider;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class Wrapper extends BaseGlobalSearchLocationIndexerAdapter
{

    final GlobalSearchFragment this$0;

    public void onLocationClick(Place place)
    {
        GlobalSearchFragment.access$500(GlobalSearchFragment.this).clearFocus();
        GlobalSearchFragment.access$600(GlobalSearchFragment.this).saveRecentLocation(place);
        GlobalSearchFragment.access$2900(GlobalSearchFragment.this, place, GlobalSearchFragment.access$600(GlobalSearchFragment.this).isUserLocation(place));
        GlobalSearchFragment.access$300(GlobalSearchFragment.this).requestTextFocus();
        GlobalSearchFragment.access$3000(GlobalSearchFragment.this);
    }

    Wrapper(Context context, LocationsAutocompleteServiceWrapper locationsautocompleteservicewrapper, String s, List list)
    {
        this$0 = GlobalSearchFragment.this;
        super(context, locationsautocompleteservicewrapper, s, list);
    }
}
