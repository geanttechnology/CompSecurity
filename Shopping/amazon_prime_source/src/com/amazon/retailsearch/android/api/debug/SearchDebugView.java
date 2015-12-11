// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import com.amazon.retailsearch.adaptive.latency.ImageQualityTreatment;
import com.amazon.retailsearch.adaptive.latency.LatencyAdaptiveManager;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.retailsearch.client.AndroidRetailSearchClient;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchConfigurationManager;
import com.amazon.searchapp.retailsearch.client.SearchConfigurationSet;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import com.amazon.searchapp.retailsearch.client.ServiceCallDebugOptions;
import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.api.debug:
//            SearchDebugDataStore, ServiceUrlType

public class SearchDebugView extends LinearLayout
{
    public static interface DebugCallback
    {

        public abstract void envSelected();
    }


    private static final String FORCE_FRESH_CLIENT_PARAMS = "rh=null&i=amazonfresh";
    private static final String FORCE_PRIMENOW_PARAMS = "debug=primeNowPostalCode:10001&adpDebug=usePrimeNowWhitelist:false";
    private final TextView addedCookies;
    private final Spinner configSpinner;
    private final SearchConfigurationSet configs;
    SearchDebugDataStore dataStore;
    private final Spinner latencySpinner;
    private final Spinner realmSpinner;
    private final EditText searchCookies;
    private final EditText searchDebugOptions;
    private final EditText searchServiceUrl;
    private final RadioGroup serviceUrlRadioGroup;

    public SearchDebugView(Context context)
    {
        this(context, (DebugCallback)null);
    }

