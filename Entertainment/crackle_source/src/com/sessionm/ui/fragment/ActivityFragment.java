// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.sessionm.b.a;
import com.sessionm.ui.ProgressViewController;
import com.sessionm.ui.SessionMViewContainer;

// Referenced classes of package com.sessionm.ui.fragment:
//            BaseFragment, FragmentActivityController

public class ActivityFragment extends BaseFragment
{

    public static final String ACTIVITY_TYPE_ARG_KEY = "ACTIVITY_TYPE_ARG_KEY";
    public static final String JSON_DATA_ARG_KEY = "JSON_DATA_ARG_KEY";
    public static final String URL_ARG_KEY = "URL_ARG_KEY";
    private FragmentActivityController activityController;
    private String contentUrl;
    private boolean isFullScreenActivity;
    private String jsonContentData;
    private ProgressViewController loadingIndicator;
    private FrameLayout rootLayout;

    public ActivityFragment()
    {
        setRetainInstance(true);
    }

    private void displayView()
    {
        if (!getState().isViewAvailable())
        {
            return;
        } else
        {
            loadingIndicator.dismiss();
            ViewGroup viewgroup = activityController.getViewContainer().getViewGroup();
            rootLayout.addView(viewgroup);
            activityController.displayView();
            return;
        }
    }

    private void initArguments(Bundle bundle)
    {
        if (bundle == null)
        {
            return;
        } else
        {
            contentUrl = bundle.getString("URL_ARG_KEY");
            jsonContentData = bundle.getString("JSON_DATA_ARG_KEY");
            return;
        }
    }

    private void loadAndDisplayView()
    {
        final FragmentActivityController activityController = getActivityController(getActivity());
        activityController.prepare(new com.sessionm.ui.ActivityController.PrepareListener() {

            final ActivityFragment this$0;
            final FragmentActivityController val$activityController;

            public void onFailure(Throwable throwable)
            {
                activityController.getActivityContext().runOnUiThread(new Runnable() {

                    final _cls3 this$1;

                    public void run()
                    {
                        loadingIndicator.setReloadPropmptState(com.sessionm.ui.ProgressViewController.ReloadPromptState.RELOAD);
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
            }

            public void onPrepared()
            {
                displayView();
            }

            
            {
                this$0 = ActivityFragment.this;
                activityController = fragmentactivitycontroller;
                super();
            }
        });
    }

    public FragmentActivityController getActivityController(Activity activity)
    {
        if (activity == null)
        {
            throw new NullPointerException("Fragment controller is not available for null activity");
        }
        if (activityController == null)
        {
            if (contentUrl != null)
            {
                activityController = new FragmentActivityController(this, activity, contentUrl);
            } else
            if (jsonContentData != null)
            {
                activityController = new FragmentActivityController(this, activity, a.w(jsonContentData).getString("preload_url"));
            } else
            {
                activityController = new FragmentActivityController(this, activity, null);
            }
        }
        return activityController;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        getActivityController(activity).setActivityContext(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initArguments(getArguments());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        if (rootLayout != null)
        {
            if (activityController.getState() == com.sessionm.ui.ActivityController.State.DISMISSED)
            {
                return null;
            }
            layoutinflater = (ViewGroup)rootLayout.getParent();
            if (layoutinflater != null)
            {
                layoutinflater.removeView(rootLayout);
            }
            return rootLayout;
        }
        layoutinflater = getActivityController(getActivity());
        viewgroup = getActivity();
        rootLayout = new FrameLayout(viewgroup);
        rootLayout.setLayoutParams(layoutinflater.getLayoutParams());
        rootLayout.setBackgroundColor(0);
        loadingIndicator = new ProgressViewController(viewgroup, rootLayout, new com.sessionm.ui.ProgressViewController.Listener() {

            final ActivityFragment this$0;

            public void onCancel()
            {
            }

            public void onReloadStarted()
            {
                loadAndDisplayView();
            }

            
            {
                this$0 = ActivityFragment.this;
                super();
            }
        }, true);
        viewgroup = layoutinflater.getState();
        if (viewgroup != com.sessionm.ui.ActivityController.State.PRESENTED) goto _L2; else goto _L1
_L1:
        rootLayout.addView(layoutinflater.getViewContainer().getViewGroup());
_L4:
        return rootLayout;
_L2:
        if (viewgroup == com.sessionm.ui.ActivityController.State.DISMISSED)
        {
            if (isFullScreenActivity)
            {
                loadingIndicator.present(com.sessionm.ui.ProgressViewController.ReloadPromptState.LOADING);
            }
            loadAndDisplayView();
        } else
        if (viewgroup == com.sessionm.ui.ActivityController.State.LOADED_WEBVIEW)
        {
            displayView();
        } else
        if (viewgroup != com.sessionm.ui.ActivityController.State.PRESENTED)
        {
            loadingIndicator.present(com.sessionm.ui.ProgressViewController.ReloadPromptState.LOADING);
            if (viewgroup == com.sessionm.ui.ActivityController.State.UNPRESENTABLE)
            {
                loadingIndicator.setReloadPropmptState(com.sessionm.ui.ProgressViewController.ReloadPromptState.RELOAD);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (activityController == null)
        {
            return;
        } else
        {
            activityController.dismiss();
            activityController = null;
            rootLayout = null;
            loadingIndicator = null;
            return;
        }
    }

    public void onResume()
    {
        super.onResume();
        if (activityController.getState() == com.sessionm.ui.ActivityController.State.DISMISSED)
        {
            activityController.removeView(null);
        }
    }

    public void preloadView(Activity activity)
    {
        getActivityController(activity).prepare(new com.sessionm.ui.ActivityController.PrepareListener() {

            final ActivityFragment this$0;

            public void onFailure(Throwable throwable)
            {
                throwable = getListener();
                if (throwable != null)
                {
                    throwable.onViewPreloadFailed(ActivityFragment.this);
                }
            }

            public void onPrepared()
            {
                BaseFragment.Listener listener = getListener();
                if (listener != null)
                {
                    listener.onViewPreloadSucceeded(ActivityFragment.this);
                }
            }

            
            {
                this$0 = ActivityFragment.this;
                super();
            }
        });
    }

    public void setArguments(Bundle bundle)
    {
        super.setArguments(bundle);
        initArguments(bundle);
    }



}
