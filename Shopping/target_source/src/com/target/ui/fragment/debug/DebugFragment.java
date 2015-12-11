// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.debug;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.f;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.a.a.e;
import com.pointinside.model.Venue;
import com.pointinside.model.VenueFactory;
import com.pointinside.model.Zone;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.h;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.x;
import com.target.ui.e.j;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.registry.RegistryLandingPageFragment;
import com.target.ui.service.k;
import com.target.ui.util.ai;
import com.target.ui.util.i;
import com.target.ui.vlc.d;
import com.target.ui.vlc.model.a;
import java.util.List;
import java.util.Locale;

public class DebugFragment extends BaseNavigationFragment
{
    static class Views extends com.target.ui.view.a
    {

        TextView deviceSpecs;
        Spinner environmentSpinner;
        Button getSavedForLater;
        Spinner inStoreModeSpinner;
        Button launchRegistry;
        EditText storeIdEditText;
        CheckBox taplyticsSwitch;
        Button vlcButton;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.helper.k.a.a
    {

        private String mStoreId;
        final DebugFragment this$0;

        public void a(Venue venue)
        {
            com.target.ui.fragment.debug.DebugFragment.e(DebugFragment.this, false);
            venue = (Zone)venue.getAllZones().get(0);
            com.target.ui.fragment.debug.DebugFragment.a(DebugFragment.this, mStoreId, venue.getUUID());
        }

        public void p_()
        {
            if (getActivity() == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.debug.DebugFragment.f(DebugFragment.this, false);
                ai.a(getActivity(), "Error loading store.  Wrong id?");
                return;
            }
        }

        public a(String s)
        {
            this$0 = DebugFragment.this;
            super();
            mStoreId = s;
        }
    }


