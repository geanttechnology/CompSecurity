// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.widget.GridStatus;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.activity.ThisDayActivity;
import com.amazon.gallery.thor.app.service.ThisDayPrefetchService;
import com.amazon.gallery.thor.ftue.DesktopScreen;
import com.amazon.gallery.thor.thisday.ThisDayCollectionViewAdapter;
import com.amazon.gallery.thor.thisday.ThisDayMetricsHelper;
import com.amazon.gallery.thor.thisday.ThisDayRouter;
import com.amazon.gallery.thor.thisday.ThisDaySharedPrefsManager;
import com.amazon.gallery.thor.thisday.ThisDayUtils;
import com.amazon.gallery.thor.thisday.ThisDayViewCollection;
import com.amazon.gallery.thor.thisday.ThisDayViewRouter;
import com.amazon.gallery.thor.thisday.ThisWeekRouter;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ThisDayRandomFragment

public class ThisDayFragment extends Fragment
{

    private static final String TAG = com/amazon/gallery/framework/kindle/fragment/ThisDayFragment.getName();
    private ThisDayCollectionViewAdapter adapter;
    protected int boundingHeight;
    protected int boundingWidth;
    protected int dataType;
    protected AppCompatButton emailButton;
    protected EditText emailInputField;
    private TextView emptyStateMsg;
    private View emptyStateView;
    protected GridStatus gridStatus;
    private android.support.v7.widget.RecyclerView.LayoutManager layoutManager;
    private boolean loadingData;
    private View loadingView;
    private RecyclerView recyclerView;
    private ThisDayViewRouter router;
    private Parcelable savedLayoutMgrState;
    protected TextInputLayout textInputLayout;
    private ThisDayMetricsHelper thisDayMetricsHelper;

    public ThisDayFragment()
    {
        boundingWidth = 0;
        boundingHeight = 0;
    }

    private void checkNetworkAndSendEmail(CharSequence charsequence, AppCompatButton appcompatbutton)
    {
        FragmentActivity fragmentactivity = getActivity();
        if (((NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY)).promptIfOffline(fragmentactivity))
        {
            return;
        } else
        {
            thisDayMetricsHelper.onGetDesktopApp();
            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(appcompatbutton.getWindowToken(), 0);
            ((ThisDayActivity)getActivity()).startEmailOperation(String.valueOf(charsequence));
            return;
        }
    }

    private void initRouter()
    {
        switch (dataType)
        {
        default:
            return;

        case 0: // '\0'
            router = new ThisDayRouter((ThisDayActivity)getActivity());
            return;

        case 1: // '\001'
            router = new ThisWeekRouter((ThisDayActivity)getActivity());
            break;
        }
    }

    public static ThisDayFragment newInstance(int i)
    {
        Object obj;
        Bundle bundle;
        if (i == 2)
        {
            obj = new ThisDayRandomFragment();
        } else
        {
            obj = new ThisDayFragment();
        }
        bundle = new Bundle();
        bundle.putInt("data_type", i);
        ((ThisDayFragment) (obj)).setArguments(bundle);
        return ((ThisDayFragment) (obj));
    }

    private void setupAdapter()
    {
        initBoundingSizeForChildren();
        adapter = new ThisDayCollectionViewAdapter(getActivity(), router);
        adapter.setHasStableIds(true);
        adapter.setBoundingSizeForViews(boundingWidth, boundingHeight);
        adapter.setLoadingStatusTracker(gridStatus);
    }

