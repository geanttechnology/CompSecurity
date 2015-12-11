// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Activity;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.TextView;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CountriesService;
import com.groupon.util.AbstractRetryAsyncTask;
import com.groupon.util.CountryUtil;
import com.groupon.util.DeviceInfoUtil;
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
//            Countries

private class RefreshOnRetryAsyncRetryListener extends AbstractRetryAsyncTask
{
    private class CountriesAdapter extends ArrayAdapter
    {

        final Countries.GetCountriesRetryAsyncTask this$1;

        public Filter getFilter()
        {
            return new CountryNameFilter(Countries.access$100(this$0));
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            String s = ((Country)getItem(i)).shortName;
            if (view == null)
            {
                view = Countries.access$700(this$0).inflate(0x7f030063, viewgroup, false);
            }
            ((TextView)view.findViewById(0x7f100078)).setText(
// JavaClassFileOutputException: get_constant: invalid tag

        public CountriesAdapter()
        {
            this$1 = Countries.GetCountriesRetryAsyncTask.this;
            super(this$0, 0x1090008, new ArrayList(Countries.access$100(this$0)));
        }
    }

    class CountriesAdapter.CountryNameFilter extends Filter
    {

        private List items;
        final CountriesAdapter this$2;

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

        public CountriesAdapter.CountryNameFilter(List list)
        {
            this$2 = CountriesAdapter.this;
            super();
            items = list;
        }
    }

    protected class RefreshOnRetryAsyncRetryListener
        implements com.groupon.util.AbstractRetryAsyncTask.OnRetryListener
    {

        final Countries.GetCountriesRetryAsyncTask this$1;

        public void onRetry()
        {
            refresh();
        }

        protected RefreshOnRetryAsyncRetryListener()
        {
            this$1 = Countries.GetCountriesRetryAsyncTask.this;
            super();
        }
    }


    protected com.groupon.util.r retryListener;
    final Countries this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public List call()
        throws Exception
    {
        return Countries.access$000(Countries.this).getCountriesSyncTask();
    }

    protected void onFinally()
    {
        onFinally();
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
        onSuccess(list);
        getListView().setVisibility(0);
        long l = SystemClock.currentThreadTimeMillis();
        Countries.access$102(Countries.this, list);
        Collections.sort(Countries.access$100(Countries.this), new Comparator() {

            final Countries.GetCountriesRetryAsyncTask this$1;

            public int compare(Country country, Country country1)
            {
                country = Strings.toString(
// JavaClassFileOutputException: get_constant: invalid tag

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((Country)obj, (Country)obj1);
            }

            
            {
                this$1 = Countries.GetCountriesRetryAsyncTask.this;
                super();
            }
        });
        long l1 = SystemClock.currentThreadTimeMillis();
        Ln.d((new StringBuilder()).append("BENCHMARK-").append(com/groupon/activity/Countries.getName()).toString(), new Object[] {
            "Duration to parse all countries: %d", Long.valueOf(l1 - l)
        });
        list = new CountriesAdapter();
        setListAdapter(list);
        Countries.access$600(Countries.this, Countries.access$500(Countries.this).getText());
        Countries.access$500(Countries.this).addTextChangedListener(new TextWatcher() {

            final Countries.GetCountriesRetryAsyncTask this$1;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                Countries.access$600(this$0, charsequence);
            }

            
            {
                this$1 = Countries.GetCountriesRetryAsyncTask.this;
                super();
            }
        });
    }





    public _cls2.this._cls1(Activity activity)
    {
        this$0 = Countries.this;
        super(activity);
        retryListener = new RefreshOnRetryAsyncRetryListener();
    }
}
