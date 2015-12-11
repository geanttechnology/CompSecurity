// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.os.ParcelUuid;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.analytics.Analytics;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.notifications.ListingNotificationHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.PMProgressDialog;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.ObjectPickupDropOff;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public abstract class PMFragment extends Fragment
    implements PMNotificationListener, TraceFieldInterface
{
    static final class FRAGMENT_TYPE extends Enum
    {

        private static final FRAGMENT_TYPE $VALUES[];
        public static final FRAGMENT_TYPE DRAWER;
        public static final FRAGMENT_TYPE HAS_DRAWER;
        public static final FRAGMENT_TYPE REGULAR;

        public static FRAGMENT_TYPE valueOf(String s)
        {
            return (FRAGMENT_TYPE)Enum.valueOf(com/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE, s);
        }

        public static FRAGMENT_TYPE[] values()
        {
            return (FRAGMENT_TYPE[])$VALUES.clone();
        }

        static 
        {
            REGULAR = new FRAGMENT_TYPE("REGULAR", 0);
            DRAWER = new FRAGMENT_TYPE("DRAWER", 1);
            HAS_DRAWER = new FRAGMENT_TYPE("HAS_DRAWER", 2);
            $VALUES = (new FRAGMENT_TYPE[] {
                REGULAR, DRAWER, HAS_DRAWER
            });
        }

        private FRAGMENT_TYPE(String s, int i)
        {
            super(s, i);
        }
    }


    List ancestorList;
    boolean bShouldHideActionBar;
    boolean bUpdateOnShow;
    PMProgressDialog dialog;
    android.view.View.OnClickListener drawerButtonListener;
    private Object fragmentData;
    UUID fragmentId;
    protected FRAGMENT_TYPE fragmentType;
    boolean fragmentViewsAlive;
    boolean fragmentVisible;
    List trackingList;
    protected String viewNameForAnalytics;

    public PMFragment()
    {
        fragmentData = null;
        bShouldHideActionBar = false;
        bUpdateOnShow = false;
        fragmentViewsAlive = false;
        fragmentVisible = false;
        drawerButtonListener = new android.view.View.OnClickListener() {

            final PMFragment this$0;

            public void onClick(View view)
            {
                ((PMContainerActivity)getActivity()).toggleDrawer();
            }

            
            {
                this$0 = PMFragment.this;
                super();
            }
        };
    }

    private void createProgressDialogWithMessage(String s, boolean flag)
    {
        boolean flag1 = false;
        if (dialog == null)
        {
            dialog = new PMProgressDialog(getActivity());
        }
        dialog.setAutoHideFlag(false);
        PMProgressDialog pmprogressdialog = dialog;
        if (!flag)
        {
            flag1 = true;
        }
        pmprogressdialog.setCancelable(flag1);
        dialog.setMessage(s);
    }

    private void trackViewForAnalytics()
    {
        Analytics.getInstance().trackView(viewNameForAnalytics);
    }

    private void updateActionbarVisibility()
    {
        ActionBar actionbar = getActivity().getActionBar();
        if (bShouldHideActionBar)
        {
            actionbar.hide();
            return;
        } else
        {
            actionbar.show();
            return;
        }
    }

    public void finishActivity()
    {
        FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null)
        {
            fragmentactivity.finish();
        }
    }

    public void finishActivityWithResult(int i, Intent intent)
    {
        FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null)
        {
            fragmentactivity.setResult(i, intent);
            fragmentactivity.finish();
        }
    }

    public Button getDrawerActionButton(int i)
    {
        View view = getActivity().getActionBar().getCustomView();
        if (view != null)
        {
            return (Button)view.findViewById(i);
        } else
        {
            return null;
        }
    }

    public Object getFragmentDataOfType(Class class1)
    {
        if (fragmentData != null && class1.isAssignableFrom(fragmentData.getClass()))
        {
            return fragmentData;
        } else
        {
            return null;
        }
    }

    public UUID getFragmentId()
    {
        return fragmentId;
    }

    public Button getNextActionButton()
    {
        Object obj = getActivity().getActionBar().getCustomView();
        if (obj != null)
        {
            obj = (Button)((View) (obj)).findViewById(0x7f0c003d);
            ((Button) (obj)).setVisibility(0);
            return ((Button) (obj));
        } else
        {
            return null;
        }
    }

    public PMActivity getParentActivity()
    {
        return (PMActivity)super.getActivity();
    }

    protected String getTrackingLabel()
    {
        return null;
    }

    protected List getTrackingList()
    {
        return trackingList;
    }

    public String getViewNameForAnalytics()
    {
        return viewNameForAnalytics;
    }

    public boolean handleBack()
    {
        return false;
    }

    public void handleNotification(Intent intent)
    {
    }

    public void handleResponse(Bundle bundle)
    {
    }

    public void hideActionBar(boolean flag)
    {
        bShouldHideActionBar = flag;
    }

    protected void hideActivityDrawer()
    {
        ((PMContainerActivity)getActivity()).hideDrawer();
    }

    public void hideAllActionButtons(boolean flag)
    {
        Object obj;
label0:
        {
            obj = getActivity().getActionBar().getCustomView();
            if (obj != null)
            {
                Object obj1 = (FrameLayout)((View) (obj)).findViewById(0x7f0c0033);
                if (obj1 != null)
                {
                    int j = ((FrameLayout) (obj1)).getChildCount();
                    int i = 0;
                    while (i < j) 
                    {
                        View view = ((FrameLayout) (obj1)).getChildAt(i);
                        if ((view instanceof ImageButton) || (view instanceof Button))
                        {
                            if (flag)
                            {
                                view.setVisibility(4);
                                view.setOnClickListener(null);
                            } else
                            {
                                view.setVisibility(0);
                            }
                        }
                        i++;
                    }
                }
                obj1 = (ImageButton)((View) (obj)).findViewById(0x7f0c0039);
                if (obj1 != null)
                {
                    if (flag)
                    {
                        ((ImageButton) (obj1)).setVisibility(8);
                        ((ImageButton) (obj1)).setOnClickListener(null);
                    } else
                    {
                        ((ImageButton) (obj1)).setVisibility(0);
                    }
                }
                obj1 = (ImageButton)((View) (obj)).findViewById(0x7f0c003c);
                if (obj1 != null)
                {
                    if (flag)
                    {
                        ((ImageButton) (obj1)).setVisibility(8);
                        ((ImageButton) (obj1)).setOnClickListener(null);
                    } else
                    {
                        ((ImageButton) (obj1)).setVisibility(0);
                    }
                }
                showFindPeopleButton(false);
                obj = (TextView)((View) (obj)).findViewById(0x7f0c0036);
                if (obj != null)
                {
                    if (!flag)
                    {
                        break label0;
                    }
                    ((TextView) (obj)).setVisibility(8);
                }
            }
            return;
        }
        ((TextView) (obj)).setVisibility(0);
    }

    public void hideKeyboard()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)getActivity().getSystemService("input_method");
        if (inputmethodmanager.isAcceptingText())
        {
            inputmethodmanager.toggleSoftInput(1, 0);
        }
    }

    public void hideProgressDialog()
    {
        if (dialog != null && dialog.isShowing())
        {
            dialog.dismiss();
        }
    }

    public void logScreenTracking()
    {
        Object obj;
label0:
        {
            obj = (PMContainerActivity)getActivity();
            if (obj != null)
            {
                if (trackingList == null)
                {
                    break label0;
                }
                ((PMContainerActivity) (obj)).setScreenNavigationStack(trackingList);
                Iterator iterator = trackingList.iterator();
                for (obj = new String(); iterator.hasNext(); obj = (new StringBuilder()).append(((String) (obj))).append((String)iterator.next()).append(", ").toString()) { }
                Log.d("BACKSTACK", ((String) (obj)));
            }
            return;
        }
        ((PMContainerActivity) (obj)).setScreenNavigationStack(trackingList);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
    }

    public void onContentChanged()
    {
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("PMFragment");
        TraceMachine.enterMethod(_nr_trace, "PMFragment#onCreate", null);
_L1:
        super.onCreate(bundle);
        NewRelicWrapper.setNewRelicFragmentClassName(getClass());
        pullParametersFromState(bundle);
        fragmentType = FRAGMENT_TYPE.REGULAR;
        NoSuchFieldError nosuchfielderror;
        if (bundle != null)
        {
            ParcelUuid parceluuid = (ParcelUuid)bundle.getParcelable("FRAGMENT_ID");
            if (parceluuid != null)
            {
                fragmentId = parceluuid.getUuid();
            }
            bundle = (ParcelUuid)bundle.getParcelable("TRACKING_LIST");
            if (bundle != null)
            {
                trackingList = (ArrayList)ObjectPickupDropOff.pickupDataObject(bundle.getUuid());
            }
        } else
        {
            fragmentId = UUID.randomUUID();
            trackingList = new ArrayList();
            bundle = getTrackingLabel();
            if (bundle != null)
            {
                trackingList.add(bundle);
            }
            if (ancestorList != null)
            {
                trackingList.addAll(ancestorList);
            }
        }
        TraceMachine.exitMethod();
        return;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "PMFragment#onCreate", null);
          goto _L1
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        TraceMachine.enterMethod(_nr_trace, "PMFragment#onCreateView", null);
_L1:
        updateActionbarVisibility();
        setViewNameForAnalytics();
        TraceMachine.exitMethod();
        return null;
        layoutinflater;
        TraceMachine.enterMethod(null, "PMFragment#onCreateView", null);
          goto _L1
    }

    public void onDestroy()
    {
        super.onDestroy();
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
        if (this instanceof ListingNotificationHandler)
        {
            ListingNotificationManager.getListingNotificationManager().unregisterListingMessageHandler((ListingNotificationHandler)this);
        }
    }

    public void onDestroyView()
    {
        super.onDestroy();
        fragmentViewsAlive = false;
    }

    public void onDetach()
    {
        super.onDetach();
    }

    public void onFragmentResult(Bundle bundle, int i)
    {
    }

    public void onLoadingComplete()
    {
    }

    public void onPMResume()
    {
        if (getUserVisibleHint())
        {
            logScreenTracking();
            setupActionBar();
            if (fragmentType != FRAGMENT_TYPE.DRAWER)
            {
                trackViewForAnalytics();
            }
        }
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (dialog == null)
        {
            dialog = new PMProgressDialog(getActivity());
        }
        fragmentViewsAlive = true;
        onPMResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (fragmentId != null)
        {
            bundle.putParcelable("FRAGMENT_ID", new ParcelUuid(fragmentId));
        }
        if (trackingList != null)
        {
            UUID uuid = ObjectPickupDropOff.getUniqueKey();
            ObjectPickupDropOff.dropOffDataObject(uuid, trackingList);
            bundle.putParcelable("TRACKING_LIST", new ParcelUuid(uuid));
        }
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop()
    {
        ApplicationStateMonitor.getInstance().activityStopped();
        super.onStop();
        if (dialog != null)
        {
            dialog.dismiss();
        }
    }

    protected void pullParametersFromState(Bundle bundle)
    {
    }

    public void replaceTrackingLabel(String s)
    {
        if (trackingList != null)
        {
            trackingList.remove(0);
            trackingList.add(0, s);
        }
    }

    public void setCutomRightImageButton(Drawable drawable, android.view.View.OnClickListener onclicklistener)
    {
        Object obj;
        if (getActivity() != null)
        {
            if ((obj = getActivity().getActionBar()) != null && (obj = ((ActionBar) (obj)).getCustomView()) != null)
            {
                obj = (ImageButton)((View) (obj)).findViewById(0x7f0c003b);
                ((ImageButton) (obj)).setImageDrawable(drawable);
                ((ImageButton) (obj)).setVisibility(0);
                ((ImageButton) (obj)).setOnClickListener(onclicklistener);
                return;
            }
        }
    }

    public PMFragment setDrawerActionButton(Class class1, PMFragment pmfragment, int i, Object obj)
    {
        PMFragment pmfragment1 = null;
        ActionBar actionbar = getActivity().getActionBar();
        View view = actionbar.getCustomView();
        if (view != null)
        {
            view = view.findViewById(i);
            view.setVisibility(0);
            PMContainerActivity pmcontaineractivity = (PMContainerActivity)getActivity();
            pmfragment1 = pmcontaineractivity.setDrawerData(class1, pmfragment, obj);
            pmcontaineractivity.enableDrawer(true);
            view.setOnClickListener(drawerButtonListener);
            actionbar.show();
        }
        return pmfragment1;
    }

    public void setFindPeopleActionButtonListener(android.view.View.OnClickListener onclicklistener)
    {
        Object obj;
        if (getActivity() != null)
        {
            if ((obj = getActivity().getActionBar()) != null && (obj = ((ActionBar) (obj)).getCustomView()) != null)
            {
                ((ImageButton)((View) (obj)).findViewById(0x7f0c003a)).setOnClickListener(onclicklistener);
                return;
            }
        }
    }

    public void setFragmentData(Object obj)
    {
        fragmentData = obj;
    }

    public void setFragmentVisibilityFlag(boolean flag)
    {
        fragmentVisible = flag;
    }

    public void setNavigationList(List list)
    {
        ancestorList = list;
    }

    public Button setNextActionButton(String s, android.view.View.OnClickListener onclicklistener)
    {
        Object obj = getActivity().getActionBar().getCustomView();
        if (obj != null)
        {
            obj = (Button)((View) (obj)).findViewById(0x7f0c003d);
            ((Button) (obj)).setText(s.toUpperCase());
            ((Button) (obj)).setOnClickListener(onclicklistener);
            ((Button) (obj)).setVisibility(0);
            return ((Button) (obj));
        } else
        {
            return null;
        }
    }

    public void setRefreshActionButtonListener(android.view.View.OnClickListener onclicklistener)
    {
        Object obj;
        if (getActivity() != null)
        {
            if ((obj = getActivity().getActionBar()) != null && (obj = ((ActionBar) (obj)).getCustomView()) != null)
            {
                ((ImageButton)((View) (obj)).findViewById(0x7f0c003c)).setOnClickListener(onclicklistener);
                return;
            }
        }
    }

    public void setSearchActionButtonListener(android.view.View.OnClickListener onclicklistener)
    {
        Object obj;
        if (getActivity() != null)
        {
            if ((obj = getActivity().getActionBar()) != null && (obj = ((ActionBar) (obj)).getCustomView()) != null)
            {
                ((ImageButton)((View) (obj)).findViewById(0x7f0c0039)).setOnClickListener(onclicklistener);
                return;
            }
        }
    }

    public void setSubTitle(String s)
    {
        Object obj = getActivity();
        if (obj != null)
        {
            ActionBar actionbar = ((Activity) (obj)).getActionBar();
            Object obj1 = actionbar.getCustomView();
            obj = obj1;
            if (obj1 == null)
            {
                actionbar.setDisplayShowCustomEnabled(true);
                actionbar.setCustomView(((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f030002, null));
                hideActivityDrawer();
                obj = actionbar.getCustomView();
            }
            obj1 = (ImageView)((View) (obj)).findViewById(0x7f0c0034);
            if (obj1 != null)
            {
                ((ImageView) (obj1)).setVisibility(4);
            }
            obj = (TextView)((View) (obj)).findViewById(0x7f0c0036);
            if (obj != null)
            {
                ((TextView) (obj)).setVisibility(0);
                ((TextView) (obj)).setText(s);
            }
        }
    }

    public void setTitle(int i)
    {
        setTitle(getResources().getString(i));
    }

    public void setTitle(String s)
    {
        Object obj = getActivity();
        if (obj != null)
        {
            ActionBar actionbar = ((Activity) (obj)).getActionBar();
            Object obj1 = actionbar.getCustomView();
            obj = obj1;
            if (obj1 == null)
            {
                actionbar.setDisplayShowCustomEnabled(true);
                actionbar.setCustomView(((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f030002, null));
                hideActivityDrawer();
                obj = actionbar.getCustomView();
            }
            obj1 = (ImageView)((View) (obj)).findViewById(0x7f0c0034);
            if (obj1 != null)
            {
                ((ImageView) (obj1)).setVisibility(4);
            }
            obj = (TextView)((View) (obj)).findViewById(0x7f0c0035);
            if (obj != null)
            {
                ((TextView) (obj)).setVisibility(0);
                ((TextView) (obj)).setText(s);
            }
        }
    }

    protected void setTrackingLabel(String s)
    {
        if (trackingList != null)
        {
            trackingList.add(0, s);
        }
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag && fragmentViewsAlive)
        {
            onPMResume();
        }
    }

    public abstract void setViewNameForAnalytics();

    public void setupActionBar()
    {
        if (fragmentType != FRAGMENT_TYPE.DRAWER)
        {
            setupActionBar(0x7f030002);
        }
    }

    public void setupActionBar(int i)
    {
label0:
        {
            if (fragmentType != FRAGMENT_TYPE.DRAWER)
            {
                ActionBar actionbar = getActivity().getActionBar();
                actionbar.setDisplayShowHomeEnabled(false);
                actionbar.setDisplayShowTitleEnabled(false);
                actionbar.setDisplayUseLogoEnabled(false);
                updateActionbarVisibility();
                actionbar.setDisplayShowCustomEnabled(true);
                View view = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(i, null);
                View view1 = actionbar.getCustomView();
                if (view1 != null && view1.getId() == view.getId())
                {
                    break label0;
                }
                actionbar.setDisplayShowCustomEnabled(true);
                actionbar.setCustomView(view);
                hideActivityDrawer();
            }
            return;
        }
        hideAllActionButtons(true);
        hideActivityDrawer();
    }

    public void showAlertMessage(String s, String s1)
    {
        showAlertMessage(s, s1, null);
    }

    public void showAlertMessage(String s, String s1, android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        AlertDialog alertdialog = (new android.app.AlertDialog.Builder(getActivity())).create();
        alertdialog.setTitle(s);
        alertdialog.setMessage(s1);
        alertdialog.setButton(-1, getResources().getString(0x7f0601e1), (Message)null);
        if (ondismisslistener != null)
        {
            alertdialog.setOnDismissListener(ondismisslistener);
        }
        alertdialog.show();
    }

    public void showAutoHideProgressDialogWithMessage(String s)
    {
        createProgressDialogWithMessage(s, true);
        dialog.setAutoHideFlag(true);
        s = (PMActivity)getActivity();
        if (s != null && s.isActivityInForeground())
        {
            dialog.show();
        }
    }

    public void showAutoHideProgressDialogWithMessage(String s, com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener progressdialogautodismisslistener)
    {
        createProgressDialogWithMessage(s, true);
        dialog.setAutoHideFlag(true);
        dialog.setDismissListener(progressdialogautodismisslistener);
        s = (PMActivity)getActivity();
        if (s != null && s.isActivityInForeground())
        {
            dialog.show();
        }
    }

    public void showAutoHideSuccessMessage(String s)
    {
        createProgressDialogWithMessage(s, true);
        dialog.setAutoHideFlag(true);
        s = (PMActivity)getActivity();
        if (s != null && s.isActivityInForeground())
        {
            dialog.show();
        }
    }

    public void showConfirmationMessage(String s, String s1, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        showConfirmationMessage(s, s1, getString(0x7f0602cd), getString(0x7f0601ce), onclicklistener);
    }

    public void showConfirmationMessage(String s, String s1, String s2, String s3, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle(s);
        builder.setMessage(s1);
        if (s2 != null && s2.length() > 0)
        {
            builder.setPositiveButton(s2, onclicklistener);
        }
        if (s3 != null && s3.length() > 0)
        {
            builder.setNegativeButton(s3, onclicklistener);
        }
        builder.create().show();
    }

    public void showError(ActionErrorContext actionerrorcontext)
    {
        if (actionerrorcontext.severity == com.poshmark.ui.model.ActionErrorContext.Severity.LOW)
        {
            showAutoHideProgressDialogWithMessage(actionerrorcontext.message);
            return;
        } else
        {
            showAlertMessage(null, actionerrorcontext.message);
            return;
        }
    }

    public void showError(ActionErrorContext actionerrorcontext, com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener progressdialogautodismisslistener)
    {
        if (actionerrorcontext.severity == com.poshmark.ui.model.ActionErrorContext.Severity.LOW)
        {
            showAutoHideProgressDialogWithMessage(actionerrorcontext.message, progressdialogautodismisslistener);
            return;
        } else
        {
            showAlertMessage(null, actionerrorcontext.message);
            return;
        }
    }

    public void showFindPeopleButton(boolean flag)
    {
        Object obj;
label0:
        {
            obj = getActivity().getActionBar().getCustomView();
            if (obj != null)
            {
                obj = (ImageButton)((View) (obj)).findViewById(0x7f0c003a);
                if (obj != null)
                {
                    if (!flag)
                    {
                        break label0;
                    }
                    ((ImageButton) (obj)).setVisibility(0);
                }
            }
            return;
        }
        ((ImageButton) (obj)).setVisibility(4);
    }

    public void showKeyboard()
    {
        ((InputMethodManager)getActivity().getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public void showLogoAsTitle()
    {
        View view = getActivity().getActionBar().getCustomView();
        ((TextView)view.findViewById(0x7f0c0035)).setVisibility(4);
        ((ImageView)view.findViewById(0x7f0c0034)).setVisibility(0);
    }

    public void showProgressDialogWithMessage(String s)
    {
        showProgressDialogWithMessage(s, true);
    }

    public void showProgressDialogWithMessage(String s, boolean flag)
    {
        createProgressDialogWithMessage(s, flag);
        s = (PMActivity)getActivity();
        if (s != null && s.isActivityInForeground())
        {
            dialog.show();
        }
    }

    public void showRefreshButton(boolean flag)
    {
        Object obj;
label0:
        {
            obj = getActivity().getActionBar().getCustomView();
            if (obj != null)
            {
                obj = (ImageButton)((View) (obj)).findViewById(0x7f0c003c);
                if (!flag)
                {
                    break label0;
                }
                ((ImageButton) (obj)).setVisibility(0);
            }
            return;
        }
        ((ImageButton) (obj)).setVisibility(4);
    }

    public void showSearchButton(boolean flag)
    {
        Object obj;
label0:
        {
            obj = getActivity().getActionBar().getCustomView();
            if (obj != null)
            {
                obj = (ImageButton)((View) (obj)).findViewById(0x7f0c0039);
                if (!flag)
                {
                    break label0;
                }
                ((ImageButton) (obj)).setVisibility(0);
            }
            return;
        }
        ((ImageButton) (obj)).setVisibility(4);
    }
}