    private void setupRecyclerView(View view)
    {
        recyclerView = (RecyclerView)view.findViewById(0x7f0c0171);
        layoutManager = new LinearLayoutManager(view.getContext());
        ((LinearLayoutManager)layoutManager).setOrientation(1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void displayData(ThisDayViewCollection thisdayviewcollection)
    {
        if (getView() == null)
        {
            GLogger.e(TAG, "Attempting to display data in a fragment whose views are not created yet", new Object[0]);
        } else
        {
            loadingView.setVisibility(8);
            emptyStateView.setVisibility(8);
            recyclerView.setVisibility(0);
            adapter.setThisDayCollectionData(thisdayviewcollection);
            if (savedLayoutMgrState != null)
            {
                layoutManager.onRestoreInstanceState(savedLayoutMgrState);
                savedLayoutMgrState = null;
            }
            loadingData = false;
            if (thisdayviewcollection.collectionType == 0)
            {
                ThisDayPrefetchService.saveBannerDataOnlyIfNeeded(getActivity().getApplicationContext(), thisdayviewcollection);
                return;
            }
        }
    }

    public void displayEmptyState()
    {
        String s;
        recyclerView.setVisibility(8);
        loadingView.setVisibility(8);
        emptyStateView.setVisibility(0);
        s = "";
        dataType;
        JVM INSTR tableswitch 0 1: default 56
    //                   0 70
    //                   1 95;
           goto _L1 _L2 _L3
_L1:
        emptyStateMsg.setText(s);
        loadingData = false;
        return;
_L2:
        s = getString(0x7f0e0209, new Object[] {
            ThisDayUtils.getDateString(getActivity())
        });
        continue; /* Loop/switch isn't completed */
_L3:
        s = getString(0x7f0e021d, new Object[] {
            ThisDayUtils.getDateString(getActivity())
        });
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void init(Bundle bundle)
    {
        if (bundle != null)
        {
            savedLayoutMgrState = bundle.getParcelable("layoutMgrState");
        }
        initRouter();
        setupAdapter();
    }

    protected void initBoundingSizeForChildren()
    {
        Resources resources = getResources();
        boundingWidth = resources.getDisplayMetrics().widthPixels;
        boundingHeight = Math.round((boundingWidth / resources.getInteger(0x7f0d0001)) * 2);
        boundingHeight = boundingHeight + resources.getDimensionPixelSize(0x7f0a01ca);
    }

    protected void loadData()
    {
        if (loadingData)
        {
            return;
        } else
        {
            loadingData = true;
            ((ThisDayActivity)getActivity()).loadDataForCollection(dataType, false);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getArguments() != null)
        {
            dataType = getArguments().getInt("data_type");
        }
        gridStatus = ((ThisDayActivity)getActivity()).getActivityStatusIndicator();
        thisDayMetricsHelper = new ThisDayMetricsHelper((Profiler)((ThisDayActivity)getActivity()).getApplicationBean(Keys.PROFILER));
        init(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0300e6, viewgroup, false);
    }

    public void onEmailOperationCompleted()
    {
        if (textInputLayout.getVisibility() == 0)
        {
            emailInputField.clearFocus();
            textInputLayout.setVisibility(8);
        }
    }

    public void onResume()
    {
        super.onResume();
        loadData();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (layoutManager != null)
        {
            bundle.putParcelable("layoutMgrState", layoutManager.onSaveInstanceState());
        }
        if (textInputLayout.getVisibility() == 0)
        {
            bundle.putCharSequence("emailInputText", emailInputField.getText());
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        setupViews(view, bundle);
        loadData();
    }

    protected void setupEmailWidgets(final TextInputLayout textInputLayout, final EditText emailInputField, CharSequence charsequence, final AppCompatButton emailButton)
    {
        emailButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ThisDayFragment this$0;
            final AppCompatButton val$emailButton;
            final EditText val$emailInputField;
            final String val$prefetchedEmailAddress;
            final TextInputLayout val$textInputLayout;

            public void onClick(View view)
            {
                if (DesktopScreen.isValidEmail(prefetchedEmailAddress))
                {
                    checkNetworkAndSendEmail(prefetchedEmailAddress, emailButton);
                    return;
                }
                if (textInputLayout.getVisibility() == 0)
                {
                    view = emailInputField.getText();
                    if (!DesktopScreen.isValidEmail(view))
                    {
                        textInputLayout.setError(getString(0x7f0e00b2));
                        return;
                    } else
                    {
                        checkNetworkAndSendEmail(view, emailButton);
                        return;
                    }
                } else
                {
                    emailInputField.setText("");
                    emailInputField.clearFocus();
                    textInputLayout.setVisibility(0);
                    return;
                }
            }

            
            {
                this$0 = ThisDayFragment.this;
                prefetchedEmailAddress = s;
                emailButton = appcompatbutton;
                textInputLayout = textinputlayout;
                emailInputField = edittext;
                super();
            }
        });
        emailInputField.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final ThisDayFragment this$0;
            final AppCompatButton val$emailButton;
            final EditText val$emailInputField;
            final TextInputLayout val$textInputLayout;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                textview = emailInputField.getText();
                if (i == 2 && !DesktopScreen.isValidEmail(textview))
                {
                    textInputLayout.setError(getString(0x7f0e00b2));
                } else
                {
                    checkNetworkAndSendEmail(textview, emailButton);
                }
                return true;
            }

            
            {
                this$0 = ThisDayFragment.this;
                emailInputField = edittext;
                textInputLayout = textinputlayout;
                emailButton = appcompatbutton;
                super();
            }
        });
        if (charsequence != null)
        {
            emailInputField.setText(charsequence);
            textInputLayout.setVisibility(0);
        }
        emailInputField.addTextChangedListener(new TextWatcher() {

            final ThisDayFragment this$0;
            final AppCompatButton val$emailButton;
            final TextInputLayout val$textInputLayout;

            public void afterTextChanged(Editable editable)
            {
                if (textInputLayout.getVisibility() == 0)
                {
                    AppCompatButton appcompatbutton = emailButton;
                    boolean flag;
                    if (!StringUtils.isEmpty(editable))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    appcompatbutton.setEnabled(flag);
                    textInputLayout.setError(null);
                }
            }

            public void beforeTextChanged(CharSequence charsequence1, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence1, int i, int j, int k)
            {
            }

            
            {
                this$0 = ThisDayFragment.this;
                textInputLayout = textinputlayout;
                emailButton = appcompatbutton;
                super();
            }
        });
    }

    protected void setupViews(View view, Bundle bundle)
    {
        setupRecyclerView(view);
        emptyStateView = view.findViewById(0x7f0c01f6);
        emptyStateMsg = (TextView)view.findViewById(0x7f0c01f7);
        loadingView = view.findViewById(0x7f0c01f0);
        emailInputField = (EditText)view.findViewById(0x7f0c01fe);
        emailButton = (AppCompatButton)view.findViewById(0x7f0c0163);
        textInputLayout = (TextInputLayout)view.findViewById(0x7f0c01fd);
        TextInputLayout textinputlayout = textInputLayout;
        EditText edittext = emailInputField;
        if (bundle != null)
        {
            view = bundle.getCharSequence("emailInputText");
        } else
        {
            view = null;
        }
        setupEmailWidgets(textinputlayout, edittext, view, emailButton);
    }


}
