// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.groupon.adapter.BaseGlobalSearchLocationIndexerAdapter;
import com.groupon.models.Place;
import com.groupon.models.country.Country;
import com.groupon.models.division.City;
import com.groupon.models.division.Division;
import com.groupon.service.core.AbTestService;
import com.groupon.service.core.CurrentDivisionUpdaterService;
import com.groupon.service.core.StaticSupportInfoService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.service.countryanddivision.DivisionsService;
import com.groupon.service.countryanddivision.RecentDivisionsDao;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.AbstractRetryAsyncTask;
import com.groupon.util.ActionBarUtil;
import com.groupon.util.CountryUtil;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DivisionUtil;
import com.groupon.util.GeoPoint;
import com.groupon.util.GrouponSafeAsyncTask;
import com.groupon.util.LocationAutocompleteClient;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import com.groupon.view.ActionBarClearableEditText;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import roboguice.util.Ln;
import roboguice.util.Strings;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory

public class Cities extends GrouponActivity
{
    private class CitiesAutoCompleteIndexerAdapter extends BaseGlobalSearchLocationIndexerAdapter
    {

        final Cities this$0;

        public void onLocationClick(Place place)
        {
            locationAutocompleteServiceWrapper.saveRecentLocation(place);
            setSelectedLocation(place);
        }

        public CitiesAutoCompleteIndexerAdapter(List list)
        {
            this$0 = Cities.this;
            super(Cities.this, locationAutocompleteServiceWrapper, CURRENT_LOCATION, list);
        }
    }

    private class CitiesLocationAutocompleteClient
        implements LocationAutocompleteClient
    {

        final Cities this$0;

        public boolean isAutocomplete()
        {
            return search.hasFocus();
        }

        public boolean isTextEmpty()
        {
            return search.getText().length() == 0;
        }

        public void locationReadyCallback(Location location)
        {
        }

        public void locationSearchReady(List list)
        {
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
            }
            autocompleteListView.setAdapter(new CitiesAutoCompleteIndexerAdapter(((List) (obj))));
        }