    public SearchDebugView(final Context context, final DebugCallback callback)
    {
        super(context);
        configs = SearchConfigurationManager.getInstance().getConfigurationSet();
        RetailSearchDaggerGraphController.inject(this);
        setOrientation(1);
        setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        setPadding(5, 5, 5, 5);
        inflate(context, com.amazon.retailsearch.R.layout.rs_debug_settings, this);
        ((Button)findViewById(com.amazon.retailsearch.R.id.rs_debug_go_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final SearchDebugView this$0;
            final DebugCallback val$callback;

            public void onClick(View view)
            {
                commitChanges();
                commitSearchDebugOptions();
                commitSearchCookies();
                if (callback != null)
                {
                    callback.envSelected();
                }
            }

            
            {
                this$0 = SearchDebugView.this;
                callback = debugcallback;
                super();
            }
        });
        serviceUrlRadioGroup = (RadioGroup)findViewById(com.amazon.retailsearch.R.id.rs_debug_radio_group);
        callback = dataStore.getServiceUrlType();
        if (callback != null)
        {
            serviceUrlRadioGroup.check(callback.getRadioButtonViewId());
        }
        serviceUrlRadioGroup.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            final SearchDebugView this$0;

            public void onCheckedChanged(RadioGroup radiogroup, int j)
            {
                if (j == com.amazon.retailsearch.R.id.rs_debug_radio_secure || j == com.amazon.retailsearch.R.id.rs_debug_radio_insecure)
                {
                    commitChanges();
                    return;
                } else
                {
                    searchServiceUrl.setText("");
                    return;
                }
            }

            
            {
                this$0 = SearchDebugView.this;
                super();
            }
        });
        realmSpinner = (Spinner)findViewById(com.amazon.retailsearch.R.id.rs_debug_select_realm);
        realmSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            final SearchDebugView this$0;

            public void onItemSelected(AdapterView adapterview, View view, int j, long l)
            {
                commitChanges();
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$0 = SearchDebugView.this;
                super();
            }
        });
        configSpinner = (Spinner)findViewById(com.amazon.retailsearch.R.id.rs_debug_config_set);
        callback = new ArrayAdapter(context, com.amazon.retailsearch.R.layout.rs_debug_spinner_item, configs.getConfigurations().keySet().toArray(new String[0]));
        configSpinner.setAdapter(callback);
        int i = callback.getPosition(dataStore.getSearchConfigId());
        if (i != -1)
        {
            configSpinner.setSelection(i);
        }
        configSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            final SearchDebugView this$0;
            final Context val$context;

            public void onItemSelected(AdapterView adapterview, View view, int j, long l)
            {
                view = new ArrayAdapter(context, com.amazon.retailsearch.R.layout.rs_debug_spinner_item, ((SearchConfiguration)configs.getConfigurations().get((String)configSpinner.getSelectedItem())).getRealms().keySet().toArray(new String[0]));
                realmSpinner.setAdapter(view);
                if (dataStore.getSearchRealm() != null)
                {
                    adapterview = dataStore.getSearchRealm().getId();
                } else
                {
                    adapterview = null;
                }
                j = view.getPosition(adapterview);
                if (j != -1)
                {
                    realmSpinner.setSelection(j);
                }
                commitChanges();
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$0 = SearchDebugView.this;
                context = context1;
                super();
            }
        });
        callback = ImageQualityTreatment.getClickToATFArray();
        latencySpinner = (Spinner)findViewById(com.amazon.retailsearch.R.id.rs_debug_select_latency);
        latencySpinner.setAdapter(new ArrayAdapter(context, com.amazon.retailsearch.R.layout.rs_debug_spinner_item, callback));
        latencySpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            final SearchDebugView this$0;
            final String val$latencies[];

            public void onItemSelected(AdapterView adapterview, View view, int j, long l)
            {
                LatencyAdaptiveManager.setEmulationLevel(latencies[j]);
                commitChanges();
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$0 = SearchDebugView.this;
                latencies = as;
                super();
            }
        });
        searchServiceUrl = (EditText)findViewById(com.amazon.retailsearch.R.id.rs_debug_search_service_url);
        searchServiceUrl.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final SearchDebugView this$0;

            public boolean onEditorAction(TextView textview, int j, KeyEvent keyevent)
            {
                if (j == 6)
                {
                    commitChanges();
                    UIUtils.closeSoftKeyboard(searchServiceUrl);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = SearchDebugView.this;
                super();
            }
        });
        if (dataStore.getCustomServiceUrl() != null)
        {
            searchServiceUrl.setText(dataStore.getCustomServiceUrl());
        }
        searchDebugOptions = (EditText)findViewById(com.amazon.retailsearch.R.id.rs_debug_search_debug_options);
        searchDebugOptions.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final SearchDebugView this$0;

            public boolean onEditorAction(TextView textview, int j, KeyEvent keyevent)
            {
                if (j == 6)
                {
                    commitSearchDebugOptions();
                    UIUtils.closeSoftKeyboard(searchDebugOptions);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = SearchDebugView.this;
                super();
            }
        });
        searchDebugOptions.setText(ServiceCallDebugOptions.getInstance().getSearchDebugOptions());
        ((Button)findViewById(com.amazon.retailsearch.R.id.rs_debug_force_fresh)).setOnClickListener(new android.view.View.OnClickListener() {

            final SearchDebugView this$0;

            public void onClick(View view)
            {
                searchDebugOptions.setText("rh=null&i=amazonfresh");
            }

            
            {
                this$0 = SearchDebugView.this;
                super();
            }
        });
        ((Button)findViewById(com.amazon.retailsearch.R.id.rs_debug_force_primenow)).setOnClickListener(new android.view.View.OnClickListener() {

            final SearchDebugView this$0;

            public void onClick(View view)
            {
                searchDebugOptions.setText("debug=primeNowPostalCode:10001&adpDebug=usePrimeNowWhitelist:false");
            }

            
            {
                this$0 = SearchDebugView.this;
                super();
            }
        });
        searchCookies = (EditText)findViewById(com.amazon.retailsearch.R.id.rs_debug_search_cookies);
        addedCookies = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_debug_added_cookie_view);
        ((Button)findViewById(com.amazon.retailsearch.R.id.rs_debug_add_cookies_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final SearchDebugView this$0;

            public void onClick(View view)
            {
                commitSearchCookies();
                UIUtils.closeSoftKeyboard(searchDebugOptions);
            }

            
            {
                this$0 = SearchDebugView.this;
                super();
            }
        });
        showAddedCookies();
        ((Button)findViewById(com.amazon.retailsearch.R.id.rs_debug_clear_cookies_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final SearchDebugView this$0;

            public void onClick(View view)
            {
                searchCookies.setText("");
            }

            
            {
                this$0 = SearchDebugView.this;
                super();
            }
        });
        ((Button)findViewById(com.amazon.retailsearch.R.id.rs_debug_add_marketplace_override)).setOnClickListener(new android.view.View.OnClickListener() {

            final SearchDebugView this$0;

            public void onClick(View view)
            {
                searchCookies.setText(com.amazon.retailsearch.R.string.debug_marketplace_override_text);
            }

            
            {
                this$0 = SearchDebugView.this;
                super();
            }
        });
    }

    private void commitChanges()
    {
        String s2;
        ServiceUrlType serviceurltype;
        s2 = (String)configSpinner.getSelectedItem();
        String s = (String)realmSpinner.getSelectedItem();
        SearchConfigurationManager.getInstance().setConfigurationId(s2);
        SearchConfiguration.getConfiguration().setRealmId(s);
        serviceurltype = ServiceUrlType.getServiceUrlType(serviceUrlRadioGroup);
        static class _cls13
        {

            static final int $SwitchMap$com$amazon$retailsearch$android$api$debug$ServiceUrlType[];

            static 
            {
                $SwitchMap$com$amazon$retailsearch$android$api$debug$ServiceUrlType = new int[ServiceUrlType.values().length];
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$api$debug$ServiceUrlType[ServiceUrlType.SECURE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$api$debug$ServiceUrlType[ServiceUrlType.INSECURE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls13..SwitchMap.com.amazon.retailsearch.android.api.debug.ServiceUrlType[serviceurltype.ordinal()];
        JVM INSTR tableswitch 1 2: default 76
    //                   1 155
    //                   2 184;
           goto _L1 _L2 _L3
_L1:
        String s1;
        s1 = searchServiceUrl.getText().toString();
        dataStore.setCustomServiceUrl(s1);
_L5:
        SearchConfiguration.getConfiguration().setRealm(createCustomizedRealm(s1));
        AndroidRetailSearchClient.resetClient();
        searchServiceUrl.setText(SearchConfiguration.getConfiguration().getRealm().getSecureSearchServiceUrl());
        dataStore.setSearchConfigId(s2);
        dataStore.setSearchRealm(SearchConfiguration.getConfiguration().getRealm());
        dataStore.setServiceUrlType(serviceurltype);
        return;
_L2:
        s1 = SearchConfiguration.getConfiguration().getRealm().getSecureSearchServiceUrl();
        dataStore.setCustomServiceUrl(null);
        searchServiceUrl.setText(s1);
        continue; /* Loop/switch isn't completed */
_L3:
        s1 = SearchConfiguration.getConfiguration().getRealm().getSearchServiceUrl();
        dataStore.setCustomServiceUrl(null);
        searchServiceUrl.setText(s1);
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void commitSearchCookies()
    {
        dataStore.getCookies().clear();
        if (searchCookies.getText() != null)
        {
            String as[] = searchCookies.getText().toString().split(";");
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                String as1[] = as[i].split("=");
                if (as1 != null && as1.length == 2)
                {
                    dataStore.addCookies(as1[0], as1[1]);
                }
                i++;
            }
        }
        showAddedCookies();
    }

    private void commitSearchDebugOptions()
    {
        ServiceCallDebugOptions.getInstance().setSearchDebugOptions(searchDebugOptions.getText().toString());
        dataStore.setServiceCallDebugOptions(searchDebugOptions.getText().toString());
    }

    private SearchRealm createCustomizedRealm(String s)
    {
        SearchRealm searchrealm = SearchConfiguration.getConfiguration().getRealm();
        return (new com.amazon.searchapp.retailsearch.client.SearchRealm.Builder()).setSearchServiceUrl(s).setSecureSearchServiceUrl(s).setId(searchrealm.getId()).setLocale(searchrealm.getLocale()).setCompletionServiceUrl(searchrealm.getCompletionServiceUrl()).setSecureCompletionServiceUrl(searchrealm.getSecureCompletionServiceUrl()).setMarketplaceId(searchrealm.getMarketplaceId()).setEncodingParam(searchrealm.getEncodingParam()).setEncodingValue(searchrealm.getEncodingValue()).build();
    }

    private void showAddedCookies()
    {
        addedCookies.setText("Added Cookies:");
        String s;
        for (Iterator iterator = dataStore.getCookies().getMap().keySet().iterator(); iterator.hasNext(); addedCookies.append((CharSequence)dataStore.getCookies().get(s)))
        {
            s = (String)iterator.next();
            addedCookies.append("\n");
            addedCookies.append(s);
            addedCookies.append("=");
        }

    }









}