    private static final String TAG = com/target/ui/fragment/debug/DebugFragment.getSimpleName();
    private final android.widget.AdapterView.OnItemSelectedListener mEnvironmentSelectionListener = new android.widget.AdapterView.OnItemSelectedListener() {

        final DebugFragment this$0;

        public void onItemSelected(AdapterView adapterview, View view, int l, long l1)
        {
            if (i.c(getActivity()).ordinal() == l)
            {
                return;
            } else
            {
                com.target.ui.fragment.debug.DebugFragment.a(DebugFragment.this, true);
                com.target.ui.fragment.debug.DebugFragment.a(DebugFragment.this, l);
                com.target.ui.service.a.a().b(com.target.ui.fragment.debug.DebugFragment.a(DebugFragment.this));
                return;
            }
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

            
            {
                this$0 = DebugFragment.this;
                super();
            }
    };
    private final android.widget.AdapterView.OnItemSelectedListener mInStoreModeSelectionListener = new android.widget.AdapterView.OnItemSelectedListener() {

        final DebugFragment this$0;

        public void onItemSelected(AdapterView adapterview, View view, int l, long l1)
        {
            if (i.d(getActivity()).ordinal() == l)
            {
                return;
            } else
            {
                DebugFragment.b(DebugFragment.this, l);
                DebugFragment.b(DebugFragment.this, true);
                a();
                return;
            }
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

            
            {
                this$0 = DebugFragment.this;
                super();
            }
    };
    private final android.view.View.OnClickListener mLaunchRegistryClickListener = new android.view.View.OnClickListener() {

        final DebugFragment this$0;

        public void onClick(View view)
        {
            view = RegistryLandingPageFragment.a(com.target.ui.fragment.debug.DebugFragment.c(DebugFragment.this));
            m().d(view);
        }

            
            {
                this$0 = DebugFragment.this;
                super();
            }
    };
    private final h mLogoutReceiver = new h() {

        final DebugFragment this$0;

        public void a(x x1)
        {
            DebugFragment.this.a(0);
        }

        public volatile void a(Object obj)
        {
            a((Void)obj);
        }

        public void a(Void void1)
        {
            DebugFragment.this.a(0);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

            
            {
                this$0 = DebugFragment.this;
                super();
            }
    };
    private final android.widget.CompoundButton.OnCheckedChangeListener mTaplyticsCheckChangeListener = new android.widget.CompoundButton.OnCheckedChangeListener() {

        final DebugFragment this$0;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            if (i.b(getActivity()) != flag)
            {
                i.a(flag, getActivity());
                com.target.ui.fragment.debug.DebugFragment.d(DebugFragment.this, true);
                a();
            }
        }

            
            {
                this$0 = DebugFragment.this;
                super();
            }
    };
    private com.target.ui.helper.k.a mVenueDataHelper;
    private Views mViews;
    private android.view.View.OnClickListener mVlcButtonClickListener;
    private com.target.ui.e.i mVlcManagerWrapper;

    public DebugFragment()
    {
        mVlcButtonClickListener = new android.view.View.OnClickListener() {

            final DebugFragment this$0;

            public void onClick(View view)
            {
                if (getActivity() == null)
                {
                    return;
                }
                view = DebugFragment.b(DebugFragment.this).storeIdEditText.getText().toString();
                if (view.isEmpty())
                {
                    i.a(view, getActivity());
                    view = com.target.ui.fragment.debug.DebugFragment.c(DebugFragment.this);
                    if (view != null)
                    {
                        view = view.getStoreId().a();
                        com.target.ui.fragment.debug.DebugFragment.d(DebugFragment.this).a(new a(view), view);
                    }
                    ai.a(getActivity(), "debug store id cleared. starting normal vlc");
                    return;
                } else
                {
                    com.target.ui.fragment.debug.DebugFragment.c(DebugFragment.this, true);
                    com.target.ui.fragment.debug.DebugFragment.d(DebugFragment.this).a(new a(view), view);
                    return;
                }
            }

            
            {
                this$0 = DebugFragment.this;
                super();
            }
        };
    }

    static h a(DebugFragment debugfragment)
    {
        return debugfragment.mLogoutReceiver;
    }

    private void a(Spinner spinner)
    {
        spinner.setSelection(i.c(getActivity()).ordinal());
    }

    private void a(TextView textview)
    {
        StringBuilder stringbuilder = new StringBuilder();
        DisplayMetrics displaymetrics = getActivity().getResources().getDisplayMetrics();
        stringbuilder.append(String.format(Locale.US, "Density: %s", new Object[] {
            String.valueOf(displaymetrics.densityDpi)
        }));
        stringbuilder.append("dpi");
        stringbuilder.append('\n');
        stringbuilder.append(String.format(Locale.US, "Pixels: %dw x %dh", new Object[] {
            Integer.valueOf(displaymetrics.widthPixels), Integer.valueOf(displaymetrics.heightPixels)
        }));
        stringbuilder.append('\n');
        stringbuilder.append(String.format(Locale.US, "Android OS: %d", new Object[] {
            Integer.valueOf(android.os.Build.VERSION.SDK_INT)
        }));
        stringbuilder.append('\n');
        textview.setText(stringbuilder.toString());
    }

    static void a(DebugFragment debugfragment, int l)
    {
        debugfragment.b(l);
    }

    static void a(DebugFragment debugfragment, String s, String s1)
    {
        debugfragment.a(s, s1);
    }

    static void a(DebugFragment debugfragment, boolean flag)
    {
        debugfragment.o(flag);
    }

    private void a(String s, String s1)
    {
        i.a(s, getActivity());
        s = new com.target.ui.vlc.model.a(s, s1);
        mVlcManagerWrapper.a(new d(Build.DEVICE, s));
        ai.a(getActivity(), (new StringBuilder()).append("Starting vlc for ").append(s.a()).toString());
    }

    static Views b(DebugFragment debugfragment)
    {
        return debugfragment.mViews;
    }

    private void b(int l)
    {
        if (l < 0 || l >= com.target.ui.util.i.a.values().length)
        {
            return;
        } else
        {
            i.a(com.target.ui.util.i.a.values()[l], getActivity());
            return;
        }
    }

    private void b(Spinner spinner)
    {
        spinner.setSelection(i.d(getActivity()).ordinal());
    }

    static void b(DebugFragment debugfragment, int l)
    {
        debugfragment.c(l);
    }

    static void b(DebugFragment debugfragment, boolean flag)
    {
        debugfragment.o(flag);
    }

    static Store c(DebugFragment debugfragment)
    {
        return debugfragment.h();
    }

    private void c()
    {
        mViews.taplyticsSwitch.setOnCheckedChangeListener(mTaplyticsCheckChangeListener);
        mViews.launchRegistry.setOnClickListener(mLaunchRegistryClickListener);
        mViews.vlcButton.setOnClickListener(mVlcButtonClickListener);
    }

    private void c(int l)
    {
        if (l < 0 || l >= com.target.ui.util.i.b.values().length)
        {
            return;
        } else
        {
            i.a(com.target.ui.util.i.b.values()[l], getActivity());
            return;
        }
    }

    static void c(DebugFragment debugfragment, boolean flag)
    {
        debugfragment.o(flag);
    }

    static com.target.ui.helper.k.a d(DebugFragment debugfragment)
    {
        return debugfragment.mVenueDataHelper;
    }

    private void d()
    {
        mViews.taplyticsSwitch.setOnCheckedChangeListener(null);
        mViews.launchRegistry.setOnClickListener(null);
        mViews.getSavedForLater.setOnClickListener(null);
        mViews.vlcButton.setOnClickListener(null);
    }

    static void d(DebugFragment debugfragment, boolean flag)
    {
        debugfragment.o(flag);
    }

    private ArrayAdapter e()
    {
        int i1 = com.target.ui.util.i.a.values().length;
        String as[] = new String[i1];
        for (int l = 0; l < i1; l++)
        {
            as[l] = com.target.ui.util.i.a.values()[l].prefValue;
        }

        ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x1090008, as);
        arrayadapter.setDropDownViewResource(0x1090009);
        return arrayadapter;
    }

    static void e(DebugFragment debugfragment, boolean flag)
    {
        debugfragment.o(flag);
    }

    private ArrayAdapter f()
    {
        int i1 = com.target.ui.util.i.b.values().length;
        String as[] = new String[i1];
        for (int l = 0; l < i1; l++)
        {
            as[l] = com.target.ui.util.i.b.values()[l].name();
        }

        ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x1090008, as);
        arrayadapter.setDropDownViewResource(0x1090009);
        return arrayadapter;
    }

