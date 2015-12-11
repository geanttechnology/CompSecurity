// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.models.Place;
import com.groupon.models.PlacesContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.util:
//            Function1, LocationsAutocompleteServiceWrapper

class this._cls0
    implements Function1
{

    final LocationsAutocompleteServiceWrapper this$0;

    public void execute(PlacesContainer placescontainer)
    {
        placescontainer = placescontainer.places;
        if (placescontainer != null)
        {
            LocationsAutocompleteServiceWrapper.access$002(LocationsAutocompleteServiceWrapper.this, new ArrayList());
            Place place;
            for (placescontainer = placescontainer.iterator(); placescontainer.hasNext(); LocationsAutocompleteServiceWrapper.access$000(LocationsAutocompleteServiceWrapper.this).add(place))
            {
                place = (Place)placescontainer.next();
                place.source = com.groupon.util.de.Place.searchOrigin;
                place.value = place.name;
            }

        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((PlacesContainer)obj);
    }

    de()
    {
        this$0 = LocationsAutocompleteServiceWrapper.this;
        super();
    }
}
