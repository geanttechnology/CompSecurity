// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import com.f2prateek.dart.Dart;
import com.groupon.fragment.HotelsSearchResult;
import com.groupon.models.hotel.Destination;
import com.groupon.service.core.AbTestService;
import com.groupon.util.ActionBarUtil;
import com.groupon.util.MarketRateUtil;
import java.util.Date;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class GetawaysSearchResultsActivity extends ActionBarActivity
    implements com.groupon.fragment.HotelsSearchResult.Callback
{
    public static class IntentBuilder
    {

        private Date checkInDate;
        private Date checkOutDate;
        private final Context context;
        private Destination destination;

        public Intent build()
        {
            if (checkInDate == null && checkOutDate != null || checkInDate != null && checkOutDate == null)
            {
                throw new IllegalStateException("checkInDate and checkOutDate may not be null");
            }
            Intent intent = new Intent(context, com/groupon/getaways/search/GetawaysSearchResultsActivity);
            if (destination != null)
            {
                intent.putExtra("destination_id", destination.uuid);
                intent.putExtra("destination_name", destination.name);
            } else
            {
                intent.putExtra("destination_name", context.getString(0x7f080118));
            }
            intent.putExtra("check_in_date", checkInDate);
            intent.putExtra("check_out_date", checkOutDate);
            return intent;
        }

        public IntentBuilder dates(Date date, Date date1)
        {
            checkInDate = date;
            checkOutDate = date1;
            return this;
        }

        public IntentBuilder destination(Destination destination1)
        {
            destination = destination1;
            return this;
        }

        public IntentBuilder(Context context1)
        {
            context = context1;
        }
    }


    public static final int RESULT_DATES_SELECTOR_CLICKED = 1;
    private AbTestService abTestService;
    Date checkInDate;
    Date checkOutDate;
    String destinationId;
    String destinationName;

    public GetawaysSearchResultsActivity()
    {
    }

    private void addCustomActionBar()
    {
        TextView textview = (TextView)ActionBarUtil.setCustomView(getSupportActionBar(), 0x7f03010e).findViewById(0x7f100323);
        boolean flag;
        if (abTestService.isVariantEnabled("hotelsMap1503USCA", "on") || abTestService.isVariantEnabled("hotelsMap1503USCA", "onWithFloatingButton"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            textview.setText(String.format("%s \267 %s", new Object[] {
                destinationName.split(",")[0], MarketRateUtil.getReservationDatesString(this, checkInDate, checkOutDate, false)
            }));
        } else
        {
            textview.setText(destinationName);
        }
        textview.setOnClickListener(new android.view.View.OnClickListener() {

            final GetawaysSearchResultsActivity this$0;

            public void onClick(View view)
            {
                goBackToSearch(-1);
            }

            
            {
                this$0 = GetawaysSearchResultsActivity.this;
                super();
            }
        });
    }

    private void goBackToSearch(int i)
    {
        setResult(i);
        finish();
        overridePendingTransition(0, 0);
    }

    private HotelsSearchResult newHotelsSearchResultInstance()
    {
        HotelsSearchResult hotelssearchresult = new HotelsSearchResult();
        Bundle bundle = new Bundle();
        bundle.putBoolean("search_flow", true);
        bundle.putString("destination_id", destinationId);
        bundle.putLong("check_in_date", checkInDate.getTime());
        bundle.putLong("check_out_date", checkOutDate.getTime());
        hotelssearchresult.setArguments(bundle);
        return hotelssearchresult;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        RoboGuice.getInjector(this).injectMembers(this);
        Dart.inject(this);
        addCustomActionBar();
        if (bundle == null)
        {
            bundle = newHotelsSearchResultInstance();
            getFragmentManager().beginTransaction().add(0x1020002, bundle).commit();
        }
    }

    public void onDatesSelectorClicked()
    {
        goBackToSearch(1);
    }

}
