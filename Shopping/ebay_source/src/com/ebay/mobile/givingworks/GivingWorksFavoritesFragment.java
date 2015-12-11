// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.givingworks;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ebay.android.widget.ContainerLayout;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.givingworks.NonProfitDataManager;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.BaseDmDialogFragment;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.givingworks:
//            GivingWorksCharityFragment, GivingWorksSearchFragment

public class GivingWorksFavoritesFragment extends BaseDmDialogFragment
    implements TextWatcher, android.view.View.OnClickListener, DialogFragmentCallback, com.ebay.common.net.api.givingworks.NonProfitDataManager.Observer, GivingWorksSearchFragment.NonProfitSelectionListener
{
    private class ErrorHandler
        implements android.view.View.OnClickListener
    {

        private final View buttonOk;
        private final View buttonRetry;
        private final View layout;
        final GivingWorksFavoritesFragment this$0;
        private final TextView viewMessage;

        public void onClick(View view)
        {
            layout.setVisibility(8);
            buttonRetry.setOnClickListener(null);
            buttonOk.setOnClickListener(null);
            switch (view.getId())
            {
            default:
                return;

            case 2131755327: 
                nonprofitDataManager.forceReloadData();
                return;

            case 2131755328: 
                dismiss();
                break;
            }
        }

        public void showError(com.ebay.nautilus.kernel.content.ResultStatus.Message message, boolean flag)
        {
            byte byte0 = 8;
            layout.setVisibility(0);
            viewMessage.setText(ResultStatus.getSafeLongMessage(((BaseActivity)getActivity()).getEbayContext(), message));
            message = buttonRetry;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            message.setVisibility(i);
            message = buttonOk;
            if (flag)
            {
                i = byte0;
            } else
            {
                i = 0;
            }
            message.setVisibility(i);
        }

        public ErrorHandler(View view)
        {
            this$0 = GivingWorksFavoritesFragment.this;
            super();
            layout = view;
            viewMessage = (TextView)view.findViewById(0x7f10013d);
            buttonRetry = view.findViewById(0x7f10013f);
            buttonOk = view.findViewById(0x7f100140);
            buttonRetry.setOnClickListener(this);
            buttonOk.setOnClickListener(this);
        }
    }


    public static final String CHARITY_SELECTED_ID = "charity_selected_id";
    public static final String CHARITY_SELECTION_ENABLED = "charity_selection_enabled";
    public static final String CHARITY_SELECTION_LABEL = "charity_selection_label";
    private static final int DIALOG_SEARCH_LENGTH_WARNING = 0;
    private static final String GIVING_WORKS_CHARITY = "giving_works_charity";
    protected static final String GIVING_WORKS_SEARCH = "giving_works_search";
    private static final String STATE_IS_EDIT_PROGRESS = "is_edit_in_progress";
    private static final String STATE_IS_HELP_VISIBLE = "is_help_visible";
    private static final String STATE_IS_SEARCH_VISIBLE = "is_search_visible";
    private static final String STATE_IS_SELECTION_ENABLED = "is_selection_enabled";
    private View cancelEdit;
    private ContainerLayout charityList;
    private TextView charityListLabel;
    private View chevronDown;
    private View chevronUp;
    private View edit;
    private View errorLayout;
    private List favorites;
    private View helpView;
    private ImageCache imageCache;
    private boolean isEditInProgress;
    private boolean isSearchVisible;
    protected boolean isSelectionEnabled;
    private View learnMoreView;
    private View mainContainerLayout;
    protected NonProfitDataManager nonprofitDataManager;
    private View progress;
    protected ScrollView scrollContainer;
    private View searchContainer;
    protected EditText searchText;
    private String selectedCharity;
    private boolean startWithHelpOpen;

    public GivingWorksFavoritesFragment()
    {
        favorites = new ArrayList();
    }

    private final boolean hideSearchFragment()
    {
        if (getChildFragmentManager().findFragmentByTag("giving_works_search") != null)
        {
            hideSearch();
            return true;
        } else
        {
            return false;
        }
    }

    private void notifyNonProfitSelection(com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit)
    {
        if (isSelectionEnabled)
        {
            handleSelectionChanged(nonprofit);
            dismiss();
        }
        hideSearch();
    }

    private void renderCharities(ContainerLayout containerlayout, List list)
    {
        containerlayout.removeAllViews();
        for (list = list.iterator(); list.hasNext(); containerlayout.addView(renderCharity((com.ebay.common.model.givingworks.NonprofitData.Nonprofit)list.next(), charityList))) { }
    }

    private View renderCharity(com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit, ViewGroup viewgroup)
    {
        byte byte0 = 8;
        viewgroup = getActivity().getLayoutInflater().inflate(0x7f0300b6, viewgroup, false);
        ImageView imageview = (ImageView)viewgroup.findViewById(0x7f1001d5);
        TextView textview = (TextView)viewgroup.findViewById(0x7f1001d7);
        ProgressBar progressbar = (ProgressBar)viewgroup.findViewById(0x7f1001d6);
        View view = viewgroup.findViewById(0x7f1001d8);
        View view1 = viewgroup.findViewById(0x7f1001d3);
        RadioButton radiobutton = (RadioButton)viewgroup.findViewById(0x7f1001d4);
        viewgroup.findViewById(0x7f1001d9).setVisibility(8);
        viewgroup.setTag(nonprofit);
        viewgroup.setOnClickListener(this);
        imageCache.setImage(imageview, nonprofit.getLogoUrl(), progressbar);
        textview.setText(nonprofit.name);
        radiobutton.setTag(nonprofit);
        radiobutton.setOnClickListener(this);
        view1.setTag(nonprofit);
        view1.setOnClickListener(this);
        if (!isSelectionEnabled)
        {
            radiobutton.setVisibility(8);
            int i;
            if (isEditInProgress)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view1.setVisibility(i);
            if (isEditInProgress)
            {
                i = byte0;
            } else
            {
                i = 0;
            }
            view.setVisibility(i);
            return viewgroup;
        } else
        {
            radiobutton.setVisibility(0);
            radiobutton.setChecked(nonprofit.nonprofitId.equals(selectedCharity));
            view1.setVisibility(8);
            view.setVisibility(8);
            return viewgroup;
        }
    }

    private void showCharityInfo(com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("charity_nonprofit", nonprofit);
        nonprofit = new GivingWorksCharityFragment();
        nonprofit.setArguments(bundle);
        nonprofit.show(getFragmentManager(), "giving_works_charity");
    }

    private void showEmpty(boolean flag)
    {
        boolean flag1 = false;
        if (flag)
        {
            charityListLabel.setVisibility(8);
            charityList.setVisibility(8);
            learnMoreView.setVisibility(8);
            helpView.setVisibility(0);
            edit.setVisibility(8);
            cancelEdit.setVisibility(8);
            return;
        }
        charityListLabel.setVisibility(0);
        charityList.setVisibility(0);
        View view = edit;
        int i;
        if (!isSelectionEnabled && !isEditInProgress)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view = cancelEdit;
        if (!isSelectionEnabled && isEditInProgress)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        learnMoreView.setVisibility(0);
        view = helpView;
        if (chevronUp.getVisibility() == 0)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    private void showError(ResultStatus resultstatus)
    {
        mainContainerLayout.setVisibility(8);
        progress.setVisibility(8);
        com.ebay.nautilus.kernel.content.ResultStatus.Message message = resultstatus.getFirstError();
        if (errorLayout.getVisibility() != 0)
        {
            (new ErrorHandler(errorLayout)).showError(message, resultstatus.canRetry());
        }
    }

    private void showInformation(boolean flag)
    {
        if (flag)
        {
            chevronUp.setVisibility(0);
            chevronDown.setVisibility(8);
            helpView.setVisibility(0);
            scrollContainer.postDelayed(new Runnable() {

                final GivingWorksFavoritesFragment this$0;

                public void run()
                {
                    scrollContainer.fullScroll(130);
                }

            
            {
                this$0 = GivingWorksFavoritesFragment.this;
                super();
            }
            }, 200L);
            return;
        } else
        {
            chevronUp.setVisibility(8);
            chevronDown.setVisibility(0);
            helpView.setVisibility(8);
            return;
        }
    }

    private void updateCharities(ContainerLayout containerlayout, List list)
    {
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist = new ArrayList();
        HashSet hashset1 = new HashSet(list.size());
        for (Iterator iterator = list.iterator(); iterator.hasNext(); hashset1.add(((com.ebay.common.model.givingworks.NonprofitData.Nonprofit)iterator.next()).externalId)) { }
        HashSet hashset = new HashSet(list.size());
        for (int i = 0; i < containerlayout.getChildCount(); i++)
        {
            View view = containerlayout.getChildAt(i);
            com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit1 = (com.ebay.common.model.givingworks.NonprofitData.Nonprofit)view.getTag();
            hashset.add(nonprofit1.externalId);
            if (!hashset1.contains(nonprofit1.externalId))
            {
                arraylist1.add(view);
            }
        }

        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit = (com.ebay.common.model.givingworks.NonprofitData.Nonprofit)list.next();
            if (!hashset.contains(nonprofit.externalId))
            {
                arraylist.add(renderCharity(nonprofit, charityList));
            }
        } while (true);
        for (list = arraylist1.iterator(); list.hasNext(); containerlayout.removeView((View)list.next())) { }
        for (list = arraylist.iterator(); list.hasNext(); containerlayout.addView((View)list.next())) { }
    }

    private void updateEditFavorites(boolean flag)
    {
        isEditInProgress = flag;
        View view = edit;
        int i;
        if (!isSelectionEnabled && !isEditInProgress)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view = cancelEdit;
        if (!isSelectionEnabled && isEditInProgress)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        i = 0;
        while (i < charityList.getChildCount()) 
        {
            View view1 = charityList.getChildAt(i);
            View view2 = view1.findViewById(0x7f1001d3);
            int j;
            if (isEditInProgress)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            view2.setVisibility(j);
            view2 = view1.findViewById(0x7f1001d8);
            if (isSelectionEnabled || isEditInProgress)
            {
                j = 8;
            } else
            {
                j = 0;
            }
            view2.setVisibility(j);
            view1 = view1.findViewById(0x7f1001d4);
            if (isSelectionEnabled && !isEditInProgress)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            view1.setVisibility(j);
            i++;
        }
    }

    public void afterTextChanged(Editable editable)
    {
        if (TextUtils.isEmpty(editable.toString()))
        {
            MyApp.getPrefs().removeUserPref("searchLastCharityKeywords");
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public String getTrackingEventName()
    {
        return "GivingWorksHome";
    }

    protected void handleSelectionChanged(com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit)
    {
    }

    protected void hideSearch()
    {
        if (getChildFragmentManager().findFragmentByTag("giving_works_search") != null)
        {
            getChildFragmentManager().popBackStack();
            searchContainer.setVisibility(8);
            scrollContainer.scrollTo(0, 0);
            scrollContainer.setVisibility(0);
        }
    }

    protected void invalidate()
    {
        progress.setVisibility(0);
        errorLayout.setVisibility(8);
        mainContainerLayout.setVisibility(8);
        nonprofitDataManager.forceReloadData();
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 8: default 80
    //                   2131755474: 120
    //                   2131755475: 182
    //                   2131755476: 158
    //                   2131755489: 170
    //                   2131755490: 176
    //                   2131755492: 98
    //                   2131755946: 81
    //                   2131755947: 93;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L5:
        break MISSING_BLOCK_LABEL_170;
_L6:
        break MISSING_BLOCK_LABEL_176;
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_182;
_L10:
        return;
_L8:
        if (!hideSearchFragment())
        {
            dismiss();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        dismiss();
        return;
_L7:
        if (chevronUp.getVisibility() == 0)
        {
            showInformation(false);
            return;
        } else
        {
            showInformation(true);
            return;
        }
_L2:
        if (!isEditInProgress)
        {
            if (isSelectionEnabled)
            {
                notifyNonProfitSelection((com.ebay.common.model.givingworks.NonprofitData.Nonprofit)view.getTag());
                return;
            } else
            {
                showCharityInfo((com.ebay.common.model.givingworks.NonprofitData.Nonprofit)view.getTag());
                return;
            }
        }
        if (true) goto _L10; else goto _L4
_L4:
        notifyNonProfitSelection((com.ebay.common.model.givingworks.NonprofitData.Nonprofit)view.getTag());
        return;
        updateEditFavorites(true);
        return;
        updateEditFavorites(false);
        return;
        view = (com.ebay.common.model.givingworks.NonprofitData.Nonprofit)view.getTag();
        nonprofitDataManager.removeNonprofit(view);
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        imageCache = new ImageCache(getActivity());
        setStyle(1, 0x7f0a002b);
        initDataManagers();
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        return new Dialog(getActivity(), getTheme()) {

            final GivingWorksFavoritesFragment this$0;

            public void onBackPressed()
            {
                if (hideSearchFragment())
                {
                    return;
                } else
                {
                    super.onBackPressed();
                    return;
                }
            }

            
            {
                this$0 = GivingWorksFavoritesFragment.this;
                super(context, i);
            }
        };
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        boolean flag = false;
        layoutinflater = layoutinflater.inflate(0x7f0300b7, viewgroup, false);
        searchText = (EditText)layoutinflater.findViewById(0x7f1001dd);
        searchText.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final GivingWorksFavoritesFragment this$0;

            public boolean onEditorAction(TextView textview, int j, KeyEvent keyevent)
            {
                if (keyevent != null && keyevent.getKeyCode() == 66)
                {
                    ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(searchText.getApplicationWindowToken(), 2);
                    startKeywordSearch();
                }
                return false;
            }

            
            {
                this$0 = GivingWorksFavoritesFragment.this;
                super();
            }
        });
        searchText.addTextChangedListener(this);
        mainContainerLayout = layoutinflater.findViewById(0x7f1001dc);
        searchContainer = layoutinflater.findViewById(0x7f1001ee);
        scrollContainer = (ScrollView)layoutinflater.findViewById(0x7f1001de);
        errorLayout = layoutinflater.findViewById(0x7f10013c);
        errorLayout.setVisibility(8);
        errorLayout.setBackgroundColor(-1);
        helpView = layoutinflater.findViewById(0x7f1001e8);
        learnMoreView = layoutinflater.findViewById(0x7f1001e4);
        chevronUp = layoutinflater.findViewById(0x7f1001e7);
        chevronDown = layoutinflater.findViewById(0x7f1001e6);
        progress = layoutinflater.findViewById(0x7f1000c0);
        charityListLabel = (TextView)layoutinflater.findViewById(0x7f1001e0);
        charityList = (ContainerLayout)layoutinflater.findViewById(0x7f1001e3);
        layoutinflater.findViewById(0x7f1001e4).setOnClickListener(this);
        edit = layoutinflater.findViewById(0x7f1001e1);
        edit.setOnClickListener(this);
        cancelEdit = layoutinflater.findViewById(0x7f1001e2);
        cancelEdit.setOnClickListener(this);
        startWithHelpOpen = false;
        int i;
        if (bundle != null)
        {
            if (bundle.getBoolean("is_help_visible"))
            {
                startWithHelpOpen = true;
            }
            isSelectionEnabled = bundle.getBoolean("is_selection_enabled");
            isEditInProgress = bundle.getBoolean("is_edit_in_progress");
            selectedCharity = bundle.getString("charity_selected_id");
            isSearchVisible = bundle.getBoolean("is_search_visible");
        } else
        if (getArguments() != null)
        {
            i = getArguments().getInt("charity_selection_label");
            if (i > -1)
            {
                charityListLabel.setTextSize(0, getActivity().getResources().getDimension(0x7f090155));
                charityListLabel.setText(i);
            }
            isSelectionEnabled = getArguments().getBoolean("charity_selection_enabled");
            selectedCharity = getArguments().getString("charity_selected_id");
        }
        viewgroup = layoutinflater.findViewById(0x7f1003aa);
        bundle = layoutinflater.findViewById(0x7f1003ab);
        ((TextView)layoutinflater.findViewById(0x7f1003a5)).setText(getString(0x7f07022d));
        if (isSelectionEnabled)
        {
            bundle.setVisibility(8);
            viewgroup.setVisibility(0);
            viewgroup.setOnClickListener(this);
        } else
        {
            bundle.setOnClickListener(this);
        }
        viewgroup = edit;
        if (!isSelectionEnabled && !isEditInProgress)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        viewgroup.setVisibility(i);
        viewgroup = cancelEdit;
        if (!isSelectionEnabled && isEditInProgress)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        viewgroup.setVisibility(i);
        viewgroup = scrollContainer;
        if (!isSearchVisible)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        viewgroup.setVisibility(i);
        viewgroup = searchContainer;
        if (isSearchVisible)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        viewgroup.setVisibility(i);
        return layoutinflater;
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        if (j == 1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (i)
        {
        default:
            break; /* Loop/switch isn't completed */

        case 0: // '\0'
            break;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        nonprofitDataManager = (NonProfitDataManager)datamanagercontainer.initialize(NonProfitDataManager.KEY, this);
        nonprofitDataManager.forceReloadData();
    }

    public void onNonProfitSelected(com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit)
    {
        boolean flag1 = false;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < favorites.size())
                {
                    if (!((com.ebay.common.model.givingworks.NonprofitData.Nonprofit)favorites.get(i)).nonprofitId.equals(nonprofit.nonprofitId))
                    {
                        break label0;
                    }
                    flag = true;
                }
                if (!flag)
                {
                    progress.setVisibility(0);
                    mainContainerLayout.setVisibility(8);
                    nonprofitDataManager.addNonprofit(nonprofit);
                }
                notifyNonProfitSelection(nonprofit);
                return;
            }
            i++;
        } while (true);
    }

    public void onNonProfitsChanged(NonProfitDataManager nonprofitdatamanager, Content content)
    {
        if (getActivity() == null || getActivity().isFinishing())
        {
            return;
        }
        nonprofitdatamanager = content.getStatus();
        favorites = (List)content.getData();
        if (nonprofitdatamanager.hasError())
        {
            showError(nonprofitdatamanager);
            return;
        }
        progress.setVisibility(8);
        errorLayout.setVisibility(8);
        mainContainerLayout.setVisibility(0);
        if (favorites == null || favorites.isEmpty())
        {
            showEmpty(true);
            return;
        }
        if (charityList.getChildCount() == 0)
        {
            renderCharities(charityList, favorites);
            if (startWithHelpOpen)
            {
                showInformation(true);
            }
        } else
        {
            updateCharities(charityList, favorites);
        }
        showEmpty(false);
    }

    public void onPause()
    {
        super.onPause();
        if (!startWithHelpOpen)
        {
            int j = charityList.getChildCount();
            StringBuilder stringbuilder = new StringBuilder();
            for (int i = 0; i < j; i++)
            {
                stringbuilder.append(((com.ebay.common.model.givingworks.NonprofitData.Nonprofit)charityList.getChildAt(i).getTag()).nonprofitId);
                if (i < j - 1)
                {
                    stringbuilder.append(";");
                }
            }

            TrackingData trackingdata = new TrackingData("MyCharities", TrackingType.PAGE_IMPRESSION);
            trackingdata.addKeyValuePair("favchar", Integer.toString(j));
            trackingdata.addKeyValuePair("charityID", stringbuilder.toString());
            trackingdata.send(getActivity());
        }
    }

    public void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(getActivity());
        String s = MyApp.getPrefs().getUserPref("searchLastCharityKeywords", "");
        if (!TextUtils.isEmpty(s))
        {
            searchText.setText(s);
            searchText.setSelection(s.length());
        }
        if (isSearchVisible)
        {
            isSearchVisible = false;
            android.app.Fragment fragment = getChildFragmentManager().findFragmentByTag("giving_works_search");
            if (fragment != null && (fragment instanceof GivingWorksSearchFragment))
            {
                ((GivingWorksSearchFragment)fragment).setNonProfitSelectionListener(this);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        boolean flag1 = true;
        super.onSaveInstanceState(bundle);
        boolean flag;
        if (chevronUp.getVisibility() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.putBoolean("is_help_visible", flag);
        bundle.putBoolean("is_selection_enabled", isSelectionEnabled);
        bundle.putBoolean("is_edit_in_progress", isEditInProgress);
        if (getChildFragmentManager().findFragmentByTag("giving_works_search") != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        bundle.putBoolean("is_search_visible", flag);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    protected void startKeywordSearch()
    {
        Object obj = searchText.getText().toString();
        if (((String) (obj)).length() < 2)
        {
            obj = new com.ebay.app.AlertDialogFragment.Builder();
            ((com.ebay.app.AlertDialogFragment.Builder) (obj)).setTitle(0x7f070146);
            ((com.ebay.app.AlertDialogFragment.Builder) (obj)).setMessage(0x7f070145);
            ((com.ebay.app.AlertDialogFragment.Builder) (obj)).setPositiveButton(getString(0x7f070738));
            ((com.ebay.app.AlertDialogFragment.Builder) (obj)).createFromActivity(0).show(getFragmentManager(), null);
            return;
        } else
        {
            updateEditFavorites(false);
            startSearch(((String) (obj)));
            return;
        }
    }

    protected void startSearch(String s)
    {
        scrollContainer.setVisibility(8);
        searchContainer.setVisibility(0);
        Object obj = getChildFragmentManager().findFragmentByTag("giving_works_search");
        if (obj == null)
        {
            obj = new Bundle();
            ((Bundle) (obj)).putString("charity_search_keywords", s);
            s = new GivingWorksSearchFragment();
            s.setNonProfitSelectionListener(this);
            s.setArguments(((Bundle) (obj)));
            obj = getChildFragmentManager().beginTransaction();
            ((FragmentTransaction) (obj)).addToBackStack("giving_works_search");
            ((FragmentTransaction) (obj)).replace(0x7f1001ee, s, "giving_works_search");
            ((FragmentTransaction) (obj)).commit();
            return;
        } else
        {
            ((GivingWorksSearchFragment)obj).startKeywordSearch(s);
            return;
        }
    }

}
