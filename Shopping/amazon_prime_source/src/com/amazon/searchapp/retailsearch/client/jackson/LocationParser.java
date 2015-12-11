// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.jackson;

import com.amazon.searchapp.retailsearch.client.LocationListener;
import com.amazon.searchapp.retailsearch.entity.CurrentEntity;
import com.amazon.searchapp.retailsearch.entity.LocationResultsEntity;
import com.amazon.searchapp.retailsearch.entity.LocationSuggestionsEntity;
import com.amazon.searchapp.retailsearch.entity.LocationsEntity;
import com.amazon.searchapp.retailsearch.model.Current;
import com.amazon.searchapp.retailsearch.model.LocationResults;
import com.amazon.searchapp.retailsearch.model.LocationSuggestions;
import com.amazon.searchapp.retailsearch.model.Locations;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.jackson:
//            StandardParser

public class LocationParser
    implements com.amazon.searchapp.retailsearch.client.LocationServiceCall.ResponseParser
{

    private static String OBJECT_TYPE_LOCATION = "locations";
    private static String OBJECT_TYPE_LOCATION_CURRENT = "current";
    private static String OBJECT_TYPE_LOCATION_SUGGESTIONS = "locationSuggestions";

    public LocationParser()
    {
    }

    public LocationResults parse(InputStream inputstream, LocationListener locationlistener)
        throws IOException
    {
        LocationResultsEntity locationresultsentity = new LocationResultsEntity();
        if (locationlistener != null)
        {
            locationlistener.startParse(locationresultsentity);
        }
        JsonParser jsonparser = StandardParser.getMapper().getFactory().createParser(inputstream);
        if (!JsonToken.START_ARRAY.equals(jsonparser.nextToken()))
        {
            throw new IOException();
        }
        inputstream = jsonparser.nextToken();
        while (inputstream != null && !JsonToken.END_ARRAY.equals(inputstream)) 
        {
            jsonparser.nextToken();
            jsonparser.nextValue();
            inputstream = jsonparser.getValueAsString();
            if (OBJECT_TYPE_LOCATION.equals(inputstream))
            {
                inputstream = new LocationsEntity();
                jsonparser.nextValue();
                inputstream.setHeaderLabel(jsonparser.getValueAsString());
                jsonparser.nextValue();
                inputstream.setLocationSelectionLabels((List)jsonparser.readValueAs(new TypeReference() {

                    final LocationParser this$0;

            
            {
                this$0 = LocationParser.this;
                super();
            }
                }));
                jsonparser.nextValue();
                inputstream.setDomains((List)jsonparser.readValueAs(new TypeReference() {

                    final LocationParser this$0;

            
            {
                this$0 = LocationParser.this;
                super();
            }
                }));
                locationresultsentity.setLocations(inputstream);
                if (locationlistener != null)
                {
                    locationlistener.locations(inputstream);
                }
            } else
            if (OBJECT_TYPE_LOCATION_SUGGESTIONS.equals(inputstream))
            {
                inputstream = new LocationSuggestionsEntity();
                jsonparser.nextValue();
                inputstream.setGroups((List)jsonparser.readValueAs(new TypeReference() {

                    final LocationParser this$0;

            
            {
                this$0 = LocationParser.this;
                super();
            }
                }));
                locationresultsentity.setLocationSuggestions(inputstream);
                if (locationlistener != null)
                {
                    locationlistener.locationSuggestions(inputstream);
                }
            } else
            if (OBJECT_TYPE_LOCATION_CURRENT.equals(inputstream))
            {
                inputstream = new CurrentEntity();
                jsonparser.nextValue();
                inputstream.setLabels((List)jsonparser.readValueAs(new TypeReference() {

                    final LocationParser this$0;

            
            {
                this$0 = LocationParser.this;
                super();
            }
                }));
                if (locationlistener != null)
                {
                    locationlistener.currentAddress(inputstream);
                }
            }
            inputstream = jsonparser.nextToken();
        }
        if (locationlistener != null)
        {
            locationlistener.endParse(locationresultsentity);
        }
        return locationresultsentity;
    }

}
