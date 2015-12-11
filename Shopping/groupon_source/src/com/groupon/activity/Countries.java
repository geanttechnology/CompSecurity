// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.TextView;
import com.groupon.models.country.Country;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CountriesService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.AbstractRetryAsyncTask;
import com.groupon.util.ActionBarUtil;
import com.groupon.util.CountryUtil;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.UserMigrationManager;
import com.groupon.view.ActionBarClearableEditText;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponListActivity, IntentFactory

public class Countries extends GrouponListActivity
    implements GrouponDialogListener
{
    private class GetCountriesRetryAsyncTask extends AbstractRetryAsyncTask
    {

        protected com.groupon.util.AbstractRetryAsyncTask.OnRetryListener retryListener;
        final Countries this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public List call()
            throws Exception
        {
            return countriesService.getCountriesSyncTask();
        }

        protected void onFinally()
        {
            super.onFinally();
            retryListener = null;
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((List)obj);
        }

        protected void onSuccess(List list)
            throws Exception
        {
            super.onSuccess(list);
            getListView().setVisibility(0);
            long l = SystemClock.currentThreadTimeMillis();
            countriesList = list;
            Collections.sort(countriesList, new Comparator() {

                final GetCountriesRetryAsyncTask this$1;

                public int compare(Country country1, Country country2)
                {
                    country1 = Strings.toString(
// JavaClassFileOutputException: get_constant: invalid tag

                public volatile int compare(Object obj, Object obj1)
                {
                    return compare((Country)obj, (Country)obj1);
                }

            
            {
                this$1 = GetCountriesRetryAsyncTask.this;
                super();
            }
            });
            long l1 = SystemClock.currentThreadTimeMillis();
            Ln.d((new StringBuilder()).append("BENCHMARK-").append(com/groupon/activity/Countries.getName()).toString(), new Object[] {
                "Duration to parse all countries: %d", Long.valueOf(l1 - l)
            });
            list = new CountriesAdapter();
            setListAdapter(list);
            filterCountries(search.getText());
            search.addTextChangedListener(new TextWatcher() {

                final GetCountriesRetryAsyncTask this$1;

                public void afterTextChanged(Editable editable)
                {
                }

                public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
                {
                }

                public void onTextChanged(CharSequence charsequence, int i, int j, int k)
                {
                    filterCountries(charsequence);
                }

            
            {
                this$1 = GetCountriesRetryAsyncTask.this;
                super();
            }
            });
        }





        public GetCountriesRetryAsyncTask(Activity activity)
        {
            this$0 = Countries.this;
            super(activity);
            retryListener = new RefreshOnRetryAsyncRetryListener();
        }
    }

    private class GetCountriesRetryAsyncTask.CountriesAdapter extends ArrayAdapter
    {

        final GetCountriesRetryAsyncTask this$1;

        public Filter getFilter()
        {
            return new CountryNameFilter(countriesList);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            String s = ((Country)getItem(i)).shortName;
            if (view == null)
            {
                view = inflater.inflate(0x7f030063, viewgroup, false);
            }
            ((TextView)view.findViewById(0x7f100078)).setText(
// JavaClassFileOutputException: get_constant: invalid tag

        public GetCountriesRetryAsyncTask.CountriesAdapter()
        {
            this$1 = GetCountriesRetryAsyncTask.this;
            super(_fld0, 0x1090008, new ArrayList(countriesList));
        }
    }

    class GetCountriesRetryAsyncTask.CountriesAdapter.CountryNameFilter extends Filter
    {

        private List items;
        final GetCountriesRetryAsyncTask.CountriesAdapter this$2;

        protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
        {
            charsequence = charsequence.toString().toLowerCase();
            android.widget.Filter.FilterResults filterresults = new FilterResults();
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
                    String s = ((Country)listiterator.next()).shortName;
                    if (!
// JavaClassFileOutputException: get_constant: invalid tag

        protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
        {
            clear();
            addAll((List)filterresults.values);
            notifyDataSetChanged();
        }

        public GetCountriesRetryAsyncTask.CountriesAdapter.CountryNameFilter(List list)
        {
            this$2 = GetCountriesRetryAsyncTask.CountriesAdapter.this;
            super();
            items = list;
        }
    }

    protected class GetCountriesRetryAsyncTask.RefreshOnRetryAsyncRetryListener
        implements com.groupon.util.AbstractRetryAsyncTask.OnRetryListener
    {

        final GetCountriesRetryAsyncTask this$1;

        public void onRetry()
        {
            refresh();
        }

        protected GetCountriesRetryAsyncTask.RefreshOnRetryAsyncRetryListener()
        {
            this$1 = GetCountriesRetryAsyncTask.this;
            super();
        }
    }


    private static final String CHANGE_COUNTRY_LOGOUT_DIALOG = "change_country_logout_dialog";
    private static final String COUNTRY_SELECTED_KEY = "country_selected_key";
    private List countriesList;
    private CountriesService countriesService;
    private Country country;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    private DeviceInfoUtil deviceInfoUtil;
    private LayoutInflater inflater;
    private IntentFactory intentFactory;
    private LoginService loginService;
    private UserMigrationManager migrationManager;
    TextView noItems;
    private ActionBarClearableEditText search;

    public Countries()
    {
    }

    private void filterCountries(final CharSequence s)
    {
        ((ArrayAdapter)getListView().getAdapter()).getFilter().filter(s, new android.widget.Filter.FilterListener() {

            final Countries this$0;
            final CharSequence val$s;

            public void onFilterComplete(int i)
            {
                TextView textview = noItems;
                if (Strings.notEmpty(s) && i == 0)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                textview.setVisibility(i);
            }

            
            {
                this$0 = Countries.this;
                s = charsequence;
                super();
            }
        });
    }

    private void setCountryAndRestartSplash(Country country1)
    {
        currentCountryManager.setCurrentCountryAndRemoveDivision(country1);
        currentDivisionManager.clearCurrentDivision();
        startActivity(intentFactory.newSplashIntent());
        finish();
    }

    protected void initActionBar(Bundle bundle)
    {
        initActionBar(bundle);
        setToolbarTitle(getString(0x7f080358));
    }

    public void onCreate(Bundle bundle)
    {
        onCreate(bundle);
        setContentView(0x7f03006a);
        refresh();
        if (bundle != null)
        {
            country = (Country)bundle.getSerializable("country_selected_key");
        }
        migrationManager.restoreState(bundle);
        migrationManager.build(this);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        onCreateOptionsMenu(menu);
        search = ActionBarUtil.addSearchMenu(getSupportActionBar(), 0x7f080346);
        return true;
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "change_country_logout_dialog"))
        {
            dialoginterface.dismiss();
        }
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "change_country_logout_dialog"))
        {
            loginService.logout();
            setCountryAndRestartSplash(country);
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        onListItemClick(listview, view, i, l);
        country = (Country)listview.getItemAtPosition(i);
        if (loginService.isLoggedIn())
        {
            listview = new GrouponDialogFragment();
            view = new Bundle();
            view.putInt("dialog_message_res_id", 0x7f0800ad);
            view.putInt("dialog_positive_button_text_res_id", 0x1040013);
            view.putInt("dialog_negative_button_text_res_id", 0x1040009);
            listview.setArguments(view);
            listview.setCancelable(false);
            GrouponDialogFragment.show(getFragmentManager(), listview, "change_country_logout_dialog");
            return;
        } else
        {
            setCountryAndRestartSplash(country);
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        if (country != null)
        {
            bundle.putParcelable("country_selected_key", country);
        }
        migrationManager.saveState(bundle);
        onSaveInstanceState(bundle);
    }

    public void refresh()
    {
        GetCountriesRetryAsyncTask getcountriesretryasynctask = new GetCountriesRetryAsyncTask(this);
        getcountriesretryasynctask.progressView(0x7f1001b3);
        getcountriesretryasynctask.execute();
    }




/*
    static List access$102(Countries countries, List list)
    {
        countries.countriesList = list;
        return list;
    }

*/




}