    static void f(DebugFragment debugfragment, boolean flag)
    {
        debugfragment.o(flag);
    }

    private void g()
    {
        String s = i.a(getActivity());
        mViews.storeIdEditText.setText(s);
    }

    private Store h()
    {
        return (Store)k.a().c().d();
    }

    void a()
    {
        a(0);
    }

    void a(int l)
    {
        ai.b(getActivity(), "App will restart...");
        if (l != 0)
        {
            getView().postDelayed(new Runnable() {

                final DebugFragment this$0;

                public void run()
                {
                    if (getActivity() == null)
                    {
                        return;
                    } else
                    {
                        b();
                        return;
                    }
                }

            
            {
                this$0 = DebugFragment.this;
                super();
            }
            }, l);
            return;
        } else
        {
            b();
            return;
        }
    }

    public boolean a(com.target.ui.e.e e1)
    {
        return true;
    }

    void b()
    {
        PendingIntent pendingintent = PendingIntent.getActivity(getActivity().getBaseContext(), 0, new Intent(getActivity().getIntent()), 0x40000000);
        ((AlarmManager)getActivity().getSystemService("alarm")).set(1, System.currentTimeMillis() + 3000L, pendingintent);
        getView().postDelayed(new Runnable() {

            final DebugFragment this$0;

            public void run()
            {
                Process.killProcess(Process.myPid());
            }

            
            {
                this$0 = DebugFragment.this;
                super();
            }
        }, 2500L);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            mVlcManagerWrapper = ((j)activity).o();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new ClassCastException((new StringBuilder()).append("Activity must implement ").append(com/target/ui/e/j.getSimpleName()).toString());
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            j("Debug");
            b(true);
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03005a, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.environmentSpinner.setAdapter(e());
        mViews.inStoreModeSpinner.setAdapter(f());
        mViews.taplyticsSwitch.setChecked(i.b(getActivity()));
        mVenueDataHelper = new com.target.ui.helper.k.a(new VenueFactory(getActivity()));
        a(mViews.deviceSpecs);
        a(mViews.environmentSpinner);
        b(mViews.inStoreModeSpinner);
        g();
        c();
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        d();
        mViews = null;
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        mViews.environmentSpinner.setOnItemSelectedListener(mEnvironmentSelectionListener);
        mViews.inStoreModeSpinner.setOnItemSelectedListener(mInStoreModeSelectionListener);
    }

}