        private CitiesLocationAutocompleteClient()
        {
            this$0 = Cities.this;
            super();
        }

    }

    public class FetchDivisions extends AbstractRetryAsyncTask
    {

        final Cities this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public Void call()
            throws Exception
        {
            divisionService.refresh();
            return null;
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((Void)obj);
        }

        protected void onSuccess(Void void1)
            throws Exception
        {
            refresh();
        }

        public void onUserCancelRetry()
        {
            finish();
        }

        public FetchDivisions(Context context)
        {
            this$0 = Cities.this;
            super(context);
        }
    }

    private class FilterTextWatcher
        implements TextWatcher
    {

        final Cities this$0;

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            filter(charsequence);
        }

        private FilterTextWatcher()
        {
            this$0 = Cities.this;
            super();
        }

    }

    private class GetCityNameFromGeoPointAsyncTask extends GrouponSafeAsyncTask
    {

        private final Division division;
        private final Place suggestion;
        final Cities this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public String call()
            throws Exception
        {
            return divisionUtil.getCityNameFromGeoPoint(new GeoPoint((int)(suggestion.lat * 1000000D), (int)(suggestion.lng * 1000000D)));
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((String)obj);
        }

        protected void onSuccess(String s)
            throws Exception
        {
            Object obj = division;
            if (s != null)
            {
                if (!suggestion.value.equals(CURRENT_LOCATION) && !locationAutocompleteServiceWrapper.isUserLocation(suggestion))
                {
                    s = suggestion.value.split(",")[0];
                }
                obj = new City(division, s);
            }
            setDivisionAndLaunchSplash(((Division) (obj)));
        }

        public GetCityNameFromGeoPointAsyncTask(Place place, Division division1)
        {
            this$0 = Cities.this;
            super();
            suggestion = place;
            division = division1;
        }
    }

    class IndexerAdapter extends ArrayAdapter
        implements SectionIndexer, StickyListHeadersAdapter
    {

        private HashMap alphaIndexer;
        private List originalObjects;
        private int sectioner[];
        private String sections[];
        final Cities this$0;

        public Filter getFilter()
        {
            return new DivisionFilter(originalObjects);
        }

        public long getHeaderId(int i)
        {
            Object obj = (Division)getItem(i);
            if (currentCountryManager.getCurrentCountry().shouldUseDivisionAsHeader())
            {
                return (long)((Division) (obj)).parent.id.hashCode();
            }
            obj = ((Division) (obj)).name;
            if (((String) (obj)).length() > 0)
            {
                obj = ((String) (obj)).substring(0, 1);
            } else
            {
                obj = "";
            }
            return (long)((String) (obj)).hashCode();
        }

        public View getHeaderView(int i, View view, ViewGroup viewgroup)
        {
            View view1 = view;
            if (view == null)
            {
                TextView textview;
                int j;
                if (currentCountryManager.getCurrentCountry().isJapan())
                {
                    j = 0x7f03014b;
                } else
                {
                    j = 0x7f030064;
                }
                view1 = inflater.inflate(j, viewgroup, false);
            }
            viewgroup = (Division)getItem(i);
            view = ((Division) (viewgroup)).name;
            if (view.length() > 0)
            {
                view = view.substring(0, 1);
            } else
            {
                view = "";
            }
            textview = (TextView)view1.findViewById(0x7f1001a1);
            if (((Division) (viewgroup)).parent == null)
            {
                viewgroup = "";
            } else
            {
                viewgroup = ((Division) (viewgroup)).parent.name;
            }
            if (!currentCountryManager.getCurrentCountry().shouldUseDivisionAsHeader())
            {
                viewgroup = view;
            }
            textview.setText(viewgroup);
            return view1;
        }

        public int getPositionForSection(int i)
        {
            String s = sections[i];
            return ((Integer)alphaIndexer.get(s)).intValue();
        }

        public int getSectionForPosition(int i)
        {
            i = sectioner[i];
            if (i > -1)
            {
                return i;
            } else
            {
                return 0;
            }
        }

        public Object[] getSections()
        {
            return sections;
        }

        public IndexerAdapter(Context context, int i, List list)
        {
            this$0 = Cities.this;
            super(context, i, list);
            originalObjects = new ArrayList(list);
            alphaIndexer = new HashMap();
            sectioner = new int[list.size()];
            i = -1;
            int k = 0;
            while (k < list.size()) 
            {
                cities = (Division)list.get(k);
                if (hasParent())
                {
                    sectioner[k] = i;
                } else
                {
                    cities = name.substring(0, 1);
                    int j = i;
                    if (!alphaIndexer.containsKey(Cities.this))
                    {
                        j = i + 1;
                        alphaIndexer.put(Cities.this, Integer.valueOf(k));
                    }
                    sectioner[k] = j;
                    i = j;
                }
                k++;
            }
            cities = new ArrayList(alphaIndexer.keySet());
            Collections.sort(Cities.this);
            sections = new String[size()];
            toArray(sections);
        }
    }

    private class IndexerAdapter.DivisionFilter extends Filter
    {

        private List items;
        final IndexerAdapter this$1;

        protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
        {
            charsequence = charsequence.toString().toLowerCase();
            android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
            ArrayList arraylist = new ArrayList(items);
            if (Strings.notEmpty(charsequence))
            {
                ListIterator listiterator = arraylist.listIterator();
                do
                {
                    if (!listiterator.hasNext())
                    {
                        break;
                    }
                    String s = ((Division)listiterator.next()).name;
                    if (!countryUtil.getDisplayName(s).toLowerCase().contains(charsequence))
                    {
                        listiterator.remove();
                    }
                } while (true);
            }
            filterresults.count = arraylist.size();
            filterresults.values = arraylist;
            return filterresults;
        }

        protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
        {
            clear();
            for (charsequence = ((List)filterresults.values).iterator(); charsequence.hasNext(); add(filterresults))
            {
                filterresults = (Division)charsequence.next();
            }

            notifyDataSetChanged();
        }

        public IndexerAdapter.DivisionFilter(List list)
        {
            this$1 = IndexerAdapter.this;
            super();
            items = list;
        }
    }

    private class SearchEditTextOnFocusChangeListener
        implements android.view.View.OnFocusChangeListener
    {

        final Cities this$0;

        public void onFocusChange(View view, boolean flag)
        {
            int i = 0;
            byte byte0;
            if (flag)
            {
                byte0 = 8;
            } else
            {
                byte0 = 0;
            }
            if (!flag)
            {
                i = 8;
            }
            listView.setVisibility(byte0);
            autocompleteContainer.setVisibility(i);
            if (flag)
            {
                locationAutocompleteServiceWrapper.searchLocation(Strings.toString(search.getText()));
            }
        }

        private SearchEditTextOnFocusChangeListener()
        {
            this$0 = Cities.this;
            super();
        }

    }

    private class SearchEditTextOnKeyListener
        implements android.view.View.OnKeyListener
    {

        final Cities this$0;

        public boolean onKey(View view, int i, KeyEvent keyevent)
        {
            if (i == 4)
            {
                search.clearFocus();
            }
            return false;
        }

        private SearchEditTextOnKeyListener()
        {
            this$0 = Cities.this;
            super();
        }

    }


    public static final String NST_CLICK_DIVISION_TYPE = "select_city";
    public static final int REQUEST_CODE = 10125;
    String CURRENT_LOCATION;
    private AbTestService abTestService;
    protected View autocompleteContainer;
    protected ListView autocompleteListView;
    private List citiesList;
    private CitiesLocationAutocompleteClient citiesLocationAutocompleteClient;
    LinearLayout content;
    TextView countryButton;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    private DeviceInfoUtil deviceInfoUtil;
    private DivisionsService divisionService;
    DivisionUtil divisionUtil;
    TextView emptyView;
    private List headerViews;
    private LayoutInflater inflater;
    private IntentFactory intentFactory;
    private boolean isMaskDivisions1508Enabled;
    StickyListHeadersListView listView;
    private LocationsAutocompleteServiceWrapper locationAutocompleteServiceWrapper;
    private Logger logger;
    ProgressBar progress;
    private TextView recentCityView;
    private RecentDivisionsDao recentDivisionsDao;
    private ActionBarClearableEditText search;
    protected TextWatcher searchListener;
    private TextView selectCityView;
    boolean shouldReturnDivision;
    private StaticSupportInfoService staticSupportInfoService;

    public Cities()
    {
        searchListener = new FilterTextWatcher();
        citiesLocationAutocompleteClient = new CitiesLocationAutocompleteClient();
    }

    private void clearRecentItems()
    {
        if (headerViews != null)
        {
            View view;
            for (Iterator iterator = headerViews.iterator(); iterator.hasNext(); listView.removeHeaderView(view))
            {
                view = (View)iterator.next();
            }

            headerViews.clear();
        }
    }

    private void filter(CharSequence charsequence)
    {
        boolean flag1 = true;
        final boolean isFiltering = Strings.notEmpty(charsequence);
        int i = listView.getHeaderViewsCount();
        Object obj;
        StickyListHeadersAdapter stickylistheadersadapter;
        boolean flag;
        if (!isFiltering)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (i > 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i ^ flag)
        {
            clearRecentItems();
            if (recentCityView != null)
            {
                recentCityView.setVisibility(8);
            }
            if (selectCityView != null)
            {
                selectCityView.setVisibility(8);
            }
        }
        if (!currentCountryManager.getCurrentCountry().shouldDisplayFastScrollBar() || isFiltering)
        {
            flag1 = false;
        }
        setFastScroll(flag1);
        stickylistheadersadapter = listView.getAdapter();
        obj = stickylistheadersadapter;
        if (stickylistheadersadapter instanceof HeaderViewListAdapter)
        {
            obj = ((HeaderViewListAdapter)stickylistheadersadapter).getWrappedAdapter();
        }
        if (obj instanceof IndexerAdapter)
        {
            ((IndexerAdapter)obj).getFilter().filter(charsequence, new android.widget.Filter.FilterListener() {

                final Cities this$0;
                final boolean val$isFiltering;

                public void onFilterComplete(int j)
                {
                    TextView textview = emptyView;
                    if (j == 0 && isFiltering)
                    {
                        j = 0;
                    } else
                    {
                        j = 8;
                    }
                    textview.setVisibility(j);
                }

            
            {
                this$0 = Cities.this;
                isFiltering = flag;
                super();
            }
            });
        }
    }

    private void processDivisionList()
    {
        content.setVisibility(8);
        emptyView.setVisibility(8);
        if (!currentCountryManager.getCurrentCountry().isJapan())
        {
            Collections.sort(citiesList, new Comparator() {

                final Cities this$0;

                public int compare(Division division, Division division1)
                {
                    if (currentCountryManager.getCurrentCountry().shouldSortCitiesByDivisionId())
                    {
                        division = division.id;
                    } else
                    {
                        division = division.name;
                    }
                    if (currentCountryManager.getCurrentCountry().shouldSortCitiesByDivisionId())
                    {
                        division1 = division1.id;
                    } else
                    {
                        division1 = division1.name;
                    }
                    return Collator.getInstance(deviceInfoUtil.getDeviceLocale()).compare(division, division1);
                }

                public volatile int compare(Object obj, Object obj1)
                {
                    return compare((Division)obj, (Division)obj1);
                }

            
            {
                this$0 = Cities.this;
                super();
            }
            });
        }
        logger.logGeneralEvent("cities", "", "cities_number", citiesList.size(), Logger.NULL_NST_FIELD);
        content.setVisibility(0);
        resetList();
        setFastScroll(currentCountryManager.getCurrentCountry().shouldDisplayFastScrollBar());
    }

    private void refresh()
    {
        updateDivisions();
        processDivisionList();
    }

    private void resetList()
    {
        clearRecentItems();
        listView.setAdapter(null);
        Object obj = new ArrayList(citiesList);
        setupRecentItems(((List) (obj)));
        obj = new IndexerAdapter(this, 0x7f030063, ((List) (obj))) {

            final Cities this$0;

            public View getView(int i, View view, ViewGroup viewgroup)
            {
                String s = ((Division)getItem(i)).name;
                if (view == null)
                {
                    view = inflater.inflate(0x7f030063, viewgroup, false);
                }
                ((TextView)view.findViewById(0x7f100078)).setText(s);
                return view;
            }

            
            {
                this$0 = Cities.this;
                super(context, i, list);
            }
        };
        listView.setAdapter(((StickyListHeadersAdapter) (obj)));
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Cities this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = ((AdapterView) (listView.getItemAtPosition(i)));
                selectNewDivision((Division)adapterview);
            }

            
            {
                this$0 = Cities.this;
                super();
            }
        });
    }

    private void selectNewDivision(Division division)
    {
        if (shouldReturnDivision)
        {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putParcelable("division_object", division);
            intent.putExtras(bundle);
            setResult(-1, intent);
            finish();
            return;
        } else
        {
            setDivisionAndLaunchSplash(division);
            return;
        }
    }

    private void setDivisionAndLaunchSplash(Division division)
    {
        String s = division.name;
        logger.logClick("", "select_city", getPageViewId(), s);
        currentDivisionManager.setCurrentDivisionAndClearCaches(division, new Class[] {
            com/groupon/service/core/CurrentDivisionUpdaterService
        });
        startActivity(intentFactory.newSplashIntent());
    }

    private void setFastScroll(boolean flag)
    {
        listView.setFastScrollEnabled(flag);
        listView.setFastScrollAlwaysVisible(flag);
    }

    private void setSelectedLocation(Place place)
    {
        Object obj = new GeoPoint((int)(place.lat * 1000000D), (int)(place.lng * 1000000D));
        obj = divisionUtil.getDivisionFrom(((GeoPoint) (obj)));
        if (obj != null)
        {
            Ln.d("mask division: setting division to %s with lnt/lng (%f,%f)", new Object[] {
                place.value, Double.valueOf(place.lat), Double.valueOf(place.lng)
            });
            (new GetCityNameFromGeoPointAsyncTask(place, ((Division) (obj)))).execute();
        }
    }

    private void setupRecentItem(List list, List list1, Division division)
    {
        if (!list1.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = null;
        Iterator iterator = list1.iterator();
        do
        {
            list1 = obj;
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            list1 = (Division)iterator.next();
        } while (!((Division) (list1)).id.equals(division.id));
        if (division instanceof City)
        {
            list1 = new City(list1, division.name);
        }
        if (list1 == null) goto _L1; else goto _L3
_L3:
        division = inflater.inflate(0x7f030063, null);
        division.setTag(list1);
        division.setBackgroundResource(0x1080062);
        ((TextView)division.findViewById(0x7f100078)).setText(((Division) (list1)).name);
        division.setOnClickListener(new android.view.View.OnClickListener() {

            final Cities this$0;

            public void onClick(View view)
            {
                view = ((View) (view.getTag()));
                selectNewDivision((Division)view);
            }

            
            {
                this$0 = Cities.this;
                super();
            }
        });
        list.add(division);
        return;
    }

    private void setupRecentItems(List list)
    {
        if (search == null || !Strings.notEmpty(search.getText()))
        {
            Object obj = recentDivisionsDao.getRecentDivisions();
            if (!((List) (obj)).isEmpty())
            {
                if (headerViews == null)
                {
                    headerViews = new ArrayList();
                }
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    Division division = (Division)((Iterator) (obj)).next();
                    if (isMaskDivisions1508Enabled || !(division instanceof City))
                    {
                        setupRecentItem(headerViews, list, division);
                    }
                } while (true);
                if (!headerViews.isEmpty() && !shouldRemoveHeaders())
                {
                    if (recentCityView == null)
                    {
                        list = inflater.inflate(0x7f0301e9, null);
                        recentCityView = (TextView)list.findViewById(0x7f1001a1);
                        recentCityView.setText(0x7f08035e);
                        listView.addHeaderView(list, null, false);
                    }
                    View view;
                    for (list = headerViews.iterator(); list.hasNext(); listView.addHeaderView(view))
                    {
                        view = (View)list.next();
                    }

                }
            }
            if (selectCityView == null)
            {
                list = inflater.inflate(0x7f0301e5, null);
                selectCityView = (TextView)list.findViewById(0x7f1001a1);
                selectCityView.setText(0x7f0803ef);
                listView.addHeaderView(list, null, false);
                return;
            }
        }
    }

    private boolean shouldRemoveHeaders()
    {
        return false;
    }

    private void updateDivisions()
    {
        citiesList = new ArrayList(divisionService.getDivisions());
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag1 = false;
        super.onCreate(bundle);
        setContentView(0x7f030062);
        locationAutocompleteServiceWrapper.setUserPlacesEnabled(false);
        locationAutocompleteServiceWrapper.setRecentlyPlacesEnabled(false);
        boolean flag = flag1;
        if (abTestService.isVariantEnabled("maskDivisions1508", "on"))
        {
            flag = flag1;
            if (currentCountryManager.getCurrentCountry().isLocationsAutocompleteEnabledCountry())
            {
                flag = true;
            }
        }
        isMaskDivisions1508Enabled = flag;
        if (!staticSupportInfoService.isCountrySupported(currentCountryManager.getCurrentCountry()))
        {
            startActivity(intentFactory.newCountrySelector());
            return;
        }
        countryButton.setOnClickListener(new android.view.View.OnClickListener() {

            final Cities this$0;

            public void onClick(View view)
            {
                startActivity(intentFactory.newCountrySelector());
            }

            
            {
                this$0 = Cities.this;
                super();
            }
        });
        countryButton.setText(countryUtil.getDisplayNameByShortName(currentCountryManager.getCurrentCountry()));
        updateDivisions();
        if (citiesList.isEmpty())
        {
            (new FetchDivisions(this)).execute();
            return;
        } else
        {
            refresh();
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        search = ActionBarUtil.addSearchMenu(getSupportActionBar(), 0x7f080345);
        search.setImeOptions(6);
        if (isMaskDivisions1508Enabled)
        {
            search.setOnKeyListener(new SearchEditTextOnKeyListener());
            locationAutocompleteServiceWrapper.setLocationAutocompleteClient(citiesLocationAutocompleteClient);
            search.setOnFocusChangeListener(new SearchEditTextOnFocusChangeListener());
            search.addTextChangedListener(locationAutocompleteServiceWrapper.getTextWatcher());
        } else
        {
            search.addTextChangedListener(searchListener);
        }
        return true;
    }













}
