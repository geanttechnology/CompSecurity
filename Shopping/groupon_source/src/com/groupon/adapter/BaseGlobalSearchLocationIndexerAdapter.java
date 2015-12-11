// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.groupon.models.Place;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.adapter:
//            LocationIndexerAdapter

public abstract class BaseGlobalSearchLocationIndexerAdapter extends LocationIndexerAdapter
{

    private static final int TYPE_CURRENT_LOCATION = 1;
    private static final int TYPE_OTHER_LOCATION = 0;
    private static final int VIEW_TYPE = 2;
    private String currentLocation;
    private LayoutInflater layoutInflater;
    private LocationsAutocompleteServiceWrapper locationsAutocompleteServiceWrapper;

    public BaseGlobalSearchLocationIndexerAdapter(Context context, LocationsAutocompleteServiceWrapper locationsautocompleteservicewrapper, String s, List list)
    {
        super(context, -1, list);
        currentLocation = s;
        locationsAutocompleteServiceWrapper = locationsautocompleteservicewrapper;
        layoutInflater = LayoutInflater.from(context);
    }

    public int getItemViewType(int i)
    {
        Object obj = (Place)originalObjects.get(i);
        obj = Strings.toString(locationsAutocompleteServiceWrapper.getLocationDisplayLabel(((Place) (obj))));
        return i != 0 || !((String) (obj)).equals(currentLocation) ? 0 : 1;
    }

    protected int getLayoutView(int i)
    {
        return i != 1 ? 0x7f030112 : 0x7f0300b5;
    }

    public View getView(int i, View view, final ViewGroup suggestion)
    {
        int j = getItemViewType(i);
        suggestion = (Place)originalObjects.get(i);
        if (view == null)
        {
            view = layoutInflater.inflate(getLayoutView(j), null);
        }
        view = (TextView)view.findViewById(0x7f100204);
        view.setText(locationsAutocompleteServiceWrapper.getLocationDisplayLabel(suggestion));
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseGlobalSearchLocationIndexerAdapter this$0;
            final Place val$suggestion;

            public void onClick(View view1)
            {
                onLocationClick(suggestion);
            }

            
            {
                this$0 = BaseGlobalSearchLocationIndexerAdapter.this;
                suggestion = place;
                super();
            }
        });
        return view;
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public abstract void onLocationClick(Place place);
}
