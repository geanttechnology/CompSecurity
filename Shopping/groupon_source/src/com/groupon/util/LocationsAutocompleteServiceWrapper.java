// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.provider.SearchRecentSuggestions;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.Toast;
import com.groupon.activity.DealDetails;
import com.groupon.models.Place;
import com.groupon.models.PlacesContainer;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.service.GlobalSearchService;
import com.groupon.service.LocationService;
import com.groupon.service.PlacesService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            LocationSearchUtil, GeoPoint, LocationAutocompleteClient, Function1

public class LocationsAutocompleteServiceWrapper
{
    protected class LocationReady
        implements Function1
    {

        final LocationsAutocompleteServiceWrapper this$0;

        public void execute(Location location)
        {
            locationReady(location);
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((Location)obj);
        }

        protected LocationReady()
        {
            this$0 = LocationsAutocompleteServiceWrapper.this;
            super();
        }
    }

    public static final class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode GPS;
        public static final Mode Place;
        public static final Mode TypedEntry;
        public String searchOrigin;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/groupon/util/LocationsAutocompleteServiceWrapper$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            GPS = new Mode("GPS", 0, "gps-search");
            TypedEntry = new Mode("TypedEntry", 1, "location-query-search");
            Place = new Mode("Place", 2, "location-query-search");
            $VALUES = (new Mode[] {
                GPS, TypedEntry, Place
            });
        }

        private Mode(String s, int i, String s1)
        {
            super(s, i);
            searchOrigin = s1;
        }
    }


    public String CURRENT_LOCATION;
    public String CURRENT_LOCATION_BOLD;
    final int MAX_LOCATION_UPDATE_MS = 0x124f80;
    final int MAX_WAIT_MS = 5000;
    final int RECENT_LOCATION_NUM = 7;
    public String USER_LOCATION_VALUE;
    private Context context;
    private CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    private Place currentLocationOrDivisionPlace;
    private Place currentlySelectedPlace;
    private GlobalSearchService globalSearchService;
    private LocationAutocompleteClient locationAutocompleteClient;
    private LocationSearchUtil locationSearchUtil;
    private LocationService locationService;
    private PlacesService placesService;
    private List recentlyAddedLocations;
    private boolean recentlyPlacesEnabled;
    private List recentlySearchedLocations;
    private SearchRecentSuggestions searchRecentSuggestions;
    private List userPlaces;
    private boolean userPlacesEnabled;

    public LocationsAutocompleteServiceWrapper()
    {
        userPlacesEnabled = true;
        recentlyPlacesEnabled = true;
    }

    private void createLocationsWithGeocoder(final String locationKeyword)
    {
        locationSearchUtil.geocoderSearchForLocation(new Function1() {

            final LocationsAutocompleteServiceWrapper this$0;
            final String val$locationKeyword;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((List)obj);
            }

            public void execute(List list)
            {
                if (list == null)
                {
                    Toast.makeText(context.getApplicationContext(), context.getString(0x7f080155), 1).show();
                }
                populateLocationSuggestionsList(list, locationKeyword);
            }

            
            {
                this$0 = LocationsAutocompleteServiceWrapper.this;
                locationKeyword = s;
                super();
            }
        }, new Function1() {

            final LocationsAutocompleteServiceWrapper this$0;

            public void execute(Exception exception)
                throws RuntimeException
            {
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Exception)obj);
            }

            
            {
                this$0 = LocationsAutocompleteServiceWrapper.this;
                super();
            }
        }, locationKeyword, 5);
    }

    private void init()
    {
        Resources resources = context.getResources();
        USER_LOCATION_VALUE = resources.getString(0x7f0804e0);
        CURRENT_LOCATION = resources.getString(0x7f0801fa);
        CURRENT_LOCATION_BOLD = resources.getString(0x7f0804df);
        searchRecentSuggestions = new SearchRecentSuggestions(context, "com.groupon.recent.locations.authority", 3);
        getLocation(null);
        getUserPlaces();
        getRecentLocations();
    }

    private void updatePlaceToCurrentLocation(Place place, String s)
    {
        place.name = s;
        place.value = s;
        place.label = s;
    }

    protected List addCurrentLocationAndHomeToLocationsSuggestions(String s)
    {
        ArrayList arraylist = new ArrayList();
        if (currentLocationOrDivisionPlace != null && Strings.equals(currentLocationOrDivisionPlace.source, Mode.GPS.searchOrigin) && isMatchingPlace(currentLocationOrDivisionPlace, s))
        {
            arraylist.add(currentLocationOrDivisionPlace);
        }
        if (userPlacesEnabled && userPlaces != null)
        {
            Iterator iterator = userPlaces.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Place place = (Place)iterator.next();
                if (place != null && isMatchingPlace(place, s))
                {
                    arraylist.add(place);
                }
            } while (true);
        }
        return arraylist;
    }

    protected void createLocationsWithAutocomplete(final String keyword)
    {
        keyword = Strings.toString(keyword).toLowerCase();
        if (Strings.notEmpty(keyword) && currentCountryManager.getCurrentCountry().isLocationsAutocompleteEnabledCountry())
        {
            globalSearchService.getLocationSuggestions(new Function1() {

                final LocationsAutocompleteServiceWrapper this$0;
                final String val$keyword;

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((List)obj);
                }

                public void execute(List list)
                {
                    if (locationAutocompleteClient == null || locationAutocompleteClient.isTextEmpty())
                    {
                        return;
                    } else
                    {
                        populateLocationSuggestionsList(locationSearchUtil.getPlacesFromLocationSuggestions(list), keyword);
                        return;
                    }
                }

            
            {
                this$0 = LocationsAutocompleteServiceWrapper.this;
                keyword = s;
                super();
            }
            }, new Function1() {

                final LocationsAutocompleteServiceWrapper this$0;
                final String val$keyword;

                public void execute(Exception exception)
                    throws RuntimeException
                {
                    createLocationsWithGeocoder(keyword);
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((Exception)obj);
                }

            
            {
                this$0 = LocationsAutocompleteServiceWrapper.this;
                keyword = s;
                super();
            }
            }, getSuggestionsRequestParameters(keyword));
            return;
        } else
        {
            reloadAndShowDefaultList();
            return;
        }
    }

    protected void decodePlaceData(Place place, String s)
    {
        try
        {
            s = s.split(":");
            place.source = s[0];
            place.lng = Double.parseDouble(s[1]);
            place.lat = Double.parseDouble(s[2]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            place.source = "";
        }
        place.lng = 0.0D;
        place.lat = 0.0D;
    }

    protected String encodePlaceData(Place place)
    {
        return (new StringBuilder()).append(place.source).append(":").append(place.lng).append(":").append(place.lat).toString();
    }

    public GeoPoint getCurrentLocationOrDivisionGeoPoint()
    {
        return new GeoPoint((int)(currentLocationOrDivisionPlace.lat * 1000000D), (int)(currentLocationOrDivisionPlace.lng * 1000000D));
    }

    public Place getCurrentLocationOrDivisionPlace()
    {
        return currentLocationOrDivisionPlace;
    }

    public Place getCurrentlySelectedPlace()
    {
        return currentlySelectedPlace;
    }

    public Place getLastUsedLocation()
    {
        if (recentlyPlacesEnabled && recentlyAddedLocations.size() > 0)
        {
            return (Place)recentlyAddedLocations.get(recentlyAddedLocations.size() - 1);
        } else
        {
            return null;
        }
    }

    protected void getLocation(Location location)
    {
        double d;
        double d1;
        String s;
        String s1;
        Object obj;
        if (location == null)
        {
            if (locationService.isAGpsProviderEnabled())
            {
                location = locationService.getLocation();
            } else
            {
                location = null;
            }
        } else
        if (!locationService.isAGpsProviderEnabled())
        {
            location = null;
        }
        if (location != null)
        {
            obj = new GeoPoint(location);
        } else
        {
            obj = currentDivisionManager.getCurrentDivision().geoPoint;
        }
        s1 = currentDivisionManager.getCurrentDivision().name;
        if (location != null)
        {
            s = Mode.GPS.searchOrigin;
        } else
        {
            s = com.groupon.util.Mode.Place.searchOrigin;
        }
        d = ((GeoPoint) (obj)).getLatitudeDegrees();
        d1 = ((GeoPoint) (obj)).getLongitudeDegrees();
        if (location != null)
        {
            obj = CURRENT_LOCATION;
        } else
        {
            obj = s1;
        }
        if (location != null)
        {
            location = CURRENT_LOCATION_BOLD;
        } else
        {
            location = s1;
        }
        currentLocationOrDivisionPlace = new Place(s, d, d1, ((String) (obj)), location);
        if (context instanceof DealDetails)
        {
            return;
        } else
        {
            saveRecentLocation(currentLocationOrDivisionPlace);
            return;
        }
    }

    public SpannableString getLocationDisplayLabel(Place place)
    {
        if (isUserLocation(place))
        {
            String s = Strings.capitalize(place.value).trim();
            place = place.locationString.trim();
            SpannableString spannablestring = new SpannableString(Html.fromHtml(String.format(USER_LOCATION_VALUE, new Object[] {
                s, place
            })));
            String s1 = Strings.toString(spannablestring);
            int i = s1.indexOf(s);
            int j = i + s.length();
            spannablestring.setSpan(new StyleSpan(1), i, j, 0);
            spannablestring.setSpan(new ForegroundColorSpan(context.getResources().getColor(0x7f0e00ee)), i, j, 0);
            i = s1.indexOf(place);
            j = place.length();
            spannablestring.setSpan(new ForegroundColorSpan(context.getResources().getColor(0x7f0e00f4)), i, i + j, 0);
            return spannablestring;
        } else
        {
            return new SpannableString(Html.fromHtml(place.label));
        }
    }

    public Place getLocationForValue(CharSequence charsequence)
    {
label0:
        {
            if (!recentlyPlacesEnabled || recentlyAddedLocations == null || recentlyAddedLocations.size() <= 0)
            {
                break label0;
            }
            Iterator iterator = recentlyAddedLocations.iterator();
            Place place;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                place = (Place)iterator.next();
            } while (!Strings.equals(place.value, charsequence));
            return place;
        }
        return null;
    }

    public void getMostRecentCurrentLocationAndReload()
    {
        this;
        JVM INSTR monitorenter ;
        Location location = locationService.getLocation();
        if (location == null) goto _L2; else goto _L1
_L1:
        if (System.currentTimeMillis() - location.getTime() >= 0x124f80L) goto _L2; else goto _L3
_L3:
        (new LocationReady()).execute(location);
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        locationService.getLocationAsync(new LocationReady(), 5000);
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    protected void getRecentLocations()
    {
        Object obj;
        recentlyAddedLocations = new ArrayList();
        obj = Uri.parse("content://com.groupon.recent.locations.authority/suggestions");
        obj = context.getContentResolver().query(((Uri) (obj)), SearchRecentSuggestions.QUERIES_PROJECTION_2LINE, null, null, null);
        if (obj == null)
        {
            return;
        }
_L2:
        Object obj1;
        Place place;
        if (!((Cursor) (obj)).moveToNext())
        {
            break MISSING_BLOCK_LABEL_154;
        }
        obj1 = ((Cursor) (obj)).getString(2);
        String s = ((Cursor) (obj)).getString(4);
        place = new Place();
        decodePlaceData(place, s);
        if (!place.source.equals(Mode.GPS.searchOrigin) || CURRENT_LOCATION.equals(obj1))
        {
            break; /* Loop/switch isn't completed */
        }
        updatePlaceToCurrentLocation(place, CURRENT_LOCATION);
_L3:
        recentlyAddedLocations.add(place);
        if (true) goto _L2; else goto _L1
        obj1;
        ((Cursor) (obj)).close();
        throw obj1;
_L1:
        updatePlaceToCurrentLocation(place, ((String) (obj1)));
          goto _L3
        ((Cursor) (obj)).close();
        return;
    }

    protected List getRecentlySearchedLocations(boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        int i = recentlyAddedLocations.size();
        if (i > 0)
        {
            if (flag)
            {
                for (i--; i >= 0; i--)
                {
                    Place place = (Place)recentlyAddedLocations.get(i);
                    if (!isCurrentLocation(place) && !isUserLocation(place))
                    {
                        arraylist.add(place);
                    }
                }

            } else
            {
                Iterator iterator = recentlyAddedLocations.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Place place1 = (Place)iterator.next();
                    if (!isCurrentLocation(place1) && !isUserLocation(place1))
                    {
                        arraylist.add(place1);
                    }
                } while (true);
            }
        }
        return arraylist;
    }

    public GeoPoint getSelectedLocationOrDivisionGeoPoint()
    {
        double d;
        double d1;
        Location location;
        boolean flag;
        if (locationService.isAGpsProviderEnabled())
        {
            location = locationService.getLocation();
        } else
        {
            location = null;
        }
        if (location != null && isCurrentLocation(currentlySelectedPlace))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            d = location.getLatitude();
        } else
        {
            d = currentlySelectedPlace.lat;
        }
        if (flag)
        {
            d1 = location.getLongitude();
        } else
        {
            d1 = currentlySelectedPlace.lng;
        }
        return new GeoPoint((int)(d * 1000000D), (int)(d1 * 1000000D));
    }

    public ArrayList getSuggestionsRequestParameters(String s)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "query", s, "limit", Integer.valueOf(5), "lat", Double.valueOf(currentLocationOrDivisionPlace.lat), "lng", Double.valueOf(currentLocationOrDivisionPlace.lng)
        }));
        return arraylist;
    }

    public TextWatcher getTextWatcher()
    {
        return new TextWatcher() {

            final LocationsAutocompleteServiceWrapper this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                i = 1;
                if (!Strings.notEmpty(charsequence) || charsequence.length() < 1)
                {
                    i = 0;
                }
                if (i != 0)
                {
                    if (locationAutocompleteClient.isAutocomplete())
                    {
                        createLocationsWithAutocomplete(Strings.toString(charsequence));
                    }
                    return;
                } else
                {
                    reloadAndShowDefaultList();
                    return;
                }
            }

            
            {
                this$0 = LocationsAutocompleteServiceWrapper.this;
                super();
            }
        };
    }

    public Place getTopListSearchLocation()
    {
        if (recentlySearchedLocations != null && recentlySearchedLocations.size() > 0)
        {
            Place place = (Place)recentlySearchedLocations.get(0);
            setCurrentlySelectedPlace(place);
            saveRecentLocation(place);
            return place;
        } else
        {
            setCurrentlySelectedPlace(currentLocationOrDivisionPlace);
            return currentLocationOrDivisionPlace;
        }
    }

    protected void getUserPlaces()
    {
        if (placesService.isSupported())
        {
            placesService.getPlaces(new Function1() {

                final LocationsAutocompleteServiceWrapper this$0;

                public void execute(PlacesContainer placescontainer)
                {
                    placescontainer = placescontainer.places;
                    if (placescontainer != null)
                    {
                        userPlaces = new ArrayList();
                        Place place;
                        for (placescontainer = placescontainer.iterator(); placescontainer.hasNext(); userPlaces.add(place))
                        {
                            place = (Place)placescontainer.next();
                            place.source = com.groupon.util.Mode.Place.searchOrigin;
                            place.value = place.name;
                        }

                    }
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((PlacesContainer)obj);
                }

            
            {
                this$0 = LocationsAutocompleteServiceWrapper.this;
                super();
            }
            }, null, null);
        }
    }

    public boolean isCurrentLocation(Place place)
    {
        return Strings.equals(place.value, CURRENT_LOCATION) || Strings.equals(place.value, currentLocationOrDivisionPlace.value);
    }

    protected boolean isMatchingPlace(Place place, String s)
    {
        String s1 = place.locationString;
        return place.value.toLowerCase().contains(s) || Strings.notEmpty(s1) && s1.toLowerCase().contains(s);
    }

    public boolean isRecentlyPlacesEnabled()
    {
        return recentlyPlacesEnabled;
    }

    public boolean isUserLocation(Place place)
    {
        return userPlaces != null && userPlaces.contains(place);
    }

    public boolean isUserPlacesEnabled()
    {
        return userPlacesEnabled;
    }

    protected void locationReady(Location location)
    {
        getLocation(location);
        if (locationAutocompleteClient != null)
        {
            locationAutocompleteClient.locationReadyCallback(location);
        }
    }

    protected void populateLocationSuggestionsList(List list, String s)
    {
        recentlySearchedLocations = addCurrentLocationAndHomeToLocationsSuggestions(s);
        if (list.size() > 0)
        {
            recentlySearchedLocations.addAll(list);
        }
        locationAutocompleteClient.locationSearchReady(recentlySearchedLocations);
    }

    public void reinit()
    {
        getLocation(null);
    }

    protected void reloadAndShowDefaultList()
    {
        getRecentLocations();
        resetLocationSuggestionsList();
        if (locationAutocompleteClient != null)
        {
            locationAutocompleteClient.locationSearchReady(recentlySearchedLocations);
        }
    }

    protected void resetLocationSuggestionsList()
    {
        recentlySearchedLocations = new ArrayList();
        if (currentLocationOrDivisionPlace != null)
        {
            recentlySearchedLocations.add(currentLocationOrDivisionPlace);
        }
        if (userPlacesEnabled && userPlaces != null)
        {
            recentlySearchedLocations.addAll(userPlaces);
        }
        if (recentlyPlacesEnabled && recentlyAddedLocations != null)
        {
            recentlySearchedLocations.addAll(getRecentlySearchedLocations(true));
        }
    }

    public void saveRecentLocation(Place place)
    {
        this;
        JVM INSTR monitorenter ;
        setCurrentlySelectedPlace(place);
        place.label = place.value;
        if (!recentlyPlacesEnabled || recentlyAddedLocations == null || recentlyAddedLocations.size() < 7) goto _L2; else goto _L1
_L1:
        searchRecentSuggestions.clearHistory();
        int i = 1;
_L3:
        if (i >= recentlyAddedLocations.size())
        {
            break; /* Loop/switch isn't completed */
        }
        searchRecentSuggestions.saveRecentQuery(((Place)recentlyAddedLocations.get(i)).value, encodePlaceData((Place)recentlyAddedLocations.get(i)));
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        searchRecentSuggestions.saveRecentQuery(place.value, encodePlaceData(place));
        this;
        JVM INSTR monitorexit ;
        return;
        place;
        throw place;
    }

    public void searchLocation(String s)
    {
        createLocationsWithAutocomplete(s);
    }

    public void setCurrentlySelectedPlace(Place place)
    {
        currentlySelectedPlace = place;
    }

    public void setLocationAutocompleteClient(LocationAutocompleteClient locationautocompleteclient)
    {
        locationAutocompleteClient = locationautocompleteclient;
    }

    public void setRecentlyPlacesEnabled(boolean flag)
    {
        recentlyPlacesEnabled = flag;
    }

    public void setUserPlacesEnabled(boolean flag)
    {
        userPlacesEnabled = flag;
    }



/*
    static List access$002(LocationsAutocompleteServiceWrapper locationsautocompleteservicewrapper, List list)
    {
        locationsautocompleteservicewrapper.userPlaces = list;
        return list;
    }

*/




}
