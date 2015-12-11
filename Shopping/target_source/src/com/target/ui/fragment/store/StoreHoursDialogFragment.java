// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.store;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.target.mothership.model.common.PhoneNumber;
import com.target.mothership.model.common.c;
import com.target.mothership.model.store.interfaces.StoreCapability;
import com.target.mothership.model.store.interfaces.StoreDetail;
import com.target.mothership.model.store.interfaces.StoreOperatingHours;
import com.target.ui.util.ae;
import com.target.ui.view.store.StoreHoursView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package com.target.ui.fragment.store:
//            StoreDetailFragment

public class StoreHoursDialogFragment extends DialogFragment
    implements TraceFieldInterface
{
    private static class a
    {

        public ListView hoursList;
        public TextView title;
        public StoreHoursView todayHours;
        public LinearLayout todayHoursContainer;

        public a(View view)
        {
            title = (TextView)view.findViewById(0x7f100220);
            todayHoursContainer = (LinearLayout)view.findViewById(0x7f100221);
            todayHours = (StoreHoursView)view.findViewById(0x7f100222);
            hoursList = (ListView)view.findViewById(0x7f100223);
        }
    }


    private static final String KEY_HOURS = "hours";
    private static final String KEY_PHONES = "phones";
    private static final String KEY_TITLE = "title";
    public static final String TAG = com/target/ui/fragment/store/StoreDetailFragment.getSimpleName();
    private ArrayList mHours;
    private ArrayList mPhoneNumbers;
    private String mTitle;
    private a mViews;

    public StoreHoursDialogFragment()
    {
    }

    private View a(final PhoneNumber phoneNumber)
    {
        View view = getActivity().getLayoutInflater().inflate(0x7f0301fc, null);
        ((TextView)view.findViewById(0x7f1005c6)).setText(phoneNumber.a());
        if (phoneNumber.b() != c.Main)
        {
            view.findViewById(0x7f1005c7).setVisibility(8);
            view.findViewById(0x7f1005c8).setVisibility(0);
            ((TextView)view.findViewById(0x7f1005c8)).setText(phoneNumber.b().toString().toUpperCase());
            return view;
        } else
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final StoreHoursDialogFragment this$0;
                final PhoneNumber val$phoneNumber;

                public void onClick(View view1)
                {
                    view1 = new Intent("android.intent.action.DIAL");
                    view1.setData(Uri.parse((new StringBuilder()).append("tel:").append(phoneNumber.a()).toString()));
                    startActivity(view1);
                }

            
            {
                this$0 = StoreHoursDialogFragment.this;
                phoneNumber = phonenumber;
                super();
            }
            });
            return view;
        }
    }

    public static StoreHoursDialogFragment a(StoreCapability storecapability)
    {
        StoreHoursDialogFragment storehoursdialogfragment = new StoreHoursDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", storecapability.a());
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(storecapability.b());
        bundle.putParcelableArrayList("hours", arraylist);
        arraylist = new ArrayList();
        arraylist.addAll(storecapability.c());
        bundle.putParcelableArrayList("phones", arraylist);
        storehoursdialogfragment.setArguments(bundle);
        return storehoursdialogfragment;
    }

    public static StoreHoursDialogFragment a(StoreDetail storedetail)
    {
        StoreHoursDialogFragment storehoursdialogfragment = new StoreHoursDialogFragment();
        Bundle bundle = new Bundle();
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(ae.b(storedetail));
        bundle.putParcelableArrayList("hours", arraylist);
        arraylist = new ArrayList();
        arraylist.addAll(storedetail.c());
        bundle.putParcelableArrayList("phones", arraylist);
        storehoursdialogfragment.setArguments(bundle);
        return storehoursdialogfragment;
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("StoreHoursDialogFragment");
        TraceMachine.enterMethod(_nr_trace, "StoreHoursDialogFragment#onCreate", null);
_L1:
        super.onCreate(bundle);
        mTitle = getArguments().getString("title");
        mHours = getArguments().getParcelableArrayList("hours");
        mPhoneNumbers = getArguments().getParcelableArrayList("phones");
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "StoreHoursDialogFragment#onCreate", null);
          goto _L1
    }

    public Dialog onCreateDialog(final Bundle dialog)
    {
        dialog = getActivity();
        Object obj = getActivity().getLayoutInflater();
        View view = ((LayoutInflater) (obj)).inflate(0x7f030089, null);
        mViews = new a(view);
        if (mTitle != null)
        {
            mViews.title.setText(mTitle);
        }
        String s = (new SimpleDateFormat("EEEE", Locale.US)).format(new Date());
        Iterator iterator1 = mHours.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            StoreOperatingHours storeoperatinghours = (StoreOperatingHours)iterator1.next();
            if (storeoperatinghours.a().equals(s))
            {
                mViews.todayHoursContainer.setVisibility(0);
                mViews.todayHours.a();
                mViews.todayHours.setHours(storeoperatinghours);
            }
        } while (true);
        if (!mPhoneNumbers.isEmpty())
        {
            obj = (LinearLayout)((LayoutInflater) (obj)).inflate(0x7f0301fb, null);
            for (Iterator iterator = mPhoneNumbers.iterator(); iterator.hasNext(); ((LinearLayout) (obj)).addView(a((PhoneNumber)iterator.next()))) { }
            mViews.hoursList.addFooterView(((View) (obj)), null, false);
        }
        mViews.hoursList.setAdapter(new com.target.ui.adapter.i.c(dialog, com.target.ui.util.d.c.a(mHours, getActivity())));
        dialog = (new android.app.AlertDialog.Builder(dialog)).setView(view).show();
        dialog.findViewById(0x7f100224).setOnClickListener(new android.view.View.OnClickListener() {

            final StoreHoursDialogFragment this$0;
            final AlertDialog val$dialog;

            public void onClick(View view1)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = StoreHoursDialogFragment.this;
                dialog = alertdialog;
                super();
            }
        });
        return dialog;
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

}
